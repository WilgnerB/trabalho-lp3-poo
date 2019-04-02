/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Interfaces.IEnderecoRepo;
import br.cefet.trabalhosalao.Model.Bean.Endereco;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.util.List;

/**
 *
 * @author wilgn
 */
public class EnderecoControl implements IEnderecoRepo {
    IEnderecoRepo eRepo;

    public EnderecoControl(IEnderecoRepo eRepo) {
        this.eRepo = eRepo;
    }
    
    @Override
    public void alterar(Endereco d) throws DaoException {
        eRepo.alterar(d);
    }

    @Override
    public List<Endereco> consultar(int cdPessoa) throws DaoException {
        return eRepo.consultar(cdPessoa);
    }

    @Override
    public Endereco consultarPorId(int cod,int cdPessoa) throws DaoException {
        return eRepo.consultarPorId(cod,cdPessoa);
    }

    @Override
    public List<Endereco> consultarPorLogradouro(String nome,int cdPessoa) throws DaoException {
        return eRepo.consultarPorLogradouro(nome,cdPessoa);
    }

    @Override
    public void excluir(Endereco d) throws DaoException {
        eRepo.excluir(d);
    }

    @Override
    public int inserir(Endereco d,int cdPessoa) throws DaoException {
        return eRepo.inserir(d,cdPessoa);
    }
}
