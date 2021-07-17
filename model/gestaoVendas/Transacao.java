package model.gestaoVendas;

import model.gestaoClientes.*;
import model.gestaoProdutos.Produto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Transacao {

    public Transacao() {
    }

    private void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeProdutos) {

        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo, arquivosDeProdutos);
            }
        }
    }

    public File criarDiretorioCliente(File diretorioCompra, Cliente cliente) {
        File diretorioCliente = new File(diretorioCompra.getPath() + "/" + cliente.getCPF());
        diretorioCliente.mkdir();
        return diretorioCliente;
    }

    public File buscarDiretorioCliente(File caminhoDiretorioGeral, Cliente cliente) {

        File[] diretoriosClientes = caminhoDiretorioGeral.listFiles();
        File pastaCliente = new File("");

        for (File file : diretoriosClientes) {
            if (file.getName().equals(cliente.getCPF())) {
                pastaCliente = file;
                break;
            }
        }

        return pastaCliente;
    }

    // Ao fim do cadastro de uma compra o estoque deve ser atualizado com a função
    // 'inicializarEstoque()'
    // da classe Estoque
    public boolean cadastrarCompra(Cliente cliente, Compra compra) {

        boolean isCadastrado = cliente.isCadastrado();
        File diretorioCompras = new File("./src/model/gestaoClientes/comprasCadastradas");
        File diretorioCliente;

        // Se a quantidade de produtos que o cliente deseja comprar estiver disponivel
        // no estoque, permitir compra
        if (compra.getProduto().getQtdEmEstoque() >= compra.getQuantidadeProduto()) {
            if (isCadastrado) {
                System.out.println("Cliente cadastrado!");
                // Acessando diretorio de compras do cliente
                diretorioCliente = new File(diretorioCompras.getPath() + "/" + cliente.getCPF());

                // Cadastrando compra no diretorio do Cliente
                cadastroCompra(diretorioCliente, cliente, compra);
                // Adicionando compra no conjunto de compras do Cliente
                cliente.setCompras(compra);

                // Alterando quantidade do produto em arquivo
                if (!alterarArquivoTexto(compra.getProduto(), compra.getQuantidadeProduto())) {
                    alterarArquivoJson(compra.getProduto(), compra.getQuantidadeProduto());
                }
            } else {
                System.out.println("Cliente não cadastrado!");
                // Criando diretorio de compras para o cliente
                diretorioCliente = criarDiretorioCliente(diretorioCompras, cliente);

                // Cadastrando compra no diretorio do cliente
                cadastroCompra(diretorioCliente, cliente, compra);
                // Adicionando compra no conjunto de compras do Cliente
                cliente.setCompras(compra);

                // Alterando quantidade do produto em arquivo
                if (!alterarArquivoTexto(compra.getProduto(), compra.getQuantidadeProduto())) {
                    alterarArquivoJson(compra.getProduto(), compra.getQuantidadeProduto());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private void cadastroCompra(File diretorioCliente, Cliente cliente, Compra compra) {

        String nomeArquivoCompra = Integer.toString(compra.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(
                new File(diretorioCliente.getPath() + "/" + nomeArquivoCompra + ".txt"));
                PrintWriter printer = new PrintWriter(acessoArquivo);) {
            printer.println(compra.getProduto().getNome());

            printer.println(compra.getProduto().getCodigo());

            printer.println(compra.getQuantidadeProduto());

            printer.println(compra.getDataHora());

            printer.println(compra.getValorTotal());

            printer.print(compra.getValorPago());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void tirarProdutoEstoque(Produto produto) {

        String classeProduto = produto.getClass().getSimpleName().toLowerCase();
        String nomeArquivo = Integer.toString(produto.hashCode());
        File arquivoProduto = new File("./src/model/gestaoProdutos/produtosForaEstoque" + "/" + nomeArquivo + ".txt");

        try (FileWriter writer = new FileWriter(arquivoProduto);
                PrintWriter printer = new PrintWriter(writer);) {
            printer.println(classeProduto.toUpperCase());
            printer.println(produto.getCodigo());
            printer.print(produto.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean diminuirEstoque(String caminhoArquivo, int qtdComprada) {

        try {
            Path path = Paths.get(caminhoArquivo);
            List<String> linhas = Files.readAllLines(path);
            int qtdEmEstoque = Integer.parseInt(linhas.get(2));
            qtdEmEstoque -= qtdComprada;
            
            linhas.remove(2);
            linhas.add(2, Integer.toString(qtdEmEstoque));
            Files.write(path, linhas);
            // Se a quantidade no produto em Estoque ficar zerada
            // deve-se mover o arquivo do produto para
            // 'produtosForaEstoque'
            if (qtdEmEstoque == 0) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean alterarArquivoTexto(Produto produto, int qtdComprada) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        boolean alterou = false;
        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(diretorioProdutos, arquivosProdutos);
        File arquivo = null;
        
        for (String nomeArquivo : arquivosProdutos) {
            arquivo = new File(diretorioProdutos.getPath() + "/" + nomeArquivo);
            try ( 
                FileReader acessoArquivo = new FileReader(arquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
            ) {
                leitorArquivo.readLine();
                
                // Se o produto lido possuir o codigo buscado, diminuir estoque do mesmo
                if (leitorArquivo.readLine().equals(produto.getCodigo())) {
                    // Se for retornado 'false' o produto foi zerado no estoque
                    if(!diminuirEstoque(diretorioProdutos.getPath() + "/" + nomeArquivo, qtdComprada)) {
                        // Adicionar produto na pasta 'produtosForaEstoque'
                        tirarProdutoEstoque(produto);
                        break;
                    }
                    alterou = true;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return alterou;
    }


    private JsonArray lerJson(File caminhoArquivo) {
        JsonArray arrayJson = null;

        if (caminhoArquivo.length() > 0) {
            try (FileReader leitor = new FileReader(caminhoArquivo);) {
                Object objeto = JsonParser.parseReader(leitor);
                arrayJson = (JsonArray) objeto;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arrayJson;
    }


    private boolean excluirEmJsonArray(String tipo, JsonArray array, String codigo) {
        JsonObject dados, produtos;

        for (JsonElement produto : array) {
            dados = (JsonObject) produto;
            produtos = (JsonObject) dados.get(tipo);
            if (produtos.get("codigo").getAsString().equals(codigo)) {
                System.out.println(dados.toString());
                array.remove(dados);
                return true;
            }
        }

        return false;
    }

    private boolean temProdutoJson(JsonArray array, String codigo, String tipoProduto) {

        JsonObject dados, produtos;

        for (JsonElement produto : array) {
            dados = (JsonObject) produto;
            produtos = (JsonObject) dados.get(tipoProduto);

            if (produtos.get("codigo").getAsString().equals(codigo))
                return true;
        }
        return false;
    }

    private boolean alterarEstoqueJson(JsonArray array, String codigo, int qtdComprada, String tipoProduto) {

        JsonObject dados, produtos;

        for (JsonElement produto : array) {
            dados = (JsonObject) produto;
            produtos = (JsonObject) dados.get(tipoProduto);

            if (produtos.get("codigo").getAsString().equals(codigo)) {
                int qtdEmEstoque = produtos.get("qtdEmEstoque").getAsInt();
                qtdEmEstoque -= qtdComprada;
                produtos.addProperty("qtdEmEstoque", qtdEmEstoque);
                if (qtdEmEstoque == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void alterarArquivoJson(Produto produto, int qtdComprada) {
        File pastaJson = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosJson");

        List<String> arquivosDeProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(pastaJson, arquivosDeProdutos);

        for (String arquivo : arquivosDeProdutos) {
            File arquivoProduto = new File(pastaJson.getPath() + "/" + arquivo);
            JsonArray array = lerJson(arquivoProduto);

            String tipoProduto = "";
            char[] tipo = arquivo.toCharArray();

            for (int i = 0; tipo[i] != '.' && i < tipo.length; i++) {
                tipoProduto += tipo[i];
            }

            if (temProdutoJson(array, produto.getCodigo(), tipoProduto)) {
                // Se a alteracao retorna falso, o produto foi zerado no estoque
                if (!alterarEstoqueJson(array, produto.getCodigo(), qtdComprada, tipoProduto)) {
                    tirarProdutoEstoque(produto);
                    excluirEmJsonArray(tipoProduto, array, produto.getCodigo());
                }

                try (FileWriter writer = new FileWriter(arquivoProduto);
                        PrintWriter printer = new PrintWriter(writer);) {
                    printer.print(array.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}