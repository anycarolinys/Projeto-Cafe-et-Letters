package control;

import view.TelaAreaCliente;
import view.TelaAreaInicial;
import view.TelaCadastrarCliente;
import view.TelaClientesAtivos;
import view.TelaClientesExcluidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.gestaoClientes.Clientela;

public class ControleCliente implements ActionListener{

    private TelaAreaCliente telaAreaCliente;
    private TelaCadastrarCliente telaCadastrarCliente;
    private TelaClientesAtivos telaClientesAtivos;
    private TelaClientesExcluidos telaClientesExcluidos;
    private Clientela clientela;
    
    public ControleCliente() {
    }   
    
    public ControleCliente(TelaAreaCliente telaAreaCliente, TelaCadastrarCliente telaCliente, TelaClientesAtivos telaClientesAtivos, TelaClientesExcluidos telaClientesExcluidos, Clientela clientela) {
        this.telaAreaCliente = telaAreaCliente;
        this.telaCadastrarCliente = telaCliente;
        this.telaClientesAtivos = telaClientesAtivos;
        this.telaClientesExcluidos = telaClientesExcluidos;
        this.clientela = clientela;
    }
    
   public void adicionarEventos(){
       /*Habilitar eventos de Área Clientes*/
        telaAreaCliente.getjBCadastrarCliente().addActionListener(this);
        telaAreaCliente.getjBClientesAtivos().addActionListener(this);
        telaAreaCliente.getjBClientesExcluidos().addActionListener(this);
        telaAreaCliente.getjBExcluirCliente().addActionListener(this);
        telaAreaCliente.getjBVoltar().addActionListener(this);    
        
        /*Habilitar eventos da Tela de Cadastro do Cliente*/
        telaCadastrarCliente.getjBcadastrar().addActionListener(this);
        telaCadastrarCliente.getjBvoltar().addActionListener(this);
        
        /*Habilitar eventos da Tela de Clientes Ativos*/
        telaClientesAtivos.getjBVoltar().addActionListener(this);
        telaClientesAtivos.getjBEditar().addActionListener(this);
        telaClientesAtivos.getjBExcluir().addActionListener(this);
        
        /*Habilitar eventos da Tela de Clientes Excluídos*/
        telaClientesExcluidos.getjBVoltar().addActionListener(this);
        telaClientesExcluidos.getjBReativar().addActionListener(this);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       /*Eventos de Área Clientes*/

        if(e.getSource() == telaAreaCliente.getjBCadastrarCliente()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaCadastrarCliente().setVisible(true);
            new TelaCadastrarCliente().dispose();
            
        }else if(e.getSource() == telaAreaCliente.getjBClientesAtivos()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaClientesAtivos().setVisible(true);
            new TelaClientesAtivos().dispose();
            
        }else if(e.getSource() == telaAreaCliente.getjBClientesExcluidos()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaClientesExcluidos().setVisible(true);
            new TelaClientesExcluidos().dispose();
            
        }else if(e.getSource() == telaAreaCliente.getjBExcluirCliente()){ /*Realizar um painel de busca? Tela nova ou aproveitar tela de clientes ativos?*/
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaClientesAtivos().setVisible(true);
            new TelaClientesAtivos().dispose();
            
        }else if(e.getSource() == telaAreaCliente.getjBVoltar()){
            telaAreaCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(false);  
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }
        
        if(e.getSource() == telaCadastrarCliente.getjBcadastrar()){
            //Implementar passagem de dados para control onde irá inserir a venda realizada nos arquivos
              
            if(validaCampos()){
              cadastrarCliente();
            }else{
                JOptionPane.showMessageDialog(telaCadastrarCliente, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
            }
            
        }else if(e.getSource() == telaCadastrarCliente.getjBvoltar()){
            telaCadastrarCliente.setVisible(false);
            
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
        }
        
        /*Eventos da Tela de Clientes Ativos*/
         if(e.getSource() == telaClientesAtivos.getjBVoltar()){
            telaClientesAtivos.setVisible(false);
            
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
            
        }else if(e.getSource() == telaClientesAtivos.getjBEditar()){
            
            
        }else if(e.getSource() == telaClientesAtivos.getjBExcluir()){
            
            
        }
  
        /*Eventos da Tela de Clientes Excluídos*/
        if(e.getSource() == telaClientesExcluidos.getjBVoltar()){
            telaClientesExcluidos.setVisible(false);
            
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
            
        }else if(e.getSource() == telaClientesExcluidos.getjBReativar()){
            //Deixar o cliente disponível novamente
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
        
    }
    
    public void listarClientesAtivos(){ //Inserir elementos em clientes ativos
        clientela.listarClientesAtivos();
    }
    
    public void editarCliente(){ //chamar telaCadastrarCliente e carregar os dados lá para serem alterados
        
    }
    
    public void listarClientesExcluidos(){ //Inserir elementos em clientes excluídos
        
    }
    
    public void excluirCliente(){
        
    }
    
}
