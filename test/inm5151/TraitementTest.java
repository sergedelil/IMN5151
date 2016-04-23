/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

import static inm5151.Traitement.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK Olga
 */
public class TraitementTest {

    Client client1;
    Client client2;
    Police police1;
    Police police2;
    Police police3;
    SoinAssure soinAs1;
    SoinAssure soinAs2;
    SoinRecu soinRec1;
    SoinRecu soinRec2;

    List<Police> lesPolices;

    Reclamation recl1;

    public TraitementTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        client1 = new Client("Kent", "Clark", "1960-12-23", "clarkkent@gmail.com", "A");
        client2 = new Client("Paul", "Dubois", "1980-10-01", "pauldubois@gmail.com", "D");

        police1 = new Police("A");
        police2 = new Police("B");
        police3 = new Police("D");

        lesPolices = new ArrayList();

        lesPolices.add(police1);
        lesPolices.add(police2);

        soinAs1 = new SoinAssure("100", 0.50, 50.0, 0.0);
        soinAs2 = new SoinAssure("175", 0.9, 80.0, 0.0);

        soinRec1 = new SoinRecu("100", "2016-04-04", "180.00$", "CXS4567");
        soinRec2 = new SoinRecu("200", "2016-03-04", "230.00$", "DSJ1249");

        police1.ajouterSoinAssure(soinAs1);
        police1.ajouterSoinAssure(soinAs2);

        recl1 = new Reclamation("A19601223", "2016-01");
    }

    @After
    public void tearDown() {
        client1 = null;
        client2 = null;
        police1 = null;
        police2 = null;
        police3 = null;
        lesPolices = null;
        recl1 = null;
    }

    /**
     * Test of ExtrairePoliceSoin method, of class Traitement.
     */
    @Test
    public void testExtrairePoliceSoin() {
        
        assertEquals(soinAs1,ExtrairePoliceSoin(client1, lesPolices, soinRec1));
    }

    /**
     * Test of rembourserPolice method, of class Traitement.
     * @throws inm5151.OperationInvalideException
     */
    @Test
    public void testRembourserPolice() throws OperationInvalideException {
        System.out.println("rembourserPolice");
        String valeur = "";
        SoinAssure soinA = null;
        HistRemb hist = null;
        Traitement.rembourserPolice(valeur, soinA,hist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of appliquerPolice method, of class Traitement.
     * @throws inm5151.OperationInvalideException
     */
    @Test
    public void testAppliquerPolice() throws OperationInvalideException {
        System.out.println("appliquerPolice");
        Client client = null;
        Reclamation rec = null;
        List<Police> lesPolices = null;
        HistRemb hist = null;
       // Traitement.appliquerPolice(client, rec, lesPolices,hist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formaterEnDecimal method, of class Traitement.
     */
    @Test
    public void testFormaterEnDecimal() {
        System.out.println("formaterEnDecimal");
        DecimalFormat expResult = null;
        DecimalFormat result = Traitement.formaterEnDecimal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenirPartieEntiere method, of class Traitement.
     */
    @Test
    public void testObtenirPartieEntiere() {
        System.out.println("obtenirPartieEntiere");
        String montant = "";
        String expResult = "";
        String result = Traitement.obtenirPartieEntiere(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenirPartieDecimale method, of class Traitement.
     */
    @Test
    public void testObtenirPartieDecimale() {
        System.out.println("obtenirPartieDecimale");
        String montant = "";
        String expResult = "";
        String result = Traitement.obtenirPartieDecimale(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of appliquerLimiteMensuelle method, of class Traitement.
     */
    @Test
    public void testAppliquerLimiteMensuelle() throws Exception {
        System.out.println("appliquerLimiteMensuelle");
        SoinAssure soinA = null;
        HistRemb hist = null;
        Traitement.appliquerLimiteMensuelle(soinA, hist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of appliquerCouverture method, of class Traitement.
     */
    @Test
    public void testAppliquerCouverture() {
        System.out.println("appliquerCouverture");
        SoinAssure soinA = null;
        double montantSoin = 0.0;
        Traitement.appliquerCouverture(soinA, montantSoin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creerMonnaie method, of class Traitement.
     */
    @Test
    public void testCreerMonnaie() {
        System.out.println("creerMonnaie");
        String montant = "";
        Monnaie expResult = null;
        Monnaie result = Traitement.creerMonnaie(montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
