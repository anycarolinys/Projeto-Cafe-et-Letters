package model.gestaoVendas;

import java.util.Set;
import java.util.TreeSet;


public class ConjuntoVendas {
    private Set<Venda> vendas;

    public ConjuntoVendas() {
        this.vendas = new TreeSet<>();
    }

    public Set<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }
    public void listarVendas(){}
    
}
