package com.laticobsa.modelo;
// Generated 22-jul-2017 13:48:47 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LcCuotas generated by hbm2java
 */
public class LcCuotas  implements java.io.Serializable {


     private int idCuota;
     private LcArticulo lcArticulo;
     private LcDatosDeudores lcDatosDeudores;
     private Integer idCliente;
     private Integer numCuotas;
     private BigDecimal valorCuota;
     private BigDecimal interesCuota;
     private BigDecimal valorMora;
     private BigDecimal gastosCobranzas;
     private BigDecimal gastosAdicional;
     private BigDecimal otrosValores;
     private BigDecimal totalCuotas;
     private Date fechaPago;
     private Date fechaMaxPago;
     private Date fechaRegistro;
     private String estado;
     private String descripcionCarga;

    public LcCuotas() {
    }

	
    public LcCuotas(int idCuota) {
        this.idCuota = idCuota;
    }
    public LcCuotas(int idCuota, LcArticulo lcArticulo, LcDatosDeudores lcDatosDeudores, Integer idCliente, Integer numCuotas, BigDecimal valorCuota, BigDecimal interesCuota, BigDecimal valorMora, BigDecimal gastosCobranzas, BigDecimal gastosAdicional, BigDecimal otrosValores, BigDecimal totalCuotas, Date fechaPago, Date fechaMaxPago, Date fechaRegistro, String estado, String descripcionCarga) {
       this.idCuota = idCuota;
       this.lcArticulo = lcArticulo;
       this.lcDatosDeudores = lcDatosDeudores;
       this.idCliente = idCliente;
       this.numCuotas = numCuotas;
       this.valorCuota = valorCuota;
       this.interesCuota = interesCuota;
       this.valorMora = valorMora;
       this.gastosCobranzas = gastosCobranzas;
       this.gastosAdicional = gastosAdicional;
       this.otrosValores = otrosValores;
       this.totalCuotas = totalCuotas;
       this.fechaPago = fechaPago;
       this.fechaMaxPago = fechaMaxPago;
       this.fechaRegistro = fechaRegistro;
       this.estado = estado;
       this.descripcionCarga = descripcionCarga;
    }
   
    public int getIdCuota() {
        return this.idCuota;
    }
    
    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }
    public LcArticulo getLcArticulo() {
        return this.lcArticulo;
    }
    
    public void setLcArticulo(LcArticulo lcArticulo) {
        this.lcArticulo = lcArticulo;
    }
    public LcDatosDeudores getLcDatosDeudores() {
        return this.lcDatosDeudores;
    }
    
    public void setLcDatosDeudores(LcDatosDeudores lcDatosDeudores) {
        this.lcDatosDeudores = lcDatosDeudores;
    }
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getNumCuotas() {
        return this.numCuotas;
    }
    
    public void setNumCuotas(Integer numCuotas) {
        this.numCuotas = numCuotas;
    }
    public BigDecimal getValorCuota() {
        return this.valorCuota;
    }
    
    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }
    public BigDecimal getInteresCuota() {
        return this.interesCuota;
    }
    
    public void setInteresCuota(BigDecimal interesCuota) {
        this.interesCuota = interesCuota;
    }
    public BigDecimal getValorMora() {
        return this.valorMora;
    }
    
    public void setValorMora(BigDecimal valorMora) {
        this.valorMora = valorMora;
    }
    public BigDecimal getGastosCobranzas() {
        return this.gastosCobranzas;
    }
    
    public void setGastosCobranzas(BigDecimal gastosCobranzas) {
        this.gastosCobranzas = gastosCobranzas;
    }
    public BigDecimal getGastosAdicional() {
        return this.gastosAdicional;
    }
    
    public void setGastosAdicional(BigDecimal gastosAdicional) {
        this.gastosAdicional = gastosAdicional;
    }
    public BigDecimal getOtrosValores() {
        return this.otrosValores;
    }
    
    public void setOtrosValores(BigDecimal otrosValores) {
        this.otrosValores = otrosValores;
    }
    public BigDecimal getTotalCuotas() {
        return this.totalCuotas;
    }
    
    public void setTotalCuotas(BigDecimal totalCuotas) {
        this.totalCuotas = totalCuotas;
    }
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    public Date getFechaMaxPago() {
        return this.fechaMaxPago;
    }
    
    public void setFechaMaxPago(Date fechaMaxPago) {
        this.fechaMaxPago = fechaMaxPago;
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
    public String getDescripcionCarga() {
        return this.descripcionCarga;
    }
    
    public void setDescripcionCarga(String descripcionCarga) {
        this.descripcionCarga = descripcionCarga;
    }




}


