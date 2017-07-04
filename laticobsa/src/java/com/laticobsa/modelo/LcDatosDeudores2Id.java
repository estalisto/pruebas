package com.laticobsa.modelo;
// Generated 27-jun-2017 21:14:43 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * LcDatosDeudores2Id generated by hbm2java
 */
public class LcDatosDeudores2Id  implements java.io.Serializable {


     private Integer idDatosDeudor;
     private Integer idEmpresa;
     private Integer idAgencia;
     private Integer idCliente;
     private Integer idEmpleado;
     private Integer tipoIdentioficacion;
     private String identificacion;
     private String nombres;
     private String apellidos;
     private Integer idCiudad;
     private Integer tipoCredito;
     private Integer status;
     private String referencia;
     private String numCuenta;
     private Date fechaCreacion;
     private String estado;
     private String nombresCompleto;

    public LcDatosDeudores2Id() {
    }

    public LcDatosDeudores2Id(Integer idDatosDeudor, Integer idEmpresa, Integer idAgencia, Integer idCliente, Integer idEmpleado, Integer tipoIdentioficacion, String identificacion, String nombres, String apellidos, Integer idCiudad, Integer tipoCredito, Integer status, String referencia, String numCuenta, Date fechaCreacion, String estado, String nombresCompleto) {
       this.idDatosDeudor = idDatosDeudor;
       this.idEmpresa = idEmpresa;
       this.idAgencia = idAgencia;
       this.idCliente = idCliente;
       this.idEmpleado = idEmpleado;
       this.tipoIdentioficacion = tipoIdentioficacion;
       this.identificacion = identificacion;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.idCiudad = idCiudad;
       this.tipoCredito = tipoCredito;
       this.status = status;
       this.referencia = referencia;
       this.numCuenta = numCuenta;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.nombresCompleto = nombresCompleto;
    }
   
    public Integer getIdDatosDeudor() {
        return this.idDatosDeudor;
    }
    
    public void setIdDatosDeudor(Integer idDatosDeudor) {
        this.idDatosDeudor = idDatosDeudor;
    }
    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Integer getIdAgencia() {
        return this.idAgencia;
    }
    
    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Integer getTipoIdentioficacion() {
        return this.tipoIdentioficacion;
    }
    
    public void setTipoIdentioficacion(Integer tipoIdentioficacion) {
        this.tipoIdentioficacion = tipoIdentioficacion;
    }
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }
    public Integer getTipoCredito() {
        return this.tipoCredito;
    }
    
    public void setTipoCredito(Integer tipoCredito) {
        this.tipoCredito = tipoCredito;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getReferencia() {
        return this.referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getNumCuenta() {
        return this.numCuenta;
    }
    
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
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
    public String getNombresCompleto() {
        return this.nombresCompleto;
    }
    
    public void setNombresCompleto(String nombresCompleto) {
        this.nombresCompleto = nombresCompleto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LcDatosDeudores2Id) ) return false;
		 LcDatosDeudores2Id castOther = ( LcDatosDeudores2Id ) other; 
         
		 return ( (this.getIdDatosDeudor()==castOther.getIdDatosDeudor()) || ( this.getIdDatosDeudor()!=null && castOther.getIdDatosDeudor()!=null && this.getIdDatosDeudor().equals(castOther.getIdDatosDeudor()) ) )
 && ( (this.getIdEmpresa()==castOther.getIdEmpresa()) || ( this.getIdEmpresa()!=null && castOther.getIdEmpresa()!=null && this.getIdEmpresa().equals(castOther.getIdEmpresa()) ) )
 && ( (this.getIdAgencia()==castOther.getIdAgencia()) || ( this.getIdAgencia()!=null && castOther.getIdAgencia()!=null && this.getIdAgencia().equals(castOther.getIdAgencia()) ) )
 && ( (this.getIdCliente()==castOther.getIdCliente()) || ( this.getIdCliente()!=null && castOther.getIdCliente()!=null && this.getIdCliente().equals(castOther.getIdCliente()) ) )
 && ( (this.getIdEmpleado()==castOther.getIdEmpleado()) || ( this.getIdEmpleado()!=null && castOther.getIdEmpleado()!=null && this.getIdEmpleado().equals(castOther.getIdEmpleado()) ) )
 && ( (this.getTipoIdentioficacion()==castOther.getTipoIdentioficacion()) || ( this.getTipoIdentioficacion()!=null && castOther.getTipoIdentioficacion()!=null && this.getTipoIdentioficacion().equals(castOther.getTipoIdentioficacion()) ) )
 && ( (this.getIdentificacion()==castOther.getIdentificacion()) || ( this.getIdentificacion()!=null && castOther.getIdentificacion()!=null && this.getIdentificacion().equals(castOther.getIdentificacion()) ) )
 && ( (this.getNombres()==castOther.getNombres()) || ( this.getNombres()!=null && castOther.getNombres()!=null && this.getNombres().equals(castOther.getNombres()) ) )
 && ( (this.getApellidos()==castOther.getApellidos()) || ( this.getApellidos()!=null && castOther.getApellidos()!=null && this.getApellidos().equals(castOther.getApellidos()) ) )
 && ( (this.getIdCiudad()==castOther.getIdCiudad()) || ( this.getIdCiudad()!=null && castOther.getIdCiudad()!=null && this.getIdCiudad().equals(castOther.getIdCiudad()) ) )
 && ( (this.getTipoCredito()==castOther.getTipoCredito()) || ( this.getTipoCredito()!=null && castOther.getTipoCredito()!=null && this.getTipoCredito().equals(castOther.getTipoCredito()) ) )
 && ( (this.getStatus()==castOther.getStatus()) || ( this.getStatus()!=null && castOther.getStatus()!=null && this.getStatus().equals(castOther.getStatus()) ) )
 && ( (this.getReferencia()==castOther.getReferencia()) || ( this.getReferencia()!=null && castOther.getReferencia()!=null && this.getReferencia().equals(castOther.getReferencia()) ) )
 && ( (this.getNumCuenta()==castOther.getNumCuenta()) || ( this.getNumCuenta()!=null && castOther.getNumCuenta()!=null && this.getNumCuenta().equals(castOther.getNumCuenta()) ) )
 && ( (this.getFechaCreacion()==castOther.getFechaCreacion()) || ( this.getFechaCreacion()!=null && castOther.getFechaCreacion()!=null && this.getFechaCreacion().equals(castOther.getFechaCreacion()) ) )
 && ( (this.getEstado()==castOther.getEstado()) || ( this.getEstado()!=null && castOther.getEstado()!=null && this.getEstado().equals(castOther.getEstado()) ) )
 && ( (this.getNombresCompleto()==castOther.getNombresCompleto()) || ( this.getNombresCompleto()!=null && castOther.getNombresCompleto()!=null && this.getNombresCompleto().equals(castOther.getNombresCompleto()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdDatosDeudor() == null ? 0 : this.getIdDatosDeudor().hashCode() );
         result = 37 * result + ( getIdEmpresa() == null ? 0 : this.getIdEmpresa().hashCode() );
         result = 37 * result + ( getIdAgencia() == null ? 0 : this.getIdAgencia().hashCode() );
         result = 37 * result + ( getIdCliente() == null ? 0 : this.getIdCliente().hashCode() );
         result = 37 * result + ( getIdEmpleado() == null ? 0 : this.getIdEmpleado().hashCode() );
         result = 37 * result + ( getTipoIdentioficacion() == null ? 0 : this.getTipoIdentioficacion().hashCode() );
         result = 37 * result + ( getIdentificacion() == null ? 0 : this.getIdentificacion().hashCode() );
         result = 37 * result + ( getNombres() == null ? 0 : this.getNombres().hashCode() );
         result = 37 * result + ( getApellidos() == null ? 0 : this.getApellidos().hashCode() );
         result = 37 * result + ( getIdCiudad() == null ? 0 : this.getIdCiudad().hashCode() );
         result = 37 * result + ( getTipoCredito() == null ? 0 : this.getTipoCredito().hashCode() );
         result = 37 * result + ( getStatus() == null ? 0 : this.getStatus().hashCode() );
         result = 37 * result + ( getReferencia() == null ? 0 : this.getReferencia().hashCode() );
         result = 37 * result + ( getNumCuenta() == null ? 0 : this.getNumCuenta().hashCode() );
         result = 37 * result + ( getFechaCreacion() == null ? 0 : this.getFechaCreacion().hashCode() );
         result = 37 * result + ( getEstado() == null ? 0 : this.getEstado().hashCode() );
         result = 37 * result + ( getNombresCompleto() == null ? 0 : this.getNombresCompleto().hashCode() );
         return result;
   }   


}


