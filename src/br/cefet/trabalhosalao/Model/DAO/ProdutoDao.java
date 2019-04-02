/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;

import br.cefet.trabalhosalao.Interfaces.IProdutoRepo;
import br.cefet.trabalhosalao.Model.Bean.Produto;
import static br.cefet.trabalhosalao.Model.DAO.Dao.closeConnection;
import static br.cefet.trabalhosalao.Model.DAO.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ProdutoDao extends Dao implements IProdutoRepo {
        private final String INSERT_SQL = "INSERT INTO `tbproduto`(`NmProduto`,`VlAtual`,`QtdProduto`,`DtEntrada`,`Status`)"
                                        + "VALUES(?,?,?,?,?);";        
    private final String UPDATE_SQL = "UPDATE `tbproduto` "
                                    + "SET `NmProduto` = ?,`VlAtual` = ?,`QtdProduto` = ? "
                                    + "WHERE `CdProduto` = ?;";
//    private final String DELETE_SQL = "UPDATE `tbproduto` SET `Status` = 'D' WHERE `CdProduto` = ?;";
    private final String DELETE_SQL = "DELETE FROM `tbproduto`WHERE `CdProduto`= ?;";
    private final String SELECT_FOR_ID_SQL = "SELECT `CdProduto`,`NmProduto`,`VlAtual`,`QtdProduto`,`DtEntrada`,`Status`FROM `tbproduto` WHERE `CdProduto` = ?;";
    private final String SELECT_FOR_NOME_SQL = "SELECT `CdProduto`,`NmProduto`,`VlAtual`,`QtdProduto`,`DtEntrada`,`Status` FROM `tbproduto` WHERE `Status` = 'A' AND `NmProduto` LIKE ?;";
    private final String SELECT_SQL = "SELECT `CdProduto`,`NmProduto`,`VlAtual`,`QtdProduto`,`DtEntrada`,`Status`FROM `tbproduto` WHERE `Status` = 'A';";
    private final String SELECT_RELATORIO_SQL = "SELECT `CdProduto`,`NmProduto`,`VlAtual`,`QtdProduto`,`DtEntrada`,`Status` FROM `tbproduto` WHERE `Status` = 'A' AND `QtdProduto` > ? AND `QtdProduto` < ? AND `VlAtual` > ? AND `VlAtual` < ?;";
    
    @Override
    public int inserir(Produto p) throws DaoException {
        int ret = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getNmProduto());
            ps.setDouble(2, p.getVlAtual());
            ps.setInt(3,p.getQtdProduto());
            ps.setDate(4,p.getDtEntrada());
            ps.setString(5,"A");
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessoa.Dao.Inserir( " + p.getNmProduto()+ ")-:" + p.getClass(), e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public void alterar(Produto p) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1,p.getNmProduto());
            ps.setDouble(2, p.getVlAtual());
            ps.setInt(3,p.getQtdProduto());
            ps.setInt(4,p.getCdProduto());
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Alterar( " + p.getNmProduto()+ ")-:" + p.getClass(), e);
        } finally{
            closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Produto p) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, p.getCdProduto());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Excluir( " + p.getNmProduto()+ ")-:" + p.getClass(), e);
        } finally{
            closeConnection(conn, ps);
        }
    }

    @Override
    public Produto consultarPorId(int cod) throws DaoException {
        Produto ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_ID_SQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                ret = getProdutoFromRs(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessoa.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public List<Produto> consultarPorNome(String nome) throws DaoException {
        List<Produto> ret = new ArrayList<Produto>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_NOME_SQL);
            ps.setString(1,nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = getProdutoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public List<Produto> consultar() throws DaoException {
        List<Produto> ret = new ArrayList<Produto>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = getProdutoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    private Produto getProdutoFromRs(ResultSet rs) throws DaoException {
        Produto p = new Produto();
        try {
            p.setCdProduto(rs.getInt("CdProduto"));
            p.setNmProduto(rs.getString("NmProduto"));
            p.setVlAtual(rs.getDouble("VlAtual"));
            p.setQtdProduto(rs.getInt("QtdProduto"));
            p.setDtEntrada(rs.getDate("DtEntrada"));
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessao.Dao.getPessoaFromRs ", e);
        }
        return p;

    }

    @Override
    public List<Produto> consultarProdutosRelatorio(int qtdMaior, int qtdMenor, double valMaior, double valMenor) throws DaoException {
        List<Produto> ret = new ArrayList<Produto>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_RELATORIO_SQL);
            ps.setInt(1,qtdMenor);
            ps.setInt(2,qtdMaior);
            ps.setDouble(3, valMenor);
            ps.setDouble(4, valMaior);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = getProdutoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    
}
