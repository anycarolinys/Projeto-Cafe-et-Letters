package model.gestaoProdutos;

public class Livro extends Autoria {
    
    public Livro() {

    }
    
    public Livro(
        String codigo, 
        int qtdEmEstoque,
        String nome, 
        double preco, 
        String iSBN, 
        String editora,
        int anoPublicacao, 
        String genero, 
        String autor) {
        super(codigo, qtdEmEstoque, nome, preco, iSBN, editora, anoPublicacao, genero, autor);
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