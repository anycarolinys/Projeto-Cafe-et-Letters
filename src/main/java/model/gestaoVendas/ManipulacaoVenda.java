package model.gestaoVendas;

import java.io.File;
import java.util.List;

import model.gestaoClientes.Cliente;

public interface ManipulacaoVenda {

    // Cria diretorio do cliente para quando este realizar sua primeira compra 
    public File criarDiretorioCliente(File diretorioCompra, Cliente cliente);

    /* Cadastra compra associada a um cliente, além de:
    * - Adiciona compras para o diretorio do cliente
    * - Alterar a quantidade do produto no estoque
    * - Remover produto do estoque se sua quantidade for zerada
    */
    /* OBSERVAÇÃO: após a chamada desta função o estoque deve ser atualizado 
    * com a função 'inicializarEstoque()' da classe Estoque
    */
    public boolean cadastrarCompra(Cliente cliente, Compra compra);

    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosDeProdutos) {

        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosDeProdutos.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(arquivo, arquivosDeProdutos);
            }
        }
    }
}
