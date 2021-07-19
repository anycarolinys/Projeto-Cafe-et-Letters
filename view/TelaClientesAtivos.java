package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.gestaoClientes.Cliente;
import model.gestaoClientes.Clientela;
import model.gestaoProdutos.Estoque;

public class TelaClientesAtivos extends javax.swing.JFrame implements ActionListener{

    private Clientela clientela;
    private List<Cliente> clientesAtivos;
    
    public TelaClientesAtivos() {
        initComponents();
        adicionarEventos();
        this.clientela = new Clientela();
        listar();
    }
    
    public void adicionarEventos(){
        this.jBVoltar.addActionListener(this);
        this.jBCompras.addActionListener(this);
        this.jBExcluir.addActionListener(this);
    }

    public void listar(){
        clientela.inicializarClientes();
        this.clientesAtivos = new ArrayList<>();
          
        for(int i=0; i<clientela.getClientes().size(); i++){
            this.clientesAtivos.add(clientela.getClientes().get(i));
            this.listClientesAtivos.add(clientela.getClientes().get(i).getNome());
        }
        
        this.listClientesAtivos.list();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();
        jBCompras = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jLlogo = new javax.swing.JLabel();
        listClientesAtivos = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes Ativos");

        jLabel3.setText("Resultado:");

        jBVoltar.setText("<- Voltar");

        jBCompras.setText("Compras do cliente");
        jBCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBComprasActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");

        jLlogo.setFont(new java.awt.Font("Kinnari", 2, 18)); // NOI18N
        jLlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLlogo.setText("Cafe et letters ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jBVoltar))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jBCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(listClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLlogo)))
                .addGap(20, 20, 20)
                .addComponent(jBExcluir)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(listClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCompras)
                    .addComponent(jBVoltar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBComprasActionPerformed

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
            TelaInicial.util.logging.Logger.getLogger(ClientesAtivos.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            TelaInicial.util.logging.Logger.getLogger(ClientesAtivos.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaInicial.util.logging.Logger.getLogger(ClientesAtivos.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaInicial.util.logging.Logger.getLogger(ClientesAtivos.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form 
        TelaInicial.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesAtivos().setVisible(true);
            }
        });*/
        
        new TelaClientesAtivos().setVisible(true);
        new TelaClientesAtivos().dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCompras;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLlogo;
    private javax.swing.JPanel jPanel1;
    private java.awt.List list1;
    private java.awt.List listClientesAtivos;
    // End of variables declaration//GEN-END:variables

    public JButton getjBVoltar() {
        return jBVoltar;
    }

    public void setjBVoltar(JButton jBVoltar) {
        this.jBVoltar = jBVoltar;
    }

    public javax.swing.JButton getjBEditar() {
        return jBCompras;
    }

    public void setjBEditar(javax.swing.JButton jBEditar) {
        this.jBCompras = jBEditar;
    }

    public javax.swing.JButton getjBExcluir() {
        return jBExcluir;
    }

    public void setjBExcluir(javax.swing.JButton jBExcluir) {
        this.jBExcluir = jBExcluir;
    }

    public java.awt.List getListClientesAtivos() {
        return listClientesAtivos;
    }

    public void setListClientesAtivos(java.awt.List listClientesAtivos) {
        this.listClientesAtivos = listClientesAtivos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == getjBVoltar()){
            setVisible(false);
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
            
        }else if(e.getSource() == getjBCompras()){          
         // listarCompras();
         
          new TelaComprasCliente().setVisible(true);
          new TelaComprasCliente().dispose();
        }else if(e.getSource() == getjBExcluir()){
           clientela.excluirCliente(clientesAtivos.get( listClientesAtivos.getSelectedIndex()).getCPF());
           JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso");
        }   
    }

    public void listarCompras(){
         clientela.inicializarClientes();
         clientela.listarComprasClientes(clientesAtivos.get( listClientesAtivos.getSelectedIndex()).getCPF());
         
         String cpf = clientesAtivos.get( listClientesAtivos.getSelectedIndex()).getCPF();
        this.clientesAtivos = new ArrayList<>();
          
        for(int i=0; i<clientela.listarComprasClientes(cpf).size(); i++){
           
        }
         this.listClientesAtivos.add(clientela.listarComprasClientes(cpf).get(0));
        this.listClientesAtivos.list();
    }
    
    public javax.swing.JButton getjBCompras() {
        return jBCompras;
    }

    public void setjBCompras(javax.swing.JButton jBCompras) {
        this.jBCompras = jBCompras;
    }

}
