package com.laticobsa.modelo;
// Generated 22-jul-2017 13:48:47 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * LcGestiones4Id generated by hbm2java
 */
public class LcGestiones4Id  implements java.io.Serializable {


     private String cartera;
     private String identificacion;
     private String nombreDeudor;
     private BigDecimal operacion;
     private Date fecha;
     private String gestor;
     private Byte resultado;
     private String detalleGestion;

    public LcGestiones4Id() {
    }

    public LcGestiones4Id(String cartera, String identificacion, String nombreDeudor, BigDecimal operacion, Date fecha, String gestor, Byte resultado, String detalleGestion) {
       this.cartera = cartera;
       this.identificacion = identificacion;
       this.nombreDeudor = nombreDeudor;
       this.operacion = operacion;
       this.fecha = fecha;
       this.gestor = gestor;
       this.resultado = resultado;
       this.detalleGestion = detalleGestion;
    }
   
    public String getCartera() {
        return this.cartera;
    }
    
    public void setCartera(String cartera) {
        this.cartera = cartera;
    }
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombreDeudor() {
        return this.nombreDeudor;
    }
    
    public void setNombreDeudor(String nombreDeudor) {
        this.nombreDeudor = nombreDeudor;
    }
    public BigDecimal getOperacion() {
        return this.operacion;
    }
    
    public void setOperacion(BigDecimal operacion) {
        this.operacion = operacion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getGestor() {
        return this.gestor;
    }
    
    public void setGestor(String gestor) {
        this.gestor = gestor;
    }
    public Byte getResultado() {
        return this.resultado;
    }
    
    public void setResultado(Byte resultado) {
        this.resultado = resultado;
    }
    public String getDetalleGestion() {
        return this.detalleGestion;
    }
    
    public void setDetalleGestion(String detalleGestion) {
        this.detalleGestion = detalleGestion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LcGestiones4Id) ) return false;
		 LcGestiones4Id castOther = ( LcGestiones4Id ) other; 
         
		 return ( (this.getCartera()==castOther.getCartera()) || ( this.getCartera()!=null && castOther.getCartera()!=null && this.getCartera().equals(castOther.getCartera()) ) )
 && ( (this.getIdentificacion()==castOther.getIdentificacion()) || ( this.getIdentificacion()!=null && castOther.getIdentificacion()!=null && this.getIdentificacion().equals(castOther.getIdentificacion()) ) )
 && ( (this.getNombreDeudor()==castOther.getNombreDeudor()) || ( this.getNombreDeudor()!=null && castOther.getNombreDeudor()!=null && this.getNombreDeudor().equals(castOther.getNombreDeudor()) ) )
 && ( (this.getOperacion()==castOther.getOperacion()) || ( this.getOperacion()!=null && castOther.getOperacion()!=null && this.getOperacion().equals(castOther.getOperacion()) ) )
 && ( (this.getFecha()==castOther.getFecha()) || ( this.getFecha()!=null && castOther.getFecha()!=null && this.getFecha().equals(castOther.getFecha()) ) )
 && ( (this.getGestor()==castOther.getGestor()) || ( this.getGestor()!=null && castOther.getGestor()!=null && this.getGestor().equals(castOther.getGestor()) ) )
 && ( (this.getResultado()==castOther.getResultado()) || ( this.getResultado()!=null && castOther.getResultado()!=null && this.getResultado().equals(castOther.getResultado()) ) )
 && ( (this.getDetalleGestion()==castOther.getDetalleGestion()) || ( this.getDetalleGestion()!=null && castOther.getDetalleGestion()!=null && this.getDetalleGestion().equals(castOther.getDetalleGestion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCartera() == null ? 0 : this.getCartera().hashCode() );
         result = 37 * result + ( getIdentificacion() == null ? 0 : this.getIdentificacion().hashCode() );
         result = 37 * result + ( getNombreDeudor() == null ? 0 : this.getNombreDeudor().hashCode() );
         result = 37 * result + ( getOperacion() == null ? 0 : this.getOperacion().hashCode() );
         result = 37 * result + ( getFecha() == null ? 0 : this.getFecha().hashCode() );
         result = 37 * result + ( getGestor() == null ? 0 : this.getGestor().hashCode() );
         result = 37 * result + ( getResultado() == null ? 0 : this.getResultado().hashCode() );
         result = 37 * result + ( getDetalleGestion() == null ? 0 : this.getDetalleGestion().hashCode() );
         return result;
   }   


}


