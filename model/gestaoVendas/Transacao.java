package model.gestaoVendas;
import model.gestaoClientes.*;

import java.io.*;

public class Transacao {
    
    public Transacao() {
    }

    public void cadastroCompra(Cliente cliente, Clientela clientela, Compra compra) {

        boolean isCadastrado = clientela.isPrimeiraCompra(cliente.getCPF());
        File diretorioCompras = new File("./src/model/gestaoClientes/comprasCadastradas");
        
        if (isCadastrado) { 
            cadastrarCompra(cliente.getCPF(), diretorioCompras, compra);
            cliente.setCompras(compra);
        } else {
            File diretorioCompraCliente = new File("./src/model/gestaoClientes/comprasCadastradas" + cliente.getCPF());
            diretorioCompraCliente.mkdir();
            cadastrarCompra(cliente.getCPF(), diretorioCompras, compra);
            cliente.setCompras(compra);
        }
    }

    public void cadastrarCompra(String CPF, File diretorioGeralCompras, Compra compra) {

        File diretorioCompraCliente = new File(diretorioGeralCompras + "\\" + CPF);

        String nomeArquivoCompra = Integer.toString(compra.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(diretorioCompraCliente + "\\" + nomeArquivoCompra + ".txt");
                BufferedWriter buffer = new BufferedWriter(acessoArquivo);) {
                buffer.write(compra.getProduto().getNome());
                buffer.newLine();

                buffer.write(Integer.toString(compra.getQuantidadeProduto()));
                buffer.newLine();

                buffer.write(compra.getProduto().getCodigo());
                buffer.newLine();

                buffer.write(Double.toString(compra.getValorTotal()));
                buffer.newLine();

                buffer.write(Double.toString(compra.getValorPago()));
                buffer.newLine();

                buffer.write(Double.toString(compra.getTroco()));
                buffer.newLine();

                buffer.write(compra.getData().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}