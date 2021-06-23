package model.gestaoProduto;

public class HQ extends Livraria{
    private String Autor;

    public HQ() {
    }

    public HQ(String autor) {
        Autor = autor;
    }

    public HQ(String nome, double preco, int qtdEmEstoque, String iSBN, String editora, int anoPublicacao,
            String genero) {
        super(nome, preco, qtdEmEstoque, iSBN, editora, anoPublicacao, genero);
    }

 
    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        this.Autor = autor;
    }

}
