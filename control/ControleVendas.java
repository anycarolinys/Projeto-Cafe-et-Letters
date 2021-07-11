package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.gestaoVendas.*;
import view.TelaAreaInicial;
import view.TelaCadastrarVenda;

public class ControleVendas implements ActionListener{
  
    private ArquivosVendas arquivosVendas;
    private TelaCadastrarVenda telaCadastrarVenda;

    public ControleVendas() {
    }
        
    public ControleVendas(ArquivosVendas arquivosVendas, TelaCadastrarVenda telaCadastrarVenda) {
        this.arquivosVendas = arquivosVendas;
        this.telaCadastrarVenda = telaCadastrarVenda;
    }

  
    public void adicionarEventos(){
        telaCadastrarVenda.getjBVoltar().addActionListener(this);
        telaCadastrarVenda.getjBConcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == telaCadastrarVenda.getjBConcluir()){
            //Implementar passagem de dados para control onde irá inserir a venda realizada nos arquivos
            
            if(validarCampos()){
              cadastrarVenda();
            }else{
                JOptionPane.showMessageDialog(telaCadastrarVenda, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
            }
        }else if(e.getSource() == telaCadastrarVenda.getjBVoltar()){
            telaCadastrarVenda.setVisible(false);
            
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }

    }
    
    public boolean validarCampos(){
        if(telaCadastrarVenda.getjCBProdutosOn().getAction().toString().equals("") ||
                telaCadastrarVenda.getjTvalorPago().toString().equals("")){ //tratar
            return false;
        }else{
            return true;
        }
    }
    public void cadastrarVenda(){
        //arquivosVendas.percorrerArquivosEmPasta(pasta, arquivosCompras);
    }
    
    
}
