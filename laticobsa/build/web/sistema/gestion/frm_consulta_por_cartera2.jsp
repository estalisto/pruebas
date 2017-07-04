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
        <div class="col-lg-6"> 
            <div class="panel panel-footer well-lg margin">
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
                                <button id="btnbuscar" type="submit" class="btn btn-primary btn-lg fa fa-search">BUSCAR</button>                       
                            </div>
                        </div>
                    </div>                  
                </div>
            </div>
        </div> 
            <div class="panel panel-default well-lg">
                <div class="row">
                    <div class="col-lg-12">   
                       <div class="box"> 
                           
                        <section class="content ">
                        <div id="pagetable">  
                            <div class='row'>
                                <div  class='col-xs-12' >
                                    <form name='form1' action='consultacartera' method='get'> 
                                        <div>
                                            <div  class='box-body table-responsive'  >
                                                <table id='consul_cartera' class='table-striped table-hover'>
                                                    <thead>
                                                        <tr> 
                                                        <th class="col-sm-1">ID</th>                                                        
                                                        <th class="col-sm-1">Identificación</th>
                                                        <th class="col-sm-3">Nombres</th>  
                                                        <th class="col-sm-2">Días Mora</th> 
                                                        <th class="col-sm-2">Total Vencidos</th> 
                                                        <th class="col-sm-2">Pagos</th>
                                                        <th class="col-sm-2">Saldo</th> 
                                                        <th class="col-sm-2">Valor Compromiso</th> 
                                                        <th class="col-sm-2">Fecha Compromiso</th>
                                                        <th class="col-sm-2">Fecha Ult. Gestión</th> 
                                                        <th class="col-sm-2">Ult. Gestión</th> 
                                                        <th class="col-sm-2">Resultado Gestión</th>
                                                        </tr> 
                                                    </thead> 
                                                    <tbody>
                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>   
                                                        </tr>
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
   
 <%= request.getAttribute("Tablacartera") %>

<script src="dist/js/consultaxcatera.js"></script> 
<script src="dist/js/cobranzas.js"></script>
<script>
  $(function () {


    
        $('#consul_cartera').DataTable({
      "paging": true,
      "lengthChange": false,
      "lengthMenu": [25],
      "searching": false,
      "ordering": true,
      "info": false,
      "autoWidth": false,
    });
                
             
    
  });
</script>
</body>
</html>

