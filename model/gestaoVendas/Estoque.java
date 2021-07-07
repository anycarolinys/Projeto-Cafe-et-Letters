package model.gestaoVendas;

import java.util.*;

import control.*;
import model.gestaoProduto.*;
import java.io.*;

public class Estoque implements ArquivosProdutos {

    Set<Produto> produtos;

    public Estoque() {
        this.produtos = new HashSet<>();
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public void inicializarProdutos(String caminhoArquivo) {
        instanciaProduto(caminhoArquivo);
    }

    // O parâmetro pode ser a leitura de um botão
    public void cadastrarProduto(String tipoProduto) {

    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    public void instanciaProduto(String caminhoArquivo) {
        
        Livraria produtoLivraria;
        Alimentos produtoAlimentos;

        try (

            FileReader acessoArquivo = new FileReader(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
            
        ) {
            String conteudo = "";
                // Lendo o tipo de produto a ser instanciado
                conteudo = leitorArquivo.readLine();

                switch (conteudo.toLowerCase()) {
                    case "livro":
                        produtoLivraria = instanciaLivro(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "hq":
                        produtoLivraria = instanciaHQ(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "revista":
                        produtoLivraria = instanciaRevista(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "bebida":
                        produtoAlimentos = instanciaBebida(caminhoArquivo);
                        setProdutos(produtoAlimentos);
                        break;
                    case "acompanhamento":
                        produtoAlimentos = instanciaAcompanhamento(caminhoArquivo);
                        setProdutos(produtoAlimentos);
                        break;
                    default:
                        break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void listarProdutosDisponiveis() {}

    // public void listarProdutosCategorias() {}

    // public void listarProdutosExcuidos() {}

    // public void listarProdutosForaDeEstoque() {}

    // public void excluirProduto() {}
}