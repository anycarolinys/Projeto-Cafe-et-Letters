package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import control.ControleProdutos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class TelaCadastrarProduto extends javax.swing.JFrame implements ActionListener{

    private ControleProdutos cp;
    
    public TelaCadastrarProduto() {
        
        initComponents();
        cp = new ControleProdutos(this);
        
        adicionaEventos();
        
    }

    
    public void adicionaEventos(){
        this.jCBTipo.addActionListener(this); //Conferir se precisará de mais algum tratamento
        this.jBVoltar.addActionListener(this);
        this.jBRegistrar.addActionListener(this);
        
        //getjBVoltar().addActionListener(this);
        //getjBEditar().addActionListener(this);
        //getjBExcluir().addActionListener(this);
    }
    
    public JButton getjBRegistrar() {
        return jBRegistrar;
    }

    public void setjBRegistrar(JButton jBRegistrar) {
        this.jBRegistrar = jBRegistrar;
    }

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

    public JFormattedTextField getjFPreco() {
        return jFPreco;
    }

    public void setjFPreco(JFormattedTextField jFPreco) {
        this.jFPreco = jFPreco;
    }

    public JTextField getjTCodProduto() {
        return jTCodProduto;
    }

    public void setjTCodProduto(JTextField jTCodProduto) {
        this.jTCodProduto = jTCodProduto;
    }

    public JTextField getjTNomeProduto() {
        return jTNomeProduto;
    }

    public void setjTNomeProduto(JTextField jTNomeProduto) {
        this.jTNomeProduto = jTNomeProduto;
    }

    public JTextField getjTqtdNoEstoque() {
        return jTqtdNoEstoque;
    }

    public void setjTqtdNoEstoque(JTextField jTqtdNoEstoque) {
        this.jTqtdNoEstoque = jTqtdNoEstoque;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTCodProduto = new javax.swing.JTextField();
        jTNomeProduto = new javax.swing.JTextField();
        jFPreco = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jBRegistrar = new javax.swing.JButton();
        jBVoltar = new javax.swing.JButton();
        jTqtdNoEstoque = new javax.swing.JTextField();
        jLlogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome: ");

        jLabel2.setText("Preço: R$");

        jLabel3.setText("Quantidade no estoque: ");

        jLabel4.setText("Código:");

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a opção desejada", "Bebida", "Acompanhamento" }));

        jLabel5.setText("Tipo: ");

        jTNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeProdutoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 2, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registro de Produtos");

        jBRegistrar.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBRegistrar.setForeground(new java.awt.Color(255, 102, 102));
        jBRegistrar.setText("Finalizar");

        jBVoltar.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBVoltar.setForeground(new java.awt.Color(255, 102, 102));
        jBVoltar.setText("<- Voltar");

        jLlogo.setFont(new java.awt.Font("Kinnari", 2, 18)); // NOI18N
        jLlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLlogo.setText("Cafe et letters ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jBVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTqtdNoEstoque))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jCBTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTNomeProduto)
                                .addComponent(jTCodProduto)
                                .addComponent(jFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLlogo)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jFPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTqtdNoEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeProdutoActionPerformed

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
            TelaInicial.util.logging.Logger.getLogger(Produto.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            TelaInicial.util.logging.Logger.getLogger(Produto.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaInicial.util.logging.Logger.getLogger(Produto.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaInicial.util.logging.Logger.getLogger(Produto.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold> */

        /* Create and display the form 
        TelaInicial.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });*/
        new TelaCadastrarProduto().setVisible(true);
        new TelaCadastrarProduto().dispose();
        //ControleProdutos p = new ControleProdutos();
        //p.actionPerformed();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRegistrar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JFormattedTextField jFPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLlogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTCodProduto;
    private javax.swing.JTextField jTNomeProduto;
    private javax.swing.JTextField jTqtdNoEstoque;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
        if(e.getSource() == getjBRegistrar()){
            cp.actionPerformed(e);
        }else if(e.getSource() == getjBVoltar()){
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }
        
        }catch(Exception ex){
            System.out.println("Erroooo TCP");
        }
    }

}
