package com.laticobsa.modelo;
// Generated 30-ago-2017 1:41:34 by Hibernate Tools 4.3.1



/**
 * LcDeudoresDocumentos generated by hbm2java
 */
public class LcDeudoresDocumentos  implements java.io.Serializable {


     private int id;
     private LcDatosDeudores lcDatosDeudores;
     private Integer idTicket;

    public LcDeudoresDocumentos() {
    }

	
    public LcDeudoresDocumentos(int id) {
        this.id = id;
    }
    public LcDeudoresDocumentos(int id, LcDatosDeudores lcDatosDeudores, Integer idTicket) {
       this.id = id;
       this.lcDatosDeudores = lcDatosDeudores;
       this.idTicket = idTicket;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public LcDatosDeudores getLcDatosDeudores() {
        return this.lcDatosDeudores;
    }
    
    public void setLcDatosDeudores(LcDatosDeudores lcDatosDeudores) {
        this.lcDatosDeudores = lcDatosDeudores;
    }
    public Integer getIdTicket() {
        return this.idTicket;
    }
    
    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }




}


