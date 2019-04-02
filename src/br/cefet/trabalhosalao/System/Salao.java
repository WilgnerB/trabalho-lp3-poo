/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.System;

import br.cefet.trabalhosalao.Controller.ControlException;
import br.cefet.trabalhosalao.Controller.EnderecoControl;
import br.cefet.trabalhosalao.Controller.PessoaControl;
import br.cefet.trabalhosalao.Controller.ProdutoControl;
import br.cefet.trabalhosalao.Controller.ProfissaoControle;
import br.cefet.trabalhosalao.Controller.ServicoControle;
import br.cefet.trabalhosalao.Controller.TipoControle;
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
public class Salao implements ISalao {

    private static ISalao instance;
    private String nome;
    private TipoControle CtrlTipo;
    private ServicoControle CtrlServico;
    private ProfissaoControle CtrlProfissao;
    private PessoaControl CtrlPessoa;
    private ProdutoControl CtrlProduto;
    private EnderecoControl CtrlEndereco;

    private Salao(String nome, TipoControle CtrlTipo, ServicoControle CtrlServico, ProfissaoControle CtrlProfissao, PessoaControl CtrlPessoa, ProdutoControl CtrlProduto, EnderecoControl CtrlEndereco) {
        this.nome = nome;
        this.CtrlTipo = CtrlTipo;
        this.CtrlServico = CtrlServico;
        this.CtrlProfissao = CtrlProfissao;
        this.CtrlPessoa = CtrlPessoa;
        this.CtrlProduto = CtrlProduto;
        this.CtrlEndereco = CtrlEndereco;
    }

    public static ISalao getInstance(String nome, TipoControle CtrlTipo, ServicoControle CtrlServico, ProfissaoControle CtrlProfissao, PessoaControl CtrlPessoa, ProdutoControl CtrlProduto, EnderecoControl CtrlEndereco) {
        if (instance == null) {
            instance = new Salao(nome, CtrlTipo, CtrlServico, CtrlProfissao, CtrlPessoa, CtrlProduto, CtrlEndereco);
            return instance;
        } else {
            return instance;
        }
    }

    public static ISalao getInstance() {
        return instance;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public List<Profissao> getProfissao() throws DaoException {
        return CtrlProfissao.read();
    }

    @Override
    public List<Profissao> getProfissaoFromDesc(String desc) throws DaoException {
        return CtrlProfissao.readForDesc(desc);
    }

    @Override
    public void updateProfissoes(Profissao Profissao) throws DaoException {
        CtrlProfissao.update(Profissao);
    }

    @Override
    public void updateProfissao(int i, String text) throws DaoException {
        CtrlProfissao.update(i, text);
    }

    @Override
    public int createProfissao(int i, String text) throws DaoException {
        return CtrlProfissao.create(i, text);
    }

    @Override
    public void deleteProfissao(Profissao p) throws DaoException {
        CtrlProfissao.delete(p);
    }

    @Override
    public List<Tipo> getTipos() throws DaoException {
        return CtrlTipo.read();
    }

    @Override
    public List<Tipo> getTipoFromDesc(String nome) throws DaoException {
        return CtrlTipo.readForDesc(nome);
    }

    @Override
    public void updateTipos(Tipo Tipo) throws DaoException {
        CtrlTipo.update(Tipo);
    }

    @Override
    public void updateTipo(int i, String text) throws DaoException {
        CtrlTipo.update(i, text);
    }

    @Override
    public int createTipo(int i, String text) throws DaoException {
        return CtrlTipo.create(i, text);
    }

    @Override
    public void deleteTipo(Tipo t) throws DaoException {
        CtrlTipo.delete(t);
    }

    @Override
    public List<Servico> getServico() throws DaoException {
        return CtrlServico.read();
    }

    @Override
    public List<Servico> getServicoFromDesc(String nome) throws DaoException {
        return CtrlServico.readForDesc(nome);
    }

    @Override
    public void updateServicos(Servico Servico) throws DaoException {
        CtrlServico.update(Servico);
    }

    @Override
    public void updateServico(int i, String text, double parseDouble, Tipo tipo) throws DaoException {
        CtrlServico.update(i, text, parseDouble, tipo);
    }

    @Override
    public int createServico(int i, String text, double parseDouble, Tipo tipo) throws DaoException {
        return CtrlServico.create(i, text, parseDouble, tipo);
    }

    @Override
    public void deleteServico(Servico s) throws DaoException {
        CtrlServico.delete(s);
    }

    @Override
    public List<Produto> getProdutos() throws DaoException {
        return CtrlProduto.consultar();
    }

    @Override
    public List<Produto> getProdutosPorNome(String nomex) throws DaoException {
        return CtrlProduto.consultarPorNome(nomex);
    }

    @Override
    public int createProduto(Produto p) throws DaoException {
        return CtrlProduto.inserir(p);
    }

    @Override
    public void updateProduto(Produto p) throws DaoException {
        CtrlProduto.alterar(p);
    }

    @Override
    public void deleteProduto(Produto p) throws DaoException {
        CtrlProduto.excluir(p);
    }

    @Override
    public List<Endereco> getEnderecos(int cdPessoa) throws DaoException {
        return CtrlEndereco.consultar(cdPessoa);
    }

    @Override
    public List<Endereco> getEnderecosPorLogra(String logra, int cdPessoa) throws DaoException {
        return CtrlEndereco.consultarPorLogradouro(logra, cdPessoa);
    }

    @Override
    public int createEndereco(Endereco e, int cdPessoa) throws DaoException {
        return CtrlEndereco.inserir(e, cdPessoa);
    }

    @Override
    public void updateEnderecos(Endereco e) throws DaoException {
        CtrlEndereco.alterar(e);
    }

    @Override
    public void deleteEndereco(Endereco e) throws DaoException {
        CtrlEndereco.excluir(e);
    }

    @Override
    public List<Pessoa> getPessoas() throws DaoException {
        return CtrlPessoa.consultar();
    }

    @Override
    public List<Pessoa> getPessoasPorNome(String nome) throws DaoException {
        return CtrlPessoa.consultarPorNome(nome);
    }

    @Override
    public int createPessoa(Pessoa p) throws DaoException {
        return CtrlPessoa.inserir(p);
    }

    @Override
    public void updatePessoa(Pessoa p) throws DaoException {
        CtrlPessoa.alterar(p);
    }

    @Override
    public void deletePessoa(Pessoa p) throws DaoException {
        CtrlPessoa.excluir(p);
    }

    @Override
    public Produto validateProduto(String nome, int qtd, double valor) throws ControlException {
        return CtrlProduto.validateProduto(nome, qtd, valor);

    }

    @Override
    public Pessoa validatePessoa(String cpf, String nome, String telefone, Date data) throws ControlException {
        return CtrlPessoa.validatePessoa(cpf,nome,telefone,data);
    }

    @Override
    public Produto getProdutoPorCd(int cdProduto) throws DaoException{
        return CtrlProduto.consultarPorId(cdProduto);
    }

    @Override
    public List<Produto> getProdutosRelatorio(int qtdMaior, int qtdMenor, double valMaior, double valMenor) throws DaoException{
        return CtrlProduto.consultarProdutosRelatorio(qtdMaior,qtdMenor,valMaior,valMenor);
    }

    @Override
    public List<Pessoa> getPessoasRelatorio(Date dtMenor, Date dtMaior, String nome) throws DaoException{
        return CtrlPessoa.consultaPessoasRelatorio(dtMenor,dtMaior,nome);
    }

}
