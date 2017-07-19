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

  <!-- Content Wrapper. Contains page content -->

  
  <br>
          <!-- general form elements -->
        <div class="box box-danger">
            <div class="box-header with-border bg-yellow">
              <h3 class="box-title">GENERAR CARTAS</h3>
            </div><br>
            <!-- /.box-header -->
            <!-- form start -->		
            <div class="row">
                            
            <div class="col-lg-6 panel panel-warning">
                
                <div class="row form-group">
                    <div class="col-sm-3">
                        <label>Cartera: </label>  
                        <select class="form-control" name="cliente" required="required" >
                            <option value='' >Seleccionar</option>
                            <option value='SUC1' >DePrati</option>
                            <option value='SUC2' >Artefacta</option>
                            <option value='SUC3' >Comandato</option>
                            <option value='SUC3' >La Ganga</option>
                       </select>
                    </div>
                    <div class="col-sm-3">
                        <label>Cédula:</label>                            					
                        <input type="text" id="cedula" class="form-control  ">   
                           <!-- <div class="form-group has-error  "> <!--hidden-->
                               <!-- <span class="help-block">Usuario no se encuentra Registrado</span>
                            </div>  -->
                    </div>
                    
                    <div class="col-sm-4">
                        <label>Nombre y Apellido: </label>	
                        <input type="text" class="form-control ">    
                    </div>
                    
                    <div class="form-group col-sm-1"><br>
                        <span><button type="button" class="btn-lg btn-primary fa fa-search"></button></span>
                    </div>
                </div>
               
                
                
              <table id="example1" class="table-striped table-hover">
                <thead>
                <tr>
                  <th class="col-sm-2">Cédula</th>
                  <th class="col-sm-4">Nombre y Apellido</th>
                  <th class="col-sm-2">Cliente</th>
                  <th class="col-sm-2">Cartera</th>                  
                  <th class="col-sm-2">Acciones</th>
                </tr>
                </thead>
                <tbody>                      
                        <tr>
                          <td><center>0912345678</center></td>
                          <td><center>David Farias</center></td>
                          <td><center>De Prati</center></td> 
                          <td><center>Cartera Alta</center></td>                                                                                    
                          <td><center><a  href="usuarios?accion=editar" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                              <a href="usuarios?accion=eliminar"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></center>
                          </td>         
                        </tr>
                        <tr>
                          <td><center>0912345678</center></td>
                          <td><center>David Farias</center></td>
                          <td><center>De Prati</center></td> 
                          <td><center>Cartera Baja</center></td>                                                                                     
                          <td><center><a  href="usuarios?accion=editar" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                              <a href="usuarios?accion=eliminar"> <span  class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></center>
                          </td>         
                        </tr>
                        
                        
                </tbody>
              </table>
            </div>
        
            
            <div class="col-lg-6 panel panel-warning">
            <form name="form" action="#" method="get" >
                                
                    <div class="form-group">
                        <label>Nombres y Apellidos: </label>
                        <input type="text" class="form-control"  disabled required="required" name="nombre">
                    </div>
                            
                            
                        <div class="row form-group">
                            
                            <div class="col-sm-6">
                                <label>Total de la Deuda: </label>
                                <input type="text" class="form-control" disabled name="total_deuda">
                            </div>

                            <div class="col-sm-6">
                                <label>F. Último pago: </label>
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>                   
                                    </div>
                                    <input type="text" class=" input-sm datepicker form-control" id="ultimo_pago" disabled name="ultimo_pago"> 
                                </div>                               			  			  
                            </div>
                        </div>
                            
                <div class="row form-group">
                    <div class="col-sm-6">
                        <label>Nombre del Documento</label>
                        <select class="form-control" name="cliente" required="required" >
                            <option value='' >Seleccionar</option>
                            <option value='CARTA1' >Carta Solicitud</option>
                            <option value='CARTA2' >Carta a Deudor</option>
                            <option value='CARTA3' >Carta de Invitacion</option>
                            <option value='CARTA4' >Carta de Aviso</option>
                       </select>
                    </div>
                    <div class="col-sm-6">
                        <label>Cartera: </label>  
                        <select class="form-control" name="cliente" required="required" >
                            <option value='' >Seleccionar</option>
                            <option value='SUC1' >DePrati</option>
                            <option value='SUC2' >Artefacta</option>
                            <option value='SUC3' >Comandato</option>
                            <option value='SUC3' >La Ganga</option>
                       </select>
                    </div>
                </div>

                <div class="form-group">
                    <label>Observaciones: </label>
                    <textarea class="form-control" rows="3" placeholder="Observaciones ..."></textarea>				   
                </div>                     
                            
                
                 
                   <div id="test"></div>         
                            
            </form>
            </div>
            
                <div class="form-group">
                    <center>  <a class="btn btn-primary fa fa-search-plus view-pdf" href="sistema/Documentos/LATICOBSA  S.pdf"> Ver</a>
                    <button class="btn btn-primary hidden-print fa fa-print" onclick="myFunction()"> Print</button>
                    <a href="#" class="btn btn-primary fa fa-close"> Cancelar</a></center>
                </div>
                
            </div>
    </div>
          

  
  
  
  
  
  <!-- /.content-wrapper -->

  
 
<!-- ./wrapper -->
<script src="dist/js/roles.js"></script>   
<script src="dist/js/cobranzas.js"></script>


<script>
    (function(a){a.createModal=function(b){defaults={title:"",message:"Your Message Goes Here!",closeButton:true,scrollable:false};var b=a.extend({},defaults,b);var c=(b.scrollable===true)?'style="max-height: 420px;overflow-y: auto;"':"";html='<div class="modal fade" id="myModal">';html+='<div class="modal-dialog">';html+='<div class="modal-content">';html+='<div class="modal-header">';html+='<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';if(b.title.length>0){html+='<h4 class="modal-title">'+b.title+"</h4>"}html+="</div>";html+='<div class="modal-body" '+c+">";html+=b.message;html+="</div>";html+='<div class="modal-footer">';if(b.closeButton===true){html+='<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>'}html+="</div>";html+="</div>";html+="</div>";html+="</div>";a("body").prepend(html);a("#myModal").modal().on("hidden.bs.modal",function(){a(this).remove()})}})(jQuery);

$(function(){    
    $('.view-pdf').on('click',function(){
        var pdf_link = $(this).attr('href');
        //var iframe = '<div class="iframe-container"><iframe src="'+pdf_link+'"></iframe></div>'
        //var iframe = '<object data="'+pdf_link+'" type="application/pdf"><embed src="'+pdf_link+'" type="application/pdf" /></object>'        
        var iframe = '<object type="application/pdf" data="'+pdf_link+'" width="100%" height="1000">No Support</object>'
        $.createModal({
            title:'Cobranzas',
            message: iframe,
            closeButton:true,
            scrollable:false
        });
        return false;        
    });    

    
    function myFunction() {
    window.print();
    }
    
    $(document).ready(function() {
    $('#test').qrcode({width: 120,height: 120, text: "https://github.com/jeromeetienne/jquery-qrcode"});
    });
    
     $("#example1").DataTable({
      "paging": false,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": false,
      "autoWidth": false
    });
    
    $('#cedula').validCampoFranz('0123456789.');
    
  })  
    
</script>


</body>
</html>


