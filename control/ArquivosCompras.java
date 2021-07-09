package control;

import java.io.File;
import java.util.List;


public interface ArquivosCompras {
    
    public default void percorrerArquivosEmPasta(File pasta, List<String> arquivosCompras) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosCompras.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(pasta, arquivosCompras);
            }
        }
    }

//     // Cadastra compra para cliente que nunca comprou
//     public void cadastrarCompra(Cliente cliente, Compra compra, File diretorioCompras);
    
//     // Cadastra compra para cliente que já comprou
//     public void cadastrarCompra(String CPF, File diretorioCompras);

//     public void cadastroCompra(Cliente cliente, Compra compra, File diretorioCompras);
}
