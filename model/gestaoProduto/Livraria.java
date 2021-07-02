package model.gestaoProduto;

public class Livraria extends Produto {
    private String ISBN;
    private String editora;
    private int anoPublicacao;
    private String genero;
    private String tipo;
    
    public Livraria() {}
    
    public Livraria(String nome, double preco, int qtdEmEstoque, String codigo, String iSBN, String editora, int anoPublicacao, String genero) {
        super(nome, preco, qtdEmEstoque, codigo);
        ISBN = iSBN;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
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
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
