package com.laticobsa.modelo;
// Generated 27-jun-2017 21:14:43 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LcDetRecaudaciones generated by hbm2java
 */
public class LcDetRecaudaciones  implements java.io.Serializable {


     private int idDetRecaudacion;
     private LcRecaudaciones lcRecaudaciones;
     private Integer idArticulo;
     private Integer idCuota;
     private BigDecimal valorCuota;
     private BigDecimal valorRecaudado;
     private BigDecimal interes;
     private BigDecimal mora;
     private BigDecimal saldo;
     private Date fechaCobro;
     private Date fechaRegistro;
     private Date fechaActualizado;
     private String estado;

    public LcDetRecaudaciones() {
    }

	
    public LcDetRecaudaciones(int idDetRecaudacion) {
        this.idDetRecaudacion = idDetRecaudacion;
    }
    public LcDetRecaudaciones(int idDetRecaudacion, LcRecaudaciones lcRecaudaciones, Integer idArticulo, Integer idCuota, BigDecimal valorCuota, BigDecimal valorRecaudado, BigDecimal interes, BigDecimal mora, BigDecimal saldo, Date fechaCobro, Date fechaRegistro, Date fechaActualizado, String estado) {
       this.idDetRecaudacion = idDetRecaudacion;
       this.lcRecaudaciones = lcRecaudaciones;
       this.idArticulo = idArticulo;
       this.idCuota = idCuota;
       this.valorCuota = valorCuota;
       this.valorRecaudado = valorRecaudado;
       this.interes = interes;
       this.mora = mora;
       this.saldo = saldo;
       this.fechaCobro = fechaCobro;
       this.fechaRegistro = fechaRegistro;
       this.fechaActualizado = fechaActualizado;
       this.estado = estado;
    }
   
    public int getIdDetRecaudacion() {
        return this.idDetRecaudacion;
    }
    
    public void setIdDetRecaudacion(int idDetRecaudacion) {
        this.idDetRecaudacion = idDetRecaudacion;
    }
    public LcRecaudaciones getLcRecaudaciones() {
        return this.lcRecaudaciones;
    }
    
    public void setLcRecaudaciones(LcRecaudaciones lcRecaudaciones) {
        this.lcRecaudaciones = lcRecaudaciones;
    }
    public Integer getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Integer getIdCuota() {
        return this.idCuota;
    }
    
    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }
    public BigDecimal getValorCuota() {
        return this.valorCuota;
    }
    
    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }
    public BigDecimal getValorRecaudado() {
        return this.valorRecaudado;
    }
    
    public void setValorRecaudado(BigDecimal valorRecaudado) {
        this.valorRecaudado = valorRecaudado;
    }
    public BigDecimal getInteres() {
        return this.interes;
    }
    
    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }
    public BigDecimal getMora() {
        return this.mora;
    }
    
    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }
    public BigDecimal getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public Date getFechaCobro() {
        return this.fechaCobro;
    }
    
    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Date getFechaActualizado() {
        return this.fechaActualizado;
    }
    
    public void setFechaActualizado(Date fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


