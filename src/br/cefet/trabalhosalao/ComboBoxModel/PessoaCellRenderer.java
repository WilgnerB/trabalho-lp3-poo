/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.ComboBoxModel;

import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author wilgn
 */
public class PessoaCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Pessoa) {
            Pessoa Pessoa = (Pessoa) value;
            setText(Pessoa.getNmPessoa());
        }
        return this;
    }
}
