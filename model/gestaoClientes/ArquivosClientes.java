package model.gestaoClientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface ArquivosClientes {
    
    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeClientes) {
        for (File arquivo : pasta.listFiles()) {
            if(!arquivo.isDirectory()) {
                arquivosDeClientes.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(pasta, arquivosDeClientes);
            }
        }
    }   
    
    public void cadastrarCliente(String caminhoArquivo);
    public void deletarCliente(File caminhoDiretorio, String CPF) throws FileNotFoundException;

    
}
