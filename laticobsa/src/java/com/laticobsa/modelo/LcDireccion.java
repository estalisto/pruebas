package com.laticobsa.modelo;
// Generated 31-jul-2017 17:40:44 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * LcDireccion generated by hbm2java
 */
public class LcDireccion  implements java.io.Serializable {


     private int idDireccion;
     private LcTiposDireccion lcTiposDireccion;
     private String identificacionDeudor;
     private String direccionCompleta;
     private Date fechaCreacion;
     private String estado;
     private String descripcionCarga;

    public LcDireccion() {
    }

	
    public LcDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    public LcDireccion(int idDireccion, LcTiposDireccion lcTiposDireccion, String identificacionDeudor, String direccionCompleta, Date fechaCreacion, String estado, String descripcionCarga) {
       this.idDireccion = idDireccion;
       this.lcTiposDireccion = lcTiposDireccion;
       this.identificacionDeudor = identificacionDeudor;
       this.direccionCompleta = direccionCompleta;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.descripcionCarga = descripcionCarga;
    }
   
    public int getIdDireccion() {
        return this.idDireccion;
    }
    
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    public LcTiposDireccion getLcTiposDireccion() {
        return this.lcTiposDireccion;
    }
    
    public void setLcTiposDireccion(LcTiposDireccion lcTiposDireccion) {
        this.lcTiposDireccion = lcTiposDireccion;
    }
    public String getIdentificacionDeudor() {
        return this.identificacionDeudor;
    }
    
    public void setIdentificacionDeudor(String identificacionDeudor) {
        this.identificacionDeudor = identificacionDeudor;
    }
    public String getDireccionCompleta() {
        return this.direccionCompleta;
    }
    
    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDescripcionCarga() {
        return this.descripcionCarga;
    }
    
    public void setDescripcionCarga(String descripcionCarga) {
        this.descripcionCarga = descripcionCarga;
    }




}


