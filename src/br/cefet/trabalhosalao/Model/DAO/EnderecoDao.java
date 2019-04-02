/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;

import br.cefet.trabalhosalao.Interfaces.IEnderecoRepo;
import br.cefet.trabalhosalao.Model.Bean.Endereco;
import br.cefet.trabalhosalao.Model.Bean.Pessoa;
import static br.cefet.trabalhosalao.Model.DAO.Dao.closeConnection;
import static br.cefet.trabalhosalao.Model.DAO.Dao.getConnection;
import java.sql.Connection;
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
public class EnderecoDao extends Dao implements IEnderecoRepo {

    private final String INSERT_SQL = "INSERT INTO `tbendereco`(`Numero`,`Logradouro`,`CEP`,`Cidade`,`Bairro`,`UF`,`Status`,`CdPessoa`)"
            + "VALUES(?,?,?,?,?,?,?,?);";
    private final String UPDATE_SQL = "UPDATE `tbendereco` "
                                    + "SET`Numero` = ?,`Logradouro` = ?,`CEP` = ?,`Cidade` = ?,`Bairro` = ?,`UF` = ? "
                                    + "WHERE `CdEndereco` = ?;";
//    private final String DELETE_SQL = "UPDATE `tbendereco` SET `Status` = 'D' WHERE `CdEndereco` = ?;";
    private final String DELETE_SQL = "DELETE FROM `tbendereco` WHERE `CdEndereco` = ?;";
    private final String SELECT_FOR_ID_SQL = "SELECT `CdEndereco`,`Numero`,`Logradouro`,`CEP`,`Cidade`,`Bairro`,`UF`"
                                    + "FROM `tbendereco`WHERE `Status`='A' AND `CdEndereco`=? AND `CdPessoa`=? ;";
    private final String SELECT_FOR_NOME_SQL = "SELECT `CdEndereco`,`Numero`,`Logradouro`,`CEP`,`Cidade`,`Bairro`,`UF`" 
                                             + "FROM `tbendereco` WHERE `Status`='A' AND `CdPessoa`=? AND `Logradouro` LIKE ?;";
    private final String SELECT_SQL = "SELECT `CdEndereco`,`Numero`,`Logradouro`,`CEP`,`Cidade`,`Bairro`,`UF`"
                                    + "FROM `tbendereco`WHERE `Status`='A' AND `CdPessoa`=?;";

    @Override
    public int inserir(Endereco d,int cdPessoa) throws DaoException {
        int ret = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, d.getNumero());
            ps.setString(2, d.getLogradouro());
            ps.setString(3, d.getCEP());
            ps.setString(4, d.getCidade());
            ps.setString(5, d.getBairro());
            ps.setString(6, d.getUF());
            ps.setString(7, "A");
            ps.setInt(8,cdPessoa);
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Endereco.Dao.Inserir( " + cdPessoa + ")-:" + d.getClass(), e);
        } finally {
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public void alterar(Endereco d) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
            ps.setInt(1, d.getNumero());
            ps.setString(2, d.getLogradouro());
            ps.setString(3, d.getCEP());
            ps.setString(4, d.getCidade());
            ps.setString(5, d.getBairro());
            ps.setString(6, d.getUF());
            ps.setInt(7, d.getCdEndereco());
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Alterar( " + d.getCdEndereco() + ")-:" + d.getClass(), e);
        } finally {
            closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Endereco d) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, d.getCdEndereco());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.Excluir( " + d.getCdEndereco() + ")-:" + d.getClass(), e);
        } finally {
            closeConnection(conn, ps);
        }
    }

    @Override
    public Endereco consultarPorId(int cod,int cdPessoa) throws DaoException {
        Endereco ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_ID_SQL);
            ps.setInt(1, cod);
            ps.setInt(2, cdPessoa);
            rs = ps.executeQuery();

            if (rs.next()) {
                ret = getEnderecoFromRs(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessoa.Dao.ConsultarPorCod ", e);
        } finally {
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public List<Endereco> consultarPorLogradouro(String nome,int cdPessoa) throws DaoException {
        List<Endereco> ret = new ArrayList<Endereco>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_NOME_SQL);
            ps.setInt(1, cdPessoa);
            ps.setString(2, nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Endereco d = getEnderecoFromRs(rs);
                ret.add(d);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally {
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    @Override
    public List<Endereco> consultar(int cdPessoa) throws DaoException {
        List<Endereco> ret = new ArrayList<Endereco>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            ps.setInt(1,cdPessoa);
            rs = ps.executeQuery();

            while (rs.next()) {
                Endereco d = getEnderecoFromRs(rs);
                ret.add(d);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Endereco.Dao.Consultar ", e);
        } finally {
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    private Endereco getEnderecoFromRs(ResultSet rs) throws DaoException {
        Endereco ed = new Endereco();
        try {
            ed.setCdEndereco(rs.getInt("CdEndereco"));
            ed.setNumero(rs.getInt("Numero"));
            ed.setLogradouro(rs.getString("Logradouro"));
            ed.setCEP(rs.getString("CEP"));
            ed.setCidade(rs.getString("Cidade"));
            ed.setBairro(rs.getString("Bairro"));
            ed.setUF(rs.getString("UF"));
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Endereco.Dao.getEnderecoFromRs ", e);
        }
        return ed;
    }

    public static void main(String[] args) {
        try {
//Inserir
//            Endereco d = new Endereco();
//            d.setNumero(12);
//            d.setBairro("Claudio");
//            d.setCEP("35.179-000");
//            d.setCidade("Shipatinga");
//            d.setLogradouro("Rua Barretos");
//            d.setUF("MG");
//            EnderecoDao dDao = new EnderecoDao();
//            int n = dDao.inserir(d,1);
//            System.out.println(n);

//Excluir
//            Endereco d = new Endereco();
//            d.setCdEndereco(1);
//            EnderecoDao dDao = new EnderecoDao();
//            dDao.excluir(d);

//Alterar
//            Endereco d = new Endereco();
//            d.setCdEndereco(1);
//            d.setNumero(13);
//            d.setBairro("Claudios");
//            d.setCEP("35179-000");
//            d.setCidade("ipatinga");
//            d.setLogradouro("Rua Barretos");
//            d.setUF("MG");
//            EnderecoDao dDao = new EnderecoDao();
//            dDao.alterar(d);

//Consultar por id
            EnderecoDao dDao = new EnderecoDao();
            Endereco d = dDao.consultarPorId(2,1);

            if (d != null) {
                System.out.println(d.getCdEndereco());
                System.out.println(d.getUF());
                System.out.println(d.getBairro());
                System.out.println(d.getLogradouro());
                System.out.println(d.getCEP());
                System.out.println(d.getCidade());
                System.out.println(d.getNumero());
            } else {
                System.out.println("Endereco não encontrado");
            }

//Consultar por Logradouro
//            EnderecoDao dDao = new EnderecoDao();
//            List<Endereco> ps = dDao.consultarPorLogradouro("Rua",1);
//            if (ps != null) {
//                for (int i = 0; i < ps.size(); i++) {
//                    Endereco d = ps.get(i);
//                    System.out.println(d.getCdEndereco());
//                    System.out.println(d.getUF());
//                    System.out.println(d.getBairro());
//                    System.out.println(d.getLogradouro());
//                    System.out.println(d.getCEP());
//                    System.out.println(d.getCidade());
//                    System.out.println(d.getNumero());
//                }
//            }

//Consultar Todos
//            EnderecoDao dDao = new EnderecoDao();
//            List<Endereco> ps = dDao.consultar(1);
//            if (ps != null) {
//                for (int i = 0; i < ps.size(); i++) {
//                    Endereco d = ps.get(i);
//                    System.out.println(d.getCdEndereco());
//                    System.out.println(d.getUF());
//                    System.out.println(d.getBairro());
//                    System.out.println(d.getLogradouro());
//                    System.out.println(d.getCEP());
//                    System.out.println(d.getCidade());
//                    System.out.println(d.getNumero());
//                }
//            }
        } catch (DaoException ex) {
            ex.printStackTrace();
        }
    }

}
