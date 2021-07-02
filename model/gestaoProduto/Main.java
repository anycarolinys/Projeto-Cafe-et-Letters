package model.gestaoProduto;

public class Main {
    public static void main(String[] args) {
        
        Autoria l1 = new Livro("Anjos e Demonios", 30, 5, "001", "85-7542-146-8", "Sextante", 2004, "Misterio", "Dan Brown");
        
        System.out.println(l1.getNome());
        System.out.println(l1.getPreco());
        System.out.println(l1.getQtdEmEstoque());
        System.out.println(l1.getISBN());
        System.out.println(l1.getEditora());
        System.out.println(l1.getAnoPublicacao());
        System.out.println(l1.getGenero());
        System.out.println(l1.getAutor());
    }
}
