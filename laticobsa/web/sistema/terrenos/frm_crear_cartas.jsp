    <%-- 
    Document   : index
    Created on : 12-feb-2017, 22:28:05
    Author     : Stalyn Granda
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <!DOCTYPE html>
<html>
<head>
     
  <!-- Content Wrapper. Contains page content -->

  <div>

      <br >
      
      
      <div class="col-md-6">

        <div class="box box-danger">
            <div class="box-header with-border bg-yellow"   >
              <h3 class="box-title" >Crear Plantillas de Documentos</h3>
            </div>
              <form name="form" action="empleados" method="get" class="well">
                
                        <!-- Color Picker -->
                        
                        <div class="row form-group">
                            <div class="col-sm-4">
                              <label>Empresa:</label>
                              <select class="form-control" id="empresa"  required="required">
                                <option value="">Seleccionar</option>
                                <option value='EMPR1'>Empresa 1</option>
                                <option value='EMPR2 '>Empresa 2</option>
                                <option value='EMPR3'>Empresa 3</option>                             
                              </select>
                            </div>

                            <div class="col-sm-4">
                                <label>Sucursal</label>
                                <select class="form-control" id="sucursal" required="required" >
                                  <option value='' >Seleccionar</option>
                                  <option value='SUC1' >Norte</option>
                                  <option value='SUC2' >Centro</option>
                                  <option value='SUC3' >Sur</option>
                                </select>
                            </div>


                            <div class="col-sm-4">
                                <label>Cartera: </label>  
                                <select class="form-control" id="cliente" required="required" >
                                    <option value='' >Seleccionar</option>
                                    <option value='CLI1' >DePrati</option>
                                    <option value='CLI2' >Artefacta</option>
                                    <option value='CLI3' >Comandato</option>
                                    <option value='CLI4' >La Ganga</option>
                               </select>
                            </div>                               
                        </div>          
                   
                        <div class="form-group">
                            <label>Nombre del Documento</label>
                            <input type="text" class="form-control" id="nombre_documento">
                        </div>
                        
                        <div class="form-group">
                            <textarea class="form-control" rows="3" placeholder="Saludo" id="saludo"></textarea>
                            <textarea class="form-control" rows="5" placeholder="Cuerpo" id="cuerpo"></textarea>
                            <textarea class="form-control" rows="3" placeholder="Despedida" id="despedida"></textarea>
                            <textarea class="form-control" rows="3" placeholder="Firma" id="firma"></textarea>
                        </div>
                        
                        <div class="form-group">
                            <label>[Cedula]</label>
                            <label>[Nombre Cliente]</label>
                            <label>[Cartera]</label>
                            <label>[Monto]</label>
                            <label>[Ciudad]</label>
                            <label>[Observaciones]</label>
                            
                        </div>
                        
                        <div class=" form-group">
                            <button type="button" class="btn btn-primary" onclick="validaDatos()">Grabar</button>  
                          <button type="button" class="btn btn-primary">Salir</button>
                        </div>
            </form> 
              <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      
  </div>
  <!-- /.content-wrapper 
  
  <script src="dist/js/plantillas.js">  </script>-->
  
  
</body>
</html>

