/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;

import br.cefet.trabalhosalao.Model.Bean.enderecoPessoa;
import static br.cefet.trabalhosalao.Model.DAO.Dao.closeConnection;
import static br.cefet.trabalhosalao.Model.DAO.Dao.getConnection;
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
public class enderecoPessoaDao extends Dao{
    private final String SELECT_SQL = "SELECT `cdEndereco`,`numero`,`logradouro`,`cep`,`cidade`,`bairro`,`uf`,P.`cdPessoa`,`nmPessoa`FROM `tbendereco` AS E,`tbpessoa` AS P WHERE  E.`CdPessoa`=P.`cdPessoa`ORDER BY P.`CdPessoa`;";
    private final String SELECT_RELATORIO_SQL = "SELECT `cdEndereco`,`numero`,`logradouro`,`cep`,`cidade`,`bairro`,`uf`,P.`cdPessoa`,`nmPessoa`FROM `tbendereco` AS E,`tbpessoa` AS P WHERE  E.`CdPessoa`=P.`cdPessoa` AND nmPessoa LIKE ? AND cidade LIKE ? ORDER BY P.`CdPessoa`;";
    private enderecoPessoa getenderecoPessoaFromRs(ResultSet rs) throws DaoException {
        enderecoPessoa p = new enderecoPessoa();
        try {
            p.setCdEndereco(rs.getInt("CdEndereco"));
            p.setNumero(rs.getInt("numero"));
            p.setLogradouro(rs.getString("logradouro"));
            p.setCep(rs.getString("cep"));
            p.setCidade(rs.getString("cidade"));
            p.setBairro(rs.getString("bairro"));
            p.setUf(rs.getString("uf"));
            p.setCdPessoa(rs.getInt("cdPessoa"));
            p.setNmPessoa(rs.getString("nmPessoa"));            
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Pessao.Dao.getPessoaFromRs ", e);
        }
        return p;

    }

    public List<enderecoPessoa> consultarenderecoPessoasRelatorio () throws DaoException {
        List<enderecoPessoa> ret = new ArrayList<enderecoPessoa>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                enderecoPessoa p = getenderecoPessoaFromRs(rs);
                ret.add(p);
            }
        } catch (SQLException e) {
            throw new DaoException("Erro no metodo Aluno.Dao.ConsultarPorCod ", e);
        } finally{
            closeConnection(conn, ps, rs);
        }
        return ret;
    }

    public List<enderecoPessoa> consultarenderecoPessoasRelatorioFiltro(String pessoa, String cidade) throws DaoException {
        List<enderecoPessoa> ret = new ArrayList<enderecoPessoa>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SELECT_RELATORIO_SQL);
            ps.setString(1, pessoa+"%");
            ps.setString(2, cidade+"%");
            rs = ps.executeQuery();

            while (rs.next()) {
                enderecoPessoa p = getenderecoPessoaFromRs(rs);
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
