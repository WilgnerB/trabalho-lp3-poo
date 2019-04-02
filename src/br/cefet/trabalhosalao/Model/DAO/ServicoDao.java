package br.cefet.trabalhosalao.Model.DAO;

import br.cefet.trabalhosalao.Model.Bean.Servico;
import br.cefet.trabalhosalao.Model.Bean.Tipo;
import static br.cefet.trabalhosalao.Model.DAO.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.cefet.trabalhosalao.Interfaces.IServicoRepo;
import br.cefet.trabalhosalao.Model.DAO.Dao;
import br.cefet.trabalhosalao.Model.DAO.DaoException;

/**
 *
 * @author Derek Jonso
 */
public class ServicoDao extends Dao implements IServicoRepo {

    private final String INSERT_SQL = "INSERT INTO `bdsalao`.`tbservico`(`Nmservico`,`VlAtual`,`CdTipo`,`Status`) VALUES (?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE `bdsalao`.`tbservico` SET `Cdservico` = ?,`Nmservico` = ?,`VlAtual` = ?,`CdTipo` = ? WHERE `Cdservico` = ?;";
    private final String DELETE_SQL = "DELETE FROM tbServico WHERE CdServico=?";
    private final String SELECT_FOR_ID_SQL = "SELECT `s`.`Cdservico`,`s`.`Nmservico`,`s`.`VlAtual`,`s`.`CdTipo`,`t`.`NmTipo`FROM `tbservico` `s`,`tbtipo` `t`WHERE `s`.`CdTipo`=`t`.`CdTipo` and s.CdServico = ?;";
    private final String SELECT_FOR_NOME_SQL = "SELECT `s`.`Cdservico`,`s`.`Nmservico`,`s`.`VlAtual`,`s`.`CdTipo`,`t`.`NmTipo`"
            + "FROM `tbservico` `s`,`tbtipo` `t`"
            + "WHERE `s`.`Status` = 'A' AND `s`.`CdTipo`=`t`.`CdTipo` and NmServico like ?";
    private final String SELECT_SQL = "SELECT `s`.`Cdservico`,`s`.`Nmservico`,`s`.`VlAtual`,`s`.`CdTipo`,`t`.`NmTipo`FROM `tbservico` `s`,`tbtipo` `t`WHERE `s`.`Status` = 'A' AND `s`.`CdTipo`=`t`.`CdTipo`;";

    @Override
    public int inserir(Servico s) throws DaoException {
        int ret = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, s.getNmServico());
            ps.setDouble(2, s.getValorAt());
            ps.setInt(3, s.getTipo().getCdTipo());
            ps.setString(4, "A");

            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ret = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.Inserir( " + s.getNmServico() + ")-:" + s.getClass(), e);
        }
        return ret;
    }

    @Override
    public void alterar(Servico s) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_SQL);
            ps.setInt(1, s.getCdServico());
            ps.setString(2, s.getNmServico());
            ps.setDouble(3, s.getValorAt());
            ps.setInt(4, s.getTipo().getCdTipo());
            ps.setInt(5, s.getCdServico());

            ps.execute();

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.Alterar( " + s.getNmServico() + ")-:" + s.getClass(), e);
        }
    }

    @Override
    public void excluir(Servico p) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, p.getCdServico());

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.Excluir( " + p.getNmServico() + ")-:" + p.getClass(), e);
        }
    }

    @Override
    public Servico consultarPorId(int cod) throws DaoException {
        Servico ret = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_ID_SQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                ret = getServicoFromRs(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.ConsultarPorCod ", e);
        }
        return ret;
    }

    @Override
    public List<Servico> consultarPorNome(String nome) throws DaoException {
        List<Servico> ret = new ArrayList<Servico>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_FOR_NOME_SQL);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                
                Servico p = getServicoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.ConsultarPorCod ", e);
        }
        return ret;
    }

    @Override
    public List<Servico> consultar() throws DaoException {
        List<Servico> ret = new ArrayList<Servico>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Servico p = getServicoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.ConsultarPorCod ", e);
        }

        return ret;
    }

    private Servico getServicoFromRs(ResultSet rs)
            throws DaoException {
        Servico p = new Servico();
        try {
            p.setCdServico(rs.getInt("CdServico"));
            p.setNmServico(rs.getString("NmServico"));
            p.setValorAt(rs.getDouble("VlAtual"));
            Tipo t = new Tipo();
            t.setCdTipo(rs.getInt("CdTipo"));
            t.setNmTipo(rs.getString("NmTipo"));
            p.setTipo(t);

        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Servico.Dao.getServicoFromRs ", e);
        }
        return p;

    }

    public static void main(String[] args) {
        try {

            ServicoDao sDao = new ServicoDao();

//        Servico s1 = new Servico();
//        Tipo t1= new Tipo();
//        Tipo t2 = new Tipo();
//        
//        t1.setCdTipo(1);
//        t1.setNmTipo("Corte.");
//        
//        t2.setCdTipo(2);
//        t2.setNmTipo("Manicure");
//
//        s1.setCdServico(1);
//        s1.setNmServico("Não tão Completão.");
//        s1.setValorAt(27.30);
//        s1.setTipo(t2);  
//        
//        int i =sDao.inserir(s1);
//        System.out.println(i);
//        
//        sDao.alterar(s1);
//        int i=sDao.inserir(s1);
//        System.out.println(i);
//         Servico prf = sDao.consultarPorId(2);
//        
//        System.out.println(""+prf.getNmServico()+" "+prf.getCdServico()+".");
//         Servico prf1 = pDao.consultarPorNome("K");
//        
//        System.out.println(""+prf1.getNmServico()+" "+prf1.getCdServico()+".");
//
//         List<Servico> prf1 = sDao.consultarPorNome("C");
//
//            for (int i = 0; i < prf1.size(); i++) {
//                Servico al = prf1.get(i);
//                System.out.println(al.getCdServico());
//                System.out.println(al.getNmServico());
//            }

//               List<Servico> prf2 = sDao.consultar();
//
//            for (int i = 0; i < prf2.size(); i++) {
//                Servico al = prf2.get(i);
//                System.out.println(al.getCdServico());
//                System.out.println(al.getNmServico());
//            }
//            List<Servico> s=sDao.consultar();
//            for (int i = 0; i < s.size(); i++) {
//                Servico get = s.get(i);
//                System.out.println("Codigo serviço: "+ get.getCdServico()+" | Nome Serviço: "+ get.getNmServico() +" | Valor: "+get.getValorAt()
//                + " | Codigo do tipo: "+get.getTipo().getCdTipo()+" | Nome do Tipo: "+get.getTipo().getNmTipo());
//            }
//            
//            
             Servico s7 = sDao.consultarPorId(1);
            System.out.println(" "+s7.getCdServico()+" "+s7.getNmServico()+" "+s7.getValorAt()+" "+s7.getTipo().getNmTipo()+" "+s7.getTipo().getCdTipo());
//            
//            List<Servico> s = sDao.consultarPorNome("N");
//            for (int i = 0; i < s.size(); i++) {
//                Servico get = s.get(i);
//                System.out.println("Codigo serviço: " + get.getCdServico() + " | Nome Serviço: " + get.getNmServico() + " | Valor: " + get.getValorAt()
//                        + " | Codigo do tipo: " + get.getTipo().getCdTipo() + " | Nome do Tipo: " + get.getTipo().getNmTipo());
//            }

        } catch (DaoException ex) {
            ex.printStackTrace();
        }

    }
}
