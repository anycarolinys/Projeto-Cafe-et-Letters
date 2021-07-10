package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import model.gestaoClientes.Cliente;

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

    public void cadastrarClienteArquivo(String caminhoArquivo);

    public void cadastrarClienteObjeto(Cliente cliente);

    public File buscarClienteParaExcluir(File caminhoDiretorio, String CPF) throws FileNotFoundException;

    public boolean excluirCliente(File caminhoArquivo);

    public Cliente buscarCliente(String CPF);
}
