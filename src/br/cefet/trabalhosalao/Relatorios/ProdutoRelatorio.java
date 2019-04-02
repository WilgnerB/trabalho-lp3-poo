/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Relatorios;

import br.cefet.trabalhosalao.Model.Bean.Produto;
import static br.cefet.trabalhosalao.Model.DAO.Dao.getConnection;
import br.cefet.trabalhosalao.Model.DAO.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author wilgn
 */
public class ProdutoRelatorio {
        
    public void emitirRelatorio(List <Produto> pList){
        String reportSource = "./reportProduto.jasper";
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("Title", "Salão Tia Eliane");
        
        try{
            JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(pList);
            JasperPrint jasperPrint = JasperFillManager.fillReport( reportSource, params, jrBean);
            
            JasperViewer.viewReport(jasperPrint, false);
            
        }catch(JRException ex){
            ex.printStackTrace();
        }
    }
    
    
    public void processar() throws JRException, ClassNotFoundException, SQLException, DaoException{
        String reportSrcFile = "./reportProduto.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        Connection conn = getConnection();
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
        
        JasperViewer.viewReport(print, false);
        System.out.println("Done!");
    }
}
