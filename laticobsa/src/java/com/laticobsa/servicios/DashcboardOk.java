/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;


import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.utils.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author CIMA2015
 */
public class DashcboardOk {
    
    Conexion conexion=new Conexion();
   
    PreparedStatement pst;
    ResultSet rs;
    
    public String ObtenerCompromisosPagos() throws SQLException{
        String cadena="";
        pst = conexion.getconexion().prepareStatement("select \n" +
"'['''||a.mes||''','||a.cantidad||'],' campo1\n" +
" from (\n" +
"select * from (\n" +
"\n" +
"select count(*) cantidad  from public.lc_compromisos_pago c\n" +
"where c.fecha_compromiso BETWEEN to_date(extract (year  from (select date_trunc('month',current_date)))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date) ))||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date))),'YYYY-MM-DD') AND \n" +
"\n" +
"to_date(extract (year  from (select date_trunc('month',current_date) +'1month' ::interval  -'1sec' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date)+'1month' ::interval  -'1sec' ::interval )) ||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date)+'1month' ::interval  -'1sec' ::interval )),'YYYY-MM-DD')\n" +
"\n" +
") cantidad,\n" +
"(select to_char(current_date, 'TMMonth')  mes ) mes\n" +
"\n" +
"\n" +
"union all\n" +
"\n" +
"\n" +
"select * from (\n" +
"\n" +
"select count(*) cantidad from public.lc_compromisos_pago c\n" +
"where c.fecha_compromiso BETWEEN to_date(extract (year  from (select date_trunc('month',current_date) -'1month' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date)-'1month' ::interval ))||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date) -'1month' ::interval)),'YYYY-MM-DD') AND \n" +
"\n" +
"to_date(extract (year  from (select date_trunc('month',current_date)  -'1sec' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date) -'1sec' ::interval )) ||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date)  -'1sec' ::interval )),'YYYY-MM-DD') \n" +
") cantidad,\n" +
"(select to_char(current_date -'1month' ::interval , 'TMMonth') mes ) mes\n" +
"\n" +
"union all\n" +
"\n" +
"\n" +
"select * from (\n" +
"select count(*) cantidad from public.lc_compromisos_pago c\n" +
"where c.fecha_compromiso BETWEEN to_date(extract (year  from (select date_trunc('month',current_date) -'1month' ::interval -'1month' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date)-'1month' ::interval -'1month' ::interval ))||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date) -'1month' ::interval -'1month' ::interval)),'YYYY-MM-DD') AND \n" +
"\n" +
"to_date(extract (year  from (select date_trunc('month',current_date) -'1month' ::interval -'1sec' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date) -'1month' ::interval -'1sec' ::interval )) ||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date) -'1month' ::interval -'1sec' ::interval )),'YYYY-MM-DD')\n" +
") cantidad,\n" +
"(select to_char(current_date -'1month' ::interval -'1month' ::interval , 'TMMonth') mes ) mes\n" +
") a");    
        //connBD.createStatement();
        rs = pst.executeQuery();
        
        while( rs.next() )    //Mientras haya una sig. tupla
            {
            
            cadena=cadena+rs.getString("campo1");
            System.out.println(cadena);
        }
        
        
        rs.close();
        pst.close();
        conexion.cierraConexion();
        return cadena;
    
    } 
    
    
     public String ObtenerGestiones() throws SQLException{
        String cadena="";
        pst = conexion.getconexion().prepareStatement("select \n" +
"'['''||a.mes||' - '||extract (year  from (select date_trunc('month',current_date)))||''','||a.cantidad||'],' campo1\n" +
" from (\n" +
"\n" +
"\n" +
"select * from (\n" +
"select count(*) cantidad from public.lc_gestiones c\n" +
"where c.fecha_transaccion BETWEEN to_date(extract (year  from (select date_trunc('month',current_date) -'1month' ::interval -'1month' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date)-'1month' ::interval -'1month' ::interval ))||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date) -'1month' ::interval -'1month' ::interval)),'YYYY-MM-DD') AND \n" +
"\n" +
"to_date(extract (year  from (select date_trunc('month',current_date) -'1month' ::interval -'1sec' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date) -'1month' ::interval -'1sec' ::interval )) ||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date) -'1month' ::interval -'1sec' ::interval )),'YYYY-MM-DD')\n" +
") cantidad,\n" +
"(select to_char(current_date -'1month' ::interval -'1month' ::interval , 'TMMonth') mes ) mes\n" +
"\n" +
"union all\n" +
"\n" +
"\n" +
"select * from (\n" +
"\n" +
"select count(*) cantidad from public.lc_gestiones c\n" +
"where c.fecha_transaccion BETWEEN to_date(extract (year  from (select date_trunc('month',current_date) -'1month' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date)-'1month' ::interval ))||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date) -'1month' ::interval)),'YYYY-MM-DD') AND \n" +
"\n" +
"to_date(extract (year  from (select date_trunc('month',current_date)  -'1sec' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date) -'1sec' ::interval )) ||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date)  -'1sec' ::interval )),'YYYY-MM-DD') \n" +
") cantidad,\n" +
"(select to_char(current_date -'1month' ::interval , 'TMMonth') mes ) mes\n" +
"\n" +
"union all\n" +
"select * from (\n" +
"\n" +
"select count(*) cantidad  from public.lc_gestiones c\n" +
"where c.fecha_transaccion BETWEEN to_date(extract (year  from (select date_trunc('month',current_date)))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date) ))||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date))),'YYYY-MM-DD') AND \n" +
"\n" +
"to_date(extract (year  from (select date_trunc('month',current_date) +'1month' ::interval  -'1sec' ::interval ))||'-'||\n" +
"extract (month  from (select date_trunc('month',current_date)+'1month' ::interval  -'1sec' ::interval )) ||'-'||\n" +
"extract (day  from (select date_trunc('month',current_date)+'1month' ::interval  -'1sec' ::interval )),'YYYY-MM-DD')\n" +
"\n" +
") cantidad,\n" +
"(select to_char(current_date, 'TMMonth')  mes ) mes\n" +
"\n" +
") a");    
        //connBD.createStatement();
        rs = pst.executeQuery();       
        while( rs.next() )    //Mientras haya una sig. tupla
            {
            
            cadena=cadena+rs.getString("campo1");
            //System.out.println(cadena);
        }
        
         rs.close();    
         pst.close();
         conexion.cierraConexion();
        return cadena;
    
    } 
     
}
