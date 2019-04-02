/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Interfaces;

import br.cefet.trabalhosalao.Model.Bean.Endereco;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IEnderecoRepo {

    void alterar(Endereco d) throws DaoException;

    List<Endereco> consultar(int cdPessoa) throws DaoException;

    Endereco consultarPorId(int cod,int cdPessoa) throws DaoException;

    List<Endereco> consultarPorLogradouro(String nome,int cdPessoa) throws DaoException;

    void excluir(Endereco d) throws DaoException;

    int inserir(Endereco d, int cdPessoa) throws DaoException;
    
}
