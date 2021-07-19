package model.gestaoProdutos;

public class Livro extends Livraria {
    
    public Livro() {

    }
    
    public Livro(
        String codigo, 
        int qtdEmEstoque,
        String nome, 
        double preco, 
        String ISBN, 
        String editora,
        int anoPublicacao, 
        String genero, 
        String autor) {
        super(codigo, qtdEmEstoque, nome, preco, ISBN, editora, anoPublicacao, genero, autor);
    }

    @Override
    public String toString() {
        return getCodigo() + "\n" +
                getQtdEmEstoque() + "\n" +
                getNome() + "\n" + 
                getPreco() + "\n" + 
                getISBN() + "\n" + 
                getEditora() + "\n" + 
                getAnoPublicacao() + "\n" +
                getGenero() + "\n" +
                getAutor() + "\n";
    }
    
}