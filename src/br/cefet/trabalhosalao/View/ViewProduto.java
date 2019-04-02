/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.View;

import br.cefet.trabalhosalao.Controller.ControlException;
import br.cefet.trabalhosalao.Model.Bean.Produto;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import br.cefet.trabalhosalao.System.ISalao;
import br.cefet.trabalhosalao.System.Salao;
import br.cefet.trabalhosalao.TableModel.ProdutoTableModel;
import br.cefet.trabalhosalao.View.telasSeleção.ViewMenu;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ViewProduto extends javax.swing.JFrame {

    ISalao salao;
    ProdutoTableModel tableModelProdutos;

    public ViewProduto() {
        salao = Salao.getInstance();

        initComponents();

        try {
            readJTable();
        } catch (DaoException d) {
            System.out.println(d.getMessage());
        }
        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false, true);

        setTitle("Controle De Produtos");
        this.setLocationRelativeTo(null);
    }

    public void setSize() {
        jTProdutos.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTProdutos.getColumnModel().getColumn(0).setResizable(false);
        jTProdutos.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTProdutos.getColumnModel().getColumn(1).setResizable(false);
        jTProdutos.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTProdutos.getColumnModel().getColumn(2).setResizable(false);
        jTProdutos.getColumnModel().getColumn(3).setPreferredWidth(25);
        jTProdutos.getColumnModel().getColumn(3).setResizable(false);
        jTProdutos.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTProdutos.getColumnModel().getColumn(4).setResizable(false);
    }

    public void setEnabledComponents(boolean btExcluir, boolean btSair, boolean btAtualizar, boolean btConfirmar, boolean btCancelar, boolean btCadastrar, boolean jTProdutos,
            boolean txtNome, boolean txtPreco, boolean txtQtd, boolean txtBuscaDesc) {
        this.btExcluir.setEnabled(btExcluir);
        this.btSair.setEnabled(btSair);
        this.btAtualizar.setEnabled(btAtualizar);
        this.btConfirmar.setEnabled(btConfirmar);
        this.btCancelar.setEnabled(btCancelar);
        this.btCadastrar.setEnabled(btCadastrar);
        this.jTProdutos.setEnabled(jTProdutos);

        this.txtNome.setEnabled(txtNome);
        this.txtPreco.setEnabled(txtPreco);
        this.txtQtd.setEnabled(txtQtd);
        this.txtBuscaDesc.setEnabled(txtBuscaDesc);
    }

    public void readJTable() throws DaoException {
        tableModelProdutos = new ProdutoTableModel(salao.getProdutos());
        jTProdutos.setModel(tableModelProdutos);
        setSize();
    }

    public void readJTableForDesc(String nome) throws DaoException {
        tableModelProdutos = new ProdutoTableModel(salao.getProdutosPorNome(nome));
        jTProdutos.setModel(tableModelProdutos);
        setSize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelValoresProd = new javax.swing.JPanel();
        txtQtd = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lbQuantidade = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PaneTbProd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        txtBuscaDesc = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Gerenciar De Produtos");

        PanelValoresProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbPreco.setText("Preço");

        lbQuantidade.setText("Quantidade");

        lbNome.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txtDt.setEditable(false);
        txtDt.setText("dd/MM/yyyy");
        txtDt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDtActionPerformed(evt);
            }
        });

        jLabel2.setText("Data");

        javax.swing.GroupLayout PanelValoresProdLayout = new javax.swing.GroupLayout(PanelValoresProd);
        PanelValoresProd.setLayout(PanelValoresProdLayout);
        PanelValoresProdLayout.setHorizontalGroup(
            PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(4, 4, 4)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDt)
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbQuantidade)
                            .addComponent(txtQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                    .addComponent(lbPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelValoresProdLayout.setVerticalGroup(
            PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNome)
                        .addGap(30, 30, 30))
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addComponent(lbQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(lbPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PaneTbProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jTProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);

        txtBuscaDesc.setText("Nome...");
        txtBuscaDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscaDescMouseClicked(evt);
            }
        });
        txtBuscaDesc.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBuscaDescInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtBuscaDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaDescActionPerformed(evt);
            }
        });
        txtBuscaDesc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtBuscaDescPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout PaneTbProdLayout = new javax.swing.GroupLayout(PaneTbProd);
        PaneTbProd.setLayout(PaneTbProdLayout);
        PaneTbProdLayout.setHorizontalGroup(
            PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneTbProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PaneTbProdLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBuscaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        PaneTbProdLayout.setVerticalGroup(
            PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneTbProdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );

        jPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCadastrar)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir)
                        .addComponent(btAtualizar))
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btConfirmar)
                        .addComponent(btCancelar))
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelValoresProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaneTbProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelValoresProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PaneTbProd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (btCadastrar.isEnabled() == true && btAtualizar.isEnabled() == false && btExcluir.isEnabled() == false) {
            try {

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
                Produto p = salao.validateProduto(txtNome.getText(),Integer.parseInt(txtQtd.getText()),Double.parseDouble(txtPreco.getText()));
                p.setDtEntrada(data);

                int i = salao.createProduto(p);

                JOptionPane.showMessageDialog(null, "Produto Criado Com Sucesso!");
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(null, "Falha na Criação do Produto! " + ex.getMessage());
                     JOptionPane.showMessageDialog(null, "Falha na validação dos dados do Produto! " + ex.getMessage());            
            } catch (ControlException ex) {
                JOptionPane.showMessageDialog(null, "Falha na validação dos dados do Produto! " + ex.getMessage());            
            }
        } else {
            if (btCadastrar.isEnabled() == false && btAtualizar.isEnabled() == true && btExcluir.isEnabled() == false) {
                try {
                    Produto p = salao.validateProduto(txtNome.getText(),Integer.parseInt(txtQtd.getText()),Double.parseDouble(txtPreco.getText()));
                    p.setCdProduto((int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));


                    salao.updateProduto(p);

                    JOptionPane.showMessageDialog(null, "Produto Alterado Com Sucesso!");
                } catch (DaoException ex) {
                    JOptionPane.showMessageDialog(null, "Falha na Alteração do Produto! " + ex.getMessage());
                } catch (ControlException ex) {
                JOptionPane.showMessageDialog(null, "Falha na validação dos dados do Produto! " + ex.getMessage());      
                }
            }
        }

        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false, true);

        txtQtd.setText("");
        txtPreco.setText("");
        txtNome.setText("");
        txtID.setText("");
        txtDt.setText("dd/MM/yyyy");

        try {
            readJTable();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTProdutos.getSelectedRow() != -1) {
            ViewExclusaoProduto frame = new ViewExclusaoProduto(tableModelProdutos.getRow(jTProdutos.getSelectedRow()));
            frame.setVisible(true);

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        ViewMenu frame = new ViewMenu();
        frame.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if (jTProdutos.getSelectedRow() != -1) {
            this.setEnabledComponents(false, false, true, true, true, false, false,
                    true, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar.");
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        this.setEnabledComponents(false, false, false, true, true, true, false,
                true, true, true, true);

        txtQtd.setText("");
        txtPreco.setText("");
        txtNome.setText("");
        txtID.setText("");
        txtDt.setText("dd/MM/yyyy");

    }//GEN-LAST:event_btCadastrarActionPerformed

//        public void setEnabledComponents(boolean btExcluir, boolean btSair, boolean btAtualizar, boolean btConfirmar, boolean btCancelar, boolean btCadastrar,
//                                     boolean txtCidade, boolean txtCEP, boolean txtBairro, boolean txtBuscaLogra,boolean txtNumero,boolean txtLogradouro) {
//        this.btExcluir.setEnabled(btExcluir);
//        this.btSair.setEnabled(btSair);
//        this.btAtualizar.setEnabled(btAtualizar);
//        this.btConfirmar.setEnabled(btConfirmar);
//        this.btCancelar.setEnabled(btCancelar);
//        this.btCadastrar.setEnabled(btCadastrar);
//
//        this.txtCidade.setEnabled(txtCidade);
//        this.txtCEP.setEnabled(txtCEP);
//        this.txtBairro.setEnabled(txtBairro);
//        this.txtBuscaLogra.setEnabled(txtBuscaLogra);
//        this.ComboBoxUF.setEnabled(btSair);
//        this.txtNumero.setEnabled(txtNumero);
//        this.txtLogradouro.setEnabled(txtLogradouro);
//    }

    private void txtBuscaDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaDescActionPerformed
        try {
            readJTableForDesc(txtBuscaDesc.getText());
        } catch (DaoException ex) {
            Logger.getLogger(ViewProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscaDescActionPerformed

    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutosKeyReleased
        if (jTProdutos.getSelectedRow() != -1) {
            txtID.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0).toString());
            txtNome.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
            txtQtd.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            txtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            txtDt.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTProdutosKeyReleased

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
        if (jTProdutos.getSelectedRow() != -1) {
            txtID.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0).toString());
            txtNome.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
            txtQtd.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            txtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            txtDt.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTProdutosMouseClicked

    private void txtDtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtBuscaDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaDescMouseClicked
        txtBuscaDesc.setText("");
    }//GEN-LAST:event_txtBuscaDescMouseClicked

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        txtQtd.setText("");
        txtPreco.setText("");
        txtNome.setText("");
        txtID.setText("");
        txtDt.setText("dd/MM/yyyy");

        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false, true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txtBuscaDescInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBuscaDescInputMethodTextChanged

    }//GEN-LAST:event_txtBuscaDescInputMethodTextChanged

    private void txtBuscaDescPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBuscaDescPropertyChange

    }//GEN-LAST:event_txtBuscaDescPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaneTbProd;
    private javax.swing.JPanel PanelValoresProd;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JTextField txtBuscaDesc;
    private javax.swing.JTextField txtDt;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
