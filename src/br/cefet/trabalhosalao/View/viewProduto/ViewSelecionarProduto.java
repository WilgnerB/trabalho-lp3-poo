/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.View.viewProduto;

import br.cefet.trabalhosalao.Model.Bean.Produto;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import br.cefet.trabalhosalao.System.ISalao;
import br.cefet.trabalhosalao.System.Salao;
import br.cefet.trabalhosalao.TableModel.ProdutoTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author wilgn
 */
public class ViewSelecionarProduto extends javax.swing.JDialog {
    ISalao salao;
    ProdutoTableModel tableModelProduto;
    Produto p;
    
    public ViewSelecionarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        salao = Salao.getInstance();

        initComponents();

        try {
            readJTable();
        } catch (DaoException ex) {
            System.out.println(ex.getMessage());
        }

        setTitle("Controle De Produtos");
        this.setLocationRelativeTo(null);
    }
    
    public void readJTable() throws DaoException {
        tableModelProduto = new ProdutoTableModel(salao.getProdutos());
        jTProdutos.setModel(tableModelProduto);
    }

    public void readJTableForNome(String nome) throws DaoException {
        tableModelProduto = new ProdutoTableModel(salao.getProdutosPorNome(nome));
        jTProdutos.setModel(tableModelProduto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Nome: ");
        jPanel3.add(jLabel1);

        jTextField1.setColumns(15);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField1);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTProdutos);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        p=null;
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTProdutos.getSelectedRow() != -1) {
            p=tableModelProduto.getRow(jTProdutos.getSelectedRow());
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Produto para confirmar.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {
            readJTableForNome(jTextField1.getText());
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(null, "Pau Fico Doido");
        }
    }//GEN-LAST:event_jTextField1KeyTyped

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
            java.util.logging.Logger.getLogger(ViewSelecionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSelecionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSelecionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSelecionarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewSelecionarProduto dialog = new ViewSelecionarProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public Produto getProduto() {
        return p;
    }
}