/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Caioh
 */
public class AddMeiaPedido extends javax.swing.JFrame {

    String sabor1;
    String sabor2;
    double valor1;
    double valor2;

    /**
     * Creates new form AddMeia
     */
    public AddMeiaPedido() {
        initComponents();
        setLocationRelativeTo(null);
        readJTable1();
        readJTable2();
    }

    public void readJTable1() {

        DefaultTableModel modelo = (DefaultTableModel) tb_pizza1.getModel();
        modelo.setNumRows(0);
        model.conexao.crudPizza crud = new model.conexao.crudPizza();

        for (model.entities.Pizza p : crud.readPizza()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),});

        }
    }

    public void readJTable2() {

        DefaultTableModel modelo = (DefaultTableModel) tb_pizza2.getModel();
        modelo.setNumRows(0);
        model.conexao.crudPizza crud = new model.conexao.crudPizza();

        for (model.entities.Pizza p : crud.readPizza()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),});

        }
    }

    public void adicionarPizza() {
        DefaultTableModel modelo1 = (DefaultTableModel) tb_pizza1.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) tb_pizza2.getModel();

        int linha1 = tb_pizza1.getSelectedRow();
        int linha2 = tb_pizza2.getSelectedRow();

        modelo1.getValueAt(linha1, 1).toString();
        modelo2.getValueAt(linha2, 1).toString();

        String pizza = modelo1.getValueAt(linha1, 1).toString() + " / "
                + modelo2.getValueAt(linha2, 1).toString() 
                + " com borda: " + combo_borda.getSelectedItem();
        double valor;

        if (valor1 > valor2) {
            valor = valor1;
        } else {
            valor = valor2;
        }

        Object[] produto = {
            1,
            pizza,
            valor
        };

        ViewPedido.addProduto(produto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pizza1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_pizza2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        combo_borda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tb_pizza1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Produto", "Valor"
            }
        ));
        tb_pizza1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pizza1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_pizza1);

        tb_pizza2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Produto", "Valor"
            }
        ));
        tb_pizza2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pizza2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_pizza2);

        jButton1.setText("Adicionar ao pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combo_borda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calabresa", "Calabresa com Catupiry", "Cheddar", "Cream Cheese Philadelphia", "Gergelim", "Mista (Requeijão e Cheddar)", "Requeijão" }));
        combo_borda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_bordaActionPerformed(evt);
            }
        });

        jLabel2.setText("Borda: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_borda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_borda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_pizza1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pizza1MouseClicked

    }//GEN-LAST:event_tb_pizza1MouseClicked

    private void tb_pizza2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pizza2MouseClicked

    }//GEN-LAST:event_tb_pizza2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adicionarPizza();

        int continua = JOptionPane.showConfirmDialog(null, "Deseja adicionar outra ?");

        if (continua > 0) {
            AddMeiaPedido.this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_bordaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_bordaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_bordaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddMeiaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMeiaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMeiaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMeiaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMeiaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_borda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_pizza1;
    private javax.swing.JTable tb_pizza2;
    // End of variables declaration//GEN-END:variables
}
