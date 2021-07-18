package model.gestaoVendas;

import java.io.File;
import java.util.*;

public class ConjuntoVendas {
    private static Set<Compra> compras;

    ConjuntoVendas () {
        compras = new HashSet<>();
    }
    
    public Set<Compra> getCompras() {
        return compras;
    }

    public static void adicionarCompras(Compra compra) {
        compras.add(compra);
    }
    
    public void percorrerArquivosEmPasta(File pasta, List<String> arquivosClientes) {
        for (File arquivo : pasta.listFiles()) {
            if (!arquivo.isDirectory()) {
                arquivosClientes.add(arquivo.getName());
            } else {
                percorrerArquivosEmPasta(pasta, arquivosClientes);
            }
        }
    }

    public List<String> listarVendas() {
        List<String> arquivosVendas = new ArrayList<>();   
        File diretorio = new File("./src/model/gestaoClientes/comprasCadastradas");

        percorrerArquivosEmPasta(diretorio, arquivosVendas);

        for (String venda : arquivosVendas) {
            arquivosVendas.add(venda);
        }
        return arquivosVendas;
    }
}