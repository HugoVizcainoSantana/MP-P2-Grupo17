/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import java.time.Instant;
import java.util.Map;
import mp.g17.users.Usuario;
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
public class ComentarioTest {
    
    public ComentarioTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getText method, of class Comentario.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        Comentario instance = null;
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class Comentario.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        Comentario instance = null;
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersVotes method, of class Comentario.
     */
    @Test
    public void testGetUsersVotes() {
        System.out.println("getUsersVotes");
        Comentario instance = null;
        Map<Usuario, Boolean> expResult = null;
        Map<Usuario, Boolean> result = instance.getUsersVotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoints method, of class Comentario.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        Comentario instance = null;
        int expResult = 0;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPoints method, of class Comentario.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        int points = 0;
        Comentario instance = null;
        instance.setPoints(points);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreationDate method, of class Comentario.
     */
    @Test
    public void testGetCreationDate() {
        System.out.println("getCreationDate");
        Comentario instance = null;
        Instant expResult = null;
        Instant result = instance.getCreationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class Comentario.
     */
    @Test
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        Comentario instance = null;
        Usuario expResult = null;
        Usuario result = instance.getCreatedBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedBy method, of class Comentario.
     */
    @Test
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        Usuario createdBy = null;
        Comentario instance = null;
        instance.setCreatedBy(createdBy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
