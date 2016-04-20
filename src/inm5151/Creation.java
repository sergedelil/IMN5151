/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static inm5151.Client.*;
import static inm5151.Message.*;
import static inm5151.FileReader.*;
import static inm5151.Reclamation.validerReclamation;
import static inm5151.Traitement.appliquerPolice;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class Creation {

    public static Client creerReclamant(JSONObject jObj) {
        String nom = extraireChamp(jObj, "nom");
        existenceChamp(nom, "nom");
        String prenom = extraireChamp(jObj, "prenom");
        existenceChamp(prenom, "prenom");
        String dateNaiss = extraireChamp(jObj, "dateNaiss");
        existenceChamp(dateNaiss, "dateNaiss");
        String mois = extraireChamp(jObj, "mois");
        existenceChamp(mois, "mois");
        String courriel = extraireChamp(jObj, "courriel");
        existenceChamp(courriel, "courriel");
        String contrat = extraireChamp(jObj, "contrat");
        existenceChamp(contrat, "contrat");
        String dossier = extraireChamp(jObj, "dossier");
        existenceChamp(dossier, "dossier");
        String reclam = extraireChamp(jObj, "reclamations");
        existenceChamp(reclam, "reclamations");
        Client client = new Client(nom, prenom, dateNaiss, courriel, contrat);
        return client;
    }
    
    public static HistRemb chargerHistorique(JSONObject jObj) {
        String valSoin0 = extraireChamp(jObj, "soin0");
        existenceChamp(valSoin0, "soin0");
        String valSoin100 = extraireChamp(jObj, "soin100");
        existenceChamp(valSoin100, "soin100");
        String valSoin150 = extraireChamp(jObj, "soin150");
        existenceChamp(valSoin150, "soin150");
        String valSoin175 = extraireChamp(jObj, "soin175");
        existenceChamp(valSoin175, "soin175");
        String valSoin200 = extraireChamp(jObj, "soin200");
        existenceChamp(valSoin200, "soin200");
        String valSoin300 = extraireChamp(jObj, "soin300");
        existenceChamp(valSoin300, "soin300");
        String valSoin400 = extraireChamp(jObj, "soin400");
        existenceChamp(valSoin400, "soin400");
        String valSoin500 = extraireChamp(jObj, "soin500");
        existenceChamp(valSoin500, "soin500");
        String valSoin600 = extraireChamp(jObj, "soin600");
        existenceChamp(valSoin600, "soin600");
        String valSoin700 = extraireChamp(jObj, "soin700");
        existenceChamp(valSoin700, "soin700");
        HistRemb hist = new HistRemb(valSoin0,valSoin100,valSoin150,valSoin175,valSoin200,
                valSoin300,valSoin400,valSoin500,valSoin600,valSoin700);
        return hist;
    }

    public static void ajouterSoin(Reclamation reclam, SoinRecu soin) {
        reclam.getListe().add(soin);
    }

    public static void traiterDemande(String fichierEntree, String fichierPolice, String fichierHistoriq) throws IOException, OperationInvalideException {
        
        List<Police> listePolice;
        JSONObject obj = chargement(fichierEntree);
        Client client = creerReclamant(obj);
        validerClient(client);
        
        Reclamation rec = creerReclamation(obj);
        validerReclamation(rec, client);
        
        listePolice = chargerLesPolice(fichierPolice);
        
        JSONObject hObj = chargement(fichierHistoriq);
        HistRemb historique = chargerHistorique(hObj);
        
        appliquerPolice(client, rec, listePolice,historique);
    }

    public static SoinRecu creerSoin(JSONObject objetSoin) {
        
        String numSoin = objetSoin.getString("soin");
        String dateSoin = objetSoin.getString("date");
        String montant = objetSoin.getString("montant");
        String idMedecin = objetSoin.getString("medecin");
        SoinRecu unSoin = new SoinRecu(numSoin, dateSoin, montant, idMedecin);
        return unSoin;
    }

    public static String extraireChamp(JSONObject objet, String champ) {
        
        String resultat;
        try {
            resultat = objet.getString(champ);
        } catch (JSONException e) {
            resultat = null;
        }
        return resultat;
    }

    public static Reclamation creerReclamation(JSONObject obj) {
        
        String reclamation = obj.getString("reclamations");
        JSONArray listeSoins = (JSONArray) JSONSerializer.toJSON(reclamation);
        verifierFormatDesSoins(listeSoins);
        Reclamation reclam = new Reclamation(obj.getString("dossier"), obj.getString("mois"));
        
        for (int i = 0; i < listeSoins.size(); i++) {
            JSONObject objetSoin = listeSoins.getJSONObject(i);
            SoinRecu unSoin = creerSoin(objetSoin);
            ajouterSoin(reclam, unSoin);
        }
        return reclam;
    }

    public static boolean verifierFichier(String textJson) {
        return textJson == null;
    }

    public static boolean verifierObJson(JSONObject jsonObj) {
        return jsonObj == null;
    }

    public static void verifierFormatDesSoins(JSONArray listeSoins) {
        for (int i = 0; i < listeSoins.size(); i++) {
            JSONObject objetSoin = listeSoins.getJSONObject(i);
            String numSoin = Creation.extraireChamp(objetSoin, "soin");
            existenceChampSoin(numSoin, "soin", i + 1);
            String date = Creation.extraireChamp(objetSoin, "date");
            existenceChampSoin(date, "date", i + 1);
            String montant = Creation.extraireChamp(objetSoin, "montant");
            existenceChampSoin(montant, "montant", i + 1);
            String med = Creation.extraireChamp(objetSoin, "medecin");
            existenceChampSoin(med, "medecin", i + 1);
        }
    }
    public static void sauvegarderHistorique(String nomFichier, String objFichHist) throws IOException{
        
        try (FileWriter fichierJson = new FileWriter(nomFichier)) {
            fichierJson.write(objFichHist);
            fichierJson.flush();
            fichierJson.close();
        }
    }
    
    public static String miseAJourFichierHistorique(HistRemb hist, JSONObject fichHist){
        
        fichHist.accumulate("soin0", hist.getSoin0());
        fichHist.accumulate("soin100", hist.getSoin100());
        fichHist.accumulate("soin150", hist.getSoin150());
        fichHist.accumulate("soin175", hist.getSoin175());
        fichHist.accumulate("soin200", hist.getSoin200());
        fichHist.accumulate("soin300", hist.getSoin300());
        fichHist.accumulate("soin400", hist.getSoin400());
        fichHist.accumulate("soin500", hist.getSoin500());
        fichHist.accumulate("soin600", hist.getSoin600());
        fichHist.accumulate("soin700", hist.getSoin700());
        
        return fichHist.toString();
    }
    
    public static void ecrireHistoriqueSurDisque(HistRemb hist) throws IOException{
        
        JSONObject hObj = new JSONObject();
        String obj = miseAJourFichierHistorique(hist, hObj);
        sauvegarderHistorique("resources/historique.json", obj);
    }
}
