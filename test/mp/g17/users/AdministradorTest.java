/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.posts.Entrada;
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
public class AdministradorTest {
    
    public AdministradorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of penalizarUsuario method, of class Administrador.
     */
    @Test
    public void testPenalizarUsuario() {
        System.out.println("penalizarUsuario");
        Alumno alumno = null;
        String reason = "";
        Administrador instance = null;
        instance.penalizarUsuario(alumno, reason);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verify method, of class Administrador.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");
        Entrada entrada = null;
        boolean resultado = false;
        Administrador instance = null;
        instance.verify(entrada, resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePosts method, of class Administrador.
     */
    @Test
    public void testUpdatePosts() {
        System.out.println("updatePosts");
        Subforo subforo = null;
        Administrador instance = null;
        instance.updatePosts(subforo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
