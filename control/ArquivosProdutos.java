package control;

import java.io.*;
import model.gestaoProduto.*;

import java.util.List;

public interface Arquivos {

    public void instanciaProduto(String caminhoArquivo);

    public default void findAllFilesInFolder(File folder) {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                System.out.println(file.getName());
            } else {
                findAllFilesInFolder(file);
            }
        }
    }

    public default void findAllFilesInFolder(File folder, List<String> arquivosDeProdutos) {
        // for (File file : folder.listFiles()) {
        // if (!file.isDirectory()) {
        // System.out.println(file.getName());
        // arquivosDeProdutos.add(file.getName());
        // } else {
        // findAllFilesInFolder(file);
        // }
        // }

        File[] file = folder.listFiles();

        for (int i = 0; i < folder.listFiles().length; i++) {
            if (!file[i].isDirectory()) {
                arquivosDeProdutos.add(file[i].getName());
            } else {
                findAllFilesInFolder(file[i]);
            }
        }
    }

    public default void lerArquivo(String caminho) {

        try (

                FileReader acessoArquivo = new FileReader(caminho);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {
            String conteudo = "";

            while (conteudo != null) {
                System.out.println(conteudo);
                conteudo = leitorArquivo.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // String poderia ser do tipo URL
    public default void escreverArquivo(String caminho, String conteudo) {
        // try-catch wih resources
        try (FileWriter acessoArquivo = new FileWriter(caminho, true); // o parâmetro true mantém o conteúdo do arquivo
                BufferedWriter buffer = new BufferedWriter(acessoArquivo);
                PrintWriter escreveArquivo = new PrintWriter(buffer);
        // Não é necessário fechar o arquivo pois ele foi aberto como recurso do try e
        // será fechado automaticamente
        ) {

            escreveArquivo.append(conteudo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public default void instanciaLivro(Livro livro, String caminhoArquivo) {

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

        // System.out.println();
        // System.out.println(livro.getCodigo());
        // System.out.println(livro.getNome());
        // System.out.println(livro.getPreco());
        // System.out.println(livro.getQtdEmEstoque());
        // System.out.println(livro.getISBN());
        // System.out.println(livro.getEditora());
        // System.out.println(livro.getAnoPublicacao());
        // System.out.println(livro.getGenero());
        // System.out.println(livro.getAutor());
    }

    public default void instanciaHQ(HQ hq, String caminhoArquivo) {
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

        // System.out.println();
        // System.out.println(hq.getCodigo());
        // System.out.println(hq.getNome());
        // System.out.println(hq.getPreco());
        // System.out.println(hq.getQtdEmEstoque());
        // System.out.println(hq.getISBN());
        // System.out.println(hq.getEditora());
        // System.out.println(hq.getAnoPublicacao());
        // System.out.println(hq.getGenero());
        // System.out.println(hq.getAutor());
    }

    public default void instanciaRevista(Revista revista, String caminhoArquivo) {
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

        // System.out.println();
        // System.out.println(revista.getCodigo());
        // System.out.println(revista.getNome());
        // System.out.println(revista.getPreco());
        // System.out.println(revista.getQtdEmEstoque());
        // System.out.println(revista.getISBN());
        // System.out.println(revista.getEditora());
        // System.out.println(revista.getAnoPublicacao());
        // System.out.println(revista.getGenero());
        // System.out.println(revista.getMarca());

    }

    public default void instanciaBebida(Bebida bebida, String caminhoArquivo) {

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

        // System.out.println();
        // System.out.println(bebida.getCodigo());
        // System.out.println(bebida.getNome());
        // System.out.println(bebida.getPreco());
        // System.out.println(bebida.getQtdEmEstoque());
        // System.out.println(bebida.getValidade());
        // System.out.println(bebida.getTipoBebida());

    }

    public default void instanciaAcompanhamento(Acompanhamento acompanhamento, String caminhoArquivo) {
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

        // System.out.println();
        // System.out.println(acompanhamento.getCodigo());
        // System.out.println(acompanhamento.getNome());
        // System.out.println(acompanhamento.getPreco());
        // System.out.println(acompanhamento.getQtdEmEstoque());
        // System.out.println(acompanhamento.getValidade());
        // System.out.println(acompanhamento.getTipoAcompanhamento());
    }
}
