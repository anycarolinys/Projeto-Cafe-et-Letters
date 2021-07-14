package model.gestaoProdutos;

import java.util.*;

import java.io.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Estoque implements ArquivosTexto, ArquivosJson {

    List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        getProdutos().remove(produto);
    }

    public void listarProdutosCadastrados() {
        for (Produto produto : getProdutos()) {
            System.out.println(produto.toString());
        }
    }

    public Produto buscarProduto(String codigo) {

        for (Produto produto : getProdutos()) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public void inicializarEstoque() {
        getProdutos().clear();

        List<String> arquivosTxt = new ArrayList<>();

        File produtosEmTxt = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        percorrerArquivosEmPasta(produtosEmTxt, arquivosTxt);

        for (String caminhoArquivo : arquivosTxt) {
            instanciarProdutoTexto(produtosEmTxt + "/" + caminhoArquivo);
        }

        List<String> arquivosJson = new ArrayList<>();

        File produtosJson = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosJson");
        percorrerArquivosEmPasta(produtosJson, arquivosJson);

        for (String caminhoArquivo : arquivosJson) {
            instanciarProdutoJson(new File(produtosJson + "/" + caminhoArquivo));
        }
    }

    public void instanciarProdutoTexto(String caminhoArquivo) {

        Livraria produtoLivraria;
        Bebida bebida;
        Acompanhamento acompanhamento;

        try (

                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {
            // Lendo o tipo de produto a ser instanciado
            String conteudo = leitorArquivo.readLine();

            switch (conteudo.toLowerCase()) {
                case "livro":
                    produtoLivraria = instanciarLivroTexto(caminhoArquivo);
                    setProdutos(produtoLivraria);
                    break;
                case "hq":
                    produtoLivraria = instanciarHQTexto(caminhoArquivo);
                    setProdutos(produtoLivraria);
                    break;
                case "bebida":
                    bebida = instanciarBebidaTexto(caminhoArquivo);
                    setProdutos(bebida);
                    break;
                case "acompanhamento":
                    acompanhamento = instanciarAcompanhamentoTexto(caminhoArquivo);
                    setProdutos(acompanhamento);
                    break;
                default:
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File procurarTextoProduto(File caminhoDiretorio, String codigo) throws FileNotFoundException {

        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, arquivosProdutos);

        File arquivo = new File("");

        for (String caminhoArquivo : arquivosProdutos) {
            arquivo = new File(caminhoDiretorio + "\\" + caminhoArquivo);

            try (FileReader leitor = new FileReader(arquivo); BufferedReader buffer = new BufferedReader(leitor);) {
                buffer.readLine();
                if (buffer.readLine().equals(codigo))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return arquivo;
    }

    public Livro instanciarLivroTexto(String caminhoArquivo) {

        Livro livro = new Livro();

        try (

                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            livro = new Livro(leitorArquivo.readLine(), // Codigo
                    Integer.parseInt(leitorArquivo.readLine()), // Quantidade em estoque
                    leitorArquivo.readLine(), // Nome
                    Double.parseDouble(leitorArquivo.readLine()), // Preco
                    leitorArquivo.readLine(), // ISBN
                    leitorArquivo.readLine(), // Editora
                    Integer.parseInt(leitorArquivo.readLine()), // Ano de publicação
                    leitorArquivo.readLine(), // Genero
                    leitorArquivo.readLine()); // Autor

        } catch (IOException e) {
            e.printStackTrace();
        }

        return livro;
    }

    public HQ instanciarHQTexto(String caminhoArquivo) {

        HQ hq = new HQ();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            hq = new HQ(leitorArquivo.readLine(), Integer.parseInt(leitorArquivo.readLine()), leitorArquivo.readLine(),
                    Double.parseDouble(leitorArquivo.readLine()), leitorArquivo.readLine(), leitorArquivo.readLine(),
                    Integer.parseInt(leitorArquivo.readLine()), leitorArquivo.readLine(), leitorArquivo.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hq;
    }

    public Bebida instanciarBebidaTexto(String caminhoArquivo) {

        Bebida bebida = new Bebida();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {
            leitorArquivo.readLine();

            String conteudo = leitorArquivo.readLine();
            bebida.setCodigo(conteudo);

            conteudo = leitorArquivo.readLine();
            bebida.setQtdEmEstoque(Integer.parseInt(conteudo));

            conteudo = leitorArquivo.readLine();
            bebida.setNome(conteudo);

            conteudo = leitorArquivo.readLine();
            bebida.setPreco(Double.parseDouble(conteudo));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bebida;
    }

    public Acompanhamento instanciarAcompanhamentoTexto(String caminhoArquivo) {

        Acompanhamento acompanhamento = new Acompanhamento();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {
            leitorArquivo.readLine();

            String conteudo = leitorArquivo.readLine();
            acompanhamento.setCodigo(conteudo);

            conteudo = leitorArquivo.readLine();
            acompanhamento.setQtdEmEstoque(Integer.parseInt(conteudo));

            conteudo = leitorArquivo.readLine();
            acompanhamento.setNome(conteudo);

            conteudo = leitorArquivo.readLine();
            acompanhamento.setPreco(Double.parseDouble(conteudo));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return acompanhamento;
    }

    public void instanciarLivroObjeto(Livro livro, boolean pasta) {
        File diretorioProdutos;
        if (pasta == true)
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(livro.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(
                new File(diretorioProdutos.getPath() + "/" + caminhoArquivo + ".txt"));
                PrintWriter printer = new PrintWriter(acessoArquivo);) {

            printer.println("LIVRO");
            printer.println(livro.getCodigo());
            printer.println(Integer.toString(livro.getQtdEmEstoque()));
            printer.println(livro.getNome());
            printer.println(Double.toString(livro.getPreco()));
            printer.println(livro.getISBN());
            printer.println(livro.getEditora());
            printer.println(Integer.toString(livro.getAnoPublicacao()));
            printer.println(livro.getGenero());
            printer.print(livro.getAutor());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarHQObjeto(HQ hq, boolean pasta) {
        File diretorioProdutos;

        if (pasta == true)
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(hq.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(
                new File(diretorioProdutos.getPath() + "/" + caminhoArquivo + ".txt"));
                PrintWriter printer = new PrintWriter(acessoArquivo);) {

            printer.println("HQ");
            printer.println(hq.getCodigo());
            printer.println(Integer.toString(hq.getQtdEmEstoque()));
            printer.println(hq.getNome());
            printer.println(Double.toString(hq.getPreco()));
            printer.println(hq.getISBN());
            printer.println(hq.getEditora());
            printer.println(Integer.toString(hq.getAnoPublicacao()));
            printer.println(hq.getGenero());
            printer.print(hq.getAutor());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarAcompanhamentoObjeto(Acompanhamento acompanhamento, boolean pasta) {

        File diretorioProdutos;

        if (pasta == true)
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(acompanhamento.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(
                new File(diretorioProdutos.getPath() + "/" + caminhoArquivo + ".txt"));
                PrintWriter printer = new PrintWriter(acessoArquivo);) {

            printer.println("ACOMPANHAMENTO");
            printer.println(acompanhamento.getCodigo());
            printer.println(Integer.toString(acompanhamento.getQtdEmEstoque()));
            printer.println(acompanhamento.getNome());
            printer.print(Double.toString(acompanhamento.getPreco()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarBebidaObjeto(Bebida bebida, boolean pasta) {

        File diretorioProdutos;

        if (pasta == true)
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(bebida.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(
                new File(diretorioProdutos.getPath() + "/" + caminhoArquivo + ".txt"));
                PrintWriter printer = new PrintWriter(acessoArquivo);) {

            printer.println("BEBIDA");
            printer.println(bebida.getCodigo());
            printer.println(Integer.toString(bebida.getQtdEmEstoque()));
            printer.println(bebida.getNome());
            printer.print(Double.toString(bebida.getPreco()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarProdutoObjeto(Produto produto, boolean pasta) {

        String conteudo = produto.getClass().getSimpleName().toLowerCase();

        switch (conteudo.toLowerCase()) {
            case "livro":
                instanciarLivroObjeto((Livro) produto, pasta);
                setProdutos(produto);
                break;
            case "hq":
                instanciarHQObjeto((HQ) produto, pasta);
                setProdutos(produto);
                break;
            case "bebida":
                instanciarBebidaObjeto((Bebida) produto, pasta);
                setProdutos(produto);
                break;
            case "acompanhamento":
                instanciarAcompanhamentoObjeto((Acompanhamento) produto, pasta);
                setProdutos(produto);
                break;
            default:
                break;
        }
    }

    public List<Produto> instanciarLivroJson(File caminhoArquivo) {

        List<Produto> instanciaLivros = new ArrayList<>();

        if (caminhoArquivo.length() > 0) {
            try (FileReader leitor = new FileReader(caminhoArquivo);) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray arrayJson = (JsonArray) objeto;

                JsonObject dados;

                for (JsonElement livro : arrayJson) {
                    dados = (JsonObject) livro;
                    instanciaLivros.add(parseLivro((JsonObject) dados));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return instanciaLivros;
    }

    public Livro parseLivro(JsonObject livro) {
        JsonObject jsonLivro = (JsonObject) livro.get("livro");

        Livro objetoLivro = new Livro(jsonLivro.get("codigo").getAsString(), jsonLivro.get("qtdEmEstoque").getAsInt(),
                jsonLivro.get("nome").getAsString(), jsonLivro.get("preco").getAsDouble(),
                jsonLivro.get("ISBN").getAsString(), jsonLivro.get("editora").getAsString(),
                jsonLivro.get("anoPublicacao").getAsInt(), jsonLivro.get("genero").getAsString(),
                jsonLivro.get("autor").getAsString());

        return objetoLivro;
    }

    public List<Produto> instanciarHQJson(File caminhoArquivo) {
        List<Produto> instanciaHQs = new ArrayList<>();

        if (caminhoArquivo.length() > 0) {
            try (FileReader leitor = new FileReader(caminhoArquivo);) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray arrayJson = (JsonArray) objeto;

                JsonObject dados;

                for (JsonElement HQ : arrayJson) {
                    dados = (JsonObject) HQ;
                    instanciaHQs.add(parseHQ((JsonObject) dados));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instanciaHQs;
    }

    public HQ parseHQ(JsonObject HQ) {
        JsonObject jsonHQ = (JsonObject) HQ.get("hq");

        HQ objetoHQ = new HQ(jsonHQ.get("codigo").getAsString(), jsonHQ.get("qtdEmEstoque").getAsInt(),
                jsonHQ.get("nome").getAsString(), jsonHQ.get("preco").getAsDouble(), jsonHQ.get("ISBN").getAsString(),
                jsonHQ.get("editora").getAsString(), jsonHQ.get("anoPublicacao").getAsInt(),
                jsonHQ.get("genero").getAsString(), jsonHQ.get("autor").getAsString());

        return objetoHQ;
    }

    public List<Produto> instanciarBebidaJson(File caminhoArquivo) {

        List<Produto> instanciaBebidas = new ArrayList<>();

        if (caminhoArquivo.length() > 0) {
            try (FileReader leitor = new FileReader(caminhoArquivo);) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray arrayJson = (JsonArray) objeto;
                JsonObject dados;

                for (JsonElement bebida : arrayJson) {
                    dados = (JsonObject) bebida;
                    instanciaBebidas.add(parseBebida((JsonObject) dados));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instanciaBebidas;
    }

    public Bebida parseBebida(JsonObject bebida) {

        JsonObject jsonBebida = (JsonObject) bebida.get("bebida");

        Bebida objetoBebida = new Bebida(jsonBebida.get("codigo").getAsString(),
                jsonBebida.get("qtdEmEstoque").getAsInt(), jsonBebida.get("nome").getAsString(),
                jsonBebida.get("preco").getAsDouble());

        return objetoBebida;
    }

    public List<Produto> instanciarAcompanhamentoJson(File caminhoArquivo) {

        List<Produto> instanciaAcompanhamentos = new ArrayList<>();

        if (caminhoArquivo.length() > 0) {
            try (FileReader leitor = new FileReader(caminhoArquivo);) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray arrayJson = (JsonArray) objeto;
                JsonObject dados;

                for (JsonElement acompanhamento : arrayJson) {
                    dados = (JsonObject) acompanhamento;
                    instanciaAcompanhamentos.add(parseAcompanhamento((JsonObject) dados));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instanciaAcompanhamentos;
    }

    public Acompanhamento parseAcompanhamento(JsonObject acompanhamento) {
        JsonObject jsonAcompanhamento = (JsonObject) acompanhamento.get("acompanhamento");

        Acompanhamento objetoAcompanhamento = new Acompanhamento(jsonAcompanhamento.get("codigo").getAsString(),
                jsonAcompanhamento.get("qtdEmEstoque").getAsInt(), jsonAcompanhamento.get("nome").getAsString(),
                jsonAcompanhamento.get("preco").getAsDouble());

        return objetoAcompanhamento;
    }

    public void instanciarProdutoJson(File caminhoArquivo) {

        List<Produto> instancias = new ArrayList<>();

        try (

                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            switch (caminhoArquivo.getName()) {
                case "livros.json":
                    instancias = instanciarLivroJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos(produto);
                    }
                    break;
                case "hqs.json":
                    instancias = instanciarHQJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos(produto);
                    }
                    break;
                case "bebidas.json":
                    instancias = instanciarBebidaJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos(produto);
                    }
                    break;
                case "acompanhamentos.json":
                    instancias = instanciarAcompanhamentoJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos(produto);
                    }
                    break;
                default:
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean excluirArquivoTxt(File caminhoArquivo) {
        if (caminhoArquivo == null)
            return false;
        return caminhoArquivo.delete();
    }

    public boolean excluirProdutoTexto(File caminhoDiretorio, String codigo) {
        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, arquivosProdutos);

        Produto produtoExcluido;
        File arquivoExclusao = null;

        for (String caminhoArquivo : arquivosProdutos) {
            File arquivo = new File(caminhoDiretorio + "/" + caminhoArquivo);

            try (FileReader leitor = new FileReader(arquivo); BufferedReader buffer = new BufferedReader(leitor);) {
                // A primeira linha do arquivo é um identificador pra representar o tipo de
                // produto
                buffer.readLine();

                if (buffer.readLine().equals(codigo)) {
                    // Encontrando Produto pelo código passado
                    produtoExcluido = buscarProduto(codigo);
                    // Copiando produto para a pasta de produtos excluídos
                    instanciarProdutoObjeto(produtoExcluido, false);
                    // Removendo produto da lista de estoque
                    removerProduto(produtoExcluido);
                    // Copiando o arquivo para ser excluido
                    arquivoExclusao = arquivo;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return excluirArquivoTxt(arquivoExclusao);
    }

    private void escreverJsonExcluido(String conteudo) {
        File produtosExcluidos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String nomeArquivo = Integer.toString(conteudo.hashCode());

        try (FileWriter writer = new FileWriter(produtosExcluidos.getPath() + "/" + nomeArquivo + ".json");
                PrintWriter printer = new PrintWriter(writer);) {
            printer.print(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean excluirEmJson(String tipo, JsonArray array, String codigo) {
        JsonObject dados, produtos;

        for (JsonElement produto : array) {
            dados = (JsonObject) produto;
            produtos = (JsonObject) dados.get(tipo);
            if (produtos.get("codigo").getAsString().equals(codigo)) {
                escreverJsonExcluido(produtos.toString());
                array.remove(dados);
                return true;
            }
        }

        return false;
    }

    private JsonArray lerJson(File caminhoArquivo) {
        JsonArray arrayJson = null;

        if (caminhoArquivo.length() > 0) {
            try (FileReader leitor = new FileReader(caminhoArquivo);) {
                Object objeto = JsonParser.parseReader(leitor);
                arrayJson = (JsonArray) objeto;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return arrayJson;
    }

    public void excluirProdutoJson(File caminhoPasta, String codigo, String tipo) {
        JsonArray array = lerJson(new File(caminhoPasta + "/" + tipo + ".json"));
        excluirEmJson(tipo, array, codigo);

        try (FileWriter writer = new FileWriter(caminhoPasta + "/" + tipo + ".json");
                PrintWriter printer = new PrintWriter(writer);) {
            printer.print(array.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}