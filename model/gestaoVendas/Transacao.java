package model.gestaoVendas;
import model.gestaoClientes.*;

import java.io.*;

public class Transacao {
    
    public Transacao() {
    }

    public File criarDiretorioCliente(File diretorioCompra, Cliente cliente) {
        File diretorioCliente = new File(diretorioCompra.getPath() + "/" + cliente.getCPF());
        diretorioCliente.mkdir();
        return diretorioCliente;
    }

    public File buscarDiretorioCliente(File caminhoDiretorioGeral, Cliente cliente) {

        File[] diretoriosClientes  = caminhoDiretorioGeral.listFiles();
        File pastaCliente = new File("");

        for (File file : diretoriosClientes) {
            if (file.getName().equals(cliente.getCPF())) {
                pastaCliente = file;
                break;
            }
        }

        return pastaCliente;
    } 

    public void cadastroCompra(Cliente cliente, Compra compra) {

        boolean isCadastrado = cliente.isPrimeiraCompra();
        File diretorioCompras = new File("./src/model/gestaoClientes/comprasCadastradas");
        File diretorioCliente;
        
        if (isCadastrado) { 
            System.out.println("Cliente cadastrado!");
            diretorioCliente = new File(diretorioCompras.getPath() + "/" + cliente.getCPF());
            cadastrarCompra(diretorioCliente, cliente, compra);
            cliente.setCompras(compra);
        } else {
            System.out.println("Cliente não cadastrado!");
            diretorioCliente = criarDiretorioCliente(diretorioCompras, cliente);
            cadastrarCompra(diretorioCliente, cliente, compra);
            cliente.setCompras(compra);
        }
    }
    
    private void cadastrarCompra(File diretorioCliente, Cliente cliente, Compra compra) {


        String nomeArquivoCompra = Integer.toString(compra.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(new File(diretorioCliente.getPath() + "/" + nomeArquivoCompra + ".txt"));
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ){
            printer.println(compra.getProduto().getNome());
            
            printer.println(compra.getProduto().getCodigo());

            printer.println(compra.getQuantidadeProduto());

            printer.println(compra.getDataHora());

            printer.println(compra.getValorTotal());
            
            printer.print(compra.getValorPago());

        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}