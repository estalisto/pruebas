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
                    "ordering": true,
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