package model.gestaoProdutos;

// import java.io.File;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
import java.text.ParseException;
// import java.util.*;

// import model.gestaoVendas.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        // Estoque estoque = new Estoque();
        // Passando pasta onde os arquivos estao localizados
        // File diretorioArquivos = new File("./src/model/gestaoProdutos/produtosCadastrados");

        // Criando array
        // List<String> arquivosDeProdutos = new ArrayList<>();
        // estoque.percorrerArquivosEmPasta(diretorioArquivos, arquivosDeProdutos);
        // System.out.println(arquivosDeProdutos);

        /* for (String nomeArquivo : arquivosDeProdutos) {
            estoque.instanciaProduto(diretorioArquivos.toString() + '\\' + nomeArquivo);
        } */
        // String codigo = "0006";
        // try {
            // File arquivo = estoque.procurarArquivoProduto(diretorioArquivos, codigo);
            // System.out.println(arquivo.getPath());
            // estoque.excluirProdutoArquivo(arquivo);
        // } catch (FileNotFoundException e) {
            // e.printStackTrace();
        // }

/*         Livraria livro = new Livro("001", "Nome de Livro", 30.90, 5, "8416341854186", "Sextante", 1990, "Crime", "Vladimir Nabokov");
        estoque.instanciarProdutoObjeto(livro);

        Livraria hq = new HQ("002", "Nome de HQ", 30.90, 5, "8416341854186", "Sextante", 1990, "Crime", "Vladimir Nabokov");
        estoque.instanciarProdutoObjeto(hq);
        
        Livraria revista = new Revista("003", "Vogue", 20, 10, "564156416651", "Vogue Inc", 2021, "Moda", "Vogue") ;
        estoque.instanciarProdutoObjeto(revista);

        Alimentos acompanhamento = new Acompanhamento("004", "Nutella", 6, 30, 07, 2021, "Cookie");
        estoque.instanciarProdutoObjeto(acompanhamento);

        Alimentos bebida = new Bebida("005", "Verde", 3, 30, 8, 2022, "Chá");
        estoque.instanciarProdutoObjeto(bebida);

        estoque.listarProdutos(); */
        

/*         try (
                FileWriter arquivo = new FileWriter(new File("./src/model/gestaoProdutos/produtosCadastrados/novoProduto.txt"));
                PrintWriter gravador = new PrintWriter(arquivo);
                ) { 
                    gravador.println("LIVRO");

                    gravador.println(livro.getCodigo());
        
                    gravador.println(livro.getNome());
                    
                    gravador.println(Double.toString(livro.getPreco()));
        
                    gravador.println(Integer.toString(livro.getQtdEmEstoque()));
        
                    gravador.println(livro.getISBN());
        
                    gravador.println(livro.getEditora());
        
                    gravador.println(Integer.toString(livro.getAnoPublicacao()));
        
                    gravador.println(livro.getGenero());
        
                    gravador.print(livro.getAutor());

        } catch (IOException e) {
            e.printStackTrace();
        } */

    }
}
