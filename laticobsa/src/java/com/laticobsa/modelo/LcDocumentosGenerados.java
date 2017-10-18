package com.laticobsa.modelo;
// Generated 30-ago-2017 1:41:34 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LcDocumentosGenerados generated by hbm2java
 */
public class LcDocumentosGenerados  implements java.io.Serializable {


     private int idDocGenerado;
     private String codigo;
     private Integer idEmpresa;
     private Integer idTicket;
     private Integer idDeudor;
     private Integer idCliente;
     private Integer idDocumento;
     private String rutaDocumento;
     private String recepcion;
     private BigDecimal valorRecaudado;
     private String identificacionRecibe;
     private String personaRecibe;
     private String observacion;
     private Date fechaRecepcion;
     private Date fechaRegistro;
     private Date fechaActualizado;
     private String estado;

    public LcDocumentosGenerados() {
    }

	
    public LcDocumentosGenerados(int idDocGenerado) {
        this.idDocGenerado = idDocGenerado;
    }
    public LcDocumentosGenerados(int idDocGenerado, String codigo, Integer idEmpresa, Integer idTicket, Integer idDeudor, Integer idCliente, Integer idDocumento, String rutaDocumento, String recepcion, BigDecimal valorRecaudado, String identificacionRecibe, String personaRecibe, String observacion, Date fechaRecepcion, Date fechaRegistro, Date fechaActualizado, String estado) {
       this.idDocGenerado = idDocGenerado;
       this.codigo = codigo;
       this.idEmpresa = idEmpresa;
       this.idTicket = idTicket;
       this.idDeudor = idDeudor;
       this.idCliente = idCliente;
       this.idDocumento = idDocumento;
       this.rutaDocumento = rutaDocumento;
       this.recepcion = recepcion;
       this.valorRecaudado = valorRecaudado;
       this.identificacionRecibe = identificacionRecibe;
       this.personaRecibe = personaRecibe;
       this.observacion = observacion;
       this.fechaRecepcion = fechaRecepcion;
       this.fechaRegistro = fechaRegistro;
       this.fechaActualizado = fechaActualizado;
       this.estado = estado;
    }
   
    public int getIdDocGenerado() {
        return this.idDocGenerado;
    }
    
    public void setIdDocGenerado(int idDocGenerado) {
        this.idDocGenerado = idDocGenerado;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Integer getIdTicket() {
        return this.idTicket;
    }
    
    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }
    public Integer getIdDeudor() {
        return this.idDeudor;
    }
    
    public void setIdDeudor(Integer idDeudor) {
        this.idDeudor = idDeudor;
    }
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getIdDocumento() {
        return this.idDocumento;
    }
    
    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }
    public String getRutaDocumento() {
        return this.rutaDocumento;
    }
    
    public void setRutaDocumento(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }
    public String getRecepcion() {
        return this.recepcion;
    }
    
    public void setRecepcion(String recepcion) {
        this.recepcion = recepcion;
    }
    public BigDecimal getValorRecaudado() {
        return this.valorRecaudado;
    }
    
    public void setValorRecaudado(BigDecimal valorRecaudado) {
        this.valorRecaudado = valorRecaudado;
    }
    public String getIdentificacionRecibe() {
        return this.identificacionRecibe;
    }
    
    public void setIdentificacionRecibe(String identificacionRecibe) {
        this.identificacionRecibe = identificacionRecibe;
    }
    public String getPersonaRecibe() {
        return this.personaRecibe;
    }
    
    public void setPersonaRecibe(String personaRecibe) {
        this.personaRecibe = personaRecibe;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Date getFechaRecepcion() {
        return this.fechaRecepcion;
    }
    
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
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


