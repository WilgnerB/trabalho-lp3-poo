/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;
import br.cefet.trabalhosalao.Interfaces.IProfissaoRepo;
import br.cefet.trabalhosalao.Model.Bean.Profissao;
import br.cefet.trabalhosalao.Model.DAO.Dao;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Derek Jonso
 */
public class ProfissaoDao extends Dao implements IProfissaoRepo {
    private final String INSERT_SQL = "INSERT INTO `tbprofissao`(`NmProfissao`,`Status`) VALUES (?,?)";
    private final String UPDATE_SQL = "UPDATE tbprofissao set NmProfissao=? where CdProfissao=?";
    private final String DELETE_SQL = "DELETE FROM tbprofissao WHERE CdProfissao=?";
    private final String SELECT_FOR_ID_SQL = "select * from tbprofissao where CdProfissao = ?";
    private final String SELECT_FOR_NOME_SQL = "select * from tbprofissao where `Status` = 'A' AND NmProfissao like ?";
    private final String SELECT_SQL = "select * from tbprofissao WHERE `Status` = 'A'";

    @Override
    public int inserir(Profissao p) throws DaoException {
        int ret = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNmProfissao());
            ps.setString(2,"A");

            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.Inserir( " + p.getNmProfissao() + ")-:" + p.getClass(), e);
        }
        return ret;
    }

    @Override
    public void alterar(Profissao p) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, p.getNmProfissao());
            ps.setInt(2, p.getCdProfissao());
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.Alterar( " + p.getNmProfissao() + ")-:" + p.getClass(), e);
        }
    }

    @Override
    public void excluir(Profissao p) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, p.getCdProfissao());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.Excluir( " + p.getNmProfissao() + ")-:" + p.getClass(), e);
        }
    }

    @Override
    public Profissao consultarPorId(int cod) throws DaoException {
        Profissao ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_ID_SQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                ret = getProfissaoFromRs(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.ConsultarPorCod ", e);
        }
        return ret;
    }

    @Override
    public List<Profissao> consultarPorNome(String nome) throws DaoException {
        List<Profissao> ret = new ArrayList<Profissao>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_NOME_SQL);
            ps.setString(1,nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Profissao p = getProfissaoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.ConsultarPorCod ", e);
        }
        return ret;
    }

    @Override
    public List<Profissao> consultar() throws DaoException {
        List<Profissao> ret = new ArrayList<Profissao>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Profissao p = getProfissaoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.ConsultarPorCod ", e);
        }
        
        return ret;
    }

    private Profissao getProfissaoFromRs(ResultSet rs)
            throws DaoException {
        Profissao p = new Profissao();
        try {
            p.setCdProfissao(rs.getInt("CdProfissao"));
            p.setNmProfissao(rs.getString("NmProfissao"));

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Profissao.Dao.getProfissaoFromRs ", e);
        }
        return p;

    }
    public static void main(String[] args) {
        try{
        ProfissaoDao pDao = new ProfissaoDao();
//        Profissao p1 = new Profissao();
//        p1.setNmProfissao("Pistolero");
//        int i=pDao.inserir(p1);
//        System.out.println(i);
//
//        Profissao p2 = new Profissao();
//        p2.setNmProfissao("Krequicista");    
//        pDao.inserir(p2);
//        pDao.excluir(p2);

//        Profissao p3 = new Profissao();
//        p3.setNmProfissao("KreitoRastero");
//        pDao.inserir(p3);
//        pDao.alterar(p3);
//
//        Profissao p4 = new Profissao();
//        p4.setCdProfissao(4);
//        p4.setNmProfissao("Seudisonado");
//        pDao.alterar(p4);

//         Profissao prf = pDao.consultarPorId(1);
//        
//        System.out.println(""+prf.getNmProfissao()+" "+prf.getCdProfissao()+".");

//         Profissao prf1 = pDao.consultarPorNome("K");
//        
//        System.out.println(""+prf1.getNmProfissao()+" "+prf1.getCdProfissao()+".");

//
//         List<Profissao> prf1 = pDao.consultarPorNome("K");
//
//            for (int i = 0; i < prf1.size(); i++) {
//                Profissao al = prf1.get(i);
//                System.out.println(al.getCdProfissao());
//                System.out.println(al.getNmProfissao());
//            }

               List<Profissao> prf2 = pDao.consultar();

            for (int i = 0; i < prf2.size(); i++) {
                Profissao al = prf2.get(i);
                System.out.println(al.getCdProfissao());
                System.out.println(al.getNmProfissao());
            }
    


            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (DaoException ex) {
            ex.printStackTrace();
        }

    }
}

