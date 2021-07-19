package view;

//import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public final class TelaAreaInicial extends javax.swing.JFrame implements ActionListener{

    public TelaAreaInicial() {
        initComponents(); 
        
        adicionarEventos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jBVendas = new javax.swing.JButton();
        jBClientes = new javax.swing.JButton();
        jBProdutos = new javax.swing.JButton();
        jBEstoque = new javax.swing.JButton();
        jLlogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPopupMenu1.setOpaque(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 250, 252));
        setForeground(new java.awt.Color(255, 255, 255));
        setName("telainicial"); // NOI18N

        jBVendas.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBVendas.setForeground(new java.awt.Color(255, 102, 102));
        jBVendas.setText("Vendas");
        jBVendas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jBClientes.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBClientes.setForeground(new java.awt.Color(255, 102, 102));
        jBClientes.setText("Clientes");
        jBClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204)));

        jBProdutos.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBProdutos.setForeground(new java.awt.Color(255, 102, 102));
        jBProdutos.setText("Produtos");
        jBProdutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        jBEstoque.setFont(new java.awt.Font("Liberation Sans", 3, 13)); // NOI18N
        jBEstoque.setForeground(new java.awt.Color(255, 102, 102));
        jBEstoque.setText("Estoque");
        jBEstoque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jBEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEstoqueActionPerformed(evt);
            }
        });

        jLlogo.setFont(new java.awt.Font("Kinnari", 2, 36)); // NOI18N
        jLlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLlogo.setText("Cafe et letters ");

        jLabel2.setFont(new java.awt.Font("URW Chancery L", 0, 13)); // NOI18N
        jLabel2.setText("Sistema de Controle de Estoque");

        jLabel1.setFont(new java.awt.Font("URW Palladio L", 2, 15)); // NOI18N
        jLabel1.setText("Livraria-Café");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLlogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLlogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void adicionarEventos(){
        this.jBVendas.addActionListener(this);
        this.jBProdutos.addActionListener(this);
        this.jBEstoque.addActionListener(this);
        this.jBClientes.addActionListener(this);
    }
    private void jBEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEstoqueActionPerformed

    public static void main(String args[]) {
       new TelaAreaInicial().setTitle("Cafe et letters: Livraria-café");
       new TelaAreaInicial().setVisible(true);  
       new TelaAreaInicial().dispose();
       
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClientes;
    private javax.swing.JButton jBEstoque;
    private javax.swing.JButton jBProdutos;
    private javax.swing.JButton jBVendas;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLlogo;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    public JButton getjBClientes() {
        return jBClientes;
    }

    public void setjBClientes(JButton jBClientes) {
        this.jBClientes = jBClientes;
    }

    public JButton getjBEstoque() {
        return jBEstoque;
    }

    public void setjBEstoque(JButton jBEstoque) {
        this.jBEstoque = jBEstoque;
    }

    public JButton getjBProdutos() {
        return jBProdutos;
    }

    public void setjBProdutos(JButton jBProdutos) {
        this.jBProdutos = jBProdutos;
    }

    public JButton getjBVendas() {
        return jBVendas;
    }

    public void setjBVendas(JButton jBVendas) {
        this.jBVendas = jBVendas;
    }

    public JLabel getjLlogo() {
        return jLlogo;
    }

    public void setjLlogo(JLabel jLlogo) {
        ImageIcon img = new ImageIcon("logo1.jpg");
        jLlogo.setIcon(img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == getjBVendas()){
            this.setVisible(false);  
            new TelaCadastrarVenda().setVisible(true);
            new TelaCadastrarVenda().dispose();
            
        }else if(e.getSource() == getjBProdutos()){
            this.setVisible(false);  
            new TelaCadastrarProduto().setVisible(true);
            new TelaCadastrarProduto().dispose();
            
        }else if(e.getSource() == getjBEstoque()){
            this.setVisible(false);  
            new TelaEstoque1().setVisible(true);
            new TelaEstoque1().dispose();
            
        }else if(e.getSource() == getjBClientes()){
            this.setVisible(false);
            new TelaAreaCliente().setVisible(true);
            new TelaAreaCliente().dispose();
        }
        
    }

}
