/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Interfaces;

import br.cefet.trabalhosalao.Model.Bean.Profissao;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author nic
 */
public interface IProfissaoRepo {

    void alterar(Profissao p) throws DaoException;

    List<Profissao> consultar() throws DaoException;

    Profissao consultarPorId(int cod) throws DaoException;

    List<Profissao> consultarPorNome(String nome) throws DaoException;

    void excluir(Profissao p) throws DaoException;

    int inserir(Profissao p) throws DaoException;
    
}
