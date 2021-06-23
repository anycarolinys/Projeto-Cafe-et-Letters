package model.gestaoProduto;

import java.util.Date;

public class Bebida extends Alimentos{
    private String tipoBebida;

    public Bebida() {
    }

    public Bebida(Date validade) {
        super(validade);
    }

    public Bebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

}
