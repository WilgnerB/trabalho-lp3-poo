/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Interfaces;

import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IPessoaRepo {

    void alterar(Pessoa p) throws DaoException;

    List<Pessoa> consultar() throws DaoException;

    Pessoa consultarPorId(int cod) throws DaoException;

    List<Pessoa> consultarPorNome(String nome) throws DaoException;

    void excluir(Pessoa p) throws DaoException;

    int inserir(Pessoa p) throws DaoException;

    public List<Pessoa> consultaPessoasRelatorio(Date dtMenor, Date dtMaior, String nome)throws DaoException;
    
}
