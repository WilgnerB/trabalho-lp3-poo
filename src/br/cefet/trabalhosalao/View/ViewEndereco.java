/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.View;

import br.cefet.trabalhosalao.Model.Bean.Endereco;
import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import br.cefet.trabalhosalao.System.ISalao;
import br.cefet.trabalhosalao.System.Salao;
import br.cefet.trabalhosalao.TableModel.EnderecoTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ViewEndereco extends javax.swing.JFrame {

    ISalao salao;
    EnderecoTableModel tableModelEndereco;
    Pessoa p;

    ViewEndereco(Pessoa p) {
        this.p=p;
        salao = Salao.getInstance();

        initComponents();

        this.setComboBoxUF();
        txtIDPessoa.setText(p.getCdPessoa()+"");

        try {
            readJTable();
        } catch (DaoException ex) {
            System.out.println(ex.getMessage());
        }

        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false,true, false, false, false);

        setTitle("Controle De Produtos");
        this.setLocationRelativeTo(null);
    }

    public void setSize() {
        jTEnderecos.getColumnModel().getColumn(0).setPreferredWidth(87);
        jTEnderecos.getColumnModel().getColumn(0).setResizable(false);
        jTEnderecos.getColumnModel().getColumn(1).setPreferredWidth(88);
        jTEnderecos.getColumnModel().getColumn(1).setResizable(false);
        jTEnderecos.getColumnModel().getColumn(2).setPreferredWidth(87);
        jTEnderecos.getColumnModel().getColumn(2).setResizable(false);
        jTEnderecos.getColumnModel().getColumn(3).setPreferredWidth(88);
        jTEnderecos.getColumnModel().getColumn(3).setResizable(false);
        jTEnderecos.getColumnModel().getColumn(4).setPreferredWidth(87);
        jTEnderecos.getColumnModel().getColumn(4).setResizable(false);
        jTEnderecos.getColumnModel().getColumn(5).setPreferredWidth(88);
        jTEnderecos.getColumnModel().getColumn(5).setResizable(false);
        jTEnderecos.getColumnModel().getColumn(6).setPreferredWidth(87);
        jTEnderecos.getColumnModel().getColumn(6).setResizable(false);
    }

    public void setEnabledComponents(boolean btExcluir, boolean btSair, boolean btAtualizar, boolean btConfirmar, boolean btCancelar, boolean btCadastrar, boolean jTEnderecos,
            boolean txtCidade, boolean txtCEP, boolean txtBairro, boolean txtBuscaLogra,boolean ComboBoxUF, boolean txtNumero, boolean txtLogradouro) {
        this.btExcluir.setEnabled(btExcluir);
        this.btSair.setEnabled(btSair);
        this.btAtualizar.setEnabled(btAtualizar);
        this.btConfirmar.setEnabled(btConfirmar);
        this.btCancelar.setEnabled(btCancelar);
        this.btCadastrar.setEnabled(btCadastrar);
        this.jTEnderecos.setEnabled(jTEnderecos);

        this.txtCidade.setEnabled(txtCidade);
        this.txtCEP.setEnabled(txtCEP);
        this.txtBairro.setEnabled(txtBairro);
        this.txtBuscaLogra.setEnabled(txtBuscaLogra);
        this.ComboBoxUF.setEnabled(ComboBoxUF);
        this.txtNumero.setEnabled(txtNumero);
        this.txtLogradouro.setEnabled(txtLogradouro);
    }

    public void setComboBoxUF() {
        ComboBoxUF.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"}));

    }

    public void readJTable() throws DaoException {
        tableModelEndereco = new EnderecoTableModel(salao.getEnderecos(p.getCdPessoa()));
        jTEnderecos.setModel(tableModelEndereco);
        setSize();
    }

    public void readJTableForDesc(String logra) throws DaoException {
        tableModelEndereco = new EnderecoTableModel(salao.getEnderecosPorLogra(logra,p.getCdPessoa()));
        jTEnderecos.setModel(tableModelEndereco);
        setSize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelValoresProd = new javax.swing.JPanel();
        txtBairro = new javax.swing.JTextField();
        lbPreco = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        lbQuantidade = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIDPessoa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ComboBoxUF = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lbQuantidade1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        PaneTbProd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEnderecos = new javax.swing.JTable();
        txtBuscaLogra = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Gerenciar De Endereços");

        PanelValoresProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        lbPreco.setText("CEP");

        txtCEP.setText("12.345-678  ");
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##.###-###");
            txtCEP = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }

        lbQuantidade.setText("Bairro");

        lbNome.setText("Cidade");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txtLogradouro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroActionPerformed(evt);
            }
        });

        jLabel2.setText("Logradouro");

        txtIDPessoa.setEditable(false);
        txtIDPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPessoaActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Pessoa");

        ComboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("UF");

        lbQuantidade1.setText("Numero");

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelValoresProdLayout = new javax.swing.GroupLayout(PanelValoresProd);
        PanelValoresProd.setLayout(PanelValoresProdLayout);
        PanelValoresProdLayout.setHorizontalGroup(
            PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(lbQuantidade)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(txtBairro)
                                .addContainerGap())))
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtIDPessoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(ComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero)
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(lbQuantidade1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(lbPreco)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2))
                            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        PanelValoresProdLayout.setVerticalGroup(
            PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelValoresProdLayout.createSequentialGroup()
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelValoresProdLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelValoresProdLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbQuantidade1)
                        .addGap(34, 34, 34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelValoresProdLayout.createSequentialGroup()
                        .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbQuantidade)
                            .addComponent(lbNome))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPreco)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelValoresProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PaneTbProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "UF", "Numero", "Cidade", "Bairro", "CEP", "Logradouro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTEnderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEnderecosMouseClicked(evt);
            }
        });
        jTEnderecos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTEnderecosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTEnderecos);

        txtBuscaLogra.setText("Logradouro...");
        txtBuscaLogra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscaLograMouseClicked(evt);
            }
        });
        txtBuscaLogra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaLograActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaneTbProdLayout = new javax.swing.GroupLayout(PaneTbProd);
        PaneTbProd.setLayout(PaneTbProdLayout);
        PaneTbProdLayout.setHorizontalGroup(
            PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneTbProdLayout.createSequentialGroup()
                .addGroup(PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneTbProdLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscaLogra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE))
                .addContainerGap())
        );
        PaneTbProdLayout.setVerticalGroup(
            PaneTbProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneTbProdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscaLogra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
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
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btAtualizar)
                    .addComponent(btCadastrar)
                    .addComponent(btConfirmar)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(PanelValoresProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PaneTbProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PaneTbProd, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelValoresProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false,true, false, false, false);

        txtID.setText("");
        ComboBoxUF.setSelectedItem("");
        txtNumero.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtCEP.setText("  .   -  ");
        txtLogradouro.setText("");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        if (btCadastrar.isEnabled() == true && btAtualizar.isEnabled() == false && btExcluir.isEnabled() == false) {
            try {
                Endereco e = new Endereco();
                e.setBairro(txtBairro.getText());
                e.setCEP(txtCEP.getText());
                e.setCidade(txtCidade.getText());
                e.setLogradouro(txtLogradouro.getText());
                e.setNumero(Integer.parseInt(txtNumero.getText()));
                e.setUF((String) ComboBoxUF.getSelectedItem());

                int i = salao.createEndereco(e,p.getCdPessoa());

                JOptionPane.showMessageDialog(null, "Produto Criado Com Sucesso!");
            } catch (DaoException ex) {
                JOptionPane.showMessageDialog(null, "Falha na Criação do Produto! " + ex.getMessage());
            }
        } else {
            if (btCadastrar.isEnabled() == false && btAtualizar.isEnabled() == true && btExcluir.isEnabled() == false) {
                try {
                    Endereco e = new Endereco();
                    e.setCdEndereco((int) jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 0));
                    e.setBairro(txtBairro.getText());
                    e.setCEP(txtCEP.getText());
                    e.setCidade(txtCidade.getText());
                    e.setLogradouro(txtLogradouro.getText());
                    e.setNumero(Integer.parseInt(txtNumero.getText()));
                    e.setUF((String) ComboBoxUF.getSelectedItem());
                    
                    salao.updateEnderecos(e);
                    
                    JOptionPane.showMessageDialog(null, "Produto Alterado Com Sucesso!");
                } catch (DaoException ex) {
                    JOptionPane.showMessageDialog(null, "Falha na Alteração do Produto! " + ex.getMessage());
                }
            }
        }

        this.setEnabledComponents(true, true, true, false, false, true, true,
                false, false, false,true, false, false, false);

        txtID.setText("");
        ComboBoxUF.setSelectedItem("");
        txtNumero.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtCEP.setText("  .   -  ");
        txtLogradouro.setText("");

        try {
            readJTable();
        } catch (DaoException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTEnderecos.getSelectedRow() != -1) {
            ViewExclusaoEndereco frame = new ViewExclusaoEndereco(tableModelEndereco.getRow(jTEnderecos.getSelectedRow()),p);
            frame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        ViewPessoa frame = new ViewPessoa();
        frame.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if (jTEnderecos.getSelectedRow() != -1) {
            this.setEnabledComponents(false, false, true, true, true, false, false,
                    true, true,true, false, true, true, true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar.");
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        this.setEnabledComponents(false, false, false, true, true, true, false,
                true, true,true, false, true, true, true);

        txtID.setText("");
        ComboBoxUF.setSelectedItem("");
        txtNumero.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtCEP.setText("  .   -  ");
        txtLogradouro.setText("");
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void txtBuscaLograActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaLograActionPerformed
        try {
            readJTableForDesc(txtBuscaLogra.getText());
        } catch (DaoException ex) {
            Logger.getLogger(ViewEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscaLograActionPerformed

    private void txtBuscaLograMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaLograMouseClicked
        txtBuscaLogra.setText("");
    }//GEN-LAST:event_txtBuscaLograMouseClicked

    private void jTEnderecosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnderecosKeyReleased
        if (jTEnderecos.getSelectedRow() != -1) {
            txtID.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 0).toString());
            ComboBoxUF.setSelectedItem(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 1).toString());
            txtNumero.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 2).toString());
            txtCidade.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 3).toString());
            txtBairro.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 4).toString());
            txtCEP.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 5).toString());
            txtLogradouro.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_jTEnderecosKeyReleased

    private void jTEnderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEnderecosMouseClicked
        if (jTEnderecos.getSelectedRow() != -1) {
            txtID.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 0).toString());
            ComboBoxUF.setSelectedItem(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 1).toString());
            txtNumero.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 2).toString());
            txtCidade.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 3).toString());
            txtBairro.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 4).toString());
            txtCEP.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 5).toString());
            txtLogradouro.setText(jTEnderecos.getValueAt(jTEnderecos.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_jTEnderecosMouseClicked

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtIDPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPessoaActionPerformed

    private void txtLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxUF;
    private javax.swing.JPanel PaneTbProd;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelValoresProd;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEnderecos;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPreco;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbQuantidade1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBuscaLogra;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDPessoa;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
