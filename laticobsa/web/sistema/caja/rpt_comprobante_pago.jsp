

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%@page import="com.laticobsa.utils.Conexion"%>
 <link rel="icon" type="image/png" href="dist/img/favicon.png"/>
<%  /*Importamos la clase "Conexion_Postgresql" y la instanciamos por el nombre conexion
con la siguiente linea de codigo*/

Conexion conexion=new Conexion();
/*Establecemos la ruta del reporte*/ 
File reportFile = new File(application.getRealPath("sistema/reportes/ComprobantePago.jasper"));

/*Enviamos parámetros porque nuestro reporte los necesita asi que escriba 
y seguiremos el formato del método runReportToPdf*/ 
/*Con Map y el HaspMap nos servira para crear los paramentros*/
Map parameters = new HashMap();

/*Capturamos el valor de nuestra formulario que es el codigo del cliente que es un
varchar(5), lo almacenamos en una String*/
//String idcliente=request.getParameter("txtidcliente");

String nom_cliente=request.getParameter("nom_deudor");


String identificacion=request.getParameter("identificacion");
String fecha_trx="2017-05-12 17:05:00";
String nombre_sesion="Luis de la Torre";
int idRecaudacion= Integer.parseInt(request.getParameter("idRecaudacion"));

/*Digitamos la siguiente linea de codigo entre parentesis ira el parametro que agregamos en nuestro reporte
llamado $P{CODIGO}, pero solo se escribira "CODIGO", el String que capturamos lo colocamos, en este caso el 
reporte solo nos pide un parametro*/
parameters.put("nom_cliente", nom_cliente); 
parameters.put("identificacion", identificacion); 
parameters.put("fecha_trx", fecha_trx); 
parameters.put("nombre_sesion", nombre_sesion); 
parameters.put("idRecaudacion", idRecaudacion); 

/*Enviamos la ruta del reporte, los parámetros y la conexión(objeto Connection)*/ 
byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion.getconexion2()); 
/*Indicamos que la respuesta va a ser en formato PDF*/ response.setContentType("application/pdf");

response.setContentLength(bytes.length); 
ServletOutputStream ouputStream = response.getOutputStream(); 
ouputStream.write(bytes, 0, bytes.length);
 /*Limpiamos y cerramos flujos de salida*/ 
ouputStream.flush(); 
ouputStream.close(); %>
