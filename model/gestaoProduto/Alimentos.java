package model.gestaoProduto;


public class Alimentos extends Produto {
    private Validade validade;

    public Alimentos() {
        this.validade = new Validade();
    }
    
    public Alimentos(String codigo, String nome, double preco, int qtdEmEstoque, int mesValidade, int anoValidade) {
        super(codigo, nome, preco, qtdEmEstoque);
        this.validade = new Validade(mesValidade, anoValidade);
    }

    public String getValidade() {
        return validade.getMes() + "/" + validade.getAno();
    }

    public void setValidade(int mes, int ano) {
        this.validade.setMes(mes);
        this.validade.setAno(ano);
    }

    @Override
    public String toString() {
        return "Alimentos [validade=" + validade + "]";
    }

}