package com.laticobsa.modelo;
// Generated 31-jul-2017 17:40:44 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * LcGestiones generated by hbm2java
 */
public class LcGestiones  implements java.io.Serializable {


     private int idGestion;
     private LcClientes lcClientes;
     private LcDatosDeudores lcDatosDeudores;
     private LcEmpleados lcEmpleados;
     private LcTipoGestion lcTipoGestion;
     private LcTipoResultado lcTipoResultado;
     private String observacion;
     private Date fechaTransaccion;
     private String estado;

    public LcGestiones() {
    }

	
    public LcGestiones(int idGestion) {
        this.idGestion = idGestion;
    }
    public LcGestiones(int idGestion, LcClientes lcClientes, LcDatosDeudores lcDatosDeudores, LcEmpleados lcEmpleados, LcTipoGestion lcTipoGestion, LcTipoResultado lcTipoResultado, String observacion, Date fechaTransaccion, String estado) {
       this.idGestion = idGestion;
       this.lcClientes = lcClientes;
       this.lcDatosDeudores = lcDatosDeudores;
       this.lcEmpleados = lcEmpleados;
       this.lcTipoGestion = lcTipoGestion;
       this.lcTipoResultado = lcTipoResultado;
       this.observacion = observacion;
       this.fechaTransaccion = fechaTransaccion;
       this.estado = estado;
    }
   
    public int getIdGestion() {
        return this.idGestion;
    }
    
    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }
    public LcClientes getLcClientes() {
        return this.lcClientes;
    }
    
    public void setLcClientes(LcClientes lcClientes) {
        this.lcClientes = lcClientes;
    }
    public LcDatosDeudores getLcDatosDeudores() {
        return this.lcDatosDeudores;
    }
    
    public void setLcDatosDeudores(LcDatosDeudores lcDatosDeudores) {
        this.lcDatosDeudores = lcDatosDeudores;
    }
    public LcEmpleados getLcEmpleados() {
        return this.lcEmpleados;
    }
    
    public void setLcEmpleados(LcEmpleados lcEmpleados) {
        this.lcEmpleados = lcEmpleados;
    }
    public LcTipoGestion getLcTipoGestion() {
        return this.lcTipoGestion;
    }
    
    public void setLcTipoGestion(LcTipoGestion lcTipoGestion) {
        this.lcTipoGestion = lcTipoGestion;
    }
    public LcTipoResultado getLcTipoResultado() {
        return this.lcTipoResultado;
    }
    
    public void setLcTipoResultado(LcTipoResultado lcTipoResultado) {
        this.lcTipoResultado = lcTipoResultado;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Date getFechaTransaccion() {
        return this.fechaTransaccion;
    }
    
    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


