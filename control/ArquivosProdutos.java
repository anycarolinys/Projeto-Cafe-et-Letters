package control;

import java.io.*;
import model.gestaoProduto.*;

import java.util.List;

public interface ArquivosProdutos {

    public void instanciarProduto(String caminhoArquivo);

    public void deletarProduto(File caminhoDiretorio, String codigo) throws FileNotFoundException;

    public Livro instanciarLivro(String caminhoArquivo);

    public HQ instanciarHQ(String caminhoArquivo);

    public Revista instanciarRevista(String caminhoArquivo);

    public Bebida instanciarBebida(String caminhoArquivo);

    public Acompanhamento instanciarAcompanhamento(String caminhoArquivo); 


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
        /* for (File arquivo : pasta.listFiles()) {
        if (!arquivo.isDirectory()) {
        System.out.println(arquivo.getName());
        arquivosDeProdutos.add(arquivo.getName());
        } else {
        percorrerArquivosEmPasta(file);
        }
        } */

        File[] arquivo = pasta.listFiles();

        for (int i = 0; i < pasta.listFiles().length; i++) {
            if (!arquivo[i].isDirectory()) {
                arquivosDeProdutos.add(arquivo[i].getName());
            } else {
                percorrerArquivosEmPasta(arquivo[i], arquivosDeProdutos);
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


}