package model.gestaoProduto;

public interface Estoque {
    //Produto product;

    public Produto getProduct();

    public void setProduct(Produto product);

    /*
    Métodos a serem implementados*/

    public int cadastrarProdutos();
    public int excluirProduto();
    public void listarProdutosCadastrados();
    public void listarProdutosDisponiveis();
    public void listarProdutosCategorias();
    public void listarProdutosExcuidos();
    public void listarProdutosForaDeEstoque();
}
