package model.gestaoProdutos;

import java.io.*;
import java.util.List;

public interface ArquivosTexto {

    public Produto buscarProduto(String codigo);

    public void instanciarProdutoTexto(String caminhoArquivo);

    public boolean excluirProdutoTexto(File caminhoDiretorio, String codigo);

    public File procurarTextoProduto(File caminhoDiretorio, String codigo) throws FileNotFoundException;

    public Livro instanciarLivroTexto(String caminhoArquivo);

    public HQ instanciarHQTexto(String caminhoArquivo);

    public Bebida instanciarBebidaTexto(String caminhoArquivo);

    public Acompanhamento instanciarAcompanhamentoTexto(String caminhoArquivo);

    public void instanciarLivroObjeto(Livro livro, boolean pasta);

    public void instanciarHQObjeto(HQ hq, boolean pasta);

    public void instanciarAcompanhamentoObjeto(Acompanhamento acompanhamento, boolean pasta);

    public void instanciarBebidaObjeto(Bebida bebida, boolean pasta);

    public void cadastrarProduto(Produto produto, boolean pasta);

    // Listar os produtos disponíveis no estoque
    public List<String> listarProdutosEstoque();

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