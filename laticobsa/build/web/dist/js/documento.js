function frm_crear_cartas()
{
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("sistema/terrenos/frm_crear_cartas.jsp",{},function(){ });
 
 }