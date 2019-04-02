package br.cefet.trabalhosalao.Model.DAO;
import br.cefet.trabalhosalao.Interfaces.ITipoRepo;
import br.cefet.trabalhosalao.Model.Bean.Tipo;
import br.cefet.trabalhosalao.Model.DAO.Dao;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import static br.cefet.trabalhosalao.Model.DAO.Dao.getConnection;
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
public class TipoDao extends Dao implements ITipoRepo {
    private final String INSERT_SQL = "INSERT INTO `tbTipo`(`NmTipo`,`Status`) VALUES (?,?)";
    private final String UPDATE_SQL = "UPDATE tbTipo set NmTipo=? where CdTipo=?";
    private final String DELETE_SQL = "DELETE FROM tbTipo WHERE CdTipo=?";
    private final String SELECT_FOR_ID_SQL = "select * from tbTipo where CdTipo = ?";
    private final String SELECT_FOR_NOME_SQL = "select * from tbTipo where `Status` = 'A' AND NmTipo like ? ";
    private final String SELECT_SQL = "select * from tbTipo where `Status` = 'A'";

    @Override
    public int inserir(Tipo p) throws DaoException {
        int ret = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNmTipo());
            ps.setString(2,"A");

            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.Inserir( " + p.getNmTipo() + ")-:" + p.getClass(), e);
        }
        return ret;
    }

    @Override
    public void alterar(Tipo p) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
            ps.setString(1, p.getNmTipo());
            ps.setInt(2, p.getCdTipo());
            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.Alterar( " + p.getNmTipo() + ")-:" + p.getClass(), e);
        }
    }

    @Override
    public void excluir(Tipo p) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, p.getCdTipo());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.Excluir( " + p.getNmTipo() + ")-:" + p.getClass(), e);
        }
    }

    @Override
    public Tipo consultarPorId(int cod) throws DaoException {
        Tipo ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_ID_SQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                ret = getTipoFromRs(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.ConsultarPorCod ", e);
        }
        return ret;
    }

    @Override
    public List<Tipo> consultarPorNome(String nome) throws DaoException {
        List<Tipo> ret = new ArrayList<Tipo>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_NOME_SQL);
            ps.setString(1,nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Tipo p = getTipoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.ConsultarPorCod ", e);
        }
        return ret;
    }

    @Override
    public List<Tipo> consultar() throws DaoException {
        List<Tipo> ret = new ArrayList<Tipo>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Tipo p = getTipoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.ConsultarPorCod ", e);
        }
        
        return ret;
    }

    private Tipo getTipoFromRs(ResultSet rs)
            throws DaoException {
        Tipo t = new Tipo();
        try {
            t.setCdTipo(rs.getInt("CdTipo"));
            t.setNmTipo(rs.getString("NmTipo"));

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Tipo.Dao.getTipoFromRs ", e);
        }
        return t;

    }
    public static void main(String[] args) {
        try{
        TipoDao pDao = new TipoDao();
//        Tipo t1 = new Tipo();
//        Tipo t2 = new Tipo();
//        
//        t1.setNmTipo("Corte.");
//        t2.setNmTipo("Manicure");
//        
//        int i=pDao.inserir(t2);
//        System.out.println(i);
//        
//        i=pDao.inserir(t2);
//        System.out.println(i);

//        Tipo p2 = new Tipo();
//        p2.setNmTipo("Krequicista");    
//        pDao.inserir(p2);
//        pDao.excluir(p2);

//        Tipo t3 = new Tipo();
//        t3.setNmTipo("Corte");
//        pDao.inserir(t3);
//        pDao.alterar(t3);
//
//        Tipo p4 = new Tipo();
//        p4.setCdTipo(4);
//        p4.setNmTipo("Seudisonado");
//        pDao.alterar(p4);

//         Tipo prf = pDao.consultarPorId(1);
//        
//        System.out.println(""+prf.getNmTipo()+" "+prf.getCdTipo()+".");

//         Tipo prf1 = pDao.consultarPorNome("K");
//        
//        System.out.println(""+prf1.getNmTipo()+" "+prf1.getCdTipo()+".");

//
//         List<Tipo> prf1 = pDao.consultarPorNome("K");
//
//            for (int i = 0; i < prf1.size(); i++) {
//                Tipo al = prf1.get(i);
//                System.out.println(al.getCdTipo());
//                System.out.println(al.getNmTipo());
//            }
//
               List<Tipo> prf2 = pDao.consultar();

            for (int i = 0; i < prf2.size(); i++) {
                Tipo al = prf2.get(i);
                System.out.println(al.getCdTipo());
                System.out.println(al.getNmTipo());
            }
    


            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (DaoException ex) {
            ex.printStackTrace();
        }

    }
}