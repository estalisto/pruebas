package com.laticobsa.modelo;
// Generated 30-ago-2017 1:41:34 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LcCartera generated by hbm2java
 */
public class LcCartera  implements java.io.Serializable {


     private int idCartera;
     private LcClientes lcClientes;
     private String nombreCartera;
     private Date fechaCreacion;
     private String estado;
     private Set lcSubcarteras = new HashSet(0);

    public LcCartera() {
    }

	
    public LcCartera(int idCartera) {
        this.idCartera = idCartera;
    }
    public LcCartera(int idCartera, LcClientes lcClientes, String nombreCartera, Date fechaCreacion, String estado, Set lcSubcarteras) {
       this.idCartera = idCartera;
       this.lcClientes = lcClientes;
       this.nombreCartera = nombreCartera;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.lcSubcarteras = lcSubcarteras;
    }
   
    public int getIdCartera() {
        return this.idCartera;
    }
    
    public void setIdCartera(int idCartera) {
        this.idCartera = idCartera;
    }
    public LcClientes getLcClientes() {
        return this.lcClientes;
    }
    
    public void setLcClientes(LcClientes lcClientes) {
        this.lcClientes = lcClientes;
    }
    public String getNombreCartera() {
        return this.nombreCartera;
    }
    
    public void setNombreCartera(String nombreCartera) {
        this.nombreCartera = nombreCartera;
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
    public Set getLcSubcarteras() {
        return this.lcSubcarteras;
    }
    
    public void setLcSubcarteras(Set lcSubcarteras) {
        this.lcSubcarteras = lcSubcarteras;
    }




}


