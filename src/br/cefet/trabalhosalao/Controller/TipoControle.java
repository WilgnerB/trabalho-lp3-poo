/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Interfaces.ITipoRepo;
import br.cefet.trabalhosalao.Model.Bean.Tipo;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author nic
 */
public class TipoControle {

    ITipoRepo tRepo;

    public TipoControle(ITipoRepo tRepo) {
        this.tRepo= tRepo;
    }

    public int create(int i, String text) throws DaoException {
        Tipo t = Tipo.newinstance(i, text);
        return tRepo.inserir(t);
    }

    public List<Tipo> read() throws DaoException {
        return tRepo.consultar();
    }

    public List<Tipo> readForDesc(String desc) throws DaoException {
        return tRepo.consultarPorNome(desc);
    }

    public void update(Tipo Tipo) throws DaoException {
        tRepo.alterar(Tipo);
    }

    public void delete(Tipo s) throws DaoException {
        tRepo.excluir(s);
    }

    public void update(int i, String text) throws DaoException {
        Tipo t = Tipo.newinstance(i, text);
        tRepo.alterar(t);
    }

}
