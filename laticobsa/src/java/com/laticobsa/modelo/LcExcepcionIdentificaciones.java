package com.laticobsa.modelo;
// Generated 31-jul-2017 17:40:44 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * LcExcepcionIdentificaciones generated by hbm2java
 */
public class LcExcepcionIdentificaciones  implements java.io.Serializable {


     private int idExcepIde;
     private String numIde;
     private Date fechaRegistro;
     private String estado;

    public LcExcepcionIdentificaciones() {
    }

	
    public LcExcepcionIdentificaciones(int idExcepIde) {
        this.idExcepIde = idExcepIde;
    }
    public LcExcepcionIdentificaciones(int idExcepIde, String numIde, Date fechaRegistro, String estado) {
       this.idExcepIde = idExcepIde;
       this.numIde = numIde;
       this.fechaRegistro = fechaRegistro;
       this.estado = estado;
    }
   
    public int getIdExcepIde() {
        return this.idExcepIde;
    }
    
    public void setIdExcepIde(int idExcepIde) {
        this.idExcepIde = idExcepIde;
    }
    public String getNumIde() {
        return this.numIde;
    }
    
    public void setNumIde(String numIde) {
        this.numIde = numIde;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


