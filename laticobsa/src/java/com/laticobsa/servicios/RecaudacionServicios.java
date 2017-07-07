/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcCuotas;
import com.laticobsa.modelo.LcDatosDeudores;
import com.laticobsa.modelo.LcDetRecaudaciones;
import com.laticobsa.modelo.LcFormapagoRecaudacion;
import com.laticobsa.modelo.LcInstitucion;
import com.laticobsa.modelo.LcRecaudaciones;
import com.laticobsa.utils.Conexion;
import java.math.BigDecimal;
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
 * @author CIMA2015
 */
public class RecaudacionServicios {
    public List<LcDatosDeudores> getLcDatosDeudores(int empresa, int empleado,String ide,int cliente,int tipo){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.lcClientes.idCliente= :idCliente and E.tipoIdentioficacion= :tipoIdentioficacion and  E.identificacion= :identificacion and E.idEmpleado= :idEmpleado and E.lcEmpresa.idEmpresa= :idEmpresa and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idCliente",cliente);
        q.setParameter("idEmpleado",empleado);
        q.setParameter("identificacion",ide);
        q.setParameter("tipoIdentioficacion",tipo);
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
    
    public List<LcDatosDeudores> getLcDatosDeudoIDE(int empresa,int tipo,String ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE  E.tipoIdentioficacion= :tipoIdentioficacion  and E.identificacion= :identificacion and E.lcEmpresa.idEmpresa= :idEmpresa and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("identificacion",ide);
        q.setParameter("tipoIdentioficacion",tipo);
        q.setParameter("estado","P");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getNombres());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getApellidos());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getNombresCompleto());
        }
        tx.commit();
        session.close();
         return lista;
    }    
    
     public List<LcDatosDeudores> getLcDatosDeudorNombre(int empresa,String nombres){
        
       
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE  E.nombresCompleto= :nombresCompleto and E.lcEmpresa.idEmpresa= :idEmpresa and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("nombresCompleto",nombres);
        q.setParameter("estado","P");
        List<LcDatosDeudores> lista=q.list();
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getNombres());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getApellidos());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getIdentificacion());
             System.out.println("ok: "+mrol.getIdDatosDeudor()+", "+mrol.getTipoIdentificacion());
        }
        tx.commit();
        session.close();
         return lista;
    } 
    public ArrayList<LcDatosDeudores> getLcNombresDeudor(String nombre){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        ArrayList<LcDatosDeudores> arreglo = new ArrayList<LcDatosDeudores>();
        Query q = session.createQuery("from LcDatosDeudores E WHERE upper(E.nombresCompleto) like :nombresCompleto and E.estado = :estado ").setMaxResults(10);
        q.setParameter("nombresCompleto","%"+nombre.toUpperCase()+"%");
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
    public List<LcCuotas> getIDCuotas(int idCuota){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcCuotas  E WHERE E.idCuota= :idCuota and  E.estado= :estado");       
        q.setParameter("idCuota",idCuota);
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
    public void addRecaudacion(LcRecaudaciones recaudacion){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(recaudacion);
    tx.commit();
    session.close();
    }    
    
    public Long getNext() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createSQLQuery( "select nextval('lc_recaudaciones_id_recaudacion_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; // return ((BigInteger) query.uniqueResult()).longValue();
    }    
     public void addDetRecaudacion(LcDetRecaudaciones Detrecaudacion){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(Detrecaudacion);
    tx.commit();
    session.close();
    }    
    
    public Long getNext2() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createSQLQuery( "select nextval('lc_det_recaudaciones_id_det_recaudacion_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; // return ((BigInteger) query.uniqueResult()).longValue();
    }   
     public void addFormaPago(LcFormapagoRecaudacion formaPago){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(formaPago);
    tx.commit();
    session.close();
    }    
    
    public Long getNext3() {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query query = session.createSQLQuery( "select nextval('lc_formapago_recaudacion_id_formpago_seq')" );
        Long key = ((BigInteger) query.uniqueResult()).longValue();   
        tx.commit();  
        session.close();
    return key; 
    }   
        public List<LcInstitucion> getLcInstituciones(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcInstitucion  E WHERE E.estado= :estado");

        q.setParameter("estado","A");
        List<LcInstitucion> lista=q.list();
         for(LcInstitucion mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdInstitucion()+", "+mrol.getNombreInstitucion());
             
        }
        tx.commit();
        session.close();
         return lista;
    }
     /*  public List<LcRecaudaciones> getLcRecaudaciones(int empresa,int idCliente, int idDeudor){
        
       
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcRecaudaciones  E WHERE  E.idEmpresa= :idEmpresa and E.idCliente= :idCliente and E.idCliente= :idCliente and E.estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idCliente",idCliente);
        q.setParameter("idDeudor",idDeudor);
        q.setParameter("estado","A");
        List<LcRecaudaciones> lista=q.list();
         for(LcRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getValorRecaudado());
        }
        tx.commit();
        session.close();
         return LcRecaudaciones;
    } */
       
  
     public BigDecimal getValorRecaudado(int IdEmpleado,int IdCliente,  int idDeudor)throws SQLException{
    
            Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
          //  BigDecimal valor;   
            String SQL="";               
            SQL="select r.valor_recaudado from lc_recaudaciones r where r.id_deudor="+idDeudor+" and r.id_cliente="+IdCliente+" and r.id_empresa="+IdEmpleado;     
            BigDecimal valorRecaudado=BigDecimal.ZERO;

            try
            {
           
            pst = conexion.getconexion().prepareStatement(SQL);
                rs = pst.executeQuery();
            
            while( rs.next() )    //Mientras haya una sig. tupla
            { 
                valorRecaudado= new BigDecimal(rs.getString("valor_recaudado")) ;     
 
            }
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
                // valor=valorRecaudado;
                return valorRecaudado;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return valorRecaudado;
            
    }
        
        
}
