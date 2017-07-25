/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function ListarFiltro(strpg,strnumreg){
    var posicion = strpg;
    var registro = strnumreg;
   // alert(posicion);
    //alert(registro);
    var accion = "posicion";

    var parametros = {
        "posicion": posicion,
        "registro": registro,
        "accion": accion

    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {

            if (response) {
              // modulos_lista();
            }else{
                
                $('#consul_cartera').css("display", "none");
                $('#consultoria').css("display", "block");
               // modulos_lista();
            }
        }
    });
}
function modulos_lista()
{   
    jQuery("#pagetable").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
    jQuery("#pagetable").load("consultacartera?accion=listando",{},function(){ });
}
function validaDatos(cartera){
         if(cartera !== "" ){
                return true;

         }else{ MsgSalidaModalA("Debe seleccionar un cliente de la cartera");}        
   return false; 
}


$('#btnbuscar').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();

   if(validaDatos(cartera)){
       modulos_asignados(cartera);
   }
    
});
function modulos_asignados(cartera)
{   
    jQuery("#pagetable").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
    jQuery("#pagetable").load("consultacartera?accion=listar_datos&cartera="+cartera,{},function(){ });
}

$('#btnordenAsc').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();
   var accion = "ordenAsc";
   var opcion=2;
   var parametros = {
        "cartera": cartera,
        "opcion": opcion,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                document.getElementById("bodytable").innerHTML = "";
                document.getElementById("bodytable").innerHTML = response;
       
               
            }
        }
    });
});


              

$('#ordenDesc').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();
   var accion = "ordenDesc";
   var opcion=0;
   var parametros = {
        "cartera": cartera,
        "opcion": opcion,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                
                document.getElementById("bodytable").innerHTML = "";
                document.getElementById("bodytable").innerHTML = response;
                
            }
        }
    });
});
//
$('#btnordenAsc1').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();
   var accion = "ordenAsc";
   var opcion=3;
   var parametros = {
        "cartera": cartera,
        "opcion": opcion,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                document.getElementById("bodytable").innerHTML = "";
                document.getElementById("bodytable").innerHTML = response;
                var x = document.getElementById("bodytable");
          
            }
        }
    });
});

$('#btnordenDesc1').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();
   var accion = "ordenDesc";
   var opcion=4;
   var parametros = {
        "cartera": cartera,
        "opcion": opcion,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                
                document.getElementById("bodytable").innerHTML = "";
                document.getElementById("bodytable").innerHTML = response;
                
            }
        }
    });
});  

$('#btnordenAsc2').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();
   var accion = "ordenAsc";
   var opcion=6;
   var parametros = {
        "cartera": cartera,
        "opcion": opcion,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                document.getElementById("bodytable").innerHTML = "";
                document.getElementById("bodytable").innerHTML = response;
                var x = document.getElementById("bodytable");
                
            }
        }
    });
});

$('#btnordenDesc2').click(function(e){
   e.preventDefault();
   var cartera = $("#cartera").val();
   var accion = "ordenDesc";
   var opcion=5;
   var parametros = {
        "cartera": cartera,
        "opcion": opcion,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                
                document.getElementById("bodytable").innerHTML = "";
                document.getElementById("bodytable").innerHTML = response;
                
            }
        }
    });
});    


function orderDiasMora(){
    var orden_dia=  document.getElementById("IdDiasMora").value;
    var cartera=$("#cartera").val();
   // var accion="filtrosDiasMora";
   var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
   
    if(orden_dia==="0" || orden_dia===""){
       document.getElementById("IdDiasMora").value="1"; //ascendente    Menor a Mayor      
     orden_dia=document.getElementById("IdDiasMora").value;
     order_by = " ORDER BY s.dias_mora ASC";
    }else{
         document.getElementById("IdDiasMora").value="0";   //descendente    Mayor a Menor  
    orden_dia=document.getElementById("IdDiasMora").value;
    order_by = " ORDER BY s.dias_mora DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("DiasMoraID").disabled="true";
    
            sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("DiasMoraID").disabled="false";
    /*var parametros = {
        "orden_dia": orden_dia,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("DiasMoraID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    });*/
    
    
    
}
function orderFchGestion(){
   var orden_Fecha=  document.getElementById("IdFechaUlt").value;
    var cartera=$("#cartera").val();
   // var accion="filtrosDiasFecha";
   
   var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
   
    if(orden_Fecha==="0" || orden_Fecha===""){
       document.getElementById("IdFechaUlt").value="1"; //ascendente    Menor a Mayor      
     orden_Fecha=document.getElementById("IdFechaUlt").value;
      order_by = " ORDER BY s.fech_ultima_gestion ASC";
    }else{
         document.getElementById("IdFechaUlt").value="0";   //descendente    Mayor a Menor  
    orden_Fecha=document.getElementById("IdFechaUlt").value;
     order_by = " ORDER BY s.fech_ultima_gestion DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("FechaID").disabled="true";
    
        sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("FechaID").disabled="false";
    /*var parametros = {
        "orden_Fecha": orden_Fecha,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("FechaID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}

function orderTotalVenc(){
   var orden_total=  document.getElementById("IdTotalVenc").value;
    var cartera=$("#cartera").val();
    //var accion="filtrosTotalVenc";
   
   var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
   
    if(orden_total==="0" || orden_total===""){
       document.getElementById("IdTotalVenc").value="1"; //ascendente    Menor a Mayor      
     orden_total=document.getElementById("IdTotalVenc").value;
      order_by = " ORDER BY s.total_vencidos ASC";
    }else{
         document.getElementById("IdTotalVenc").value="0";   //descendente    Mayor a Menor  
    orden_total=document.getElementById("IdTotalVenc").value;
     order_by = " ORDER BY s.total_vencidos DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("TotalID").disabled="true";
    
    sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("TotalID").disabled="false";
   /* var parametros = {
        "orden_total": orden_total,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("TotalID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderIdent(){
   var orden_IDE=  document.getElementById("IdIdentificacion").value;
    var cartera=$("#cartera").val();
    //var accion="filtrosIDE";
    var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    if(orden_IDE==="0" || orden_IDE===""){
       document.getElementById("IdIdentificacion").value="1"; //ascendente    Menor a Mayor      
     orden_IDE=document.getElementById("IdIdentificacion").value;
     order_by = " ORDER BY s.identificacion ASC";
    }else{
         document.getElementById("IdIdentificacion").value="0";   //descendente    Mayor a Menor  
    orden_IDE=document.getElementById("IdIdentificacion").value;
    order_by = " ORDER BY s.identificacion DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("IdentificacionID").disabled="true";
   
     sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("IdentificacionID").disabled="false";
    /* var parametros = {
        "orden_IDE": orden_IDE,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("IdentificacionID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderNombre(){
   var orden_Nombre=  document.getElementById("IdNombres").value;
    var cartera=$("#cartera").val();
    //var accion="filtrosNombre";
    var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
   
    if(orden_Nombre==="0" || orden_Nombre===""){
       document.getElementById("IdNombres").value="1"; //ascendente    Menor a Mayor      
     orden_Nombre=document.getElementById("IdNombres").value;
      order_by = " ORDER BY s.nombres_completo ASC";
    }else{
         document.getElementById("IdNombres").value="0";   //descendente    Mayor a Menor  
    orden_Nombre=document.getElementById("IdNombres").value;
     order_by = " ORDER BY s.nombres_completo DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("NombresID").disabled="true";
    
    
     sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("NombresID").disabled="false";
    
    /*var parametros = {
        "orden_Nombre": orden_Nombre,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("NombresID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderPagos(){
   var orden_Pago=  document.getElementById("IdPagos").value;
    var cartera=$("#cartera").val();
   // var accion="filtrosPagos";
     var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    if(orden_Pago==="0" || orden_Pago===""){
       document.getElementById("IdPagos").value="1"; //ascendente    Menor a Mayor      
     orden_Pago=document.getElementById("IdPagos").value;
     order_by = " ORDER BY s.pagos ASC";
    }else{
         document.getElementById("IdPagos").value="0";   //descendente    Mayor a Menor  
    orden_Pago=document.getElementById("IdPagos").value;
    order_by = " ORDER BY s.pagos DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("PagosID").disabled="true";
    
    
     sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("PagosID").disabled="false";
    /*var parametros = {
        "orden_Pago": orden_Pago,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("PagosID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderSaldo(){
   var orden_Saldo=  document.getElementById("IdSaldo").value;
    var cartera=$("#cartera").val();
   // var accion="filtrosSaldo";
     var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
   
   
    if(orden_Saldo==="0" || orden_Saldo===""){
       document.getElementById("IdSaldo").value="1"; //ascendente    Menor a Mayor      
     orden_Saldo=document.getElementById("IdSaldo").value;
     order_by = " ORDER BY s.saldo ASC";
    }else{
         document.getElementById("IdSaldo").value="0";   //descendente    Mayor a Menor  
    orden_Saldo=document.getElementById("IdSaldo").value;
    order_by = " ORDER BY s.saldo DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("SaldosID").disabled="true";
   
      sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("SaldosID").disabled="false";
    
    
    
    /* var parametros = {
        "orden_Saldo": orden_Saldo,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("SaldosID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderValorComp(){
   var orden_ValorComp=  document.getElementById("IdValorComp").value;
    var cartera=$("#cartera").val();
   // var accion="filtrosValorComp";
    var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    if(orden_ValorComp==="0" || orden_ValorComp===""){
       document.getElementById("IdValorComp").value="1"; //ascendente    Menor a Mayor      
     orden_ValorComp=document.getElementById("IdValorComp").value;
     order_by = " ORDER BY s.valor_compro ASC";
    }else{
         document.getElementById("IdValorComp").value="0";   //descendente    Mayor a Menor  
    orden_ValorComp=document.getElementById("IdValorComp").value;
    order_by = " ORDER BY s.valor_compro DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("ValorCompID").disabled="true";
   
     sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("ValorCompID").disabled="false";
    
    
    /* var parametros = {
        "orden_ValorComp": orden_ValorComp,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("ValorCompID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderFechaComp(){
   var orden_FechaComp=  document.getElementById("IdFechaComp").value;
    var cartera=$("#cartera").val();
    //var accion="filtrosFechaComp";
   var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    if(orden_FechaComp==="0" || orden_FechaComp===""){
       document.getElementById("IdFechaComp").value="1"; //ascendente    Menor a Mayor      
       orden_FechaComp=document.getElementById("IdFechaComp").value;
        order_by = " ORDER BY s.fecha_comp ASC";
    }else{
         document.getElementById("IdFechaComp").value="0";   //descendente    Mayor a Menor  
        orden_FechaComp=document.getElementById("IdFechaComp").value;
         order_by = " ORDER BY s.fecha_comp DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("FechaCompID").disabled="true";
   
    sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("FechaCompID").disabled="false";
    
    
    /*var parametros = {
        "orden_FechaComp": orden_FechaComp,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("FechaCompID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderUltima(){
   var orden_Ultima=  document.getElementById("IdUltima").value;
    var cartera=$("#cartera").val();
   // var accion="filtrosUltima";
    var order_by="";
    var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    if(orden_Ultima==="0" || orden_Ultima===""){
       document.getElementById("IdUltima").value="1"; //ascendente    Menor a Mayor      
       orden_Ultima=document.getElementById("IdUltima").value;
       order_by = " ORDER BY s.ultima_gestion ASC";
    }else{
         document.getElementById("IdUltima").value="0";   //descendente    Mayor a Menor  
         orden_Ultima=document.getElementById("IdUltima").value;
         order_by = " ORDER BY s.ultima_gestion DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("UltimaID").disabled="true";
    
     sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("UltimaID").disabled="false";
    /*var parametros = {
        "orden_Ultima": orden_Ultima,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("UltimaID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderResultado(){
   var orden_Resultado=  document.getElementById("IdResultado").value;
    var cartera=$("#cartera").val();
    var accion="filtrosResultado";
    var order_by="";
   var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    if(orden_Resultado==="0" || orden_Resultado===""){
       document.getElementById("IdResultado").value="1"; //ascendente    Menor a Mayor      
     orden_Resultado=document.getElementById("IdResultado").value;
        order_by = " ORDER BY s.resultado_gestion ASC";
    }else{
         document.getElementById("IdResultado").value="0";   //descendente    Mayor a Menor  
    orden_Resultado=document.getElementById("IdResultado").value;
       order_by = " ORDER BY s.resultado_gestion DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("ResultadoID").disabled="true";
    
    sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("ResultadoID").disabled="false";
    /*var parametros = {
        "orden_Resultado": orden_Resultado,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("ResultadoID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}
function orderFechaUltPagos(){
   var orden_FechaUltPagos=  document.getElementById("IdFecUltPagos").value;
    var cartera=$("#cartera").val();
    var accion="filtrosFechaUltPagos";
   var order_by="";
   var sqlQuery=$("#input_query").val();
   
    if(sqlQuery===""){
         MsgSalidaModalA("Debe realizar la consulta en la pantalla de filtros");
    return;    
    }
    
    if(orden_FechaUltPagos==="0" || orden_FechaUltPagos===""){
      document.getElementById("IdFecUltPagos").value="1"; //ascendente    Menor a Mayor      
     orden_FechaUltPagos=document.getElementById("IdFecUltPagos").value;
      order_by = " ORDER BY s.fecha_ult_pagos ASC";
    }else{
         document.getElementById("IdFecUltPagos").value="0";   //descendente    Mayor a Menor  
    orden_FechaUltPagos=document.getElementById("IdFecUltPagos").value;
     order_by = " ORDER BY s.fecha_ult_pagos DESC";
    }
    $('#id_loader').css("display", "block");
    document.getElementById("FecUltPagosID").disabled="true";
    
    sqlQuery=sqlQuery+order_by;
    console.log(sqlQuery);
    //realiza la consulta
    consulta_query(sqlQuery,cartera);
    document.getElementById("FecUltPagosID").disabled="false";
    /*
    var parametros = {
        "orden_FechaUltPagos": orden_FechaUltPagos,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
                $('#id_loader').css("display", "none");
             document.getElementById("FecUltPagosID").disabled="false";
            var respuesta=response.toString();
              document.getElementById("bodytable").innerHTML = "";
              document.getElementById("bodytable").innerHTML = respuesta;
        }
    }); */
}



function consulta_filtro_cartera(){

    var pagos_ini=$('#pagos').val();
    var pagos_fin=$('#pagos1').val();
    var tvencido_ini=$('#tvencido').val();
    var tvencido_fin=$('#tvencido1').val();
    var vcompromiso_ini=$('#vcompromiso').val();
    var vcompromiso_fin=$('#vcompromiso1').val();
    var saldos_ini=$('#saldos').val();
    var saldos_fin=$('#saldos1').val();
    var dia_mora_ini=$('#dia_mora').val();
    var dia_mora_fin=$('#dia_mora1').val();
    var fUltimo_pago_ini=$('#datetimepicker10').val();
    var fUltimo_pago_fin=$('#datetimepicker11').val();
    var fUltimo_gestion_ini=$('#datetimepicker12').val();
    var fUltimo_gestion_fin=$('#datetimepicker13').val();
    var fUltimo_compromiso_ini=$('#datetimepicker14').val();
    var fUltimo_compromiso_fin=$('#datetimepicker15').val();
    var SelectTipoGestion=$("#tgestion").val();
    var SelectTipoResultado=$("#tresultado_gestion").val();
    var cartera = $("#cartera").val();
    var accion = "nuevaConsulta";
    var order_by=$('#order_by').val();
    var sqlQuery=" select * from vw_consulta_cartera s  where s.id_cliente=IDClienteConsulta and s.id_empleado=IDEmpleadoConsulta ";
    
    //
   var fmontos="";
   /*valida critrios de pagos*/
    if (pagos_ini.length !== 0 && pagos_fin.length !==0  && parseInt(pagos_ini) >= parseInt(pagos_fin)){        alert("El valor de PAGO Inicial debe ser MENOR a la PAGO final para realizar la consulta");        return; }
    if (pagos_ini.length !== 0 && pagos_fin.length !==0  && parseInt(pagos_ini) < parseInt(pagos_fin)){        fmontos+= " AND s.pagos >= "+pagos_ini+" AND s.pagos <= "+pagos_fin;    }
    if (pagos_ini.length !== 0 && pagos_fin.length === 0  && parseInt(pagos_ini) < 0){         alert("El valor en PAGOS ingresdo debe ser mayor a 0 para realizar la consulta.");        return;   }
    if (pagos_ini.length !== 0 && pagos_fin.length === 0  && parseInt(pagos_ini) > 0){        fmontos+= " AND s.pagos >= "+pagos_ini ;    }
    if (pagos_ini.length === 0 && pagos_fin.length !== 0  && parseInt(pagos_fin) < 0){         alert("El valor ingresdo en PAGOS debe ser mayo a 0 para realizar la consulta");        return;    }
    if (pagos_ini.length === 0 && pagos_fin.length !== 0  && parseInt(pagos_fin) > 0){        fmontos+= " AND s.pagos <= "+pagos_fin ;    }
     /*valida critrios de Total Deuda*/ 
    if (tvencido_ini.length !== 0 && tvencido_fin.length !==0  && parseInt(tvencido_ini) >= parseInt(tvencido_fin)){       alert("El valor de Deudoa Total Inicial debe ser MENOR a la PAGO final para realizar la consulta");        return; }
    if (tvencido_ini.length !== 0 && tvencido_fin.length !==0  && parseInt(tvencido_ini) < parseInt(tvencido_fin)){        fmontos+= " AND s.total_vencidos >= "+tvencido_ini+" AND s.total_vencidos <= "+tvencido_fin;    }
    if (tvencido_ini.length !== 0 && tvencido_fin.length === 0  && parseInt(tvencido_ini) < 0){        alert("El valor en Total Deuda ingresdo debe ser mayor a 0 para realizar la consulta.");        return;   }
    if (tvencido_ini.length !== 0 && tvencido_fin.length === 0  && parseInt(tvencido_ini) > 0){        fmontos+= " AND s.total_vencidos >= "+tvencido_ini ;    }
    if (tvencido_ini.length === 0 && tvencido_fin.length !== 0  && parseInt(tvencido_fin) < 0){        alert("El valor ingresdo en Total Deuda debe ser mayor a 0 para realizar la consulta");        return;    }
    if (tvencido_ini.length === 0 && tvencido_fin.length !== 0  && parseInt(tvencido_fin) > 0){        fmontos+= " AND s.pagtotal_vencidosos <= "+tvencido_fin ;    }
   
    /*valida critrios de Valor Compromiso*/ 
    if (vcompromiso_ini.length !== 0 && vcompromiso_fin.length !==0  && parseInt(vcompromiso_ini) >= parseInt(vcompromiso_fin)){       alert("El valor de Compromiso de Pago Inicial debe ser MENOR a  Compromiso de Pago final para realizar la consulta");        return; }
    if (vcompromiso_ini.length !== 0 && vcompromiso_fin.length !==0  && parseInt(vcompromiso_ini) < parseInt(vcompromiso_fin)){        fmontos+= " AND s.valor_compro >= "+vcompromiso_ini+" AND s.valor_compro <= "+vcompromiso_fin;    }
    if (vcompromiso_ini.length !== 0 && vcompromiso_fin.length === 0  && parseInt(vcompromiso_ini) < 0){        alert("El valor en Compromiso de Pago ingresdo debe ser mayor a 0 para realizar la consulta.");        return;   }
    if (vcompromiso_ini.length !== 0 && vcompromiso_fin.length === 0  && parseInt(vcompromiso_ini) > 0){        fmontos+= " AND s.valor_compro >= "+vcompromiso_ini ;    }
    if (vcompromiso_ini.length === 0 && vcompromiso_fin.length !== 0  && parseInt(vcompromiso_fin) < 0){        alert("El valor Compromiso de Pago Deuda debe ser mayor a 0 para realizar la consulta");        return;    }
    if (vcompromiso_ini.length === 0 && vcompromiso_fin.length !== 0  && parseInt(vcompromiso_fin) > 0){        fmontos+= " AND s.valor_compro <= "+vcompromiso_fin ;    }
  
     /*valida critrios de Saldos*/ 
    if (saldos_ini.length !== 0 && saldos_fin.length !==0  && parseInt(saldos_ini) >= parseInt(saldos_fin)){       alert("El valor de Saldo Inicial debe ser MENOR al Saldo final para realizar la consulta");        return; }
    if (saldos_ini.length !== 0 && saldos_fin.length !==0  && parseInt(saldos_ini) < parseInt(saldos_fin)){        fmontos+= " AND s.saldo >= "+saldos_ini+" AND s.saldo <= "+saldos_fin;    }
    if (saldos_ini.length !== 0 && saldos_fin.length === 0  && parseInt(saldos_ini) < 0){        alert("El valor Saldo ingresdo debe ser mayor a 0 para realizar la consulta.");        return;   }
    if (saldos_ini.length !== 0 && saldos_fin.length === 0  && parseInt(saldos_ini) > 0){        fmontos+= " AND s.saldo >= "+saldos_ini ;    }
    if (saldos_ini.length === 0 && saldos_fin.length !== 0  && parseInt(saldos_fin) < 0){        alert("El valor Saldo Deuda debe ser mayor a 0 para realizar la consulta");        return;    }
    if (saldos_ini.length === 0 && saldos_fin.length !== 0  && parseInt(saldos_fin) > 0){        fmontos+= " AND s.saldo <= "+saldos_fin ;    }
  
     /*valida critrios de Dias de Mora*/ 
    if (dia_mora_ini.length !== 0 && dia_mora_fin.length !==0  && parseInt(dia_mora_ini) >= parseInt(dia_mora_fin)){       alert("El valor de Dias Mora Inicial debe ser MENOR a Dias Mora final para realizar la consulta");        return; }
    if (dia_mora_ini.length !== 0 && dia_mora_fin.length !==0  && parseInt(dia_mora_ini) < parseInt(dia_mora_fin)){        fmontos+= " AND s.dias_mora >= "+dia_mora_ini+" AND s.dias_mora <= "+dia_mora_fin;    }
    if (dia_mora_ini.length !== 0 && dia_mora_fin.length === 0  && parseInt(dia_mora_ini) < 0){        alert("El valor Dias Mora ingresdo debe ser mayor a 0 para realizar la consulta.");        return;   }
    if (dia_mora_ini.length !== 0 && dia_mora_fin.length === 0  && parseInt(dia_mora_ini) > 0){        fmontos+= " AND s.dias_mora >= "+dia_mora_ini ;    }
    if (dia_mora_ini.length === 0 && dia_mora_fin.length !== 0  && parseInt(dia_mora_fin) < 0){        alert("El valor Dias Mora Deuda debe ser mayor a 0 para realizar la consulta");        return;    }
    if (dia_mora_ini.length === 0 && dia_mora_fin.length !== 0  && parseInt(dia_mora_fin) > 0){        fmontos+= " AND s.dias_mora <= "+dia_mora_fin ;    }
  
     /*valida critrios de Fecha Ultimo Pago*/ 
    if (fUltimo_pago_ini.length !== 0 && fUltimo_pago_fin.length !==0  && Date.parse(fUltimo_pago_ini) >= Date.parse(fUltimo_pago_fin)){       alert("La fecha de Ultimo Pago Inicial debe ser MENOR a la fecha de Ultimo Pago final para realizar la consulta");        return; }
    if (fUltimo_pago_ini.length !== 0 && fUltimo_pago_fin.length !==0  && Date.parse(fUltimo_pago_ini) < Date.parse(fUltimo_pago_fin)){        fmontos+= " AND s.fecha_ult_pagos >= '"+fUltimo_pago_ini+"' AND s.fecha_ult_pagos <= '"+fUltimo_pago_fin+"' ";    }
    if (fUltimo_pago_ini.length !== 0 && fUltimo_pago_fin.length === 0 ){ fmontos+= " AND s.fecha_ult_pagos >= '"+fUltimo_pago_ini+"' ";     }
    if (fUltimo_pago_ini.length === 0 && fUltimo_pago_fin.length !== 0 ){ fmontos+= " AND s.fecha_ult_pagos <= '"+fUltimo_pago_fin+"' ";    }
  
    /*valida critrios de Fecha Ultima Gestión*/ 
    if (fUltimo_gestion_ini.length !== 0 && fUltimo_gestion_fin.length !==0  && Date.parse(fUltimo_gestion_ini) >= Date.parse(fUltimo_gestion_fin)){       alert("La fecha de Ultimo Gestión Inicial debe ser MENOR a la fecha de Ultimo Gestión final para realizar la consulta");        return; }
    if (fUltimo_gestion_ini.length !== 0 && fUltimo_gestion_fin.length !==0  && Date.parse(fUltimo_gestion_ini) < Date.parse(fUltimo_gestion_fin)){        fmontos+= " AND s.fech_ultima_gestion >= '"+fUltimo_pago_ini+"' AND s.fech_ultima_gestion <= '"+fUltimo_gestion_fin+"' ";    }
    if (fUltimo_gestion_ini.length !== 0 && fUltimo_gestion_fin.length === 0 ){ fmontos+= " AND s.fech_ultima_gestion >= '"+fUltimo_gestion_ini+"' ";     }
    if (fUltimo_gestion_ini.length === 0 && fUltimo_gestion_fin.length !== 0 ){ fmontos+= " AND s.fech_ultima_gestion <= '"+fUltimo_gestion_fin+"' ";    }
  
    /*valida critrios de Fecha Ultima Compromiso*/ 
    if (fUltimo_compromiso_ini.length !== 0 && fUltimo_compromiso_fin.length !==0  && Date.parse(fUltimo_compromiso_ini) >= Date.parse(fUltimo_compromiso_fin)){       alert("La fecha de Compromiso inicial debe ser MENOR a la fecha de Compromiso final para realizar la consulta");        return; }
    if (fUltimo_compromiso_ini.length !== 0 && fUltimo_compromiso_fin.length !==0  && Date.parse(fUltimo_compromiso_ini) < Date.parse(fUltimo_compromiso_fin)){        fmontos+= " AND s.fecha_comp >='"+fUltimo_compromiso_ini+"' AND s.fecha_comp <= '"+fUltimo_compromiso_fin+"' ";    }
    if (fUltimo_compromiso_ini.length !== 0 && fUltimo_compromiso_fin.length === 0 ){ fmontos+= " AND s.fecha_comp >= '"+fUltimo_compromiso_ini+"'";     }
    if (fUltimo_compromiso_ini.length === 0 && fUltimo_compromiso_fin.length !== 0 ){ fmontos+= " AND s.fecha_comp <= '"+fUltimo_compromiso_fin+"' ";    }
  
//  alert(SelectTipoGestion);
//  return;
    if (SelectTipoGestion!== "0"){
       fmontos+= " AND s.ultima_gestion = '"+$('#tgestion').find('option:selected').text()+"'";         
    }  
    if (SelectTipoResultado!== "0"){
       fmontos+= " AND s.resultado_gestion = '"+$('#tresultado_gestion').find('option:selected').text()+"'";      
    } 
    
    if (order_by!==""){
        
       order_by= " ORDER BY s."+order_by+" DESC";
    }
    
       $('#id_loader').css("display", "block");
       //arma el query para la consula
    sqlQuery=sqlQuery+fmontos+order_by;
    document.getElementById("input_query").value = "";
    document.getElementById("input_query").value = sqlQuery;
   // alert(sqlQuery);
   var htmlTable="<table id='consul_cartera' class='table table-striped table-bordered dt-responsive nowrap table-hover' cellspacing='0' width='100%'><thead><tr bgcolor='#FBF5EF'><th class='col-sm-1 text-left hidden' style='color: #3c8dbc'>ID</th><th align='left' class='col-sm-1 text-left'><a id='IdentificacionID' onclick='orderIdent()'>Identificación</a></th><th class='col-sm-2 text-left'><a id='NombresID' onclick='orderNombre()'>Nombres</a></th>  <th class='col-sm-1 text-left'><a id='DiasMoraID' onclick='orderDiasMora()' >Días Mora</a></th> <th class='col-sm-1 text-right'><a id='TotalID' onclick='orderTotalVenc()' >Total Vnc</a></th> <th align='center' class='col-sm-1 text-right'><a id='PagosID' onclick='orderPagos()'>Pagos</a></th><th align='center' class='col-sm-1 text-right'><a id='FecUltPagosID' onclick='orderFechaUltPagos()'>Fecha Ult. Pagos</a></th><th align='rigth' class='col-sm-1 text-right'><a id='SaldosID' onclick='orderSaldo()'>Saldo</a></th><th align='center' class='col-sm-1 text-right'><a id='ValorCompID' onclick='orderValorComp()'>Valor Comp.</a></th> <th align='center' class='col-sm-2 text-center'><a id='FechaCompID' onclick='orderFechaComp()'>Fecha Comp.</a></th><th align='center' class='col-sm-3'><a id='FechaID' onclick='orderFchGestion()' >Fecha Ult. Gestión</a></th> <th align='center' class='col-sm-3'><a id='UltimaID' onclick='orderUltima()'>Ult. Gestión</a></th> <th align='center' class='col-sm-2'><a id='ResultadoID' onclick='orderResultado()'>Resultado Gestión</a></th></tr> </thead><tbody>";
     var parametros = {
        "sqlQuery":sqlQuery,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
             $('#id_loader').css("display", "none");
             if (response) {
              $("#consul_cartera").remove();           
              // $("#consul_cartera").append(response.toString());
           document.getElementById("tabla_div").innerHTML = "";
           document.getElementById("tabla_div").innerHTML = htmlTable+response.toString()+"</tbody></table>";
           datatableok();
            $('#det_filtro').modal('hide');   
            }      
        }
    });
    
 // alert(sqlQuery);
}

function consulta_query(sqlQuery,cartera){
    var accion="nuevaConsulta";
       var htmlTable="<table id='consul_cartera' class='table table-striped table-bordered dt-responsive nowrap table-hover' cellspacing='0' width='100%'><thead><tr bgcolor='#FBF5EF'><th class='col-sm-1 text-left hidden' style='color: #3c8dbc'>ID</th><th align='left' class='col-sm-1 text-left'><a id='IdentificacionID' onclick='orderIdent()'>Identificación</a></th><th class='col-sm-2 text-left'><a id='NombresID' onclick='orderNombre()'>Nombres</a></th>  <th class='col-sm-1 text-left'><a id='DiasMoraID' onclick='orderDiasMora()' >Días Mora</a></th> <th class='col-sm-1 text-right'><a id='TotalID' onclick='orderTotalVenc()' >Total Vnc</a></th> <th align='center' class='col-sm-1 text-right'><a id='PagosID' onclick='orderPagos()'>Pagos</a></th><th align='center' class='col-sm-1 text-right'><a id='FecUltPagosID' onclick='orderFechaUltPagos()'>Fecha Ult. Pagos</a></th><th align='rigth' class='col-sm-1 text-right'><a id='SaldosID' onclick='orderSaldo()'>Saldo</a></th><th align='center' class='col-sm-1 text-right'><a id='ValorCompID' onclick='orderValorComp()'>Valor Comp.</a></th> <th align='center' class='col-sm-2 text-center'><a id='FechaCompID' onclick='orderFechaComp()'>Fecha Comp.</a></th><th align='center' class='col-sm-3'><a id='FechaID' onclick='orderFchGestion()' >Fecha Ult. Gestión</a></th> <th align='center' class='col-sm-3'><a id='UltimaID' onclick='orderUltima()'>Ult. Gestión</a></th> <th align='center' class='col-sm-2'><a id='ResultadoID' onclick='orderResultado()'>Resultado Gestión</a></th></tr> </thead><tbody>";
     var parametros = {
        "sqlQuery":sqlQuery,
        "cartera": cartera,
        "accion": accion
    };
        $.ajax({
        data: parametros,
        url: 'consultacartera',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
             $('#id_loader').css("display", "none");
             if (response) {
              $("#consul_cartera").remove();           
              // $("#consul_cartera").append(response.toString());
           document.getElementById("tabla_div").innerHTML = "";
           document.getElementById("tabla_div").innerHTML = htmlTable+response.toString()+"</tbody></table>";
           datatableok();
               
            }      
        }
    });
    
}


function fnc_order_by(orden) {
    document.getElementById("order_by").value = "";
    document.getElementById("order_by").value = orden;
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
function existeFecha(fecha){
      var fechaf = fecha.split("-");
      var year = fechaf[0];
      var month = fechaf[1];
      var day = fechaf[2];
      var date = new Date(year,month,'0');
      if((day-0)>(date.getDate()-0)){
            return false;
      }
      return true;
}

function getTiposGestiones(){
document.getElementById("tgestion").innerHTML="";
document.getElementById("gestion").innerHTML="";
$("#tgestion").append($("<option>",{value:"0",text:"Seleccione Tipo Gestión"}));
$("#gestion").append($("<option>",{value:"0",text:"Seleccione Tipo Gestión"}));
    $.getJSON("consultacartera", {"accion" : "TiposGestiones"}, function(result){
          $.each(result.tipo_gestion, function(key, val){             
          // $("#tgestion").append('<option id="' + val.idTipoGestion + '">' + val.nombreTipoGestion +'</option>');
           $("#tgestion").append($("<option>",{value:val.idTipoGestion,text:val.nombreTipoGestion}));
           $("#gestion").append($("<option>",{value:val.idTipoGestion,text:val.nombreTipoGestion}));
          });
    });
    
   document.getElementById("tresultado_gestion").disabled=true;
   $("#tresultado_gestion").append($("<option>",{value:"0",text:"Seleccione Tipo Gestión"}));
   
    
}


function ConsultaTipoResultado(){
  var IdTipoGestion=$("#tgestion").val();
  var idcliente="";
   // if(IdTipoGestion===0){
   
     document.getElementById("tresultado_gestion").disabled=true;
     document.getElementById("tresultado_gestion").innerHTML="";
     $("#tresultado_gestion").append($("<option>",{value:"0",text:"Seleccione Tipo Gestión"}));  
  if(IdTipoGestion === 0 || IdTipoGestion === "0" ) {  
         return;
     }
  if(IdTipoGestion!==0){
      document.getElementById("tresultado_gestion").disabled=false;
      document.getElementById("tresultado_gestion").innerHTML="";
      $("#tresultado_gestion").append($("<option>",{value:"0",text:"Seleccione Tipo Resultado"}));
     $.getJSON("consultacartera", {"accion" : "TiposResulatdos","idcliente":idcliente}, function(result){
         console.log(result);
         console.log('size: '+result.tipos_resultado.tipos_resultado);
          $.each(result.tipos_resultado, function(key, val){             
           $("#tresultado_gestion").append($("<option>",{value:val.idTipoResultado,text:val.nombreTipoResultado}));
          });
    });
  }
    
}

function hidden_cartera_cliente(valor){
   
   if(valor==="true"){
       document.getElementById("cliente_cartera").style.display = 'none';
        document.getElementById("gestion_cliente").style.display = 'block';
  
       
   }
   if(valor==="false"){
         document.getElementById("cliente_cartera").style.display = 'block';
        document.getElementById("gestion_cliente").style.display = 'none'; 
   }
   
        

}
function datatableok(){
    console.log("consulta cartera");
           $("#consul_cartera").DataTable({
                    "paging": false,
                    "lengthChange": false,
                    "searching": true,
                    "ordering": false,
                    "info": false,
                    "autoWidth": true
                  }); 
        }