/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Interfaces.IPessoaRepo;
import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wilgn
 */
public class PessoaControl implements IPessoaRepo {

    IPessoaRepo pRepo;

    public PessoaControl(IPessoaRepo pRepo) {
        this.pRepo = pRepo;
    }

    @Override
    public void alterar(Pessoa p) throws DaoException {
        pRepo.alterar(p);
    }

    @Override
    public List<Pessoa> consultar() throws DaoException {
        return pRepo.consultar();
    }

    @Override
    public Pessoa consultarPorId(int cod) throws DaoException {
        return pRepo.consultarPorId(cod);
    }

    @Override
    public List<Pessoa> consultarPorNome(String nome) throws DaoException {
        return pRepo.consultarPorNome(nome);
    }

    @Override
    public void excluir(Pessoa p) throws DaoException {
        pRepo.excluir(p);
    }

    @Override
    public int inserir(Pessoa p) throws DaoException {
        return pRepo.inserir(p);
    }

    public Pessoa validatePessoa(String cpf, String nome, String telefone, Date data) throws ControlException {
        Pessoa ret = null;
        cpf.replaceAll(" ","");
        telefone.replaceAll(" ","");
        
        System.out.println(cpf);
        System.out.println(telefone);
        
        if (cpf.length() == 14 && nome.length() >= 4 && telefone.length() == 14 && data != null) {
            ret = new Pessoa();
            ret.setCpf(cpf);
            ret.setNmPessoa(nome);
            ret.setTelefone(telefone);
            ret.setDtNasc(data);
        } else {
            if (cpf.length() != 14) {
                throw new ControlException(", o cpf:" + cpf + " é invalido!");
            }
            if (nome.length() < 4) {
                throw new ControlException(", o nome :" + nome + " é invalido!");
            }
            if (telefone.length() != 14) {
                throw new ControlException(", o telefone:" + telefone + " é invalido!");
            }
            if (data == null) {
                throw new ControlException(", a data é invalida!");
            }
        }
        return ret;
    }

    @Override
    public List<Pessoa> consultaPessoasRelatorio(Date dtMenor, Date dtMaior, String nome) throws DaoException{
        return pRepo.consultaPessoasRelatorio(dtMenor,dtMaior,nome);
    }
}
