package com.laticobsa.modelo;
// Generated 31-jul-2017 17:40:44 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * LcGenero generated by hbm2java
 */
public class LcGenero  implements java.io.Serializable {


     private int idGenero;
     private String abreviatura;
     private String descripcion;
     private String estado;
     private Set lcEmpleadoses = new HashSet(0);

    public LcGenero() {
    }

	
    public LcGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    public LcGenero(int idGenero, String abreviatura, String descripcion, String estado, Set lcEmpleadoses) {
       this.idGenero = idGenero;
       this.abreviatura = abreviatura;
       this.descripcion = descripcion;
       this.estado = estado;
       this.lcEmpleadoses = lcEmpleadoses;
    }
   
    public int getIdGenero() {
        return this.idGenero;
    }
    
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
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
    public Set getLcEmpleadoses() {
        return this.lcEmpleadoses;
    }
    
    public void setLcEmpleadoses(Set lcEmpleadoses) {
        this.lcEmpleadoses = lcEmpleadoses;
    }




}


