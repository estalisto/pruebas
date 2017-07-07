<%-- 
    Document   : index
    Created on : 12-feb-2017, 22:28:05
    Author     : Stalyn Granda
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

  <!DOCTYPE html>
<html>
  <head>      
        
           <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  </head>

<body>

  <div> 
      
      <br><div class="box box-danger">
        <div class="box-header with-border bg-yellow">
          <h3 class="box-title">Consultas por Cartera</h3>
        </div> 
          <div class="col-lg-5"> <br>
            
                <div class="row">
                    <div class="col-lg-12">                    
                        <div class="row">
                             <div class="col-sm-2">
                                <label>Cliente Cartera:</label>
                             </div>
                            <div class="col-sm-6">
                                 <select class="form-control" name="cartera" required="required" id="cartera" >
                               
                                <c:forEach items="${carteras}" var="carter">
                                    <option value="<c:out value="${carter.getIdCliente()}" />"><c:out value="${carter.getRazonSocial()}" /> </option>                         
                                </c:forEach> 
                                </select>
                             </div>                                             
                            <div class="col-sm-2">                        
                                <button id="btnbuscar" type="submit" class="btn btn-primary btn-sm fa fa-search"> BUSCAR</button>                       
                            </div>
                        </div>
                    </div>                  
                </div>
            
        </div> 
          <div class="col-lg-6">             
                <div class="row">
                    <div class="col-lg-10">               
                        <div class="row">
                             <div class="form-inline">
                                 <div class="col-sm-4">
                                    <label>Monto</label><br>
                                    <input size="2" type="text" class="form-control input-sm" id="monto" name="idmonto" required="required">
                                    <input size="2" type="text" class="form-control input-sm" id="monto1" name="idmonto1" required="required">
                                   <a id="btnMonto" onclick="" ><span class="glyphicon glyphicon-ok" ></span></a>
                                   <!--  <a id="ordenDesc" onclick="" ><span class="fa fa-arrow-down" ></span></a>-->
                              
                                </div>
                             </div>
                            
                            <div class="form-inline">
                                <div class="col-sm-4">
                                    <label>Días Mora</label><br>
                                    <input size="2" type="text" class="form-control input-sm" id="dia_mora" name="idmora" required="required">
                                    <input size="2" type="text" class="form-control input-sm" id="dia_mora1" name="idmora1" required="required">
                                   <!-- <a id="btnordenAsc1" onclick="" ><span class="fa fa-arrow-up" ></span></a>
                                    <a id="btnordenDesc1" onclick="" ><span class="fa fa-arrow-down" ></span></a>-->
                                </div>
                            </div>                                             
                            
                            <div class="form-inline">  
                                <div class="col-sm-4">
                                    <label>F. Últ. Gestión</label><br>
                                    <input size="2" type="text" class="form-control input-sm" id="ultima_gestion" name="idgestion" required="required">
                                    <input size="2" type="text" class="form-control input-sm" id="ultima_gestion1" name="idgestion" required="required">
                                   <!-- <a  id="btnordenAsc2" ><span class="fa fa-arrow-up" ></span></a>
                                    <a  id="btnordenDesc2" ><span class="fa fa-arrow-down" ></span></a>-->
                                </div>
                            </div>
                             
                        </div>
                    </div> 
                    <div class="col-lg-1"> 
                     <center><img id="id_loader" src="resources/dist/img/loader.gif" class="img-circle" alt="User Image" width="50" style="display: none"></center>
                    </div>                   
                </div>           
        </div> 
          <input  type="text" class="form-control input-sm hidden" id="IdDiasMora">
          <input  type="text" class="form-control input-sm hidden" id="IdTotalVenc">
          <input  type="text" class="form-control input-sm hidden" id="IdFechaUlt">
          <input  type="text" class="form-control input-sm hidden" id="IdIdentificacion">
          <input  type="text" class="form-control input-sm hidden" id="IdNombres">
          <input  type="text" class="form-control input-sm hidden" id="IdPagos">
          <input  type="text" class="form-control input-sm hidden" id="IdFecUltPagos">
          <input  type="text" class="form-control input-sm hidden" id="IdSaldo">
          <input  type="text" class="form-control input-sm hidden" id="IdValorComp">
          <input  type="text" class="form-control input-sm hidden" id="IdFechaComp">
          <input  type="text" class="form-control input-sm hidden" id="IdUltima">
          <input  type="text" class="form-control input-sm hidden" id="IdResultado">
            <div class="panel panel-default well-lg">
                <div class="row">
                    <div class="col-lg-12">   
                       <div class="box"> 
                           
                        <section class="content ">
                         <div id="pagetable">  
                            <div class="row">
                                <div  class="col-xs-12" >
                                        <form name="form1" action="consultacartera" method="get">                                
                                         <div>                        
                                            <div  class="box-body table-responsive" style="overflow-x: auto" >
                                         <table id="consul_cartera" class="table-striped table-hover " >
                                                            <thead>
                                                                    <tr bgcolor="#FBF5EF">                                  
                                                                        <th class="col-sm-1 text-left hidden" style="color: #3c8dbc">ID</th>                                                        
                                                                        <th align="left" class="col-sm-1 text-left"><a id="IdentificacionID" onclick="orderIdent()">Identificación</a></th>
                                                                        <th class="col-sm-2 text-left"><a id="NombresID" onclick="orderNombre()">Nombres</a></th>  
                                                                        <th class="col-sm-1 text-left"><a id="DiasMoraID" onclick="orderDiasMora()" >Días Mora</a></th> 
                                                                        <th class="col-sm-1 text-right"><a id="TotalID" onclick="orderTotalVenc()" >Total Vnc</a></th> 
                                                                        <th align="center" class="col-sm-1 text-right"><a id="PagosID" onclick="orderPagos()">Pagos</a></th>
                                                                        <th align="center" class="col-sm-1 text-right"><a id="FecUltPagosID" onclick="orderFechaUltPagos()">Fecha Ult. Pagos</a></th>
                                                                        <th align="rigth" class="col-sm-1 text-right"><a id="SaldosID" onclick="orderSaldo()">Saldo</a></th> 
                                                                        <th align="center" class="col-sm-1 text-right"><a id="ValorCompID" onclick="orderValorComp()">Valor Comp.</a></th> 
                                                                        <th align="center" class="col-sm-2 text-center"><a id="FechaCompID" onclick="orderFechaComp()">Fecha Comp.</a></th>
                                                                        <th align="center" class="col-sm-3"><a id="FechaID" onclick="orderFchGestion()" >Fecha Ult. Gestión</a></th> 
                                                                        <th align="center" class="col-sm-3"><a id="UltimaID" onclick="orderUltima()">Ult. Gestión</a></th> 
                                                                        <th align="center" class="col-sm-2"><a id="ResultadoID" onclick="orderResultado()">Resultado Gestión</a></th>
                                                                    </tr>  
                                                            </thead>
                                                            <tbody id="bodytable">                                
                                                               
                                                            
                                                                 <%= request.getAttribute("Tablacartera") %>
                                                            </tbody>
                                                    </table>
                                            </div>
                                         </div>
                                        </form>
                                </div>
                            </div>
                        </div> 
                        
                        </section>
                        </div>                          
                    </div>
                </div>
            </div>
      </div> 
  </div> 
   


<script src="dist/js/consultaxcatera.js"></script> 
<script src="dist/js/cobranzas.js"></script>
</body>
</html>

