package control;

import view.TelaCadastrarLH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import view.TelaAreaInicial;
import java.lang.String;
import java.util.List;
//import java.awt.List;
import view.TelaCadastrarProduto;
import model.gestaoProdutos.*;
import model.gestaoProdutos.Estoque;
import view.TelaEstoque1;

public final class ControleProdutos implements ActionListener{
    private TelaCadastrarProduto telaProduto;
    private TelaCadastrarLH telaProdutoLH; //= new TelaCadastrarLH();
    private TelaEstoque1 telaEstoque;
    private Estoque arquivosProdutos; //Como implementar e chamar os métodos aqui
    private Produto produto;
    
    private Bebida bebida;
    private Acompanhamento acompanhamento;
    private HQ hq;
    private Livro livro;
    private int verifica; 
    
    private   ArrayList<String> codigoprodutos;

    public ControleProdutos() {
        System.out.println("Chegou em Controle de produtos");
          this.arquivosProdutos = new Estoque();
       // telaProdutoLH = ;
        
        this.bebida = new Bebida();
        this.acompanhamento = new Acompanhamento();
        this.hq = new HQ();
        this.livro = new Livro();
        this.verifica = 0;
        adicionaEventos();
    }  

    public ControleProdutos(TelaCadastrarProduto telaProduto) {
        this.telaProduto = telaProduto;
        this.arquivosProdutos = new Estoque();
       // telaProdutoLH = ;
        
        this.bebida = new Bebida();
        this.acompanhamento = new Acompanhamento();
        this.hq = new HQ();
        this.livro = new Livro();
        this.verifica = 0;
        adicionaEventos();
    }
    
        public ControleProdutos(TelaEstoque1 telaestoque) {
        this.telaEstoque = telaestoque;
        this.arquivosProdutos = new Estoque();
  
        adicionaEventosEstoque();
        //listarEstoque();
    }
  
  
    public ControleProdutos(TelaCadastrarProduto telaProduto, TelaEstoque1 telaEstoque, Estoque arquivosProdutos, Produto produto, Bebida bebida, Acompanhamento acompanhamento, HQ hq, Livro livro) {
        this.telaProduto = telaProduto;
        this.telaEstoque = telaEstoque;
        this.produto = produto;
    }

    public void adicionaEventos(){
        telaProduto.getjCBTipo().addActionListener(this); //Conferir se precisará de mais algum tratamento
        telaProduto.getjBVoltar().addActionListener((ActionListener) this);
        telaProduto.getjBRegistrar().addActionListener(this);
    }
    
      public void adicionaEventosEstoque(){
        telaEstoque.getjBVoltar().addActionListener(this);
       // telaEstoque.getjBEditar().addActionListener(this);
        telaEstoque.getjBExcluir().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
        //Eventos em Tela Produto
        if(e.getSource() == telaProduto.getjBRegistrar()){
            
            if(telaProduto.getjCBTipo().getSelectedItem().equals("Livro") || telaProduto.getjCBTipo().getSelectedItem().equals("HQ") ){    
                chamartelaLH();
            }else{
                  if(validarDados1()){
                    cadastrarProduto();
                  }else{
                      JOptionPane.showMessageDialog(telaProduto, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
            }
            }
            
        }else if(e.getSource() == telaProduto.getjBVoltar()){
            telaProduto.setVisible(false);
            
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
            
        }if(e.getSource() == telaProdutoLH.getjBCadastrar()){  //Cadastrar em LH
              System.out.println("Chegou em cadastrar LH");
            if(validarDados2()){
              cadastrarProduto();
            }else{
                JOptionPane.showMessageDialog(telaProduto, "Campo(s) em branco. Todos os campos precisam estar preenchidos");
            }
        }
         
        //Eventos em Tela Estoque
        if(e.getSource() == telaEstoque.getjBVoltar()){
            telaEstoque.setVisible(false);
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
            
        }//else if(e.getSource() == telaEstoque.getjBEditar()){
            
        //}
        else if(e.getSource() == telaEstoque.getjBExcluir()){
            
        }
        }catch(Exception ex){
            
        }
    }
    
    public void chamartelaLH(){
                 telaProdutoLH.setVisible(true);
                telaProdutoLH.main(new String[0]);
                telaProdutoLH.dispose();
                
    }
    
    public boolean validarDados1(){
        return !(telaProduto.getjTNomeProduto().getText().equals("") || 
                telaProduto.getjTCodProduto().getText().equals("") ||
                telaProduto.getjTqtdNoEstoque().getText().equals("") ||
                telaProduto.getjFPreco().getText().equals("") ||
                telaProduto.getjCBTipo().getSelectedItem().equals("Selecione a opção desejada"));
    }
    
    public boolean validarDados2(){
        return !(telaProdutoLH.getjTAutor().getText().equals("") || 
                telaProdutoLH.getjTISBN().getText().equals("") ||
                telaProdutoLH.getjTAno().getText().equals("") ||
                telaProdutoLH.getjTEditora().getText().equals("") ||
                telaProdutoLH.getjCGenero().getSelectedItem().equals("Selecione"));
    }
    
    public void cadastrarProduto(){
          
        try{
        if(telaProduto.getjCBTipo().getSelectedItem().equals("Bebida")){ 
            bebida.setNome(telaProduto.getjTNomeProduto().getText());
            bebida.setCodigo(telaProduto.getjTCodProduto().getText());
            bebida.setQtdEmEstoque(Integer.parseInt(telaProduto.getjTqtdNoEstoque().getText()));
            bebida.setPreco(Double.parseDouble(telaProduto.getjFPreco().getText()));
            
            System.out.println(bebida.toString());
            
            arquivosProdutos.instanciarBebidaObjeto(bebida, true);
            System.out.println("Funcionou");
            
        }if(telaProduto.getjCBTipo().getSelectedItem().equals("Acompanhamento")){ 
            
            acompanhamento.setNome(telaProduto.getjTNomeProduto().getText());
            acompanhamento.setCodigo(telaProduto.getjTCodProduto().getText());
            acompanhamento.setQtdEmEstoque(Integer.parseInt(telaProduto.getjTqtdNoEstoque().getText()));
            acompanhamento.setPreco(Double.parseDouble(telaProduto.getjFPreco().getText()));
           
            arquivosProdutos.instanciarAcompanhamentoObjeto(acompanhamento, true);
            
        }if(telaProduto.getjCBTipo().getSelectedItem().equals("Livro")){
    
            
            livro.setNome(telaProduto.getjTNomeProduto().getText());
            livro.setCodigo(telaProduto.getjTCodProduto().getText());
            livro.setQtdEmEstoque(Integer.parseInt(telaProduto.getjTqtdNoEstoque().getText())); //É a quantidade que sera comprada ou terei q fazer uma busca no estoque?
            livro.setPreco(Double.parseDouble(telaProduto.getjFPreco().getText()));
//            
//          telaProdutoLH.setVisible(true);
//          telaProdutoLH.main(new String[0]);
//          telaProdutoLH.dispose();
//         
            chamartelaLH();
            livro.setEditora(telaProdutoLH.getjTISBN().getText());
            livro.setISBN(telaProdutoLH.getjTISBN().getText());
            livro.setAutor(telaProdutoLH.getjTAutor().getText());
            livro.setAnoPublicacao(Integer.parseInt(telaProdutoLH.getjTAno().getText()));
            livro.setGenero(telaProdutoLH.getjCGenero().getSelectedItem().toString());
            
            arquivosProdutos.instanciarLivroObjeto(livro, true);
  
          JOptionPane.showMessageDialog(telaProdutoLH, "Livro cadastrado com sucesso!");

        }if(telaProduto.getjCBTipo().getSelectedItem().equals("HQ")){

            hq.setNome(telaProduto.getjTNomeProduto().getText());
            hq.setCodigo(telaProduto.getjTCodProduto().getText());
            hq.setQtdEmEstoque(Integer.parseInt(telaProduto.getjTqtdNoEstoque().getText()));
            hq.setPreco(Double.parseDouble(telaProduto.getjFPreco().getText()));
              
//           telaProdutoLH.setVisible(true);
//           telaProdutoLH.main(new String[0]);
//           telaProdutoLH.dispose();
           
            hq.setEditora(telaProdutoLH.getjTISBN().getText());
            hq.setISBN(telaProdutoLH.getjTISBN().getText());
            hq.setAutor(telaProdutoLH.getjTAutor().getText());
            hq.setAnoPublicacao(Integer.parseInt(telaProdutoLH.getjTAno().getText()));
            hq.setGenero(telaProdutoLH.getjCGenero().getSelectedItem().toString());
            
            arquivosProdutos.instanciarHQObjeto(hq, true);
            
        }/**/
        
        JOptionPane.showMessageDialog(telaProdutoLH, "Produto cadastrado com sucesso!");
        limparCampos();
        }catch(NullPointerException n){
            System.out.print("Erroooooo: ");
            n.printStackTrace();
            
        }
}
  
    public void limparCampos(){
        telaProduto.getjTCodProduto().setText("");
        telaProduto.getjTNomeProduto().setText("");
        telaProduto.getjFPreco().setText("");
        telaProduto.getjCBTipo().setSelectedIndex(1);
        telaProduto.getjTqtdNoEstoque().setText("");
               

    }
    /*Implementar funções relativas a Tela Estoque*/
    
    public String[] listarEstoque(){
        List<Produto> produtos;
        
        produtos = arquivosProdutos.getProdutos(); //Funcionou
        ArrayList<String> nomesprodutos;
        nomesprodutos = new ArrayList();
        
        codigoprodutos = new ArrayList(); //Códigos dos produtos disponíveis deverão ser 
        
        int x = produtos.size();
        String[] nomes = new String[x];
        
        for(int i=0; i<produtos.size(); i++){
            nomes[i] = produtos.get(i).getNome();
            System.out.println("Array de string: " + nomes[i]);
            nomesprodutos.add(produtos.get(i).getNome());
            codigoprodutos.add(produtos.get(i).getCodigo());
        }
        
                arquivosProdutos.listarProdutosCadastrados();
                return nomes;
        
 /*       JList<String> nomesprodutos;
        nomesprodutos = new JList(); //Funcionou, porem está vazio
        
        DefaultListModel<String> teste;
       
        DefaultListModel<String> df = new DefaultListModel<>();
         telaEstoque.getjListaEstoque().setValueIsAdjusting(true);

        for(int i=0; i<produtos.size(); i++){
          
               df.addElement(produtos.get(i).getNome());
        }
         telaEstoque.getjListaEstoque().setName("hello world");

        nomesprodutos.setModel(df); 
        //= df.getElementAt(1);
        System.out.println("" + df);
        telaEstoque.getjListaEstoque().setModel(df);*/
       
//        arquivosProdutos.listarProdutosCadastrados();
        //Transferir elementos para JList de Tela Estoque*/
    }  
    
}
