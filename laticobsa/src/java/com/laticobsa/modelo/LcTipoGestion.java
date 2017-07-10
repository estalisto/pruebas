package com.laticobsa.modelo;
// Generated 09-jul-2017 23:23:34 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LcTipoGestion generated by hbm2java
 */
public class LcTipoGestion  implements java.io.Serializable {


     private int idTipoGestion;
     private String nombreTipoGestion;
     private Integer idCliente;
     private String observacion;
     private Date fechaRegistro;
     private String estado;
     private Set lcTipoResultados = new HashSet(0);
     private Set lcTipoResultados_1 = new HashSet(0);
     private Set lcGestioneses = new HashSet(0);

    public LcTipoGestion() {
    }

	
    public LcTipoGestion(int idTipoGestion) {
        this.idTipoGestion = idTipoGestion;
    }
    public LcTipoGestion(int idTipoGestion, String nombreTipoGestion, Integer idCliente, String observacion, Date fechaRegistro, String estado, Set lcTipoResultados, Set lcTipoResultados_1, Set lcGestioneses) {
       this.idTipoGestion = idTipoGestion;
       this.nombreTipoGestion = nombreTipoGestion;
       this.idCliente = idCliente;
       this.observacion = observacion;
       this.fechaRegistro = fechaRegistro;
       this.estado = estado;
       this.lcTipoResultados = lcTipoResultados;
       this.lcTipoResultados_1 = lcTipoResultados_1;
       this.lcGestioneses = lcGestioneses;
    }
   
    public int getIdTipoGestion() {
        return this.idTipoGestion;
    }
    
    public void setIdTipoGestion(int idTipoGestion) {
        this.idTipoGestion = idTipoGestion;
    }
    public String getNombreTipoGestion() {
        return this.nombreTipoGestion;
    }
    
    public void setNombreTipoGestion(String nombreTipoGestion) {
        this.nombreTipoGestion = nombreTipoGestion;
    }
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
    public Set getLcTipoResultados() {
        return this.lcTipoResultados;
    }
    
    public void setLcTipoResultados(Set lcTipoResultados) {
        this.lcTipoResultados = lcTipoResultados;
    }
    public Set getLcTipoResultados_1() {
        return this.lcTipoResultados_1;
    }
    
    public void setLcTipoResultados_1(Set lcTipoResultados_1) {
        this.lcTipoResultados_1 = lcTipoResultados_1;
    }
    public Set getLcGestioneses() {
        return this.lcGestioneses;
    }
    
    public void setLcGestioneses(Set lcGestioneses) {
        this.lcGestioneses = lcGestioneses;
    }




}


