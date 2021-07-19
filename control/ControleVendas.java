package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.gestaoClientes.Cliente;
import model.gestaoClientes.Clientela;
import model.gestaoProdutos.Estoque;
import model.gestaoProdutos.Produto;
import model.gestaoVendas.Compra;
import model.gestaoVendas.Transacao;
import view.TelaAreaInicial;
import view.TelaCadastrarCliente;
import view.TelaCadastrarVenda;

public final class ControleVendas implements ActionListener{
  
    private Transacao arquivosVendas;
    private Compra compra;
    private TelaCadastrarVenda telaCadastrarVenda;
    public TelaCadastrarCliente telaCadastrarCliente;
    private Cliente cliente;
    private Clientela clientela;
    private Produto produto;
    private Estoque estoque;
    
    public ControleVendas() {
    }
        
    public ControleVendas(TelaCadastrarVenda telaCadastrarVenda) {
        this.telaCadastrarVenda = telaCadastrarVenda;
        this.arquivosVendas = new Transacao();
        this.cliente = new Cliente();
        this.clientela = new Clientela();
        compra = new Compra();
        estoque = new Estoque();
        produto = new Produto() {};
 
    }

    public void adicionarEventos(){
         telaCadastrarVenda.getjBVoltar().addActionListener(this);
        telaCadastrarVenda.getjBConcluir().addActionListener(this);
        telaCadastrarVenda.getjBcadastrar().addActionListener(this);
        telaCadastrarVenda.getjBBuscarCod().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == telaCadastrarVenda.getjBBuscarCod()){
            System.out.println("Chegou  em buscar codigo opcao");
           buscaPeloCodigo();
           
        } 
        if(e.getSource() == telaCadastrarVenda.getjBConcluir()){
            //Implementar passagem de dados para control onde irá inserir a venda realizada nos arquivos
              //buscaPeloCodigo();
             System.out.println("Chegou no action performed de controle");
       
                   System.out.println("Chegou no cadastrar Cliente");
                 
                if(validarCampos1()){
                  System.out.println("Validou campos");
                  cadastrarVenda();
                  JOptionPane.showMessageDialog(telaCadastrarVenda, "Venda cadastrada com sucesso");
                }else{
                    JOptionPane.showMessageDialog(telaCadastrarVenda, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
                }
            
             } if(e.getSource() == telaCadastrarVenda.getjBVoltar()){
            telaCadastrarVenda.setVisible(false);
            
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }
              if(e.getSource() == telaCadastrarVenda.getjBVoltar()){
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
            
        }if(e.getSource() == telaCadastrarVenda.getjBcadastrar()){
            //Verificar somente campos Cliente e validar if o selected item for nao
             if(validarCampos2()){
              if(conferirSeClienteJaExiste()){
                 JOptionPane.showMessageDialog(telaCadastrarVenda, "Cliente  já estava cadastrado. ");

        }else{    
                  
                  cliente.setNome(telaCadastrarVenda.getjTNome().getText());
                  cliente.setCPF(telaCadastrarVenda.getjTCPF().getText()); 
                  cliente.setCompras(compra);
                  
                clientela.cadastrarCliente(cliente, true);
               JOptionPane.showMessageDialog(telaCadastrarVenda, "Cliente  cadastrado. ");
                         }
             }
        }

    }
    
    public boolean validarCampos1(){
        if(telaCadastrarVenda.getjTCodProduto().getText().equals("Código do produto") ||
                telaCadastrarVenda.getjTvalorPago().getText().equals("")){ //tratar
            
            
            return false;
        }else{
            return true;
        }
    }
    
    public boolean validarCampos2(){
        if(telaCadastrarVenda.getjTNome().getText().equals("") || 
                        telaCadastrarVenda.getjTCPF().getText().equals("")){ //tratar     
            return false;
        }else{
            return true;
        }
    }
    
    public void chamarTelaCliente(){
                this.telaCadastrarCliente = new TelaCadastrarCliente();
                //new TelaCadastrarCliente().setVisible(true);
                //new TelaCadastrarCliente().dispose();
                
                String[] args = {""};
                this.telaCadastrarCliente.main(args);
               this.telaCadastrarCliente.setVisible(true);
               //telaCadastrarCliente.setLocation(300, 300);
              this. telaCadastrarCliente.dispose();
    }
    
    public void buscaPeloCodigo(){ //Busca produto pelo codigo digitado
                System.out.println("Chegou valor do produto");
       
      try{
       estoque.inicializarEstoque();
       produto  = estoque.buscarProduto(telaCadastrarVenda.getjTCodProduto().getText());
 
       System.out.println("Preço: " + produto.getPreco());
       System.out.println("Produto: " + produto.toString());

        telaCadastrarVenda.getjLvalorProduto().setText(produto.getPreco()+"");
            
        }catch(Exception e ){
                       JOptionPane.showMessageDialog(telaCadastrarVenda, "Produto não cadastrado");
                       telaCadastrarVenda.getjTCodProduto().setText("");
             System.out.println("Erros na busca por produto: ");
         //   e.printStackTrace();
        }
    }
    
    public void cadastrarVenda(){
        //arquivosVendas.percorrerArquivosEmPasta(pasta, arquivosCompras);
        //Ler produtos dos produtos cadastrados e buscar pelo telaCadastrarVenda.getjCBProdutosOn().getSelectedItem();
        //Receber aqui o codigo ou a chave primaria
        
        try{
          estoque.inicializarEstoque();
        System.out.println("Chegou em cadastrar venda real");

        compra.setProduto(produto);
        compra.setDataHora();
        compra.setQuantidadeProduto(Integer.parseInt(telaCadastrarVenda.getjTqtd().getText()));
       
        compra.setValorPago(Double.parseDouble(telaCadastrarVenda.getjTValorPago().getText()));
        compra.setValorTotal(produto.getPreco()*compra.getQuantidadeProduto());
        cliente.setCompras(compra);

        System.out.println("Compra: " + compra.getValorTotal());
        
        arquivosVendas.cadastrarCompra(cliente, compra);
        estoque.inicializarEstoque();

        System.out.println("Funcionou");
        }catch(Exception e){
            System.out.println("Erro ao cadastrar");
        }
    }
    
    public boolean conferirSeClienteJaExiste(){
        if(clientela.buscarCliente(telaCadastrarVenda.getjTCPF().getText()) == null){ //Então não existe
           
            return false;
        }return true;
    }
    
    
    
}
