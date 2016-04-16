/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;
import static inm5151.Message.*;
import java.util.*;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class Client {
    
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String courriel;
    private String contrat;
    private List<Beneficiaire> listeBeneficiares;
    
    public Client(String nom, String prenom, String dateNaiss, String courriel,String contrat){
    
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.courriel = courriel;
        this.contrat = contrat;
        this.listeBeneficiares = new ArrayList();
    }
    public Client(){}
    
    public boolean ajouterBeneficiaire(Beneficiaire b){
    
        return this.listeBeneficiares.add(b);
    }
    
    public boolean supprimerBeneficiaire(Beneficiaire b){
    
        return this.listeBeneficiares.remove(b);
    }
    
    public int nbBeneficiaire(){
    
        return this.listeBeneficiares.size();
    }
    
    public boolean contient(Beneficiaire b){
        
        boolean trouve = false;
        
        for(int i = 0; i < this.listeBeneficiares.size() && !trouve; i++){
            
            if(this.listeBeneficiares.get(i).equals(b))
                trouve = true;
        }
        return trouve;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public String getDateNaiss(){
        return this.dateNaiss;
    }
    
    public String getCourriel(){
        return this.courriel;
    }
    
    public String getContrat(){
        return this.contrat;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public void setDateNaiss(String dateNaiss){
        this.dateNaiss = dateNaiss;
    }
    
    public void setCourriel(String courriel){
        this.courriel = courriel;
    }
    
    public void setContrat(String contrat){
        this.contrat = contrat;
    }
    
    public boolean validerDateNaiss(){
        
        return (dateNaiss != null && dateNaiss.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$"));
    }
    
    public boolean validerNom(){
        
        return (nom != null && nom.matches("^[A-Z][a-z]{2,}$"));
    }
    
    public boolean validerPrenom(){
        
        return (prenom != null && prenom.matches("^[A-Z][a-z]{2,}"));
    }
    
    public boolean validerCourriel(){
        
        return (courriel != null && courriel.matches("^(\\w+)@(\\w+)\\.([a-z]{1,3})$"));
    }
    
    public boolean validerContrat() {

        return (contrat != null && contrat.matches("^[ABCDE]$"));
    }
    
    public static void validerClient(Client client){
        qualifierNom(client);
        qualifierPrenom(client);
        qualifierDateNaiss(client);
        qualifierCourriel(client);
        qualifierContrat(client);
    }

    /**
     * @return the listeBeneficiares
     */
    public List<Beneficiaire> getListeBeneficiares() {
        return listeBeneficiares;
    }

    /**
     * @param listeBeneficiares the listeBeneficiares to set
     */
    public void setListeBeneficiares(List<Beneficiaire> listeBeneficiares) {
        this.listeBeneficiares = listeBeneficiares;
    }
}
