/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.System;

import br.cefet.trabalhosalao.Controller.ControlException;
import br.cefet.trabalhosalao.Model.Bean.Endereco;
import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import br.cefet.trabalhosalao.Model.Bean.Produto;
import br.cefet.trabalhosalao.Model.Bean.Profissao;
import br.cefet.trabalhosalao.Model.Bean.Servico;
import br.cefet.trabalhosalao.Model.Bean.Tipo;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface ISalao {
    String getNome();

    void setNome(String nome);
    
    List<Profissao> getProfissao() throws DaoException;

    List<Profissao> getProfissaoFromDesc(String desc) throws DaoException;

    List<Servico> getServico() throws DaoException;

    List<Servico> getServicoFromDesc(String nome) throws DaoException;

    List<Tipo> getTipoFromDesc(String nome) throws DaoException;

    void updateProfissoes(Profissao Profissao) throws DaoException;
    
    void updateTipos(Tipo Tipo) throws DaoException;

    public void updateServicos(Servico Servico) throws DaoException;    
    
    int createProfissao(int i, String text) throws DaoException;
    
    int createTipo(int i,String text) throws DaoException;
    
    public int createServico(int i,String text, double parseDouble, Tipo tipo) throws DaoException;

    List<Tipo> getTipos() throws DaoException;

    void deleteProfissao(Profissao p)  throws DaoException;
    
    void deleteTipo(Tipo t) throws DaoException;
    
    public void deleteServico(Servico s) throws DaoException;
 
    void updateProfissao(int i,String text)  throws DaoException;
    
    public void updateServico(int i, String text, double parseDouble, Tipo tipo) throws DaoException;
    
    public void updateTipo(int i, String text) throws DaoException;
    
    int createEndereco(Endereco e, int cdPessoa) throws DaoException;

    int createPessoa(Pessoa p) throws DaoException;

    int createProduto(Produto p) throws DaoException;

    void deleteEndereco(Endereco e) throws DaoException;

    void deletePessoa(Pessoa p) throws DaoException;

    void deleteProduto(Produto p) throws DaoException;

    List<Endereco> getEnderecos(int cdPessoa) throws DaoException;

    List<Endereco> getEnderecosPorLogra(String logra, int cdPessoa) throws DaoException;

    List<Pessoa> getPessoas() throws DaoException;

    List<Pessoa> getPessoasPorNome(String nome) throws DaoException;

    List<Produto> getProdutos() throws DaoException;

    List<Produto> getProdutosPorNome(String nomex) throws DaoException;

    void updateEnderecos(Endereco e) throws DaoException;

    void updatePessoa(Pessoa p) throws DaoException;

    void updateProduto(Produto p) throws DaoException;

    Produto validateProduto(String text, int parseInt, double valor) throws ControlException;

    Pessoa validatePessoa(String cpf, String nome, String telefone, Date data)  throws ControlException;

    public Produto getProdutoPorCd(int cdProduto)throws DaoException;;

    public List<Produto> getProdutosRelatorio(int qtdMaior, int qtdMenor, double valMaior, double valMenor) throws DaoException;

    public List<Pessoa> getPessoasRelatorio(Date dtMenor, Date dtMaior, String nome) throws DaoException;
    
}
