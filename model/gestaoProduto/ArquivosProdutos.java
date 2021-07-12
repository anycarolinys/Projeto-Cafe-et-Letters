package model.gestaoProdutos;

import java.io.*;
import java.util.List;


public interface ArquivosProdutos {
    

    public void listarProdutosCadastrados();

    public void instanciarProdutoArquivo(String caminhoArquivo);

    public File procurarArquivoProduto(File caminhoDiretorio, String codigo) throws FileNotFoundException;

    public Livro instanciarLivroArquivo(String caminhoArquivo);

    public HQ instanciarHQArquivo(String caminhoArquivo);

    public Bebida instanciarBebidaArquivo(String caminhoArquivo);

    public Acompanhamento instanciarAcompanhamentoArquivo(String caminhoArquivo); 

    public void instanciarLivroObjeto(Livro livro, boolean pasta);

    public void instanciarHQObjeto(HQ hq, boolean pasta);

    public void instanciarAcompanhamentoObjeto(Acompanhamento acompanhamento, boolean pasta); 

    public void instanciarBebidaObjeto(Bebida bebida, boolean pasta);

    public void instanciarProdutoObjeto(Produto produto, boolean pasta);

    public File buscarProdutoParaExcluir(File caminhoDiretorio, String codigo);

    public boolean excluirArquivoProduto(File caminhoArquivo);
    
    public Produto buscarProduto(String codigo);


    public default void percorrerArquivosEmPasta(File pasta) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                System.out.println(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo);
            }
        }
    }


    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeProdutos) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo, arquivosDeProdutos);
            }
        }

/*         File[] arquivo = pasta.listFiles();

        for (int i = 0; i < pasta.listFiles().length; i++) {
            if (!arquivo[i].isDirectory()) {
                arquivosDeProdutos.add(arquivo[i].getName());
            } else {
                percorrerArquivosEmPasta(arquivo[i], arquivosDeProdutos);
            }
        } */
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


}