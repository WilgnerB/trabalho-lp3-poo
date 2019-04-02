/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;

import br.cefet.trabalhosalao.Model.Bean.Profissao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nic
 */
public class ProfissaoTableModel extends AbstractTableModel {

    private List<Profissao> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome"};

    public ProfissaoTableModel(List<Profissao> s) {
        super();
        this.dados = s;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return dados.get(linha).getCdProfissao();
            case 1:
                return dados.get(linha).getNmProfissao();

        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdProfissao(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNmProfissao((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(Profissao s) {
        this.dados.add(s);
        this.fireTableDataChanged();
    }

    public Profissao getRow(int linha) {
        return dados.get(linha);
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Profissao> getList() {
        return dados;
    }
}

