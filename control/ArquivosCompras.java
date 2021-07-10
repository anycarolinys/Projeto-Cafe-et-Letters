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

//     public void cadastroCompra(Cliente cliente, Compra compra, File diretorioCompras);
}
