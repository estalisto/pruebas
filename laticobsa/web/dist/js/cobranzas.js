/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Sgtedeudor(stridDeudor, stridCliente) {
    var idDeudor = stridDeudor;
    var idCliente = stridCliente;
    var accion = "deudor";
    $('#img_cargando').css("display", "block");
    var parametros = {
        "idCliente": idCliente,
        "idDeudor": idDeudor,
        "accion": accion

    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                if(parseInt(response) === 0){
                   document.getElementById("siguiente").disabled = true;  
		   $('#img_cargando').css("display", "none");
                }else{
                     cobranzas2(idCliente, parseInt(response));
                }
            }
        }
    });
}
function Antdeudor(stridDeudor, stridCliente) {
    var idDeudor = stridDeudor;
    var idCliente = stridCliente;
    var accion = "anterior";
    $('#img_cargando').css("display", "block");
    var parametros = {
        "idCliente": idCliente,
        "idDeudor": idDeudor,
        "accion": accion

    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                //alert(response);
                if(parseInt(response) === 0){
                 document.getElementById("anterior").disabled = true;   
		  $('#img_cargando').css("display", "none");
                }else{
                cobranzas2(idCliente, parseInt(response));
            }
            }
        }
    });
}
function cobranzas2(stridCliente, stride){
var idCliente = stridCliente;
var idDeudor= stride;
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>");
        jQuery("#page-wrapper").load("cobranzas?accion=envio&idCliente="+idCliente+"&idDeudor="+idDeudor,{},function(){ });
        

}
function obtenerResultado() {
    var gestion = $("#gestion").val();

    if (gestion !== "") {
        $.post("sistema/gestion/combo_resultado.jsp", $("#data").serialize(), function (data) {
            $("#resultado").html(data);
        });
        document.getElementById("resultado").disabled = false;
    }
}
function GuardarRecordatorio()
{
    var id = $('#id').val();
    var accion = "guardar";
    var hora = $('#hora').val();
    var compromiso_pago = $('#datepicker2').val();
    var cliente = $('#idcliente').val();
    
     if(verificaFecha3('datepicker2')!==2){        
          if(verificaFecha3('datepicker2')===1){
              MsgSalidaModalA("La Fecha de Recordatorio tiene que se igual o mayor a la fecha actual");
          }else   if(verificaFecha3('datepicker2')===3){
             MsgSalidaModalA("La Fecha de recordatorio  no valida o no existe."); 
          }else   if(verificaFecha3('datepicker2')===4){
             MsgSalidaModalA("El Formato de la fecha es incorrecto."); 
          }        
      return true;  
    }
    
    
    if (compromiso_pago !== "") {
        if (hora !== "") {
    var parametros = {
        "accion": accion,
        "id": id,
        "hora": hora,
        "compromiso_pago": compromiso_pago
    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                MsgSalidaModalM(response);
                        $('#transaccion_table').css("display", "none");
                transacciones_pendientes(cliente,id);
            }
        }
    });
        } else {
            alert("Debe Escoger Hora para el Recordatorio");
        }
    } else {
        alert("Debe elegir una Fecha");
    }

}

function GuardarTransaccion() {
    var id = $('#id').val();
    var accion = "guardar";
    var hora = $('#hora').val();
    var compromiso_pago = $('#datepicker2').val();
    var cliente = $('#idcliente').val();
    var parametros = {
        "accion": accion,
        "id": id,
        "hora": hora,
        "compromiso_pago": compromiso_pago
    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                MsgSalidaModalM(response);
                $('#transaccion_table').css("display", "none");
                 transacciones_pendientes(cliente,id);
            }
        }
    });
}
function ValidarNota2(){
    var idNota = $('#idNotas').val();
    var idCliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    var accion = "notas";
    var txtnota = $('#txtnota').val();
    //alert("Notas: "+txtnota+" Cliente: "+idCliente+" Deudor: "+idDeudor+" accion: "+accion);
         var parametros = {
        "accion": accion,
        "idNota": idNota,
        "idDeudor": idDeudor,
        "txtnota": txtnota,
        "idCliente": idCliente
    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                var x = document.getElementById("idNotas");
                x.value = parseInt(response);
            }
        }
    });
    
}
function ValidarNota(strcliente,strdeudor){
    var idNota = strnota;
    var idCliente = strcliente;
    var idDeudor = strdeudor;
    var accion = "notas";
    var txtnota = $('#txtnota').val();
    //alert(txtnota);
    if(idNota === ""){
        idNota=0;
        var parametros = {
        "accion": accion,
        "idNota": idNota,
        "idDeudor": idDeudor,
        "txtnota": txtnota,
        "idCliente": idCliente
    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                //alert(response);
            }
        }
    });
    }else{
        var parametros = {
        "accion": accion,
        "idNota": idNota,
        "idDeudor": idDeudor,
        "txtnota": txtnota,
        "idCliente": idCliente
    };
    $.ajax({
        data: parametros,
        url: 'cobranzas',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
                //alert(response);
            }
        }
    });
    }
    
}
function validaDatos( resultado, gestion, descripcion,accion,id,cliente) {
    if (gestion !== "") {
        if (resultado !== "") {
            if (descripcion.length > 1 ) {
                
                    return true;
                
            } else {
                alert("Debe ingresar una descripcion");
            }
        } else {
            alert("Debe elegir un Resultado");
        }
    } else {
        alert("Debe elegir una Gestion");
    }
    return false;
}

function obtenerResultado2() {
    var gestion = $("#gestion").val();

    if (gestion !== "") {
        $.post("sistema/gestion/combo_resultado.jsp", $("#data").serialize(), function (data) {
            $("#resultado").html(data);
        });
        document.getElementById("resultado").disabled = false;
    }
}

function GuardarTransaccnormal() {
    var id = $('#id').val();
    var accion = "transaccion";
    var descripcion = $('#descripcion').val();
    var resultado = $('#resultado').val();
    var gestion = $('#gestion').val();
    var cliente = $('#idcliente').val();
    //JG ini
    var monto_compromiso = $('#monto_compromiso').val();
    var comp_pago = $('#datepicker').val();
    var idTransaccion = $('#idTransaccion').val();
     //JG fin
   
    if (validaDatos(resultado, gestion, descripcion, accion, id, cliente)) {
      //JG ini
        if(resultado=="1"){
            
        if (comp_pago !== "") {
            if (verificaFecha3('datepicker') !== 2) {
                    if (verificaFecha3('datepicker') === 1) {
                        MsgSalidaModalA("La Fecha de Compromisos de Pago tiene que se igual o mayor a la fecha actual");
                    } else if (verificaFecha3('datepicker') === 3) {
                        MsgSalidaModalA("La Fecha de Compromiso de Pago no existe.");
                    } else if (verificaFecha3('datepicker') === 4) {
                        MsgSalidaModalA("El Formato de la fecha es incorrecto.");
                    }
                    return true;
                }
               //  alert(idTransaccion);
                   $('#img_cargando').css("display", "block");
            if(monto_compromiso !== ""){
               
                var parametros = {
                    "accion": accion,
                    "id": id,
                    "descripcion": descripcion,
                    "gestion": gestion,
                    "resultado": resultado,
                    "cliente": cliente,
                    "idTransaccion": idTransaccion,
                    "monto_compromiso": monto_compromiso,
                    "comp_pago": comp_pago
                };
                $.ajax({
                    data: parametros,
                    url: 'cobranzas',
                    type: 'GET',
                    beforeSend: function () {
                    },
                    success: function (response) {
                    $('#img_cargando').css("display", "none"); 
                        if (response) {
                         
                            MsgSalidaModalM(response);
                            var x = document.getElementById("descripcion");
                            x.value = "";
                            var y = document.getElementById("resultado");
                            y.value = "";
                            var z = document.getElementById("gestion");
                            z.value = "";
                            var A = document.getElementById("datepicker");//monto_compromiso
                            A.value = "";
                            var B = document.getElementById("monto_compromiso");
                            B.value = "";
                            transacciones_pendientes(cliente, id);
                              
                        } else {
                            MsgSalidaModalM("Compromiso de pago no Guardado");

                        }
                    }
                });
            }else{alert("Debe Ingresar un Monto de Compromiso De Pago");}
        } else {
            alert("Debe Ingresar una Fecha de Compromiso De Pago");
        }
    }
        if ((comp_pago === "")&&(resultado!="1")) {
            if(monto_compromiso===""){
	    //JG fin
//            comp_pago = 0;
//            monto_compromiso = 0;
          $('#img_cargando').css("display", "block"); 
            var parametros = {
                "accion": accion,
                "id": id,
                "descripcion": descripcion,
                "gestion": gestion,
                "resultado": resultado,
                "cliente": cliente,
                "idTransaccion": idTransaccion//,
//                "monto_compromiso": monto_compromiso,
//                "comp_pago": comp_pago
            };
            $.ajax({
                data: parametros,
                url: 'cobranzas',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {
                    $('#img_cargando').css("display", "none"); 
                    if (response) {
                        
                        alert(response);
                        $('#transaccion_table').css("display", "none");
                      //JG ini
		        var x = document.getElementById("descripcion");
                        x.value = "";
                        var y = document.getElementById("resultado");
                        y.value = "";
                        var z = document.getElementById("gestion");
                        z.value = "";
                        var A = document.getElementById("datepicker");//monto_compromiso
                            A.value = "";
                            var B = document.getElementById("monto_compromiso");
                            B.value = "";
			    //JG fin
                                  
                        transacciones_pendientes(cliente, id);
                    } else {
                        alert("Compromiso de pago no Guardado");

                    }
                }
            });
            }
        }
    }
}
function transacciones_pendientes(cliente,id)
{   
    jQuery("#pagetable").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
    jQuery("#pagetable").load("cobranzas?accion=listar_transaccion&idDeudor="+id+"&idCliente="+cliente,{},function(){ });
}

function GuardarCompPago() {
 var comp_pago = $('#datepicker').val();
    var accion = "compromiso";
    var idCliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    //console.log("valida compromiso: "+verificaFecha3('datepicker'));
    if(verificaFecha3('datepicker')!==2){        
          if(verificaFecha3('datepicker')===1){
              MsgSalidaModalA("La Fecha de Compromisos de Pago tiene que se igual o mayor a la fecha actual");
          }else   if(verificaFecha3('datepicker')===3){
             MsgSalidaModalA("La Fecha de Compromiso de Pago no existe."); 
          }else   if(verificaFecha3('datepicker')===4){
             MsgSalidaModalA("El Formato de la fecha es incorrecto."); 
          }        
      return true;  
    }
     //console.log("paso compromiso ");
    //return;
    
    if (comp_pago !== "") {
        var parametros = {
            "accion": accion,
            "idDeudor": idDeudor,
            "idCliente": idCliente,
            "comp_pago": comp_pago
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {
                    MsgSalidaModalM(response);
                     transacciones_pendientes(idCliente,idDeudor);
                } else {
                    MsgSalidaModalM("Compromiso de pago no Guardado");

                }
            }
        });
    } else {
        alert("Debe Ingresar una Fecha de Compromiso De Pago");
    }
}/*
$('#agregaDir').click(function(e){
   e.preventDefault();  
    var cliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    var tDireccion = $('#tDireccion').val();
    var direccion_new = $('#direccion_new').val();
    var accion = "agraga_direccion";
   // alert("agraga_telef?cliente: "+cliente+"Deudor: "+idDeudor+"Telefono: "+tipoTelefono+"New Tele: "+newTelefono+accion);

    if (direccion_new === "") {
        alert("Ingrese una dirección válida");
        return;  
      }
var parametros = {
            "accion": accion,
            "idDeudor": idDeudor,
            "cliente": cliente,
            "tDireccion": tDireccion,
            "direccion_new": direccion_new
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {
                    alert(response);
                  document.getElementById("direccion_new").value = "";
               // $('#table_direccion').css("display", "none");
                table_direccion(cliente, idDeudor);
                }
            }
        });
	});*/
        
function agregarDireccionModal(){
     var cliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    var tDireccion = $('#tDireccion').val();
    var direccion_new = $('#direccion_new').val();
    var accion = "agraga_direccion";
   // alert("agraga_telef?cliente: "+cliente+"Deudor: "+idDeudor+"Telefono: "+tipoTelefono+"New Tele: "+newTelefono+accion);

    if (direccion_new === "") {
        alert("Ingrese una dirección válida");
        return;  
      }
var parametros = {
            "accion": accion,
            "idDeudor": idDeudor,
            "cliente": cliente,
            "tDireccion": tDireccion,
            "direccion_new": direccion_new
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {
                    alert(response);
                  document.getElementById("direccion_new").value = "";
               // $('#table_direccion').css("display", "none");
                table_direccion(cliente, idDeudor);
                }
            }
        });
    
}   
        
function table_direccion(cliente, id)
{
    jQuery("#pagedireccion").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>");
    jQuery("#pagedireccion").load("cobranzas?accion=listar_direccion&idDeudor=" + id + "&idCliente=" + cliente, {}, function () { });
}
/*
$('#agregaTelf').click(function(e){
   e.preventDefault();  
    var cliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    var tipoTelefono = $('#tTelefono').val();
    var newTelefono = $('#newTelefono').val();
    var accion = "agraga_telef";
    //alert("agraga_telef?cliente: "+cliente+"Deudor: "+idDeudor+"Telefono: "+tipoTelefono+"New Tele: "+newTelefono+accion);

    if (newTelefono === "") {
        alert("Ingrese un numero de telefono");
        return;  
      }
var parametros = {
            "accion": accion,
            "idDeudor": idDeudor,
            "cliente": cliente,
            "tipoTelefono": tipoTelefono,
            "newTelefono": newTelefono
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {
                    alert(response);
                      document.getElementById("newTelefono").value = "";
              //  $('#table_telefono').css("display", "none");
                table_telefono(cliente, idDeudor);
                }
                
            }
        });





});
*/
function agregarTelefonosModal(){
    var cliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    var tipoTelefono = $('#tTelefono').val();
    var newTelefono = $('#newTelefono').val();
    var accion = "agraga_telef";
    //alert("agraga_telef?cliente: "+cliente+"Deudor: "+idDeudor+"Telefono: "+tipoTelefono+"New Tele: "+newTelefono+accion);

    if (newTelefono === "") {
        alert("Ingrese un numero de telefono");
        return;  
      }
var parametros = {
            "accion": accion,
            "idDeudor": idDeudor,
            "cliente": cliente,
            "tipoTelefono": tipoTelefono,
            "newTelefono": newTelefono
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {
                    alert(response);
                      document.getElementById("newTelefono").value = "";
              //  $('#table_telefono').css("display", "none");
                table_telefono(cliente, idDeudor);
                }
                
            }
        });
}


function table_telefono(cliente, id)
{
    jQuery("#pagetelefono").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>");
    jQuery("#pagetelefono").load("cobranzas?accion=listar_telefono&idDeudor=" + id + "&idCliente=" + cliente, {}, function () { });
}
function ValidaSoloNumeros() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}

function addHtmlTelefonoRef() {
    
    var cont=$("#Cont").val();
    var a=document.getElementById("Cont");
    var cadena = [];
    var elementos="";
    //alert("addHtmlTelfRef "+cont);
    if(cont>0){
        var y=0;
       
        //var cadena="";
        
     
         for (y=0;y<cont;y++){ 
             
            var z=0;
              z=y+1;
          elementos+=" <div class='form-group'> \n\
                             <div class='col-lg-3'> \n\
                                <select class=' form-control' name='tipo_tel_ref' id='tReferenciaRef"+z+"'>\n\
                                    <option value='1' >Domicilio</option>\n\
                                    <option value='2' >Trabajo</option>\n\
                                    <option value='3' >Celular</option>\n\
                                </select>\n\
                             </div>\n\
                             <div class='col-lg-3'>\n\
                                    <input type='text' class='form-control' id='new_telefono_ref"+z+"'  value='"+$("#new_telefono_ref"+z).val()+"'>\n\
                             </div>\n\
                       </div>";
          
           
         }
       
    }
    cont++;
    document.getElementById("addHtmlTelfRef").innerHTML="";
    
    document.getElementById("addHtmlTelfRef").innerHTML+=elementos+" <div class='form-group'> <div class='col-lg-3'> \n\
                                                            <select class=' form-control' id='tReferenciaRef"+cont+"' >\n\
                                                                <option value='1' >Domicilio </option>\n\
                                                                <option value='2' >Trabajo</option>\n\
                                                                <option value='3' >Celular</option>\n\
                                                            </select></div>\n\
                                                            <div class='col-lg-3'>\n\
                                                                <input maxlength='10' type='text' class='form-control'  onkeydown=solo_numeros('new_telefono_ref"+cont+"') id='new_telefono_ref"+cont+"'>\n\
                                                            </div>\n\
                                                            ";
    a.value=cont;                                                                               
  

  
  
}
function solo_numeros(id_telefono){
    var nombre_telefono=id_telefono;
    
   // alert("Estas aqui "+nombre_telefono);
    $("#"+nombre_telefono).validCampoFranz('0123456789');
    
}
function AddReferencias() {
 var cont= $("#Cont").val();
 var cliente = $('#idcliente').val();
 var idDeudor = $('#id').val();
 var nombre_ref=$("#nombre_ref").val();
 var TipoRef=$("#IdtReferencia").val();
 
 var accion = "addReferncia";
 if(nombre_ref===""){
     alert("Debe Ingresar el nombre de la referencia.");
     return;
 }
 
 if(cont>0){
     //alert("ok1"+cont+"Cliente: "+cliente+" deudor: "+idDeudor+" nombre_ref: "+nombre_ref+" TipoRef: "+TipoRef);
    //    return;
     var parametros = {
            "accion": accion,
            "idDeudor": idDeudor,
            "cliente": cliente,
            "nombre_ref": nombre_ref,
            "TipoRef": TipoRef
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {
                    var i=0;
                    cont++;
                    var IDReferenci=response.trim();
                    for (i=1;i<cont;i++){ 
                      var tipo_telef = $("#tReferenciaRef"+i).val();  
                      var NewTelefono = $("#new_telefono_ref"+i).val();
                     // alert("IDReferenci: "+IDReferenci+"cont: "+cont+"item: -- "+i+" --tipo tel: "+tipo_telef+"telefono: "+NewTelefono);
                                            
                      if ((typeof NewTelefono !== 'undefined')|| (!NewTelefono.length)||(!NewTelefono)){
                          
                       NewTelefonoReferencia(response,tipo_telef,NewTelefono);
                      }
                    }
                  alert("Referencia Ingresada exitosamente...")
                }
                
            }
        });
     
 }else{
     alert("Debe registrar un número de Teléfono");
 }
  
 
    
    
}




function NewTelefonoReferencia(idReferencia1,tipoTelefono1,newTelefono1){

    var accion = "agraga_telef_ref";
    var idReferencia=idReferencia1;
    var tipoTelefono=tipoTelefono1;
    var newTelefono=newTelefono1;
 //   alert("accion "+accion+" idReferencia: "+idReferencia+" tipoTelefono: "+tipoTelefono+"  newTelefono: "+newTelefono);


    if (typeof newTelefono == 'undefined'){
        alert("Ingrese un numero de telefono");
        return;  
     }
var parametros = {
            "accion": accion,
            "idReferencia": idReferencia,
            "tipoTelefono": tipoTelefono,
            "newTelefono": newTelefono
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {               
                
            }
        });

    
 
    
    
    
}
function MuestraDatosReferencias(){
    var accion = "tablaReferencia";
    var idCliente = $('#idcliente').val();
    var idDeudor = $('#id').val();
    
    var parametros = {
            "accion": accion,
            "idCliente": idCliente,
            "idDeudor": idDeudor
          
        };
        $.ajax({
            data: parametros,
            url: 'cobranzas',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {  
                var tablaString="";
                tablaString= response.toString();
                document.getElementById("DatosReferencias").innerHTML="";
                document.getElementById("DatosReferencias").innerHTML+=tablaString;
                
                
            }
        });
    
}

$("#listoModal").click(function(e){
   e.preventDefault(); 
   MuestraDatosReferencias();
});



$("#datepicker2").mask("9999-99-99", {

    // Generamos un evento en el momento que se rellena
    completed:function(){
        $("#datepicker2").addClass("ok");
    }
});
$("#datepicker").mask("9999-99-99", {

    // Generamos un evento en el momento que se rellena
    completed:function(){
        $("#datepicker2").addClass("ok");
    }
});
$("#hora").mask("99:99", {

    // Generamos un evento en el momento que se rellena
    completed:function(){
        $("#hora").addClass("ok");
    }
});




function existeFecha(fecha){
      var fechaf = fecha.split("-");
      var year = fechaf[0];
      var month = fechaf[1];
      var day = fechaf[2];
      var date = new Date(year,month,'0');
     // console.log("existe "+date);
      //console.log("existe 2"+date.getDate());
      //console.log("existe 2"+day);
      if((day-0)>(date.getDate()-0)){
            return false;
      }
      return true;
}
 
function existeFecha2 (fecha) {
        var fechaf = fecha.split("-");
        var y = fechaf[0];
        var m = fechaf[1];
        var d = fechaf[2];
       // console.log("existe "+(new Date(y, m, 0)).getDate());
        return m > 0 && m < 13 && y > 0 && y < 32768 && d > 0 && d <= (new Date(y, m, 0)).getDate();
}   

function validarFechaMenorActual(date){
      var x=new Date();
      var fecha = date.split("-");
      x.setFullYear(fecha[0],fecha[1]-1,fecha[2]);
      //console.log("existe v: "+x);
      var today = new Date();
 
      if (x >= today)
        return false;
      else
        return true;
}
function validarFormatoFecha(campo) {
      var RegExPattern = /^\d{2,4}\-\d{1,2}\-\d{1,2}$/;
      if ((campo.match(RegExPattern)) && (campo!='')) {
            return true;
      } else {
            return false;
      }
}

function verificaFecha(){
  //  console.log("valida");
    var fecha = $("#datepicker2").val();
    //  console.log("fecha: "+fecha);
        var MsgValFecha=document.getElementById("MsgValFecha");  
         document.getElementById("MsgValFecha").innerHTML="";
    if(validarFormatoFecha(fecha)){
          if(existeFecha(fecha)){            
                      if(validarFechaMenorActual(fecha)){
               // alert("La fecha introducida es correcta.");
                     // console.log("La fecha introducida es correcta y es menor.");
                      document.getElementById("MsgValFecha").innerHTML+="La fecha introducida es correcta y es menor."; 
                    MsgValFecha.style.color="#f00";
                    MsgValFecha.style.display = '';
                        }else{
                             console.log("La fecha introducida es correcta y es mayor.");
                        }
          }else{
                //alert("La fecha introducida no existe.");
                     // console.log("La fecha introducida no existe.");
                               document.getElementById("MsgValFecha").innerHTML+="La fecha introducida no existe."; 
                    MsgValFecha.style.color="#f00";
                    MsgValFecha.style.display = '';
          }
    }else{
          //alert("El formato de la fecha es incorrecto.");
             // console.log("El formato de la fecha es incorrecto.");
                       document.getElementById("MsgValFecha").innerHTML+="El formato de la fecha es incorrecto."; 
                    MsgValFecha.style.color="#f00";
                    MsgValFecha.style.display = '';
    }
   
    
    
}

function verificaFecha2(){
  //  console.log("valida");
    var fecha = $("#datepicker").val();
    //  console.log("fecha: "+fecha);
        var MsgValFecha=document.getElementById("fechaCompro");  
         document.getElementById("fechaCompro").innerHTML="";
    if(validarFormatoFecha(fecha)){
          if(existeFecha(fecha)){            
                      if(validarFechaMenorActual(fecha)){
               // alert("La fecha introducida es correcta.");
                     // console.log("La fecha introducida es correcta y es menor.");
                      document.getElementById("fechaCompro").innerHTML+="La fecha de Compromisos de Pago tiene que se igual o mayor a la fecha actual"; 
                    MsgValFecha.style.color="#f00";
                    MsgValFecha.style.display = '';
                        }else{
                             console.log("La fecha introducida es correcta y es mayor.");
                        }
          }else{
                //alert("La fecha introducida no existe.");
                     // console.log("La fecha introducida no existe.");
                               document.getElementById("fechaCompro").innerHTML+="La fecha introducida no existe."; 
                    MsgValFecha.style.color="#f00";
                    MsgValFecha.style.display = '';
          }
    }else{
          //alert("El formato de la fecha es incorrecto.");
             // console.log("El formato de la fecha es incorrecto.");
                       document.getElementById("fechaCompro").innerHTML+="El formato de la fecha es incorrecto."; 
                    MsgValFecha.style.color="#f00";
                    MsgValFecha.style.display = '';
    }
   
    
    
}
 function validaHora(){
      var hora = $("#hora").val();
       var horaf = hora.split(":");
        var hh = horaf[0];
        var mm = horaf[1];
        var mensaje=null;
        // console.log("hora: "+hh+" minutos "+mm);
          var MsgValFechaHora=document.getElementById("MsgValHora");  
          document.getElementById("MsgValHora").innerHTML="";
      if(hh>=0 && hh<=23){
           if(mm>=0 && mm<=59){
         //  console.log("El formato de la Hora es correcto.");
           mensaje="El formato de la Hora es correcto.";
            //document.getElementById("MsgValFechaHora").innerHTML+=mensaje; 
            }else{
            //    console.log("El formato de la Hora es incorrecto.");
                   mensaje="El formato de la Hora es incorrecto.";
                    document.getElementById("MsgValHora").innerHTML+=mensaje; 
                    MsgValFechaHora.style.color="#f00";
                    MsgValFechaHora.style.display = '';
            }
      }else{
         //  console.log("El formato de la Hora es incorrecto.");
              mensaje="El formato de la Hora es incorrecto.";
               document.getElementById("MsgValHora").innerHTML+=mensaje; 
               MsgValFechaHora.style.color="#f00";
       MsgValFechaHora.style.display = '';
      }
     verificaFecha();
     
 }
 
 function verificaFecha3(nameInput){
    var fecha = $("#"+nameInput).val();       
    if(validarFormatoFecha(fecha)){
          if(existeFecha(fecha)){            
            if(validarFechaMenorActual(fecha)){
                  return 1;
              }else{
                   return 2;
              }
          }else{
            return 3;
          }
    }else{
        return 4;
    }
}

function AddTelModal(){
    var AddTelefono="<div id='agrega_datos2' class='modal fade' id='exampleModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel'> "+
                                       " <div class='modal-dialog' role='document'>"+
                                       "   <div class='modal-content'>"+
                                        "    <div class='modal-header'>"+
                                       "       <button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"+
                                      "        <h4 class='modal-title' id='exampleModalLabel'>Agregar Datos:  <c:out value='${cobro.getNombres()} ${cobro.getApellidos()}'/></h4>"+
                                       "     </div>"+
                                   "         <div class='modal-body'>"+
                                      "          <label>INGRESE NUEVO NÚMERO TELEFONICO:</label>"+
                                         "      <form action='#'  class='form-horizontal' role='form'>  "   +                                             
                                        "        <div class='form-group'>"+
                                            "         <div class='col-lg-3'>"+
                                             "           <select class='form-control' name='tipo_tel' id='tTelefono' >"+
                                               "             <option value='1' >Domicilio</option>"+
                                                  "          <option value='2' >Trabajo</option>"+
                                                  "          <option value='3' >Celular</option>   "    +                                     
                                                   "     </select>"+
                                                  "  </div>"+
                                                   " <div class='col-lg-7'>"+
                                                   "     <input type='text' class='form-control' id='newTelefono' onkeypress='ValidaSoloNumeros()'>   "+
                                                "    </div>  "+
                                                 "   <div class='col-lg-1'>"+
                                                  "      <button type='button' onclick='agregarTelefonosModal()' class='btn btn-success'>Agregar</button> " +
                                                  "  </div>  "      +                               
                                              "  </div>  </div>"+
                                         "   <div class='modal-footer'>"+
                                            "  <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"+
                                         "   </div>"+
                                       "   </div>"+
                                      "  </div>"+
                                     " </div>" ;
                document.getElementById("modalADDTel").innerHTML = AddTelefono; 
 $("#agrega_datos2").modal();
   $('#newTelefono').validCampoFranz('0123456789');    
    
}

function AddDirModal(){
    var AddDireccion="<div id='agrega_direccion' class='modal fade' id='exampleModal' tabindex='-1' role='dialog' aria-labelledby='exampleModalLabel'> "+
                                       " <div class='modal-dialog' role='document'>"+
                                         " <div class='modal-content'>"+
                                           " <div class='modal-header'>"+
                                            "  <button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"+
                                            "  <h4 class='modal-title' id='exampleModalLabel'>Agregar Datos:  <c:out value='${cobro.getNombres()} ${cobro.getApellidos()}'/></h4>"+
                                          "  </div>"+
                                           " <div class='modal-body'>       "      +                                                                                 
                                            
                                             "    <div class='row'><div class='col-sm-9'><dt>INGRESE NUEVA DIRECCIÓN:</dt></div>"+
                                             "<div class='col-sm-1'><dt style='color:#F5A9A9' id='contador_direccion'>300</dt></div></div>"+
                                           "      <form action='#' class='form-horizontal' role='form'>  "+
                                            "    <div class='form-group'>"+
                                              "        <div class='col-lg-3'>"+
                                                        "    <select class=' form-control' name='tipo_tel' id='tDireccion' >"+
                                                              "    <option value='1' >Domicilio</option>"+
                                                                "  <option value='2' >Trabajo</option>         "   +                              
                                                         " </select>"+
                                                     " </div>"+
                                                 "    <div class='col-lg-7'>              "   +                         
                                                   "     <textarea maxlength='300' class='form-control input-sm' rows='2' id='direccion_new'></textarea>"+
                                                    " </div>   "+
                                                  "   <div class='col-lg-1'>      "        +                            
                                                     "   <button type='button'  onclick='agregarDireccionModal()' class='btn btn-success'>Agregar</button>"+
                                                  "   </div>  "+
                                              "  </div>    "+
                                            "  </form> "+
                                            "</div>"+
                                           " <div class='modal-footer'>"+
                                           "   <button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>"+
                                           " </div>"+
                                        "  </div>"+
                                      "  </div>"+
                                     " </div>" ;
                document.getElementById("modalDireccion").innerHTML = AddDireccion; 
                 var max_chars = 300;

                    $('#max').html(max_chars);

                    $('#direccion_new').keyup(function() {
                        var chars = $(this).val().length;
                        var diff = max_chars - chars;
                        $('#contador_direccion').html(diff);   
                    });
 $("#agrega_direccion").modal();
   $('#direccion_new').validCampoFranz('abcdefghijklmnñopqrstuvwxyzáéíóúüABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚÜ0123456789/-# ');    
    
}