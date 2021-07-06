package model.gestaoProduto;

public class Revista extends Livraria{
    private String marca;

    public Revista() {
        
    }

    public Revista(
        String codigo, 
        String nome, 
        double preco, 
        int qtdEmEstoque, 
        String iSBN, 
        String editora,
        int anoPublicacao, 
        String genero, 
        String marca) {
        super(codigo, nome, preco, qtdEmEstoque, iSBN, editora, anoPublicacao, genero);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
                getMarca() + "\n";
    }

}
