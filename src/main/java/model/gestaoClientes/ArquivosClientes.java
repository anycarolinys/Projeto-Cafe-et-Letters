package model.gestaoClientes;

import java.io.File;
import java.util.List;

public interface ArquivosClientes {

    /* Instancia clientes a partir da pasta clientesCadastrados
    * deve ser chamada ao inicializar o programa
    */
    public void inicializarClientes();
    
    /* Receber um objeto cliente e um booleando pasta
    * true: instancia cliente na pasta clientesCadastrados
    * false: instancia cliente na pasta clientesExcluidos
    */
    public void cadastrarCliente(Cliente cliente, boolean pasta);

    /* Recebe o CPF do cliente e remove-o tanto da Cliente
    * bem como remove seu arquivo e move-o para a pasta
    * clientesExcluidos 
    */
    public void excluirCliente(String CPF);

    // Lista os clientes cadastrados
    public List<Cliente> listarClientesCadastrados();
    
    // Lista os clientes excluidos
    public List<String> listarClientesExcluidos();

    // Recebe o CPF do cliente e lista suas compras já realizadas
    public List<String> listarComprasClientes(String CPF);

    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosClientes) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosClientes.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(pasta, arquivosClientes);
            }
        }
    }
}