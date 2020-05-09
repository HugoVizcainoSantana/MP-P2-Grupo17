/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import mp.g17.Penalizacion;
import mp.g17.events.EventoEntradaCreada;
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
public class AlumnoTest {
    
    public AlumnoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of update method, of class Alumno.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        EventoEntradaCreada event = null;
        Alumno instance = null;
        instance.update(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrike method, of class Alumno.
     */
    @Test
    public void testGetStrike() {
        System.out.println("getStrike");
        Alumno instance = null;
        Penalizacion expResult = null;
        Penalizacion result = instance.getStrike();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrike method, of class Alumno.
     */
    @Test
    public void testSetStrike() {
        System.out.println("setStrike");
        Penalizacion strike = null;
        Alumno instance = null;
        instance.setStrike(strike);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
