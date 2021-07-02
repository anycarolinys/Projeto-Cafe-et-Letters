package model.gestaoProduto;

import java.util.Date;

public class Bebida extends Alimentos {
    private String tipoBebida;

    public Bebida() {}

    public Bebida(String nome, double preco, int qtdEmEstoque, String codigo, Date validade, String tipoBebida) {
        super(nome, preco, qtdEmEstoque, codigo, validade);
        this.tipoBebida = tipoBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

}
