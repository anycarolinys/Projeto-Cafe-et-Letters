package model.gestaoClientes;

import model.gestaoVendas.Compra;

public class Cliente {
    private String nome;
    private String CPF;
    private Compra[] compra;
    
    public Cliente() {
    }
    
    public Cliente(String nome, String cPF, Compra[] compra) {
        this.nome = nome;
        CPF = cPF;
        this.compra = compra;
    }

    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Compra[] getCompra() {
        return compra;
    }
    public void setCompra(Compra[] compra) {
        this.compra = compra;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        this.CPF = cPF;
    }

    public void aplicarPromocao(){}

    public void listarCompras(){}
}
