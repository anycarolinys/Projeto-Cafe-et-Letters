package model.gestaoProdutos;


public class Alimentos extends Produto {
    private Validade validade;

    public Alimentos() {
        this.validade = new Validade();
    }
    
    public Alimentos(String codigo, int qtdEmEstoque, String nome, double preco, int mesValidade, int anoValidade) {
        super(codigo, qtdEmEstoque, nome, preco);
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