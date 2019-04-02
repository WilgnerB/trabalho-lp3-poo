/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Interfaces;

import br.cefet.trabalhosalao.Model.Bean.Tipo;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author nic
 */
public interface ITipoRepo {

    void alterar(Tipo p) throws DaoException;

    List<Tipo> consultar() throws DaoException;

    Tipo consultarPorId(int cod) throws DaoException;

    List<Tipo> consultarPorNome(String nome) throws DaoException;

    void excluir(Tipo p) throws DaoException;

    int inserir(Tipo p) throws DaoException;
    
}
