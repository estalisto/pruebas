/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcDatosDeudores;
import com.laticobsa.modelo.LcDeudor;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.utils.Conexion;
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
        public List<LcDatosDeudores> getDatosDeudorID(int IDDeudor){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        Query q = session.createQuery("from LcDatosDeudores E WHERE E.idDatosDeudor = :idDatosDeudor ");
        q.setParameter("idDatosDeudor",IDDeudor);
        List<LcDatosDeudores> lista=q.list();
       
         for(LcDatosDeudores mrol:lista )
        {
             System.out.println("ok: "+mrol.getIdDatosDeudor());
             System.out.println("ok: "+mrol.getNombresCompleto());
             
             
        }
         tx.commit();
        session.close();
         return lista;
    }  
     public String getDatosTransaccion(int idDeudor)throws SQLException
    {   
        Conexion conexion=new Conexion();
            PreparedStatement pst;
            ResultSet rs;
            String valor = "";
           try
            {
            String SQL="";
             
            SQL = "select (t.id_transaccion)as id_transaccion,(c.razon_social)as razon_social,(t.total_vencidos)as total_vencidos,(t.dias_mora)as dias_mora\n" +
            "from lc_transacciones t,lc_clientes c where t.id_deudor= "+idDeudor+" and t.id_cliente=c.id_cliente ";
            
            String contenido = "";
            String razon_social, total_vencidos, dias_mora,id_asigna,estado;
            
            pst = conexion.getconexion().prepareStatement(SQL);
            rs = pst.executeQuery();
            int cont = 0;
            while( rs.next() )    //Mientras haya una sig. tupla
            {    
                razon_social= rs.getString("razon_social");
                total_vencidos = rs.getString("total_vencidos");
                dias_mora = rs.getString("dias_mora");
                //id_transaccion = rs.getString("id_transaccion");
                
                contenido = contenido + "<tr id=\"fila_"+cont+"\">\n"
                + "<td class=\"text-center \"><input id=\"cedente_"+cont+"\" style=\"display:none\" value=\'"+razon_social+"\'>" + razon_social + "</td>\n"        
                + "<td class=\"text-center \"><input id=\"total_"+cont+"\" style=\"display:none\" value=\'"+total_vencidos+"\'>" + total_vencidos + "</td>\n"
                + "<td class=\"text-center\"><input id=\"diamora_"+cont+"\" style=\"display:none\" value=\'"+dias_mora+"\'>" + dias_mora + "</td>\n"
                + "<td class=\"text-center\"><input id=\"abono_"+cont+"\" style=\"display:none\"></td>\n"
                + "<td class=\"text-center\"><a ><span  class=\"glyphicon glyphicon-eye-open\" aria-hidden=\"true\"></span></a></td></tr>";
             
               
            }
            
            //footer="<div class=\"col-lg-2\"><strong><input type=\"text\" value=\'"+suma+"\'></strong> </div></th> ";
            
            
                rs.close();
                pst.close();
                conexion.cierraConexion();
            valor = contenido;
                return valor;
            }catch(Exception ex){
            }finally{
                    if(conexion!=null)
                    conexion.cierraConexion();
                 }
        return valor;
    }          
}
