/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Interfaces;

import br.cefet.trabalhosalao.Model.Bean.Servico;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author nic
 */
public interface IServicoRepo {

    void alterar(Servico s) throws DaoException;

    List<Servico> consultar() throws DaoException;

    Servico consultarPorId(int cod) throws DaoException;

    List<Servico> consultarPorNome(String nome) throws DaoException;

    void excluir(Servico p) throws DaoException;

    int inserir(Servico s) throws DaoException;
    
}
