package model.gestaoClientes;

import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class Clientela implements ArquivosClientes {

    private List<Cliente> clientes;

    public Clientela() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void listarClientesAtivos(){
        for (Cliente cliente : getClientes()) {
            System.out.println(cliente.getNome());
        }
    }

    public void removerCliente(Cliente cliente) {
        getClientes().remove(cliente);
    }
    
    public void instanciarClienteArquivo(String caminhoArquivo) {
        Cliente cliente = new Cliente();
        
        try (
                FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
        ) {
            
            cliente = new Cliente(
                leitorArquivo.readLine(),
                leitorArquivo.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        setClientes(cliente);
    }

    public void instanciarClienteObjeto(Cliente cliente, boolean pasta) {
        File diretorioClientes;
        if (pasta == true)
            diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        else
            diretorioClientes = new File("./src/model/gestaoClientes/clientesExcluidos");
        
        String caminhoArquivo = Integer.toString(cliente.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(diretorioClientes + "\\" + caminhoArquivo + ".txt");
            PrintWriter printer = new PrintWriter(acessoArquivo);
        ) {
            printer.println(cliente.getCPF());
            printer.print(cliente.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File buscarClienteParaExcluir(File caminhoDiretorio, String CPF) throws FileNotFoundException {

        List<String> arquivosClientes = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, arquivosClientes);

        File arquivo = null;

        Cliente clienteExcluido; 

        for (String caminhoArquivo : arquivosClientes) {
            arquivo = new File(caminhoDiretorio + "\\" + caminhoArquivo);
            try (
                FileReader leitor = new FileReader(arquivo);
                BufferedReader buffer = new BufferedReader(leitor);
            ) {
                if (buffer.readLine().equals(CPF)) {
                    clienteExcluido = buscarCliente(CPF);
                    instanciarClienteObjeto(clienteExcluido, false);
                    removerCliente(clienteExcluido);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return arquivo;
    }

    public boolean excluirCliente(File caminhoArquivo) {
        return caminhoArquivo.delete();
    }

    public Cliente buscarCliente(String CPF) {

        for (Cliente cliente : getClientes()) {
            if (cliente.getCPF().equals(CPF))
                return cliente;
        }

        return null;
    }

}