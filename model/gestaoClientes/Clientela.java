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
        for(int i = 0; i < getClientes().size() ; i++) 
            System.out.println(getClientes().get(i).getNome());
    }
    
    public void cadastrarCliente(String caminhoArquivo) {
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

    public void deletarCliente(File caminhoDiretorio, String CPF) throws FileNotFoundException {
        List<String> listaArquivos = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, listaArquivos);

        for (String caminhoArquivo : listaArquivos) {
            File arquivo = new File(caminhoDiretorio + "\\" + caminhoArquivo);
            
            String CPFAtual = "";

            try (                
                FileReader acessoArquivo = new FileReader(arquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
            ) {
                CPFAtual = leitorArquivo.readLine();
                if (CPFAtual.equals(CPF)) {
                    System.out.println(CPFAtual);
                    arquivo.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
    }
}