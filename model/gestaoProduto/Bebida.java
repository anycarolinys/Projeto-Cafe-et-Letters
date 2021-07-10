package model.gestaoProdutos;

public class Bebida extends Alimentos {
    private String tipoBebida;

    public Bebida() {
        
    }

    public Bebida(String codigo, int qtdEmEstoque, String nome, double preco, int mesValidade, int anoValidade,
            String tipoBebida) {
        super(codigo, qtdEmEstoque, nome, preco, mesValidade, anoValidade);
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
