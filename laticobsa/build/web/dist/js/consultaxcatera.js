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

 $("#consul_cartera").DataTable({
                    "paging": true,
                    "lengthChange": false,
                    "lengthMenu": [25],
                    "searching": true,
                    "ordering": false,
                    "info": false,
                    "autoWidth": false
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
    var accion="filtrosDiasMora";
   
    if(orden_dia==="0" || orden_dia===""){
       document.getElementById("IdDiasMora").value="1"; //ascendente    Menor a Mayor      
     orden_dia=document.getElementById("IdDiasMora").value;
    }else{
         document.getElementById("IdDiasMora").value="0";   //descendente    Mayor a Menor  
    orden_dia=document.getElementById("IdDiasMora").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("DiasMoraID").disabled="true";
    var parametros = {
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
    });
    
    
    
}
function orderFchGestion(){
   var orden_Fecha=  document.getElementById("IdFechaUlt").value;
    var cartera=$("#cartera").val();
    var accion="filtrosDiasFecha";
   
    if(orden_Fecha==="0" || orden_Fecha===""){
       document.getElementById("IdFechaUlt").value="1"; //ascendente    Menor a Mayor      
     orden_Fecha=document.getElementById("IdFechaUlt").value;
    }else{
         document.getElementById("IdFechaUlt").value="0";   //descendente    Mayor a Menor  
    orden_Fecha=document.getElementById("IdFechaUlt").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("FechaID").disabled="true";
    var parametros = {
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
    }); 
}

function orderTotalVenc(){
   var orden_total=  document.getElementById("IdTotalVenc").value;
    var cartera=$("#cartera").val();
    var accion="filtrosTotalVenc";
   
    if(orden_total==="0" || orden_total===""){
       document.getElementById("IdTotalVenc").value="1"; //ascendente    Menor a Mayor      
     orden_total=document.getElementById("IdTotalVenc").value;
    }else{
         document.getElementById("IdTotalVenc").value="0";   //descendente    Mayor a Menor  
    orden_total=document.getElementById("IdTotalVenc").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("TotalID").disabled="true";
    var parametros = {
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
    }); 
}
function orderIdent(){
   var orden_IDE=  document.getElementById("IdIdentificacion").value;
    var cartera=$("#cartera").val();
    var accion="filtrosIDE";
   
    if(orden_IDE==="0" || orden_IDE===""){
       document.getElementById("IdIdentificacion").value="1"; //ascendente    Menor a Mayor      
     orden_IDE=document.getElementById("IdIdentificacion").value;
    }else{
         document.getElementById("IdIdentificacion").value="0";   //descendente    Mayor a Menor  
    orden_IDE=document.getElementById("IdIdentificacion").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("IdentificacionID").disabled="true";
    var parametros = {
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
    }); 
}
function orderNombre(){
   var orden_Nombre=  document.getElementById("IdNombres").value;
    var cartera=$("#cartera").val();
    var accion="filtrosNombre";
   
    if(orden_Nombre==="0" || orden_Nombre===""){
       document.getElementById("IdNombres").value="1"; //ascendente    Menor a Mayor      
     orden_Nombre=document.getElementById("IdNombres").value;
    }else{
         document.getElementById("IdNombres").value="0";   //descendente    Mayor a Menor  
    orden_Nombre=document.getElementById("IdNombres").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("NombresID").disabled="true";
    var parametros = {
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
    }); 
}
function orderPagos(){
   var orden_Pago=  document.getElementById("IdPagos").value;
    var cartera=$("#cartera").val();
    var accion="filtrosPagos";
   
    if(orden_Pago==="0" || orden_Pago===""){
       document.getElementById("IdPagos").value="1"; //ascendente    Menor a Mayor      
     orden_Pago=document.getElementById("IdPagos").value;
    }else{
         document.getElementById("IdPagos").value="0";   //descendente    Mayor a Menor  
    orden_Pago=document.getElementById("IdPagos").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("PagosID").disabled="true";
    var parametros = {
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
    }); 
}
function orderSaldo(){
   var orden_Saldo=  document.getElementById("IdSaldo").value;
    var cartera=$("#cartera").val();
    var accion="filtrosSaldo";
   
    if(orden_Saldo==="0" || orden_Saldo===""){
       document.getElementById("IdSaldo").value="1"; //ascendente    Menor a Mayor      
     orden_Saldo=document.getElementById("IdSaldo").value;
    }else{
         document.getElementById("IdSaldo").value="0";   //descendente    Mayor a Menor  
    orden_Saldo=document.getElementById("IdSaldo").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("SaldosID").disabled="true";
    var parametros = {
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
    }); 
}
function orderValorComp(){
   var orden_ValorComp=  document.getElementById("IdValorComp").value;
    var cartera=$("#cartera").val();
    var accion="filtrosValorComp";
   
    if(orden_ValorComp==="0" || orden_ValorComp===""){
       document.getElementById("IdValorComp").value="1"; //ascendente    Menor a Mayor      
     orden_ValorComp=document.getElementById("IdValorComp").value;
    }else{
         document.getElementById("IdValorComp").value="0";   //descendente    Mayor a Menor  
    orden_ValorComp=document.getElementById("IdValorComp").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("ValorCompID").disabled="true";
    var parametros = {
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
    }); 
}
function orderFechaComp(){
   var orden_FechaComp=  document.getElementById("IdFechaComp").value;
    var cartera=$("#cartera").val();
    var accion="filtrosFechaComp";
   
    if(orden_FechaComp==="0" || orden_FechaComp===""){
       document.getElementById("IdFechaComp").value="1"; //ascendente    Menor a Mayor      
     orden_FechaComp=document.getElementById("IdFechaComp").value;
    }else{
         document.getElementById("IdFechaComp").value="0";   //descendente    Mayor a Menor  
    orden_FechaComp=document.getElementById("IdFechaComp").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("FechaCompID").disabled="true";
    var parametros = {
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
    }); 
}
function orderUltima(){
   var orden_Ultima=  document.getElementById("IdUltima").value;
    var cartera=$("#cartera").val();
    var accion="filtrosUltima";
   
    if(orden_Ultima==="0" || orden_Ultima===""){
       document.getElementById("IdUltima").value="1"; //ascendente    Menor a Mayor      
     orden_Ultima=document.getElementById("IdUltima").value;
    }else{
         document.getElementById("IdUltima").value="0";   //descendente    Mayor a Menor  
    orden_Ultima=document.getElementById("IdUltima").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("UltimaID").disabled="true";
    var parametros = {
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
    }); 
}
function orderResultado(){
   var orden_Resultado=  document.getElementById("IdResultado").value;
    var cartera=$("#cartera").val();
    var accion="filtrosResultado";
   
    if(orden_Resultado==="0" || orden_Resultado===""){
       document.getElementById("IdResultado").value="1"; //ascendente    Menor a Mayor      
     orden_Resultado=document.getElementById("IdResultado").value;
    }else{
         document.getElementById("IdResultado").value="0";   //descendente    Mayor a Menor  
    orden_Resultado=document.getElementById("IdResultado").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("ResultadoID").disabled="true";
    var parametros = {
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
    }); 
}
function orderFechaUltPagos(){
   var orden_FechaUltPagos=  document.getElementById("IdFecUltPagos").value;
    var cartera=$("#cartera").val();
    var accion="filtrosFechaUltPagos";
   
    if(orden_FechaUltPagos==="0" || orden_FechaUltPagos===""){
       document.getElementById("IdFecUltPagos").value="1"; //ascendente    Menor a Mayor      
     orden_FechaUltPagos=document.getElementById("IdFecUltPagos").value;
    }else{
         document.getElementById("IdFecUltPagos").value="0";   //descendente    Mayor a Menor  
    orden_FechaUltPagos=document.getElementById("IdFecUltPagos").value;
    }
    $('#id_loader').css("display", "block");
    document.getElementById("FecUltPagosID").disabled="true";
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
    }); 
}