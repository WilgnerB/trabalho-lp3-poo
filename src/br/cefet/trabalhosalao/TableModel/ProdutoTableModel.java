/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;


import br.cefet.trabalhosalao.Model.Bean.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samuelson
 */
public class ProdutoTableModel extends AbstractTableModel {

    private List<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome", "Quantidade", "Valor","DataEnt"};

    public ProdutoTableModel(List<Produto> d) {
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
                return dados.get(linha).getCdProduto();
            case 1:
                return dados.get(linha).getNmProduto();
            case 2:
                return dados.get(linha).getQtdProduto();
            case 3:
                return dados.get(linha).getVlAtual();
            case 4:
                return dados.get(linha).getDtEntrada();
        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdProduto(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNmProduto((String) valor);
                break;
            case 2:
                dados.get(linha).setQtdProduto(Integer.parseInt((String) valor));
                break;
            case 3:
                dados.get(linha).setVlAtual(Double.parseDouble((String) valor));
                break;
            case 4:
                dados.get(linha).setDtEntrada((java.sql.Date) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(Produto p) {
        this.dados.add(p);
        this.fireTableDataChanged();
    }

    public Produto getRow(int linha) {
        return dados.get(linha);
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Produto> getList() {
        return dados;
    }
}
