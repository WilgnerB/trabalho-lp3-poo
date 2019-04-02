/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.View;

import br.cefet.trabalhosalao.Controller.ControlException;
import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import br.cefet.trabalhosalao.Model.DAO.PessoaDao;
import br.cefet.trabalhosalao.System.ISalao;
import br.cefet.trabalhosalao.System.Salao;
import br.cefet.trabalhosalao.TableModel.PessoaTableModel;
import br.cefet.trabalhosalao.View.telasSeleção.ViewMenu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ViewPessoa extends javax.swing.JFrame {

    ISalao salao;
    PessoaTableModel tableModelPessoa;

    public ViewPessoa() {
        salao = Salao.getInstance();

        initComponents();

        try {
            readJTable();
        } catch (DaoException ex) {
            System.out.println(ex.getMessage());
        }

        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false, true, false);

        setTitle("Controle De Pessoas");
        this.setLocationRelativeTo(null);
    }

    public void setSize() {

        jTPessoas.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTPessoas.getColumnModel().getColumn(0).setResizable(false);
        jTPessoas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTPessoas.getColumnModel().getColumn(1).setResizable(false);
        jTPessoas.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTPessoas.getColumnModel().getColumn(2).setResizable(false);
        jTPessoas.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTPessoas.getColumnModel().getColumn(3).setResizable(false);
        jTPessoas.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTPessoas.getColumnModel().getColumn(4).setResizable(false);

    }

    public void setEnabledComponents(boolean btExcluir, boolean btSair, boolean btAtualizar, boolean btConfirmar, boolean btCancelar, boolean btCadastrar, boolean jTPessoas,
            boolean txtNome, boolean txtTelefone, boolean txtCPF, boolean txtBuscaNome, boolean txtData) {

        this.btExcluir.setEnabled(btExcluir);
        this.btSair.setEnabled(btSair);
        this.btAtualizar.setEnabled(btAtualizar);
        this.btConfirmar.setEnabled(btConfirmar);
        this.btCancelar.setEnabled(btCancelar);
        this.btCadastrar.setEnabled(btCadastrar);
        this.jTPessoas.setEnabled(jTPessoas);

        this.txtNome.setEnabled(txtNome);
        this.txtTelefone.setEnabled(txtTelefone);
        this.txtCPF.setEnabled(txtCPF);
        this.txtBuscaNome.setEnabled(txtBuscaNome);
        this.txtData.setEnabled(txtData);
    }

    public void readJTable() throws DaoException {
        tableModelPessoa = new PessoaTableModel(salao.getPessoas());
        jTPessoas.setModel(tableModelPessoa);
        setSize();
    }

    public void readJTableForNome(String nome) throws DaoException {
        tableModelPessoa = new PessoaTableModel(salao.getPessoasPorNome(nome));
        jTPessoas.setModel(tableModelPessoa);
        setSize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelValoresProd = new javax.swing.JPanel();
        txtCPF = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lbQuantidade = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        PaneTbProd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPessoas = new javax.swing.JTable();
        txtBuscaNome = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Gerenciar De Pessoas");

        PanelValoresProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCPF.setText("123.456.789-10");
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("###.###.###-##");
            txtCPF= new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }

        lbPreco.setText("Telefone");

        txtTelefone.setText("(12)93456-7890");
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("(##)9####-####");
            txtTelefone= new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        lbQuantidade.setText("CPF");

        lbNome.setText("NOME");

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

        txtData.setText("dd/MM/yyyy");
        txtData.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##-##-####");
            txtData= new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }

        jLabel2.setText("Data Nasc.");

        jButton1.setText("Enderecos...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ver Enderecos");

        javax.swing.GroupLayout PanelValoresProdLayout = new javax.swing.GroupLayout(PanelValoresProd);
        PanelValoresProd.setLayout(PanelValoresProdLayout);
        PanelValoresProdLayout.setHorizontalGroup(
            PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelValoresProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNome)
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addComponent(txtTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addComponent(lbPreco)
                                    .addComponent(jLabel6))
                                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel2))
                                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(lbQuantidade)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jButton1))))
                .addContainerGap())
        );
        PanelValoresProdLayout.setVerticalGroup(
            PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNome)
                        .addGap(30, 30, 30))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPreco)
                    .addComponent(lbQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PaneTbProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data Nasc.", "Telefone", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPessoasMouseClicked(evt);
            }
        });
        jTPessoas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPessoasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTPessoas);

        txtBuscaNome.setText("Nome...");
        txtBuscaNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscaNomeMouseClicked(evt);
            }
        });
        txtBuscaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaneTbProdLayout = new javax.swing.GroupLayout(PaneTbProd);
        PaneTbProd.setLayout(PaneTbProdLayout);
        PaneTbProdLayout.setHorizontalGroup(
            PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneTbProdLayout.createSequentialGroup()
                .addGroup(PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PaneTbProdLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaneTbProdLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PaneTbProdLayout.setVerticalGroup(
            PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneTbProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
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
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(PanelValoresProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PaneTbProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelValoresProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PaneTbProd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (btCadastrar.isEnabled() == true && btAtualizar.isEnabled() == false && btExcluir.isEnabled() == false) {
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                java.sql.Date data = null;
                try {
                    data = new java.sql.Date(format.parse(txtData.getText()).getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pessoa p = salao.validatePessoa(txtCPF.getText(), txtNome.getText(), txtTelefone.getText(), data);

                int i = salao.createPessoa(p);

                JOptionPane.showMessageDialog(null, "Pessoa Criado Com Sucesso!");
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(null, "Falha na Criação do Pessoa! " + ex.getMessage());
            } catch (ControlException ex) {
                JOptionPane.showMessageDialog(null, "Falha na validação dos dados da Pessoa! " + ex.getMessage());
            }
        } else {
            if (btCadastrar.isEnabled() == false && btAtualizar.isEnabled() == true && btExcluir.isEnabled() == false) {
                try {
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    java.sql.Date data = null;
                    try {
                        data = new java.sql.Date(format.parse(txtData.getText()).getTime());
                    } catch (ParseException ex) {
                        Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Pessoa p = salao.validatePessoa(txtCPF.getText(), txtNome.getText(), txtTelefone.getText(), data);
                    p.setCdPessoa((int) jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 0));

                    salao.updatePessoa(p);

                    JOptionPane.showMessageDialog(null, "Pessoa Alterado Com Sucesso!");
                } catch (DaoException ex) {
                    JOptionPane.showMessageDialog(null, "Falha na Alteração da Pessoa! " + ex.getMessage());
                } catch (ControlException ex) {
                    JOptionPane.showMessageDialog(null, "Falha na validação dos dados da Pessoa! " + ex.getMessage());
                }
            }
        }

        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false, true, false);

        txtCPF.setText("");
        txtData.setText("");
        txtID.setText("");
        txtNome.setText("");
        txtTelefone.setText("");

        try {
            readJTable();
        } catch (DaoException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTPessoas.getSelectedRow() != -1) {
            ViewExclusaoPessoa frame = new ViewExclusaoPessoa(tableModelPessoa.getRow(jTPessoas.getSelectedRow()));
            frame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para excluir.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        ViewMenu frame = new ViewMenu();
        frame.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if (jTPessoas.getSelectedRow() != -1) {
            this.setEnabledComponents(false, false, true, true, true, false, false,
                    true, true, true, false, true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para atualizar.");
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        this.setEnabledComponents(false, false, false, true, true, true, false,
                true, true, true, false, true);

        txtCPF.setText("");
        txtData.setText("");
        txtID.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void txtBuscaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaNomeActionPerformed
        try {
            readJTableForNome(txtBuscaNome.getText());
        } catch (DaoException ex) {
            Logger.getLogger(ViewPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscaNomeActionPerformed

    private void jTPessoasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPessoasKeyReleased
        if (jTPessoas.getSelectedRow() != -1) {
            txtID.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 0).toString());
            txtNome.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 1).toString());
            txtTelefone.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 2).toString());
            txtData.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 3).toString());
            txtCPF.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTPessoasKeyReleased

    private void jTPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPessoasMouseClicked
        if (jTPessoas.getSelectedRow() != -1) {
            txtID.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 0).toString());
            txtNome.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 1).toString());
            txtTelefone.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 2).toString());
            txtData.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 3).toString());
            txtCPF.setText(jTPessoas.getValueAt(jTPessoas.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTPessoasMouseClicked

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtBuscaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaNomeMouseClicked
        txtBuscaNome.setText("");
    }//GEN-LAST:event_txtBuscaNomeMouseClicked

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false, true, false);

        txtCPF.setText("");
        txtData.setText("");
        txtID.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTPessoas.getSelectedRow() != -1) {
            ViewEndereco frame = new ViewEndereco(tableModelPessoa.getRow(jTPessoas.getSelectedRow()));
            frame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para ver os Endereços.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PaneTbProd;
    private javax.swing.JPanel PanelValoresProd;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPessoas;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JTextField txtBuscaNome;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
