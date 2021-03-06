package model.gestaoProdutos;

import java.io.*;
import java.util.List;

public interface ArquivosProdutos {

    /*
     * Inicializa os produtos tanto do formato .txt quanto do formato .json
     */
    public void inicializarEstoque();

    /*
     * Busca um produto por seu codigo e retorna o objeto do mesmo
     */
    public Produto buscarProduto(String codigo);

    /*
     * Recebe objeto de um produto generico, instancia e coloca-o na pasta
     * produtosCadastrados ou produtosExcluidos. Recebe um booleano: true: grava em
     * produtosCadastrados false: grava em produtosExcluidos
     */
    public void cadastrarProduto(Produto produto, boolean pasta);


    // Exclui um produto do estoque identificando
    public void excluirProduto(String codigo);
    
    /*
     * Lista todos os produtos do estoque, isto é, todos os arquivos que estao na
     * pasta produtosCadastrados além de todos os produtos que foram instanciados
     * após a inicialização do programa
     */
    public List<String> listarProdutosEstoque();

    // Lista todos os produtos instanciados após a inicialização do programa
    public List<String> listarProdutosCadastrados();

    /*
     * Lista os produtos excluidos, isto é, aqueles que estão na pasta
     * produtosExcluidos. Nesta pasta existem tanto arquivos .txt como arquivos
     * .json, por isso é feito o tratamento antes de ler os arquivos
     */
    public List<String> listarProdutosExcluidos();

    /*
     * Lista os produtos fora do estoque, isto é, aqueles cuja quantidade de
     * unidades foi zerada e estão guardados na pasta 'produtosForaEstoque'
     */
    public List<String> listarProdutosForaEstoque();

    // Lista todos os produtos da categoria Livro
    public List<String> listarLivros();

    // Lista todos os produtos da categoria HQ
    public List<String> listarHQs();

    // Lista todos os produtos da categoria Bebida
    public List<String> listarBebidas();

    // Lista todos os produtos da categoria Acompanhamento
    public List<String> listarAcompanhamentos();

    /* Adiciona a uma lista o nome dos arquivos contidos em
    * uma pasta, bem como os arquivos de suas subpastas
    */
    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeProdutos) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo, arquivosDeProdutos);
            }
        }
    }
}