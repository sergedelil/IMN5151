/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static inm5151.Creation.ecrireHistoriqueSurDisque;
import java.util.List;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import static inm5151.Message.*;
import java.io.IOException;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class Traitement {
    
    private static Monnaie remboursement ;
    private static double sommeTotal;
    public Traitement(){
        remboursement = null;
    }
    public static double getSommeTotal(){
            return sommeTotal;
    }
       
    public static SoinAssure ExtrairePoliceSoin(Client client, List<Police> lesPolices, SoinRecu unSoin){
        
        SoinAssure soinPolice = null;
        boolean trouve = false;
        String contrat = client.getContrat();
        
        for(int i = 0; i < lesPolices.size() && !trouve; i++){
            
            if (contrat.equals(lesPolices.get(i).getContrat())){
                
                for(int j = 0; j < lesPolices.get(i).getListeSoinsAssures().size() && !trouve; j++){
                    
                    if(lesPolices.get(i).getListeSoinsAssures().get(j).getNumSoin().equals(unSoin.getNumSoin())){
                        soinPolice = lesPolices.get(i).getListeSoinsAssures().get(j);
                        trouve = true;
                    }
                }
            }
        }
        return soinPolice;
    }
    
    public static void rembourserPolice(String valeur, SoinAssure soinA,HistRemb hist) throws OperationInvalideException{
        
        double montantSoin;
        String cout = valeur.trim();
        String montant = cout.substring(0, cout.length() - 1);
        remboursement = creerMonnaie(montant);
        montantSoin = Double.parseDouble(montant.substring(0, montant.length() - 1));
        
        appliquerCouverture(soinA,montantSoin);
        
        if(soinA.admetLimiteMensuelle())
            appliquerLimiteMensuelle(soinA,hist);
    }
    
    public static void appliquerLimiteMensuelle(SoinAssure soinA,HistRemb hist) throws OperationInvalideException{
        
        String numSoin = "soin";
        numSoin = numSoin + soinA.getNumSoin();
        String cumulHist = hist.recupererSoinHistorique(numSoin);
        
        Monnaie valHist = creerMonnaie(cumulHist);
        Monnaie limMens = creerMonnaie(String.valueOf(soinA.getLimiteMensuelle()));
        calculerLimite(valHist, limMens, hist, numSoin);
    }

    private static void calculerLimite(Monnaie valHist, Monnaie limMens, HistRemb hist, String numSoin) throws OperationInvalideException {
       
        if(valHist.getTotalCents() < limMens.getTotalCents()){

            valHist.additionner(remboursement);
            
            if(valHist.getTotalCents() > limMens.getTotalCents()){
                
                valHist.soustraire(limMens);
                remboursement.soustraire(valHist);
                hist.modifierSoinHistorique(numSoin, limMens.toString().substring(0, limMens.toString().length() - 1));
            }else{

                hist.modifierSoinHistorique(numSoin, valHist.toString().substring(0, valHist.toString().length() - 1));
            }
        }else{
            
            remboursement.soustraire(remboursement);
            hist.modifierSoinHistorique(numSoin, limMens.toString().substring(0, limMens.toString().length() - 1));
        }
    }
    
    public static void appliquerCouverture(SoinAssure soinA, double montantSoin){
        
        if(soinA.getLimite() == 0.0)
            remboursement.pourcentage((int)(soinA.getPourcentage()*100));
        
        else if((montantSoin * soinA.getPourcentage()) > soinA.getLimite())
            remboursement = creerMonnaie(String.valueOf(soinA.getLimite()));
            
        else if((montantSoin * soinA.getPourcentage()) < soinA.getLimite())
            remboursement.pourcentage((int)soinA.getPourcentage()*100);
    }
    
    public static Monnaie creerMonnaie(String montant){
        
        int dollar = Integer.parseInt(obtenirPartieEntiere(montant));
        int cent = Integer.parseInt(obtenirPartieDecimale(montant));
        
        return new Monnaie(dollar, cent);
    
    }
    
    public static void appliquerPolice(Client client, Reclamation rec, List<Police> lesPolices,HistRemb historique) throws OperationInvalideException, IOException{
        
        String contrat = client.getContrat();
        List<SoinRecu> listeSoin = Reclamation.getListe();
        
        for(int i = 0; i < listeSoin.size(); i++ ){
            
            SoinRecu soinR = listeSoin.get(i);
            SoinAssure soinA = ExtrairePoliceSoin(client,lesPolices,soinR);
            rembourserPolice(soinR.getMontant(), soinA, historique);
            int position = i+1;
            
            afficherRemboursement(listeSoin.get(i),remboursement,position);
            String remb = remboursement.toString();
           double somme=  Double.parseDouble(remb.substring(0, remb.length() - 1));
            sommeTotal= sommeTotal+somme;
        }
        ecrireHistoriqueSurDisque(historique);
    }
    
    public static DecimalFormat formaterEnDecimal() {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", dfs);
        return df;
    }
    
    public static String obtenirPartieEntiere(String montant){
        
        String entier = "";
        int i = 0;
        
        while(montant.charAt(i) != '.'){
            entier = entier + montant.charAt(i);
            i++;
        }
        return entier.trim();
    }
    
    public static String obtenirPartieDecimale(String montant){
        
        int i = 0;
        
        while(montant.charAt(i) != '.'){
            i++;
        }
        return montant.substring(i+1);
    }
}
