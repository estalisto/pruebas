package com.laticobsa.modelo;
// Generated 30-ago-2017 1:41:34 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LcCuadreCaja generated by hbm2java
 */
public class LcCuadreCaja  implements java.io.Serializable {


     private int idCuadreCaja;
     private Integer idFormaPago;
     private Integer idUsuario;
     private Integer idEmpresa;
     private Integer idSucursal;
     private Integer numeroComprobante;
     private Date fechaPago;
     private Integer idDeudor;
     private BigDecimal total;
     private Date fechaRegistro;
     private Date fechaCuadre;
     private String estado;

    public LcCuadreCaja() {
    }

	
    public LcCuadreCaja(int idCuadreCaja) {
        this.idCuadreCaja = idCuadreCaja;
    }
    public LcCuadreCaja(int idCuadreCaja, Integer idFormaPago, Integer idUsuario, Integer idEmpresa, Integer idSucursal, Integer numeroComprobante, Date fechaPago, Integer idDeudor, BigDecimal total, Date fechaRegistro, Date fechaCuadre, String estado) {
       this.idCuadreCaja = idCuadreCaja;
       this.idFormaPago = idFormaPago;
       this.idUsuario = idUsuario;
       this.idEmpresa = idEmpresa;
       this.idSucursal = idSucursal;
       this.numeroComprobante = numeroComprobante;
       this.fechaPago = fechaPago;
       this.idDeudor = idDeudor;
       this.total = total;
       this.fechaRegistro = fechaRegistro;
       this.fechaCuadre = fechaCuadre;
       this.estado = estado;
    }
   
    public int getIdCuadreCaja() {
        return this.idCuadreCaja;
    }
    
    public void setIdCuadreCaja(int idCuadreCaja) {
        this.idCuadreCaja = idCuadreCaja;
    }
    public Integer getIdFormaPago() {
        return this.idFormaPago;
    }
    
    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Integer getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Integer getNumeroComprobante() {
        return this.numeroComprobante;
    }
    
    public void setNumeroComprobante(Integer numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    public Integer getIdDeudor() {
        return this.idDeudor;
    }
    
    public void setIdDeudor(Integer idDeudor) {
        this.idDeudor = idDeudor;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Date getFechaCuadre() {
        return this.fechaCuadre;
    }
    
    public void setFechaCuadre(Date fechaCuadre) {
        this.fechaCuadre = fechaCuadre;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


