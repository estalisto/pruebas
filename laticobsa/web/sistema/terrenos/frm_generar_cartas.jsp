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

  
  <br><div class="col-sm-6">
          <!-- general form elements -->
        <div class="box box-danger">
            <div class="box-header with-border bg-yellow">
              <h3 class="box-title">Usuarios</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->			

            <form name="form" action="#" method="get" class="well">
                            <!-- /input-group -->
                    <div class="form-group">
                        <label>Cédula:</label>
                            <div class="input-group">					
                                <input type="text" class="form-control">
                                <span class="input-group-btn">
                                  <button type="button" class="btn btn-info btn-flat">Buscar</button>
                                </span>
                            </div>
                            <div class="form-group has-error  "> <!--hidden-->
                                <span class="help-block">Usuario no se encuentra Registrado</span>
                            </div>
                    </div>

                    <div class="form-group">
                        <label>Nombres y Apellidos: </label>
                        <input type="text" class="form-control"  disabled required="required" name="nombre">
                    </div>
                            
                            
                        <div class="row form-group">
                            <div class="col-sm-4">
                                <label>Cliente</label>  
                                <select class="form-control" name="cliente" required="required" >
                                    <option value='' >Seleccionar</option>
                                    <option value='SUC1' >DePrati</option>
                                    <option value='SUC2' >Artefacta</option>
                                    <option value='SUC3' >Comandato</option>
                                    <option value='SUC3' >La Ganga</option>
                               </select>
                            </div>

                            <div class="col-sm-4">
                                <label>Total de la Deuda: </label>
                                <input type="text" class="form-control" disabled name="total_deuda">
                            </div>

                            <div class="col-sm-4">
                                <label>F. Último pago: </label>
                                <div class="input-group date">
                                    <div class="input-sm input-group-addon">
                                        <i class="fa fa-calendar"></i>                   
                                    </div>
                                    <input type="text" class=" input-sm datepicker form-control" id="ultimo_pago" disabled name="ultimo_pago"> 
                                </div>                               			  			  
                            </div>
                        </div>
                            
                <div class="form-group">
                    <label>Nombre del Documento</label>
                    <select class="form-control" name="cliente" required="required" >
                        <option value='' >Seleccionar</option>
                        <option value='CARTA1' >Carta Solicitud</option>
                        <option value='CARTA2' >Carta a Deudor</option>
                        <option value='CARTA3' >Carta de Invitacion</option>
                        <option value='CARTA4' >Carta de Aviso</option>
                   </select>
                </div>

                <div class="form-group">
                    <label>Observaciones: </label>
                    <textarea class="form-control" rows="3" placeholder="Observaciones ..."></textarea>				   
                </div>                     
                            
                <div class="form-group">
                    <a class="btn btn-primary view-pdf" href="sistema/Documentos/LATICOBSA  S.pdf">Ver</a>
                    <button class="btn btn-primary hidden-print" onclick="myFunction()">Print</button>
                    <a href="#" class="btn btn-primary">Cancelar</a>
                </div>
                 
                   <div id="test"></div>         
                            
            </form>     
        </div>
    </div>
</div>
  <!-- /.content-wrapper -->

  
 
<!-- ./wrapper -->
<script src="dist/js/roles.js"></script>   


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
})
    
    function myFunction() {
    window.print();
    }
    
    $(document).ready(function() {
    $('#test').qrcode({width: 120,height: 120, text: "https://github.com/jeromeetienne/jquery-qrcode"});
    });
</script>


</body>
</html>


