/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.servicios;

import com.laticobsa.modelo.HibernateUtil;
import com.laticobsa.modelo.LcDocumentos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CIMA2015
 */
public class DocumentosServicios {
     public List<LcDocumentos> getLcDocumentos(){
         
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx= session.beginTransaction();
        // hacemos la transaccion
        //ArrayList<LcDocumentos> arreglo = new ArrayList<LcEmpresa>();
        Query q = session.createQuery("from LcDocumentos");
        List<LcDocumentos> lista=q.list();
         for(LcDocumentos list:lista )
        {
             System.out.print("datos: "+list.getIdDocumento()+list.getNombreDocumento()+list.getIdCliente()+list.getFechaRegistro()+list.getFechaActualizado());
        }
        tx.commit();
        session.close();
        return lista;
    }
}
