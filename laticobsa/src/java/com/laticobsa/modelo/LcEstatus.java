package com.laticobsa.modelo;
// Generated 27-jun-2017 21:14:43 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LcEstatus generated by hbm2java
 */
public class LcEstatus  implements java.io.Serializable {


     private int idEstatus;
     private String descripcion;
     private Date fechaCreacion;
     private String estado;
     private Set lcDatosDeudoreses = new HashSet(0);

    public LcEstatus() {
    }

	
    public LcEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }
    public LcEstatus(int idEstatus, String descripcion, Date fechaCreacion, String estado, Set lcDatosDeudoreses) {
       this.idEstatus = idEstatus;
       this.descripcion = descripcion;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.lcDatosDeudoreses = lcDatosDeudoreses;
    }
   
    public int getIdEstatus() {
        return this.idEstatus;
    }
    
    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public Set getLcDatosDeudoreses() {
        return this.lcDatosDeudoreses;
    }
    
    public void setLcDatosDeudoreses(Set lcDatosDeudoreses) {
        this.lcDatosDeudoreses = lcDatosDeudoreses;
    }




}


