package model.gestaoProdutos;

public class Livraria extends Produto {
    private String ISBN;
    private String editora;
    private int anoPublicacao;
    private String genero;
    private String autor;
    
    public Livraria() {}
    
    public Livraria(
        String codigo, 
        int qtdEmEstoque, 
        String nome, 
        double preco, 
        String iSBN, 
        String editora, 
        int anoPublicacao, 
        String genero, 
        String autor) {
        super(codigo, qtdEmEstoque, nome, preco);
        ISBN = iSBN;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        this.ISBN = iSBN;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livraria [ISBN=" + ISBN + ", anoPublicacao=" + anoPublicacao + ", editora=" + editora + ", genero="
                + genero;
    }

}
