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
        Alumno u = new Alumno ;
        Administrador admin = new Administrador;
        admin.penalizarUsuario(u,comportamiento);
        assertTrue(u.getStrike());

    }
    @Test
    public void testVerify() {
        Administrador admin = new Administrador;
        Entrada e = new Entrada;
        admin.Verify(e,true);
        assertTrue(e.isVerified);

    }

    /**
     * Test of updatePosts method, of class Administrador.
     */
    @Test
    public void testUpdatePosts() {
        Subforo sub = new Subforo;
        Administrador admin = new Administrador;
        Entrada e = new Entrada;
        admin.Verify(e,true);
        sub.postUnverified.add(e);
        admin.updatePosts(sub);
        assetEquals(1, sub.posts.size());
    }
    
}
