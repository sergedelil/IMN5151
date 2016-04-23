/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inm5151;

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
public class BeneficiaireTest {

    HistRemb hist;
    HistRemb hist2;
    Beneficiaire ben1;
    Beneficiaire ben2;
    Beneficiaire ben3;
    Client client1;
    Client client2;

    public BeneficiaireTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hist = new HistRemb("soin0", "soin100", "soin150", "soin175", "soin200", "soin300", "soin400", "soin500", "soin600", "soin700");
        hist2 = new HistRemb("soin0", "soin50", "soin150", "soin175", "soin200", "soin300", "soin400", "soin500", "soin600", "soin700");

        client1 = new Client("Kent", "Clark", "1960-12-23", "clarkkent@gmail.com", "A");
        client2 = new Client("Paul", "Dubois", "1980-10-01", "pauldubois@gmail.com", "B");

        ben1 = new Beneficiaire("Tomson", "Peter", client1, hist);
        ben2 = new Beneficiaire("", "", client1, hist);
        ben3 = new Beneficiaire("Kao", "Tai-Chin", client1, hist);

    }

    @After
    public void tearDown() {
        hist = null;
        hist2 = null;
        client1 = null;
        client2 = null;
        ben1 = null;
        ben2 = null;
        ben3 = null;
    }

    /**
     * Test of validerNom method, of class Beneficiaire.
     */
    @Test
    public void testValiderNom() {

        Beneficiaire instance = ben1;
        boolean expResult = true;
        boolean result = instance.validerNom();
        assertEquals(expResult, result);

        instance = ben2;
        expResult = false;
        result = instance.validerNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of validerPrenom method, of class Beneficiaire.
     */
    @Test
    public void testValiderPrenom() {
        Beneficiaire instance = ben1;
        boolean expResult = true;
        boolean result = instance.validerPrenom();
        assertEquals(expResult, result);

        instance = ben2;
        expResult = false;
        result = instance.validerPrenom();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Beneficiaire.
     */
    @Test
    public void testEquals() {
        
        Beneficiaire instance = ben2;
        Beneficiaire unAutreBeneficiaire = ben3;
        boolean expResult = false;
        boolean result = instance.equals(unAutreBeneficiaire);
        assertEquals(expResult, result);

        unAutreBeneficiaire = ben2;
        expResult = true;
        result = instance.equals(unAutreBeneficiaire);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNom method, of class Beneficiaire.
     */
    @Test
    public void testGetNom() {
        Beneficiaire instance = ben1;
        String expResult = "Tomson";
        String result = instance.getNom();
        assertEquals(expResult, result);

        instance = ben3;
        expResult = "Kao";
        result = instance.getNom();
        assertEquals(expResult, result);

        expResult = "Tomson";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setNom method, of class Beneficiaire.
     */
    @Test
    public void testSetNom() {

        String nom = "Boudou";
        Beneficiaire instance = ben1;
        instance.setNom(nom);
        assertEquals(nom, instance.getNom());

        nom = "Brava";
        instance = ben3;
        instance.setNom(nom);
        assertEquals(nom, instance.getNom());
        
        nom = "Rere";
        instance = ben3;
         assertFalse(nom.equals(instance.getNom()));
    }

    /**
     * Test of getPrenom method, of class Beneficiaire.
     */
    @Test
    public void testGetPrenom() {
        Beneficiaire instance = ben1;
        String expResult = "Peter";
        String result = instance.getPrenom();
        assertEquals(expResult, result);

        instance = ben3;
        expResult = "Tai-Chin";
        result = instance.getPrenom();
        assertEquals(expResult, result);

        expResult = "Didou";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setPrenom method, of class Beneficiaire.
     */
    @Test
    public void testSetPrenom() {
        String prenom = "Pablo";
        Beneficiaire instance = ben1;
        instance.setPrenom(prenom);
        assertTrue(prenom.equals(instance.getPrenom()));

        prenom = "Nino";
        instance = ben3;
        instance.setPrenom(prenom);
        assertTrue(prenom.equals(instance.getPrenom()));

        prenom = "Lulu";
        assertFalse(prenom.equals(instance.getPrenom()));
    }

    /**
     * Test of getHistoriqRemb method, of class Beneficiaire.
     */
    @Test
    public void testGetHistoriqRemb() {

        Beneficiaire instance = ben1;
        HistRemb expResult = hist;
        HistRemb result = instance.getHistoriqRemb();
        assertEquals(expResult, result);

        instance = ben3;
        expResult = hist;
        result = instance.getHistoriqRemb();
        assertEquals(expResult, result);

        expResult = new HistRemb("", "", "", "", "", "", "", "", "", "");
        result = instance.getHistoriqRemb();
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setHistoriqRemb method, of class Beneficiaire.
     */
    @Test
    public void testSetHistoriqRemb() {

        HistRemb historiqRemb = hist;
        Beneficiaire instance = ben1;
        instance.setHistoriqRemb(historiqRemb);
        assertEquals(instance.getHistoriqRemb(), historiqRemb);

        historiqRemb = hist2;
        assertFalse(instance.getHistoriqRemb().equals(historiqRemb));
    }

    /**
     * Test of getClient method, of class Beneficiaire.
     */
    @Test
    public void testGetClient() {

        Beneficiaire instance = ben1;
        Client expResult = client1;
        Client result = instance.getClient();
        assertEquals(expResult, result);

        instance = ben3;
        expResult = client1;
        result = instance.getClient();
        assertEquals(expResult, result);

        instance = ben2;
        expResult = client1;
        result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class Beneficiaire.
     */
    @Test
    public void testSetClient() {

        Client client = client2;
        Beneficiaire instance = ben1;
        instance.setClient(client);
        assertEquals(client, instance.getClient());


    }

}
