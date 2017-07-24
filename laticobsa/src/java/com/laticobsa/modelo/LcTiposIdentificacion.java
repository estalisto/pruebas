package com.laticobsa.modelo;
// Generated 22-jul-2017 13:48:47 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * LcTiposIdentificacion generated by hbm2java
 */
public class LcTiposIdentificacion  implements java.io.Serializable {


     private int idTipoIdentificacion;
     private String tipoIdentificacion;
     private String descripcion;
     private String estado;
     private Set lcEmpresas = new HashSet(0);
     private Set lcEmpleadoses = new HashSet(0);
     private Set lcClienteses = new HashSet(0);

    public LcTiposIdentificacion() {
    }

	
    public LcTiposIdentificacion(int idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }
    public LcTiposIdentificacion(int idTipoIdentificacion, String tipoIdentificacion, String descripcion, String estado, Set lcEmpresas, Set lcEmpleadoses, Set lcClienteses) {
       this.idTipoIdentificacion = idTipoIdentificacion;
       this.tipoIdentificacion = tipoIdentificacion;
       this.descripcion = descripcion;
       this.estado = estado;
       this.lcEmpresas = lcEmpresas;
       this.lcEmpleadoses = lcEmpleadoses;
       this.lcClienteses = lcClienteses;
    }
   
    public int getIdTipoIdentificacion() {
        return this.idTipoIdentificacion;
    }
    
    public void setIdTipoIdentificacion(int idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }
    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }
    
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getLcEmpresas() {
        return this.lcEmpresas;
    }
    
    public void setLcEmpresas(Set lcEmpresas) {
        this.lcEmpresas = lcEmpresas;
    }
    public Set getLcEmpleadoses() {
        return this.lcEmpleadoses;
    }
    
    public void setLcEmpleadoses(Set lcEmpleadoses) {
        this.lcEmpleadoses = lcEmpleadoses;
    }
    public Set getLcClienteses() {
        return this.lcClienteses;
    }
    
    public void setLcClienteses(Set lcClienteses) {
        this.lcClienteses = lcClienteses;
    }




}


