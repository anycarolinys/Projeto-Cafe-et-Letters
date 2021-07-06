package model.gestaoProduto;

public class Livro extends Autoria {
    
    public Livro() {

    }
    
    public Livro(
        String codigo, 
        String nome, 
        double preco, 
        int qtdEmEstoque, 
        String iSBN, 
        String editora,
        int anoPublicacao, 
        String genero, 
        String autor) {
        super(codigo, nome, preco, qtdEmEstoque, iSBN, editora, anoPublicacao, genero, autor);
    }

    @Override
    public String toString() {
        return getCodigo() + "\n" +
                getNome() + "\n" + 
                getPreco() + "\n" + 
                getQtdEmEstoque() + "\n" +
                getISBN() + "\n" + 
                getEditora() + "\n" + 
                getAnoPublicacao() + "\n" +
                getGenero() + "\n" +
                getAutor() + "\n";
    }
    
}