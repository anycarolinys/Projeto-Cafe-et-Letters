package control;

import java.text.ParseException;
import java.io.*;
import java.util.*;

import model.gestaoVendas.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Estoque estoque = new Estoque();
        // Passando pasta onde os arquivos estao localizados
        File diretorioArquivos = new File("./src/control/produtosCadastrados");

        // Criando array
        List<String> arquivosDeProdutos = new ArrayList<>();
        estoque.findAllFilesInFolder(diretorioArquivos, arquivosDeProdutos);
        System.out.println(arquivosDeProdutos);

        for (String nomeArquivo : arquivosDeProdutos) {
            // Arquivos.lerArquivo(diretorioArquivos.toString() + '\\' + nomeArquivo);
            estoque.instanciaProduto(diretorioArquivos.toString() + '\\' + nomeArquivo);
        }   

        // estoque.listarProdutosCadastrados();

    }
}
