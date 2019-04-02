/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;

import br.cefet.trabalhosalao.Model.Bean.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wilgn
 */
public class EnderecoTableModel extends AbstractTableModel{

    private List<Endereco> dados=new ArrayList<>();
    private String[] colunas={"Id","UF","Numero","Cidade","Bairro","CEP","Logradouro"};

    public EnderecoTableModel(List<Endereco> d) {
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
                return dados.get(linha).getCdEndereco();
            case 1:
                return dados.get(linha).getUF();
            case 2:
                return dados.get(linha).getNumero();
            case 3:
                return dados.get(linha).getCidade();
            case 4:
                return dados.get(linha).getBairro();
            case 5:
                return dados.get(linha).getCEP();
            case 6:
                return dados.get(linha).getLogradouro();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdEndereco(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setUF((String) valor);
                break;
            case 2:
                dados.get(linha).setNumero(Integer.parseInt((String) valor));
                break;
            case 3:
                dados.get(linha).setCidade((String) valor);
                break;
            case 4:
                dados.get(linha).setBairro((String) valor);
                break;
            case 5:
                dados.get(linha).setCEP((String) valor);
                break;
            case 6:
                dados.get(linha).setLogradouro((String) valor);
                break;
        }  
            
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(Endereco e) {
        this.dados.add(e);
        this.fireTableDataChanged();
    }

    public Endereco getRow(int linha) {
        return dados.get(linha);
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<Endereco> getList() {
        return dados;
    }
}
