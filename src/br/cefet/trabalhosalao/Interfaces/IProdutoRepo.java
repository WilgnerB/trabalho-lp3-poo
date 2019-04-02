/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Interfaces;

import br.cefet.trabalhosalao.Model.Bean.Produto;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IProdutoRepo {

    void alterar(Produto p) throws DaoException;

    List<Produto> consultar() throws DaoException;

    Produto consultarPorId(int cod) throws DaoException;

    List<Produto> consultarPorNome(String nome) throws DaoException;

    void excluir(Produto p) throws DaoException;

    int inserir(Produto p) throws DaoException;

    public List<Produto> consultarProdutosRelatorio(int qtdMaior, int qtdMenor, double valMaior, double valMenor) throws DaoException;
    
}
