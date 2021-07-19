package model.gestaoProdutos;

public abstract class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int qtdEmEstoque;

    public Produto() {}

    public Produto(String codigo, int qtdEmEstoque, String nome, double preco) {
        this.codigo = codigo;
        this.qtdEmEstoque = qtdEmEstoque;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEmEstoque() {
        return qtdEmEstoque;
    }

    public void setQtdEmEstoque(int qtdEmEstoque) {
        this.qtdEmEstoque = qtdEmEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", qtdEmEstoque=" + qtdEmEstoque
                + "]";
    }
    
}