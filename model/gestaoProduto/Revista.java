package model.gestaoProduto;

public class Revista extends Livraria{
    private String marca;

    public Revista() {}

    public Revista(String nome, double preco, int qtdEmEstoque, String codigo, String iSBN, String editora, int anoPublicacao, String genero, String marca) {
        super(nome, preco, qtdEmEstoque, codigo, iSBN, editora, anoPublicacao, genero);
        this.marca = marca;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
