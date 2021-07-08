package model.gestaoVendas;

import java.util.*;

public class ConjuntoVendas {
    private Set<Venda> vendas;

    public ConjuntoVendas() {
        this.vendas = new TreeSet<>();
    }

    public Set<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Venda venda) {
        this.vendas.add(venda);
    }

    public void listarVendas(){}
    
}
