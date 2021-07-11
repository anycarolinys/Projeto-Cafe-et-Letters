package model.gestaoVendas;

import model.gestaoClientes.*;
import model.gestaoProdutos.Produto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

            alterarProdutoEstoque(compra.getProduto(), compra.getQuantidadeProduto());
        } else {
            System.out.println("Cliente não cadastrado!");
            System.out.println(compra.getProduto().getNome());
            diretorioCliente = criarDiretorioCliente(diretorioCompras, cliente);
            
            cadastroCompra(diretorioCliente, cliente, compra);
            cliente.setCompras(compra);
            
            alterarProdutoEstoque(compra.getProduto(), compra.getQuantidadeProduto());
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

    public void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeProdutos) {

        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo, arquivosDeProdutos);
            }
        }

        /*
         * File[] arquivo = pasta.listFiles();
         * 
         * for (int i = 0; i < pasta.listFiles().length; i++) { if
         * (!arquivo[i].isDirectory()) { arquivosDeProdutos.add(arquivo[i].getName()); }
         * else { percorrerArquivosEmPasta(arquivo[i], arquivosDeProdutos); } }
         */
    }

    private void alterarProdutoEstoque(Produto produto, int qtdComprada) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");

        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(diretorioProdutos, arquivosProdutos);

        for (String arquivoProduto : arquivosProdutos) {
            try (FileReader acessoArquivo = new FileReader(diretorioProdutos.getPath() + "/" + arquivoProduto);
                    BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

            ) {
                leitorArquivo.readLine();

                if (leitorArquivo.readLine().equals(produto.getCodigo()))
                    diminuirEstoque(diretorioProdutos.getPath() + "/" + arquivoProduto, qtdComprada);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void diminuirEstoque(String caminhoArquivo, int qtdComprada) {

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

    public boolean excluirProduto(File caminhoArquivo) {
        return caminhoArquivo.delete();
    }
}