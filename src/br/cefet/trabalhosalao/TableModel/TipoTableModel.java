/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;

import br.cefet.trabalhosalao.Model.Bean.Tipo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nic
 */
public class TipoTableModel extends AbstractTableModel {

    private List<Tipo> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome"};

    public TipoTableModel(List<Tipo> s) {
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
                return dados.get(linha).getCdTipo();
            case 1:
                return dados.get(linha).getNmTipo();

        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdTipo(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNmTipo((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(Tipo s) {
        this.dados.add(s);
        this.fireTableDataChanged();
    }

    public Tipo getRow(int linha) {
        return dados.get(linha);
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Tipo> getList() {
        return dados;
    }
}

