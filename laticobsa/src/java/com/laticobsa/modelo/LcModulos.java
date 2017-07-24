package com.laticobsa.modelo;
// Generated 22-jul-2017 13:48:47 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LcModulos generated by hbm2java
 */
public class LcModulos  implements java.io.Serializable {


     private int idModulo;
     private Integer idEmpresa;
     private String menuOpciones;
     private Integer nivel;
     private Integer grupo;
     private String funciones;
     private Date fechaCreacion;
     private String estado;
     private Integer orden;
     private Set lcModuloRols = new HashSet(0);

    public LcModulos() {
    }

	
    public LcModulos(int idModulo) {
        this.idModulo = idModulo;
    }
    public LcModulos(int idModulo, Integer idEmpresa, String menuOpciones, Integer nivel, Integer grupo, String funciones, Date fechaCreacion, String estado, Integer orden, Set lcModuloRols) {
       this.idModulo = idModulo;
       this.idEmpresa = idEmpresa;
       this.menuOpciones = menuOpciones;
       this.nivel = nivel;
       this.grupo = grupo;
       this.funciones = funciones;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.orden = orden;
       this.lcModuloRols = lcModuloRols;
    }
   
    public int getIdModulo() {
        return this.idModulo;
    }
    
    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public String getMenuOpciones() {
        return this.menuOpciones;
    }
    
    public void setMenuOpciones(String menuOpciones) {
        this.menuOpciones = menuOpciones;
    }
    public Integer getNivel() {
        return this.nivel;
    }
    
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public Integer getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }
    public String getFunciones() {
        return this.funciones;
    }
    
    public void setFunciones(String funciones) {
        this.funciones = funciones;
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
    public Integer getOrden() {
        return this.orden;
    }
    
    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    public Set getLcModuloRols() {
        return this.lcModuloRols;
    }
    
    public void setLcModuloRols(Set lcModuloRols) {
        this.lcModuloRols = lcModuloRols;
    }




}


