/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import conexion.Conexion;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diabulus
 */
public class funciones {
    
    public boolean compararlogin(String loginusuario, String loginpass){
        String sql = "SELECT usuario FROM usuario WHERE usuario='"+loginusuario+"' and pass=SHA2('"+loginpass+"',224);";
        //System.out.println(sql);
        Conexion conn = new Conexion();
        boolean existe = false;
        try{
                PreparedStatement st = conn.prepararSQL(sql);
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    existe = true;
                }
        }catch(SQLException ex){
        }finally{
                conn.desconectar();
        }
        System.out.println(existe);
        return existe;
    }
    
    
    public String obtenerPrivilegio(String loginusuario, String loginpass){
        String sql = "SELECT privilegio FROM usuario WHERE usuario='"+loginusuario+"' and pass=SHA2('"+loginpass+"',224);";
        Conexion conn = new Conexion();
        String privilegios= "";
        try{

             PreparedStatement st = conn.prepararSQL(sql);
                 ResultSet rs = st.executeQuery();
            if(rs.next()){
                privilegios = rs.getString(1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        conn.desconectar();
        }
        return privilegios;
    }
    
    
    public static void mostrarDatos(String sql) {
        try {
            Conexion conn = new Conexion();
           
            Statement st = conn.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                
                String rut = (rs.getString(1));
                String nombre1 = (rs.getString(2));
                String nombre2 = (rs.getString(3));
                String apellido1 = (rs.getString(4));
                String apellido2 = (rs.getString(5));
                String direccion = (rs.getString(6));
                int nota = (rs.getInt(7));
                JOptionPane.showMessageDialog(null, " RUT: "+rs.getString(1)+"\n NOMBRE: "+rs.getString(2)+"\n NOMBRE: "+rs.getString(3)+"\n APELLIDO: "+rs.getString(4)+"\n APELLIDO 2: "+rs.getString(5)+"\n DIRECCION: "+rs.getString(6)+"\n NOTA: "+rs.getString(7));
                //System.out.println("RUT: "+rs.getString(1)+"\n NOMBRE"+rs.getString(2)+"\n NOMBRE: "+rs.getString(3)+"\n APELLIDO: "+rs.getString(4)+"\n APELLIDO 2: "+rs.getString(5)+"\n DIRECCION: "+rs.getString(6)+"\n NOTA: "+rs.getString(7));
            }            
            rs.close();
            conn.desconectar();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
   public static void insertarnuevacuenta(Postulante nuevopostulante) {
        try {
            Conexion conn = new Conexion();
//            String sql = "insert into minimarket.cuenta(minimarket.cuenta.nombre, minimarket.cuenta.usuario, minimarket.cuenta.rut,minimarket.cuenta.pass,minimarket.cuenta.privilegios)"
//                    + "values('" + cuentanueva.getNombre() + "','" + cuentanueva.getUsuario() + "','" + cuentanueva.getRut() +  "','"+cuentanueva.getPass()+"','"+ cuentanueva.getPrivilegios()+"')";
            String sql = "INSERT INTO prueba.postulante (rut, nombre1, nombre2, apellido1, apellido2, direccion, promedio) "
                    + "VALUES ('"+nuevopostulante.getRut()+"', '"+nuevopostulante.getNombre()+"', '"+nuevopostulante.getNombre2()+"', '"+nuevopostulante.getApellido()+"', '"+nuevopostulante.getApellido2()+"', '"+nuevopostulante.getDireccion()+"', '"+nuevopostulante.getPromedio()+"');";
            Statement st = conn.getConexion().createStatement();
            JOptionPane.showMessageDialog(null, sql);
            //int res = st.executeUpdate(sql);
            //if (res == 1) {
//                JOptionPane.showMessageDialog(null, "Postulante Ingresado Correctamente");
            //}
            conn.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
////////////////////////////////////////////////////////////////////////////////
              
//       public static void cargarTablaMantenimientoProveedor(JTable tabla, String sql) {
//        try {
//            Conexion conn = new Conexion();
//           
//            Statement st = conn.getConexion().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            DefaultTableModel modelo= (DefaultTableModel)tabla.getModel();
//            modelo.getDataVector().clear();
//
//            while(rs.next()){
//                
//                String telefonos = retornaTelefonos(rs.getString(1));
//                String[] parte = telefonos.split("-");
//                String telefono1 = parte[0];
//                String telefono2 = parte[1];
//                String telefono3= parte[2];
//                String [] fila = {rs.getString(1), rs.getString(2),rs.getString(3),telefono1,telefono2,telefono3,rs.getString(4)};
//                modelo.addRow(fila);
//                tabla.setModel(modelo);
//            }
//            rs.close();
//            conn.desconectar();
//        }catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//    }
    
       
}

