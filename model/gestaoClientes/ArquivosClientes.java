package model.gestaoClientes;

import java.io.File;
import java.util.List;

public interface ArquivosClientes {

    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosClientes) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosClientes.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(pasta, arquivosClientes);
            }
        }
    }

    public void instanciarClienteArquivo(String caminhoArquivo);

    public void instanciarClienteObjeto(Cliente cliente, boolean pasta);

    // public File buscarClienteParaExcluir(File caminhoDiretorio, String CPF) throws FileNotFoundException;

    // public boolean excluirCliente(File caminhoArquivo);

    public Cliente buscarCliente(String CPF);
}