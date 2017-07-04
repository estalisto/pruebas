package com.laticobsa.modelo;
// Generated 27-jun-2017 21:14:43 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LcPiccaTmpId generated by hbm2java
 */
public class LcPiccaTmpId  implements java.io.Serializable {


     private String nombre;
     private String apellido;
     private BigDecimal cuenta;
     private Integer negociador;
     private String cedula;
     private String direccion;
     private String tel1;
     private String tel2;
     private BigDecimal tarjeta;
     private BigDecimal cupo;
     private BigDecimal deudatotal;
     private BigDecimal condonacion;
     private BigDecimal deudanvencida;
     private BigDecimal deudaVencida;
     private Date apertura;
     private Date iniciovenc;
     private BigDecimal pc30dias;
     private BigDecimal pc60dias;
     private BigDecimal pc90dias;
     private BigDecimal pc120dias;
     private BigDecimal pc120mdias;
     private Integer numeroVenc;
     private Integer diasvencidos;
     private String estados;
     private String region;
     private String direccionDom;
     private String direccionLab;
     private String referencia;
     private String telRef1;
     private String referencia2;
     private String telRef2;
     private Date fechUltimoPago;
     private BigDecimal pgoMinimo;
     private BigDecimal empleado;
     private String telefono3;
     private String telefono4;
     private String tapeNombre;
     private BigDecimal pc12meses;
     private BigDecimal pc11meses;
     private BigDecimal pc10meses;
     private BigDecimal pc9meses;
     private BigDecimal pc8meses;
     private BigDecimal pc7meses;
     private BigDecimal pc6meses;
     private BigDecimal pc5meses;
     private BigDecimal pc4meses;
     private BigDecimal pc3meses;
     private BigDecimal pc2meses;
     private BigDecimal pc1meses;
     private BigDecimal vecesVenc;
     private BigDecimal veces1vez;
     private BigDecimal pjsdvpp;
     private BigDecimal pjvecesven;
     private BigDecimal pjpagomin;
     private BigDecimal puntaje;
     private String email;
     private String supercredito;
     private Integer idCiudad;

    public LcPiccaTmpId() {
    }

    public LcPiccaTmpId(String nombre, String apellido, BigDecimal cuenta, Integer negociador, String cedula, String direccion, String tel1, String tel2, BigDecimal tarjeta, BigDecimal cupo, BigDecimal deudatotal, BigDecimal condonacion, BigDecimal deudanvencida, BigDecimal deudaVencida, Date apertura, Date iniciovenc, BigDecimal pc30dias, BigDecimal pc60dias, BigDecimal pc90dias, BigDecimal pc120dias, BigDecimal pc120mdias, Integer numeroVenc, Integer diasvencidos, String estados, String region, String direccionDom, String direccionLab, String referencia, String telRef1, String referencia2, String telRef2, Date fechUltimoPago, BigDecimal pgoMinimo, BigDecimal empleado, String telefono3, String telefono4, String tapeNombre, BigDecimal pc12meses, BigDecimal pc11meses, BigDecimal pc10meses, BigDecimal pc9meses, BigDecimal pc8meses, BigDecimal pc7meses, BigDecimal pc6meses, BigDecimal pc5meses, BigDecimal pc4meses, BigDecimal pc3meses, BigDecimal pc2meses, BigDecimal pc1meses, BigDecimal vecesVenc, BigDecimal veces1vez, BigDecimal pjsdvpp, BigDecimal pjvecesven, BigDecimal pjpagomin, BigDecimal puntaje, String email, String supercredito, Integer idCiudad) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.cuenta = cuenta;
       this.negociador = negociador;
       this.cedula = cedula;
       this.direccion = direccion;
       this.tel1 = tel1;
       this.tel2 = tel2;
       this.tarjeta = tarjeta;
       this.cupo = cupo;
       this.deudatotal = deudatotal;
       this.condonacion = condonacion;
       this.deudanvencida = deudanvencida;
       this.deudaVencida = deudaVencida;
       this.apertura = apertura;
       this.iniciovenc = iniciovenc;
       this.pc30dias = pc30dias;
       this.pc60dias = pc60dias;
       this.pc90dias = pc90dias;
       this.pc120dias = pc120dias;
       this.pc120mdias = pc120mdias;
       this.numeroVenc = numeroVenc;
       this.diasvencidos = diasvencidos;
       this.estados = estados;
       this.region = region;
       this.direccionDom = direccionDom;
       this.direccionLab = direccionLab;
       this.referencia = referencia;
       this.telRef1 = telRef1;
       this.referencia2 = referencia2;
       this.telRef2 = telRef2;
       this.fechUltimoPago = fechUltimoPago;
       this.pgoMinimo = pgoMinimo;
       this.empleado = empleado;
       this.telefono3 = telefono3;
       this.telefono4 = telefono4;
       this.tapeNombre = tapeNombre;
       this.pc12meses = pc12meses;
       this.pc11meses = pc11meses;
       this.pc10meses = pc10meses;
       this.pc9meses = pc9meses;
       this.pc8meses = pc8meses;
       this.pc7meses = pc7meses;
       this.pc6meses = pc6meses;
       this.pc5meses = pc5meses;
       this.pc4meses = pc4meses;
       this.pc3meses = pc3meses;
       this.pc2meses = pc2meses;
       this.pc1meses = pc1meses;
       this.vecesVenc = vecesVenc;
       this.veces1vez = veces1vez;
       this.pjsdvpp = pjsdvpp;
       this.pjvecesven = pjvecesven;
       this.pjpagomin = pjpagomin;
       this.puntaje = puntaje;
       this.email = email;
       this.supercredito = supercredito;
       this.idCiudad = idCiudad;
    }
   
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public BigDecimal getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(BigDecimal cuenta) {
        this.cuenta = cuenta;
    }
    public Integer getNegociador() {
        return this.negociador;
    }
    
    public void setNegociador(Integer negociador) {
        this.negociador = negociador;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTel1() {
        return this.tel1;
    }
    
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }
    public String getTel2() {
        return this.tel2;
    }
    
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }
    public BigDecimal getTarjeta() {
        return this.tarjeta;
    }
    
    public void setTarjeta(BigDecimal tarjeta) {
        this.tarjeta = tarjeta;
    }
    public BigDecimal getCupo() {
        return this.cupo;
    }
    
    public void setCupo(BigDecimal cupo) {
        this.cupo = cupo;
    }
    public BigDecimal getDeudatotal() {
        return this.deudatotal;
    }
    
    public void setDeudatotal(BigDecimal deudatotal) {
        this.deudatotal = deudatotal;
    }
    public BigDecimal getCondonacion() {
        return this.condonacion;
    }
    
    public void setCondonacion(BigDecimal condonacion) {
        this.condonacion = condonacion;
    }
    public BigDecimal getDeudanvencida() {
        return this.deudanvencida;
    }
    
    public void setDeudanvencida(BigDecimal deudanvencida) {
        this.deudanvencida = deudanvencida;
    }
    public BigDecimal getDeudaVencida() {
        return this.deudaVencida;
    }
    
    public void setDeudaVencida(BigDecimal deudaVencida) {
        this.deudaVencida = deudaVencida;
    }
    public Date getApertura() {
        return this.apertura;
    }
    
    public void setApertura(Date apertura) {
        this.apertura = apertura;
    }
    public Date getIniciovenc() {
        return this.iniciovenc;
    }
    
    public void setIniciovenc(Date iniciovenc) {
        this.iniciovenc = iniciovenc;
    }
    public BigDecimal getPc30dias() {
        return this.pc30dias;
    }
    
    public void setPc30dias(BigDecimal pc30dias) {
        this.pc30dias = pc30dias;
    }
    public BigDecimal getPc60dias() {
        return this.pc60dias;
    }
    
    public void setPc60dias(BigDecimal pc60dias) {
        this.pc60dias = pc60dias;
    }
    public BigDecimal getPc90dias() {
        return this.pc90dias;
    }
    
    public void setPc90dias(BigDecimal pc90dias) {
        this.pc90dias = pc90dias;
    }
    public BigDecimal getPc120dias() {
        return this.pc120dias;
    }
    
    public void setPc120dias(BigDecimal pc120dias) {
        this.pc120dias = pc120dias;
    }
    public BigDecimal getPc120mdias() {
        return this.pc120mdias;
    }
    
    public void setPc120mdias(BigDecimal pc120mdias) {
        this.pc120mdias = pc120mdias;
    }
    public Integer getNumeroVenc() {
        return this.numeroVenc;
    }
    
    public void setNumeroVenc(Integer numeroVenc) {
        this.numeroVenc = numeroVenc;
    }
    public Integer getDiasvencidos() {
        return this.diasvencidos;
    }
    
    public void setDiasvencidos(Integer diasvencidos) {
        this.diasvencidos = diasvencidos;
    }
    public String getEstados() {
        return this.estados;
    }
    
    public void setEstados(String estados) {
        this.estados = estados;
    }
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    public String getDireccionDom() {
        return this.direccionDom;
    }
    
    public void setDireccionDom(String direccionDom) {
        this.direccionDom = direccionDom;
    }
    public String getDireccionLab() {
        return this.direccionLab;
    }
    
    public void setDireccionLab(String direccionLab) {
        this.direccionLab = direccionLab;
    }
    public String getReferencia() {
        return this.referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public String getTelRef1() {
        return this.telRef1;
    }
    
    public void setTelRef1(String telRef1) {
        this.telRef1 = telRef1;
    }
    public String getReferencia2() {
        return this.referencia2;
    }
    
    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }
    public String getTelRef2() {
        return this.telRef2;
    }
    
    public void setTelRef2(String telRef2) {
        this.telRef2 = telRef2;
    }
    public Date getFechUltimoPago() {
        return this.fechUltimoPago;
    }
    
    public void setFechUltimoPago(Date fechUltimoPago) {
        this.fechUltimoPago = fechUltimoPago;
    }
    public BigDecimal getPgoMinimo() {
        return this.pgoMinimo;
    }
    
    public void setPgoMinimo(BigDecimal pgoMinimo) {
        this.pgoMinimo = pgoMinimo;
    }
    public BigDecimal getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(BigDecimal empleado) {
        this.empleado = empleado;
    }
    public String getTelefono3() {
        return this.telefono3;
    }
    
    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }
    public String getTelefono4() {
        return this.telefono4;
    }
    
    public void setTelefono4(String telefono4) {
        this.telefono4 = telefono4;
    }
    public String getTapeNombre() {
        return this.tapeNombre;
    }
    
    public void setTapeNombre(String tapeNombre) {
        this.tapeNombre = tapeNombre;
    }
    public BigDecimal getPc12meses() {
        return this.pc12meses;
    }
    
    public void setPc12meses(BigDecimal pc12meses) {
        this.pc12meses = pc12meses;
    }
    public BigDecimal getPc11meses() {
        return this.pc11meses;
    }
    
    public void setPc11meses(BigDecimal pc11meses) {
        this.pc11meses = pc11meses;
    }
    public BigDecimal getPc10meses() {
        return this.pc10meses;
    }
    
    public void setPc10meses(BigDecimal pc10meses) {
        this.pc10meses = pc10meses;
    }
    public BigDecimal getPc9meses() {
        return this.pc9meses;
    }
    
    public void setPc9meses(BigDecimal pc9meses) {
        this.pc9meses = pc9meses;
    }
    public BigDecimal getPc8meses() {
        return this.pc8meses;
    }
    
    public void setPc8meses(BigDecimal pc8meses) {
        this.pc8meses = pc8meses;
    }
    public BigDecimal getPc7meses() {
        return this.pc7meses;
    }
    
    public void setPc7meses(BigDecimal pc7meses) {
        this.pc7meses = pc7meses;
    }
    public BigDecimal getPc6meses() {
        return this.pc6meses;
    }
    
    public void setPc6meses(BigDecimal pc6meses) {
        this.pc6meses = pc6meses;
    }
    public BigDecimal getPc5meses() {
        return this.pc5meses;
    }
    
    public void setPc5meses(BigDecimal pc5meses) {
        this.pc5meses = pc5meses;
    }
    public BigDecimal getPc4meses() {
        return this.pc4meses;
    }
    
    public void setPc4meses(BigDecimal pc4meses) {
        this.pc4meses = pc4meses;
    }
    public BigDecimal getPc3meses() {
        return this.pc3meses;
    }
    
    public void setPc3meses(BigDecimal pc3meses) {
        this.pc3meses = pc3meses;
    }
    public BigDecimal getPc2meses() {
        return this.pc2meses;
    }
    
    public void setPc2meses(BigDecimal pc2meses) {
        this.pc2meses = pc2meses;
    }
    public BigDecimal getPc1meses() {
        return this.pc1meses;
    }
    
    public void setPc1meses(BigDecimal pc1meses) {
        this.pc1meses = pc1meses;
    }
    public BigDecimal getVecesVenc() {
        return this.vecesVenc;
    }
    
    public void setVecesVenc(BigDecimal vecesVenc) {
        this.vecesVenc = vecesVenc;
    }
    public BigDecimal getVeces1vez() {
        return this.veces1vez;
    }
    
    public void setVeces1vez(BigDecimal veces1vez) {
        this.veces1vez = veces1vez;
    }
    public BigDecimal getPjsdvpp() {
        return this.pjsdvpp;
    }
    
    public void setPjsdvpp(BigDecimal pjsdvpp) {
        this.pjsdvpp = pjsdvpp;
    }
    public BigDecimal getPjvecesven() {
        return this.pjvecesven;
    }
    
    public void setPjvecesven(BigDecimal pjvecesven) {
        this.pjvecesven = pjvecesven;
    }
    public BigDecimal getPjpagomin() {
        return this.pjpagomin;
    }
    
    public void setPjpagomin(BigDecimal pjpagomin) {
        this.pjpagomin = pjpagomin;
    }
    public BigDecimal getPuntaje() {
        return this.puntaje;
    }
    
    public void setPuntaje(BigDecimal puntaje) {
        this.puntaje = puntaje;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSupercredito() {
        return this.supercredito;
    }
    
    public void setSupercredito(String supercredito) {
        this.supercredito = supercredito;
    }
    public Integer getIdCiudad() {
        return this.idCiudad;
    }
    
    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LcPiccaTmpId) ) return false;
		 LcPiccaTmpId castOther = ( LcPiccaTmpId ) other; 
         
		 return ( (this.getNombre()==castOther.getNombre()) || ( this.getNombre()!=null && castOther.getNombre()!=null && this.getNombre().equals(castOther.getNombre()) ) )
 && ( (this.getApellido()==castOther.getApellido()) || ( this.getApellido()!=null && castOther.getApellido()!=null && this.getApellido().equals(castOther.getApellido()) ) )
 && ( (this.getCuenta()==castOther.getCuenta()) || ( this.getCuenta()!=null && castOther.getCuenta()!=null && this.getCuenta().equals(castOther.getCuenta()) ) )
 && ( (this.getNegociador()==castOther.getNegociador()) || ( this.getNegociador()!=null && castOther.getNegociador()!=null && this.getNegociador().equals(castOther.getNegociador()) ) )
 && ( (this.getCedula()==castOther.getCedula()) || ( this.getCedula()!=null && castOther.getCedula()!=null && this.getCedula().equals(castOther.getCedula()) ) )
 && ( (this.getDireccion()==castOther.getDireccion()) || ( this.getDireccion()!=null && castOther.getDireccion()!=null && this.getDireccion().equals(castOther.getDireccion()) ) )
 && ( (this.getTel1()==castOther.getTel1()) || ( this.getTel1()!=null && castOther.getTel1()!=null && this.getTel1().equals(castOther.getTel1()) ) )
 && ( (this.getTel2()==castOther.getTel2()) || ( this.getTel2()!=null && castOther.getTel2()!=null && this.getTel2().equals(castOther.getTel2()) ) )
 && ( (this.getTarjeta()==castOther.getTarjeta()) || ( this.getTarjeta()!=null && castOther.getTarjeta()!=null && this.getTarjeta().equals(castOther.getTarjeta()) ) )
 && ( (this.getCupo()==castOther.getCupo()) || ( this.getCupo()!=null && castOther.getCupo()!=null && this.getCupo().equals(castOther.getCupo()) ) )
 && ( (this.getDeudatotal()==castOther.getDeudatotal()) || ( this.getDeudatotal()!=null && castOther.getDeudatotal()!=null && this.getDeudatotal().equals(castOther.getDeudatotal()) ) )
 && ( (this.getCondonacion()==castOther.getCondonacion()) || ( this.getCondonacion()!=null && castOther.getCondonacion()!=null && this.getCondonacion().equals(castOther.getCondonacion()) ) )
 && ( (this.getDeudanvencida()==castOther.getDeudanvencida()) || ( this.getDeudanvencida()!=null && castOther.getDeudanvencida()!=null && this.getDeudanvencida().equals(castOther.getDeudanvencida()) ) )
 && ( (this.getDeudaVencida()==castOther.getDeudaVencida()) || ( this.getDeudaVencida()!=null && castOther.getDeudaVencida()!=null && this.getDeudaVencida().equals(castOther.getDeudaVencida()) ) )
 && ( (this.getApertura()==castOther.getApertura()) || ( this.getApertura()!=null && castOther.getApertura()!=null && this.getApertura().equals(castOther.getApertura()) ) )
 && ( (this.getIniciovenc()==castOther.getIniciovenc()) || ( this.getIniciovenc()!=null && castOther.getIniciovenc()!=null && this.getIniciovenc().equals(castOther.getIniciovenc()) ) )
 && ( (this.getPc30dias()==castOther.getPc30dias()) || ( this.getPc30dias()!=null && castOther.getPc30dias()!=null && this.getPc30dias().equals(castOther.getPc30dias()) ) )
 && ( (this.getPc60dias()==castOther.getPc60dias()) || ( this.getPc60dias()!=null && castOther.getPc60dias()!=null && this.getPc60dias().equals(castOther.getPc60dias()) ) )
 && ( (this.getPc90dias()==castOther.getPc90dias()) || ( this.getPc90dias()!=null && castOther.getPc90dias()!=null && this.getPc90dias().equals(castOther.getPc90dias()) ) )
 && ( (this.getPc120dias()==castOther.getPc120dias()) || ( this.getPc120dias()!=null && castOther.getPc120dias()!=null && this.getPc120dias().equals(castOther.getPc120dias()) ) )
 && ( (this.getPc120mdias()==castOther.getPc120mdias()) || ( this.getPc120mdias()!=null && castOther.getPc120mdias()!=null && this.getPc120mdias().equals(castOther.getPc120mdias()) ) )
 && ( (this.getNumeroVenc()==castOther.getNumeroVenc()) || ( this.getNumeroVenc()!=null && castOther.getNumeroVenc()!=null && this.getNumeroVenc().equals(castOther.getNumeroVenc()) ) )
 && ( (this.getDiasvencidos()==castOther.getDiasvencidos()) || ( this.getDiasvencidos()!=null && castOther.getDiasvencidos()!=null && this.getDiasvencidos().equals(castOther.getDiasvencidos()) ) )
 && ( (this.getEstados()==castOther.getEstados()) || ( this.getEstados()!=null && castOther.getEstados()!=null && this.getEstados().equals(castOther.getEstados()) ) )
 && ( (this.getRegion()==castOther.getRegion()) || ( this.getRegion()!=null && castOther.getRegion()!=null && this.getRegion().equals(castOther.getRegion()) ) )
 && ( (this.getDireccionDom()==castOther.getDireccionDom()) || ( this.getDireccionDom()!=null && castOther.getDireccionDom()!=null && this.getDireccionDom().equals(castOther.getDireccionDom()) ) )
 && ( (this.getDireccionLab()==castOther.getDireccionLab()) || ( this.getDireccionLab()!=null && castOther.getDireccionLab()!=null && this.getDireccionLab().equals(castOther.getDireccionLab()) ) )
 && ( (this.getReferencia()==castOther.getReferencia()) || ( this.getReferencia()!=null && castOther.getReferencia()!=null && this.getReferencia().equals(castOther.getReferencia()) ) )
 && ( (this.getTelRef1()==castOther.getTelRef1()) || ( this.getTelRef1()!=null && castOther.getTelRef1()!=null && this.getTelRef1().equals(castOther.getTelRef1()) ) )
 && ( (this.getReferencia2()==castOther.getReferencia2()) || ( this.getReferencia2()!=null && castOther.getReferencia2()!=null && this.getReferencia2().equals(castOther.getReferencia2()) ) )
 && ( (this.getTelRef2()==castOther.getTelRef2()) || ( this.getTelRef2()!=null && castOther.getTelRef2()!=null && this.getTelRef2().equals(castOther.getTelRef2()) ) )
 && ( (this.getFechUltimoPago()==castOther.getFechUltimoPago()) || ( this.getFechUltimoPago()!=null && castOther.getFechUltimoPago()!=null && this.getFechUltimoPago().equals(castOther.getFechUltimoPago()) ) )
 && ( (this.getPgoMinimo()==castOther.getPgoMinimo()) || ( this.getPgoMinimo()!=null && castOther.getPgoMinimo()!=null && this.getPgoMinimo().equals(castOther.getPgoMinimo()) ) )
 && ( (this.getEmpleado()==castOther.getEmpleado()) || ( this.getEmpleado()!=null && castOther.getEmpleado()!=null && this.getEmpleado().equals(castOther.getEmpleado()) ) )
 && ( (this.getTelefono3()==castOther.getTelefono3()) || ( this.getTelefono3()!=null && castOther.getTelefono3()!=null && this.getTelefono3().equals(castOther.getTelefono3()) ) )
 && ( (this.getTelefono4()==castOther.getTelefono4()) || ( this.getTelefono4()!=null && castOther.getTelefono4()!=null && this.getTelefono4().equals(castOther.getTelefono4()) ) )
 && ( (this.getTapeNombre()==castOther.getTapeNombre()) || ( this.getTapeNombre()!=null && castOther.getTapeNombre()!=null && this.getTapeNombre().equals(castOther.getTapeNombre()) ) )
 && ( (this.getPc12meses()==castOther.getPc12meses()) || ( this.getPc12meses()!=null && castOther.getPc12meses()!=null && this.getPc12meses().equals(castOther.getPc12meses()) ) )
 && ( (this.getPc11meses()==castOther.getPc11meses()) || ( this.getPc11meses()!=null && castOther.getPc11meses()!=null && this.getPc11meses().equals(castOther.getPc11meses()) ) )
 && ( (this.getPc10meses()==castOther.getPc10meses()) || ( this.getPc10meses()!=null && castOther.getPc10meses()!=null && this.getPc10meses().equals(castOther.getPc10meses()) ) )
 && ( (this.getPc9meses()==castOther.getPc9meses()) || ( this.getPc9meses()!=null && castOther.getPc9meses()!=null && this.getPc9meses().equals(castOther.getPc9meses()) ) )
 && ( (this.getPc8meses()==castOther.getPc8meses()) || ( this.getPc8meses()!=null && castOther.getPc8meses()!=null && this.getPc8meses().equals(castOther.getPc8meses()) ) )
 && ( (this.getPc7meses()==castOther.getPc7meses()) || ( this.getPc7meses()!=null && castOther.getPc7meses()!=null && this.getPc7meses().equals(castOther.getPc7meses()) ) )
 && ( (this.getPc6meses()==castOther.getPc6meses()) || ( this.getPc6meses()!=null && castOther.getPc6meses()!=null && this.getPc6meses().equals(castOther.getPc6meses()) ) )
 && ( (this.getPc5meses()==castOther.getPc5meses()) || ( this.getPc5meses()!=null && castOther.getPc5meses()!=null && this.getPc5meses().equals(castOther.getPc5meses()) ) )
 && ( (this.getPc4meses()==castOther.getPc4meses()) || ( this.getPc4meses()!=null && castOther.getPc4meses()!=null && this.getPc4meses().equals(castOther.getPc4meses()) ) )
 && ( (this.getPc3meses()==castOther.getPc3meses()) || ( this.getPc3meses()!=null && castOther.getPc3meses()!=null && this.getPc3meses().equals(castOther.getPc3meses()) ) )
 && ( (this.getPc2meses()==castOther.getPc2meses()) || ( this.getPc2meses()!=null && castOther.getPc2meses()!=null && this.getPc2meses().equals(castOther.getPc2meses()) ) )
 && ( (this.getPc1meses()==castOther.getPc1meses()) || ( this.getPc1meses()!=null && castOther.getPc1meses()!=null && this.getPc1meses().equals(castOther.getPc1meses()) ) )
 && ( (this.getVecesVenc()==castOther.getVecesVenc()) || ( this.getVecesVenc()!=null && castOther.getVecesVenc()!=null && this.getVecesVenc().equals(castOther.getVecesVenc()) ) )
 && ( (this.getVeces1vez()==castOther.getVeces1vez()) || ( this.getVeces1vez()!=null && castOther.getVeces1vez()!=null && this.getVeces1vez().equals(castOther.getVeces1vez()) ) )
 && ( (this.getPjsdvpp()==castOther.getPjsdvpp()) || ( this.getPjsdvpp()!=null && castOther.getPjsdvpp()!=null && this.getPjsdvpp().equals(castOther.getPjsdvpp()) ) )
 && ( (this.getPjvecesven()==castOther.getPjvecesven()) || ( this.getPjvecesven()!=null && castOther.getPjvecesven()!=null && this.getPjvecesven().equals(castOther.getPjvecesven()) ) )
 && ( (this.getPjpagomin()==castOther.getPjpagomin()) || ( this.getPjpagomin()!=null && castOther.getPjpagomin()!=null && this.getPjpagomin().equals(castOther.getPjpagomin()) ) )
 && ( (this.getPuntaje()==castOther.getPuntaje()) || ( this.getPuntaje()!=null && castOther.getPuntaje()!=null && this.getPuntaje().equals(castOther.getPuntaje()) ) )
 && ( (this.getEmail()==castOther.getEmail()) || ( this.getEmail()!=null && castOther.getEmail()!=null && this.getEmail().equals(castOther.getEmail()) ) )
 && ( (this.getSupercredito()==castOther.getSupercredito()) || ( this.getSupercredito()!=null && castOther.getSupercredito()!=null && this.getSupercredito().equals(castOther.getSupercredito()) ) )
 && ( (this.getIdCiudad()==castOther.getIdCiudad()) || ( this.getIdCiudad()!=null && castOther.getIdCiudad()!=null && this.getIdCiudad().equals(castOther.getIdCiudad()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNombre() == null ? 0 : this.getNombre().hashCode() );
         result = 37 * result + ( getApellido() == null ? 0 : this.getApellido().hashCode() );
         result = 37 * result + ( getCuenta() == null ? 0 : this.getCuenta().hashCode() );
         result = 37 * result + ( getNegociador() == null ? 0 : this.getNegociador().hashCode() );
         result = 37 * result + ( getCedula() == null ? 0 : this.getCedula().hashCode() );
         result = 37 * result + ( getDireccion() == null ? 0 : this.getDireccion().hashCode() );
         result = 37 * result + ( getTel1() == null ? 0 : this.getTel1().hashCode() );
         result = 37 * result + ( getTel2() == null ? 0 : this.getTel2().hashCode() );
         result = 37 * result + ( getTarjeta() == null ? 0 : this.getTarjeta().hashCode() );
         result = 37 * result + ( getCupo() == null ? 0 : this.getCupo().hashCode() );
         result = 37 * result + ( getDeudatotal() == null ? 0 : this.getDeudatotal().hashCode() );
         result = 37 * result + ( getCondonacion() == null ? 0 : this.getCondonacion().hashCode() );
         result = 37 * result + ( getDeudanvencida() == null ? 0 : this.getDeudanvencida().hashCode() );
         result = 37 * result + ( getDeudaVencida() == null ? 0 : this.getDeudaVencida().hashCode() );
         result = 37 * result + ( getApertura() == null ? 0 : this.getApertura().hashCode() );
         result = 37 * result + ( getIniciovenc() == null ? 0 : this.getIniciovenc().hashCode() );
         result = 37 * result + ( getPc30dias() == null ? 0 : this.getPc30dias().hashCode() );
         result = 37 * result + ( getPc60dias() == null ? 0 : this.getPc60dias().hashCode() );
         result = 37 * result + ( getPc90dias() == null ? 0 : this.getPc90dias().hashCode() );
         result = 37 * result + ( getPc120dias() == null ? 0 : this.getPc120dias().hashCode() );
         result = 37 * result + ( getPc120mdias() == null ? 0 : this.getPc120mdias().hashCode() );
         result = 37 * result + ( getNumeroVenc() == null ? 0 : this.getNumeroVenc().hashCode() );
         result = 37 * result + ( getDiasvencidos() == null ? 0 : this.getDiasvencidos().hashCode() );
         result = 37 * result + ( getEstados() == null ? 0 : this.getEstados().hashCode() );
         result = 37 * result + ( getRegion() == null ? 0 : this.getRegion().hashCode() );
         result = 37 * result + ( getDireccionDom() == null ? 0 : this.getDireccionDom().hashCode() );
         result = 37 * result + ( getDireccionLab() == null ? 0 : this.getDireccionLab().hashCode() );
         result = 37 * result + ( getReferencia() == null ? 0 : this.getReferencia().hashCode() );
         result = 37 * result + ( getTelRef1() == null ? 0 : this.getTelRef1().hashCode() );
         result = 37 * result + ( getReferencia2() == null ? 0 : this.getReferencia2().hashCode() );
         result = 37 * result + ( getTelRef2() == null ? 0 : this.getTelRef2().hashCode() );
         result = 37 * result + ( getFechUltimoPago() == null ? 0 : this.getFechUltimoPago().hashCode() );
         result = 37 * result + ( getPgoMinimo() == null ? 0 : this.getPgoMinimo().hashCode() );
         result = 37 * result + ( getEmpleado() == null ? 0 : this.getEmpleado().hashCode() );
         result = 37 * result + ( getTelefono3() == null ? 0 : this.getTelefono3().hashCode() );
         result = 37 * result + ( getTelefono4() == null ? 0 : this.getTelefono4().hashCode() );
         result = 37 * result + ( getTapeNombre() == null ? 0 : this.getTapeNombre().hashCode() );
         result = 37 * result + ( getPc12meses() == null ? 0 : this.getPc12meses().hashCode() );
         result = 37 * result + ( getPc11meses() == null ? 0 : this.getPc11meses().hashCode() );
         result = 37 * result + ( getPc10meses() == null ? 0 : this.getPc10meses().hashCode() );
         result = 37 * result + ( getPc9meses() == null ? 0 : this.getPc9meses().hashCode() );
         result = 37 * result + ( getPc8meses() == null ? 0 : this.getPc8meses().hashCode() );
         result = 37 * result + ( getPc7meses() == null ? 0 : this.getPc7meses().hashCode() );
         result = 37 * result + ( getPc6meses() == null ? 0 : this.getPc6meses().hashCode() );
         result = 37 * result + ( getPc5meses() == null ? 0 : this.getPc5meses().hashCode() );
         result = 37 * result + ( getPc4meses() == null ? 0 : this.getPc4meses().hashCode() );
         result = 37 * result + ( getPc3meses() == null ? 0 : this.getPc3meses().hashCode() );
         result = 37 * result + ( getPc2meses() == null ? 0 : this.getPc2meses().hashCode() );
         result = 37 * result + ( getPc1meses() == null ? 0 : this.getPc1meses().hashCode() );
         result = 37 * result + ( getVecesVenc() == null ? 0 : this.getVecesVenc().hashCode() );
         result = 37 * result + ( getVeces1vez() == null ? 0 : this.getVeces1vez().hashCode() );
         result = 37 * result + ( getPjsdvpp() == null ? 0 : this.getPjsdvpp().hashCode() );
         result = 37 * result + ( getPjvecesven() == null ? 0 : this.getPjvecesven().hashCode() );
         result = 37 * result + ( getPjpagomin() == null ? 0 : this.getPjpagomin().hashCode() );
         result = 37 * result + ( getPuntaje() == null ? 0 : this.getPuntaje().hashCode() );
         result = 37 * result + ( getEmail() == null ? 0 : this.getEmail().hashCode() );
         result = 37 * result + ( getSupercredito() == null ? 0 : this.getSupercredito().hashCode() );
         result = 37 * result + ( getIdCiudad() == null ? 0 : this.getIdCiudad().hashCode() );
         return result;
   }   


}


