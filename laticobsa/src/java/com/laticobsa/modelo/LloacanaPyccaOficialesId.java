package com.laticobsa.modelo;
// Generated 09-jul-2017 23:23:34 by Hibernate Tools 4.3.1



/**
 * LloacanaPyccaOficialesId generated by hbm2java
 */
public class LloacanaPyccaOficialesId  implements java.io.Serializable {


     private String camp1;
     private Integer camp2;

    public LloacanaPyccaOficialesId() {
    }

    public LloacanaPyccaOficialesId(String camp1, Integer camp2) {
       this.camp1 = camp1;
       this.camp2 = camp2;
    }
   
    public String getCamp1() {
        return this.camp1;
    }
    
    public void setCamp1(String camp1) {
        this.camp1 = camp1;
    }
    public Integer getCamp2() {
        return this.camp2;
    }
    
    public void setCamp2(Integer camp2) {
        this.camp2 = camp2;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LloacanaPyccaOficialesId) ) return false;
		 LloacanaPyccaOficialesId castOther = ( LloacanaPyccaOficialesId ) other; 
         
		 return ( (this.getCamp1()==castOther.getCamp1()) || ( this.getCamp1()!=null && castOther.getCamp1()!=null && this.getCamp1().equals(castOther.getCamp1()) ) )
 && ( (this.getCamp2()==castOther.getCamp2()) || ( this.getCamp2()!=null && castOther.getCamp2()!=null && this.getCamp2().equals(castOther.getCamp2()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCamp1() == null ? 0 : this.getCamp1().hashCode() );
         result = 37 * result + ( getCamp2() == null ? 0 : this.getCamp2().hashCode() );
         return result;
   }   


}


