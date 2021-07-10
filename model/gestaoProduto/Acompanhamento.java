package model.gestaoProdutos;

public class Acompanhamento extends Alimentos {
    private String tipoAcompanhamento;

    public Acompanhamento() {
    }

    public Acompanhamento(
    String codigo,
    int qtdEmEstoque, 
    String nome, 
    double preco, 
    int mesValidade, 
    int anoValidade,
    String tipoAcompanhamento) {
        super(codigo, qtdEmEstoque, nome, preco, mesValidade, anoValidade);
        this.tipoAcompanhamento = tipoAcompanhamento;
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
                getNome() + "\n" +
                getPreco() + "\n" +
                getQtdEmEstoque() + "\n" +
                getValidade() + "\n" +
                getTipoAcompanhamento() + "\n";
    }
}
