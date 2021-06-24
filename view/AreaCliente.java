package cafe.etletters.view;

import javax.swing.JButton;

public class AreaCliente extends javax.swing.JFrame {

    public AreaCliente() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBCadastrarCliente = new javax.swing.JButton();
        jBClientesAtivos = new javax.swing.JButton();
        jBExcluirCliente = new javax.swing.JButton();
        jBClientesExcluidos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCadastrarCliente.setText("Cadastrar Cliente");

        jBClientesAtivos.setText("Clientes ativos");

        jBExcluirCliente.setText("Excluir Cliente");

        jBClientesExcluidos.setText("Clientes excluídos");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Área do Cliente");

        jBVoltar.setText("<- Voltar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jBCadastrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBClientesExcluidos)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBVoltar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientesExcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
         */
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
        }
        //</editor-fold>

        /* Create and display the form */
        TelaInicial.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaCliente().setVisible(true);
            }
        });
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
}
