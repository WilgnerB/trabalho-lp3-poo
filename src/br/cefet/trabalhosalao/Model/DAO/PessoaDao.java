/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;

import br.cefet.trabalhosalao.Interfaces.IPessoaRepo;
import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import br.cefet.trabalhosalao.Model.Bean.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PessoaDao extends Dao implements IPessoaRepo {
    private final String INSERT_SQL = "INSERT INTO `tbpessoa`(`NmPessoa`,`DtNasc`,`Telefone`,`CPF`,`Status`)"
                                    + "VALUES(?,?,?,?,?);";        
    private final String UPDATE_SQL = "UPDATE `tbpessoa` "
                                    + "SET `NmPessoa` = ?,`DtNasc` = ?,`Telefone` = ? ,`CPF`=? "
                                    + "WHERE `CdPessoa` = ?";
//    private final String DELETE_SQL = "UPDATE `tbpessoa` SET `Status` = 'D' WHERE `CdPessoa` = ?";
    private final String DELETE_SQL = "DELETE FROM `tbpessoa` WHERE `CdPessoa` = ?";    
    private final String SELECT_FOR_ID_SQL = "SELECT * FROM `tbpessoa`WHERE `CdPessoa` = ?";
    private final String SELECT_FOR_NOME_SQL = "SELECT `CdPessoa`,`NmPessoa`,`DtNasc`,`Telefone`,`CPF`,`Status` FROM `tbpessoa`WHERE `Status` = 'A' AND `NmPessoa` LIKE ?";
    private final String SELECT_SQL = "SELECT * FROM `tbpessoa`WHERE `Status` = 'A'";
    private final String SELECT_RELATORIO_SQL = "SELECT `CdPessoa`, `NmPessoa`,`DtNasc`,`Telefone`,`CPF`,`Status` FROM `tbpessoa`WHERE `Status` = 'A' AND DtNasc > ? And DtNasc < ? AND `NmPessoa` LIKE ?; ";

    @Override
    public int inserir(Pessoa p) throws DaoException {
        int ret = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getNmPessoa());
            ps.setDate(2, p.getDtNasc());
            ps.setString(3,p.getTelefone());
            ps.setString(4,p.getCpf());
            ps.setString(5,"A");
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessoa.Dao.Inserir( " + p.getNmPessoa()+ ")-:" + p.getClass(), e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public void alterar(Pessoa p) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);

            ps.setString(1, p.getNmPessoa());
            ps.setDate(2, p.getDtNasc());
            ps.setString(3, p.getTelefone());
            ps.setString(4, p.getCpf());
            ps.setInt(5, p.getCdPessoa());
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Alterar( " + p.getNmPessoa() + ")-:" + p.getClass(), e);
        } finally{
            closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Pessoa p) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, p.getCdPessoa());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Excluir( " + p.getNmPessoa()+ ")-:" + p.getClass(), e);
        } finally{
            closeConnection(conn, ps);
        }
    }

    @Override
    public Pessoa consultarPorId(int cod) throws DaoException {
        Pessoa ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_ID_SQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                ret = getPessoaFromRs(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessoa.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public List<Pessoa> consultarPorNome(String nome) throws DaoException {
        List<Pessoa> ret = new ArrayList<Pessoa>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_NOME_SQL);
            ps.setString(1,nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa p = getPessoaFromRs(rs);
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
    public List<Pessoa> consultar() throws DaoException {
        List<Pessoa> ret = new ArrayList<Pessoa>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa p = getPessoaFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    private Pessoa getPessoaFromRs(ResultSet rs) throws DaoException {
        Pessoa p = new Pessoa();
        try {
            p.setCdPessoa(rs.getInt("cdpessoa"));
            p.setNmPessoa(rs.getString("NmPessoa"));
            p.setCpf(rs.getString("CPF"));
            p.setDtNasc(rs.getDate("DtNasc"));
            p.setTelefone(rs.getString("Telefone"));

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessao.Dao.getPessoaFromRs ", e);
        }
        return p;

    }
    @Override
     public List<Pessoa> consultaPessoasRelatorio(Date dtMenor, Date dtMaior, String nome)throws DaoException{
                 List<Pessoa> ret = new ArrayList<Pessoa>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_RELATORIO_SQL);
            ps.setDate(1, dtMenor);
            ps.setDate(2, dtMaior);
            ps.setString(3,nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa p = getPessoaFromRs(rs);
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
