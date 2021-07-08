package model.gestaoClientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        List<String> arquivosClientes = new ArrayList<>();

        Clientela clientela = new Clientela();
        clientela.percorrerArquivosEmPasta(diretorioClientes, arquivosClientes);

        for (String nomeArquivo : arquivosClientes) {
            clientela.cadastrarCliente(diretorioClientes + "\\" + nomeArquivo);
        }

        // clientela.listarClientesAtivos();
        try {
            clientela.deletarCliente(diretorioClientes, "12345678910");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
