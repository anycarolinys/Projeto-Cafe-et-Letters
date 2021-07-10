package model.gestaoVendas;

// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Calendar;

import control.ArquivosCompras;
import model.gestaoProdutos.Produto;

public class Compra extends Venda implements ArquivosCompras{
    private Produto produto;
    private int quantidadeProduto;

    public Compra() {
    }

    public Compra(
        double valorTotal, 
        double valorPago, 
        Produto produto, 
        int quantidadeProduto) {

        super(valorTotal, valorPago);
        // Compra não instancia produto, pois só é 
        // possível comprar o que se tem no estoque
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

}
