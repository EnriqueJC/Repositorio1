/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikef
 */
public class SqlUsuario extends ConexionAPP{//heredamos la conexion
    public boolean registrar(Usuario datos){
        PreparedStatement ps=null;
        Connection con=getConnection();
        String sql="INSERT INTO registro(usuario,password,nombre,correo,id_tipo)VALUES(?,?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, datos.getUsuario());
            ps.setString(2, datos.getPassword());
            ps.setString(3, datos.getNombre());
            ps.setString(4, datos.getCorreo());
            ps.setInt(5, datos.getId_tipo());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean ingreso(Usuario datos){
        PreparedStatement ps=null;
        ResultSet rs;
        Connection con=getConnection();
        try{
            String sql="SELECT * FROM registro WHERE usuario=? AND password=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, datos.getUsuario());
            ps.setString(2, datos.getPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                return true;
            }
            return false;
        }catch(SQLException ex){
            Logger.getLogger(SqlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
