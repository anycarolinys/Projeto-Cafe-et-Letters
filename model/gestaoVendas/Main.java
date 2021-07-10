package model.gestaoVendas;
// import model.gestaoProdutos.*;
import model.gestaoClientes.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Clientela clientela = new Clientela();
        List<String> arquivosClientes = new ArrayList<>();
        File diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");

        clientela.percorrerArquivosEmPasta(diretorioClientes, arquivosClientes);
        
        for (String caminhoArquivo : arquivosClientes) {
            clientela.cadastrarClienteArquivo(diretorioClientes + "/" + caminhoArquivo);
        }

        // clientela.listarClientesAtivos();
        
        /* Alimentos bebida = new Bebida("008", "Guaraná", 5, 8, 9, 2021, "Refrigerante");
        Compra compra1 = new Compra(30, 40, bebida, 2);
        
        Transacao transacao = new Transacao();
        transacao.cadastroCompra(clientela, clientela.getClientes().get(0), compra1);
        
        Compra compra2 = new Compra(30, 40, bebida, 2);
        transacao.cadastroCompra(clientela, clientela.getClientes().get(0), compra2);
        
        transacao.cadastroCompra(clientela, clientela.getClientes().get(1), compra1);
        transacao.cadastroCompra(clientela, clientela.getClientes().get(1), compra2);
         */

/*       File diretorioCompras = new File("./src/model/gestaoClientes/comprasCadastradas");
        File meuDiretorio = new File("./src/model/gestaoClientes/comprasCadastradas");

        File arquivoCPF = transacao.buscarDiretorioCliente(meuDiretorio, clientela.getClientes().get(0));

        System.out.println(arquivoCPF.getName());
        System.out.println(arquivoCPF.getPath());
 */
    }

}