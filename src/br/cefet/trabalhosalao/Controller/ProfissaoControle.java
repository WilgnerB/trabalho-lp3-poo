/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Interfaces.IProfissaoRepo;
import br.cefet.trabalhosalao.Model.Bean.Profissao;
import br.cefet.trabalhosalao.Model.Bean.Tipo;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author nic
 */
public class ProfissaoControle {

    IProfissaoRepo pRepo;

    public ProfissaoControle(IProfissaoRepo pRepo) {
        this.pRepo = pRepo;
    }

    public int create(int i, String text) throws DaoException {
        Profissao p = Profissao.newinstance(i, text);
        return pRepo.inserir(p);
    }

    public List<Profissao> read() throws DaoException {
        return pRepo.consultar();
    }

    public List<Profissao> readForDesc(String desc) throws DaoException {
        return pRepo.consultarPorNome(desc);
    }

    public void update(Profissao Profissao) throws DaoException {
        pRepo.alterar(Profissao);
    }

    public void delete(Profissao s) throws DaoException {
        pRepo.excluir(s);
    }

    public void update(int i, String text) throws DaoException {
        Profissao p = Profissao.newinstance(i, text);
        pRepo.alterar(p);
    }

}