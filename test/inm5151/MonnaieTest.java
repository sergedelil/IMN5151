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
public class MonnaieTest {

    Monnaie m1;
    Monnaie m2;
    Monnaie m3;
    Monnaie m4;

    public MonnaieTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        m1 = new Monnaie(25, 43);
        m2 = new Monnaie(17, 35);
        m4 = new Monnaie(234, 56);
    }

    @After
    public void tearDown() {

        m1 = null;
        m2 = null;
        m4 = null;
    }

    /**
     * Test of toString method, of class Monnaie.
     */
    @Test
    public void testToString() {

        assertEquals("234.56$", m4.toString());
        assertFalse("2.56$".equals(m4));
        assertNotNull(m1.toString());
    }

    /**
     * Test of getDollars method, of class Monnaie.
     */
    @Test
    public void testGetDollars() {

        assertEquals(25, m1.getDollars());
        assertEquals(234, m4.getDollars());
        assertFalse(2 == m4.getDollars());

    }

    /**
     * Test of getCents method, of class Monnaie.
     */
    @Test
    public void testGetCents() {
        assertEquals(56, m4.getCents());
        assertEquals(56, m4.getCents());
        assertFalse(2 == m4.getCents());
    }

    /**
     * Test of getTotalCents method, of class Monnaie.
     */
    @Test
    public void testGetTotalCents() {

        assertEquals(23456, m4.getTotalCents());
        assertEquals(2543, m1.getTotalCents());
        assertEquals(1735, m2.getTotalCents());
    }

    /**
     * Test of additionner method, of class Monnaie.
     */
    @Test
    public void testAdditionner() {
        m1.additionner(m2);
        assertEquals(4278, m1.getTotalCents());
        assertFalse(10 == m1.getTotalCents());
    }

    /**
     * Test of soustraire method, of class Monnaie.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSoustraire() throws Exception {

        m1.soustraire(m2);
        assertEquals(808, m1.getTotalCents());
        assertFalse(10 == m1.getTotalCents());
    }

    /**
     * Test of pourcentage method, of class Monnaie.
     */
    @Test
    public void testPourcentage() {

        m4.pourcentage(50);
        assertEquals(11728, m4.getTotalCents());
        assertFalse(10 == m4.getTotalCents());
    }

    /**
     * Test of multiplier method, of class Monnaie.
     */
    @Test
    public void testMultiplier() {

        m2.multiplier(m1);
        assertEquals(4412105, m2.getTotalCents());
        assertFalse(10 == m1.getTotalCents());
    }

}
