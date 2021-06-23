package model.gestaoProduto;

public class Revista extends Livraria{
    private String marca;

    public Revista() {
    }

    public Revista(String marca) {
        this.marca = marca;
    }

    public Revista(String nome, double preco, int qtdEmEstoque, String iSBN, String editora, int anoPublicacao,
            String genero, String marca) {
        super(nome, preco, qtdEmEstoque, iSBN, editora, anoPublicacao, genero);
        this.marca = marca;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
