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

    public void inicializarEstoque() {
        getProdutos().clear();

        List<String> arquivosTxt = new ArrayList<>();

        File produtosEmTxt = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosTxt");
        percorrerArquivosEmPasta(produtosEmTxt, arquivosTxt);

        for (String caminhoArquivo : arquivosTxt) {
            instanciarProdutoArquivo(produtosEmTxt + "/" + caminhoArquivo);
        }

        List<String> arquivosJson = new ArrayList<>();

        File produtosJson = new File("./src/model/gestaoProdutos/produtosCadastrados/produtosJson");
        percorrerArquivosEmPasta(produtosJson, arquivosJson);

        for (String caminhoArquivo : arquivosJson) {
            instanciarProdutoJson(new File(produtosJson + "/" + caminhoArquivo));
        }
    }

    public void instanciarProdutoArquivo(String caminhoArquivo) {

        Livraria produtoLivraria;
        Bebida bebida;
        Acompanhamento acompanhamento;

        try (

                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {
            String conteudo = "";
            // Lendo o tipo de produto a ser instanciado
            conteudo = leitorArquivo.readLine();

            switch (conteudo.toLowerCase()) {
                case "livro":
                    produtoLivraria = instanciarLivroArquivo(caminhoArquivo);
                    setProdutos(produtoLivraria);
                    break;
                case "hq":
                    produtoLivraria = instanciarHQArquivo(caminhoArquivo);
                    setProdutos(produtoLivraria);
                    break;
                case "bebida":
                    bebida = instanciarBebidaArquivo(caminhoArquivo);
                    setProdutos(bebida);
                    break;
                case "acompanhamento":
                    acompanhamento = instanciarAcompanhamentoArquivo(caminhoArquivo);
                    setProdutos(acompanhamento);
                    break;
                default:
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File procurarArquivoProduto(File caminhoDiretorio, String codigo) throws FileNotFoundException {

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

    public Livro instanciarLivroArquivo(String caminhoArquivo) {

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

    public HQ instanciarHQArquivo(String caminhoArquivo) {

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

    public Bebida instanciarBebidaArquivo(String caminhoArquivo) {

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

            /*
             * conteudo = leitorArquivo.readLine(); bebida.setTipoBebida(conteudo);
             */

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bebida;
    }

    public Acompanhamento instanciarAcompanhamentoArquivo(String caminhoArquivo) {

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

            /*
             * conteudo = leitorArquivo.readLine();
             * acompanhamento.setTipoAcompanhamento(conteudo);
             */

        } catch (Exception e) {
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
            // printer.println(acompanhamento.getValidade());
            // printer.print(acompanhamento.getTipoAcompanhamento());

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
            // printer.println(bebida.getValidade());
            // printer.print(bebida.getTipoBebida());

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

        try (FileReader leitor = new FileReader(caminhoArquivo);) {
            if (caminhoArquivo.length() > 0) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray listaLivros = (JsonArray) objeto;

                for (JsonElement livros : listaLivros) {
                    instanciaLivros.add(parseLivro((JsonObject) livros));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instanciaLivros;
    }

    public Livro parseLivro(JsonObject livro) {
        Livro objetoLivro = new Livro(livro.get("codigo").getAsString(), livro.get("qtdEmEstoque").getAsInt(),
                livro.get("nome").getAsString(), livro.get("preco").getAsDouble(), livro.get("ISBN").getAsString(),
                livro.get("editora").getAsString(), livro.get("anoPublicacao").getAsInt(),
                livro.get("genero").getAsString(), livro.get("autor").getAsString());

        return objetoLivro;
    }

    public List<Produto> instanciarHQJson(File caminhoArquivo) {

        List<Produto> instanciaLivros = new ArrayList<>();

        try (FileReader leitor = new FileReader(caminhoArquivo);) {
            if (caminhoArquivo.length() > 0) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray listaLivros = (JsonArray) objeto;

                for (JsonElement livros : listaLivros) {
                    instanciaLivros.add(parseHQ((JsonObject) livros));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instanciaLivros;
    }

    public HQ parseHQ(JsonObject livro) {
        HQ objetoHQ = new HQ(livro.get("codigo").getAsString(), livro.get("qtdEmEstoque").getAsInt(),
                livro.get("nome").getAsString(), livro.get("preco").getAsDouble(), livro.get("ISBN").getAsString(),
                livro.get("editora").getAsString(), livro.get("anoPublicacao").getAsInt(),
                livro.get("genero").getAsString(), livro.get("autor").getAsString());

        return objetoHQ;
    }

    public List<Produto> instanciarBebidaJson(File caminhoArquivo) {

        List<Produto> instanciaBebidas = new ArrayList<>();

        try (FileReader leitor = new FileReader(caminhoArquivo);) {
            // Testa se todos os produtos foram excluídos
            if (caminhoArquivo.length() > 0) {
                Object objeto = JsonParser.parseReader(leitor);
                JsonArray listaLivros = (JsonArray) objeto;

                for (JsonElement bebidas : listaLivros) {
                    instanciaBebidas.add(parseBebida((JsonObject) bebidas));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instanciaBebidas;
    }

    public Bebida parseBebida(JsonObject bebida) {
        Bebida objetoBebida = new Bebida(bebida.get("codigo").getAsString(), bebida.get("qtdEmEstoque").getAsInt(),
                bebida.get("nome").getAsString(), bebida.get("preco").getAsDouble());

        return objetoBebida;
    }

    public List<Produto> instanciarAcompanhamentoJson(File caminhoArquivo) {
        List<Produto> instanciaAcompanhamentos = new ArrayList<>();

        try (FileReader leitor = new FileReader(caminhoArquivo);) {
            // Testa se todos os produtos foram excluídos
            if (caminhoArquivo.length() > 0) {
                if (JsonParser.parseReader(leitor) != null) {
                    Object objeto = JsonParser.parseReader(leitor);
                    JsonArray listaAcompanhamento = (JsonArray) objeto;

                    for (JsonElement acompanhamentos : listaAcompanhamento) {
                        instanciaAcompanhamentos.add(parseAcompanhamento((JsonObject) acompanhamentos));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instanciaAcompanhamentos;
    }

    public Acompanhamento parseAcompanhamento(JsonObject acompanhamento) {
        Acompanhamento objetoAcompanhamento = new Acompanhamento(acompanhamento.get("codigo").getAsString(),
                acompanhamento.get("qtdEmEstoque").getAsInt(), acompanhamento.get("nome").getAsString(),
                acompanhamento.get("preco").getAsDouble());

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

    public boolean excluirProdutoTxt(File caminhoDiretorio, String codigo) {
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

        return excluirArquivo(arquivoExclusao);
    }

    public boolean excluirProdutoJson(File caminhoPasta, String codigo) {
        JsonArray arrayProdutos = new JsonArray();

        List<String> arquivosProdutos = new ArrayList<>();

        percorrerArquivosEmPasta(caminhoPasta, arquivosProdutos);

        for (String caminhoArquivo : arquivosProdutos) {
            File arquivoProduto = new File(caminhoPasta + "/" + caminhoArquivo);
            try (FileReader leitor = new FileReader(arquivoProduto);
                    FileWriter writer = new FileWriter(arquivoProduto);
                    PrintWriter printer = new PrintWriter(writer);) {
                // O arquivo do produto pode já estar vazio
                if (arquivoProduto.length() > 0) {
                    Object objeto = JsonParser.parseReader(leitor);
                    arrayProdutos = (JsonArray) objeto;

                    for (int i = 0; i < arrayProdutos.size(); i++) {
                        JsonObject objProduto = (JsonObject) arrayProdutos.get(i);
                        if (objProduto.get("codigo").getAsString().equals(codigo)) {
                            arrayProdutos.remove(i);
                            if (arrayProdutos.size() > 0) {
                                printer.print(arrayProdutos.toString());
                                return true;
                            }
                        }
                    }
                    /*
                     * for(int i = 0; i < produtos.size() ; i++) { produto = (JsonObject)
                     * arrayProdutos.get(i); if (produto.get("codigo").getAsString().equals(codigo))
                     * { System.out.println(produto.toString()); produtos.remove(i); if (produtos !=
                     * null) printer.print(produtos.toString()); return true; } }
                     */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public Produto buscarProduto(String codigo) {

        for (Produto produto : getProdutos()) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public boolean excluirArquivo(File caminhoArquivo) {
        if (caminhoArquivo == null)
            return false;
        return caminhoArquivo.delete();
    }
}