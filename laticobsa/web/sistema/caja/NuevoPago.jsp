<%-- 
    Document   : NuevoPago
    Created on : 17/05/2017, 02:02:03 PM
    Author     : ViewSoft
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br >
            <ol class="breadcrumb">
                <li><a href="#" onclick="listar_pagos();">Pagos Realizados</a></li>
                <li class="active"><a href="#" onclick="recaudacion();">Consultar Deuda Clientes</a></li>             
            </ol>

        <div>
            <div class="col-md-10">
               
                <section class="content">
                    <div class="row">
                       
                        <div class="col-lg-9">
                         <div class="panel panel-default well-lg margin"> 
                            <form class="form-inline">   
                                <div  class="form-group has-feedback">
                                  <a href="#" onclick="recaudacion()" class="btn btn-success">Nuevo Pago +</a></div>
                                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <div class="form-group has-feedback">
                                    <label class="control-label"> Fecha Desde:</label>
                                    <input type="text" class="form-control" placeholder="DD-MM-YYYY" data-date-format="dd-mm-yyyy" id="datepicker"/>
                                    <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                                </div> 
                                   <div class="form-group has-feedback"></div> 
                                <div class="form-group has-feedback">
                                    <label class="control-label">Fecha Hasta: </label>
                                    <input type="text" class="form-control" placeholder="DD-MM-YYYY" data-date-format="dd-mm-yyyy" id="datepicker2"/>
                                    <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                                </div> 
                                   <div class="form-group has-feedback"> 
                                       <button type="button" class="btn btn-success " id="buscarCompromisos" onclick="consultaRecaudaciones();">
                                     <span class="glyphicon glyphicon-search"></span> <strong> Buscar </strong>
                                  </button>
                                   </div>
                                    
                                 
                              </form>
                             
                         </div>
                             
                        </div>
                        <div class="col-lg-3">
                             <label class="control-label ">Total Recaudado: </label>
                           <div class="panel panel-default margin"> 
                                <form class="form-inline">   
                                    <div class="form-group has-feedback">
                                   
                                    <label class="control-label "><h3><p  class="text-right text-primary ">$1500.00</p></h3></label>                                    
                                   </div>  
                                </form> 
                             </div>  
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="tableRecaudaciones" class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Lista de Pagos</h3>
                                </div>
                                <!-- /.box-header -->
                                <div id="consultaRecaudaciones">
                                        <div class="box-body" style="overflow-x:scroll;">
                                            <table id="example1" class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>

                                                        <th>N° Comprobante</th>
                                                        <th>Nombre Deudor</th>
                                                        <th>Valor Total</th>
                                                        <th>Fecha Pago </th>
                                                        <th>Acción </th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                <c:forEach items="${datos}" var="data">
                                                    <tr>

                                                        <td><c:out value="${data.getIdRecaudacion()}"/></td>
                                                        <td><c:out value="${data.getLcDatosDeudores().getNombresCompleto()}"/></td>
                                                        <td><c:out value="${data.getValorRecaudado()}" /></td>
                                                        <td><c:out value="${data.getFechaRegistro()}" /></td>
                                                        <td>
                                                            <!--<a onclick="ConnsultaDatosID(${data.getIdRecaudacion()})"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>-->
                                                           </span></a>
                                                           <a onclick="VistaPago(${data.getIdRecaudacion()})"> <span class="glyphicon glyphicon-eye-open" aria-hidden="true">
                                                           <a onclick="elminarPago(${data.getIdRecaudacion()})"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>

                                                       </td>    
                                                    </tr>     
                                                </c:forEach>  
                                                </tbody>

                                            </table>
                                        </div>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </section>
                    
            </div>
        </div>  
        <script src="dist/js/nuevoPago.js"></script>    
         <script src="dist/js/validaciones.js"></script>   
    </body>

</html>
