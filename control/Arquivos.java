package control;

import java.io.*;
import java.util.*;

public interface Arquivos {

    public static void acessarArquivosNoDiretorio(File diretorio, List<String> arquivosDeProdutos) {

        for (File arquivo : diretorio.listFiles()) {
            // Testando se o caminho passado consiste em outro diretorio
            if (!arquivo.isDirectory()) {
                // Adicionando nome dos arquivos à List
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                acessarArquivosNoDiretorio(diretorio, arquivosDeProdutos);
            }
        }

    }

    public static void lerArquivoTexto(String caminho) {

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
    public static void escreverArquivoTexto(String caminho, String conteudo) {
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