/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcDatosDeudores;
import com.laticobsa.modelo.LcDetRecaudaciones;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcFormapagoRecaudacion;
import com.laticobsa.modelo.LcRecaudaciones;
import com.laticobsa.modelo.LcTiposIdentificacion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
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
public class PagosServicios {
    
     public List<LcDetRecaudaciones> getLcDatosPagoActual(){
        Date fecha_reg = new Date();
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String convertido = fecha.format(fecha_reg);
        System.out.println(convertido);
        try {
             SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
             Date ActualDate = dateFormatter.parse(convertido);
              
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDetRecaudaciones  E WHERE E.fechaRegistro>= :fechaRegistro AND estado= :estado");
        q.setParameter("estado","A");
        q.setParameter("fechaRegistro",ActualDate);
        List<LcDetRecaudaciones> lista=q.list();
         for(LcDetRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getLcRecaudaciones().getLcDatosDeudores().getIdDatosDeudor());
        }
        tx.commit();
        session.close();
         return lista;
         } catch (ParseException ex) {
             Logger.getLogger(PagosServicios.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }

        public List<LcRecaudaciones> getLcDatosRecaudoActual(int empresa, int empleado){
        Date fecha_reg = new Date();
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        String convertido = fecha.format(fecha_reg);
        System.out.println(convertido);
        try {
             SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
             Date ActualDate = dateFormatter.parse(convertido);
              
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcRecaudaciones  E WHERE E.idEmpresa= :idEmpresa AND E.idEmpleado= :idEmpleado AND E.fechaRegistro>= :fechaRegistro AND estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idEmpleado",empleado);
        q.setParameter("estado","A");
        q.setParameter("fechaRegistro",ActualDate);
        List<LcRecaudaciones> lista=q.list();
         for(LcRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdRecaudacion()+", "+mrol.getLcDatosDeudores().getIdDatosDeudor()+mrol.getLcDatosDeudores().getNombresCompleto());
        }
        tx.commit();
        session.close();
         return lista;
         } catch (ParseException ex) {
             Logger.getLogger(PagosServicios.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }
    public List<LcRecaudaciones> getConsultaLcDatosRecaudaciones(int empresa, int empleado, String fechaInicio, String fechaFin){

        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           //  SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      
             Date beginDate = dateFormatter.parse(fechaInicio+" 00:00:00");
             Date endDate = dateFormatter.parse(fechaFin+" 23:59:59");             
             System.out.print("fechaInicio: "+fechaInicio+" 00:00:00");
             System.out.print("fechaFin: "+fechaFin+" 23:59:59");             

              
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcRecaudaciones  E WHERE E.idEmpresa= :idEmpresa AND E.idEmpleado= :idEmpleado AND E.fechaRegistro>= :beginDate AND E.fechaRegistro<= :endDate AND estado= :estado");
        q.setParameter("idEmpresa",empresa);
        q.setParameter("idEmpleado",empleado);
        q.setParameter("estado","A");
        q.setParameter("beginDate",beginDate);             
        q.setParameter("endDate",endDate);
        List<LcRecaudaciones> lista=q.list();
         for(LcRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdRecaudacion()+", "+mrol.getLcDatosDeudores().getIdDatosDeudor()+mrol.getLcDatosDeudores().getNombresCompleto());
        }
        tx.commit();
        session.close();
         return lista;
         } catch (ParseException ex) {
             Logger.getLogger(PagosServicios.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    } 
        
    public List<LcDatosDeudores> getLcDatosDeudoIDE(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDatosDeudores  E WHERE E.idDatosDeudor= :idDatosDeudor  and E.estado= :estado");
        q.setParameter("idDatosDeudor",ide);
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
    public List<LcRecaudaciones> getLcREcaudacionIDE(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcRecaudaciones  E WHERE E.idDeudor= :idDeudor  and E.estado= :estado");
        q.setParameter("idDeudor",ide);
        q.setParameter("estado","A");
        List<LcRecaudaciones> lista=q.list();
         for(LcRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdRecaudacion()+", "+mrol.getLcDatosDeudores().getIdDatosDeudor());
             
        }
        tx.commit();
        session.close();
         return lista;
    } 
    
    public List<LcTiposIdentificacion> getLctipoIde(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcTiposIdentificacion  E WHERE E.idTipoIdentificacion= :idTipoIdentificacion  and E.estado= :estado");
        q.setParameter("idTipoIdentificacion",ide);
        q.setParameter("estado","A");
        List<LcTiposIdentificacion> lista=q.list();
         for(LcTiposIdentificacion mrol:lista )
        {
             System.out.println("ok: "+mrol.getTipoIdentificacion()+", "+mrol.getDescripcion());
             
        }
        tx.commit();
        session.close();
         return lista;
    }
    public List<LcEmpleados> getLcoficial(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcEmpleados  E WHERE E.idEmpleado= :idEmpleado  and E.estado= :estado");
        q.setParameter("idEmpleado",ide);
        q.setParameter("estado","A");
        List<LcEmpleados> lista=q.list();
         for(LcEmpleados mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdEmpleado()+", "+mrol.getNombres());
             
        }
        tx.commit();
        session.close();
         return lista;
    }
    public List<LcRecaudaciones> getLcREcaudacion(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcRecaudaciones  E WHERE E.idRecaudacion= :idRecaudacion  and E.estado= :estado");
        q.setParameter("idRecaudacion",ide);
        q.setParameter("estado","A");
        List<LcRecaudaciones> lista=q.list();
         for(LcRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdRecaudacion()+", "+mrol.getLcDatosDeudores().getIdDatosDeudor());
             
        }
        tx.commit();
        session.close();
         return lista;
    }
    public List<LcDetRecaudaciones> getDEtalle(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDetRecaudaciones  E WHERE E.lcRecaudaciones.idRecaudacion= :idRecaudacion  and E.estado= :estado");
        q.setParameter("idRecaudacion",ide);
        q.setParameter("estado","A");
        List<LcDetRecaudaciones> lista=q.list();
         for(LcDetRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getValorRecaudado());
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getIdArticulo());
        }
        tx.commit();
        session.close();
         return lista;
    }  
    public List<LcDetRecaudaciones> getDEtalleid( int idRecaudacion){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDetRecaudaciones  E WHERE  E.lcRecaudaciones.idRecaudacion= :idRecaudacion and E.estado= :estado");
        q.setParameter("idRecaudacion",idRecaudacion);
        
        q.setParameter("estado","A");
        List<LcDetRecaudaciones> lista=q.list();
         for(LcDetRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getValorRecaudado());
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getIdArticulo());
        }
        tx.commit();
        session.close();
         return lista;
    }  
    public List<LcFormapagoRecaudacion> getPagoid( int idRecaudacion){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcFormapagoRecaudacion  E WHERE  E.lcRecaudaciones.idRecaudacion= :idRecaudacion and E.estado= :estado");
        q.setParameter("idRecaudacion",idRecaudacion);
        
        q.setParameter("estado","A");
        List<LcFormapagoRecaudacion> lista=q.list();
         for(LcFormapagoRecaudacion mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdFormpago()+", "+mrol.getTotalRecaudado());
             System.out.println("ok: "+mrol.getIdFormpago()+", "+mrol.getIdEntidadFinanciera());
        }
        tx.commit();
        session.close();
         return lista;
    }  
     public List<LcFormapagoRecaudacion> getFormPago(int  ide){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcFormapagoRecaudacion  E WHERE E.lcRecaudaciones.idRecaudacion= :idRecaudacion  and E.estado= :estado");
        q.setParameter("idRecaudacion",ide);
        q.setParameter("estado","A");
        List<LcFormapagoRecaudacion> lista=q.list();
         for(LcFormapagoRecaudacion mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdFormpago()+", "+mrol.getLcRecaudaciones().getIdRecaudacion());
             
        }
        tx.commit();
        session.close();
         return lista;
    }  
    
    public void deletePago(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        LcDetRecaudaciones agen = (LcDetRecaudaciones) session.get(LcDetRecaudaciones.class, id);
        agen.setEstado("I");
        session.update(agen);
        tx.commit();
        session.close();
    }    
    public void deleteCabecera(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        LcRecaudaciones agen = (LcRecaudaciones) session.get(LcRecaudaciones.class, id);
        agen.setEstado("I");
        session.update(agen);
        tx.commit();
        session.close();
    }
        public void deleteFormaPago(int idRecaudacion) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        LcFormapagoRecaudacion agen = (LcFormapagoRecaudacion) session.get(LcFormapagoRecaudacion.class, idRecaudacion);
        agen.setEstado("I");
        session.update(agen);
        tx.commit();
        session.close();
    }
    //idRecaudacion,idArticulo,numCuota,Valor_cuota,Valor_Pagar,Interes,Mora,Saldo,fecha_act
    public void updateCabecera(int idRecaudacion, BigDecimal valor,Date fecha){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcRecaudaciones agen = (LcRecaudaciones)session.get(LcRecaudaciones.class, idRecaudacion);
    agen.setValorRecaudado(valor);
    agen.setFechaActualizado(fecha);
    session.update(agen);
    tx.commit();
    session.close();
    }    
    public void updateDetalle(int idDetRecaudacion,BigDecimal Valor_Pagar,BigDecimal Saldo,Date fecha){ //int idArticulo,int numCuota,BigDecimal Valor_cuota,BigDecimal Interes,BigDecimal Mora,
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcDetRecaudaciones agen = (LcDetRecaudaciones)session.get(LcDetRecaudaciones.class, idDetRecaudacion);
//    agen.setIdArticulo(idArticulo);
//    agen.setNumeroCuotas(numCuota);
//    agen.setValorCuota(Valor_cuota);
    agen.setValorRecaudado(Valor_Pagar);
//    agen.setInteres(Interes);
//    agen.setMora(Mora);
    agen.setSaldo(Saldo);
    agen.setFechaActualizado(fecha);
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    public void updateTipoPago(int idPago,int tipopago,BigDecimal ValorEfectivo,BigDecimal ValorTarjeta,int inst_tarjeta,String num_tarjeta,BigDecimal ValorCheque,int inst_cheque,String num_cheque,Date fecha){ //int idArticulo,int numCuota,BigDecimal Valor_cuota,BigDecimal Interes,BigDecimal Mora,
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcFormapagoRecaudacion agen = (LcFormapagoRecaudacion)session.get(LcFormapagoRecaudacion.class, idPago);
    if(tipopago ==1){
        agen.setTotalRecaudado(ValorEfectivo);
        agen.setFechaActualizado(fecha);
    }
    if(tipopago == 2){
        agen.setTotalRecaudado(ValorTarjeta);
        agen.setNumTarjetaCred(num_tarjeta);
        agen.setIdEntidadFinanciera(inst_tarjeta);
        agen.setFechaActualizado(fecha);
    }
    if(tipopago == 3){
        agen.setTotalRecaudado(ValorCheque);
        agen.setNumCheque(num_cheque);
        agen.setIdEntidadFinanciera(inst_cheque);
        agen.setFechaActualizado(fecha);
    }
    session.update(agen);
    tx.commit();
    session.close();
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
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("select nextval('lc_formapago_recaudacion_id_formpago_seq')");
        Long key = ((BigInteger) query.uniqueResult()).longValue();
        tx.commit();
        session.close();
        return key;
    }
    public void updateTipoPagoEstado(int idPago){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcFormapagoRecaudacion agen = (LcFormapagoRecaudacion)session.get(LcFormapagoRecaudacion.class, idPago);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    public List<LcDetRecaudaciones> getDEtalleide( int iddetalle){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        Query q = session.createQuery("from LcDetRecaudaciones  E WHERE  E.idDetRecaudacion= :idDetRecaudacion and E.estado= :estado");
        q.setParameter("idDetRecaudacion",iddetalle);
        
        q.setParameter("estado","A");
        List<LcDetRecaudaciones> lista=q.list();
         for(LcDetRecaudaciones mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getValorRecaudado());
             System.out.println("ok: "+mrol.getIdDetRecaudacion()+", "+mrol.getIdArticulo());
        }
        tx.commit();
        session.close();
         return lista;
    }
    public void updateDEtallEstado(int idetalle){
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session= factory.openSession();
    Transaction tx=session.beginTransaction();
    LcDetRecaudaciones agen = (LcDetRecaudaciones)session.get(LcDetRecaudaciones.class, idetalle);
    agen.setEstado("I");
    session.update(agen);
    tx.commit();
    session.close();
    }
    
    
}
