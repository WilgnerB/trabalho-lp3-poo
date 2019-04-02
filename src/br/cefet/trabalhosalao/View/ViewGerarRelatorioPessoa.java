/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.View;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import br.cefet.trabalhosalao.Model.DAO.PessoaDao;
import br.cefet.trabalhosalao.Relatorios.PessoaRelatorio;
import br.cefet.trabalhosalao.System.ISalao;
import br.cefet.trabalhosalao.System.Salao;
import br.cefet.trabalhosalao.TableModel.PessoaTableModel;
import br.cefet.trabalhosalao.View.telasSeleção.ViewMenu;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas
 */
public class ViewGerarRelatorioPessoa extends javax.swing.JFrame {

    ISalao salao;
    PessoaTableModel tableModelPessoas;
    java.sql.Date dtMenor = null;
    java.sql.Date dtMaior = null;

    /**
     * Creates new form Teste2JFrame
     */
    public ViewGerarRelatorioPessoa() {
        initComponents();
        salao = Salao.getInstance();

        try {
            readJTable();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Erro", JOptionPane.HEIGHT);
        }

        setTitle("Controle De Pessoas");
        this.setLocationRelativeTo(null);
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
        txtDtMenor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDtMaior = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Gerar Relatorio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Data de Nascimento:");
        jPanel3.add(jLabel1);

        txtDtMenor.setMinimumSize(new java.awt.Dimension(50, 24));
        txtDtMenor.setPreferredSize(new java.awt.Dimension(50, 24));
        txtDtMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDtMenorActionPerformed(evt);
            }
        });
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##-##-####");
            txtDtMenor= new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jPanel3.add(txtDtMenor);

        jLabel2.setText("ate");
        jPanel3.add(jLabel2);

        txtDtMaior.setMinimumSize(new java.awt.Dimension(50, 24));
        txtDtMaior.setPreferredSize(new java.awt.Dimension(50, 24));
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##-##-####");
            txtDtMaior= new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jPanel3.add(txtDtMaior);

        jLabel3.setText("Nome:");
        jPanel3.add(jLabel3);

        txtNome.setMinimumSize(new java.awt.Dimension(50, 24));
        txtNome.setPreferredSize(new java.awt.Dimension(50, 24));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel3.add(txtNome);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonPesquisar);

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

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
        jTProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewMenu frame = new ViewMenu();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dtMenor = new java.sql.Date(format.parse(txtDtMenor.getText()).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dtMaior = new java.sql.Date(format.parse(txtDtMaior.getText()).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(dtMenor+" "+dtMaior);
        try {
            readJTableRelatorio();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Erro", JOptionPane.HEIGHT);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    public void readJTableRelatorio() throws DaoException {
        tableModelPessoas = new PessoaTableModel(salao.getPessoasRelatorio(dtMenor,dtMaior,txtNome.getText()));
        jTProdutos.setModel(tableModelPessoas);
    }

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
    }//GEN-LAST:event_jTProdutosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PessoaRelatorio pRel = new PessoaRelatorio();
        pRel.emitirRelatorio(tableModelPessoas.getList());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtDtMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDtMenorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtMenorActionPerformed

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
            java.util.logging.Logger.getLogger(ViewGerarRelatorioPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGerarRelatorioPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGerarRelatorioPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGerarRelatorioPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGerarRelatorioPessoa().setVisible(true);
            }
        });
    }

    public void readJTable() throws DaoException {
        tableModelPessoas = new PessoaTableModel(salao.getPessoas());
        jTProdutos.setModel(tableModelPessoas);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField txtDtMaior;
    private javax.swing.JTextField txtDtMenor;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}