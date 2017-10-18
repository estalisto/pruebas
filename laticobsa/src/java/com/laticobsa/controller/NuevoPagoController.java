/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcCuotas;
import com.laticobsa.modelo.LcDatosDeudores;
import com.laticobsa.modelo.LcDetRecaudaciones;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcFormapagoRecaudacion;
import com.laticobsa.modelo.LcInstitucion;
import com.laticobsa.modelo.LcRecaudaciones;
import com.laticobsa.modelo.LcTipoFormaPago;
import com.laticobsa.modelo.LcTiposIdentificacion;
import com.laticobsa.servicios.ClientesServicios;
import com.laticobsa.servicios.ConsultaxCarteraServicios;
import com.laticobsa.servicios.EmpleadosServicios;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.NuevoPagoServicios;
import com.laticobsa.servicios.RecaudacionServicios;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CIMA2015
 */
public class NuevoPagoController extends HttpServlet {

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
        String accion;
        accion = request.getParameter("accion");
        HttpSession sesion = request.getSession(true);
        NuevoPagoServicios rst = new NuevoPagoServicios();
        RecaudacionServicios rs = new RecaudacionServicios();
        EmpresaServicios es = new EmpresaServicios();
        EmpleadosServicios emp = new EmpleadosServicios();
        ClientesServicios cl = new ClientesServicios();
        ConsultaxCarteraServicios cd = new ConsultaxCarteraServicios();
        String id_empresas;
        id_empresas = sesion.getAttribute("Sstrempresa").toString();
        int EmpresaID = Integer.parseInt(id_empresas);
        String id_empleados;
        id_empleados = sesion.getAttribute("Sstrempleado").toString();
        int EmpleadoID = Integer.parseInt(id_empleados);
        if (accion.equals("agregar")) {
            request.getRequestDispatcher("sistema/caja/NuevoPago.jsp").forward(request, response);
        }
        if (accion.equals("eliminar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            rst.deleteCabecera(id);
            List<LcDetRecaudaciones> ListRecaudacion = rst.getDEtalle(id);
            if (!ListRecaudacion.isEmpty()) {
                for (int i = 0; i < ListRecaudacion.size(); i++) {
                    int idDEtalle = ListRecaudacion.get(i).getIdDetRecaudacion();
                    rst.deletePago(idDEtalle);
                }
            }
            List<LcFormapagoRecaudacion> ListPago = rst.getFormPago(id);
            if (!ListPago.isEmpty()) {
                for (int j = 0; j < ListPago.size(); j++) {
                    int idForma = ListPago.get(j).getIdFormpago();
                    rst.deleteFormaPago(idForma);
                }
            }
        }
        if (accion.equals("cuotatable")) {
            int idRecaudacion = Integer.parseInt(request.getParameter("idRecaudacion"));
            int cont = Integer.parseInt(request.getParameter("cont"));
            String resp = "";
            List<LcDetRecaudaciones> dataIDCuotas = rst.getDEtalleid(idRecaudacion);
            resp += "<tbody>";
            
            for (int i = 0; i < dataIDCuotas.size(); i++) {
                resp += "<tr id=\"fila_" + cont + "\">";
                int idDetalle = dataIDCuotas.get(i).getIdDetRecaudacion() ;
                resp += "<input id=\"idDetalle\" style=\"display:none\" value=\'" +idDetalle+ "'\" type=\"text\">";
                resp += "<td class=\"hidden\"><input id=\"idarticulo" + "_" + cont + "\"  type=\"text\"  value='" + dataIDCuotas.get(i).getIdArticulo() + "'>" + dataIDCuotas.get(i).getIdArticulo();
                resp += "<td  value='" + dataIDCuotas.get(i).getIdArticulo() + "'>" + dataIDCuotas.get(i).getIdArticulo();
                resp += "<td value='" + dataIDCuotas.get(i).getValorCuota() + "'><input id=\"valorcuota" + "_" + cont + "\" class=\"hidden\"  type=\"text\"  value='" + dataIDCuotas.get(i).getValorCuota() + "'>" + dataIDCuotas.get(i).getValorCuota();
                resp += "<td value='" + dataIDCuotas.get(i).getInteres() + "'><input id=\"interes" + "_" + cont + "\" class=\"hidden\"  type=\"text\"  value='" + dataIDCuotas.get(i).getInteres() + "'>" + dataIDCuotas.get(i).getInteres();
                resp += "<td value='" + dataIDCuotas.get(i).getMora() + "'><input id=\"valormora" + "_" + cont + "\" class=\"hidden\"  type=\"text\"  value='" + dataIDCuotas.get(i).getMora() + "'>" + dataIDCuotas.get(i).getMora();
                BigDecimal interes = dataIDCuotas.get(i).getInteres();
                BigDecimal valorCuota = dataIDCuotas.get(i).getValorCuota();
                BigDecimal Mora= dataIDCuotas.get(i).getMora();
                BigDecimal sum_total = ((valorCuota.add(interes)).add(Mora));
                resp += "<td value='" + sum_total + "'>" + sum_total;

                resp += "<td><input id=\"valor_pagar" + "_" + cont + "\" onkeypress=\"ValidaSoloNumeros()\" onkeyup=\"Actualizar_saldo2(" + sum_total + "," + cont + ")\"  name=\"valor\"  type=\"text\" value=\'" + dataIDCuotas.get(i).getValorRecaudado() + "\'>";

                resp += "<td> <input style=\"color:#00a65a\" id=\"saldo" + "_" + cont + "\"  type=\"text\"  value='" + dataIDCuotas.get(i).getSaldo() + "'>";

                resp += "<td><a> <span onclick=\"EliminaFila2(" + cont +","+idDetalle+")\" class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span></a></td>";
                resp += "</tr>";

                cont++;
                resp += "</tbody>";
                BigDecimal totalpagar = (dataIDCuotas.get(i).getValorRecaudado()).add(dataIDCuotas.get(i).getValorRecaudado());
                resp += "<input id=\"valorpagar\" style=\"display:none\" value=\'" + totalpagar + "'\" type=\"text\">";
                
            }
                resp += "<input id=\"conter\" style=\"display:none\" value=\'" + cont + "'\" type=\"text\">";
            response.getWriter().println(resp);
        }
            /* TODO output your page here. You may use following sample code. */
//
//            }
//
//        }
        if (accion.equals("contador")) {
            int idRecaudacion = Integer.parseInt(request.getParameter("idRecaudacion"));
            List<LcDetRecaudaciones> contador = rst.getDEtalleid(idRecaudacion);
            int tamanio = contador.size();

            response.getWriter().println(tamanio);
        }
        if (accion.equals("tipopago")) {
            int idRecaudacion = Integer.parseInt(request.getParameter("idRecaudacion"));
            List<LcFormapagoRecaudacion> formapago = rst.getFormPago(idRecaudacion);
            if(!formapago.isEmpty()){
                 
                 for (int i = 0; i < formapago.size(); i++) {
                     int tipopago = formapago.get(i).getLcTipoFormaPago().getIdTipoFp();
                     if(tipopago == 1){
                         String resp="";
                         BigDecimal valor_efectivo = formapago.get(i).getTotalRecaudado();
                         response.getWriter().println(1+"|"+valor_efectivo+"%");
                     }
                     if(tipopago == 2){
                         BigDecimal valor_tarjeta = formapago.get(i).getTotalRecaudado();
                         int entidad = formapago.get(i).getIdEntidadFinanciera();
                         String num_tarj = formapago.get(i).getNumTarjetaCred();
                         response.getWriter().println(2+"|"+valor_tarjeta+"|"+entidad+"|"+num_tarj+"%");
                     }
                     
                     if(tipopago == 3){
                         BigDecimal valor_cheque = formapago.get(i).getTotalRecaudado();
                         int entidad2 = formapago.get(i).getIdEntidadFinanciera();
                         String num_cheque = formapago.get(i).getNumCheque();
                         response.getWriter().println(3+"|"+valor_cheque+"|"+entidad2+"|"+num_cheque+"%");
                     }
                     
                 }
            }
        }
        if (accion.equals("Actcabecera")) {
            int idRecaudacion = Integer.parseInt(request.getParameter("idRecaudacion"));
            Date fecha_reg = new Date();
            String totalpago = request.getParameter("valor_pagar");
            BigDecimal total_pago = new BigDecimal(totalpago);
            
            rst.updateCabecera(idRecaudacion, total_pago,fecha_reg);
            response.getWriter().println(1);
        }
        if (accion.equals("Actdetalle")) {
            int idRecaudacion = Integer.parseInt(request.getParameter("idRecaudacion"));
//            int idArticulo = Integer.parseInt(request.getParameter("idArticulo"));
//            int numCuota = Integer.parseInt(request.getParameter("idCuota"));
//            String ValorCuota = request.getParameter("valCuota");
//            BigDecimal Valor_cuota = new BigDecimal(ValorCuota);
            String ValorPagar = request.getParameter("valor_pagar");
            BigDecimal Valor_Pagar = new BigDecimal(ValorPagar);
//            String interes = request.getParameter("interes");
//            BigDecimal Interes = new BigDecimal(interes);
//            String mora = request.getParameter("mora");
//            BigDecimal Mora = new BigDecimal(mora);
            String saldo = request.getParameter("saldo");
            BigDecimal Saldo = new BigDecimal(saldo);
            Date fecha_act = new Date();
            List<LcDetRecaudaciones> detRecaudacion = rst.getDEtalle(idRecaudacion);
            for (int i = 0; i < detRecaudacion.size(); i++) {
            int idDetRecaudacion = detRecaudacion.get(i).getIdDetRecaudacion();
            rst.updateDetalle(idDetRecaudacion,Valor_Pagar,Saldo,fecha_act);//idArticulo,numCuota,Valor_cuota,Interes,Mora,
            }
        }
        if (accion.equals("eliminafila")) {
            int idDetalle = Integer.parseInt(request.getParameter("idDetalle"));
            //List<LcDetRecaudaciones> dataIDCuotas = rst.getDEtalleide(idDetalle);
            rst.updateDEtallEstado(idDetalle);
            response.getWriter().println("Eliminar");
        }
        if (accion.equals("Actipago")) {
            int idRecaudacion = Integer.parseInt(request.getParameter("idRecaudacion"));
            List<LcFormapagoRecaudacion> FPRecaudacion = rst.getFormPago(idRecaudacion);
            String valor_efectivo = request.getParameter("valor_efectivo");
            BigDecimal ValorEfectivo = new BigDecimal(valor_efectivo);
            String valor_tarjeta = request.getParameter("valor_tarjeta");
            BigDecimal ValorTarjeta = new BigDecimal(valor_tarjeta);
            int inst_tarjeta = Integer.parseInt(request.getParameter("inst_tarjeta"));
            String num_tarjeta = request.getParameter("num_tarjeta");
            String valor_cheque = request.getParameter("valor_cheque");
            BigDecimal ValorCheque = new BigDecimal(valor_cheque);
            int inst_cheque = Integer.parseInt(request.getParameter("inst_cheque"));
            String num_cheque = request.getParameter("num_cheque");
            int pago_efectivo = 1, pago_tarjeta = 2,pago_cheque = 3;
            
            Date fecha_act = new Date();
            int id_FormPagrecaudacion = Integer.parseInt(rs.getNext3().toString());
            
            //Actualiza datos solo de efectivo
             if ((inst_tarjeta == 0)&&(inst_cheque == 0)) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                    
                }
             }
            //Actualiza todos
             if ((inst_tarjeta != 0)&&(inst_cheque != 0)&&(!valor_efectivo.equals("0"))) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                }
             }
            //Actualiza datos solo de tarjeta
             if ((valor_efectivo.equals("0"))&&(inst_cheque == 0)) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                }
             } 
             
            //Actualiza datos solo de cheque
             if ((valor_efectivo.equals("0"))&&(inst_tarjeta == 0)) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    
                    if(!valor_cheque.equals("0")){
                         rst.updateTipoPagoEstado(idPago);
                          rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
                                (new LcRecaudaciones(idRecaudacion)),
                                (new LcTipoFormaPago(3)),
                                ValorTarjeta,
                                inst_cheque,
                                num_cheque,
                                null,
                                fecha_act,
                                fecha_act,
                                fecha_act, "A"));
                    
                    }else{
                        rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                    }
                }
             } 
            //Actualiza datos de efectivo y tarjeta
            if ((inst_cheque == 0)) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    if((!valor_cheque.equals("0"))&&(!valor_tarjeta.equals("0"))){
                    rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                    }
                    if(TipoPago == 1){
                          rst.updateTipoPagoEstado(idPago);
                          rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
                                (new LcRecaudaciones(idRecaudacion)),
                                (new LcTipoFormaPago(2)),
                                ValorTarjeta,
                                inst_tarjeta,
                                null,
                                num_tarjeta,
                                fecha_act,
                                fecha_act,
                                fecha_act, "A"));
                      }
                      if(TipoPago == 2){
                          rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                      }
                      if(!(valor_efectivo.equals("0"))){
                          rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
                                (new LcRecaudaciones(idRecaudacion)),
                                (new LcTipoFormaPago(1)),
                                ValorEfectivo,
                                0,
                                null,
                                null,
                                fecha_act,
                                fecha_act,
                                fecha_act, "A"));
                      }
                }
            }
            //Actualiza datos de tarjeta y cheque
            if (valor_efectivo.equals("0")) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    if((!valor_cheque.equals("0"))&&(!valor_tarjeta.equals("0"))){
                    rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                    }
//                    if(valor_tarjeta.equals("0")){
                      if(TipoPago == 1){
                          rst.updateTipoPagoEstado(idPago);
                          rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
                                (new LcRecaudaciones(idRecaudacion)),
                                (new LcTipoFormaPago(3)),
                                ValorCheque,
                                inst_cheque,
                                null,
                                num_cheque,
                                fecha_act,
                                fecha_act,
                                fecha_act, "A"));
                      }
                      if(TipoPago == 2){
                          rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                      }
                      
                    //}
//                    if(valor_cheque.equals("0")){
//                        rst.updateTipoPagoEstado(idPago);
//                      rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
//                                (new LcRecaudaciones(idRecaudacion)),
//                                (new LcTipoFormaPago(1)),
//                                ValorEfectivo,
//                                0,
//                                null,
//                                null,
//                                fecha_act,
//                                fecha_act,
//                                fecha_act, "A"));
//                    }
                    
                    
                }
            }
            //Actualiza datos de efectivo y cheque
            if ((inst_tarjeta == 0)) {
                for (int i = 0; i < FPRecaudacion.size(); i++) {
                    int idPago = FPRecaudacion.get(i).getIdFormpago();
                    int TipoPago = FPRecaudacion.get(i).getLcTipoFormaPago().getIdTipoFp();
                    if((!valor_cheque.equals("0"))&&(!valor_tarjeta.equals("0"))){
                    rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                    }
                    if(valor_tarjeta.equals("0")){
                      if(TipoPago == 2){
                          rst.updateTipoPagoEstado(idPago);
                          rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
                                (new LcRecaudaciones(idRecaudacion)),
                                (new LcTipoFormaPago(1)),
                                ValorEfectivo,
                                0,
                                null,
                                null,
                                fecha_act,
                                fecha_act,
                                fecha_act, "A"));
                      }
                      if(TipoPago == 3){
                          rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                      }
                      if(!valor_efectivo.equals("0")){
                          rst.updateTipoPago(idPago, TipoPago, ValorEfectivo, ValorTarjeta, inst_tarjeta, num_tarjeta, ValorCheque, inst_cheque, num_cheque, fecha_act);
                          rst.addFormaPago(new LcFormapagoRecaudacion(id_FormPagrecaudacion,
                                (new LcRecaudaciones(idRecaudacion)),
                                (new LcTipoFormaPago(3)),
                                ValorCheque,
                                inst_cheque,
                                num_cheque,
                                null,
                                fecha_act,
                                fecha_act,
                                fecha_act, "A"));
                      }
                      if(!valor_tarjeta.equals("0")){}
                    }
                }
                //Actualiza datos solo de efectivo
               
//               
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
