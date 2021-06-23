package model.gestaoProduto;

import java.util.Date;

public class Acompanhamento extends Alimentos{
    private String tipoAcompanhamento;
    
    public Acompanhamento() {
    }

    public Acompanhamento(Date validade) {
        super(validade);
    }

 
    public Acompanhamento(String tipoAcompanhamento) {
        this.tipoAcompanhamento = tipoAcompanhamento;
    }

    public String getTipoAcompanhamento() {
        return tipoAcompanhamento;
    }

    public void setTipoAcompanhamento(String tipoAcompanhamento) {
        this.tipoAcompanhamento = tipoAcompanhamento;
    }
    
}
