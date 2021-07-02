package model.gestaoClientes;

import java.util.List;

import control.*;

import java.util.ArrayList;


public class Clientela implements Arquivos {
    private List<Cliente> clientes;

    public Clientela() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int cadastrarCliente(){
        return 1;
    }

    public int excluirCliente(){
        return 1;
    }

    public void listarClientesAtivos(){

    }

    public void listarClientesExcluidos(){

    }
}
