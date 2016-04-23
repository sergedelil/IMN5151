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
 * @author Serge Dogny
 * @author ALLAMOU Fatima-Ezzahra
 * @author MAKHIVCHTCHOUK Olga
 */
public class SoinAssureTest {

    SoinAssure soin1;
    SoinAssure soin2;
    SoinAssure soin3;
    SoinAssure soin4;
    SoinAssure soin5;
    SoinAssure soin6;
    SoinAssure soin7;
    SoinAssure soin8;

    public SoinAssureTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        soin1 = new SoinAssure("100", 0.50, 50.0, 0.0);
        soin2 = new SoinAssure("175", 0.9, 80.0, 0.0);
        soin3 = new SoinAssure();
        soin4 = new SoinAssure("800", 0.4, 60.5, 0.0);

        soin5 = new SoinAssure("0", 0.4, 60.5, 0.0);
        soin6 = new SoinAssure("400", 0.4, 60.5, 0.0);
        soin7 = new SoinAssure("600", 0.4, 60.5, 300.0);
        soin8 = new SoinAssure("500", 0.4, 60.5, 150.0);
    }

    @After
    public void tearDown() {

        soin1 = null;
        soin2 = null;
        soin3 = null;
        soin4 = null;
        soin5 = null;
        soin6 = null;
        soin7 = null;
        soin8 = null;
    }

    /**
     * Test of getNumSoin method, of class SoinAssure.
     */
    @Test
    public void testGetNumSoin() {

        assertEquals("100", soin1.getNumSoin());
        assertNull(soin3.getNumSoin());
        assertEquals("175", soin2.getNumSoin());

    }

    /**
     * Test of getPourcentage method, of class SoinAssure.
     */
    @Test
    public void testGetPourcentage() {

        assertEquals(0.50, soin1.getPourcentage(), 0.01);
        assertEquals(0.9, soin2.getPourcentage(), 0.01);
    }

    /**
     * Test of getLimite method, of class SoinAssure.
     */
    @Test
    public void testGetLimite() {

        assertEquals(50.0, soin1.getLimite(), 0.01);
        assertEquals(80.0, soin2.getLimite(), 0.01);
    }

    /**
     * Test of setNumSoin method, of class SoinAssure.
     */
    @Test
    public void testSetNumSoin() {

        assertNull(soin3.getNumSoin());
        soin3.setNumSoin("200");
        assertNotNull(soin3.getNumSoin());
        assertEquals("200", soin3.getNumSoin());

    }

    /**
     * Test of setPourcentage method, of class SoinAssure.
     */
    @Test
    public void testSetPourcentage() {

        assertEquals(0.0, soin3.getPourcentage(), 0.01);
        soin3.setPourcentage(0.7);
        assertEquals(0.7, soin3.getPourcentage(), 0.01);
    }

    /**
     * Test of setLimite method, of class SoinAssure.
     */
    @Test
    public void testSetLimite() {

        assertEquals(0.0, soin3.getLimite(), 0.01);
        soin3.setLimite(56.0);
        assertEquals(56.0, soin3.getLimite(), 0.01);
    }

    /**
     * Test of validerNumeroSoin method, of class SoinAssure.
     */
    @Test
    public void testValiderNumeroSoin() {

        assertTrue(soin1.validerNumeroSoin());
        assertFalse(soin4.validerNumeroSoin());
        assertTrue(soin2.validerNumeroSoin());
    }

    /**
     * Test of validerLaCouvertureDuSoin method, of class SoinAssure.
     */
    @Test
    public void testValiderLaCouvertureDuSoin() {

        assertTrue(soin1.validerLaCouvertureDuSoin());
        soin3.setPourcentage(2.0);
        assertFalse(soin3.validerLaCouvertureDuSoin());
        soin3.setPourcentage(-1.1);
        assertFalse(soin3.validerLaCouvertureDuSoin());
        assertTrue(soin2.validerLaCouvertureDuSoin());
    }

    /**
     * Test of validerLaLimiteDuSoin method, of class SoinAssure.
     */
    @Test
    public void testValiderLaLimiteDuSoin() {

        assertTrue(soin1.validerLaLimiteDuSoin());
        soin3.setLimite(-2.0);
        assertFalse(soin3.validerLaLimiteDuSoin());
        assertTrue(soin2.validerLaLimiteDuSoin());
    }

    /**
     * Test of admetLimiteMensuelle method, of class SoinAssure.
     */
    @Test
    public void testAdmetLimiteMensuelle() {

        SoinAssure instance = soin5;
        boolean expResult = false;
        boolean result = instance.admetLimiteMensuelle();
        assertEquals(expResult, result);

        instance = soin6;
        expResult = false;
        result = instance.admetLimiteMensuelle();
        assertEquals(expResult, result);

        instance = soin7;
        expResult = true;
        result = instance.admetLimiteMensuelle();
        assertEquals(expResult, result);

        instance = soin8;
        expResult = true;
        result = instance.admetLimiteMensuelle();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLimiteMensuelle method, of class SoinAssure.
     */
    @Test
    public void testGetLimiteMensuelle() {
        SoinAssure instance = soin7;
        double expResult = 300.0;
        double result = instance.getLimiteMensuelle();
        assertEquals(expResult, result, 300.0);

        instance = soin8;
        expResult = 150.0;
        result = instance.getLimiteMensuelle();
        assertEquals(expResult, result, 150.0);

        instance = soin5;
        expResult = 0.0;
        result = instance.getLimiteMensuelle();
        assertEquals(expResult, result, 0.0);

        instance = soin6;
        expResult = 0.0;
        result = instance.getLimiteMensuelle();
        assertEquals(expResult, result, 0.0);

        instance = soin8;
        expResult = 0.0;
        assertFalse(expResult == instance.getLimiteMensuelle());
    }

    /**
     * Test of setLimiteMensuelle method, of class SoinAssure.
     */
    @Test
    public void testSetLimiteMensuelle() {
        double limiteMensuelle = 0.0;
        SoinAssure instance = soin7;
        instance.setLimiteMensuelle(limiteMensuelle);
        double result = instance.getLimiteMensuelle();
        assertEquals(limiteMensuelle, result, 0.0);

        instance = soin7;
        instance.setLimiteMensuelle(limiteMensuelle);
        result = instance.getLimiteMensuelle();
        assertEquals(limiteMensuelle, result, 0.0);

        limiteMensuelle = 30.0;
        instance = soin5;
        instance.setLimiteMensuelle(limiteMensuelle);
        result = instance.getLimiteMensuelle();
        assertEquals(limiteMensuelle, result, 30.0);

        limiteMensuelle = 66.0;
        instance = soin6;
        instance.setLimiteMensuelle(limiteMensuelle);
        result = instance.getLimiteMensuelle();
        assertEquals(limiteMensuelle, result, 66.0);

    }
}
