/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;

import br.cefet.trabalhosalao.Model.Bean.servicoTipo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nic
 */
public class ServicoTipoTableModel extends AbstractTableModel {

    private List<servicoTipo> dados = new ArrayList<>();
    private String[] colunas = {"Id", "NmServico", "VlAtual", "IdTipo", "NmTipo"};

    public ServicoTipoTableModel(List<servicoTipo> s) {
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
                return dados.get(linha).getCdServico();
            case 1:
                return dados.get(linha).getNmServico();
            case 2:
                return dados.get(linha).getVlAtual();
            case 3:
                return dados.get(linha).getCdTipo();
            case 4:
                return dados.get(linha).getNmTipo();

        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdServico(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNmServico((String) valor);
                break;
            case 2:
                dados.get(linha).setVlAtual(Double.parseDouble((String) valor));
                break;
            case 3:
                dados.get(linha).setCdTipo(Integer.parseInt((String) valor));
                break;
            case 4:
                dados.get(linha).setNmTipo((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(servicoTipo s) {
        this.dados.add(s);
        this.fireTableDataChanged();
    }

    public servicoTipo getRow(int linha) {
        return dados.get(linha);
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<servicoTipo> getList() {
        return dados;
    }
}
