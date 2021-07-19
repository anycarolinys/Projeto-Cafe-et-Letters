package view;

import control.ControleProdutos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import model.gestaoProdutos.Estoque;
import model.gestaoProdutos.Produto;

public final class TelaEstoque1 extends javax.swing.JFrame implements ActionListener{

    //private final ControleProdutos cp;
    private Estoque estoque;
    private List<Produto> produtosNoEstoque;
     private List<String> produtosNoEstoque2;
     
    public TelaEstoque1() {
        initComponents();
        adicionarEventos();
        this.estoque = new Estoque();
       // cp = new ControleProdutos();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBTipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jLlogo = new javax.swing.JLabel();
        listProdutos = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 2, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estoque de produtos");

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cadastrados", "Disponíveis", "Excluídos" }));
        jCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo:");

        jLabel3.setText("Resultado:");

        jBVoltar.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBVoltar.setForeground(new java.awt.Color(255, 102, 102));
        jBVoltar.setText("<- Voltar");

        jBExcluir.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBExcluir.setForeground(new java.awt.Color(255, 102, 102));
        jBExcluir.setText("Excluir");

        jLlogo.setFont(new java.awt.Font("Kinnari", 2, 18)); // NOI18N
        jLlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLlogo.setText("Cafe et letters ");

        listProdutos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listProdutosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBVoltar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLlogo)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(listProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExcluir)
                    .addComponent(jBVoltar))
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listProdutosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listProdutosItemStateChanged
      
        
    }//GEN-LAST:event_listProdutosItemStateChanged

    private void jCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoActionPerformed
        System.out.println("aquiiii");  
        
        if(this.jCBTipo.getSelectedItem().equals("Cadastrados")){
            this.listProdutos.removeAll();
            lista();
        } if(this.jCBTipo.getSelectedItem().equals("Disponíveis")){
            this.listProdutos.removeAll();
            disponiveis();
        } if(this.jCBTipo.getSelectedItem().equals("Excluídos")){
            this.listProdutos.removeAll();
            excluidos();
        }if(this.jCBTipo.getSelectedItem().equals("Categoria: Livros")){
             this.listProdutos.removeAll();
             porCategoriaLivros();
             
        } if(this.jCBTipo.getSelectedItem().equals("Categoria: HQs")){
              this.listProdutos.removeAll();
              porCategoriaHQ();
            
        } if(this.jCBTipo.getSelectedItem().equals("Categoria: Bebidas")){
              this.listProdutos.removeAll();
              porCategoriaBebida();
            
        }if(this.jCBTipo.getSelectedItem().equals("Categoria: Acompanhamentos")){
              this.listProdutos.removeAll();
              porCategoriaAcompanhamento();
        } 
    }//GEN-LAST:event_jCBTipoActionPerformed

    public void adicionarEventos(){
        this.jBVoltar.addActionListener(this);
        this.jBExcluir.addActionListener(this);
    }
    
    public void lista(){
        estoque.inicializarEstoque();
        this.produtosNoEstoque = new ArrayList<>();
        
        for(int i=0; i<estoque.getProdutos().size(); i++){
            this.produtosNoEstoque.add(estoque.getProdutos().get(i));
            this.listProdutos.add(estoque.getProdutos().get(i).getNome()+" | "+estoque.getProdutos().get(i).getCodigo());
        }
        
        this.listProdutos.list();
    }
    
    public void disponiveis(){
        estoque.inicializarEstoque();
        produtosNoEstoque2 = new ArrayList<>();
        
                for(int i=0; i<estoque.listarProdutosEstoque().size(); i++){
                    this.produtosNoEstoque2.add(estoque.listarProdutosEstoque().get(i));
                    this.listProdutos.add(estoque.listarProdutosEstoque().get(i));
                }
                
    this.listProdutos.list();
    }
    
    public void excluidos(){
        estoque.inicializarEstoque();
        produtosNoEstoque2 = new ArrayList<>();
        
                for(int i=0; i<estoque.listarProdutosExcluidos().size(); i++){
                    this.produtosNoEstoque2.add(estoque.listarProdutosExcluidos().get(i));
                    this.listProdutos.add(estoque.listarProdutosExcluidos().get(i));
                }
                
    this.listProdutos.list();
    }
    
    public void foraDeEstoque(){
         estoque.inicializarEstoque();
        
                for(int i=0; i<estoque.listarProdutosForaEstoque().size(); i++){
                    this.listProdutos.add(estoque.listarProdutosForaEstoque().get(i));
                }
                
    this.listProdutos.list();
    }
    
    public void porCategoriaLivros(){
          estoque.inicializarEstoque();
        
                for(int i=0; i<estoque.listarLivros().size(); i++){
                    this.listProdutos.add(estoque.listarLivros().get(i));
                }
                
    this.listProdutos.list();
    }
    
    public void porCategoriaHQ(){
          estoque.inicializarEstoque();
        
                for(int i=0; i<estoque.listarHQs().size(); i++){
                    this.listProdutos.add(estoque.listarHQs().get(i));
                }
                
    this.listProdutos.list();
    }
    
    public void porCategoriaBebida(){
          estoque.inicializarEstoque();
        
                for(int i=0; i<estoque.listarBebidas().size(); i++){
                    this.listProdutos.add(estoque.listarBebidas().get(i));
                }
                
    this.listProdutos.list();
    }
    
    public void porCategoriaAcompanhamento(){
          estoque.inicializarEstoque();
        
                for(int i=0; i<estoque.listarAcompanhamentos().size(); i++){
                    this.listProdutos.add(estoque.listarAcompanhamentos().get(i));
                }
                
    this.listProdutos.list();
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            TelaInicial.util.logging.Logger.getLogger(Estoque.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            TelaInicial.util.logging.Logger.getLogger(Estoque.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaInicial.util.logging.Logger.getLogger(Estoque.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaInicial.util.logging.Logger.getLogger(Estoque.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form 
        TelaInicial.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estoque().setVisible(true);
            }
        });*/
      
        new TelaEstoque1().setVisible(true);
        new TelaEstoque1().dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLlogo;
    private java.awt.List listProdutos;
    // End of variables declaration//GEN-END:variables

    public JButton getjBVoltar() {
        return jBVoltar;
    }

    public void setjBVoltar(JButton jBVoltar) {
        this.jBVoltar = jBVoltar;
    }

    public JComboBox<String> getjCBTipo() {
        return jCBTipo;
    }

    public void setjCBTipo(JComboBox<String> jCBTipo) {
        this.jCBTipo = jCBTipo;
    }

    public javax.swing.JButton getjBExcluir() {
        return jBExcluir;
    }

    public void setjBExcluir(javax.swing.JButton jBExcluir) {
        this.jBExcluir = jBExcluir;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == getjBVoltar()){
            setVisible(false);
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
            
        }else if(e.getSource() == getjBExcluir()){
              // estoque.excluirProduto(this.produtosNoEstoque.get(listProdutos.getSelectedIndex()).getCodigo());
              new TelaExcluirProduto().setVisible(true);
              new TelaExcluirProduto().dispose();
              
        }else if(e.getSource() == getjCBTipo().getActionCommand()){
            System.out.println("Identificou mudança");
        }
    }

    public java.awt.List getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(java.awt.List listProdutos) {
        this.listProdutos = listProdutos;
    }
 
}
