package model.gestaoVendas;

import java.util.*;

import control.*;
import model.gestaoProdutos.*;

import java.io.*;

public class Estoque implements ArquivosProdutos {

    Set<Produto> produtos;

    public Estoque() {
        this.produtos = new HashSet<>();
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public void inicializarProdutos(String caminhoArquivo) {
        instanciarProdutoArquivo(caminhoArquivo);
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    public void instanciarProdutoArquivo(String caminhoArquivo) {
        
        Livraria produtoLivraria;
        Alimentos produtoAlimentos;

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
                    case "revista":
                        produtoLivraria = instanciarRevistaArquivo(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "bebida":
                        produtoAlimentos = instanciarBebidaArquivo(caminhoArquivo);
                        setProdutos(produtoAlimentos);
                        break;
                    case "acompanhamento":
                        produtoAlimentos = instanciarAcompanhamentoArquivo(caminhoArquivo);
                        setProdutos(produtoAlimentos);
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

    public boolean excluirProdutoArquivo(File caminhoArquivo) {
        return caminhoArquivo.delete();
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

    public Revista instanciarRevistaArquivo(String caminhoArquivo) {
        Revista revista = new Revista();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {
            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            revista = new Revista(leitorArquivo.readLine(), 
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

        return revista;
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

            String validade[] = leitorArquivo.readLine().split("/", 2);

            bebida.setValidade(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]));

            conteudo = leitorArquivo.readLine();
            bebida.setTipoBebida(conteudo);

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

            String validade[] = leitorArquivo.readLine().split("/", 2);

            acompanhamento.setValidade(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]));

            conteudo = leitorArquivo.readLine();
            acompanhamento.setTipoAcompanhamento(conteudo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return acompanhamento;
    }
    
    public void instanciarLivroObjeto(Livro livro) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");

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

    public void instanciarHQObjeto(HQ hq) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");

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

    public void instanciarRevistaObjeto(Revista revista) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");

        String caminhoArquivo = Integer.toString(revista.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/"+ caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {

            printer.println("REVISTA");
            printer.println(revista.getCodigo());
            printer.println(Integer.toString(revista.getQtdEmEstoque()));
            printer.println(revista.getNome());
            printer.println(Double.toString(revista.getPreco()));
            printer.println(revista.getISBN());
            printer.println(revista.getEditora());
            printer.println(Integer.toString(revista.getAnoPublicacao()));
            printer.println(revista.getGenero());
            printer.print(revista.getMarca());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarAcompanhamentoObjeto(Acompanhamento acompanhamento) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");

        String caminhoArquivo = Integer.toString(acompanhamento.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/"+ caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {

            printer.println("ACOMPANHAMENTO");
            printer.println(acompanhamento.getCodigo());
            printer.println(Integer.toString(acompanhamento.getQtdEmEstoque()));
            printer.println(acompanhamento.getNome());
            printer.println(Double.toString(acompanhamento.getPreco()));
            printer.println(acompanhamento.getValidade());
            printer.print(acompanhamento.getTipoAcompanhamento());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarBebidaObjeto(Bebida bebida) {
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");

        String caminhoArquivo = Integer.toString(bebida.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioProdutos.getPath() + "/"+ caminhoArquivo + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {

            printer.println("BEBIDA");
            printer.println(bebida.getCodigo());
            printer.println(Integer.toString(bebida.getQtdEmEstoque()));
            printer.println(bebida.getNome());
            printer.println(Double.toString(bebida.getPreco()));
            printer.println(bebida.getValidade());
            printer.print(bebida.getTipoBebida());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void instanciarProdutoObjeto(Produto produto) {
        

        String conteudo = produto.getClass().getSimpleName().toLowerCase();

        switch (conteudo.toLowerCase()) {
            case "livro":
                instanciarLivroObjeto((Livro) produto);
                setProdutos(produto);
                break;
            case "hq":
                instanciarHQObjeto((HQ) produto);
                setProdutos(produto);
                break;
            case "revista":
                instanciarRevistaObjeto((Revista) produto);
                setProdutos(produto);
                break;
            case "bebida":
                instanciarBebidaObjeto((Bebida) produto);
                setProdutos(produto);
                break;
            case "acompanhamento":
                instanciarAcompanhamentoObjeto((Acompanhamento) produto);
                setProdutos(produto);
                break;
            default:
                break;
        }
    }
}
/*     public void editarProdutoEstoque(String codigo, File diretorioProdutos) {
         
        try {
            // File arquivoProduto = procurarArquivoProduto(diretorioProdutos, codigo);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
    } */