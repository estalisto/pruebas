/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcArticulo;
import com.laticobsa.modelo.LcCiudad;
import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcCompromisosPago;
import com.laticobsa.modelo.LcCuotas;
import com.laticobsa.modelo.LcDatosDeudores;
import com.laticobsa.modelo.LcDireccion;
import com.laticobsa.modelo.LcGestiones;
import com.laticobsa.modelo.LcNotas;
import com.laticobsa.modelo.LcRecordatorios;
import com.laticobsa.modelo.LcTelefonos;
import com.laticobsa.modelo.LcTipoGestion;
import com.laticobsa.modelo.LcTipoResultado;
import com.laticobsa.modelo.LcTransacciones;
import com.laticobsa.utils.Conexion;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class ConsultaxCarteraServicios {
         public List<LcDatosDeudores> getLcDatosDeudores(int empresa, int agencia,int empleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("select DISTINCT(E.lcClientes.idCliente)  from LcDatosDeudores  E WHERE E.lcAgencia.idAgencia= :idAgencia and E.idEmpleado= :idEmpleado and E.lcEmpresa.idEmpresa= :idEmpresa and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idAgencia",agencia);
        q.setParameter("idEmpleado",empleado);
        q.setParameter("estado","P");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
        }
        tx.commit();
        session.close();
         return lista;
    }
          public List<LcClientes> getLcDatoscliente(int empresa,int empleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery(" from LcClientes  E WHERE E.idCliente= :idCliente and E.lcEmpresa.idEmpresa= :idEmpresa ");
        q.setParameter("idEmpresa",empresa);
        //q.setParameter("idAgencia",agencia);
        q.setParameter("idCliente",empleado);
        //q.setParameter("estado","P");
        List<LcClientes> lista=q.list();
         for(LcClientes mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdCliente());
        }
        tx.commit();
        session.close();
         return lista;
    }
         
        public Integer getIdCliente(int empresa, int agencia,int empleado) {
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx= session.beginTransaction();
            Query q = session.createQuery("select DISTINCT E.lcClientes.idCliente  from LcDatosDeudores  E WHERE E.lcAgencia.idAgencia= :idAgencia and E.idEmpleado= :idEmpleado and E.lcEmpresa.idEmpresa= :idEmpresa and E.estado= :estado");
            q.setParameter("idEmpresa",empresa);
            q.setParameter("idAgencia",agencia);
            q.setParameter("idEmpleado",empleado);
            q.setParameter("estado","A");
             //List listDatos = q.list();
            List listResult = q.list();
            Integer number;
            if(listResult.size()==0){
               number=0;
            }else{
            number = (Integer) listResult.get(0);
            }
            
            tx.commit();  
            session.close();
        return number; 
       
        }

         
public List<LcDatosDeudores> getLcDatosposicion(int empresa, int agencia,int posicion, int IDEmpleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.idDatosDeudor>= :idDatosDeudor and E.lcAgencia.idAgencia= :idAgencia and  E.lcEmpresa.idEmpresa= :idEmpresa and E.idEmpleado = :IDEmpleado and E.estado= :estado").setMaxResults(10);
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idAgencia",agencia);
        
        q.setParameter("IDEmpleado",IDEmpleado); 
        q.setParameter("idDatosDeudor",posicion); 
        q.setParameter("estado","P");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
        }
        tx.commit();
        session.close();
         return lista;
    }       
         
        public List<LcDatosDeudores> getLcDatos(int empresa, int agencia,int cliente, int IDEmpleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.lcAgencia.idAgencia= :idAgencia and E.lcClientes.idCliente= :idCliente and E.lcEmpresa.idEmpresa= :idEmpresa and E.idEmpleado = :IDEmpleado and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idAgencia",agencia);
        q.setParameter("idCliente",cliente);
        q.setParameter("IDEmpleado",IDEmpleado);        
        q.setParameter("estado","P");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
        }
        tx.commit();
        session.close();
         return lista;
    } 
        public List<LcDatosDeudores> getLcDatos2(int empresa, int agencia, int IDEmpleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.lcAgencia.idAgencia= :idAgencia and E.lcEmpresa.idEmpresa= :idEmpresa and E.idEmpleado = :IDEmpleado and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idAgencia",agencia);
        q.setParameter("IDEmpleado",IDEmpleado);        
        q.setParameter("estado","A");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
        }
        tx.commit();
        session.close();
         return lista;
    }         
    public ArrayList<LcDatosDeudores> getLcobteneregistros(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcDatosDeudores> arreglo = new ArrayList<LcDatosDeudores>();
        Query q = session.createQuery("from LcDatosDeudores  E WHERE  E.estado= :estado");
        
        q.setParameter("estado","P");
        List<LcDatosDeudores> lista=q.list();
        Iterator<LcDatosDeudores> iter=lista.iterator();
        while(iter.hasNext())
        {
            LcDatosDeudores rol= (LcDatosDeudores) iter.next();
            arreglo.add(rol);
        }
         tx.commit();
        session.close();
        return arreglo;

    }        
    public Integer numeroregistros() {
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx= session.beginTransaction();
            Query q = session.createQuery("select max(*) from LcDatosDeudores E WHERE E.estado= :estado");
            q.setParameter("estado","P");
           
            List listResult = q.list();
            Integer number = (Integer) listResult.size();
            tx.commit();  
            session.close();
        return number; 
       
        }

public List<LcDatosDeudores> getLcDatosidentifica(String identificacion,int empresa,int cliente){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.lcEmpresa.idEmpresa= :idEmpresa and E.lcClientes.idCliente= :idCliente and E.identificacion= :identificacion");
        q.setParameter("idCliente",cliente);
        q.setParameter("identificacion",identificacion);
        q.setParameter("idEmpresa",empresa);
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
             System.out.println("Ciudad: "+mrol.getLcCiudad().getIdCiudad()+mrol.getLcCiudad().getCiudad());
        }
        tx.commit();
        session.close();
         return lista;
    }          
public List<LcDatosDeudores> getLcDeudorId(int id,int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.lcClientes.idCliente= :idCliente and E.idDatosDeudor= :idDeudor");
        q.setParameter("idCliente",id);
        q.setParameter("idDeudor",idDeudor);
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
             System.out.println("Ciudad: "+mrol.getLcCiudad().getIdCiudad()+mrol.getLcCiudad().getCiudad());
            
        }
        tx.commit();
        session.close();
         return lista;
    }  
public List<LcTransacciones> getTransaccionesId(int id,int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcTransacciones  E WHERE E.lcClientes.idCliente= :idCliente and E.lcDatosDeudores.idDatosDeudor= :idDeudor");
        q.setParameter("idCliente",id);
        q.setParameter("idDeudor",idDeudor);
        List<LcTransacciones> lista=q.list();
         for(LcTransacciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdTransaccion()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdTransaccion()+", "+mrol.getLcClientes().getRazonSocial());
             
             System.out.println("ok: "+mrol.getIdTransaccion()+", "+mrol.getLcDatosDeudores().getNombresCompleto());
             
            
             
        }
        tx.commit();
        session.close();
         return lista;
    }  
public String getIdentificacionDeudor(int idDeudor){
       
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("Select E.identificacion from LcDatosDeudores  E WHERE E.idDatosDeudor= :idDeudor and estado= :estado");
        //q.setParameter("idCliente",id);
        q.setParameter("idDeudor",idDeudor);  
        q.setParameter("estado","A");    
       String Identificacion;
             Identificacion = "";
             Identificacion = q.list().toString();
        String cadena = Identificacion.replace("[", "");
               cadena =cadena.replace("]", "");
                
        System.out.println(cadena);
         tx.commit();
         session.close();

         return cadena;
    }

public List<LcDireccion> getLcDireccion(String ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcDireccion  E WHERE E.identificacionDeudor= :identificacionDeudor");      
        q.setParameter("identificacionDeudor",ide);
        List<LcDireccion> lista=q.list();
       
         for(LcDireccion mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDireccion()+", "+mrol.getDireccionCompleta());
             System.out.println("ok: "+mrol.getIdDireccion()+", "+mrol.getLcTiposDireccion().getNombreTipoDireccion());
             
        }
        tx.commit();
        session.close();
         return lista;
    }

public List<LcTelefonos> getLcTelefono(String ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcTelefonos  E WHERE E.identificacionDeudor= :identificacionDeudor");
        q.setParameter("identificacionDeudor",ide);
        List<LcTelefonos> lista=q.list();

         for(LcTelefonos mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdTelefono()+", "+mrol.getTelefono());
             System.out.println("ok: "+mrol.getIdTelefono()+", "+mrol.getLcTiposTelefono().getNombreTipoTlf());
             
        }
         tx.commit();
        session.close();
         return lista;
    }

public List<LcCiudad> getLcCiudad(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcCiudad  E WHERE E.estado= :estado");
        q.setParameter("estado","A");
        List<LcCiudad> lista=q.list();
         for(LcCiudad mrol:lista )
        {
            
             System.out.println("ok: "+mrol.getIdCiudad()+", "+mrol.getCiudad());
             
        }
        tx.commit();
        session.close();
         return lista;
    }


public List<LcGestiones> getGestionesTRX(int idCliente,int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcGestiones  E WHERE  E.lcDatosDeudores.idDatosDeudor = :idDeudor  and   E.lcClientes.idCliente= :idCliente and  E.estado= :estado order by E.fechaTransaccion desc");
        
        q.setParameter("idCliente",idCliente);
        q.setParameter("idDeudor",idDeudor);
        q.setParameter("estado","A");
        List<LcGestiones> lista=q.list();
         for(LcGestiones mrol:lista )
        {
            
             System.out.println("ok: "+mrol.getLcClientes().getRazonSocial()+" "+ mrol.getLcDatosDeudores().getNombres()+" "+mrol.getLcTipoGestion().getNombreTipoGestion()+" "+ mrol.getLcTipoResultado().getNombreTipoResultado()+""+mrol.getLcEmpleados().getNombres()+""+mrol.getLcEmpleados().getApellidos());
             
        }
          tx.commit();
        session.close();

         return lista;
    }
public List<LcArticulo> getArticulos(int idCliente,int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcArticulo  E WHERE  E.lcDatosDeudores.idDatosDeudor = :idDeudor  and   E.idCliente= :idCliente and  E.estado= :estado order by E.fechaRegistro");       
        q.setParameter("idCliente",idCliente);
        q.setParameter("idDeudor",idDeudor);
        q.setParameter("estado","A");
        List<LcArticulo> lista=q.list();
         for(LcArticulo mrol:lista )
        {
            
             System.out.println("ok: "+mrol.getNombreArticulo()+" "+ mrol.getReferencia()+" "+mrol.getFechaCompra()+""+mrol.getValorArticulo());
             
        }
          tx.commit();
        session.close();

         return lista;
    }
public List<LcCuotas> getCuotas(int idCliente,int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcCuotas  E WHERE  E.lcDatosDeudores.idDatosDeudor = :idDeudor  and   E.idCliente= :idCliente and  E.estado= :estado order by E.numCuotas DESC");       
        q.setParameter("idCliente",idCliente);
        q.setParameter("idDeudor",idDeudor);
        q.setParameter("estado","A");
        List<LcCuotas> lista=q.list();
         for(LcCuotas mrol:lista )
        {
            
             System.out.println("ok: "+mrol.getIdCuota()+" "+ mrol.getLcArticulo().getReferencia()+" "+mrol.getInteresCuota()+""+mrol.getNumCuotas()+mrol.getGastosAdicional()+
                     mrol.getGastosCobranzas()+mrol.getInteresCuota()+mrol.getValorMora()+mrol.getOtrosValores()+mrol.getTotalCuotas()+mrol.getFechaMaxPago()+mrol.getValorCuota());
             
        }
          tx.commit();
        session.close();

         return lista;
    }

    public void addRecordatorio(LcRecordatorios recordatorio){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(recordatorio);
    tx.commit();
    session.close();
    }

    public void addGestiones(LcGestiones gestion){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(gestion);
    tx.commit();
    session.close();
    }
    
    public List<LcDatosDeudores> getLcDeudorRecordatorio(int id,int empresa,int sucursal,int empleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.idDatosDeudor= :idDatosDeudor and E.lcEmpresa.idEmpresa= :idEmpresa and E.lcAgencia.idAgencia= :idAgencia and E.idEmpleado= :idEmpleado");
        q.setParameter("idDatosDeudor",id);
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idAgencia",sucursal);
        q.setParameter("idEmpleado",empleado);
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
        }
        tx.commit();
        session.close();
         return lista;
    }
    
    public Long getNext() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createSQLQuery( "select nextval('lc_recordatorios_id_recordatorio_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; // return ((BigInteger) query.uniqueResult()).longValue();
    }
    public Long getNext2() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createSQLQuery( "select nextval('lc_gestiones_id_gestion_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; // return ((BigInteger) query.uniqueResult()).longValue();
    }
    
    
    public List<LcTipoGestion> getLcTipoGestion(int cliente){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcTipoGestion  E WHERE E.idCliente= :idCliente and E.estado= :estado");
        q.setParameter("idCliente",cliente);
        q.setParameter("estado","A");
        List<LcTipoGestion> lista=q.list();
         for(LcTipoGestion mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdTipoGestion());

        }
 tx.commit();
        session.close();
         return lista;
    }
    public ArrayList<LcTipoResultado> getLcTipoResultado(int gestion){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcTipoResultado> arreglo = new ArrayList<LcTipoResultado>();
        Query q = session.createQuery("from LcTipoResultado  E WHERE E.lcTipoGestion.idTipoGestion= :idTipoGestion and E.estado= :estado");
        q.setParameter("idTipoGestion",gestion);
        q.setParameter("estado","A");
        List<LcTipoResultado> lista=q.list();
        Iterator<LcTipoResultado> iter=lista.iterator();
        while(iter.hasNext())
        {
            LcTipoResultado rol= (LcTipoResultado) iter.next();
            arreglo.add(rol);
        }
         tx.commit();
        session.close();
        return arreglo;

    }
    public List<LcNotas> getLcNotas(int id,int idDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        ArrayList<LcNotas> arreglo = new ArrayList<LcNotas>();
        Query q = session.createQuery("from LcNotas  E WHERE E.idCliente= :idCliente and E.idDeudor= :idDeudor and E.estado= :estado");
        q.setParameter("idCliente",id);
        q.setParameter("idDeudor",idDeudor);
        q.setParameter("estado","A");
        List<LcNotas> lista=q.list();
         for(LcNotas mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdNota());
             System.out.println("ok: "+mrol.getIdNota()+", "+mrol.getIdDeudor());
             System.out.println("ok: "+mrol.getIdNota()+", "+mrol.getIdCliente());
        }
        tx.commit();
        session.close();
         return lista;
    }
    
    public List<LcNotas> getLcNotasId(int idNota,int idDeudor,int idCliente){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcNotas  E WHERE E.idCliente= :idCliente and E.idDeudor= :idDeudor and E.idNota= :idNota and E.estado= :estado");
        q.setParameter("idCliente",idCliente);
        q.setParameter("idDeudor",idDeudor);
        q.setParameter("idNota",idNota);
        q.setParameter("estado","A");
        List<LcNotas> lista=q.list();
         for(LcNotas mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdNota());
             System.out.println("ok: "+mrol.getIdNota()+", "+mrol.getIdDeudor());
             System.out.println("ok: "+mrol.getIdNota()+", "+mrol.getIdCliente());
        }
          tx.commit();
        session.close();
         return lista;
    }
    public void addNota(LcNotas nota){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(nota);
    tx.commit();
    session.close();
    }
    
    public void updateNota(int idNota, String txtnota){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcNotas agen = (LcNotas)session.get(LcNotas.class, idNota);
    agen.setObservacion(txtnota);
    session.update(agen);
    tx.commit();
    session.close();
    }
    public void updateTransactionState(int idTransaccion,String estado){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcTransacciones agen = (LcTransacciones)session.get(LcTransacciones.class, idTransaccion);
    agen.setEstado(estado);
    session.update(agen);
    tx.commit();
    session.close();
    }
    public Long getNext3() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("select nextval('lc_notas_id_nota_seq')");
        Long key = ((BigInteger) query.uniqueResult()).longValue();
        tx.commit();
        session.close();
        return key; 
    }
      public Long getNext4() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("select nextval('lc_compromisos_pago_id_compromiso_seq')");
        Long key = ((BigInteger) query.uniqueResult()).longValue();
        tx.commit();
        session.close();
        return key; 
    }  
    public void addCompPago(LcCompromisosPago pago){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(pago);
    tx.commit();
    session.close();
    }
   public List<LcDatosDeudores> getLcDatossgte(int empresa, int cliente, int IDEmpleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.lcClientes.idCliente= :idCliente and E.lcEmpresa.idEmpresa= :idEmpresa and E.idEmpleado = :IDEmpleado and E.estado= :estado order by E.idDatosDeudor");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idCliente",cliente);
        q.setParameter("IDEmpleado",IDEmpleado);        
        q.setParameter("estado","A");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getIdCliente());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcClientes().getRazonSocial());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getIdTipocredito());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcTipoCredito().getDescripcion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getIdEstatus());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getLcEstatus().getDescripcion());
        }
        tx.commit();
        session.close();
         return lista;
    } 
   public String getDatosCarteras(int IdCliente, int IdEmpleado, int IdFiltro)throws SQLException{
    
            Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
            String valor = "";
            int opcion=0;
            opcion=IdFiltro;
            String Ordenar="";
            String SQL="",SQL2="";   
            
            SQL="select  id_datos_deudor, id_cliente, identificacion, nombres_completo , dias_mora, total_vencidos, pagos, saldo, valor_compro,fecha_comp, fech_ultima_gestion,ultima_gestion,resultado_gestion,estado\n" +
"  from vw_consulta_cartera s\n" +
"where s.id_cliente="+IdCliente+"\n" +
" and s.id_empleado="+IdEmpleado; 
            
            String contenidoTabla="";
           if (opcion==0){
                // ordena por Monto de Mayor a Menor
               Ordenar="order by s.total_vencidos desc"; 
                SQL2= SQL+Ordenar;
             }
            if (opcion==1){
                // Ultima Gestion
               Ordenar="order by s.dias_mora asc"; 
                SQL2= SQL+Ordenar;
             }
            if(opcion==2){
                Ordenar="order by s.dias_mora desc";
                SQL2= SQL+Ordenar;
             }
            if(opcion==3){// ordena por Dias Mora de Menor a Mayor
                Ordenar="order by s.total_vencidos asc"; 
                SQL2= SQL+Ordenar;
            }
            if(opcion==4){ //ordena por Dias Mora de Mayor a Menor
                Ordenar="order by s.fech_ultima_gestion asc"; 
                SQL2= SQL+Ordenar;
            }
            if(opcion==5){ //ordena por fecha ultima gestion de Mayor a Menor
                Ordenar="order by s.fech_ultima_gestion desc";
                SQL2= SQL+Ordenar;
            }
           
          
               
           String id_datos_deudor;
String identificacion;
String nombres_completo;
String dias_mora;
String total_vencidos;
String pagos;
String saldo;
String valor_compro;
String fecha_comp;
String fech_ultima_gestion;
String ultima_gestion;
String resultado_gestion;
String estado;
String id_cliente;
String color;
            try
            {
           
            pst = conexion.getconexion().prepareStatement(SQL2);
                rs = pst.executeQuery();
            
            while( rs.next() )    //Mientras haya una sig. tupla
                {
 id_datos_deudor=rs.getString("id_datos_deudor");
 identificacion=rs.getString("identificacion");
 nombres_completo=rs.getString("nombres_completo");
 dias_mora=rs.getString("dias_mora");
 total_vencidos=rs.getString("total_vencidos");
 pagos=rs.getString("pagos");
 saldo=rs.getString("saldo");
 valor_compro=rs.getString("valor_compro");
 fecha_comp=rs.getString("fecha_comp");
 fech_ultima_gestion=rs.getString("fech_ultima_gestion");
 ultima_gestion=rs.getString("ultima_gestion"); 
 resultado_gestion=rs.getString("resultado_gestion");
 estado=rs.getString("estado");
 if(!estado.equals("A")){
 color="class=\"text-warning\"";
 }else{
 color="";
 }
 
 id_cliente=rs.getString("id_cliente");      
  
// contenidoTabla=contenidoTabla+"<tr onclick='cobranzas2("+id_cliente+","+id_datos_deudor+");'>"+

 
  contenidoTabla=contenidoTabla+"<tr  bgcolor=\"#E0ECF8\" onclick=\"cobranzas2("+id_cliente+","+id_datos_deudor+");\"  >\n" +
"                                                                    <td><h6><p "+color+" >"+id_datos_deudor+"</p></h6></td>\n" +
"                                                                    <td><h6><p "+color+" >"+identificacion+"</p> </h6></td>\n" +
"                                                                    <td><h6><p "+color+" >"+nombres_completo+"</p></h6></td>\n" +
"                                                                    <td align=\"center\"><h6><p "+color+" >"+dias_mora+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+total_vencidos+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+pagos+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+saldo+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+valor_compro+"</p></h6> </td>\n" +
"                                                                    <td align=\"center\"><h6><p "+color+" >"+fecha_comp+"</p></h6></td>\n" +          
"                                                                    <td align=\"center\"><SUB><p "+color+" >"+fech_ultima_gestion+"</p></SUB></td>\n" +
"                                                                    <td align=\"center\"> <h6><p "+color+" >"+ultima_gestion+"</p> </h6></td>\n" +
"                                                                    <td align=\"center\"><h6><p "+color+" > "+resultado_gestion+"</p> </h6></td>\n" +
"                                                                </tr>";
 
            }
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
                 valor=contenidoTabla;
                return valor;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return valor;
            
    }
   
  
     public String getRetornaQuery(int IdCliente, int IdEmpleado, int IdFiltro)throws SQLException{
    
          
            int opcion;
            opcion=IdFiltro;
            String Ordenar="";
            if (opcion==0){
               
               Ordenar="order by s.total_vencidos desc"; 
                
             }
            if (opcion==1){
                // Ultima Gestion
               Ordenar="order by s.fech_ultima_gestion asc"; 
                
             }
            if(opcion==2){
                Ordenar="order by s.total_vencidos asc"; 
             }
             if(opcion==3){// ordena por Dias Mora de Menor a Mayor
                Ordenar="order by s.dias_mora asc"; 
            }
            if(opcion==4){ //ordena por Dias Mora de Mayor a Menor
                Ordenar="order by s.dias_mora desc"; 
            }
            if(opcion==5){ //ordena por fecha ultima gestion de Mayor a Menor
                Ordenar="order by s.fech_ultima_gestion desc"; 
            }
            if(opcion==6){ //ordena por fecha ultima gestion de Menor a Mayor
                Ordenar="order by s.fech_ultima_gestion asc"; 
            }
            String SQL="";
            SQL="select  id_datos_deudor, id_cliente, identificacion, nombres_completo , dias_mora, total_vencidos, pagos, saldo, valor_compro,fecha_comp, fech_ultima_gestion,ultima_gestion,resultado_gestion,estado\n" +
            "  from vw_consulta_cartera s\n" +
            " where s.id_cliente="+IdCliente+"\n" +
            " and s.id_empleado="+IdEmpleado+" "+Ordenar; 
        return SQL;
            
    }
        public String getRetornaQuery2(int IdCliente, int IdEmpleado, int IdFiltro)throws SQLException{
    
          
            int opcion;
            opcion=IdFiltro;
            String Ordenar="";
            if (opcion==0){ Ordenar="order by s.dias_mora desc"; }
            if (opcion==1){ Ordenar="order by s.dias_mora asc"; }
            
           
            String SQL="";
            SQL="select  id_datos_deudor, id_cliente, identificacion, nombres_completo , dias_mora, total_vencidos, pagos, saldo, valor_compro,fecha_comp, fech_ultima_gestion,ultima_gestion,resultado_gestion,estado \n" +
            "  from vw_consulta_cartera s\n" +
            " where s.id_cliente="+IdCliente+"\n" +
            " and s.id_empleado="+IdEmpleado+" "+Ordenar; 
        return SQL;
            
    }
   
   public List<String> getDatosCarterasSiguienteAnterior(int IdCliente, int IdEmpleado, int IdFiltro)throws SQLException{
    
            Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
            String valor = "";
            int opcion;
            opcion=IdFiltro;
            String Ordenar="";
            if (opcion==0){
                // ordena por Monto de Mayor a Menor
               Ordenar="order by s.total_vencidos desc"; 
             }
            if (opcion==1){
                // Ultima Gestion
               Ordenar="order by s.fech_ultima_gestion asc"; 
                
             }
            if(opcion==2){
                Ordenar="order by s.total_vencidos asc"; 
             }
             if(opcion==3){// ordena por Dias Mora de Menor a Mayor
                Ordenar="order by s.dias_mora asc"; 
            }
            if(opcion==4){ //ordena por Dias Mora de Mayor a Menor
                Ordenar="order by s.dias_mora desc"; 
            }
            if(opcion==5){ //ordena por fecha ultima gestion de Mayor a Menor
                Ordenar="order by s.fech_ultima_gestion desc"; 
            }
            if(opcion==6){ //ordena por fecha ultima gestion de Menor a Mayor
                Ordenar="order by s.fech_ultima_gestion asc"; 
             }
            String SQL="";   
            
            SQL="select  id_datos_deudor\n" +
                "  from vw_consulta_cartera s\n" +
                "where s.id_cliente="+IdCliente+"\n" +
                " and s.id_empleado="+IdEmpleado+" "+Ordenar; 
           String id_datos_deudor;
          // List idDeudorCartera = new ArrayList();
           List<String> idDeudorCartera = new ArrayList<String>();
            try
            {
             pst = conexion.getconexion().prepareStatement(SQL);
             rs = pst.executeQuery();
              
            while( rs.next() )    //Mientras haya una sig. tupla
                {
                    id_datos_deudor=rs.getString("id_datos_deudor");
                    idDeudorCartera.add(id_datos_deudor);
            }
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
                
                return idDeudorCartera;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return idDeudorCartera;
            
    }
   public List<String> getEjecutaQueryDatosDeudor(String sql)throws SQLException{
    
            Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
            
           
            String SQL="";   
            
            SQL=sql; 
           String id_datos_deudor;
          // List idDeudorCartera = new ArrayList();
           List<String> idDeudorCartera = new ArrayList<String>();
            try
            {
             pst = conexion.getconexion().prepareStatement(SQL);
             rs = pst.executeQuery();
              
            while( rs.next() )    //Mientras haya una sig. tupla
                {
                    id_datos_deudor=rs.getString("id_datos_deudor");
                    idDeudorCartera.add(id_datos_deudor);
            }
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
                
                return idDeudorCartera;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return idDeudorCartera;
            
    }
    public String getGestiones(int IdCliente, int IdEmpleado)throws SQLException{
    
            Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
            String valor = "";
           
            String SQL="";
            
            SQL="select (SELECT t_1.nombre_tipo_gestion\n" +
"                   FROM \n" +
"                    lc_tipo_gestion t_1\n" +
"                  WHERE  t_1.id_cliente=g.id_cliente AND   t_1.id_tipo_gestion =g.id_tipo_gestion   ) AS ultima_gestion,\n" +
"\n" +
"( SELECT lc_tipo_resultado.nombre_tipo_resultado\n" +
"                           FROM lc_tipo_resultado\n" +
"                          WHERE lc_tipo_resultado.id_tipo_resultado = g.id_tipo_resultado) AS nombre_tipo_resultado,\n" +
"g.observacion, (SELECT t_1.nombres||' '||t_1.apellidos nombres\n" +
"                   FROM \n" +
"                    lc_empleados t_1\n" +
"where id_empleado=g.id_empleado) empleado ,to_char(g.fecha_transaccion,'YYYY-MM-DD hh24:mi:ss') fecha_transaccion from lc_gestiones g\n" +
"where id_deudor="+IdEmpleado+"\n" +
"and id_cliente="+IdCliente+"\n" +
"and estado='A'\n" +
"order by g.fecha_transaccion desc"; 
            
            String contenidoTabla="";

            try
            {
           
            pst = conexion.getconexion().prepareStatement(SQL);
                rs = pst.executeQuery();
            
            while( rs.next() )    //Mientras haya una sig. tupla
            {
              contenidoTabla=contenidoTabla+" <tr   bgcolor=\"#E0ECF8\">";  
              contenidoTabla=contenidoTabla+"<td>"+rs.getString("ultima_gestion")+"</td>";  
              contenidoTabla=contenidoTabla+"<td>"+rs.getString("nombre_tipo_resultado")+"</td>";  
              contenidoTabla=contenidoTabla+"<td>"+rs.getString("observacion")+"</td>";  
              contenidoTabla=contenidoTabla+"<td>"+rs.getString("empleado")+"</td>";  
              contenidoTabla=contenidoTabla+"<td>"+rs.getString("fecha_transaccion")+"</td>";  
              contenidoTabla=contenidoTabla+"</tr>"; 
            }
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
                 valor=contenidoTabla;
                return valor;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return valor;
            
    }
    
     public String getDatosCarteras2(String query)throws SQLException{
    
            Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
            String valor = "";          
            String SQL="";               
            SQL=query;             
            String contenidoTabla="";
            String id_datos_deudor;
            String identificacion;
            String nombres_completo;
            String dias_mora;
            String total_vencidos;
            String pagos;
            String saldo;
            String valor_compro;
            String fecha_comp;
            String fech_ultima_gestion;
            String ultima_gestion;
            String resultado_gestion;
            String estado;
            String id_cliente;
            String color;
            try
            {
           
            pst = conexion.getconexion().prepareStatement(SQL);
                rs = pst.executeQuery();
            
            while( rs.next() )    //Mientras haya una sig. tupla
                {
 id_datos_deudor=rs.getString("id_datos_deudor");
 identificacion=rs.getString("identificacion");
 nombres_completo=rs.getString("nombres_completo");
 dias_mora=rs.getString("dias_mora");
 total_vencidos=rs.getString("total_vencidos");
 pagos=rs.getString("pagos");
 saldo=rs.getString("saldo");
 valor_compro=rs.getString("valor_compro");
 fecha_comp=rs.getString("fecha_comp");
 fech_ultima_gestion=rs.getString("fech_ultima_gestion");
 ultima_gestion=rs.getString("ultima_gestion"); 
 resultado_gestion=rs.getString("resultado_gestion");
 estado=rs.getString("estado");
 if(!estado.equals("A")){
 color="class=\"text-warning\"";
 }else{
 color="";
 }
 
 id_cliente=rs.getString("id_cliente");      
  
// contenidoTabla=contenidoTabla+"<tr onclick='cobranzas2("+id_cliente+","+id_datos_deudor+");'>"+

 
  contenidoTabla=contenidoTabla+"<tr  bgcolor=\"#E0ECF8\" onclick=\"cobranzas2("+id_cliente+","+id_datos_deudor+");\"  >\n" +
"                                                                    <td><h6><p "+color+" >"+id_datos_deudor+"</p></h6></td>\n" +
"                                                                    <td><h6><p "+color+" >"+identificacion+"</p> </h6></td>\n" +
"                                                                    <td><h6><p "+color+" >"+nombres_completo+"</p></h6></td>\n" +
"                                                                    <td align=\"center\"><h6><p "+color+" >"+dias_mora+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+total_vencidos+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+pagos+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+saldo+"</p></h6></td>\n" +
"                                                                    <td align=\"right\"><h6><p "+color+" >"+valor_compro+"</p></h6> </td>\n" +
"                                                                    <td align=\"center\"><h6><p "+color+" >"+fecha_comp+"</p></h6></td>\n" +          
"                                                                    <td align=\"center\"><SUB><p "+color+" >"+fech_ultima_gestion+"</p></SUB></td>\n" +
"                                                                    <td align=\"center\"> <h6><p "+color+" >"+ultima_gestion+"</p> </h6></td>\n" +
"                                                                    <td align=\"center\"><h6><p "+color+" > "+resultado_gestion+"</p> </h6></td>\n" +
"                                                                </tr>";
 
            }
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
                 valor=contenidoTabla;
                return valor;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return valor;
            
    }
  
   
}
