package conexion;
import java.sql.*;

public class Conexion {
    private String Driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/prueba";
    private String user = "root";
   private String pass = "";
    private Connection conex;
    
    
    public Conexion() {
        conectar();
    }         
    public Connection getConexion(){
        return conex;
    }     
        
   private void conectar(){
        try{
            Class.forName(Driver);
            conex = DriverManager.getConnection(URL,user,pass);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }                
    }
    public void desconectar(){
        try{
            conex.close();
        }catch(SQLException ex){
         ex.printStackTrace();   
        }
    }
    public PreparedStatement prepararSQL(String sql){
        PreparedStatement st = null;
        try{
            st = conex.prepareStatement(sql);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return st;
    }
}