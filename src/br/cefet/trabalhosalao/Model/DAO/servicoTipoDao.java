/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;

import br.cefet.trabalhosalao.Model.Bean.servicoTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilgn
 */
public class servicoTipoDao extends Dao{
    private final String SELECT_SQL = "SELECT `Cdservico`, `Nmservico`, `VlAtual`, S.`CdTipo`, `NmTipo` FROM`tbservico` AS S,`tbtipo` AS T WHERE S.`CdTipo` = T.`CdTipo` ORDER BY T.`CdTipo`;";
    private final String SELECT_RELATORIO_SQL = "SELECT `Cdservico`, `Nmservico`, `VlAtual`, S.`CdTipo`, `NmTipo` FROM`tbservico` AS S,`tbtipo` AS T WHERE S.`CdTipo` = T.`CdTipo` AND `Nmservico` LIKE ? AND `NmTipo` LIKE ? ORDER BY T.`CdTipo`;";

    private servicoTipo getservicoTipoFromRs(ResultSet rs) throws DaoException {
        servicoTipo p = new servicoTipo();
        try {
            p.setCdServico(rs.getInt("Cdservico"));
            p.setNmServico(rs.getString("Nmservico"));
            p.setVlAtual(rs.getDouble("VlAtual"));
            p.setCdTipo(rs.getInt("CdTipo"));
            p.setNmTipo(rs.getString("NmTipo"));
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessao.Dao.getPessoaFromRs ", e);
        }
        return p;

    }

    public List<servicoTipo> consultarservicoTiposRelatorio () throws DaoException {
        List<servicoTipo> ret = new ArrayList<servicoTipo>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                servicoTipo p = getservicoTipoFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }
    
        public List<servicoTipo> consultarservicoTiposRelatorioFiltro (String servico,String tipo) throws DaoException {
        List<servicoTipo> ret = new ArrayList<servicoTipo>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_RELATORIO_SQL);
            ps.setString(1, servico+"%");
            ps.setString(2, tipo+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                servicoTipo p = getservicoTipoFromRs(rs);
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
