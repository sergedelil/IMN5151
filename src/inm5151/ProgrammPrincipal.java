/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import java.io.IOException;
import static inm5151.Creation.*;
import java.io.FileWriter;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *@author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK  Olga
 */
public class ProgrammPrincipal {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws inm5151.OperationInvalideException
     */
    public static void main(String[] args) throws IOException, OperationInvalideException {
        
        if (args.length != 3){
            System.out.println("Le chemin du fichier manque...");
        }else { 
            traiterDemande(args[0], args[1], args[2]);
            ecrireRemboursementSurDisque();
        } 
    }
    public static void ecrireRemboursement(String nomFichier, String resultat) throws IOException {

      try (FileWriter fichierJson = new FileWriter(nomFichier)) {
            fichierJson.write(resultat);
            fichierJson.flush();
            fichierJson.close();
        }
    }
    public static JSONArray listedessoin(List<SoinRecu> liste){
     JSONArray soinResultat= new JSONArray();
      for (int i=0; i< liste.size();i++){
     JSONObject soin =new JSONObject();
        soin.accumulate("soin",liste.get(i).getNumSoin() );
         soin.accumulate("date",liste.get(i).getDatesoin());
         soin.accumulate("montant",liste.get(i).getMontant());
         soinResultat.add(soin);
        }     
        return soinResultat;
    }
    
      public static String createJSONArrayRembouresement()throws IOException {
        JSONObject remboursementFinales= new JSONObject();
        remboursementFinales.accumulate("dossier",Reclamation.getNumDossier());
        remboursementFinales.accumulate("mois", Reclamation.getMoisReclamation());
        remboursementFinales.accumulate("remboursements", listedessoin(Reclamation.getListe()));
        remboursementFinales.accumulate("total",(Traitement.getSommeTotal()+ "$"));
            
        return remboursementFinales.toString(3);
      }
      
       public static void ecrireRemboursementSurDisque() throws IOException{
        String obj = createJSONArrayRembouresement();
        ecrireRemboursement("resources/output.json", obj);
    }
}
       