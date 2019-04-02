/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.ComboBoxModel;

import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


/**
 *
 * @author aluno
 */
public class PessoaComboModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private List<Pessoa> listItem;
    private Pessoa selectedItem;
    private final static int FIRSTINDEX = 0;
    
    public PessoaComboModel() {
        this.listItem=new ArrayList<>();
    }
    
    public PessoaComboModel(List<Pessoa> listItem) {
        this();
        this.listItem.addAll(listItem);
        if (getSize() > 0) {
            setSelectedItem(this.listItem.get(FIRSTINDEX));
        }

    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Pessoa) anItem;
        fireContentsChanged(anItem, FIRSTINDEX, FIRSTINDEX);
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return listItem.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listItem.get(index);
    }
    
    
}
