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
public final class AddBebidaDB extends javax.swing.JFrame {

    /**
     * Creates new form addPizzaBD
     */
    public AddBebidaDB() {
        initComponents();
        setLocationRelativeTo(null);
        readJTable();
    }

    public void AdicionarDB() {
        model.conexao.crudBebida b = new model.conexao.crudBebida();
        model.conexao.ConnectionDB dao = new model.conexao.ConnectionDB();
        model.entities.Bebida bebida = new model.entities.Bebida();

        bebida.setNome(jtf_bebida.getText());
        bebida.setPreco(Double.parseDouble(jtf_valor.getText()));

        b.createBebida(bebida);
        readJTable();
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) tb_bebida.getModel();
        modelo.setNumRows(0);
        model.conexao.crudBebida crud = new model.conexao.crudBebida();

        crud.readBebida().forEach(p -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_bebida = new javax.swing.JTextField();
        jtf_valor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bebida = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da bebida:");

        jLabel2.setText("Valor:");

        tb_bebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Produto", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_bebida.getColumnModel().getColumn(0).setPreferredWidth(25);
        tb_bebida.getColumnModel().getColumn(1).setPreferredWidth(140);
        tb_bebida.getColumnModel().getColumn(2).setPreferredWidth(40);
        tb_bebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bebidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bebida);
        if (tb_bebida.getColumnModel().getColumnCount() > 0) {
            tb_bebida.getColumnModel().getColumn(0).setResizable(false);
            tb_bebida.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_bebida.getColumnModel().getColumn(1).setResizable(false);
            tb_bebida.getColumnModel().getColumn(1).setPreferredWidth(212);
            tb_bebida.getColumnModel().getColumn(2).setResizable(false);
            tb_bebida.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtf_valor)
                    .addComponent(jtf_bebida, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 233, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(51, 51, 51)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_bebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdicionarDB();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tb_bebida.getSelectedRow() != -1) {

            model.entities.Bebida b = new model.entities.Bebida();
            model.conexao.crudBebida dao = new model.conexao.crudBebida();

            b.setId((int) tb_bebida.getValueAt(tb_bebida.getSelectedRow(), 0));

            dao.deleteBebida(b);

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tb_bebida.getSelectedRow() != -1) {
            model.entities.Bebida b = new model.entities.Bebida();
            model.conexao.crudBebida dao = new model.conexao.crudBebida();
            
            b.setId((int) tb_bebida.getValueAt(tb_bebida.getSelectedRow(), 0));
            b.setNome(jtf_bebida.getText());
            b.setPreco(Double.parseDouble(jtf_valor.getText()));

            dao.atualizarBebida(b);

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tb_bebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bebidaMouseClicked

        jtf_bebida.setText((String) tb_bebida.getValueAt(tb_bebida.getSelectedRow(), 1));
        jtf_valor.setText(tb_bebida.getValueAt(tb_bebida.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tb_bebidaMouseClicked

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
            java.util.logging.Logger.getLogger(AddBebidaDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBebidaDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBebidaDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBebidaDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddBebidaDB().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jtf_bebida;
    private javax.swing.JTextField jtf_valor;
    private javax.swing.JTable tb_bebida;
    // End of variables declaration//GEN-END:variables
}
