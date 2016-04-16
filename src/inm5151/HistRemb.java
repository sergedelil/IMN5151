/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

/**
 *
 * @author sergedelil
 */
public class HistRemb {
    
    private String soin0;
    private String soin100;
    private String soin150;
    private String soin175;
    private String soin200;
    private String soin300;
    private String soin400;
    private String soin500;
    private String soin600;
    private String soin700;
    
    public HistRemb(){}
    
    public HistRemb(String soin0,String soin100,String soin150,String soin175,
            String soin200,String soin300,String soin400,String soin500,String soin600,String soin700){
        
        this.soin0 = soin0;
        this.soin100 = soin100;
        this.soin150 = soin150;
        this.soin175 = soin175;
        this.soin200 = soin200;
        this.soin300 = soin300;
        this.soin400 = soin400;
        this.soin500 = soin500;
        this.soin600 = soin600;
        this.soin700 = soin700;
    }
    
    public void ecrireHistorique(){
    
    }
    
    public String recupererSoinHistorique(String str){
        
        String resultat = "";
        if("soin0".equals(str))
            resultat = getSoin0();
        else if("soin100".equals(str))
            resultat = getSoin100();
        else if("soin150".equals(str))
            resultat = getSoin150();
        else if("soin175".equals(str))
            resultat = getSoin175();
        else if("soin200".equals(str))
            resultat = getSoin200();
        else if("soin300".equals(str))
            resultat = getSoin300();
        else if("soin400".equals(str))
            resultat = getSoin400();
        else if("soin500".equals(str))
            resultat = getSoin500();
        else if("soin600".equals(str))
            resultat = getSoin600();
        else if("soin700".equals(str))
            resultat = getSoin700();
        return resultat;
    }
    
    public void modifierSoinHistorique(String soin, String str){
        
        if("soin0".equals(soin))
            setSoin0(str);
        else if("soin100".equals(soin))
            setSoin100(str);
        else if("soin150".equals(soin))
            setSoin150(str);
        else if("soin175".equals(soin))
            setSoin175(str);
        else if("soin200".equals(soin))
            setSoin200(str);
        else if("soin300".equals(soin))
            setSoin300(str);
        else if("soin400".equals(soin))
            setSoin400(str);
        else if("soin500".equals(soin))
            setSoin500(str);
        else if("soin600".equals(soin))
            setSoin600(str);
        else if("soin700".equals(soin))
            setSoin700(str);
    }

    /**
     * @return the soin0
     */
    public String getSoin0() {
        return soin0;
    }

    /**
     * @param soin0 the soin0 to set
     */
    public void setSoin0(String soin0) {
        this.soin0 = soin0;
    }

    /**
     * @return the soin100
     */
    public String getSoin100() {
        return soin100;
    }

    /**
     * @param soin100 the soin100 to set
     */
    public void setSoin100(String soin100) {
        this.soin100 = soin100;
    }

    /**
     * @return the soin150
     */
    public String getSoin150() {
        return soin150;
    }

    /**
     * @param soin150 the soin150 to set
     */
    public void setSoin150(String soin150) {
        this.soin150 = soin150;
    }

    /**
     * @return the soin175
     */
    public String getSoin175() {
        return soin175;
    }

    /**
     * @param soin175 the soin175 to set
     */
    public void setSoin175(String soin175) {
        this.soin175 = soin175;
    }

    /**
     * @return the soin200
     */
    public String getSoin200() {
        return soin200;
    }

    /**
     * @param soin200 the soin200 to set
     */
    public void setSoin200(String soin200) {
        this.soin200 = soin200;
    }

    /**
     * @return the soin300
     */
    public String getSoin300() {
        return soin300;
    }

    /**
     * @param soin300 the soin300 to set
     */
    public void setSoin300(String soin300) {
        this.soin300 = soin300;
    }

    /**
     * @return the soin400
     */
    public String getSoin400() {
        return soin400;
    }

    /**
     * @param soin400 the soin400 to set
     */
    public void setSoin400(String soin400) {
        this.soin400 = soin400;
    }

    /**
     * @return the soin500
     */
    public String getSoin500() {
        return soin500;
    }

    /**
     * @param soin500 the soin500 to set
     */
    public void setSoin500(String soin500) {
        this.soin500 = soin500;
    }

    /**
     * @return the soin600
     */
    public String getSoin600() {
        return soin600;
    }

    /**
     * @param soin600 the soin600 to set
     */
    public void setSoin600(String soin600) {
        this.soin600 = soin600;
    }

    /**
     * @return the soin700
     */
    public String getSoin700() {
        return soin700;
    }

    /**
     * @param soin700 the soin700 to set
     */
    public void setSoin700(String soin700) {
        this.soin700 = soin700;
    }
    
    

}
