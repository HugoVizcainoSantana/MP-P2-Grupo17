/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17;

import java.util.Calendar;
import mp.g17.users.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class PenalizacionTest {
    
    public PenalizacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFechaInicio method, of class Penalizacion.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        Penalizacion instance = null;
        Calendar expResult = null;
        Calendar result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFinal method, of class Penalizacion.
     */
    @Test
    public void testGetFechaFinal() {
        System.out.println("getFechaFinal");
        Penalizacion instance = null;
        Calendar expResult = null;
        Calendar result = instance.getFechaFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPenalizedBy method, of class Penalizacion.
     */
    @Test
    public void testGetPenalizedBy() {
        System.out.println("getPenalizedBy");
        Penalizacion instance = null;
        Administrador expResult = null;
        Administrador result = instance.getPenalizedBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReason method, of class Penalizacion.
     */
    @Test
    public void testGetReason() {
        System.out.println("getReason");
        Penalizacion instance = null;
        String expResult = "";
        String result = instance.getReason();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
