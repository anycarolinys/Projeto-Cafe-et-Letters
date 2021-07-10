package model.gestaoVendas;

import java.util.*;

public class ConjuntoCompras {
    private static Set<Compra> compras;

    public Set<Compra> getCompras() {
        return compras;
    }

    public static void adicionarCompras(Compra compra) {
        compras.add(compra);
    }
        
}