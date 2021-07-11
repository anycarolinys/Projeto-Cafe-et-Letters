package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaAreaInicial;

import view.TelaCadastrarProduto;
import view.TelaEstoque;
import model.gestaoProduto.*;

public class ControleProdutos implements ActionListener{
    private TelaCadastrarProduto telaProduto;
    private TelaEstoque telaEstoque;
    private ArquivosProdutos arquivosProdutos; //Como implementar e chamar os métodos aqui
    
    public ControleProdutos() {
    }

    public ControleProdutos(TelaCadastrarProduto telaProduto, TelaEstoque telaEstoque) {
        this.telaProduto = telaProduto;
        this.telaEstoque = telaEstoque;
        
        adicionaEventos();
    }

    public void adicionaEventos(){
        telaProduto.getjCBTipo().addActionListener(this); //Conferir se precisará de mais algum tratamento
        telaProduto.getjBVoltar().addActionListener((ActionListener) this);
        telaProduto.getjBRegistrar().addActionListener(this);
        
        telaEstoque.getjBVoltar().addActionListener(this);
        telaEstoque.getjBEditar().addActionListener(this);
        telaEstoque.getjBExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Eventos em Tela Produto
        if(e.getSource() == telaProduto.getjBRegistrar()){
            //Implementar passagem de dados para control onde irá inserir a venda realizada nos arquivos
            
            if(validarDados()){
              cadastrarProduto();
            }else{
                JOptionPane.showMessageDialog(telaEstoque, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
            }
            
        }else if(e.getSource() == telaProduto.getjBVoltar()){
            telaProduto.setVisible(false);
            
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }
         
        //Eventos em Tela Estoque
        if(e.getSource() == telaEstoque.getjBVoltar()){
            telaEstoque.setVisible(false);
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
            
        }else if(e.getSource() == telaEstoque.getjBEditar()){
            
        }else if(e.getSource() == telaEstoque.getjBExcluir()){
            
        }
    }
    
    public boolean validarDados(){
        return !(telaProduto.getjTNomeProduto().toString().equals("") || 
                telaProduto.getjTCodProduto().toString().equals("") ||
                telaProduto.getjTqtdNoEstoque().toString().equals("") ||
                telaProduto.getjFPreco().toString().equals("") ||
                telaProduto.getjCBTipo().getActionCommand().equals(""));
    }
    
    public void cadastrarProduto(){
        //arquivosProdutos.inicializarProdutos(caminhoArquivo);
        //arquivosProdutos.instanciarProdutoArquivo(caminhoArquivo);
        //arquivosProdutos.instanciarProdutoObjeto(telaProduto, true);
        
        if(telaProduto.getjCBTipo().getActionCommand().equals("Bebida")){ 
            //arquivosProdutos.instanciarBebidaObjeto(this, true);
            
        }if(telaProduto.getjCBTipo().getActionCommand().equals("Acompanhamento")){ 
            //arquivosProdutos.instanciarAcompanhamentoObjeto(telaProduto, true);
            
        }if(telaProduto.getjCBTipo().getActionCommand().equals("Livro")){ 
            //arquivosProdutos.instanciarLivroObjeto(this, true);
            
        }if(telaProduto.getjCBTipo().getActionCommand().equals("HQ")){ 
            //arquivosProdutos.instanciarHQObjeto(this, true);
            
        }if(telaProduto.getjCBTipo().getActionCommand().equals("Revista")){ 
            //arquivosProdutos.instanciarRevistaObjeto(this, true);
        }
    }
  
    /*Implementar funções relativas a Tela Estoque*/
    
    public void listarEstoque(){
        arquivosProdutos.listarProdutosCadastrados();
        //Transferir elementos para JList de Tela Estoque
    }  
    
    public void editarProduto(){ //TelaEstoque
            //arquivosProdutos.lerArquivo(caminho);
            //arquivosProdutos.escreverArquivo(caminho, conteudo);
    }
    
    public void excluirProduto(){ //TelaEstoque
        
    }
}
