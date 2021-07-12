package model.gestaoProdutos;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ArquivosJson {
    
    public List<Livro> instanciarLivroJson(String caminhoArquivo) {

        List<Livro> instanciaLivros = new ArrayList<>();
        
        try (
            FileReader leitor = new FileReader(caminhoArquivo);
        ) {
            Object objeto = JsonParser.parseReader(leitor);
            JsonArray listaLivros = (JsonArray) objeto;

            for (JsonElement livros : listaLivros) {
                instanciaLivros.add(parseLivro((JsonObject) livros));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return instanciaLivros;
    }

    public Livro parseLivro(JsonObject livro) {
        Livro objetoLivro = new Livro(
                                        livro.get("codigo").getAsString(),
                                        livro.get("qtdEmEstoque").getAsInt(),
                                        livro.get("nome").getAsString(),
                                        livro.get("preco").getAsDouble(),
                                        livro.get("ISBN").getAsString(),
                                        livro.get("editora").getAsString(),
                                        livro.get("anoPublicacao").getAsInt(),
                                        livro.get("genero").getAsString(),
                                        livro.get("autor").getAsString());

        return objetoLivro;
    }

    public List<HQ> instanciarHQJson(String caminhoArquivo) {

        List<HQ> instanciaLivros = new ArrayList<>();
        
        try (
            FileReader leitor = new FileReader(caminhoArquivo);
        ) {
            Object objeto = JsonParser.parseReader(leitor);
            JsonArray listaLivros = (JsonArray) objeto;

            for (JsonElement livros : listaLivros) {
                instanciaLivros.add(parseHQ((JsonObject) livros));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return instanciaLivros;
    }
    
    public HQ parseHQ(JsonObject livro) {
        HQ objetoHQ = new HQ(
                                        livro.get("codigo").getAsString(),
                                        livro.get("qtdEmEstoque").getAsInt(),
                                        livro.get("nome").getAsString(),
                                        livro.get("preco").getAsDouble(),
                                        livro.get("ISBN").getAsString(),
                                        livro.get("editora").getAsString(),
                                        livro.get("anoPublicacao").getAsInt(),
                                        livro.get("genero").getAsString(),
                                        livro.get("autor").getAsString());

        return objetoHQ;
    }

}