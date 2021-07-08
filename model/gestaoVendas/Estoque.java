package model.gestaoVendas;

import java.util.*;

import control.*;
import model.gestaoProduto.*;
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
        instanciarProduto(caminhoArquivo);
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    public void instanciarProduto(String caminhoArquivo) {
        
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
                        produtoLivraria = instanciarLivro(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "hq":
                        produtoLivraria = instanciarHQ(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "revista":
                        produtoLivraria = instanciarRevista(caminhoArquivo);
                        setProdutos(produtoLivraria);
                        break;
                    case "bebida":
                        produtoAlimentos = instanciarBebida(caminhoArquivo);
                        setProdutos(produtoAlimentos);
                        break;
                    case "acompanhamento":
                        produtoAlimentos = instanciarAcompanhamento(caminhoArquivo);
                        setProdutos(produtoAlimentos);
                        break;
                    default:
                        break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletarProduto(File caminhoDiretorio, String codigo) throws FileNotFoundException {

        // ArrayList pra guardar todos os arquivos do diretorio
        List<String> listaArquivos = new ArrayList<>(); 
        // Função que armazena o nome dos arquivos em ArrayList
        percorrerArquivosEmPasta(caminhoDiretorio, listaArquivos); 

        for (String caminhoArquivo : listaArquivos) {
            File arquivo = new File(caminhoDiretorio + "\\" + caminhoArquivo);

            try  {
                FileReader leitor = new FileReader(arquivo); 
                BufferedReader buffer = new BufferedReader(leitor);
                // A primeira linha deve ser ignorada
                buffer.readLine();
                // A segunda linha corresponde ao codigo
                String codigoAtual = buffer.readLine();
                // Se o codigo for igual, o arquivo deve ser deletado
                if (codigoAtual.equals(codigo)) {
                    System.out.println(codigoAtual);
                    boolean b = arquivo.delete();  
                    System.out.println(b);
                }
                buffer.close();
                leitor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Livro instanciarLivro(String caminhoArquivo) {
        
        Livro livro = new Livro();

        try (

                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            livro = new Livro(leitorArquivo.readLine(),
            leitorArquivo.readLine(),
            Double.parseDouble(leitorArquivo.readLine()), 
            Integer.parseInt(leitorArquivo.readLine()),
            leitorArquivo.readLine(), 
            leitorArquivo.readLine(), 
            Integer.parseInt(leitorArquivo.readLine()),
            leitorArquivo.readLine(), 
            leitorArquivo.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


        return livro;
    }

    public HQ instanciarHQ(String caminhoArquivo) {

        HQ hq = new HQ();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            hq = new HQ(leitorArquivo.readLine(), 
            leitorArquivo.readLine(),
            Double.parseDouble(leitorArquivo.readLine()), 
            Integer.parseInt(leitorArquivo.readLine()),
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

    public Revista instanciarRevista(String caminhoArquivo) {
        Revista revista = new Revista();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {
            // Inicializando com a primeira linha do arquivo
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();

            revista = new Revista(leitorArquivo.readLine(), 
            leitorArquivo.readLine(),
            Double.parseDouble(leitorArquivo.readLine()), 
            Integer.parseInt(leitorArquivo.readLine()),
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

    public Bebida instanciarBebida(String caminhoArquivo) {

        Bebida bebida = new Bebida();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {
            leitorArquivo.readLine();

            String conteudo = leitorArquivo.readLine();
            bebida.setCodigo(conteudo);

            conteudo = leitorArquivo.readLine();
            bebida.setNome(conteudo);

            conteudo = leitorArquivo.readLine();
            bebida.setPreco(Double.parseDouble(conteudo));

            conteudo = leitorArquivo.readLine();
            bebida.setQtdEmEstoque(Integer.parseInt(conteudo));

            String validade[] = leitorArquivo.readLine().split("/", 2);

            bebida.setValidade(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]));

            conteudo = leitorArquivo.readLine();
            bebida.setTipoBebida(conteudo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bebida;
    }

    public Acompanhamento instanciarAcompanhamento(String caminhoArquivo) {
        
        Acompanhamento acompanhamento = new Acompanhamento();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {
            leitorArquivo.readLine();

            String conteudo = leitorArquivo.readLine();
            acompanhamento.setCodigo(conteudo);

            conteudo = leitorArquivo.readLine();
            acompanhamento.setNome(conteudo);

            conteudo = leitorArquivo.readLine();
            acompanhamento.setPreco(Double.parseDouble(conteudo));

            conteudo = leitorArquivo.readLine();
            acompanhamento.setQtdEmEstoque(Integer.parseInt(conteudo));

            String validade[] = leitorArquivo.readLine().split("/", 2);

            acompanhamento.setValidade(Integer.parseInt(validade[0]), Integer.parseInt(validade[1]));

            conteudo = leitorArquivo.readLine();
            acompanhamento.setTipoAcompanhamento(conteudo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return acompanhamento;
    }
    
    // public void listarProdutosDisponiveis() {}

    // public void listarProdutosCategorias() {}

    // public void listarProdutosExcuidos() {}

    // public void listarProdutosForaDeEstoque() {}

    // public void excluirProduto() {}
}