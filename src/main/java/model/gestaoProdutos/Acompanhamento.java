package model.gestaoProdutos;

public class Acompanhamento extends Produto {
    private String tipoAcompanhamento;

    public Acompanhamento() {
    }

    public Acompanhamento(
    String codigo,
    int qtdEmEstoque, 
    String nome, 
    double preco) {
        super(codigo, qtdEmEstoque, nome, preco);
    }

    public String getTipoAcompanhamento() {
        return tipoAcompanhamento;
    }

    public void setTipoAcompanhamento(String tipoAcompanhamento) {
        this.tipoAcompanhamento = tipoAcompanhamento;
    }

    @Override
    public String toString() {
        return getCodigo() + "\n" +
                getQtdEmEstoque() + "\n" +
                getNome() + "\n" +
                getPreco() + "\n";
    }
}
