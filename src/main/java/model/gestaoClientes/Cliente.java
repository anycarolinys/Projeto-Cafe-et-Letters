package model.gestaoClientes;

import java.util.List;
import java.util.ArrayList;
import model.gestaoVendas.*;

public class Cliente {
    private String CPF;
    private String nome;
    private List<Compra> compras;

    public Cliente() {
        this.compras = new ArrayList<>();
    }

    public Cliente(String CPF, String nome) {
        this.CPF = CPF;
        this.nome = nome;
        this.compras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        this.CPF = cPF;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Compra compra) {
        this.compras.add(compra);
    }

    public void aplicarPromocao() {
    }

    public void listarCompras() {
    }

    public boolean possuiCompras() {
        if (getCompras().size() > 0)
                return true;
        return false;
    }
}