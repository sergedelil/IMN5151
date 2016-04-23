/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static inm5151.Creation.*;
import static inm5151.FileReader.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ESPERANZA
 */
public class CreationTest {// CreationTest

    Client client1;
    Client client2;
    Reclamation recl1;
    Reclamation recl2;
    SoinRecu soin1;
    SoinRecu soin2;
    SoinRecu soin3;
    SoinRecu soin4;
    SoinRecu soin5;

    public CreationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        client1 = new Client("Clark", "Kent", "1900-11-12", "superman@gmail.com", "A");
        client2 = new Client("Gagnon", "Romain", "1960-12-32", "clarkkent@gmail", "B");
        recl1 = new Reclamation("A19601223", "2016-01");
        recl2 = new Reclamation("A19001112", "2016-03");
        soin1 = new SoinRecu("100", "2016-04-04", "180.00$", "CXS4567");
        soin2 = new SoinRecu("200", "2016-03-04", "230.00$", "DSJ1249");
        soin3 = new SoinRecu("990", "2016-04-04", "16.50$", "KGB1079");
        soin4 = new SoinRecu("175", "2016-03-07", "130.00$", "COD1279");
        soin5 = new SoinRecu("150", "2016-03-15", "110.00$", "MHD0219");

    }

    @After
    public void tearDown() {
        client1 = null;
        client2 = null;
        recl1 = null;
        soin1 = null;
        soin2 = null;
        soin3 = null;
        soin4 = null;
    }

    /**
     * Test of creerReclamant method, of class Creation.
     */
    @Test
    public void testCreerReclamant() {

        JSONObject jObj = null;
        try {

            jObj = chargement("resources/input.json");

        } catch (IOException ex) {
            Logger.getLogger(CreationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Client expResult = client1;

        Client result = Creation.creerReclamant(jObj);

        assertTrue(expResult.getContrat().equals(result.getContrat()));
        assertTrue(expResult.getCourriel().equals(result.getCourriel()));
        assertTrue(expResult.getDateNaiss().equals(result.getDateNaiss()));
        assertTrue(expResult.getNom().equals(result.getNom()));
        assertTrue(expResult.getPrenom().equals(result.getPrenom()));

        expResult = client2;

        assertFalse(expResult.getContrat().equals(result.getContrat()));
        assertFalse(expResult.getCourriel().equals(result.getCourriel()));
        assertFalse(expResult.getDateNaiss().equals(result.getDateNaiss()));
        assertFalse(expResult.getNom().equals(result.getNom()));
        assertFalse(expResult.getPrenom().equals(result.getPrenom()));

    }

    /**
     * Test of ajouterSoin method, of class Creation.
     */
    @Test
    public void testAjouterSoin() {

        Reclamation reclam = recl1;

        SoinRecu soin = soin1;
        Creation.ajouterSoin(reclam, soin);
        assertEquals(soin1, reclam.getListe().get((reclam.getListe().size()) - 1));

        soin = soin2;
        Creation.ajouterSoin(reclam, soin);
        assertEquals(soin2, reclam.getListe().get((reclam.getListe().size()) - 1));

        soin = soin3;
        assertFalse(soin.equals(reclam.getListe().get((reclam.getListe().size()) - 1)));
    }

    /**
     * Test of traiterDemande method, of class Creation.
     */
    @Test
    public void testTraiterDemande() throws Exception {

        String fichierEntree = "resources/input.json";
        String fichierPolice = "resources/listePolices.json";
        String fichierHistorique = "resources/historique.json";

        Creation.traiterDemande(fichierEntree, fichierPolice,fichierHistorique);

    }

    /**
     * Test of creerSoin method, of class Creation.
     */
    @Test
    public void testCreerSoin() {

        JSONObject objetSoin = null;
        try {
            objetSoin = chargement("resources/input.json");
        } catch (IOException ex) {
            Logger.getLogger(CreationTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        String reclamation = objetSoin.getString("reclamations");
        JSONArray listeSoins = (JSONArray) JSONSerializer.toJSON(reclamation);

        for (int i = 0; i < listeSoins.size(); i++) {
            objetSoin = listeSoins.getJSONObject(i);
            SoinRecu unSoin = creerSoin(objetSoin);
            if (i == 0) {
                assertTrue(unSoin.getDatesoin().equals(soin4.getDatesoin()));
                assertTrue(unSoin.getIdMedecin().equals(soin4.getIdMedecin()));
                assertTrue(unSoin.getMontant().equals(soin4.getMontant()));
                assertTrue(unSoin.getNumSoin().equals(soin4.getNumSoin()));
            }
            if (i == 1) {
                assertTrue(unSoin.getDatesoin().equals(soin5.getDatesoin()));
                assertTrue(unSoin.getIdMedecin().equals(soin5.getIdMedecin()));
                assertTrue(unSoin.getMontant().equals(soin5.getMontant()));
                assertTrue(unSoin.getNumSoin().equals(soin5.getNumSoin()));

                assertFalse(unSoin.getDatesoin().equals(soin1.getDatesoin()));
                assertFalse(unSoin.getIdMedecin().equals(soin1.getIdMedecin()));
                assertFalse(unSoin.getMontant().equals(soin1.getMontant()));
                assertFalse(unSoin.getNumSoin().equals(soin1.getNumSoin()));
            }

        }

    }

    /**
     * Test of extraireChamp method, of class Creation.
     */
    @Test
    public void testExtraireChamp() {

        JSONObject jObj = null;
        try {
            jObj = chargement("resources/input.json");
        } catch (IOException ex) {
            Logger.getLogger(CreationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //assertTrue
        String champ = "Clark";
        String expResult = Creation.extraireChamp(jObj, "nom");
        assertTrue(expResult.equals(champ));

        champ = "Kent";
        expResult = Creation.extraireChamp(jObj, "prenom");
        assertTrue(expResult.equals(champ));

        champ = "1900-11-12";
        expResult = Creation.extraireChamp(jObj, "dateNaiss");
        assertTrue(expResult.equals(champ));

        champ = "2016-03";
        expResult = Creation.extraireChamp(jObj, "mois");
        assertTrue(expResult.equals(champ));

        champ = "superman@gmail.com";
        expResult = Creation.extraireChamp(jObj, "courriel");
        assertTrue(expResult.equals(champ));

        champ = "A";
        expResult = Creation.extraireChamp(jObj, "contrat");
        assertTrue(expResult.equals(champ));

        champ = "A19001112";
        expResult = Creation.extraireChamp(jObj, "dossier");
        assertTrue(expResult.equals(champ));

        //assertFalse
        champ = "Beaulieu";
        expResult = Creation.extraireChamp(jObj, "nom");
        assertFalse(expResult.equals(champ));

        champ = "Paul";
        expResult = Creation.extraireChamp(jObj, "prenom");
        assertFalse(expResult.equals(champ));

        champ = "1980-10-12";
        expResult = Creation.extraireChamp(jObj, "dateNaiss");
        assertFalse(expResult.equals(champ));

        champ = "2015-07";
        expResult = Creation.extraireChamp(jObj, "mois");
        assertFalse(expResult.equals(champ));

        champ = "kent   @gmail.com";
        expResult = Creation.extraireChamp(jObj, "courriel");
        assertFalse(expResult.equals(champ));

        champ = "D";
        expResult = Creation.extraireChamp(jObj, "contrat");
        assertFalse(expResult.equals(champ));

        champ = "A77703332";
        expResult = Creation.extraireChamp(jObj, "dossier");
        assertFalse(expResult.equals(champ));

    }

    /**
     * Test of creerReclamation method, of class Creation.
     */
    @Test
    public void testCreerReclamation() {

        JSONObject jObj = null;
        try {
            jObj = chargement("resources/input.json");
        } catch (IOException ex) {
            Logger.getLogger(CreationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Reclamation expResult = recl2;
        Reclamation result = Creation.creerReclamation(jObj);
        assertTrue(expResult.getMoisReclamation().equals(result.getMoisReclamation()));
        assertTrue(expResult.getNumDossier().equals(result.getNumDossier()));

        expResult = recl1;
        assertFalse(expResult.getMoisReclamation().equals(result.getMoisReclamation()));
        assertFalse(expResult.getNumDossier().equals(result.getNumDossier()));
    }

    /**
     * Test of verifierFichier method, of class Creation.
     */
    @Test
    public void testVerifierFichier() {

        String textJson = "resources/input.json";
        boolean expResult = false;
        boolean result = Creation.verifierFichier(textJson);
        assertEquals(expResult, result);

        textJson = null;
        expResult = true;
        result = Creation.verifierFichier(textJson);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifierObJson method, of class Creation.
     */
    @Test
    public void testVerifierObJson() {
        JSONObject jObj = null;
        try {
            jObj = chargement("resources/input.json");
        } catch (IOException ex) {
            Logger.getLogger(CreationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean expResult = false;
        boolean result = Creation.verifierObJson(jObj);
        assertEquals(expResult, result);

    }

    /**
     * Test of verifierFormatDesSoins method, of class Creation.
     */
    @Test
    public void testVerifierFormatDesSoins() {
         JSONObject objetSoin = null;
        try {
            objetSoin = chargement("resources/input.json");
        } catch (IOException ex) {
            Logger.getLogger(CreationTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        String reclamation = objetSoin.getString("reclamations");
        JSONArray listeSoins = (JSONArray) JSONSerializer.toJSON(reclamation);

        Creation.verifierFormatDesSoins(listeSoins);
       
    }

}
