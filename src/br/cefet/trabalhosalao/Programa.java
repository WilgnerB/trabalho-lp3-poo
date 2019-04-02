/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao;

import br.cefet.trabalhosalao.Controller.EnderecoControl;
import br.cefet.trabalhosalao.Controller.PessoaControl;
import br.cefet.trabalhosalao.Controller.ProdutoControl;
import br.cefet.trabalhosalao.Controller.ProfissaoControle;
import br.cefet.trabalhosalao.Controller.ServicoControle;
import br.cefet.trabalhosalao.Controller.TipoControle;
import br.cefet.trabalhosalao.Interfaces.IEnderecoRepo;
import br.cefet.trabalhosalao.Interfaces.IPessoaRepo;
import br.cefet.trabalhosalao.Interfaces.IProdutoRepo;
import br.cefet.trabalhosalao.Interfaces.IProfissaoRepo;
import br.cefet.trabalhosalao.Interfaces.IServicoRepo;
import br.cefet.trabalhosalao.Interfaces.ITipoRepo;
import br.cefet.trabalhosalao.Model.DAO.EnderecoDao;
import br.cefet.trabalhosalao.Model.DAO.PessoaDao;
import br.cefet.trabalhosalao.Model.DAO.ProdutoDao;
import br.cefet.trabalhosalao.Model.DAO.ProfissaoDao;
import br.cefet.trabalhosalao.Model.DAO.ServicoDao;
import br.cefet.trabalhosalao.Model.DAO.TipoDao;
import br.cefet.trabalhosalao.System.ISalao;
import br.cefet.trabalhosalao.System.Salao;
import br.cefet.trabalhosalao.View.ViewGerarRelatorioEnderecoPessoa;
import br.cefet.trabalhosalao.View.ViewGerarRelatorioPessoa;
import br.cefet.trabalhosalao.View.ViewGerarRelatorioServicoTipo;
import br.cefet.trabalhosalao.View.telasSeleção.ViewMenu;
import br.cefet.trabalhosalao.View.viewProduto.ViewGerarRelatorioProduto;

/**
 *
 * @author wilgn
 */
public class Programa {

    public static void main(String[] args) {
        IProdutoRepo prDao = new ProdutoDao();
        IPessoaRepo peDao = new PessoaDao();
        IEnderecoRepo eRepo = new EnderecoDao();
        ITipoRepo tRepo = new TipoDao();
        IServicoRepo sRepo = new ServicoDao();
        IProfissaoRepo pRepo = new ProfissaoDao();

        String nome = "Salao Da Tia Eliane";
        TipoControle CtrlTipo = new TipoControle(tRepo);
        ServicoControle CtrlServico = new ServicoControle(sRepo);
        ProfissaoControle CtrlProfissao = new ProfissaoControle(pRepo);
        PessoaControl CtrlPessoa = new PessoaControl(peDao);
        ProdutoControl CtrlProduto = new ProdutoControl(prDao);
        EnderecoControl CtrlEndereco = new EnderecoControl(eRepo);
        ISalao salao = Salao.getInstance(nome, CtrlTipo, CtrlServico, CtrlProfissao, CtrlPessoa, CtrlProduto, CtrlEndereco);
        ViewMenu frame = new ViewMenu();
        frame.setVisible(true);
    }
}
