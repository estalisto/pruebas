<%-- 
    Document   : frm_gestion_cobranzas.jsp
    Created on : 12/04/2017, 11:51:39
    Author     : Stalyn Granda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <link href="dist/css/bootstrap-datepicker.css" rel="stylesheet" /> 
             <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    </head>
    <body>
        <style>
input:enabled {
background-color:#FDF9DB;
border: 2px solid #CB8B07;
}
select:enabled {
background-color:#FDF9DB;
border: 2px solid #CB8B07;
}
</style>


        <div>      

            <div> 


                <div class="panel panel-default well margin">

                    <c:forEach items="${cobranzas}" var="cobro">
                        <div class="row">
                            <div class="col-lg-4">
                                <form class="form-horizontal">
                                    <div class="col-xs-3 hidden">
                                        <div class="form-group">
                                            <label>Código:</label>
                                            <input type="text" class="form-control" id="id" name="id" value="<c:out value="${cobro.getIdDatosDeudor()}"/>" required="required">
                                        </div> 
                                    </div>
                                    <div class="col-xs-3 hidden">
                                        <div class="form-group">
                                            <label>Cliente:</label>
                                            <input type="text" class="form-control" id="idcliente" name="idcliente" value="<c:out value="${cobro.getLcClientes().getIdCliente()}"/>" required="required">
                                            
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">C.I/RUC:</label>   
                                        <input class="col-sm-6 input-sm" type="text" placeholder="Número de identificación" required="required" name="identificacion" value="<c:out value='${cobro.getIdentificacion()}'/>" id="identificacion" readonly>                                    
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Cuenta:</label>   
                                        <input class="col-sm-6 input-sm" type="text" placeholder="Número de cuenta" required="required" name="cuenta" id="cuenta" value="<c:out value='${cobro.getNumCuenta()}'/>" readonly>                   
                                    </div>
                                </form>
                            </div>

                            <div class="col-lg-6">
                                <strong>  <center><h2 id="deudor"> <c:out value='${cobro.getNombres()} ${cobro.getApellidos()}'/></h2></center></strong>
                                <center><h4 id="cliente" style="color: #0063dc"><b><c:out value='${cobro.getLcClientes().getRazonSocial()}'/></b></h4></center>   
                            </div>

                            <div class="col-lg-2"> 
                                <button id="anterior" type="button" onclick="Antdeudor(${cobro.getIdDatosDeudor()},${cobro.getLcClientes().getIdCliente()})" class="btn btn-primary btn-lg glyphicon glyphicon-arrow-left"></button>
                                <button id="siguiente" type="button" onclick="Sgtedeudor(${cobro.getIdDatosDeudor()},${cobro.getLcClientes().getIdCliente()})" class="btn btn-primary btn-lg glyphicon glyphicon-arrow-right"> </button>

                            </div>  
                        </div>
                        <c:forEach items="${transaccion}" var="transa">        
                        <div class="row">
                            
                            
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label">Total:</label> 
                                    <label class="col-sm-1 control-label" style="color: #FF3A2D"><u>$ <c:out value='${transa.getMontoAsignado()}'/></u></label>

                                    <label class="col-sm-1 control-label">Último Pago:</label>
                                    <label class="col-sm-1 control-label" style="color: #FF3A2D"><u>$ <c:out value='${transa.getUltimoPago()}'/></u></label>
                                    <label class="col-sm-1 control-label">Pagos:</label> 
                                    <label class="col-sm-1 control-label" style="color: #FF3A2D"><u><c:out value='${transa.getNumeroPagos()}'/></u></label>
                                    <label class="col-sm-1 control-label">Días Mora:</label>  
                                    <label class="col-sm-1 control-label" style="color: #FF3A2D"><u><c:out value='${transa.getDiasMora()} '/> Dias</u></label>
                                    <label class="col-sm-1 control-label">Vencidos:</label>  
                                    <label class="col-sm-1 control-label" style="color: #FF3A2D"><u><c:out value='${transa.getDiasVencidos()} '/>Dias</u></label>
                                    <label class="col-sm-1 control-label">Saldo Vencido:</label>    
                                    <label class="col-sm-1 control-label" style="color: #FF3A2D"><u>$ <c:out value='${transa.getTotalVencidos()}'/></u></label>

                                </div>   
                            </form>
                        </div>                  
                        </c:forEach>            
                        <div class="row">   
                            <div id="pagedireccion">  
                            <div class="col-lg-4">
                                <div id="table_direccion" class="form-group">                                
                                    <dt>Dirección: </dt>
                                    <div  class="box table-responsive">
                                        <table id="idAllDireccions" class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Tipo</th>
                                                    <th>Dirección</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${direcciones}" var="direccion">           
                                                    <tr>
                                                        <td><c:out value="${direccion.getLcTiposDireccion().getNombreTipoDireccion()}" /> </td>
                                                        <td><c:out value="${direccion.getDireccionCompleta()}" /> </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>                                       
                                </div>  
                            </div>
                            </div>
                            <div id="pagetelefono">  
                            <div id="table_telefono" class="col-lg-3">        
                                <dt>Telefonos: </dt>
                                <div  class="box table-responsive">  
                                    <table id="idAllTelefonos" class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Tipo</th>
                                                <th>Télefonos</th>
                                                <th>Llamar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${telefonos}" var="phone">               
                                                <tr>
                                                    <td><c:out value="${phone.getLcTiposTelefono().getNombreTipoTlf()}" /></td>                    
                                                    <td><c:out value="${phone.getTelefono()}" /></td>
                                                    <td><a  href="#" ><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span></a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            </div>    
                            <div class="col-lg-3">
                                <div class="form-group">                                 
                                    <dt>Ciudad: </dt>
                                    <select class="input-sm form-control" name="Ciudad" required="required" disabled="true">
                                        <option value="<c:out value="${cobro.getLcCiudad().getIdCiudad()}"/>"><c:out value="${cobro.getLcCiudad().getCiudad()}"/></option>
                                        <c:forEach items="${ciudades}" var="ciudad">
                                            <option value="<c:out value="${ciudad.getIdCiudad()}" />" ><c:out value="${ciudad.getCiudad()}" /></option>
                                        </c:forEach>    
                                    </select>
                                    <label>Recordatorio  Fecha  y  Hora: </label>     
                                    <form class="form-inline">
                                        <div class="input-group date">
                                            <div class="input-sm input-group-addon">
                                                <i class="fa fa-calendar"></i>                   
                                            </div>
                                            <input type="text" class=" input-sm datepicker form-control" data-date-format="yyyy-mm-dd" id="datepicker2" onkeyup="verificaFecha();" name="compromiso_pago" placeholder="YYYY-MM-DD"> 
                                        </div> 
                                        <input type="time" class="form-control" id="hora" name="hora" placeholder="23:59" onkeyup="validaHora();">

                                        <button id="grabar_recordatorio" type="button" class="btn btn-primary btn-sm glyphicon glyphicon-plus" onclick="GuardarRecordatorio()" ></button> <span id="MsgValFecha"></span><span id="MsgValHora"></span>
                                    </form>     



                                    <dt>NOTAS</dt>
                                    <!--button id="grabar" type="button" class="btn btn-primary btn-sm glyphicon glyphicon-plus hidden" ></button-->
                                    <c:if test="${!empty(notas)}">
                                   
                                        <c:forEach items="${notas}" var="nota">
                                            <input id="idNotas" type="text" class="form-control hidden" placeholder="Dirección Trabajo" name="act_trabajo" value="<c:out value="${nota.getIdNota()}" />" >
                                                                                                                                                
                                            <textarea id="txtnota" class="form-control input-sm" rows="2" onkeyup="ValidarNota2()"  placeholder="Actualización de Datos" style="overflow-y:scroll; background-color:#FDF9DB;" value="<c:out value="${nota.getIdNota()}"/>"><c:out value="${nota.getObservacion()}"/></textarea>
                                        </c:forEach> 
                                    </c:if>
                                      <c:if test="${empty(notas)}">
                                          <input id="idNotas" type="text" class="form-control hidden" placeholder="Dirección Trabajo" name="act_trabajo" value="0" />

                                                           
                                        <textarea id="txtnota" class="form-control input-sm" rows="2" onkeyup="ValidarNota2()"  placeholder="Actualización de Datos" style="overflow-y:scroll;background-color:#FDF9DB;" ></textarea>
                                        
                                    </c:if>
                                   
                                    </div>         
                            </div>


                            <div class="col-lg-2">
                                <div class="btn-group-vertical">  
                                    <a href="#referencia" onclick="listo();" id="listoModal" data-toggle="modal" class="btn btn-primary">Referencia</a>
                                    <!--<a href="#agrega_datos"  data-toggle="modal" class="btn btn-primary">Agregar Datos</a>-->
                                    <a onclick="AddDirModal();" class="btn btn-primary">Agregar Dirección</a>
                                    <a onclick="AddTelModal();" class="btn btn-primary">Agregar Teléfono</a>
                                    
                                    <a href="#det_articulo"  data-toggle="modal" class="btn btn-primary">Detalles Artículo</a>
                                    <a href="#det_cuotas"  data-toggle="modal" class="btn btn-primary">Detalles Cuotas</a>
                                    <div id="modalADDTel"></div>
                                     <div id="modalDireccion"></div>
                                    <div id="agrega_datos" class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                        <div class="modal-dialog" role="document">
                                          <div class="modal-content">
                                            <div class="modal-header">
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                              <h4 class="modal-title" id="exampleModalLabel">Agregar Datos:  <c:out value='${cobro.getNombres()} ${cobro.getApellidos()}'/></h4>
                                            </div>
                                            <div class="modal-body">
                                                <label>INGRESE NUEVO NÚMERO TELEFONICO:</label>
                                               <form action="#"  class="form-horizontal" role="form">                                                  
                                                <div class="form-group">
                                                     <div class="col-lg-3">
                                                        <select class="form-control" name="tipo_tel" id="tTelefono" >
                                                            <option value='1' >Casa</option>
                                                            <option value='2' >Trabajo</option>
                                                            <option value='3' >Personal</option>                                            
                                                        </select>
                                                    </div>
                                                    <div class="col-lg-7">
                                                        <input type="text" class="form-control" id="newTelefono" onkeypress="ValidaSoloNumeros()">   
                                                    </div>  
                                                    <div class="col-lg-1">
                                                        <button type="button" id="agregaTelf" class="btn btn-success">Agregar</button>  
                                                    </div>                                       
                                                </div>  
                                              </form>                                                 
                                                <hr />
                                                 <label>INGRESE NUEVA DIRECCIÓN:</label>
                                                 <form action="#" class="form-horizontal" role="form">  
                                                <div class="form-group">
                                                      <div class="col-lg-3">
                                                            <select class=" form-control" name="tipo_tel" id="tDireccion" >
                                                                  <option value='1' >Domicilio</option>
                                                                  <option value='2' >Trabajo</option>                                          
                                                          </select>
                                                      </div>
                                                     <div class="col-lg-7">                                          
                                                        <textarea class="form-control input-sm" rows="2" id="direccion_new"></textarea>
                                                     </div>   
                                                     <div class="col-lg-1">                                          
                                                        <button type="button" id="agregaDir" class="btn btn-success">Agregar</button>
                                                     </div>  
                                                </div>    
                                               
                                                
                                              </form> 
                                                
                                                
                                            </div>
                                            <div class="modal-footer">
                                              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                    
                                    
                                    
                                    
                                    
                                    <div id="referencia" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="actulizacion">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="box-body">
                                                    <div class="col-md-12">
                                                        <div class="box">
                                                            <div class="box-header with-border bg-yellow">
                                                                <h3 class="box-title">Actualizacón de Datos</h3>
                                                               
                                                            </div>  <br>
                                                                <form class="form-horizontal" role="form">  
                                                                     <label>Ingrese Nombre de la Referencia: </label>
                                                                    <div class="form-group">
                                                                        <div class="col-lg-3">
                                                                            <select class=" form-control" id="IdtReferencia" >
                                                                                <option value='1' >Tio </option>
                                                                                <option value='2' >Vecino</option> 
                                                                                <option value='3' >Hermano</option>  
                                                                                <option value='4' >Papa</option>  
                                                                                <option value='5' >Abuelo</option>  
                                                                            </select>
                                                                        </div>
                                                                        <div class="col-lg-9">
                                                                            <textarea class="form-control" id="nombre_ref" name="nombre_ref" rows="1" placeholder="Nombre de la Referencia" style="overflow-y:scroll;"></textarea> 
                                                                        </div>                                                                  
                                                                    </div>
                                                                    
                                                                    <input class="form-control" name="telefono" id="Cont" value="0"  type="hidden" > 
                                                                    <div id="addHtmlTelfRef">
                                                                        
                                                                    </div>
                                                                    <button type="button" onclick="addHtmlTelefonoRef();" id="addInputButton" class="btn btn-success">+ Agregar Telefono</button>

                                                                    <br>
                                                                   
                                                                    <button type="button" class="btn btn-success" id="GuardarRef" onclick="AddReferencias();">Guardar</button>
                                                                    <!--button type="button" class="btn btn-primary" id="DatReferencias" onclick="MuestraDatosReferencias();">Datos</button-->
                                                                  <br><br>
                                                                  <div id="DatosReferencias">
                                                                      
                                                                  </div>            
                                                                </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                 
                                    <div id="det_articulo" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="detalle_articulo">
                                        <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content">
                                                <br><div class="box box-danger">
                                                    <div class="box-header with-border bg-yellow">
                                                        <h3 class="box-title">Desglose de Artículos</h3>
                                                    </div>
                                                    <div class="box-body" style="overflow-y:scroll;">
                                                        <table id="detalle_articulos" class="table table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>Referencia de Artículo</th>
                                                                    <th>Descripción</th>
                                                                    <th>Valor Articulo</th>                                                                    
                                                                    <th>Fecha de Compra</th>															  
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                 <c:set var="actualSum" value="${0}"/> 
                                                                <c:forEach items="${detArticulos}" var="detArticulo">
                                                                    <tr>  
                                                                        <td><c:out value="${detArticulo.getReferencia()}"/></td>
                                                                        <td><c:out value="${detArticulo.getNombreArticulo()}"/></td>
                                                                        <td><c:out value="${detArticulo.getValorArticulo()}"/></td>
                                                                        <td><c:out value="${detArticulo.getFechaCompra()} "/></td>
                                                                       <c:set var="actualSum" value="${actualSum + detArticulo.getValorArticulo()}"/> 
                                                               
                                                                    </tr>                                      
                                                                </c:forEach>
                                                                  

                                                            </tbody>
                                                            <tfoot>
                                                                    <tr>
                                                                       
                                                                        <th> Total Deuda: </th>  <th><strong><c:out value="${actualSum} "/></strong></th> 

                                                                    </tr>
                                                                </tfoot>
                                                            
                                                        </table>
                                                                 
                                                    </div>
                                                </div>
                                            </div>      
                                        </div>
                                    </div>            

                                    
                                    <div id="det_cuotas" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="detalle_cuota">
                                        <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content">
                                                <br><div class="box box-danger">
                                                    <div class="box-header with-border bg-yellow">
                                                        <h3 class="box-title">Detalle Cuotas</h3>
                                                    </div> 
                                                    <div class="box-body" style="overflow-y:scroll;">
                                                        <table id="detalle_cuotas" class="table table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>Artículo</th>
                                                                    <th>NºCuota</th>
                                                                    <th>Interés</th>
                                                                    <th>Mora</th>
                                                                    <th>Gastos Cobranzas</th>
                                                                    <th>Gastos Adicionales</th>
                                                                    <th>Otros Gastos</th>
                                                                    <th>Valor Cuota</th>
                                                                    <th>Total</th>
                                                                    <th>Fecha max Pago</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:set var="actualSum" value="${0}"/> 
                                                                <c:forEach items="${detCuotas}" var="detCuota">
                                                                    <tr> 
                                                                        <td><c:out value="${detCuota.getLcArticulo().getReferencia()}"/></td>
                                                                        <td><c:out value="${detCuota.getNumCuotas()}"/></td>
                                                                        <td><c:out value="${detCuota.getInteresCuota()}"/></td>
                                                                        <td><c:out value="${detCuota.getValorMora()}"/></td>
                                                                        <td><c:out value="${detCuota.getGastosCobranzas()}"/></td>
                                                                        <td><c:out value="${detCuota.getGastosAdicional()}"/></td>
                                                                        <td><c:out value="${detCuota.getOtrosValores()}"/></td>
                                                                        <td><c:out value="${detCuota.getValorCuota()}"/></td>
                                                                        <td><c:out value="${detCuota.getTotalCuotas()}"/></td>
                                                                        <td><c:out value="${detCuota.getFechaMaxPago()} "/></td>  
                                                                    </tr>                                      
                                                                </c:forEach>
                                                                
                                                            </tbody>

                                                        </table>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                                        
                                        <div>
                                            <label>   Comp. Pago</label>                
                                            <form class="form-inline"> 
                                                <div class="col-lg-2">
                                                    <div class="input-group date">
                                                        <div class="input-sm input-group-addon">
                                                            <i class="fa fa-calendar"></i>                   
                                                        </div>
                                                        <input type="text" class=" input-sm datepicker form-control" onkeyup="verificaFecha2();" data-date-format="yyyy-mm-dd" id="datepicker" name="compromiso_pago" placeholder="YYYY-MM-DD" >                                         
                                                    </div> 
                                                     <button  type="button" class="btn btn-sm btn-primary btn-lg " onclick="GuardarCompPago()">+</button>
                                                </div> <span id="fechaCompro" ></span>   
                                                <!--div class="col-lg-1">
                                        <button  type="button" class="btn btn-primary btn-lg fa fa-save" onclick="GuardarCompPago()"></button>
                                                </div-->
                                            </form>
                                        </div>




                        </div>
                        <div class="row"> 
                            <form name="form" action="cobranzas" method="post"  id="data">                 
                                <div class="col-lg-2">                                  
                                    <dt>Tipo de Gestión: </dt>
                                    <select class="input-sm form-control" name="gestion" id="gestion" required="required" onchange="obtenerResultado()">
                                        <option value=''>Gestión</option>
                                        <c:forEach items="${gestiones}" var="gestion">
                                            <option value="<c:out value="${gestion.getIdTipoGestion()}"/>" ><c:out value="${gestion.getNombreTipoGestion()}" /></option>
                                        </c:forEach>
                                    </select>                                 
                                </div>

                                <div class="col-lg-2">                                  
                                    <dt>Resultado: </dt>
                                    <select class="input-sm form-control" name="resultado" required="required" id="resultado" disabled="true">
                                        <option value=''>Resultado</option>

                                    </select>                                 
                                </div>

                                <div class="col-lg-7">
                                    <div class="form-group"> 
                                        <label>Descripción: </label>
                                        <strong> <textarea class="form-control input-sm" id="descripcion" name="descripcion" rows="1" placeholder="Descripción" style="overflow-y:scroll; background-color:#FDF9DB;"></textarea>   </strong>
                                    </div>
                                </div>


                                <div class="col-lg-1">
                                    <br><button  type="button" onclick="GuardarTransaccnormal()" class="btn btn-primary btn-lg fa fa-save"></button>
                                </div>
                            </form>
                            <section class="content ">
                                <div id="pagetable">  
                                    <div id="transaccion_table"  class="box table-responsive" style="overflow-y:scroll;" >
                                        <div style="overflow-x:scroll;">
                                            <table id="allTrxGestiones" class="table table-responsive table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th class="col-sm-2">Fecha</th>
                                                        <th class="col-sm-1">Tipo Gestión</th>
                                                        <th class="col-sm-1">Gestión</th>
                                                        <th class="col-sm-5">Descripción</th>
                                                        <th class="col-sm-1">Oficial</th>
                                                        <th class="col-sm-1">Otros</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${GestionTRX}" var="TRXGestion">
                                                        <tr>  
                                                            <td><c:out value="${TRXGestion.getFechaTransaccion()}"/></td>
                                                            <td><c:out value="${TRXGestion.getLcTipoGestion().getNombreTipoGestion()}"/></td>
                                                            <td><c:out value="${TRXGestion.getLcTipoResultado().getNombreTipoResultado()}"/></td>
                                                            <td><strong><c:out value="${TRXGestion.getObservacion()}"/></strong></td>
                                                            <td><c:out value="${TRXGestion.getLcEmpleados().getNombres()}  ${TRXGestion.getLcEmpleados().getApellidos()}  "/></td>
                                                            <td></td>
                                                        </tr>                                      
                                                    </c:forEach>
                                                </tbody>                       
                                            </table>
                                        </div>
                                    </div>
                                </div> 
                            </section>
                        </div>
                    </c:forEach>           
                </div>               
            </div>     
        </div>           

        <!--script src="bootstrap/js/bootstrap-datetimepicker.min.js"></script-->
        <script src="bootstrap/js/bootstrap-datepicker.js"></script>
        <script src="dist/js/consultaxcatera.js"></script>  
        <script src="dist/js/cobranzas.js"></script>
        

        <script>
            $(function () {

                $('#detalle_articulos').DataTable({
                    "paging": false,
                    "lengthChange": false,
                    "searching": false,
                    "ordering": true,
                    "info": true,
                    "autoWidth": false
                });
                $('#detalle_cuotas').DataTable({
                    "paging": true,
                    "lengthChange": false,
                    "searching": false,
                    "ordering": true,
                    "info": false,
                    "autoWidth": false
                });
                $('#datepicker').datepicker({
                    weekStart: 1,
                    color: 'red'
                });
                $('#datepicker2').datepicker({
                    weekStart: 1,
                    color: 'red'
                });
                $('#idAllTelefonos').DataTable( {
                    scrollY:        100,
                    scrollX:        false,
                    scrollCollapse: false,
                    paging:         false,
                     info: false,
                    searching: false,
                    
                    columnDefs: [ {
                        orderable: false,

                        targets:   2
                    } ],
                    select: {
                        style:    'os',
                        selector: 'td:first-child'
                    },
                    order: [[ 2, 'asc' ]]
                } );  
                 $('#idAllDireccions').DataTable( {
                    scrollY:        100,
                    scrollX:        false,
                    scrollCollapse: false,
                    paging:         false,
                     info: false,
                    searching: false,
                    columnDefs: [ {
                        orderable: false,

                        targets:   1
                    } ],
                    select: {
                        style:    'os',
                        selector: 'td:first-child'
                    },
                    order: [[ 1, 'asc' ]]
                } );
                
                
                 $('#allTrxGestiones').DataTable( {
                    scrollY:        300,
                    scrollX:        false,
                    scrollCollapse: false,
                    paging:         false,
                     info: false,
                    searching: false,
                    columnDefs: [ {
                        orderable: false,

                        targets:   1
                    } ],
                    select: {
                        style:    'os',
                        selector: 'td:first-child'
                    },
                    order: [[ 1, 'asc' ]]
                } );
            });
        </script>

    </body>
</html>

