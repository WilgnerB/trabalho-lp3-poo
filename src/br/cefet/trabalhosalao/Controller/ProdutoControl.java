/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Controller;

import br.cefet.trabalhosalao.Interfaces.IProdutoRepo;
import br.cefet.trabalhosalao.Model.Bean.Produto;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wilgn
 */
public class ProdutoControl implements IProdutoRepo {

    IProdutoRepo pRepo;

    public ProdutoControl(IProdutoRepo pRepo) {
        this.pRepo = pRepo;
    }

    @Override
    public void alterar(Produto p) throws DaoException {
        pRepo.alterar(p);
    }

    @Override
    public List<Produto> consultar() throws DaoException {
        return pRepo.consultar();
    }

    @Override
    public Produto consultarPorId(int cod) throws DaoException {
        return pRepo.consultarPorId(cod);
    }

    @Override
    public List<Produto> consultarPorNome(String nome) throws DaoException {
        return pRepo.consultarPorNome(nome);
    }

    @Override
    public void excluir(Produto p) throws DaoException {
        pRepo.excluir(p);
    }

    @Override
    public int inserir(Produto p) throws DaoException {
        return pRepo.inserir(p);
    }

    public Produto validateProduto(String nome, int qtd, double valor) throws ControlException {
        Produto ret = new Produto();
        if (nome.length() >= 3 && qtd >= 1 && valor > 0.0) {
            ret.setNmProduto(nome);
            ret.setQtdProduto(qtd);
            ret.setVlAtual(valor);
        } else {
            if(nome.length() < 3){
                throw new ControlException(", o nome: "+nome+" é invalido!");
            }
            if(qtd < 1 ){
               throw new ControlException(", a quantidade: "+qtd+" é invalida!");
            }
            if(valor < 1.0){
                throw new ControlException(", o valor: "+valor+" é invalido!");
            }           
        }

        return ret;
    }
    
    @Override
    public List<Produto> consultarProdutosRelatorio(int qtdMaior, int qtdMenor, double valMaior, double valMenor) throws DaoException{
        return pRepo.consultarProdutosRelatorio(qtdMaior,qtdMenor,valMaior,valMenor);
    }

}
