package model.gestaoClientes;

import java.util.List;

import control.*;

import java.util.ArrayList;

import model.gestaoVendas.Compra;

public class Cliente implements Arquivos {
    private String nome;
    private String CPF;
    private List<Compra> compras;

    public Cliente(String nome, String cPF) {
        this.nome = nome;
        CPF = cPF;
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

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void aplicarPromocao() {
    }

    public void listarCompras() {
    }
}
