/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;

import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuelson
 */
public class PessoaTableModel extends AbstractTableModel {

    private List<Pessoa> dados = new ArrayList<>();
    private final String[] colunas = {"Id", "Nome", "Telefone", "Data Nasc.","CPF"};

    public PessoaTableModel(List<Pessoa> d) {
        super();
        this.dados = d;
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
                return dados.get(linha).getCdPessoa();
            case 1:
                return dados.get(linha).getNmPessoa();
            case 2:
                return dados.get(linha).getTelefone();
            case 3:
                return dados.get(linha).getDtNasc();
            case 4:
                return dados.get(linha).getCpf();
        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdPessoa(Integer.parseInt((String) valor));
            case 1:
                dados.get(linha).setNmPessoa((String) valor);
                break;
            case 2:
                dados.get(linha).setTelefone((String) valor);
                break;
            case 3:
                dados.get(linha).setDtNasc((java.sql.Date) valor);
                break;
            case 4:
                dados.get(linha).setCpf((String) valor);
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(Pessoa p) {
        this.dados.add(p);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Pessoa getRow(int linha) {
        return dados.get(linha);
    }

    public List<Pessoa> getList() {
        return dados;
    }

}
