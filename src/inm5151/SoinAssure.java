/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class SoinAssure {
    
    private double pourcentage;
    private double limite;
    private String numSoin;
    private double limiteMensuelle;

    
    public SoinAssure(){}
    
    public SoinAssure(String numSoin, double pourcentage, double limite, double limiteMensuelle) {
        
        this.pourcentage = pourcentage;
        this.limite = limite;
        this.numSoin = numSoin;
        this.limiteMensuelle = limiteMensuelle;
    }
    
    public  boolean admetLimiteMensuelle(){
        
        return limiteMensuelle != 0.0;
    }
    
    public String getNumSoin(){
        return numSoin;
    }
    
    public double getPourcentage(){
        return pourcentage;
    }
    
    public double getLimite(){
        return limite;
    }
    
    public void setNumSoin(String num){
        numSoin = num;
    }
    
    public void setPourcentage(double percent){
        pourcentage = percent;
    }
    
    
    public void setLimite(double valeur){
        limite = valeur;
    }
    
    public boolean validerNumeroSoin(){
        
        return (numSoin.matches("^(0|150|175|[1-7]0{2}|3[0-9]{2})$"));
    }
    
    public boolean validerLaCouvertureDuSoin() {

        return (pourcentage >= 0 && pourcentage <= 1);
    }
    
    public boolean validerLaLimiteDuSoin() {

        return (limite >= 0);
    }

    /**
     * @return the limiteMensuelle
     */
    public double getLimiteMensuelle() {
        return limiteMensuelle;
    }

    /**
     * @param limiteMensuelle the limiteMensuelle to set
     */
    public void setLimiteMensuelle(double limiteMensuelle) {
        this.limiteMensuelle = limiteMensuelle;
    }
}
