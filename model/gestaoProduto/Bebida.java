package model.gestaoProdutos;

public class Bebida extends Produto {
    private String tipoBebida;

    public Bebida() {
        
    }

    public Bebida(
        String codigo, 
        int qtdEmEstoque, 
        String nome, 
        double preco) {
        super(codigo, qtdEmEstoque, nome, preco);
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
                getQtdEmEstoque() + "\n" +
                getNome() + "\n" +
                getPreco() + "\n";
    }
}
