package model.gestaoProduto;

public class Livro extends Autoria {

    public Livro() {}
    
    public Livro(String nome, double preco, int qtdEmEstoque, String codigo, String ISBN, String editora, int anoPublicacao,
            String genero, String autor) {
        super(nome, preco, qtdEmEstoque, codigo, ISBN, editora, anoPublicacao, genero, autor);
    }
    



}
