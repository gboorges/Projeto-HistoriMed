package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author giovanna borges - cg3018334
 */

public class ConexaoDAO {
    public Connection conectaBD(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/historimed?useSSL=false";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO: " + erro.getMessage());
        }
        
        return conn;
    }
}