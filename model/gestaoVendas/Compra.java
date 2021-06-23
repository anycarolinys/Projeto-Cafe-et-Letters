package model.gestaoVendas;

import java.util.Calendar;

import model.gestaoProduto.Produto;

public class Compra extends Venda{
 private Produto produto;

 public Compra(){}

 public Compra(double valorTotal, double valorPago, double troco, Calendar data, int hora) {
    super(valorTotal, valorPago, troco, data, hora);
}

 public Compra(double valorTotal, double valorPago, double troco, Calendar data, int hora, Produto produto) {
    super(valorTotal, valorPago, troco, data, hora);
    this.produto = produto;
}

public Produto getProduto() {
    return produto;
}

public void setProduto(Produto produto) {
    this.produto = produto;
}

public double pagar(double valor){
    return valor;
}

public int cadastrarVenda(){
    return 1;
}
}
