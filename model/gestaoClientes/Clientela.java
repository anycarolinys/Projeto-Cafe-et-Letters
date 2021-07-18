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

    private void removerCliente(Cliente cliente) {
        getClientes().remove(cliente);
    }

    public void inicializarClientes() {
        getClientes().clear();

        File diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        List<String> nomeArquivos = new ArrayList<>();
        percorrerArquivosEmPasta(diretorioClientes, nomeArquivos);

        for (String arquivoCliente : nomeArquivos) {
            instanciarClienteArquivo(diretorioClientes.getPath() + "/" + arquivoCliente);
        }
    }

    private void instanciarClienteArquivo(String caminhoArquivo) {
        Cliente cliente = new Cliente();

        try (FileReader acessoArquivo = new FileReader(caminhoArquivo);
                BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);) {

            cliente = new Cliente(leitorArquivo.readLine(), leitorArquivo.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        setClientes(cliente);
    }

    public void cadastrarCliente(Cliente cliente, boolean pasta) {
        File diretorioClientes;
        if (pasta == true)
            diretorioClientes = new File("./src/model/gestaoClientes/clientesCadastrados");
        else
            diretorioClientes = new File("./src/model/gestaoClientes/clientesExcluidos");

        String caminhoArquivo = Integer.toString(cliente.hashCode());

        try (FileWriter acessoArquivo = new FileWriter(diretorioClientes + "\\" + caminhoArquivo + ".txt");
                PrintWriter printer = new PrintWriter(acessoArquivo);) {
            printer.println(cliente.getCPF());
            printer.print(cliente.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(String CPF) {

        File caminhoDiretorio = new File("./src/model/gestaoClientes/clientesCadastrados");
        List<String> arquivosClientes = new ArrayList<>();
        percorrerArquivosEmPasta(caminhoDiretorio, arquivosClientes);

        File arquivo = null;

        Cliente clienteExcluido;

        for (String caminhoArquivo : arquivosClientes) {
            arquivo = new File(caminhoDiretorio + "\\" + caminhoArquivo);
            try (FileReader leitor = new FileReader(arquivo); BufferedReader buffer = new BufferedReader(leitor);) {
                if (buffer.readLine().equals(CPF)) {
                    clienteExcluido = buscarCliente(CPF);
                    cadastrarCliente(clienteExcluido, false);
                    removerCliente(clienteExcluido);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        arquivo.delete();
    }

    private Cliente buscarCliente(String CPF) {

        for (Cliente cliente : getClientes()) {
            if (cliente.getCPF().equals(CPF))
                return cliente;
        }

        return null;
    }

    public List<String> listarClientesCadastrados() {
        List<String> nomeClientes = new ArrayList<>();

        for (Cliente cliente : getClientes()) {
            nomeClientes.add(cliente.getNome());
        }
        return nomeClientes;
    }

    public List<String> listarClientesExcluidos() {
        List<String> nomeClientes = new ArrayList<>();
        List<String> arquivosClientes = new ArrayList<>();
        File diretorio = new File("./src/model/gestaoClientes/clientesExcluidos");

        percorrerArquivosEmPasta(diretorio, arquivosClientes);
        for (String caminhoArquivo : arquivosClientes) {
            try (FileReader leitorArquivo = new FileReader(diretorio + "/" + caminhoArquivo);
                    BufferedReader buffer = new BufferedReader(leitorArquivo);) {
                buffer.readLine(); // CPF do Cliente
                nomeClientes.add(buffer.readLine()); // Nome do cliente
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nomeClientes;
    }

    public List<String> listarComprasClientes(String CPF) {
        List<String> arquivosCompras = new ArrayList<>();
        List<String> compras = new ArrayList<>();

        File diretorioCompras = new File("./src/model/gestaoClientes/comprasCadastradas");
        File[] comprasCliente = diretorioCompras.listFiles();

        for (File pastaCliente : comprasCliente) {
            if (pastaCliente.getName().equals(CPF)) {
                percorrerArquivosEmPasta(pastaCliente, compras);
                for (String nomeArquivo : compras) {
                    try (FileReader leitor = new FileReader(diretorioCompras.getPath() + "/" + CPF + "/" + nomeArquivo);
                            BufferedReader buffer = new BufferedReader(leitor);) {
                        String nomeProduto = buffer.readLine(); // Nome do produto
                        buffer.readLine(); // Codigo do produto
                        buffer.readLine(); // Quantidade comprada
                        String dataHora = buffer.readLine(); // Data e hora da compra
                        arquivosCompras.add(nomeProduto + " (" + dataHora + ")");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return arquivosCompras;
    }
}