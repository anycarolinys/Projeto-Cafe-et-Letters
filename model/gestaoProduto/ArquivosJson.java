package model.gestaoProdutos;

import java.io.File;
import java.util.List;

import com.google.gson.JsonObject;

public interface ArquivosJson {

    public void instanciarProdutoJson(File caminhoArquivo);

    public List<Produto> instanciarLivroJson(File caminhoArquivo);

    public Livro parseLivro(JsonObject livro);

    public List<Produto> instanciarHQJson(File caminhoArquivo);

    public HQ parseHQ(JsonObject livro);

    public List<Produto> instanciarBebidaJson(File caminhoArquivo);

    public Bebida parseBebida(JsonObject bebida);

    public List<Produto> instanciarAcompanhamentoJson(File caminhoArquivo);

    public Acompanhamento parseAcompanhamento(JsonObject acompanhamento);

    public void excluirProdutoJson(File caminhoPasta, String codigo, String tipo);

}