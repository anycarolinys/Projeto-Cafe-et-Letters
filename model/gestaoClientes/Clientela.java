package model.gestaoClientes;

import java.util.List;

import control.ArquivosClientes;

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
        for(int i = 0; i < getClientes().size() ; i++) 
            System.out.println(getClientes().get(i).getNome());
    }
    
    public void cadastrarClienteArquivo(String caminhoArquivo) {
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

    public void cadastrarClienteObjeto(Cliente cliente) {
        File diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        
        String caminhoArquivo = Integer.toString(cliente.hashCode());

        try (
            FileWriter acessoArquivo = new FileWriter(diretorioClientes + "\\" + caminhoArquivo + ".txt");
            BufferedWriter buffer = new BufferedWriter(acessoArquivo);
        ) {
            buffer.write(cliente.getCPF());
            buffer.write(cliente.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File buscarClienteParaExcluir(File caminhoDiretorio, String CPF) throws FileNotFoundException {

        List<String> arquivosClientes = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, arquivosClientes);

        File arquivo = new File("");

        for (String caminhoArquivo : arquivosClientes) {
            arquivo = new File(caminhoDiretorio + "\\" + caminhoArquivo);
            try (
                FileReader leitor = new FileReader(arquivo);
                BufferedReader buffer = new BufferedReader(leitor);
            ) {
                if (buffer.readLine().equals(CPF))
                    break;
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
        Cliente cliente = new Cliente();

        for(int i = 0; i < getClientes().size() ; i++) {
            if (getClientes().get(i).getCPF().equals(CPF)) {
                cliente = getClientes().get(i);
                break;
            }
        }

        return cliente;
    }

    public boolean isPrimeiraCompra(String CPF) {
        for (Cliente cliente : getClientes()) {
            if (cliente.getCPF().equals(CPF) && (cliente.getCompras().size() == 0))   
                return true;
        }
        return false;
    }

}