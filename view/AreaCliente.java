package cafe.etletters.view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AreaCliente extends javax.swing.JFrame implements javax.swing.Action{

    public AreaCliente() {
        initComponents();
        
        this.jBCadastrarCliente.addActionListener(this);
        this.jBClientesAtivos.addActionListener(this);
        this.jBClientesExcluidos.addActionListener(this);
        this.jBExcluirCliente.addActionListener(this);
        this.jBVoltar.addActionListener(this);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBCadastrarCliente = new javax.swing.JButton();
        jBClientesAtivos = new javax.swing.JButton();
        jBExcluirCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();
        jBClientesExcluidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCadastrarCliente.setText("Cadastrar Cliente");

        jBClientesAtivos.setText("Clientes ativos");

        jBExcluirCliente.setText("Excluir Cliente");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Área do Cliente");

        jBVoltar.setText("<- Voltar");

        jBClientesExcluidos.setText("Clientes excluídos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jBCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClientesExcluidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVoltar)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientesExcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            TelaInicial.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            TelaInicial.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaInicial.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaInicial.util.logging.Logger.getLogger(AreaCliente.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } */
        //</editor-fold>

        /* Create and display the form 
        TelaInicial.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaCliente().setVisible(true);
            }
        });*/
        
        new AreaCliente().setVisible(true);
        new AreaCliente().dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrarCliente;
    private javax.swing.JButton jBClientesAtivos;
    private javax.swing.JButton jBClientesExcluidos;
    private javax.swing.JButton jBExcluirCliente;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JButton getjBCadastrarCliente() {
        return jBCadastrarCliente;
    }

    public void setjBCadastrarCliente(JButton jBCadastrarCliente) {
        this.jBCadastrarCliente = jBCadastrarCliente;
    }

    public JButton getjBClientesAtivos() {
        return jBClientesAtivos;
    }

    public void setjBClientesAtivos(JButton jBClientesAtivos) {
        this.jBClientesAtivos = jBClientesAtivos;
    }

    public JButton getjBClientesExcluidos() {
        return jBClientesExcluidos;
    }

    public void setjBClientesExcluidos(JButton jBClientesExcluidos) {
        this.jBClientesExcluidos = jBClientesExcluidos;
    }

    public JButton getjBExcluirCliente() {
        return jBExcluirCliente;
    }

    public void setjBExcluirCliente(JButton jBExcluirCliente) {
        this.jBExcluirCliente = jBExcluirCliente;
    }

    public JButton getjBVoltar() {
        return jBVoltar;
    }

    public void setjBVoltar(JButton jBVoltar) {
        this.jBVoltar = jBVoltar;
    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == getjBCadastrarCliente()){
            setVisible(false);
            
            new AreaCliente().setVisible(false);  
            new Cliente().setVisible(true);
            new Cliente().dispose();
            
        }else if(e.getSource() == getjBClientesAtivos()){
            setVisible(false);
            
            new AreaCliente().setVisible(false);  
            new ClientesAtivos().setVisible(true);
            new ClientesAtivos().dispose();
            
        }else if(e.getSource() == getjBClientesExcluidos()){
            setVisible(false);
            
            new AreaCliente().setVisible(false);  
            new ClientesExcluidos().setVisible(true);
            new ClientesExcluidos().dispose();
            
        }else if(e.getSource() == getjBExcluirCliente()){ /*Realizar um painel de busca? Tela nova ou aproveitar tela de clientes ativos?*/
            setVisible(false);
            
            new AreaCliente().setVisible(false);  
            new ClientesAtivos().setVisible(true);
            new ClientesAtivos().dispose();
            
        }else if(e.getSource() == getjBVoltar()){
            setVisible(false);
            
            new AreaCliente().setVisible(false);  
            new AreaInicial().setVisible(true);
            new AreaInicial().dispose();
        }

    }
}
