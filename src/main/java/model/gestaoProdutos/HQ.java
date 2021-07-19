package model.gestaoProdutos;

public class HQ extends Livraria {

    public HQ() {
    }

    public HQ(
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
