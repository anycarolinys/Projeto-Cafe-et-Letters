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

    public void cadastrarCompra(Cliente cliente, Compra compra) {

        boolean isCadastrado = cliente.isCadastrado();
        File diretorioCompras = new File("./src/model/gestaoClientes/comprasCadastradas");
        File diretorioCliente;

        if (isCadastrado) {
            System.out.println("Cliente cadastrado!");
            diretorioCliente = new File(diretorioCompras.getPath() + "/" + cliente.getCPF());

            cadastroCompra(diretorioCliente, cliente, compra);
            cliente.setCompras(compra);

            if (!alterarArquivoTexto(compra.getProduto(), compra.getQuantidadeProduto())) {
                System.out.println("está em Json!");
                alterarArquivoJson(compra.getProduto(), compra.getQuantidadeProduto());
            }

        } else {
            System.out.println("Cliente não cadastrado!");
            // System.out.println(compra.getProduto().getNome());
            diretorioCliente = criarDiretorioCliente(diretorioCompras, cliente);

            cadastroCompra(diretorioCliente, cliente, compra);
            cliente.setCompras(compra);

            if (!alterarArquivoTexto(compra.getProduto(), compra.getQuantidadeProduto())) {
                System.out.println("está em Json!");
                alterarArquivoJson(compra.getProduto(), compra.getQuantidadeProduto());
            }
        }
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

    private void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeProdutos) {

        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo, arquivosDeProdutos);
            }
        }
    }

    private boolean alterarArquivoTexto(Produto produto, int qtdComprada) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");

        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(diretorioProdutos, arquivosProdutos);

        for (String arquivoProduto : arquivosProdutos) {
            try (FileReader acessoArquivo = new FileReader(diretorioProdutos.getPath() + "/" + arquivoProduto);
                    BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

            ) {
                leitorArquivo.readLine();

                if (leitorArquivo.readLine().equals(produto.getCodigo())) {
                    diminuirEstoque(diretorioProdutos.getPath() + "/" + arquivoProduto, qtdComprada);
                    return true;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void diminuirEstoque(String caminhoArquivo, int qtdComprada) {

        try {
            Path path = Paths.get(caminhoArquivo);
            List<String> linhas = Files.readAllLines(path);
            int qtdEmEstoque = Integer.parseInt(linhas.get(2));
            qtdEmEstoque -= qtdComprada;
            linhas.remove(2);
            linhas.add(2, Integer.toString(qtdEmEstoque));
            Files.write(path, linhas);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    private void alterarEstoqueJson(JsonArray array, String codigo, int qtdComprada, String tipoProduto) {

        JsonObject dados, produtos;

        for (JsonElement produto : array) {
            dados = (JsonObject) produto;
            produtos = (JsonObject) dados.get(tipoProduto);

            if (produtos.get("codigo").getAsString().equals(codigo)) {
                System.out.println(produtos.toString());
                int qtdEmEstoque = produtos.get("qtdEmEstoque").getAsInt();
                qtdEmEstoque -= qtdComprada;
                produtos.addProperty("qtdEmEstoque", qtdEmEstoque);
            }
        }
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
                System.out.println("eh um produto " + tipoProduto);
                alterarEstoqueJson(array, produto.getCodigo(), qtdComprada, tipoProduto);

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