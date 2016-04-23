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
public class HistRembTest {

    HistRemb hist;

    public HistRembTest() {
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

    }

    @After
    public void tearDown() {
        hist = null;
    }

    /**
     * Test of ecrireHistorique method, of class HistRemb.
     */
    @Test
    public void testEcrireHistorique() {

        hist.ecrireHistorique();

    }

    /**
     * Test of recupererSoinHistorique method, of class HistRemb.
     */
    @Test
    public void testRecupererSoinHistorique() {
        String str = "soin0";
        HistRemb instance = hist;
        String expResult = "soin0";
        String result = instance.recupererSoinHistorique(str);
        assertEquals(expResult, result);

        str = "soin200";
        expResult = "soin200";
        result = instance.recupererSoinHistorique(str);
        assertEquals(expResult, result);

        str = "soin300";
        expResult = "soin1000";
        result = instance.recupererSoinHistorique(str);
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of modifierSoinHistorique method, of class HistRemb.
     */
    @Test
    public void testModifierSoinHistorique() {

        String soin = "soin200";
        String str = "soin200";
        HistRemb instance = hist;
        instance.modifierSoinHistorique(soin, str);
        assertEquals(soin, instance.getSoin200());

        soin = "soin175";
        str = "soin175";
        instance.modifierSoinHistorique(soin, str);
        assertEquals(soin, instance.getSoin175());
    }

    /**
     * Test of getSoin0 method, of class HistRemb.
     */
    @Test
    public void testGetSoin0() {

        HistRemb instance = hist;
        String expResult = "soin0";
        String result = instance.getSoin0();
        assertEquals(expResult, result);

        expResult = "soin100";
        assertFalse(expResult.equals(result));

    }

    /**
     * Test of setSoin0 method, of class HistRemb.
     */
    @Test
    public void testSetSoin0() {

        String soin0 = "unSoin0";
        HistRemb instance = hist;
        instance.setSoin0(soin0);
        assertEquals(soin0, instance.getSoin0());
    }

    /**
     * Test of getSoin100 method, of class HistRemb.
     */
    @Test
    public void testGetSoin100() {

        HistRemb instance = hist;
        String expResult = "soin100";
        String result = instance.getSoin100();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin100 method, of class HistRemb.
     */
    @Test
    public void testSetSoin100() {
        String soin100 = "unSoin100";
        HistRemb instance = hist;
        instance.setSoin100(soin100);
        assertEquals(soin100, instance.getSoin100());
    }

    /**
     * Test of getSoin150 method, of class HistRemb.
     */
    @Test
    public void testGetSoin150() {
        HistRemb instance = hist;
        String expResult = "soin150";
        String result = instance.getSoin150();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin150 method, of class HistRemb.
     */
    @Test
    public void testSetSoin150() {
        String soin150 = "unSoin150";
        HistRemb instance = hist;
        instance.setSoin150(soin150);
        assertEquals(soin150, instance.getSoin150());

    }

    /**
     * Test of getSoin175 method, of class HistRemb.
     */
    @Test
    public void testGetSoin175() {
        HistRemb instance = hist;
        String expResult = "soin175";
        String result = instance.getSoin175();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin175 method, of class HistRemb.
     */
    @Test
    public void testSetSoin175() {
        String soin175 = "unSoin175";
        HistRemb instance = hist;
        instance.setSoin175(soin175);
        assertEquals(soin175, instance.getSoin175());
    }

    /**
     * Test of getSoin200 method, of class HistRemb.
     */
    @Test
    public void testGetSoin200() {
        HistRemb instance = hist;
        String expResult = "soin200";
        String result = instance.getSoin200();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin200 method, of class HistRemb.
     */
    @Test
    public void testSetSoin200() {
        String soin200 = "unSoin200";
        HistRemb instance = hist;
        instance.setSoin200(soin200);
        assertEquals(soin200, instance.getSoin200());
    }

    /**
     * Test of getSoin300 method, of class HistRemb.
     */
    @Test
    public void testGetSoin300() {
        HistRemb instance = hist;
        String expResult = "soin300";
        String result = instance.getSoin300();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin300 method, of class HistRemb.
     */
    @Test
    public void testSetSoin300() {
        String soin300 = "unSoin300";
        HistRemb instance = hist;
        instance.setSoin300(soin300);
        assertEquals(soin300, instance.getSoin300());
    }

    /**
     * Test of getSoin400 method, of class HistRemb.
     */
    @Test
    public void testGetSoin400() {
        HistRemb instance = hist;
        String expResult = "soin400";
        String result = instance.getSoin400();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin400 method, of class HistRemb.
     */
    @Test
    public void testSetSoin400() {
        String soin400 = "unSoin400";
        HistRemb instance = hist;
        instance.setSoin400(soin400);
        assertEquals(soin400, instance.getSoin400());
    }

    /**
     * Test of getSoin500 method, of class HistRemb.
     */
    @Test
    public void testGetSoin500() {
        HistRemb instance = hist;
        String expResult = "soin500";
        String result = instance.getSoin500();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin500 method, of class HistRemb.
     */
    @Test
    public void testSetSoin500() {
        String soin500 = "unSoin500";
        HistRemb instance = hist;
        instance.setSoin500(soin500);
        assertEquals(soin500, instance.getSoin500());
    }

    /**
     * Test of getSoin600 method, of class HistRemb.
     */
    @Test
    public void testGetSoin600() {
        HistRemb instance = hist;
        String expResult = "soin600";
        String result = instance.getSoin600();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin600 method, of class HistRemb.
     */
    @Test
    public void testSetSoin600() {
        String soin600 = "unSoin600";
        HistRemb instance = hist;
        instance.setSoin600(soin600);
        assertEquals(soin600, instance.getSoin600());
    }

    /**
     * Test of getSoin700 method, of class HistRemb.
     */
    @Test
    public void testGetSoin700() {
        HistRemb instance = hist;
        String expResult = "soin700";
        String result = instance.getSoin700();
        assertEquals(expResult, result);

        expResult = "soin1";
        assertFalse(expResult.equals(result));
    }

    /**
     * Test of setSoin700 method, of class HistRemb.
     */
    @Test
    public void testSetSoin700() {
        String soin700 = "unSoin700";
        HistRemb instance = hist;
        instance.setSoin700(soin700);
        assertEquals(soin700, instance.getSoin700());
    }

}
