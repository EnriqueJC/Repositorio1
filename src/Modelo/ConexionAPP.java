/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikef
 */
public class ConexionAPP {
    //datos para la conexion
    private final String bd="login";
    private final String user="root";
    private final String pass="";
    private final String url="jdbc:mysql://localhost:3306/"+bd;
    //metodo para la conexion
    private Connection  con=null;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionAPP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAPP.class.getName()).log(Level.SEVERE, null, ex);
        }return con;
    }    
}
