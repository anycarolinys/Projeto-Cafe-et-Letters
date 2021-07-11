package model.gestaoProdutos;

public class Revista extends Livraria{
    private String marca;

    public Revista() {
        
    }

    public Revista(
        String codigo,
        int qtdEmEstoque,
        String nome, 
        double preco, 
        String iSBN, 
        String editora,
        int anoPublicacao, 
        String genero, 
        String marca) {
        super(codigo, qtdEmEstoque, nome, preco, iSBN, editora, anoPublicacao, genero);
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
                getQtdEmEstoque() + "\n" +
                getNome() + "\n" + 
                getPreco() + "\n" + 
                getISBN() + "\n" + 
                getEditora() + "\n" + 
                getAnoPublicacao() + "\n" +
                getGenero() + "\n" +
                getMarca() + "\n";
    }

}
