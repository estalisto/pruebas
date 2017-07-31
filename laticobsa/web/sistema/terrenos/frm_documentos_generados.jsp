<%-- 
    Document   : roles
    Created on : 27-feb-2017, 11:50:46
    Author     : Stalyn Granda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
</head>
<div> 
    <section class="content">
          
        <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Mis Documentos</h3>
                </div>
                <!-- /.box-header -->
                    <div class="box-body" style="overflow-x:scroll;">
                        <table id="example1" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                              <th>N°. Documento</th>
                              <th>Documento</th>
                              <th>Cliente</th>                  
                              <th>Fecha Modificación</th>
                              <th>Acciones</th>
                            </tr>
                            </thead>
                            <tbody>  
                                <tr>
                                  <td> </td>
                                  <td> </td>
                                  <td></td> 
                                  <td></td>                                                                                      
                                  <td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                      <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                      <span  class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                  </td> 
                                </tr>   
                            </tbody>
                        </table>
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


<script src="dist/js/documento.js"></script>   
<script>
  $(function () {
       $('#example').DataTable();
    $("#example1").DataTable();
  });
</script>
</body>
</html>



