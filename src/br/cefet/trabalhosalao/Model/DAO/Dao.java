/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefet.trabalhosalao.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Dao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/bdsalao";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws DaoException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException e){
            throw new DaoException("Erro no getConnection - Biblioteca de conexão com BD não importada." + e.getClass().getName() + "-" + e.getMessage(), e);   
        }catch (SQLException e){
             throw new DaoException("Erro no getConnection - Falha na conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }catch (Exception e){
             throw new DaoException("Erro no getConnection - Falha na conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }
        return conn;
    }

    public static void closeConnection(Connection con) throws DaoException {
        try {
            if (con != null) {
                con.close();
            }
        }catch (SQLException e){
             throw new DaoException("Erro no getConnection - Falha ao fechar conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }catch (Exception e){
             throw new DaoException("Erro no getConnection - Falha ao fechar conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) throws DaoException {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        }catch (SQLException e){
             throw new DaoException("Erro no getConnection - Falha ao fechar conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }catch (Exception e){
             throw new DaoException("Erro no getConnection - Falha ao fechar conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) throws DaoException {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        }catch (SQLException e){
             throw new DaoException("Erro no getConnection - Falha ao fechar conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }catch (Exception e){
             throw new DaoException("Erro no getConnection - Falha ao fechar conexão. " + e.getClass().getName() + "-" + e.getMessage(), e);
        }
    }

}
