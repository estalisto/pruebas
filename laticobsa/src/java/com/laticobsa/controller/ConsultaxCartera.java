/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcDatosDeudores;

import com.laticobsa.servicios.ConsultaxCarteraServicios;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.SucursalServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ViewSoft
 */
public class ConsultaxCartera extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
       EmpresaServicios es =new EmpresaServicios();
       SucursalServicios su = new SucursalServicios();
       ConsultaxCarteraServicios cd = new ConsultaxCarteraServicios();
       String accion;
       accion= request.getParameter("accion");
       String id_empresas,id_empleados,id_sucursal;    
       HttpSession sesion = request.getSession(true);
       id_empresas = sesion.getAttribute("Sstrempresa").toString();
       int EmpresaID= Integer.parseInt(id_empresas);
       id_empleados = sesion.getAttribute("Sstrempleado").toString();
       int EmpleadoID= Integer.parseInt(id_empleados);
       id_sucursal = sesion.getAttribute("Sstrsucursal").toString();
       int SucursalID= Integer.parseInt(id_sucursal);
         String SSqlDatosDeudor="";

       
       if(accion.equals("listar"))
        {            
           int idclienteok =cd.getIdCliente(EmpresaID, SucursalID, EmpleadoID);
           String Tabla="";
         
           int opcion=0;
           
            
           List<LcClientes> carteras = cd.getLcDatoscliente(EmpresaID, idclienteok);  
           request.setAttribute("carteras", carteras);
          // List<LcDatosDeudores> datas = cd.getLcDatos2(EmpresaID,SucursalID, EmpleadoID);
          // request.setAttribute("datas", datas);
            try {
                    String filtro1 = request.getParameter("orden_dia");
                    String filtro2 = request.getParameter("orden_valor");
                    String filtro3 = request.getParameter("orden_fecha");
                    if((filtro1==null)&&(filtro2==null)&&(filtro3==null)){
                Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, opcion);
               
                 request.setAttribute("Tablacartera", Tabla);
                  SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, opcion);
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                         request.getRequestDispatcher("sistema/gestion/frm_consulta_por_cartera.jsp").forward(request, response);
                    }
                   if(filtro1!=null){
                       int valorFiltro1 = Integer.parseInt(filtro1);
                        Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, valorFiltro1);
                       request.setAttribute("Tablacartera", Tabla);
                       SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, valorFiltro1);
                       sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                       response.getWriter().println(Tabla);
                   }
                    if(filtro2!=null){
                       int valorfiltro2 = Integer.parseInt(filtro2);
                       Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, valorfiltro2);
                        request.setAttribute("Tablacartera", Tabla);
                        SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, valorfiltro2);
                        sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor);
                        response.getWriter().println(Tabla);
                    }
                    if(filtro3!=null){
                       int valorfiltro3 = Integer.parseInt(filtro3); 
                        Tabla=cd.getDatosCarteras(idclienteok, EmpleadoID, valorfiltro3);
                        request.setAttribute("Tablacartera", Tabla);
                        SSqlDatosDeudor=cd.getRetornaQuery(idclienteok, EmpleadoID, valorfiltro3);
                        sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                        response.getWriter().println(Tabla);
                    }
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }


        if(accion.equals("listar_datos")){
        int cartera = Integer.parseInt(request.getParameter("cartera"));
            List<LcDatosDeudores> datas = cd.getLcDatos(EmpresaID, SucursalID, cartera,EmpleadoID);
            request.setAttribute("datas", datas);
            request.getRequestDispatcher("sistema/gestion/consulta_cartera.jsp").forward(request, response);
        }
        
        if(accion.equals("orden")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_dia"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                Tabla2=cd.getDatosCarteras(cartera, EmpleadoID, opcion);
                 SSqlDatosDeudor=cd.getRetornaQuery(cartera, EmpleadoID, opcion);
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(accion.equals("ordenDesc")){
            String Tabla3="";
            int opcion=Integer.parseInt(request.getParameter("opcion"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                Tabla3=cd.getDatosCarteras(cartera, EmpleadoID, opcion);
                 //request.setAttribute("Tablacartera3", Tabla3);
                 SSqlDatosDeudor=cd.getRetornaQuery(cartera, EmpleadoID, opcion);
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 response.getWriter().println(Tabla3);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(accion.equals("filtrosDiasMora")){
            String Tabla2="";
           
            
            int opcion=Integer.parseInt(request.getParameter("orden_dia"));
            int cartera = Integer.parseInt(request.getParameter("cartera"));
         try {
                
                 SSqlDatosDeudor=cd.getRetornaQuery2(cartera, EmpleadoID, opcion);                 
                 sesion.setAttribute("SSqlDatosDeudor",SSqlDatosDeudor); 
                 Tabla2=cd.getDatosCarteras2(SSqlDatosDeudor);
                 response.getWriter().println(Tabla2);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaxCartera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
