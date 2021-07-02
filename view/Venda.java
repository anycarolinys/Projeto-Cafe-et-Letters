package cafe.etletters.view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList; 
//import java.awt.EventQueue;

public class Venda extends javax.swing.JFrame implements javax.swing.Action{

    public Venda() {
        initComponents();
        
        this.jBVoltar.addActionListener(this);
        this.jBConcluir.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLproduto = new javax.swing.JLabel();
        jCBProdutosOn = new javax.swing.JComboBox<>();
        jLabel0 = new javax.swing.JLabel();
        jLvalorPago = new javax.swing.JLabel();
        jFTvalorPago = new javax.swing.JFormattedTextField();
        jLvalorProduto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBConcluir = new javax.swing.JButton();
        jFhora = new javax.swing.JFormattedTextField();
        jLTroco = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLproduto.setText("Produto: ");

        jCBProdutosOn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel0.setText("Valor:");

        jLvalorPago.setText("Valor Pago:");

        jLabel2.setText("Troco:");

        jLabel3.setText("Data:");

        jLabel4.setText("Hora:");

        jBConcluir.setText("Concluir venda");

        jLTroco.setText("(R$ Valor)");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Venda");

        jBVoltar.setText("<- Voltar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel0)
                    .addComponent(jLproduto)
                    .addComponent(jLvalorPago)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jCBProdutosOn, 0, 306, Short.MAX_VALUE)
                        .addComponent(jFTvalorPago)
                        .addComponent(jLvalorProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFhora))
                    .addComponent(jLTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBConcluir)
                        .addGap(179, 179, 179))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLproduto)
                    .addComponent(jCBProdutosOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel0)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLvalorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLvalorPago)
                    .addComponent(jFTvalorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFhora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jBConcluir)
                .addGap(16, 16, 16)
                .addComponent(jBVoltar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
       new Venda().setVisible(true);
       new Venda().dispose();
    }

    public JButton getjBConcluir() {
        return jBConcluir;
    }

    public void setjBConcluir(JButton jBConcluir) {
        this.jBConcluir = jBConcluir;
    }

    public JButton getjBVoltar() {
        return jBVoltar;
    }

    public void setjBVoltar(JButton jBVoltar) {
        this.jBVoltar = jBVoltar;
    }

    public JComboBox<String> getjCBProdutosOn() {
        return jCBProdutosOn;
    }

    public void setjCBProdutosOn(JComboBox<String> jCBProdutosOn) {
        this.jCBProdutosOn = jCBProdutosOn;
    }

    public JFormattedTextField getjFTvalorPago() {
        return jFTvalorPago;
    }

    public void setjFTvalorPago(JFormattedTextField jFTvalorPago) {
        this.jFTvalorPago = jFTvalorPago;
    }

    public JFormattedTextField getjFhora() {
        return jFhora;
    }

    public void setjFhora(JFormattedTextField jFhora) {
        this.jFhora = jFhora;
    }

    public JLabel getjLTroco() {
        return jLTroco;
    }

    public void setjLTroco(JLabel jLTroco) {
        this.jLTroco = jLTroco;
    }

    public JList<String> getjList1() {
        return jList1;
    }

    public void setjList1(JList<String> jList1) {
        this.jList1 = jList1;
    }

    public JLabel getjLproduto() {
        return jLproduto;
    }

    public void setjLproduto(JLabel jLproduto) {
        this.jLproduto = jLproduto;
    }

    public JLabel getjLvalorPago() {
        return jLvalorPago;
    }

    public void setjLvalorPago(JLabel jLvalorPago) {
        this.jLvalorPago = jLvalorPago;
    }

    public JLabel getjLvalorProduto() {
        return jLvalorProduto;
    }

    public void setjLvalorProduto(JLabel jLvalorProduto) {
        this.jLvalorProduto = jLvalorProduto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConcluir;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBProdutosOn;
    private javax.swing.JFormattedTextField jFTvalorPago;
    private javax.swing.JFormattedTextField jFhora;
    private javax.swing.JLabel jLTroco;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JLabel jLproduto;
    private javax.swing.JLabel jLvalorPago;
    private javax.swing.JLabel jLvalorProduto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

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
        if(e.getSource() == getjBConcluir()){
            //Implementar passagem de dados para control onde irá inserir a venda realizada nos arquivos
        }else if(e.getSource() == getjBVoltar()){
            setVisible(false);
            
            new AreaInicial().setVisible(true);
            new AreaInicial().dispose();
        }
    }
}
