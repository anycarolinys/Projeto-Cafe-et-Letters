package view;

import control.ControleVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList; 
import javax.swing.JTextField;

public class TelaCadastrarVenda extends javax.swing.JFrame implements ActionListener{

    private ControleVendas cv;
    
    public TelaCadastrarVenda() {
        initComponents();
        adicionaEventos();
        
        cv = new ControleVendas(this);
    }
    
    public void adicionaEventos(){
       this.jBVoltar.addActionListener(this);
       this.jBConcluir.addActionListener(this);
       this.jBBuscarCod.addActionListener(this);
       this.jBcadastrar.addActionListener(this);
   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLproduto = new javax.swing.JLabel();
        jLabel0 = new javax.swing.JLabel();
        jLvalorPago = new javax.swing.JLabel();
        jBConcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();
        jTValorPago = new javax.swing.JTextField();
        jTCodProduto = new javax.swing.JTextField();
        jTqtd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTCPF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBcadastrar = new javax.swing.JButton();
        jBBuscarCod = new javax.swing.JButton();
        jLlogo = new javax.swing.JLabel();
        jLvalorProduto = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLproduto.setText("Produto: ");

        jLabel0.setText("Valor: R$");

        jLvalorPago.setText("Valor Pago:");

        jBConcluir.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        jBConcluir.setForeground(new java.awt.Color(255, 102, 102));
        jBConcluir.setText("Concluir venda");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 2, 22)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Venda");

        jBVoltar.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        jBVoltar.setForeground(new java.awt.Color(255, 102, 102));
        jBVoltar.setText("<- Voltar");

        jTCodProduto.setText("Código do produto");

        jLabel1.setText("Quantidade:");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 2, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Cliente");

        jLabel3.setText("Nome:");

        jLabel4.setText("CPF: ");

        jBcadastrar.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        jBcadastrar.setForeground(new java.awt.Color(255, 102, 102));
        jBcadastrar.setText("Cadastrar");

        jBBuscarCod.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        jBBuscarCod.setForeground(new java.awt.Color(255, 102, 102));
        jBBuscarCod.setText("OK");

        jLlogo.setFont(new java.awt.Font("Kinnari", 2, 18)); // NOI18N
        jLlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLlogo.setText("Cafe et letters ");

        jLvalorProduto.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel0))
                            .addComponent(jLvalorPago)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLproduto))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jBConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTCodProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBBuscarCod))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTqtd)
                                        .addComponent(jTValorPago, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                                    .addComponent(jLvalorProduto)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jBcadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTNome, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(jTCPF)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLlogo))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLproduto)
                    .addComponent(jTCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel0)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLvalorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLvalorPago)
                            .addComponent(jTValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jBcadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBVoltar)
                            .addComponent(jBConcluir))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
       new TelaCadastrarVenda().setVisible(true);
       new TelaCadastrarVenda().dispose();
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

    public JTextField getjTvalorPago() {
        return jTValorPago;
    }

    public void setjTvalorPago(JTextField jFTvalorPago) {
        this.jTValorPago = jFTvalorPago;
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

    public JTextField getjLvalorProduto() {
        return jLvalorProduto;
    }

    public void setjLvalorProduto(JTextField jLvalorProduto) {
        this.jLvalorProduto = jLvalorProduto;
    }
    
    public JTextField getjTCodProduto() {
        return jTCodProduto;
    }

    public void setjTCodProduto(JTextField jTCodProduto) {
        this.jTCodProduto = jTCodProduto;
    }
    
    
    public JButton getjBcadastrar() {
        return jBcadastrar;
    }

    public void setjBcadastrar(JButton jBcadastrar) {
        this.jBcadastrar = jBcadastrar;
    }

    public JTextField getjTCPF() {
        return jTCPF;
    }

    public void setjTCPF(JTextField jTCPF) {
        this.jTCPF = jTCPF;
    }

    public JTextField getjTNome() {
        return jTNome;
    }

    public void setjTNome(JTextField jTNome) {
        this.jTNome = jTNome;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscarCod;
    private javax.swing.JButton jBConcluir;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JButton jBcadastrar;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JLabel jLlogo;
    private javax.swing.JLabel jLproduto;
    private javax.swing.JLabel jLvalorPago;
    private javax.swing.JTextField jLvalorProduto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCPF;
    private javax.swing.JTextField jTCodProduto;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTValorPago;
    private javax.swing.JTextField jTqtd;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try{
            
        if(e.getSource() == getjBBuscarCod()){
            cv.actionPerformed(e);
        }if(e.getSource() == getjBConcluir()){
              System.out.println("Chegou 1");
            cv.actionPerformed(e);
        } if(e.getSource() == getjBcadastrar()){
              System.out.println("Chegou 2");
            cv.actionPerformed(e);
        }else if(e.getSource() == getjBVoltar()){
            this.setVisible(false);
            new TelaAreaInicial().setVisible(true);
            new TelaAreaInicial().dispose();
        }
        
        }catch(Exception ex){
            System.out.println("Erroooo TCP");
            ex.printStackTrace();
        }
    }

    public javax.swing.JTextField getjTqtd() {
        return jTqtd;
    }

    public void setjTqtd(javax.swing.JTextField jTqtd) {
        this.jTqtd = jTqtd;
    }


    public javax.swing.JTextField getjTValorPago() {
        return jTValorPago;
    }

    public void setjTValorPago(javax.swing.JTextField jTValorPago) {
        this.jTValorPago = jTValorPago;
    }

    public javax.swing.JButton getjBBuscarCod() {
        return jBBuscarCod;
    }

    public void setjBBuscarCod(javax.swing.JButton jBBuscarCod) {
        this.jBBuscarCod = jBBuscarCod;
    }


}
