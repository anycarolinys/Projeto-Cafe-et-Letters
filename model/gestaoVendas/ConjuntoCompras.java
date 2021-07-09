package model.gestaoVendas;

import java.util.*;

public class ConjuntoCompras {
    private Set<Compra> vendas;

    public ConjuntoCompras() {
        this.vendas = new TreeSet<>();
    }

    public Set<Compra> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Compra> vendas) {
        this.vendas = vendas;
    }

    public void listarVendas(){}
    
}