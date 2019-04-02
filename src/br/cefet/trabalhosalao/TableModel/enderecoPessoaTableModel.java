/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.TableModel;

import br.cefet.trabalhosalao.Model.Bean.enderecoPessoa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
    int cdPessoa;
    String nmPessoa;
    int cdEndereco;
    int numero;
    String logradouro;
    String cep;
    String cidade;
    String bairro;
    String uf;
 */
public class enderecoPessoaTableModel extends AbstractTableModel {

    private List<enderecoPessoa> dados = new ArrayList<>();
    private String[] colunas = {"Id Pessoa", "NmPessoa", "CdEndereco", "Numero", "Logradouro" , "CEP" , "Cidade" , "Bairro" , "UF"};

    public enderecoPessoaTableModel(List<enderecoPessoa> s) {
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
                return dados.get(linha).getCdPessoa();
            case 1:
                return dados.get(linha).getNmPessoa();
            case 2:
                return dados.get(linha).getCdEndereco();
            case 3:
                return dados.get(linha).getNumero();
            case 4:
                return dados.get(linha).getLogradouro();
            case 5:
                return dados.get(linha).getCep();
            case 6:
                return dados.get(linha).getCidade();
            case 7:
                return dados.get(linha).getBairro();
            case 8:
                return dados.get(linha).getUf();                

        }

        return null;

    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna) {
            case 0:
                dados.get(linha).setCdPessoa(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNmPessoa((String) valor);
                break;
            case 2:
                dados.get(linha).setCdEndereco(Integer.parseInt((String) valor));
                break;
            case 3:
                dados.get(linha).setNumero(Integer.parseInt((String) valor));
                break;
            case 4:
                dados.get(linha).setLogradouro((String) valor);
                break;
            case 5:
                dados.get(linha).setCep((String) valor);
                break;            
            case 6:
                dados.get(linha).setCidade((String) valor);
                break;                
            case 7:
                dados.get(linha).setBairro((String) valor);
                break;                
            case 8:
                dados.get(linha).setUf((String) valor);
                break;                
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }

    public void addRow(enderecoPessoa s) {
        this.dados.add(s);
        this.fireTableDataChanged();
    }

    public enderecoPessoa getRow(int linha) {
        return dados.get(linha);
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public List<enderecoPessoa> getList() {
        return dados;
    }
}

