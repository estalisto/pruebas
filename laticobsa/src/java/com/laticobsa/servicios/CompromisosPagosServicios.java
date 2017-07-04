/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcCompromisosPago;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CIMA2015
 */
public class CompromisosPagosServicios {
    
    
public List<LcCompromisosPago> getLcCompromisosPago(Date fechaCompromiso, int IDEmpleado) {
     
         
     
     try {
         SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
         String result;
         result = dateFormatter.format(fechaCompromiso);
         Date beginDate = dateFormatter.parse(result);
         
         
         SessionFactory sesion = HibernateUtil.getSessionFactory();
         Session session;
         session = sesion.openSession();
         Transaction tx= session.beginTransaction();
         Query q = session.createQuery("FROM LcCompromisosPago E WHERE E.lcDatosDeudores.idEmpleado = :IDEmpleado  AND E.fechaCompromiso >= :beginDate");
         q.setParameter("IDEmpleado",IDEmpleado);
         q.setParameter("beginDate",beginDate);
         List<LcCompromisosPago> lista=q.list();
         for(LcCompromisosPago compp:lista )
         {
             
             System.out.println("compp: "+compp.getLcDatosDeudores().getNombres()+", "+compp.getIdCliente()+" "+compp.getLcDatosDeudores().getApellidos()+""+compp.getIdCliente()+compp.getLcDatosDeudores().getIdDatosDeudor());
             System.out.println("compp: ");
         }
          tx.commit();
        session.close();
         return lista;
     } catch (ParseException ex) {
         Logger.getLogger(CompromisosPagosServicios.class.getName()).log(Level.SEVERE, null, ex);
     } 
         return null;
    }
 
 public List<LcCompromisosPago> getLcCompromisosPagoFechas(String fechaInicio,String fechaFin, int IDEmpleado){
     
         
         try {
             SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
             SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy-MM-dd");      
             Date beginDate = dateFormatter.parse(fechaInicio);
             Date endDate = dateFormatter.parse(fechaFin);             
             System.out.print("fechaInicio: "+fechaInicio);
             System.out.print("fechaFin: "+fechaFin);             
             SessionFactory sesion = HibernateUtil.getSessionFactory();
             Session session;
             session = sesion.openSession();
             Transaction tx= session.beginTransaction();
             Query q = session.createQuery("From LcCompromisosPago E WHERE E.lcDatosDeudores.idEmpleado= :IDEmpleado AND E.fechaCompromiso >= :beginDate AND E.fechaCompromiso <= :endDate");
             q.setParameter("IDEmpleado",IDEmpleado);
             q.setParameter("beginDate",beginDate);             
             q.setParameter("endDate",endDate);
             List<LcCompromisosPago> lista=q.list();
             for(LcCompromisosPago compp:lista )
             {
                 
                 System.out.println("compp: "+compp.getLcDatosDeudores().getNombres()+", "+compp.getIdCliente()+" "+compp.getLcDatosDeudores().getApellidos()+
                         compp.getLcDatosDeudores().getIdDatosDeudor()+compp.getFechaCompromiso());
                                  System.out.println("compp: ");
             }
              tx.commit();
        session.close();
             return lista; 
         } catch (ParseException ex) {
             Logger.getLogger(CompromisosPagosServicios.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    } 
    
    
}
