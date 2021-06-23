package model.gestaoClientes;

import model.gestaoVendas.Compra;

public class Clientela extends Cliente{
    private Cliente[] cliente;

    public Clientela() {
    }

    public Clientela(String nome, String cPF, Compra[] compra) {
        super(nome, cPF, compra);
    }

    public Clientela(Cliente[] cliente) {
        this.cliente = cliente;
    }

    public Cliente[] getCliente() {
        return cliente;
    }

    public void setCliente(Cliente[] cliente) {
        this.cliente = cliente;
    }

    public int cadastrarCliente(){
        return 1;
    }

    public int excluirCliente(){
        return 1;
    }

    public void listarClientes(){

    }

    public void listarClientesExcluidos(){

    }
}
