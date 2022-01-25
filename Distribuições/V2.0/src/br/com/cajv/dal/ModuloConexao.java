package br.com.cajv.dal;

 /*@author islan*/
import java.sql.*;

public class ModuloConexao {
    // Método responsável por estabelecer a conexão com o banco.
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        // Chamar o driver:
        String driver = "com.mysql.cj.jdbc.Driver";
        
        // Armazenando informações referentes ao banco.
        String url="jdbc:mysql://localhost:3306/cajazeiras_varejo";
        String user = "root";
        String password = "admin12345";
        
        // Estabelecendo conexão com o banco.
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // Apoio de erros:
             System.out.println(e);
            return null;
        }
    }
}
