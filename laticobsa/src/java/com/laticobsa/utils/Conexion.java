/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ViewSoft
 */
public class Conexion {
    
   String url2="jdbc:postgresql://localhost:5432/bdjsp3";
 Connection cn=null;
     public Connection getconexion(){
        String url="jdbc:postgresql://localhost:5432/bdjsp3";
        String user = "sgranda";
        String pass = "sgranda";
        
        try{
            Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        
        return cn;
    }
     
    public void cierraConexion()
    {
        try
        {
            cn.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }
 
   
    
    public Connection getconexion2(){
        Connection cn=null;
        try{
            Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection(url2,"postgres","sebas2008");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }
    
    
}
