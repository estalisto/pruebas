/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcAgencia;
import com.laticobsa.modelo.LcCargos;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcEstadoCivil;
import com.laticobsa.modelo.LcGenero;

import com.laticobsa.modelo.LcTiposIdentificacion;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
public class EmpleadosServicios {
    
    public ArrayList<LcEmpleados> getLCEmpleados(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("from LcEmpleados E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
        Iterator<LcEmpleados> iter=lista.iterator();
 
        while(iter.hasNext())
        {
            LcEmpleados rol= (LcEmpleados) iter.next();
            arreglo.add(rol);
        }
        tx.commit();
        session.close();
        return arreglo;
    }
    
    public List<LcEmpleados> getLcEmpleadoss(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcEmpleados");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
                                      System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
             
        }
        tx.commit();
        session.close();
         return lista;
    }
    public List<LcEmpleados> getLCEmpleados2(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcEmpleados E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
        for(LcEmpleados mrol:lista )
        {
        //     System.out.println("Empleado: "+mrol.getIdEmpleado()+", Cargo: "+mrol.getLcCargos().getCargo());
                          System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion());
             
        }tx.commit();
        session.close();
        
         return lista;
    }

    public List<LcEmpleados> getLCEmpleados3(int empresa){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.lcEmpresa.idEmpresa= :idEmpresa and E.estado = :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
        //Iterator<LcEmpleados> iter=lista.iterator();
        for(LcEmpleados mrol:lista )
        {
             //System.out.println("Empleado: "+mrol.getIdEmpleado()+", Cargo: "+mrol.getLcCargos().getCargo());
                                      System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
             
        }tx.commit();
        session.close();
        
         return lista;
    }    
    public List<LcEmpleados> getLcEmpleadosActivo(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.estado = :estado ");
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
                                      System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
             
        }
        tx.commit();
        session.close();
         return lista;
    }
    
    public List<LcEmpleados> getLcEmplInactivo(){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.estado = :estado ");
        q.setParameter("estado","I");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
                                      System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
             
        }
        tx.commit();
        session.close();
         return lista;
    }    
    public ArrayList<LcEmpleados> getDatoEncontrado(int empresa,String identificacion){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("From LcEmpleados E WHERE E.identificacion = :identificacion and E.lcEmpresa.idEmpresa= :idEmpresa  and E.estado = :estado" );
        q.setParameter("idEmpresa",empresa);
        q.setParameter("identificacion",identificacion);
        q.setParameter("estado", "A");
        List<LcEmpleados> lista=q.list();
        Iterator<LcEmpleados> iter=lista.iterator();

        while(iter.hasNext())
        {
            LcEmpleados rol= (LcEmpleados) iter.next();
            arreglo.add(rol);
        }
        tx.commit();
        session.close();
        
        return arreglo;
    }    
    public void addEmpleado(LcEmpleados empleado){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(empleado);
    tx.commit();
    session.close();
    } 
    public List<LcEmpleados> ValidaLCEmpleadoss(String ident,int empresa){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.lcEmpresa.idEmpresa= :idEmpresa and E.identificacion = :identificacion and E.estado= :estado");
        q.setParameter("identificacion",ident);
        q.setParameter("idEmpresa",empresa);
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        tx.commit();
        session.close();
         return lista;
    }
    public List<LcEmpleados> ValidaLCEmpleado(String ident){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.identificacion = :identificacion and E.estado= :estado");
        q.setParameter("identificacion",ident);
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getLcEmpresa().getIdEmpresa());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
        tx.commit();
        session.close();
         return lista;
    }
    
    public List<LcEmpleados> ValidaLCEmpleadototal(String ident, int empresa){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.identificacion = :identificacion and E.lcEmpresa.idEmpresa= :idEmpresa and E.estado= :estado");
        q.setParameter("identificacion",ident);
         q.setParameter("idEmpresa",empresa);
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
        }
         tx.commit();
        session.close();

         return lista;
    }
    
    public void updateEmpleados(int idEmpleado, int idEmpresa, int tipoIdentificacion, String identificacion, String nombres, String apellidos, String lugarNacimiento, Date fechaNacimiento, String email, String telefonos, String celular, String direccionDomicilio, int estadoCivil, int idGenero, String profesion, Integer idCargo, Integer idJefeInmediato, String observacion, int agencia){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcEmpleados agen = (LcEmpleados)session.get(LcEmpleados.class, idEmpleado);
    agen.setLcEmpresa(new LcEmpresa(idEmpresa));
    agen.setLcTiposIdentificacion(new LcTiposIdentificacion(tipoIdentificacion));
    agen.setIdentificacion(identificacion);
    agen.setNombres(nombres);
    agen.setApellidos(apellidos);
    agen.setLugarNacimiento(lugarNacimiento);
    agen.setFechaNacimiento(fechaNacimiento);
    agen.setEmail(email);
    agen.setTelefonos(telefonos);
    agen.setCelular(celular);
    agen.setDireccionDomicilio(direccionDomicilio);
    agen.setLcEstadoCivil(new LcEstadoCivil(estadoCivil));
    agen.setLcGenero(new LcGenero(idGenero));
    agen.setProfesion(profesion);
    agen.setLcCargos(new LcCargos(idCargo));
    agen.setIdJefeInmediato(idJefeInmediato);
    agen.setObservacion(observacion);
    agen.setLcAgencia(new LcAgencia(agencia));
    session.update(agen);
    tx.commit();
    session.close();
    }
   
    public void deleteEmpleado(int id){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcEmpleados agen = (LcEmpleados)session.get(LcEmpleados.class, id);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    //consulta datos por ID
    public List<LcEmpleados> getDatosLCEmpleadosID(int IDEmpleado){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEmpleados> arreglo = new ArrayList<LcEmpleados>();
        Query q = session.createQuery("from LcEmpleados E WHERE E.idEmpleado = :idEmpleado ");
        q.setParameter("idEmpleado",IDEmpleado);
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getLcEmpresa().getIdEmpresa()+mrol.getLcAgencia().getIdAgencia()+mrol.getLcAgencia().getNombre());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEstadoCivil().getDescripcion());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcTiposIdentificacion().getDescripcion());
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcGenero().getDescripcion());
             //System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcSucursal().getNombre());
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
        int q = (int)session.createQuery("SELECT MAX(idEmpleado) FROM LcEmpleados").uniqueResult();
        session.close();
            tx.commit();
    session.close();
        return q;
    }
    public ArrayList<LcTiposIdentificacion> getLcEmpTipIDE(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcTiposIdentificacion> arreglo = new ArrayList<LcTiposIdentificacion>();
        Query q = session.createQuery("from LcTiposIdentificacion  ");
        //q.setParameter("estado","A");
        List<LcTiposIdentificacion> lista=q.list();
        Iterator<LcTiposIdentificacion> iter=lista.iterator();
        tx.commit();
        session.flush();
        session.clear();
        session.close();
        
        
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcTiposIdentificacion rol= (LcTiposIdentificacion) iter.next();
            arreglo.add(rol);
        }

        return arreglo;
    }
        
        
    public ArrayList<LcGenero> getLcEmpGenero(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcGenero> arreglo = new ArrayList<LcGenero>();
        Query q = session.createQuery("from LcGenero  ");
        //q.setParameter("estado","A");
        List<LcGenero> lista=q.list();
        Iterator<LcGenero> iter=lista.iterator();

        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcGenero rol= (LcGenero) iter.next();
            arreglo.add(rol);
        }

        tx.commit();
        session.close();
        return arreglo;
    }    
       
    public ArrayList<LcEstadoCivil> getLcEmpcivil(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcEstadoCivil> arreglo = new ArrayList<LcEstadoCivil>();
        Query q = session.createQuery("from LcEstadoCivil  ");
        //q.setParameter("estado","A");
        List<LcEstadoCivil> lista=q.list();
        Iterator<LcEstadoCivil> iter=lista.iterator();
        tx.commit();
        session.close();
        //agrega los datos en la lista
        while(iter.hasNext())
        {
            LcEstadoCivil rol= (LcEstadoCivil) iter.next();
            arreglo.add(rol);
        }
        
        return arreglo;
    }  
       
 //Validaciones por empresa      
    public List<LcEmpleados> getEmpleadoxconsulta(int empresa, int user){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcEmpleados E WHERE E.idEmpleado= :idEmpleado and E.lcEmpresa.idEmpresa= :idEmpresa");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idEmpleado",user);
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             //System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
                                      System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre()+mrol.getLcAgencia().getIdAgencia());

        }
        
          tx.commit();
    session.close();
         return lista;
    }       
    public List<LcEmpleados> getEmpleadoxempresa(int empresa){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.lcEmpresa.idEmpresa= :idEmpresa");
        q.setParameter("idEmpresa",empresa);
        //q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             //System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
                         System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
        }
            tx.commit();
    session.close();
      
         return lista;
    }
       
    public List<LcEmpleados> getEmpleadoxempresaAct(int empresa){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.lcEmpresa.idEmpresa= :idEmpresa and E.estado = :estado ");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             //System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
                         System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
        }
            tx.commit();
    session.close();
      
         return lista;
    }   
    
    public List<LcEmpleados> getEmpleadoxempresaInact(int empresa){
     
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados E WHERE E.lcEmpresa.idEmpresa= :idEmpresa and E.estado = :estado ");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("estado","I");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             //System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcEmpresa().getRazonSocial());
                         System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getLcCargos().getCargo()+mrol.getNombres()+mrol.getLcCargos().getCargo()+mrol.getProfesion()+mrol.getIdJefeInmediato()+mrol.getLcEstadoCivil().getDescripcion()+mrol.getLcAgencia().getNombre());
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
        Query query = session.createSQLQuery( "select nextval('lc_empleados_id_empleado_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; // return ((BigInteger) query.uniqueResult()).longValue();
    }
}
