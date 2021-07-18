package model.gestaoProdutos;

import java.util.*;

import java.io.*;

import com.google.gson.*;

public class Estoque implements ArquivosProdutos {

    List<Produto> produtos;
    List<String> produtosCadastrados;

    public Estoque() {
        this.produtos = new ArrayList<>();
        this.produtosCadastrados = new ArrayList<>();
    }

    private List<Produto> getProdutos() {
        return produtos;
    }

    private void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    private List<String> getProdutosCadastrados() {
        return produtosCadastrados;
    }

    private void setProdutosCadastrados(String nomeProduto) {
        this.produtosCadastrados.add(nomeProduto);
    }

    private void removerProduto(Produto produto) {
        getProdutos().remove(produto);
    }

    public void excluirProduto(String codigo) {
        if (!excluirProdutoTexto(new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt"), codigo)) {
            excluirProdutoJson(new File("./src/model/gestaoProdutos/produtosCadastrados/produtosJson"), codigo);
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

    private void instanciarProdutoTexto(String caminhoArquivo) {

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

    private boolean excluirArquivoTxt(File caminhoArquivo) {
        if (caminhoArquivo == null)
            return false;
        return caminhoArquivo.delete();
    }

    private boolean excluirProdutoTexto(File caminhoDiretorio, String codigo) {
        boolean excluiu = false;
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
                    cadastrarProduto(produtoExcluido, false);
                    // Removendo produto da lista de estoque
                    removerProduto(produtoExcluido);
                    // Copiando o arquivo para ser excluido
                    arquivoExclusao = arquivo;

                    excluiu = true;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        excluirArquivoTxt(arquivoExclusao);
        return excluiu;
    }

    private Livro instanciarLivroTexto(String caminhoArquivo) {

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

    private HQ instanciarHQTexto(String caminhoArquivo) {

        HQ hq = new HQ();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            hq = new HQ(leitorArquivo.readLine(), // Codigo
                    Integer.parseInt(leitorArquivo.readLine()), // Quantidade em estoque
                    leitorArquivo.readLine(), // Nome
                    Double.parseDouble(leitorArquivo.readLine()), // Preco
                    leitorArquivo.readLine(), // ISBN
                    leitorArquivo.readLine(), // Editora
                    Integer.parseInt(leitorArquivo.readLine()), // Ano de publicação
                    leitorArquivo.readLine(), // Genero
                    leitorArquivo.readLine());// Autor

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hq;
    }

    private Bebida instanciarBebidaTexto(String caminhoArquivo) {

        Bebida bebida = new Bebida();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {

            // Primeira linha do arquivo identifica o tipo de produto
            leitorArquivo.readLine();

            bebida = new Bebida(leitorArquivo.readLine(), // Codigo
                    Integer.parseInt(leitorArquivo.readLine()), // Quantidade em estoque
                    leitorArquivo.readLine(), // Nome
                    Double.parseDouble(leitorArquivo.readLine())); // Preco

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bebida;
    }

    private Acompanhamento instanciarAcompanhamentoTexto(String caminhoArquivo) {

        Acompanhamento acompanhamento = new Acompanhamento();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {

            leitorArquivo.readLine();

            acompanhamento = new Acompanhamento(leitorArquivo.readLine(), // Codigo
                    Integer.parseInt(leitorArquivo.readLine()), // Quantidade em estoque
                    leitorArquivo.readLine(), // Nome
                    Double.parseDouble(leitorArquivo.readLine())); // Preco

        } catch (IOException e) {
            e.printStackTrace();
        }

        return acompanhamento;
    }

    public void cadastrarProduto(Produto produto, boolean pasta) {

        String conteudo = produto.getClass().getSimpleName().toLowerCase();

        switch (conteudo.toLowerCase()) {
            case "livro":
                instanciarLivroObjeto((Livro) produto, pasta);
                // Cadastrar o produto no Estoque
                setProdutos(produto);
                // Adicionar produto como cadastrado pelo usuário
                setProdutosCadastrados(produto.getNome());
                break;
            case "hq":
                instanciarHQObjeto((HQ) produto, pasta);
                setProdutos(produto);
                setProdutosCadastrados(produto.getNome());
                break;
            case "bebida":
                instanciarBebidaObjeto((Bebida) produto, pasta);
                setProdutos(produto);
                setProdutosCadastrados(produto.getNome());
                break;
            case "acompanhamento":
                instanciarAcompanhamentoObjeto((Acompanhamento) produto, pasta);
                setProdutos(produto);
                setProdutosCadastrados(produto.getNome());
                break;
            default:
                break;
        }
    }

    private void instanciarLivroObjeto(Livro livro, boolean pasta) {
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

    private void instanciarHQObjeto(HQ hq, boolean pasta) {
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

    private void instanciarBebidaObjeto(Bebida bebida, boolean pasta) {

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

    private void instanciarAcompanhamentoObjeto(Acompanhamento acompanhamento, boolean pasta) {

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

    private void instanciarProdutoJson(File caminhoArquivo) {

        List<Produto> instancias = new ArrayList<>();

        try (

                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            switch (caminhoArquivo.getName()) {
                case "livro.json":
                    instancias = instanciarLivroJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos(produto);
                    }
                    break;
                case "hq.json":
                    instancias = instanciarHQJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos((HQ) produto);
                    }
                    break;
                case "bebida.json":
                    instancias = instanciarBebidaJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos((Bebida) produto);
                    }
                    break;
                case "acompanhamento.json":
                    instancias = instanciarAcompanhamentoJson(caminhoArquivo);
                    for (Produto produto : instancias) {
                        setProdutos((Acompanhamento) produto);
                    }
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Produto> instanciarLivroJson(File caminhoArquivo) {

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

    private Livro parseLivro(JsonObject livro) {
        JsonObject jsonLivro = (JsonObject) livro.get("livro");

        Livro objetoLivro = new Livro(jsonLivro.get("codigo").getAsString(), jsonLivro.get("qtdEmEstoque").getAsInt(),
                jsonLivro.get("nome").getAsString(), jsonLivro.get("preco").getAsDouble(),
                jsonLivro.get("ISBN").getAsString(), jsonLivro.get("editora").getAsString(),
                jsonLivro.get("anoPublicacao").getAsInt(), jsonLivro.get("genero").getAsString(),
                jsonLivro.get("autor").getAsString());

        return objetoLivro;
    }

    private List<Produto> instanciarHQJson(File caminhoArquivo) {
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

    private HQ parseHQ(JsonObject HQ) {
        JsonObject jsonHQ = (JsonObject) HQ.get("hq");

        HQ objetoHQ = new HQ(jsonHQ.get("codigo").getAsString(), jsonHQ.get("qtdEmEstoque").getAsInt(),
                jsonHQ.get("nome").getAsString(), jsonHQ.get("preco").getAsDouble(), jsonHQ.get("ISBN").getAsString(),
                jsonHQ.get("editora").getAsString(), jsonHQ.get("anoPublicacao").getAsInt(),
                jsonHQ.get("genero").getAsString(), jsonHQ.get("autor").getAsString());

        return objetoHQ;
    }

    private List<Produto> instanciarBebidaJson(File caminhoArquivo) {

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

    private Bebida parseBebida(JsonObject bebida) {

        JsonObject jsonBebida = (JsonObject) bebida.get("bebida");

        Bebida objetoBebida = new Bebida(jsonBebida.get("codigo").getAsString(),
                jsonBebida.get("qtdEmEstoque").getAsInt(), jsonBebida.get("nome").getAsString(),
                jsonBebida.get("preco").getAsDouble());

        return objetoBebida;
    }

    private List<Produto> instanciarAcompanhamentoJson(File caminhoArquivo) {

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

    private Acompanhamento parseAcompanhamento(JsonObject acompanhamento) {
        JsonObject jsonAcompanhamento = (JsonObject) acompanhamento.get("acompanhamento");

        Acompanhamento objetoAcompanhamento = new Acompanhamento(jsonAcompanhamento.get("codigo").getAsString(),
                jsonAcompanhamento.get("qtdEmEstoque").getAsInt(), jsonAcompanhamento.get("nome").getAsString(),
                jsonAcompanhamento.get("preco").getAsDouble());

        return objetoAcompanhamento;
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
                // String conteudo = "{\"" + tipo + "\":" + produtos.toString() + "}";
                escreverJsonExcluido(produtos.toString());
                // escreverJsonExcluido(conteudo);
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

    /*
     * private void excluirProdutoJson(File caminhoPasta, String codigo, String
     * tipo) { JsonArray array = lerJson(new File(caminhoPasta + "/" + tipo +
     * ".json")); // JsonArray array = lerJson(new File(caminhoPasta.getPath() + "/"
     * + tipo + ".json")); excluirEmJson(tipo, array, codigo);
     * 
     * try (FileWriter writer = new FileWriter(caminhoPasta + "/" + tipo + ".json");
     * PrintWriter printer = new PrintWriter(writer);) {
     * printer.print(array.toString()); } catch (IOException e) {
     * e.printStackTrace(); }
     * 
     * Produto produtoExcluido = buscarProduto(codigo);
     * removerProduto(produtoExcluido); }
     */

    private void excluirProdutoJson(File caminhoPasta, String codigo) {

        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoPasta, arquivosProdutos);

        for (String arquivo : arquivosProdutos) {
            File arquivoProduto = new File(caminhoPasta.getPath() + "/" + arquivo);
            JsonArray array = lerJson(arquivoProduto);

            String tipoProduto = "";
            char[] tipo = arquivo.toCharArray();

            for (int i = 0; tipo[i] != '.' && i < tipo.length; i++) {
                tipoProduto += tipo[i];
            }

            excluirEmJson(tipoProduto, array, codigo);

            try (FileWriter writer = new FileWriter(caminhoPasta + "/" + tipoProduto + ".json");
                    PrintWriter printer = new PrintWriter(writer);) {
                printer.print(array.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Produto produtoExcluido = buscarProduto(codigo);
        removerProduto(produtoExcluido);
    }

    public List<String> listarProdutosEstoque() {
        List<String> nomeProdutos = new ArrayList<>();

        for (Produto produto : getProdutos()) {
            nomeProdutos.add(produto.getNome() + " - " + produto.getClass().getSimpleName());
        }

        return nomeProdutos;
    }

    public List<String> listarProdutosCadastrados() {
        return getProdutosCadastrados();
    }

    private String obterNomeProdutoTxt(File caminhoArquivo) {
        String nome = null;
        try (FileReader leitorArquivo = new FileReader(caminhoArquivo);
                BufferedReader buffer = new BufferedReader(leitorArquivo);) {
            String tipo = buffer.readLine();

            buffer.readLine(); // codigo do produto
            buffer.readLine(); // quantidade em estoque

            nome = buffer.readLine() + " - " + tipo; // Nome do produto e sua categoria
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nome;
    }

    private String obterNomeProdutoJson(File caminhoArquivo) {
        String nome = null;

        try {
            FileReader leitor = new FileReader(caminhoArquivo);
            Object objeto = JsonParser.parseReader(leitor);
            JsonObject produto = (JsonObject) objeto;
            nome = produto.get("nome").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nome;
    }

    public List<String> listarProdutosExcluidos() {
        List<String> nomeProdutos = new ArrayList<>();

        File arquivosExcluidos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        List<String> nomeArquivos = new ArrayList<>();
        percorrerArquivosEmPasta(arquivosExcluidos, nomeArquivos);

        for (String caminhoArquivo : nomeArquivos) {
            if (caminhoArquivo.contains(".txt")) {
                nomeProdutos.add(obterNomeProdutoTxt(new File(arquivosExcluidos.getPath() + "/" + caminhoArquivo)));
            } else if (caminhoArquivo.contains(".json")) {
                nomeProdutos.add(obterNomeProdutoJson(new File(arquivosExcluidos.getPath() + "/" + caminhoArquivo)));
            }
        }

        return nomeProdutos;
    }

    public List<String> listarProdutosForaEstoque() {
        List<String> nomeProdutos = new ArrayList<>();
        File arquivosForaEstoque = new File("./src/model/gestaoProdutos/produtosForaEstoque");

        List<String> nomeArquivos = new ArrayList<>();

        percorrerArquivosEmPasta(arquivosForaEstoque, nomeArquivos);

        for (String caminhoArquivo : nomeArquivos) {
            try (FileReader leitor = new FileReader(arquivosForaEstoque.getPath() + "/" + caminhoArquivo);
                    BufferedReader buffer = new BufferedReader(leitor);) {
                buffer.readLine(); // Categoria do Produto
                buffer.readLine(); // Codigo do produto
                nomeProdutos.add(buffer.readLine()); // Nome do produto
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nomeProdutos;
    }

    public List<String> listarLivros() {
        List<String> nomesLivros = new ArrayList<>();

        for (Produto produto : getProdutos()) {
            if (produto.getClass().getSimpleName().equalsIgnoreCase("Livro")) {
                nomesLivros.add(produto.getNome());
            }
        }
        return nomesLivros;
    }

    public List<String> listarHQs() {
        List<String> nomesHQs = new ArrayList<>();

        for (Produto produto : getProdutos()) {
            if (produto.getClass().getSimpleName().equalsIgnoreCase("HQ")) {
                nomesHQs.add(produto.getNome());
            }
        }
        return nomesHQs;
    }

    public List<String> listarBebidas() {
        List<String> nomesBebidas = new ArrayList<>();

        for (Produto produto : getProdutos()) {
            if (produto.getClass().getSimpleName().equalsIgnoreCase("Bebida")) {
                nomesBebidas.add(produto.getNome());
            }
        }
        return nomesBebidas;
    }

    public List<String> listarAcompanhamentos() {
        List<String> nomesAcompanhamentos = new ArrayList<>();

        for (Produto produto : getProdutos()) {
            if (produto.getClass().getSimpleName().equalsIgnoreCase("Bebida")) {
                nomesAcompanhamentos.add(produto.getNome());
            }
        }
        return nomesAcompanhamentos;
    }
}