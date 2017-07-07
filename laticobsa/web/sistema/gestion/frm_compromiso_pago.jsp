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
        
       
  </head>
    <body>
  

  <div> <!-- div inicio  -->
      
    <div class="col-lg-8"> 
        <br><div class="box box-danger">
            <div class="box-header with-border bg-yellow">
                <h3 class="box-title">Compromiso de Pago</h3>
            </div>
      <div class="panel panel-default well-lg margin"> 
           <form class="form-inline">            
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
               <div class="form-group has-feedback"></div> 
               <button type="button" class="btn btn-success " id="buscarCompromisos">
                 <span class="glyphicon glyphicon-search"></span> <strong> Buscar </strong>
              </button>
          </form>
          <br>
          
            <div class="row">
                <div  class="box">
                    <div id="busca_compromisos"> 
                      <table  id="compro_pago" class="table-striped table-hover">    
                          
                        <tbody>
                            
                        <tr>
                          <th class="col-sm-1 text-center" >N°</th>
                          <th class="col-sm-2  text-center">Fecha de llamada</th>
                          <th class="col-sm-3">Deudor</th>
                          <th class="col-sm-2 text-center">Fecha de Compromiso</th>
                          <th class="col-sm-2">Monto de Compromiso</th>
                          <th class="col-sm-3">Observación</th>
                        </tr>
                                
                                
                                    <%= request.getAttribute("Tablacompromiso") %>
                      </tbody>
		      </table>
                    </div>
                </div>                
            </div>
      </div>
    </div>
      
    </div>   
  </div>  <!-- fin de div de inicio  --> 
       
  
  
  <!-- /.content-wrapper 
<script src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>-->

<script src="dist/js/compromiso_pagos.js"></script> 
<script src="dist/js/cobranzas.js"></script>


<!-- DataTables
<script src="plugins/datatables/jquery.dataTables.min.js"></script> -->
<!--script src="plugins/datatables/dataTables.bootstrap.min.js"></script-->

<script>    
$(function() {
    $('#datepicker').datepicker({
    weekStart:1,
    color: 'red'
    });
    $('#datepicker2').datepicker({
    weekStart:1,
    color: 'red'
    });
});
         </script> 
<!-- ./wrapper -->
</body>
</html>


