/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import java.util.List;
import mp.g17.Subforo;
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
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstname method, of class Usuario.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getFirstname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstname method, of class Usuario.
     */
    @Test
    public void testSetFirstname() {
        System.out.println("setFirstname");
        String firstname = "";
        Usuario instance = null;
        instance.setFirstname(firstname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class Usuario.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastname method, of class Usuario.
     */
    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lastname = "";
        Usuario instance = null;
        instance.setLastname(lastname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFullName method, of class Usuario.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlias method, of class Usuario.
     */
    @Test
    public void testGetAlias() {
        System.out.println("getAlias");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getAlias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlias method, of class Usuario.
     */
    @Test
    public void testSetAlias() {
        System.out.println("setAlias");
        String alias = "";
        Usuario instance = null;
        instance.setAlias(alias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Usuario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Usuario instance = null;
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Usuario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Usuario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Usuario instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuscribedSubForos method, of class Usuario.
     */
    @Test
    public void testGetSuscribedSubForos() {
        System.out.println("getSuscribedSubForos");
        Usuario instance = null;
        List<Subforo> expResult = null;
        List<Subforo> result = instance.getSuscribedSubForos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSuscribedSubForos method, of class Usuario.
     */
    @Test
    public void testSetSuscribedSubForos() {
        System.out.println("setSuscribedSubForos");
        List<Subforo> suscribedSubforos = null;
        Usuario instance = null;
        instance.setSuscribedSubForos(suscribedSubforos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subscribeForum method, of class Usuario.
     */
    @Test
    public void testSubscribeForum() {
        System.out.println("subscribeForum");
        Subforo subforo = null;
        Usuario instance = null;
        instance.subscribeForum(subforo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Usuario instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Usuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Usuario instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Usuario.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        EventoEntradaCreada event = null;
        Usuario instance = null;
        instance.update(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class UsuarioImpl extends Usuario {

        public UsuarioImpl() {
            super("", "", "", "", "");
        }
    }
    
}
