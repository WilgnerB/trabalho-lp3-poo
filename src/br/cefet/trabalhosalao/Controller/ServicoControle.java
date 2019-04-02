/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Interfaces.IServicoRepo;
import br.cefet.trabalhosalao.Model.Bean.Tipo;
import br.cefet.trabalhosalao.Model.Bean.Servico;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author nic
 */
public class ServicoControle {

    IServicoRepo sRepo;

    public ServicoControle(IServicoRepo sRepo) {
        this.sRepo = sRepo;
    }

    public int create(int i, String text, double parseDouble, Tipo tipo) throws DaoException {
        Servico s = Servico.newinstance(i, text, parseDouble,tipo);
        return sRepo.inserir(s);
    }

    public List<Servico> read() throws DaoException {
        return sRepo.consultar();
    }

    public List<Servico> readForDesc(String desc) throws DaoException {
        return sRepo.consultarPorNome(desc);
    }

    public void update(Servico Servico) throws DaoException {
        sRepo.alterar(Servico);
    }

    public void delete(Servico s) throws DaoException {
        sRepo.excluir(s);
    }

    public void update(int i, String text, double parseDouble, Tipo tipo) throws DaoException {
        Servico s = Servico.newinstance(i, text, parseDouble, tipo);
        sRepo.alterar(s);
    }

}

