package com.laticobsa.modelo;
// Generated 31-jul-2017 17:40:44 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LcClientes generated by hbm2java
 */
public class LcClientes  implements java.io.Serializable {


     private int idCliente;
     private LcCiudad lcCiudad;
     private LcEmpresa lcEmpresa;
     private LcPais lcPais;
     private LcProvincia lcProvincia;
     private LcTiposIdentificacion lcTiposIdentificacion;
     private String identificacion;
     private String razonSocial;
     private String direccion;
     private String contacto;
     private String email;
     private String telefono;
     private String extensioon;
     private String celular;
     private Date fechaCreacion;
     private String estado;
     private Set lcTransaccioneses = new HashSet(0);
     private Set lcRecordatorioses = new HashSet(0);
     private Set lcDeudors = new HashSet(0);
     private Set lcClienteResultados = new HashSet(0);
     private Set lcCarteras = new HashSet(0);
     private Set lcGestioneses = new HashSet(0);

    public LcClientes() {
    }

	
    public LcClientes(int idCliente) {
        this.idCliente = idCliente;
    }
    public LcClientes(int idCliente, LcCiudad lcCiudad, LcEmpresa lcEmpresa, LcPais lcPais, LcProvincia lcProvincia, LcTiposIdentificacion lcTiposIdentificacion, String identificacion, String razonSocial, String direccion, String contacto, String email, String telefono, String extensioon, String celular, Date fechaCreacion, String estado, Set lcTransaccioneses, Set lcRecordatorioses, Set lcDeudors, Set lcClienteResultados, Set lcCarteras, Set lcGestioneses) {
       this.idCliente = idCliente;
       this.lcCiudad = lcCiudad;
       this.lcEmpresa = lcEmpresa;
       this.lcPais = lcPais;
       this.lcProvincia = lcProvincia;
       this.lcTiposIdentificacion = lcTiposIdentificacion;
       this.identificacion = identificacion;
       this.razonSocial = razonSocial;
       this.direccion = direccion;
       this.contacto = contacto;
       this.email = email;
       this.telefono = telefono;
       this.extensioon = extensioon;
       this.celular = celular;
       this.fechaCreacion = fechaCreacion;
       this.estado = estado;
       this.lcTransaccioneses = lcTransaccioneses;
       this.lcRecordatorioses = lcRecordatorioses;
       this.lcDeudors = lcDeudors;
       this.lcClienteResultados = lcClienteResultados;
       this.lcCarteras = lcCarteras;
       this.lcGestioneses = lcGestioneses;
    }
   
    public int getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public LcCiudad getLcCiudad() {
        return this.lcCiudad;
    }
    
    public void setLcCiudad(LcCiudad lcCiudad) {
        this.lcCiudad = lcCiudad;
    }
    public LcEmpresa getLcEmpresa() {
        return this.lcEmpresa;
    }
    
    public void setLcEmpresa(LcEmpresa lcEmpresa) {
        this.lcEmpresa = lcEmpresa;
    }
    public LcPais getLcPais() {
        return this.lcPais;
    }
    
    public void setLcPais(LcPais lcPais) {
        this.lcPais = lcPais;
    }
    public LcProvincia getLcProvincia() {
        return this.lcProvincia;
    }
    
    public void setLcProvincia(LcProvincia lcProvincia) {
        this.lcProvincia = lcProvincia;
    }
    public LcTiposIdentificacion getLcTiposIdentificacion() {
        return this.lcTiposIdentificacion;
    }
    
    public void setLcTiposIdentificacion(LcTiposIdentificacion lcTiposIdentificacion) {
        this.lcTiposIdentificacion = lcTiposIdentificacion;
    }
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getExtensioon() {
        return this.extensioon;
    }
    
    public void setExtensioon(String extensioon) {
        this.extensioon = extensioon;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
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
    public Set getLcTransaccioneses() {
        return this.lcTransaccioneses;
    }
    
    public void setLcTransaccioneses(Set lcTransaccioneses) {
        this.lcTransaccioneses = lcTransaccioneses;
    }
    public Set getLcRecordatorioses() {
        return this.lcRecordatorioses;
    }
    
    public void setLcRecordatorioses(Set lcRecordatorioses) {
        this.lcRecordatorioses = lcRecordatorioses;
    }
    public Set getLcDeudors() {
        return this.lcDeudors;
    }
    
    public void setLcDeudors(Set lcDeudors) {
        this.lcDeudors = lcDeudors;
    }
    public Set getLcClienteResultados() {
        return this.lcClienteResultados;
    }
    
    public void setLcClienteResultados(Set lcClienteResultados) {
        this.lcClienteResultados = lcClienteResultados;
    }
    public Set getLcCarteras() {
        return this.lcCarteras;
    }
    
    public void setLcCarteras(Set lcCarteras) {
        this.lcCarteras = lcCarteras;
    }
    public Set getLcGestioneses() {
        return this.lcGestioneses;
    }
    
    public void setLcGestioneses(Set lcGestioneses) {
        this.lcGestioneses = lcGestioneses;
    }




}


