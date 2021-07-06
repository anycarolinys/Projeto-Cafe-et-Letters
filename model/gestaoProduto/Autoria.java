package model.gestaoProduto;

public class Autoria extends Livraria {
    private String autor;
    
    public Autoria() {
    }

    public Autoria(String codigo, String nome, double preco, int qtdEmEstoque, String iSBN, String editora,
            int anoPublicacao, String genero, String autor) {
        super(codigo, nome, preco, qtdEmEstoque, iSBN, editora, anoPublicacao, genero);
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Autoria [autor=" + autor + "]";
    }

}
