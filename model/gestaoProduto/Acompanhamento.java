package model.gestaoProduto;

import java.util.Date;

public class Acompanhamento extends Alimentos {
    private String tipoAcompanhamento;

    public Acompanhamento() {}
    
    public Acompanhamento(String nome, double preco, int qtdEmEstoque, String codigo, Date validade, String tipoAcompanhamento) {
        super(nome, preco, qtdEmEstoque, codigo, validade);
        this.tipoAcompanhamento = tipoAcompanhamento;
    }   

    public String getTipoAcompanhamento() {
        return tipoAcompanhamento;
    }

    public void setTipoAcompanhamento(String tipoAcompanhamento) {
        this.tipoAcompanhamento = tipoAcompanhamento;
    }
}
