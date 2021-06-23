package model.gestaoProduto;

public class Livro extends Livraria{
    private String autor;

    public Livro() {
    }

    public Livro(String autor) {
        this.autor = autor;
    }

    public Livro(String nome, double preco, int qtdEmEstoque, String iSBN, String editora, int anoPublicacao,
            String genero, String autor) {
        super(nome, preco, qtdEmEstoque, iSBN, editora, anoPublicacao, genero);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
