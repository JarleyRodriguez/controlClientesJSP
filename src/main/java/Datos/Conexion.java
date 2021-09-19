package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String jdbc_URL = "jdbc:mysql://localhost:3306/control_cliente?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String jdbc_User = "root";
    private static final String jdbc_Password = "admin";
    
    
    // metodo para reuperar la conexion a la base de datos 
    
    public static BasicDataSource getDataSource(){
    
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(jdbc_URL);
        ds.setUsername(jdbc_User);
        ds.setPassword(jdbc_Password);
        ds.setInitialSize(50);
        return ds;
        // quiza deveria cambiar para q que si regrese in dataSource
  
    }
    
    public static Connection getConnection () throws SQLException{
        
        return getDataSource().getConnection();
        
    }
    
    public static void close(ResultSet rs) {
    
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close (PreparedStatement ps){
        
        try {
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection con){
        
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
}
