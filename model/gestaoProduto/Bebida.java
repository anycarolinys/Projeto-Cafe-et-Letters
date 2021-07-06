package model.gestaoProduto;

public class Bebida extends Alimentos {
    private String tipoBebida;

    public Bebida() {
        
    }

    public Bebida(String codigo, String nome, double preco, int qtdEmEstoque, int mesValidade, int anoValidade,
            String tipoBebida) {
        super(codigo, nome, preco, qtdEmEstoque, mesValidade, anoValidade);
        this.tipoBebida = tipoBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    
    @Override
    public String toString() {
        return getCodigo() + "\n" +
                getNome() + "\n" +
                getPreco() + "\n" +
                getQtdEmEstoque() + "\n" +
                getValidade() + "\n" +
                getTipoBebida() + "\n";
    }
}
