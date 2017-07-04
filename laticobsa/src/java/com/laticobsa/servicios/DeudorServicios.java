/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcDeudor;
import com.laticobsa.modelo.LcEmpresa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ViewSoft
 */
public class DeudorServicios {
    
       public ArrayList<LcDeudor> getLcDeudor(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcDeudor> arreglo = new ArrayList<LcDeudor>();
        Query q = session.createQuery("from LcDeudor E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcDeudor> lista=q.list();
        Iterator<LcDeudor> iter=lista.iterator();
   
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcDeudor rol= (LcDeudor) iter.next();
            arreglo.add(rol);
        }
              tx.commit();
        session.close();
        return arreglo;
    }
     
   public List<LcDeudor> getLcDeudores(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDeudor E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcDeudor> lista=q.list();
        
         for(LcDeudor mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDeudor()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             
             
        }
          tx.commit();
        session.close();
         return lista;
    }    
   
   public List<LcDeudor> getLcDeudorxEmpresa(int empresa){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDeudor E WHERE E.lcEmpresa.idEmpresa= :idEmpresa and E.estado = :estado ");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("estado","A");
        List<LcDeudor> lista=q.list();
       
         for(LcDeudor mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDeudor()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             
             
        }
           tx.commit();
        session.close();
         return lista;
    }
   
    public void addDeudor(LcDeudor deudor){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(deudor);
    tx.commit();
    session.close();
    }
   
   public void updateDeudor(int idDeudor, int idEmpresa, int idCliente, String nombreCartera, String observacion, String datosAdicional){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcDeudor agen = (LcDeudor)session.get(LcDeudor.class, idDeudor);
    agen.setLcEmpresa(new LcEmpresa(idEmpresa));
    agen.setLcClientes(new LcClientes(idCliente));
    agen.setNombreCartera(nombreCartera);
    agen.setObservacion(observacion);
    agen.setDatosAdicional(datosAdicional);
    tx.commit();
    session.close();
    }
   
    public void deleteDeudor(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcDeudor agen = (LcDeudor)session.get(LcDeudor.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcDeudor> getDatosLCDeudorID(int IDDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcDeudor E WHERE E.idDeudor = :idDeudor ");
        q.setParameter("idDeudor",IDDeudor);
        List<LcDeudor> lista=q.list();
       
         for(LcDeudor mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDeudor()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             
             
        }
         tx.commit();
        session.close();
         return lista;
    }
    
         public int  SecuenciaModulo(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        int q = (int)session.createQuery("SELECT MAX(idDeudor) FROM LcDeudor").uniqueResult();
         tx.commit();
        session.close();
        
        return q;
    }
}
