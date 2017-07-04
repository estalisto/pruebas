/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laticobsa.controller;

import com.laticobsa.modelo.LcAgencia;
import com.laticobsa.modelo.LcArticulo;
import com.laticobsa.modelo.LcCiudad;
import com.laticobsa.modelo.LcClientes;
import com.laticobsa.modelo.LcCompromisosPago;
import com.laticobsa.modelo.LcCuotas;
import com.laticobsa.modelo.LcDatosDeudores;
import com.laticobsa.modelo.LcDireccion;
import com.laticobsa.modelo.LcEmpleados;
import com.laticobsa.modelo.LcEmpresa;
import com.laticobsa.modelo.LcGestiones;
import com.laticobsa.modelo.LcNotas;
import com.laticobsa.modelo.LcRecordatorios;
import com.laticobsa.modelo.LcReferencias;
import com.laticobsa.modelo.LcTelefonos;
import com.laticobsa.modelo.LcTipoGestion;
import com.laticobsa.modelo.LcTipoPersona;
import com.laticobsa.modelo.LcTipoReferencia;
import com.laticobsa.modelo.LcTipoResultado;
import com.laticobsa.modelo.LcTiposDireccion;
import com.laticobsa.modelo.LcTiposTelefono;
import com.laticobsa.modelo.LcTransacciones;
import com.laticobsa.servicios.ConsultaxCarteraServicios;
import com.laticobsa.servicios.DireccionServicios;
import com.laticobsa.servicios.EmpresaServicios;
import com.laticobsa.servicios.ParametrosServicios;
import com.laticobsa.servicios.ReferenciasServicios;
import com.laticobsa.servicios.SucursalServicios;
import com.laticobsa.servicios.TelefonoServicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author ViewSoft
 */
public class CobranzaController extends HttpServlet {

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
        EmpresaServicios es = new EmpresaServicios();
        SucursalServicios su = new SucursalServicios();
        TelefonoServicios telf = new TelefonoServicios();
        DireccionServicios dir = new DireccionServicios();
        ReferenciasServicios ref = new ReferenciasServicios();
        ParametrosServicios param = new ParametrosServicios();
        ConsultaxCarteraServicios cd = new ConsultaxCarteraServicios();
        String accion;
        accion = request.getParameter("accion");
        String id_empresas, id_empleados, id_sucursal;
        HttpSession sesion = request.getSession(true);
        id_empresas = sesion.getAttribute("Sstrempresa").toString();
        int EmpresaID = Integer.parseInt(id_empresas);
        id_empleados = sesion.getAttribute("Sstrempleado").toString();
        int EmpleadoID = Integer.parseInt(id_empleados);
        id_sucursal = sesion.getAttribute("Sstrsucursal").toString();
        int SucursalID = Integer.parseInt(id_sucursal);
        String Identificacion=null;
        if(accion.equals("listar"))
        {
            
            request.getRequestDispatcher("sistema/gestion/frm_gestion_cobranzas.jsp").forward(request, response);
        }
        if(accion.equals("envio"))
        {
         int  idCliente=Integer.parseInt(request.getParameter("idCliente"));
         int  idDeudor=Integer.parseInt(request.getParameter("idDeudor"));  
         
         List<LcDatosDeudores> cobranzas = cd.getLcDeudorId(idCliente,idDeudor);
         request.setAttribute("cobranzas", cobranzas);
         List<LcTransacciones> transaccion = cd.getTransaccionesId(idCliente,idDeudor);
         request.setAttribute("transaccion", transaccion);
         int idcliente = cobranzas.get(0).getLcClientes().getIdCliente();
         List<LcTipoGestion> gestiones = cd.getLcTipoGestion(idcliente);
         request.setAttribute("gestiones", gestiones);
         String identifica= cd.getIdentificacionDeudor(idDeudor);// aqui
         
         List<LcDireccion> direcciones = cd.getLcDireccion(identifica);
         request.setAttribute("direcciones", direcciones);
         
         List<LcTelefonos> telefonos = cd.getLcTelefono(cd.getIdentificacionDeudor(idDeudor));
         request.setAttribute("telefonos", telefonos);
         
         List<LcCiudad> ciudades = cd.getLcCiudad();
         request.setAttribute("ciudades", ciudades);
         
         List<LcNotas> notas = cd.getLcNotas(idCliente,idDeudor);
         request.setAttribute("notas", notas);
         
         List<LcArticulo> detArticulos = cd.getArticulos(idCliente,idDeudor);
         request.setAttribute("detArticulos", detArticulos);
         
         List<LcCuotas> detCuotas = cd.getCuotas(idCliente,idDeudor);
         request.setAttribute("detCuotas", detCuotas);
           String TablaGestiones="";
            try {
                 TablaGestiones=cd.getGestiones(idCliente, idDeudor);
            } catch (SQLException ex) {
                Logger.getLogger(CobranzaController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         
         //List<LcGestiones> GestionTRX = cd.getGestionesTRX(idCliente,idDeudor);
         request.setAttribute("GestionTRX", TablaGestiones);
         
         
         
         request.getRequestDispatcher("sistema/gestion/frm_gestion_cobranzas.jsp").forward(request, response);
        }
        
        if(accion.equals("guardar"))
        {
            try{  
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
            int  id=Integer.parseInt(request.getParameter("id"));
            String  hora=request.getParameter("hora");
            String  compromiso_pago = request.getParameter("compromiso_pago");
            List<LcDatosDeudores> recordatorio = cd.getLcDeudorRecordatorio(id,EmpresaID,SucursalID,EmpleadoID);
         
            Date fecha_reg = new Date();
            String Fecha1=compromiso_pago+" "+hora+":00";
           Date  Fecha_final = formatter.parse(Fecha1);
                System.out.println(Fecha_final);
                LcDatosDeudores data = recordatorio.get(0);
                int id_empresa = data.getLcEmpresa().getIdEmpresa();
                int id_agencia = data.getLcAgencia().getIdAgencia();
                int id_deudor = data.getIdDatosDeudor();
                int id_cliente = data.getLcClientes().getIdCliente();
                int id_empleado = data.getIdEmpleado();

                int id_recordatorio = Integer.parseInt(cd.getNext().toString());
                
                cd.addRecordatorio(new LcRecordatorios(
                        id_recordatorio,
                        (new LcAgencia(id_agencia)),
                        (new LcClientes(id_cliente)),
                        (new LcDatosDeudores(id_deudor)),
                        (new LcEmpleados(id_empleado)),
                        (new LcEmpresa(id_empresa)),
                        Fecha_final,
                        "A",
                        fecha_reg,
                        fecha_reg,
                        "A"
                ));
                int id_transaccion = Integer.parseInt(cd.getNext2().toString());
                List<LcTipoGestion> gestion = cd.getLcTipoGestion(id_cliente);
                int id_gestion = gestion.get(0).getIdTipoGestion();
                List<LcTipoResultado> resultado = cd.getLcTipoResultado(id_gestion);
                int id_resultado = resultado.get(0).getIdTipoResultado();
                cd.addGestiones(new LcGestiones(
                        id_transaccion,
                        (new LcClientes(id_cliente)),
                        (new LcDatosDeudores(id_deudor)),
                        (new LcEmpleados(id_empleado)),
                        (new LcTipoGestion(id_gestion)),
                        (new LcTipoResultado(id_resultado)),
                        "RECORDATORIO DE LLAMADA Fecha:" + compromiso_pago + "Hora:" + hora,
                        fecha_reg,
                        "A"
                ));
                /*
                 this.idGestion = idGestion;
       this.lcClientes = lcClientes;
       this.lcDatosDeudores = lcDatosDeudores;
       this.lcEmpleados = lcEmpleados;
       this.lcTipoGestion = lcTipoGestion;
       this.lcTipoResultado = lcTipoResultado;
       this.observacion = observacion;
       this.fechaTransaccion = fechaTransaccion;
       this.estado = estado;
                */

                response.getWriter().println("Recordatorio y Gestión Guardada.");

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (accion.equals("notas")) {
                int idNota = Integer.parseInt(request.getParameter("idNota"));
                int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                Date fecha_reg = new Date();
                String txtnota = request.getParameter("txtnota");
                
                //List<LcNotas> note = cd.getLcNotasId(idNota, idDeudor,idCliente);
                  if (idNota == 0 ){
                    idNota=Integer.parseInt(cd.getNext3().toString()); 
                    cd.addNota(new LcNotas(
                        idNota,
                        idDeudor,
                        idCliente,
                        txtnota,
                        fecha_reg,
                        "A"
                ));
                }else{
                   
                    cd.updateNota(idNota, txtnota);
                }
               
                            response.getWriter().println(idNota);
        }

        
        if (accion.equals("transaccion")) {
            try{
                int id = Integer.parseInt(request.getParameter("id"));
                
                int id_gestion = Integer.parseInt(request.getParameter("gestion"));
                int id_resultado = Integer.parseInt(request.getParameter("resultado"));
                int id_cliente = Integer.parseInt(request.getParameter("cliente"));
                int id_Transaccion = Integer.parseInt(request.getParameter("idTransaccion"));
                int id_Gestion = Integer.parseInt(cd.getNext2().toString());
                String descripcion = request.getParameter("descripcion");
                
                Date fecha_reg = new Date();
                
                String estado="";
                try {
                    if(!param.getValorParametro("COMPROMISO_PAGO").isEmpty()){
                        
                        String valor_parametro = param.getValorParametro("COMPROMISO_PAGO");
                        String id_resultados = Integer.toString(id_resultado);
                        int resultado = valor_parametro.indexOf(id_resultados);
                        if(resultado != -1){
                            //NUEVO CAMBIO
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            
                            int idComPago=Integer.parseInt(cd.getNext4().toString());
                            String  comp_pago = request.getParameter("comp_pago");
                            Date  Fecha_final = formatter.parse(comp_pago);
                            String fecha_comp=formatter.format(Fecha_final);
                            String monto_compromiso = request.getParameter("monto_compromiso");
                            BigDecimal valor_compromiso = new BigDecimal(monto_compromiso);
                            BigDecimal valorComprometido = valor_compromiso;
                            
                            descripcion=descripcion+"  FECHA COMPROMISO DE PAGO: "+fecha_comp+" VALOR QUE SE COMPROMETE A CANCELAR: $"+valorComprometido;
                            //Guarda Compromiso Pago lc_compromiso_pago
                            cd.addCompPago(new LcCompromisosPago(
                                    idComPago,
                                    (new LcDatosDeudores (id)),
                                    id_cliente,
                                    Fecha_final,
                                    valorComprometido,
                                    null,
                                    fecha_reg,
                                    fecha_reg,
                                    "A"
                            ));
                            //Guarda Gestion lc_gestiones
                            cd.addGestiones(new LcGestiones(
                                    id_Gestion,
                                    (new LcClientes(id_cliente)),
                                    (new LcDatosDeudores(id)),
                                    (new LcEmpleados(EmpleadoID)),
                                    (new LcTipoGestion(id_gestion)),
                                    (new LcTipoResultado(id_resultado)),
                                    descripcion.toUpperCase(),
                                    fecha_reg,
                                    "A"
                            ));
                            //Actualiza estado lc_transaciones
                            estado="C";
                            cd.updateTransactionState(id_Transaccion,estado);
                            //NUEVO CAMBIO
                        }else{ //Guarda solo Gestion
                            cd.addGestiones(new LcGestiones(
                                    id_Gestion,
                                    (new LcClientes(id_cliente)),
                                    (new LcDatosDeudores(id)),
                                    (new LcEmpleados(EmpleadoID)),
                                    (new LcTipoGestion(id_gestion)),
                                    (new LcTipoResultado(id_resultado)),
                                    descripcion.toUpperCase(),
                                    fecha_reg,
                                    "A"
                            ));
                            estado="P";
                            cd.updateTransactionState(id_Transaccion,estado);
                    
                        }
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(CobranzaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.getWriter().println("Gestión Guardada Exitosamente.");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        if (accion.equals("listar_transaccion")) {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
           // List<LcGestiones> GestionTRX = cd.getGestionesTRX(idCliente, idDeudor);
            String TablaGestiones="";
            try {
                 TablaGestiones=cd.getGestiones(idCliente, idDeudor);
            } catch (SQLException ex) {
                Logger.getLogger(CobranzaController.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         
         //List<LcGestiones> GestionTRX = cd.getGestionesTRX(idCliente,idDeudor);
         request.setAttribute("GestionTRX", TablaGestiones);
            
            
          //  request.setAttribute("GestionTRX", GestionTRX);

            request.getRequestDispatcher("sistema/gestion/transacciones_pendientes.jsp").forward(request, response);
        }
        if (accion.equals("compromiso")) {
           try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
            int idComPago=Integer.parseInt(cd.getNext4().toString());
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));   
            String  comp_pago = request.getParameter("comp_pago");
            
            Date  Fecha_final = formatter.parse(comp_pago+" "+"00:00:00");
            Date fecha_reg = new Date();

               cd.addCompPago(new LcCompromisosPago(
                       idComPago,
                       (new LcDatosDeudores (idDeudor)),
                       idCliente,
                       Fecha_final,
                       null,
                       null,
                       fecha_reg,
                       fecha_reg,
                       "A"
               ));

             String fecha_comp=formatter.format(Fecha_final);

               int id_transaccion = Integer.parseInt(cd.getNext2().toString());
                List<LcTipoGestion> gestion = cd.getLcTipoGestion(idCliente);
                int id_gestion = gestion.get(0).getIdTipoGestion();
                List<LcTipoResultado> resultado = cd.getLcTipoResultado(id_gestion);
                int id_resultado = resultado.get(0).getIdTipoResultado();
                cd.addGestiones(new LcGestiones(
                        id_transaccion,
                        (new LcClientes(idCliente)),
                        (new LcDatosDeudores(idDeudor)),
                        (new LcEmpleados(EmpleadoID)),
                        (new LcTipoGestion(id_gestion)),
                        (new LcTipoResultado(id_resultado)),
                        "SE COMPROMETE A REALIZAR UN COMPROMISO DE PAGO LA FECHA: " + fecha_comp,
                        fecha_reg,
                        "A"
                ));

                response.getWriter().println("Compromiso Pago Guardado Exitosamente.");
            
            
           } catch (ParseException e) {
                e.printStackTrace();
            }}
        
        if(accion.equals("agraga_telef")){
            int ID_deudorTel = Integer.parseInt(request.getParameter("idDeudor"));
            int IDClienteTel = Integer.parseInt(request.getParameter("cliente"));
            int IdTipoTelf = Integer.parseInt(request.getParameter("tipoTelefono"));
            String NewTelef = request.getParameter("newTelefono");
            Date FechaHoyTel= new Date();
            int IdTelefonoDeudor =Integer.parseInt(telf.getNext().toString());
            telf.addTelefonos(new LcTelefonos(IdTelefonoDeudor,new LcTipoPersona(1),new LcTiposTelefono(IdTipoTelf),ID_deudorTel,cd.getIdentificacionDeudor(ID_deudorTel),NewTelef,0,FechaHoyTel,"A" ));
            response.getWriter().println("Teléfono Agregado Exitosamente.");
        }
        
        if(accion.equals("agraga_direccion")){
		int ID_deudorTel = Integer.parseInt(request.getParameter("idDeudor"));
		int IDClienteTel = Integer.parseInt(request.getParameter("cliente"));
		int IdTipoDir = Integer.parseInt(request.getParameter("tDireccion"));
		String NewDireccion = request.getParameter("direccion_new");
		 Date FechaHoyDireccion= new Date();
		 int IdDireccion =Integer.parseInt(dir.getNext().toString());
		 dir.addLcDireccion(new LcDireccion(IdDireccion,new LcTiposDireccion(IdTipoDir),cd.getIdentificacionDeudor(ID_deudorTel),NewDireccion,FechaHoyDireccion,"A"  ) );
		  response.getWriter().println("Dirección Agregada Exitosamente.");
        }
        if (accion.equals("listar_direccion")) {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
            String identifica= cd.getIdentificacionDeudor(idDeudor);

            List<LcDireccion> direcciones = cd.getLcDireccion(identifica);
            request.setAttribute("direcciones", direcciones);

            request.getRequestDispatcher("sistema/gestion/table_direccion.jsp").forward(request, response);
        }
        if (accion.equals("listar_telefono")) {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
            
            List<LcTelefonos> telefonos = cd.getLcTelefono(cd.getIdentificacionDeudor(idDeudor));
            request.setAttribute("telefonos", telefonos);

            request.getRequestDispatcher("sistema/gestion/table_telefono.jsp").forward(request, response);
        }
         if(accion.equals("deudor")){
            try {
                int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                int opcion=2;
                 String sqlquery="";   
                  List<String> sgte;
                 sqlquery = sesion.getAttribute("SSqlDatosDeudor").toString();
                 if (sqlquery.isEmpty()){
                      List<String> sgte1= cd.getDatosCarterasSiguienteAnterior(idCliente,EmpleadoID, opcion);
                      sgte=sgte1;
                 }else{
                         List<String> sgte2= cd.getEjecutaQueryDatosDeudor(sqlquery);
                          sgte=sgte2;
                 }
                 
                 
               
// List<LcDatosDeudores> sgte = cd.getLcDatossgte(EmpresaID,idCliente, EmpleadoID);
                if (!sgte.isEmpty()){
                    if(sgte.size()>0){
                        for(int i=0; i< sgte.size(); i++) {
                            String otro= sgte.get(i);
                            int id = Integer.parseInt(otro);
                            if(id == idDeudor){
                                
                                if((i+1) > sgte.size()){
                                    response.getWriter().println(0);
                                    break;
                                }else{
                                    otro=sgte.get(i+1);
                                    id = Integer.parseInt(otro);
                                    response.getWriter().println(id);
                                    break;
                                    
                                    
                                }}
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CobranzaController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        if(accion.equals("anterior")){
            try {
                int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                int opcion=2;
               // List<String> sgte= cd.getDatosCarterasSiguienteAnterior(idCliente,EmpleadoID, opcion);
                 List<String> sgte;
                  String sqlquery="";   
                 sqlquery = sesion.getAttribute("SSqlDatosDeudor").toString();
                 if (sqlquery.isEmpty()){
                      List<String> sgte1= cd.getDatosCarterasSiguienteAnterior(idCliente,EmpleadoID, opcion);
                      sgte=sgte1;
                 }else{
                         List<String> sgte2= cd.getEjecutaQueryDatosDeudor(sqlquery);
                          sgte=sgte2;
                 }
                //List<LcDatosDeudores> sgte = cd.getLcDatossgte(EmpresaID,idCliente, EmpleadoID);
                
                    if (!sgte.isEmpty()){
                    if (sgte.size() > 0) {
                        for (int i = 0; i < sgte.size(); i++) {
                            String otro = sgte.get(i);
                            int id = Integer.parseInt(otro);
                            if (id == idDeudor) {
                                if((i-1) < 0){
                                    response.getWriter().println(0);
                                    break;
                                }else{
                                    otro=sgte.get(i-1);
                                    id = Integer.parseInt(otro);
                                    response.getWriter().println(id);
                                    break;
                                    
                                    
                                }
                                
                                
                                
                            }
                        }
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(CobranzaController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
        if(accion.equals("addReferncia")){
             int idDeudor = Integer.parseInt(request.getParameter("idDeudor"));
             String nombreReferencia=request.getParameter("nombre_ref");
             int TipoReferencia = Integer.parseInt(request.getParameter("TipoRef"));
             int ciudad= 1;
              int IDReferencia=Integer.parseInt(ref.getNext().toString()); 
              Date FechaHoy=new Date();
             
             ref.addReferencias(new LcReferencias(IDReferencia,
                     (new LcCiudad(ciudad)),(new LcTipoReferencia(TipoReferencia)),
                     idDeudor,
                     nombreReferencia.toUpperCase(),
                     null,
                     null,
                     FechaHoy,
                     "A"));
             
            /*  List<LcReferencias> datosref= ref.getDatosLcReferencias(idDeudor);  
              JSONObject obj = new JSONObject();
                 //JSONArray list = new JSONArray();
           for (LcReferencias referencias : datosref) {
                obj.put("tipo_referido", referencias.getLcTipoReferencia().getDescripcion());
                obj.put("nombre", referencias.getNombreReferencia() );
                
           }
             
             System.out.println("Json");
              System.out.println(obj);*/
    
             response.getWriter().println(IDReferencia);
            
        }
        
        if(accion.equals("agraga_telef_ref")){
            String Persona=request.getParameter("idReferencia");
            Persona=Persona.replaceAll("\n", "");
            Persona=Persona.replaceAll("\r", "");
            
            String newTelefono=request.getParameter("newTelefono");
            int TipoTelefono = Integer.parseInt(request.getParameter("tipoTelefono"));           
            Date FechaHoy=new Date();
            int IdTelefono =Integer.parseInt(telf.getNext().toString());
            int IdPersona =Integer.parseInt(Persona);

            
            telf.addTelefonos(new LcTelefonos(IdTelefono,
                      new LcTipoPersona(2), //Tipo -> 2 Persona Referencia 
                      new LcTiposTelefono(TipoTelefono),
                      IdPersona,
                      "0000000000",newTelefono,0,FechaHoy,"A" ));

             response.getWriter().println("ok");

        }
         if(accion.equals("tablaReferencia")){
            int idDeudor = Integer.parseInt(request.getParameter("idDeudor")); 
            //int idcliente = Integer.parseInt(request.getParameter("idcliente")); 
            List<LcReferencias> datosref= ref.getDatosLcReferencias(idDeudor);
           // List<LcReferencias> telefon= ref.getDatosLcReferencias(idDeudor,idDeudor);
            
            String TablaReferencias ="  <table id='detalle_articulos' class='table table-bordered table-striped'>"
                                    + "     <thead>"
                                    + "         <tr>"
                                    + "             <th>Tipo Ref.</th> "
                                    + "             <th>Nombre</th> "
                                    + "             <th>Telefonos</th>   "
                                    + "             <th>Dirección</th> "
                                    + "         </tr> "
                                    + "     </thead> "
                                    + "     <tbody>";

          
        
            int tipoPersona=2;
            for (LcReferencias referencias : datosref) {
                
                try {
                    TablaReferencias +="<tr>"
                            + "<td>"+referencias.getLcTipoReferencia().getDescripcion()+"</td>"
                            + "<td>"+referencias.getNombreReferencia()+"</td>"
                            + "<td>"
                            + "     <table>"
                            + "         <tr><td><a>"+  telf.getTelefonoReferencia2(referencias.getIdReferencia(), tipoPersona)+"</a></td></tr>"
                            + "     </table>"
                            + "</td>"
                            + "<td></td>"
                            + "</tr>";
                } catch (SQLException ex) {
                    Logger.getLogger(CobranzaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
           TablaReferencias +="</tbody></table>";
           
           response.getWriter().println(TablaReferencias);
         }
        
    }
    public  String cadenaTabla(int deudor){
    ReferenciasServicios ref2 = new ReferenciasServicios();
         int idDeudor = deudor; 
            
            String TablaReferencias ="  <table id='detalle_articulos' class='table table-bordered table-hover'>"
                                    + "     <thead>"
                                    + "         <tr>"
                                    + "             <th>Tipo Ref.</th> "
                                    + "             <th>Nombre</th> "
                                    + "             <th>Telefonos</th>   "
                                    + "             <th>Dirección</th> "
                                    + "         </tr> "
                                    + "     </thead> "
                                    + "     <tbody>";

          
        
 List<LcReferencias> datosref= ref2.getDatosLcReferencias(idDeudor);
            for (LcReferencias referencias : datosref) {
                TablaReferencias +="<tr>"
                        + "<td>"+referencias.getLcTipoReferencia().getDescripcion()+"</td>"
                        + "<td>"+referencias.getNombreReferencia()+"</td>"
                        + "<td>"
                        + "     <table>"
                        + "         <tr>"
                        + "             <td><a>0922676945</a></td>"
                        + "             </tr><tr><td><a>0922676946</a></td>"
                        + "         </tr>"
                        + "     </table>"
                        + "</td>"
                        + "<td></td>"
                        + "</tr>";
            }
            
            
          // TablaReferencias +="<tr><td></td><td></td><td><table><tr><td><a>0922676945</a></td></tr><tr><td><a>0922676946</a></td></tr><tr><td><a>0922676947</a></td></tr></table></td><td></td></tr>";
           TablaReferencias +="</tbody></table>";
        
        
        return TablaReferencias;
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
