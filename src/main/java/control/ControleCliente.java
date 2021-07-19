package control;

import view.TelaAreaCliente;
import view.TelaAreaInicial;
import view.TelaCadastrarCliente;
import view.TelaClientesAtivos;
import view.TelaClientesExcluidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.gestaoClientes.Cliente;
import model.gestaoClientes.Clientela;
import model.gestaoVendas.Compra;

public class ControleCliente implements ActionListener{

    private TelaAreaCliente telaAreaCliente;
    private TelaCadastrarCliente telaCadastrarCliente;
    private TelaClientesAtivos telaClientesAtivos;
    private TelaClientesExcluidos telaClientesExcluidos;
    private Clientela clientela;
    private Cliente cliente;
    private Compra compras;
   
    public ControleCliente() {
        this.cliente = new Cliente();
        this.compras = new Compra();
        this.clientela = new Clientela();

    }   
 
    public ControleCliente(TelaAreaCliente telaAreaCliente) {
        this.telaAreaCliente = telaAreaCliente;
        
        adicionarEventosAreaCliente();
    }   
         
    public ControleCliente(TelaCadastrarCliente telaCadastrarCliente) {
        this.telaCadastrarCliente = telaCadastrarCliente;
        this.cliente = new Cliente();
        this.compras = new Compra();
        this.clientela = new Clientela();

        addEventosCadastrarCliente();
    }
 
    public ControleCliente(TelaClientesExcluidos telaClientesExcluidos) {
        this.telaClientesExcluidos = telaClientesExcluidos;
        this.cliente = new Cliente();
        this.compras = new Compra();
        this.clientela = new Clientela();

        addEventosClientesExcluidos();
    }

    public ControleCliente(TelaClientesAtivos telaClientesAtivos) {
        this.telaClientesAtivos = telaClientesAtivos;
        this.cliente = new Cliente();
        this.compras = new Compra();
        this.clientela = new Clientela();

        addEventosClientesAtivos();
    }   

    public ControleCliente(TelaAreaCliente telaAreaCliente, TelaCadastrarCliente telaCliente, TelaClientesAtivos telaClientesAtivos, TelaClientesExcluidos telaClientesExcluidos) {
        this.telaAreaCliente = telaAreaCliente;
        this.telaCadastrarCliente = telaCliente;
        this.telaClientesAtivos = telaClientesAtivos;
        this.telaClientesExcluidos = telaClientesExcluidos;
        this.clientela = new Clientela();
        this.cliente = new Cliente();
        this.compras = new Compra();
    }

   public void adicionarEventosAreaCliente(){
       /*Habilitar eventos de Área Clientes*/
        telaAreaCliente.getjBCadastrarCliente().addActionListener(this);
        telaAreaCliente.getjBClientesAtivos().addActionListener(this);
        telaAreaCliente.getjBClientesExcluidos().addActionListener(this);
        telaAreaCliente.getjBExcluirCliente().addActionListener(this);
        telaAreaCliente.getjBVoltar().addActionListener(this);    
       
   }

   public void addEventosCadastrarCliente(){
           /*Habilitar eventos da Tela de Cadastro do Cliente*/
        telaCadastrarCliente.getjBcadastrar().addActionListener(this);
        telaCadastrarCliente.getjBvoltar().addActionListener(this);
   }
   
   public void addEventosClientesAtivos(){
       /*Habilitar eventos da Tela de Clientes Ativos*/
        telaClientesAtivos.getjBVoltar().addActionListener(this);
        telaClientesAtivos.getjBEditar().addActionListener(this);
        telaClientesAtivos.getjBExcluir().addActionListener(this);
        
   }
   
   public void addEventosClientesExcluidos(){
        /*Habilitar eventos da Tela de Clientes Excluídos*/
        telaClientesExcluidos.getjBVoltar().addActionListener(this);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
       /*Eventos de Área Clientes*/

       try{
        if(e.getSource() == telaAreaCliente.getjBCadastrarCliente()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaCadastrarCliente().setVisible(true);
            new TelaCadastrarCliente().dispose();
            
        } if(e.getSource() == telaAreaCliente.getjBClientesAtivos()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaClientesAtivos().setVisible(true);
            new TelaClientesAtivos().dispose();
            
        } if(e.getSource() == telaAreaCliente.getjBClientesExcluidos()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaClientesExcluidos().setVisible(true);
            new TelaClientesExcluidos().dispose();
            
        } if(e.getSource() == telaAreaCliente.getjBExcluirCliente()){ /*Realizar um painel de busca? Tela nova ou aproveitar tela de clientes ativos?*/
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaClientesAtivos().setVisible(true);
            new TelaClientesAtivos().dispose();
            
        } if(e.getSource() == telaAreaCliente.getjBVoltar()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }
        
              }catch(Exception f){
           System.out.println("Erro em eventos controle cliente de Area Cliente");
       }
        
     try{

        /*Tela Cadastrar Cliente*/
        if(e.getSource() == telaCadastrarCliente.getjBcadastrar()){
            //Implementar passagem de dados para control onde irá inserir a venda realizada nos arquivos
             System.out.println("Pressionou botao cadastrar");

            if(validaCampos()){
              System.out.println("Validou campos");
              cadastrarCliente();
            }else{
                JOptionPane.showMessageDialog(telaCadastrarCliente, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
            }
            
        }else if(e.getSource() == telaCadastrarCliente.getjBvoltar()){
            telaCadastrarCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
        }
        
     }catch(Exception f){
           System.out.println("Erro em eventos controle cliente em tela clientes cadastrar");

     }
        
        try{
        /*Eventos da Tela de Clientes Ativos*/
         if(e.getSource() == telaClientesAtivos.getjBVoltar()){
            telaClientesAtivos.setVisible(false);
            
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
            
        }else if(e.getSource() == telaClientesAtivos.getjBEditar()){
            
            
        }else if(e.getSource() == telaClientesAtivos.getjBExcluir()){
            
            
        }
        }catch(Exception f){
           System.out.println("Erro em eventos controle cliente em tela clientes ativos");

        }
  
        try{
        /*Eventos da Tela de Clientes Excluídos*/
        if(e.getSource() == telaClientesExcluidos.getjBVoltar()){
            telaClientesExcluidos.setVisible(false);
            
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
            
        }
        }catch(Exception f){
            System.out.println("Erro em eventos controle cliente em tela clientes excluidos");
        }
    }

    public boolean validaCampos(){
       if (telaCadastrarCliente.getjTNome().toString().equals("") || telaCadastrarCliente.getjTCPF().toString().equals("")){
           return false;
       }else{
           return true;

       }
    }
    
    public void cadastrarCliente(){
        //Main
        //clientela.instanciarClienteArquivo(SMALL_ICON);
        //clientela.instanciarClienteObjeto(telaCadastrarCliente, true);
        System.out.println("Cadastrar cliente");
        cliente.setNome(telaCadastrarCliente.getjTNome().getText());
        cliente.setCPF(telaCadastrarCliente.getjTCPF().getText());
        
        //compras.setProduto(produto);
        cliente.setCompras(compras);
        
        clientela.cadastrarCliente(cliente, true);
        JOptionPane.showMessageDialog(telaCadastrarCliente, "Cliente cadastrado com sucesso");
    }
    
    public void listarClientesAtivos(){ //Inserir elementos em clientes ativos
        //clientela.listarClientesAtivos();
    }
    
    public void editarCliente(){ //chamar telaCadastrarCliente e carregar os dados lá para serem alterados
        
    }
    
    public void listarClientesExcluidos(){ //Inserir elementos em clientes excluídos
        
    }
    
    public void excluirCliente(){
        
    }
    
}
