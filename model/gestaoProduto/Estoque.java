package model.gestaoProdutos;

import java.util.*;

import java.io.*;

public class Estoque implements ArquivosProdutos {

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
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    public void atualizar() {
        getProdutos().clear();

        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");
        List<String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(diretorioProdutos, arquivosProdutos);
        for (String caminhoArquivo : arquivosProdutos) {
            instanciarProdutoArquivo(diretorioProdutos + "/" + caminhoArquivo);
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

            try (
                FileReader leitor = new FileReader(arquivo);
                BufferedReader buffer = new BufferedReader(leitor);
            ) {
                buffer.readLine();
                if(buffer.readLine().equals(codigo)) 
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
            leitorArquivo.readLine(),  // Editora
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

            hq = new HQ(leitorArquivo.readLine(), 
            Integer.parseInt(leitorArquivo.readLine()),
            leitorArquivo.readLine(),
            Double.parseDouble(leitorArquivo.readLine()), 
            leitorArquivo.readLine(), 
            leitorArquivo.readLine(), 
            Integer.parseInt(leitorArquivo.readLine()),
            leitorArquivo.readLine(), 
            leitorArquivo.readLine());

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

            /* String validade[] = leitorArquivo.readLine().split("/", 2);

            bebida.setValidade(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]));

            conteudo = leitorArquivo.readLine();
            bebida.setTipoBebida(conteudo); */

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

            /* String validade[] = leitorArquivo.readLine().split("/", 2);
            acompanhamento.setValidade(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]));
            
            conteudo = leitorArquivo.readLine();
            acompanhamento.setTipoAcompanhamento(conteudo); */

        } catch (Exception e) {
            e.printStackTrace();
        }

        return acompanhamento;
    }
    
    public void instanciarLivroObjeto(Livro livro, boolean pasta) {
        File diretorioProdutos;
        if (pasta == true)
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(livro.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/" + caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {

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
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(hq.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/"+ caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {
            
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
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(acompanhamento.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/"+ caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {

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
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");
        else
            diretorioProdutos = new File("./src/model/gestaoProdutos/produtosExcluidos");

        String caminhoArquivo = Integer.toString(bebida.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/"+ caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {

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
    
    public File buscarProdutoParaExcluir(File caminhoDiretorio, String codigo) {
        List <String> arquivosProdutos = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, arquivosProdutos);

        Produto produtoExcluido;
        File arquivo = null;
        
        for (String caminhoArquivo : arquivosProdutos) {
            arquivo = new File(caminhoDiretorio + "/" + caminhoArquivo);

            try (
                FileReader leitor = new FileReader(arquivo);
                BufferedReader buffer = new BufferedReader(leitor);
            ) {
                // A primeira linha do arquivo é um identificador pra representar o tipo de produto
                buffer.readLine(); 
                
                if (buffer.readLine().equals(codigo))  {
                    produtoExcluido = buscarProduto(codigo);
                    instanciarProdutoObjeto(produtoExcluido, false);
                    removerProduto(produtoExcluido);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return arquivo;
    }   

    
    public Produto buscarProduto(String codigo) {

        for (Produto produto : getProdutos()) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public boolean excluirArquivoProduto(File caminhoArquivo) {
        return caminhoArquivo.delete();
    }
}