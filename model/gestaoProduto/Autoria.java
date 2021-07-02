package model.gestaoProduto;

public class Autoria extends Livraria {
    private String autor;

    public Autoria() {}
    
    public Autoria(String nome, double preco, int qtdEmEstoque, String codigo, String iSBN, String editora, int anoPublicacao,
            String genero, String autor) {
        super(nome, preco, qtdEmEstoque,codigo, iSBN, editora, anoPublicacao, genero);
        this.autor = autor;
    }
    
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

}
