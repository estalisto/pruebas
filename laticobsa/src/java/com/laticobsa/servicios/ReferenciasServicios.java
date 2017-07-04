/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcReferencias;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CIMA2015
 */
public class ReferenciasServicios {
    
    
   public void addReferencias(LcReferencias referencias){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(referencias);
    tx.commit();
    session.close();
    }   
    
 public Long getNext() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createSQLQuery( "select nextval('lc_referencias_id_referencia_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; // return ((BigInteger) query.uniqueResult()).longValue();
    }
 
 public List<LcReferencias> getDatosLcReferencias(int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
       // ArrayList<LcReferencias> arreglo = new ArrayList<LcReferencias>();
        Query q = session.createQuery("from LcReferencias E WHERE E.idDeudor = :idDeudor ");
        q.setParameter("idDeudor",idDeudor);
         List<LcReferencias> lista=q.list();
         for(LcReferencias mrol:lista )
        {
             System.out.println("Referencia: "+mrol.getNombreReferencia()+", "+mrol.getLcTipoReferencia().getDescripcion()+mrol.getIdReferencia());
             
        }
    tx.commit();
    session.close();
         return lista;
    } 
     
}
