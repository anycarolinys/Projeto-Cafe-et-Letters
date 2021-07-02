package model.gestaoVendas;

import java.util.HashSet;
import java.util.Set;

import control.*;
import model.gestaoProduto.*;

public class Estoque implements Arquivos {
    Set<Produto> produtos;

    public Estoque() {
        this.produtos = new HashSet<>();
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    // A String passada pode ser a leitura de botão no Swing
    public void cadastrarProduto(String tipoProduto) {

    }

    public void instanciarProduto(Produto produto) {

    }

    public void excluirProduto() {};
    public void listarProdutosCadastrados() {
    };

    public void listarProdutosDisponiveis() {
    };

    public void listarProdutosCategorias() {
    };

    public void listarProdutosExcuidos() {
    };

    public void listarProdutosForaDeEstoque() {
    };
}
