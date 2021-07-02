package model.gestaoProduto;

import java.util.Date;

public class Alimentos extends Produto {
    private Date validade;

    public Alimentos() {}
    
    public Alimentos(String nome, double preco, int qtdEmEstoque, String codigo, Date validade) {
        super(nome, preco, qtdEmEstoque, codigo);
        this.validade = validade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

}
