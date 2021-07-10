package model.gestaoProdutos;

public class Autoria extends Livraria {
    private String autor;
    
    public Autoria() {
    }

    public Autoria(
        String codigo, 
        int qtdEmEstoque, 
        String nome, 
        double preco, 
        String iSBN, 
        String editora,
        int anoPublicacao, 
        String genero, 
        String autor) {
        super(codigo, qtdEmEstoque, nome, preco, iSBN, editora, anoPublicacao, genero);
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
