/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

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
    SoinAssure soinAs1;
    SoinAssure soinAs2;
    Police police1;
    List<Police> lesPolices;
    SoinRecu soinRec1;
    HistRemb hist;
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
        soinAs1 = new SoinAssure("100", 0.50, 50.0, 250.0);
        soinAs2 = new SoinAssure("175", 0.9, 80.0, 200.0);
        recl1 = new Reclamation("A19601223", "2016-01");
        police1 = new Police("A");
        police1.ajouterSoinAssure(soinAs1);
        police1.ajouterSoinAssure(soinAs2);
        lesPolices = new ArrayList();
        lesPolices.add(police1);
        soinRec1 = new SoinRecu("100", "2016-04-04", "180.00$", "CXS4567");
        hist = new HistRemb("soin0", "soin100", "soin150", "soin175", "soin200", "soin300", "soin400", "soin500", "soin600", "soin700");
}

    @After
    public void tearDown() {
        client1 = null;
        soinAs1 = null;
        soinAs2 = null;
        police1 = null;
        recl1 = null;
        lesPolices = null;
        soinRec1 = null;
        hist = null;
     }

    /**
     * Test of ExtrairePoliceSoin method, of class Traitement.
     */
    @Test
    public void testExtrairePoliceSoin() {
        
        SoinAssure result = Traitement.ExtrairePoliceSoin(client1, lesPolices, soinRec1);
        assertFalse(soinAs2.equals(result));
    }
        /**
     * Test of appliquerCouverture method, of class Traitement.
     */
    @Test
    public void testAppliquerCouverture() {

        SoinAssure soinA = soinAs1;
        double montantSoin = 100.0;
        Traitement.appliquerCouverture(soinA, montantSoin);

        soinA = soinAs2;
        montantSoin = 300.0;
        Traitement.appliquerCouverture(soinA, montantSoin);

    }

    /**
     * Test of creerMonnaie method, of class Traitement.
     */
    @Test
    public void testCreerMonnaie() {

        String montant = "234.76";
        Monnaie expResult = new Monnaie(234, 76);
        Monnaie result = Traitement.creerMonnaie(montant);
        System.out.println(result);
        assertTrue(expResult.toString().equals(result.toString()));
    }

}
