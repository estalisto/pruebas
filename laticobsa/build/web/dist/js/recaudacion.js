/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function BuscarCuota() {
    var cartera = $('#cartera').val();
    var oficial = $('#oficial').val();
    var tipo = $('#t_identificacion').val();
    var ide = $('#identificacion').val();
    var nombres = $('#nombres').val();
    var accion = "cuota";

    if (oficial === "") {
        oficial = 0;
        var parametros = {
            "cartera": cartera,
            "oficial": oficial,
            "tipo": tipo,
            "ide": ide,
            "nombres": nombres,
            "accion": accion
        };
        $.ajax({
            data: parametros,
            url: 'recaudacion',
            type: 'GET',
            beforeSend: function () {
            },
            success: function (response) {

                if (response) {

                    var cadena = "";
                    cadena += "<div class='modal-dialog modal-lg' role='document'> \n\
                            <div class='modal-content'> \n\
                            <br><div class='box box-danger'> \n\
                            <div class='box-header with-border bg-yellow'> \n\
                            <h3 class='box-title'>Detalle Cuotas</h3> \n\
                            </div>  \n\
                            <div class='box-body' style='overflow-y:scroll;'> \n\
                            <table id='detalle_cuotas' class='table table-bordered table-hover'> \n\
                            <thead> \n\
                            <tr> \n\
                                    <th class='hidden'>idCuota</th> \n\
                                    <th>Artículo</th> \n\
                                    <th>Cuota</th> \n\
                                    <th>Interés</th> \n\
                                    <th>Capital </th> \n\
                                    <th>Mora Generada</th> \n\
                                    <th>Agregar</th> \n\
                                </tr> \n\
                            </thead> "
                            + response +
                            "</table> \n\
                                </div>";
                    cadena += "</div> \n\
                                    </div> \n\
                                </div> ";
                    document.getElementById("detalle_cuota").innerHTML = '';
                    document.getElementById("detalle_cuota").innerHTML += cadena;


                }
            }
        });
    }
        if (oficial !== "") {
        var parametros = {
        "cartera": cartera,
                "oficial": oficial,
                "tipo": tipo,
                "ide": ide,
                "nombres": nombres,
                "accion": accion
        };
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {

                var cadena = "";
                        cadena += "<div class='modal-dialog modal-lg' role='document'> \n\
                            <div class='modal-content'> \n\
                            <br><div class='box box-danger'> \n\
                            <div class='box-header with-border bg-yellow'> \n\
                            <h3 class='box-title'>Detalle Cuotas</h3> \n\
                            </div>  \n\
                            <div class='box-body' style='overflow-y:scroll;'> \n\
                            <table id='detalle_cuotas' class='table table-bordered table-hover'> \n\
                            <thead> \n\
                            <tr> \n\
                                    <th class='hidden'>idCuota</th> \n\
                                    <th>Artículo</th> \n\
                                    <th>Cuota</th> \n\
                                    <th>Interés</th> \n\
                                    <th>Capital </th> \n\
                                    <th>Mora Generada</th> \n\
                                    <th>Agregar</th> \n\
                                </tr> \n\
                            </thead> "
                        + response +
                        "</table> \n\
                                </div>";
                        cadena += "</div> \n\
                                    </div> \n\
                                </div> ";
                        document.getElementById("detalle_cuota").innerHTML = '';
                        document.getElementById("detalle_cuota").innerHTML += cadena;
                }
                }
        });
}
}
function Buscarecaudo() {
    var cartera = $('#cartera').val();
    var oficial = $('#oficial').val();
    var tipo = $('#t_identificacion').val();
    var ide = $('#identificacion').val();
    var nombres = $('#nombres').val();
    var accion = "recaudo";

    if ((oficial === "") && (nombres === "")) {
        oficial = 0;
        nombres = "N";
        if (cartera !== "") {
            if (tipo !== "") {
                if (ide !== "") {
                    var parametros = {
                        "cartera": cartera,
                        "oficial": oficial,
                        "tipo": tipo,
                        "ide": ide,
                        "nombres": nombres,
                        "accion": accion
                    };
                    $.ajax({
                        data: parametros,
                        url: 'recaudacion',
                        type: 'GET',
                        beforeSend: function () {
                        },
                        success: function (response) {

                            if (response) {
                                var separo = response.split("|");
                                var nombres = separo[0];
                                var id = separo[1];
                                var x = document.getElementById("nombres");
                                x.value = nombres;
                                var i = document.getElementById("idDeudor");
                                i.value = "";
                                i.value = parseInt(id);
                                document.getElementById("busc_cuota").disabled = false;
                            } else {
                                MsgSalidaModalA("No existe Deudor con esa Identificación");
                            }
                        }
                    });
                } else {
                    MsgSalidaModalA("Debe ingresar una identificación");
                }
            } else {
                MsgSalidaModalA("Debe elegir un tipo de identificación");
            }
        } else {
            MsgSalidaModalA("Debe elegir una cartera");
        }
    }

    if ((oficial !== "") && (nombres === "")) {
        
        nombres = "N";
        if (cartera !== "") {
            if (tipo !== "") {
                if (ide !== "") {
                    var parametros = {
                        "cartera": cartera,
                        "oficial": oficial,
                        "tipo": tipo,
                        "ide": ide,
                        "nombres": nombres,
                        "accion": accion
                    };
                    $.ajax({
                        data: parametros,
                        url: 'recaudacion',
                        type: 'GET',
                        beforeSend: function () {
                        },
                        success: function (response) {

                            if (response) {
                                var separo = response.split("|");
                                var nombres = separo[0];
                                var id = separo[1];
                                var x = document.getElementById("nombres");
                                x.value = nombres;
                                var i = document.getElementById("idDeudor");
                                i.value = "";
                                i.value = parseInt(id);
                                document.getElementById("busc_cuota").disabled = false;
                            } else {
                                MsgSalidaModalA("No existe Deudor con esa Identificación");
                            }
                        }
                    });
                } else {
                    MsgSalidaModalA("Debe ingresar una identificación");
                }
            } else {
                MsgSalidaModalA("Debe elegir un tipo de identificación");
            }
        } else {
            MsgSalidaModalA("Debe elegir una cartera");
        }
    }
    
    if ((tipo === "") && (ide === "") && (oficial === "")) {
        tipo = 0;
        ide = "N";
        oficial = 0;
        if (cartera !== "") {
            var separo = nombres.split("|");
            var nombres = $.trim(separo[1]);

            var parametros = {
                "cartera": cartera,
                "oficial": oficial,
                "tipo": tipo,
                "ide": ide,
                "nombres": nombres,
                "accion": accion
            };
            $.ajax({
                data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                    if (response) {
                        //alert(response);
                        var separo = response.split("|");
                        var iden = separo[0];
                        var tipo = separo[1];
                        var nom = separo[2];
                        var id = separo[3];
                        var x = document.getElementById("identificacion");
                        x.value = "";
                        x.value = iden;
                        var y = document.getElementById("t_identificacion");
                        y.value = "";
                        y.value = parseInt(tipo);
                        var z = document.getElementById("nombres");
                        z.value="";
                        z.value = nom;
                        var i = document.getElementById("idDeudor");
                        i.value = "";
                        i.value = parseInt(id);
                        document.getElementById("busc_cuota").disabled = false;
                    }
                }
            });
        } else {
            MsgSalidaModalA("Debe elegir una cartera");
        }
    }
    
    if ((tipo === "") && (ide === "") && (oficial !== "")) {
        tipo = 0;
        ide = "N";
        
        if (cartera !== "") {
            var separo = nombres.split("|");
            var nombres = $.trim(separo[1]);
            var parametros = {
                "cartera": cartera,
                "oficial": oficial,
                "tipo": tipo,
                "ide": ide,
                "nombres": nombres,
                "accion": accion
            };
            $.ajax({
                data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                    if (response) {
                        //alert(response);
                        var separo = response.split("|");
                        var iden = separo[0];
                        var tipo = separo[1];
                        var nom = separo[2];
                        var id = separo[3];
                        var x = document.getElementById("identificacion");
                        x.value = "";
                        x.value = iden;
                        var y = document.getElementById("t_identificacion");
                        y.value = "";
                        y.value = parseInt(tipo);
                        var z = document.getElementById("nombres");
                        z.value = "";
                        z.value = nom;
                        var i = document.getElementById("idDeudor");
                        i.value = "";
                        i.value = parseInt(id);
                        document.getElementById("busc_cuota").disabled = false;
                    }
                }
            });
        } else {
            MsgSalidaModalA("Debe elegir una cartera");
        }
    }
}
function validaselector() {
    var tipo = $("#t_identificacion").val();
    if (parseInt(tipo) === 1) {
        document.getElementById("identificacion").disabled = false;
        document.getElementById("identificacion").maxlength = "10";
    }
    if (parseInt(tipo) === 2) {
        document.getElementById("identificacion").disabled = false;
        document.getElementById("identificacion").maxlength = "13";
    }
    if ((parseInt(tipo) === 1) && (parseInt(tipo) === 2)) {
        document.getElementById("identificacion").disabled = true;
    }
}
function ValidaSoloNumeros() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}
function txNombres() {
    if ((event.keyCode !== 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
        event.returnValue = false;
}
$(document).ready(function () {
    $("#nombres").keyup(function () {

        $.get("recaudacion?accion=autocomplete", {company: $(this).val()}, function (data) {
            $("datalist").empty();
            $("datalist").html(data);

        });

    });
});
function Recaudacion(stridCuota) {
    var idCuota = stridCuota;
    var cont = $('#Cont').val();
    var accion = "listarCuota";
    var parametros = {
        "idCuota": idCuota,
        "cont": cont,
        "accion": accion
    };
    $.ajax({
        data: parametros,
        url: 'recaudacion',
        type: 'GET',
        beforeSend: function () {
        },
        success: function (response) {
            if (response) {
                var cadena = "";
                cadena += "<table  class='table table-responsive table-bordered'>"
                        + response +
                        "</table>";

                $('#table2').css("display", "none");
                document.getElementById("table1").innerHTML += cadena;
                var valorpagar = $('#valor_pagar_' + cont).val();
                var suma = $('#pago').val();
                for (var i = 0; i <= cont; i++) {
                   
                        var total = parseFloat(suma) + parseFloat($('#valor_pagar_' + i).val());
                        
                        if(parseInt(cont) === 0){
                            var v = document.getElementById("pago");
                            v.value = valorpagar;
                        }else{
                            var v = document.getElementById("pago");
                            v.value = "";
                            v.value = total;
                        }
                }
                cont++;
                var c = document.getElementById("Cont");
                c.value = cont; 
            }
        }
    });
     document.getElementById("recibido").disabled = false;
                document.getElementById("Guardado").disabled = false;
}
function Actualizar_saldo(strsaldo, strcont) {
    var saldo = strsaldo;
    var total_saldo = 0;
    var cont = strcont;//1
    var valor_pagar = $('#valor_pagar_' + cont).val();

    if (parseFloat(valor_pagar) === parseFloat(saldo)) {
        
        var x = document.getElementById("saldo_" + cont);
        x.value = 0.00;
        document.getElementById("saldo_" + cont).style.color = "#00a65a";
        
    } else {
        total_saldo = saldo - ($('#valor_pagar_' + cont).val());
        
        document.getElementById("saldo_" + cont).disabled = true;
        var x = document.getElementById("saldo_" + cont);
        x.value = "";
        x.value = total_saldo;
        if(parseFloat(total_saldo) < 0){
        document.getElementById("saldo_" + cont).style.color = "#f00";
        }
        }
        Suma_totales();
}


function Suma_totales() {

    var cont = $('#Cont').val();
    //alert(cont);
    var sum=0;
    var totales=0;
    for(sum=0;sum<=cont;sum++){
       //alert("variable:"+$('#valor_pagar_' + sum).val());
        if(($('#valor_pagar_' + sum).val()) !== undefined){
           
        totales=totales+ parseFloat($('#valor_pagar_' + sum).val());   
       } 
    }
    
     var v = document.getElementById("pago");
        v.value = "";
        v.value = totales;
    var t = document.getElementById("totalpago");
    t.value = "";
    t.value = totales;
}
function CalculoCambio(){
    var valorpagar=$('#pago').val();;
    var cambio= ($('#recibido').val()) - valorpagar;
     var v = document.getElementById("cambio");
      // v.value = "";
       v.value = "$ "+cambio;
}
function FormaPago() {
var cadena = '';
        cadena += "<div class='form-group'> \n\
            <div class='col-lg-12'> \n\
            <div class='col-lg-2'> \n\
            <label>Forma de Pago:</label> \n\
            </div> \n\
            <div class='col-lg-4'>\n\
            <select class='form-control' id='forma_pago2' onchange='OtroPago()'> \n\
            <option value='2' >Tarjeta de Credito</option> \n\
            <option value='3' >Cheque</option> \n\
            </select> \n\
            </div> \n\
            </div> \n\
            </div>";
        cadena +="<div class='form-group'> \n\
            <div class='col-lg-12'> \n\
            <div class='col-lg-3'><label>Valor:</label> \n\
            <input type='text' class='form-control' name='Valor' id='Valor'>\n\
            </div>\n\
           <div class='col-lg-3'><label>Número Tarjeta:</label> \n\
            <input type='text' class='form-control'  placeholder='N° Tarjeta' name='tarjeta' id='tarjeta'></div>\n\
            <div class='col-lg-3'><label>Número Cuenta:</label>\n\
            <input type='text' class='form-control'  placeholder='N° Cuenta' name='cuenta' id='cuenta'>";										
        cadena +="</div>\n\
            <div class='col-lg-3'><label>Nombre de Institucion:</label>\n\
            <input type='text'  class='form-control'  placeholder='Nombre de Institucion'  name='institucion' id='institucion'></div></div> \n\
            </div>";									
           
        document.getElementById("new_formpago").innerHTML += cadena; 
        document.getElementById("mas").disabled = true;
        //var forma_pago = $('#forma_pago2').val();
        var f = document.getElementById("forma_pago2");
        f.value = "";

}
function OtroPago(){
    var pago2= $('#forma_pago2').val();
    //alert(pago2);
     document.getElementById("tarjeta").disabled = true;
     document.getElementById("cuenta").disabled = true;
    if(parseInt(pago2) === 2){
     document.getElementById("tarjeta").disabled = false;   
    }
    if(parseInt(pago2) === 3){
    document.getElementById("cuenta").disabled = false;
    }
}
function GuardarRecaudacion(){
var cartera = $('#cartera').val();
var accion="guardaregistros";
var valorecaudacion = $('#pago').val();
var idDeudor = $('#idDeudor').val();
var cont = $('#Cont').val();
var PagoEfectivo=$("#totalpago").val();
var PagoCheque=$("#Valor2").val();
var PagoTarjCred=$("#Valor").val();
var numeroCtaCheque=$("#cuenta").val();
var InstCtaCheque=$("#institucion2").val();

var numeroTarjetaCredito=$("#tarjeta").val();
var InstTarjetaCredito=$("#institucion").val();



if((PagoEfectivo==="")&&(PagoCheque === "")&&(PagoTarjCred === "")){
    MsgSalidaModalA("Debe ingresar una forma de Pago");
    return true;    
}
if((PagoCheque !== "")&&(numeroCtaCheque === "")){
    MsgSalidaModalA("Debe Ingresar el número e Cheque ");
    return true;    
}
if((PagoCheque !== "")&&(InstCtaCheque === "")){
    MsgSalidaModalA("Debe Ingresar el nombre de la Institucion Bancaria");
    return true;    
}

if((PagoTarjCred !== "")&&(numeroTarjetaCredito === "")){
    MsgSalidaModalA("Debe Ingresar el número de VOUCHER ");
    return true;    
}
if((PagoTarjCred !== "")&&(InstTarjetaCredito === "")){
    MsgSalidaModalA("Debe Ingresar el nombre de la Entidad Financiera de la Tarjeta");
    return true;    
}
//parseInt(PagoEfectivo)

if(PagoEfectivo===""){
    PagoEfectivo=0;
}
if(PagoCheque===""){
    PagoCheque=0;
}
if(PagoTarjCred===""){
    PagoTarjCred=0;
}

var tttotal = parseInt(PagoEfectivo)+parseInt(PagoCheque)+parseInt(PagoTarjCred);
if(tttotal!==parseFloat(valorecaudacion)){
    MsgSalidaModalA("Los valores registrados en la FORMA DE PAGO deben ser igual al Total a Cancelar....");
    return true;  
}




var parametros = {
        "cartera": cartera,
        "idDeudor": idDeudor,
        "valorecaudacion": valorecaudacion,
        "accion": accion
};
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    if (parseInt(response) > 0) {

                        for (var i = 0; i < cont; i++) {
                            
                            var idArticulo= $('#idarticulo_'+i).val();
                            var idCuota = $('#idcuota_'+i).val();
                            var valorCuota = $('#valorcuota_'+i).val();
                            var interes = $('#interes_'+i).val();
                            var mora = $('#valormora_'+i).val();
                            var valorPagar = $('#valor_pagar_'+i).val();
                            var saldo = $('#saldo_'+i).val();
                            
                            if (idCuota !== undefined) {
                                if (idArticulo !== undefined) {
                                    if (valorCuota !== undefined) {
                                        if (interes !== undefined) {
                                            if (mora !== undefined) {
                                                if (valorPagar !== undefined) {
                                                    if (saldo !== undefined) {
                                                       GuardarDet_Recaudacion(parseInt(response),idArticulo,idCuota,valorCuota,interes,mora,valorPagar,saldo);
                                                    }
                                                }
                                            }        
                                        }
                                    }
                                }
                            }
                        }
                        Guardar_FormaPago(parseInt(response));
                          var nom_deudor=$("#nombres").val();
                        var identificacion=$("#identificacion").val();                        
                        var idRecaudacion=parseInt(response);
                        //window.open("reportes?idRecaudacion="+idRecaudacion+"&identificacion="+identificacion+"&nom_deudor="+nom_deudor, "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=700,height=1000");
                        window.open("reportes?idRecaudacion="+idRecaudacion+"&identificacion="+identificacion+"&nom_deudor="+nom_deudor);

                    }
                }
            }
        });
    
}
function GuardarDet_Recaudacion(stridRecaudacion,stridArticulo,stridCuota,strvalorCuota,strinteres,strmora,strvalorPagar,strsaldo){
var idRecaudacion = stridRecaudacion;
var idArticulo = stridArticulo;
var idCuota = stridCuota;
var valorCuota = strvalorCuota;
var interes = strinteres;
var mora = strmora;
var valorPagar = strvalorPagar;
var saldo = strsaldo;
var accion="detalle";



var parametros = {
        "idRecaudacion": idRecaudacion,
        "idArticulo": idArticulo,
        "idCuota": idCuota,
        "valorCuota": valorCuota,
        "interes": interes,
        "mora": mora,
        "valorPagar": valorPagar,
        "saldo": saldo,
        "accion": accion
};    
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    //alert(response);
                    //Guardar_FormaPago();
                }
            }
        });    
}
function Guardar_FormaPago(stridRecaudacion){
    /*Segundo tipo de pago Efectivo*/
    var idRecaudacion = stridRecaudacion;
    var formaPago = 1;
    var totalpago = $('#totalpago').val();
    /*Segundo tipo de pago Tarjeta/credito*/
    var formaPago2 = 2;
    var totalpago2 = $('#Valor').val();
    var institucion = $('#institucion').val();
    var num_tarjeta = $('#tarjeta').val();
    /*Tercer tipo de pago Cheque*/
    var formaPago3 = 3;
    var totalpago3 = $('#Valor2').val();
    var institucion2 = $('#institucion2').val();
    var num_cuenta = $('#cuenta').val();    
    var accion="Formapago";
    var valorecaudacion = $('#pago').val();
      if((totalpago !== "")&&(totalpago2 !== "")&&(totalpago3 !== "")){


        var suma = Number($('#Valor').val()) + Number($('#Valor2').val()) +Number($('#totalpago').val());

        if(Number(suma).toFixed(2) === Number(valorecaudacion).toFixed(2)){ 
        var parametros = {
        "totalpago": totalpago,
        "formaPago": formaPago,
        "idRecaudacion": idRecaudacion,
        
        "formaPago2": formaPago2,
        "institucion": institucion,
        "totalpago2": totalpago2,
        "num_tarjeta": num_tarjeta,
        
        "formaPago3": formaPago3,
        "totalpago3": totalpago3,
        "institucion2": institucion2,
        "num_cuenta": num_cuenta,                    
        "accion": accion
};    
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    MsgSalidaModalM(response);
                }
            }
        });
        }
        
    }

    if((totalpago === "")&&(totalpago2 !== "")&&(totalpago3 === "")){
        formaPago = 0; formaPago3 = 0;
        institucion2 = 0;
        totalpago = "0"; totalpago3 = "0";
        num_cuenta = "";
        if(Number(totalpago2).toFixed(2) === valorecaudacion){
        var parametros = {
        "totalpago": totalpago,
        "formaPago": formaPago,
        "idRecaudacion": idRecaudacion,
        
        "formaPago2": formaPago2,
        "institucion": institucion,
        "totalpago2": totalpago2,
        "num_tarjeta": num_tarjeta,
        
        "formaPago3": formaPago3,
        "totalpago3": totalpago3,
        "institucion2": institucion2,
        "num_cuenta": num_cuenta,                    
        "accion": accion
};    
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    MsgSalidaModalA(response);
                }
            }
        });
        }

    }

    if((totalpago === "")&&(totalpago2 === "")&&(totalpago3 !== "")){
        formaPago2 = 0; formaPago = 0;
        institucion = 0; 
        totalpago2 = "0"; totalpago = "0";
        num_tarjeta = "";
        if(Number(totalpago3).toFixed(2) === valorecaudacion){
            var parametros = {
                "totalpago": totalpago,
                "formaPago": formaPago,
                "idRecaudacion": idRecaudacion,

                "formaPago2": formaPago2,
                "institucion": institucion,
                "totalpago2": totalpago2,
                "num_tarjeta": num_tarjeta,

                "formaPago3": formaPago3,
                "totalpago3": totalpago3,
                "institucion2": institucion2,
                "num_cuenta": num_cuenta,                    
                "accion": accion
};    
            $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    MsgSalidaModalM(response);
                }
            }
        });
        }
    
    }
//        }else{alert("Debe ingresar un numero de Tarjeta Credito");}
//    }else{alert("Debe ingresar el nombre de la Institucion Financiera");}
    
    if((totalpago !== "")&&(totalpago2 === "")&&(totalpago3 === "")){
        formaPago2 = 0; formaPago3 = 0;
        institucion = 0; institucion2 = 0;
        totalpago2 = "0"; totalpago3 = "0";
        num_tarjeta = ""; num_cuenta = "";
       // alert("Efectivo");
        if(Number(totalpago).toFixed(2) === valorecaudacion){
            var parametros = {
                "totalpago": totalpago,
                "formaPago": formaPago,
                "idRecaudacion": idRecaudacion,
                "formaPago2": formaPago2,
                "institucion": institucion,
                "totalpago2": totalpago2,
                "num_tarjeta": num_tarjeta,
                "formaPago3": formaPago3,
                "totalpago3": totalpago3,
                "institucion2": institucion2,
                "num_cuenta": num_cuenta,
                "accion": accion
            };
            $.ajax({
                data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                    if (response) {
                        MsgSalidaModalM(response);
                    }
                }
            });
        }
        
    }
    if((totalpago !== "")&&(totalpago2 !== "")&&(totalpago3 === "")){
        formaPago3 = 0;
        institucion2 = 0;
        totalpago3 = "0";
        num_cuenta = " ";
	var suma = Number($('#totalpago').val()) + Number($('#Valor').val());
	if(Number(suma).toFixed(2) === Number(valorecaudacion).toFixed(2)){
	 var parametros = {
	 "totalpago": totalpago,
            "formaPago": formaPago,
            "idRecaudacion": idRecaudacion,

            "formaPago2": formaPago2,
            "institucion": institucion,
            "totalpago2": totalpago2,
            "num_tarjeta": num_tarjeta,

            "formaPago3": formaPago3,
            "totalpago3": totalpago3,
            "institucion2": institucion2,
            "num_cuenta": num_cuenta,                    
            "accion": accion
    };    
            $.ajax({
            data: parametros,
                    url: 'recaudacion',
                    type: 'GET',
                    beforeSend: function () {
                    },
                    success: function (response) {

                    if (response) {
                        MsgSalidaModalM(response);
                    }
                }
            });
        }

    }
    if((totalpago !== "")&&(totalpago2 === "")&&(totalpago3 !== "")){
        formaPago2 = 0;
        institucion = 0;
        totalpago2 = "0";
        num_tarjeta = " ";
        var suma = Number($('#totalpago').val()) + Number($('#Valor2').val());

        if(Number(suma).toFixed(2) === Number(valorecaudacion).toFixed(2)){ 
        var parametros = {
        "totalpago": totalpago,
        "formaPago": formaPago,
        "idRecaudacion": idRecaudacion,
        
        "formaPago2": formaPago2,
        "institucion": institucion,
        "totalpago2": totalpago2,
        "num_tarjeta": num_tarjeta,
        
        "formaPago3": formaPago3,
        "totalpago3": totalpago3,
        "institucion2": institucion2,
        "num_cuenta": num_cuenta,                    
        "accion": accion
};    
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    MsgSalidaModalA(response);
                }
            }
        });}else{MsgSalidaModalA("Valor debe ser igual al total de pago");}

    }
    if((totalpago === "")&&(totalpago2 !== "")&&(totalpago3 !== "")){
        formaPago = 0;
        
        totalpago = "0";
        
        var suma = Number($('#Valor').val()) + Number($('#Valor2').val());

        if(Number(suma).toFixed(2) === Number(valorecaudacion).toFixed(2)){ 
        var parametros = {
        "totalpago": totalpago,
        "formaPago": formaPago,
        "idRecaudacion": idRecaudacion,
        
        "formaPago2": formaPago2,
        "institucion": institucion,
        "totalpago2": totalpago2,
        "num_tarjeta": num_tarjeta,
        
        "formaPago3": formaPago3,
        "totalpago3": totalpago3,
        "institucion2": institucion2,
        "num_cuenta": num_cuenta,                    
        "accion": accion
};    
        $.ajax({
        data: parametros,
                url: 'recaudacion',
                type: 'GET',
                beforeSend: function () {
                },
                success: function (response) {

                if (response) {
                    MsgSalidaModalA(response);
                }
            }
        });
        }
        
    }
  

}

function EliminaFila(strIdCuota){
    var cuota = strIdCuota;
    //alert(cuota);
     $("#fila_" + cuota).remove();
     Suma_totales();
}
