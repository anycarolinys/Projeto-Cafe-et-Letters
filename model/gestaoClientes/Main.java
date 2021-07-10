package model.gestaoClientes;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        List<String> arquivosClientes = new ArrayList<>();

        Clientela clientela = new Clientela();
        clientela.percorrerArquivosEmPasta(diretorioClientes, arquivosClientes);

        for (String nomeArquivo : arquivosClientes) {
            clientela.cadastrarClienteArquivo(diretorioClientes + "\\" + nomeArquivo);
        }

        // clientela.listarClientesAtivos();
        // try {
        //     File arquivo = clientela.procurarArquivoCliente(diretorioClientes, "12345678919");
        //     System.out.println(arquivo.getPath());
        //     clientela.excluirCliente(arquivo);
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }

        clientela.listarClientesAtivos(); 
    }
}
