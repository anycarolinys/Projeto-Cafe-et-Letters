package model.gestaoProduto;

public class HQ extends Autoria {

    public HQ() {}
    
    public HQ(String nome, double preco, int qtdEmEstoque, String codigo, String iSBN, String editora,
            int anoPublicacao, String genero, String autor) {
        super(nome, preco, qtdEmEstoque, codigo, iSBN, editora, anoPublicacao, genero, autor);
    }

}
