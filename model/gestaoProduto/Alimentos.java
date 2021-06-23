package model.gestaoProduto;

import java.util.Date;

public class Alimentos {
    private Date validade;

    public Alimentos() {
    }

    public Alimentos(Date validade) {
        this.validade = validade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

}
