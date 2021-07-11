package model.gestaoVendas;
// import model.gestaoProdutos.*;
import model.gestaoClientes.*;

import java.io.File;
// import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        
        Clientela clientela = new Clientela();
        File diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        List<String> arquivosClientes = new ArrayList<>();
        
        clientela.percorrerArquivosEmPasta(diretorioClientes, arquivosClientes);
        for (String caminhoArquivo : arquivosClientes) {
            clientela.instanciarClienteArquivo(diretorioClientes + "/" + caminhoArquivo);
        }

        clientela.listarClientesAtivos();
        
        Estoque estoque = new Estoque();
        File diretorioProdutos = new File("./src/model/gestaoProdutos/produtosCadastrados");
        List<String> arquivosProdutos = new ArrayList<>();

        estoque.percorrerArquivosEmPasta(diretorioProdutos, arquivosProdutos);
        for (String caminhoArquivo : arquivosProdutos) {
            estoque.instanciarProdutoArquivo(diretorioProdutos + "/" + caminhoArquivo);
        }

        estoque.listarProdutosCadastrados();

        Compra compra = new Compra(30, 30, estoque.getProdutos().get(0), 2);
        Compra compra2 = new Compra(30, 30, estoque.getProdutos().get(2), 2);
        
        Cliente cliente1 = clientela.getClientes().get(0);
        System.out.println(cliente1.getNome());
        Transacao transacao = new Transacao();
        transacao.cadastrarCompra(clientela.getClientes().get(0), compra); 
        transacao.cadastrarCompra(clientela.getClientes().get(0), compra2); 

        estoque.atualizar();

        estoque.listarProdutosCadastrados();
    }

}