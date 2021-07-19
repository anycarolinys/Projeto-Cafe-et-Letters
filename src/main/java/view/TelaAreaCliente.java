package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class TelaAreaCliente extends javax.swing.JFrame implements ActionListener{

    public TelaAreaCliente() {
        initComponents();   
        adicionarEventos();
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
        jLlogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCadastrarCliente.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBCadastrarCliente.setForeground(new java.awt.Color(255, 102, 102));
        jBCadastrarCliente.setText("Cadastrar Cliente");

        jBClientesAtivos.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBClientesAtivos.setForeground(new java.awt.Color(255, 102, 102));
        jBClientesAtivos.setText("Clientes ativos");

        jBExcluirCliente.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBExcluirCliente.setForeground(new java.awt.Color(255, 102, 102));
        jBExcluirCliente.setText("Excluir Cliente");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Área do Cliente");

        jBVoltar.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBVoltar.setForeground(new java.awt.Color(255, 102, 102));
        jBVoltar.setText("<- Voltar");

        jBClientesExcluidos.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBClientesExcluidos.setForeground(new java.awt.Color(255, 102, 102));
        jBClientesExcluidos.setText("Clientes excluídos");

        jLlogo.setFont(new java.awt.Font("Kinnari", 2, 36)); // NOI18N
        jLlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLlogo.setText("Cafe et letters ");

        jLabel2.setFont(new java.awt.Font("URW Palladio L", 2, 15)); // NOI18N
        jLabel2.setText("Livraria-Café");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBVoltar)
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLlogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClientesExcluidos))
                    .addComponent(jLabel2))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVoltar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLlogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientesAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientesExcluidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
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
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void adicionarEventos(){
        
        this.jBCadastrarCliente.addActionListener(this);
        this.jBClientesAtivos.addActionListener(this);
        this.jBClientesExcluidos.addActionListener(this);
        this.jBExcluirCliente.addActionListener(this);
        this.jBVoltar.addActionListener(this);        
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
        
        new TelaAreaCliente().setVisible(true);
        new TelaAreaCliente().dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrarCliente;
    private javax.swing.JButton jBClientesAtivos;
    private javax.swing.JButton jBClientesExcluidos;
    private javax.swing.JButton jBExcluirCliente;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLlogo;
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
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == getjBCadastrarCliente()){
            this.setVisible(false);
            
            new TelaCadastrarCliente().setVisible(true);
            new TelaCadastrarCliente().dispose();
            
        }else if(e.getSource() == getjBClientesAtivos()){
            this.setVisible(false);
            
            new  TelaClientesAtivos().setVisible(true);
            new  TelaClientesAtivos().dispose();
            
        }else if(e.getSource() == getjBClientesExcluidos()){
            this.setVisible(false);
            
            new  TelaClientesExcluidos().setVisible(true);
            new  TelaClientesExcluidos().dispose();
            
        }else if(e.getSource() == getjBExcluirCliente()){ /*Realizar um painel de busca? Tela nova ou aproveitar tela de clientes ativos?*/
            this.setVisible(false);
            
            new  TelaClientesAtivos().setVisible(true);
            new  TelaClientesAtivos().dispose();
            
        }else if(e.getSource() == getjBVoltar()){
            this.setVisible(false);
            
            new  TelaAreaInicial().setVisible(true);
            new  TelaAreaInicial().dispose();
        }

    }

}
