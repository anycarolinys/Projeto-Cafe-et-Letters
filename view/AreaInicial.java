package cafe.etletters.view;

//import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AreaInicial extends javax.swing.JFrame implements javax.swing.Action{

    public AreaInicial() {
        initComponents();
        this.jBVendas.addActionListener(this);
        this.jBProdutos.addActionListener(this);
        this.jBEstoque.addActionListener(this);
        this.jBClientes.addActionListener(this);
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

        jPopupMenu1.setOpaque(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(254, 254, 254));
        setName("telainicial"); // NOI18N

        jBVendas.setText("Vendas");

        jBClientes.setText("Clientes");

        jBProdutos.setText("Produtos");

        jBEstoque.setText("Estoque");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEstoque)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLlogo, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                        .addContainerGap(56, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        
       /*Tentativa de inserir logo no programa
        
       ImageIcon img = new ImageIcon("logo1.jpg");
       JLabel label = new JLabel();
       label.setName("JLlogo");
       label.setIcon("img");*/
       
       /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            TelaInicial.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            TelaInicial.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            TelaInicial.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            TelaInicial.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(TelaInicial.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form 
        TelaInicial.awt.EventQueue.invokeLater(new Runnable() {
          
        });
        JFrame telainicial = new JFrame();
        telainicial.setSize(450, 550);
        telainicial.setTitle("Boas vindas");
        telainicial.setVisible(true);*//**/
       
       new AreaInicial().setTitle("Cafe et letters: Livraria-café");
       new AreaInicial().setVisible(true);  
       new AreaInicial().dispose();
       
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClientes;
    private javax.swing.JButton jBEstoque;
    private javax.swing.JButton jBProdutos;
    private javax.swing.JButton jBVendas;
    private javax.swing.JColorChooser jColorChooser1;
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
        //ImageIcon img = new ImageIcon("logo1.jpg");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == getjBVendas()){
            setVisible(false);  
            new Venda().setVisible(true);
            new Venda().dispose();
            
        }else if(e.getSource() == getjBProdutos()){
            setVisible(false);  
            new Produto().setVisible(true);
            new Produto().dispose();
            
        }else if(e.getSource() == getjBEstoque()){
            setVisible(false);  
            new Estoque().setVisible(true);
            new Estoque().dispose();
            
        }else if(e.getSource() == getjBClientes()){
            setVisible(false);
            new AreaCliente().setVisible(true);
            new AreaCliente().dispose();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean accept(Object sender) {
        //return Action.super.accept(sender); //To change body of generated methods, choose Tools | Templates.
        return true;
    }



}
