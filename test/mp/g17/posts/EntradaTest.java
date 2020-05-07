/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import java.util.List;
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
public class EntradaTest {
    
    public EntradaTest() {
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
     * Test of verify method, of class Entrada.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");
        boolean resultado = false;
        Entrada instance = null;
        instance.verify(resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntradas method, of class Entrada.
     */
    @Test
    public void testSetEntradas() {
        System.out.println("setEntradas");
        List<EntradaGenerica> entradas = null;
        Entrada instance = null;
        instance.setEntradas(entradas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVerified method, of class Entrada.
     */
    @Test
    public void testSetVerified() {
        System.out.println("setVerified");
        boolean verified = false;
        Entrada instance = null;
        instance.setVerified(verified);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVerified method, of class Entrada.
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        Entrada instance = null;
        boolean expResult = false;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Entrada.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        EntradaGenerica entry = null;
        Entrada instance = null;
        instance.add(entry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntradas method, of class Entrada.
     */
    @Test
    public void testGetEntradas() {
        System.out.println("getEntradas");
        Entrada instance = null;
        List<EntradaGenerica> expResult = null;
        List<EntradaGenerica> result = instance.getEntradas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
