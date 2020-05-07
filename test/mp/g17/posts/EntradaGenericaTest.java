/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import java.time.Instant;
import java.util.List;
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
public class EntradaGenericaTest {
    
    public EntradaGenericaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCreationDate method, of class EntradaGenerica.
     */
    @Test
    public void testSetCreationDate() {
        System.out.println("setCreationDate");
        Instant creationDate = null;
        EntradaGenerica instance = null;
        instance.setCreationDate(creationDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommentList method, of class EntradaGenerica.
     */
    @Test
    public void testGetCommentList() {
        System.out.println("getCommentList");
        EntradaGenerica instance = null;
        List<Comentario> expResult = null;
        List<Comentario> result = instance.getCommentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCommentList method, of class EntradaGenerica.
     */
    @Test
    public void testSetCommentList() {
        System.out.println("setCommentList");
        List<Comentario> commentList = null;
        EntradaGenerica instance = null;
        instance.setCommentList(commentList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comment method, of class EntradaGenerica.
     */
    @Test
    public void testComment() {
        System.out.println("comment");
        Comentario texto = null;
        EntradaGenerica instance = null;
        boolean expResult = false;
        boolean result = instance.comment(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class EntradaGenerica.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        EntradaGenerica instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class EntradaGenerica.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        EntradaGenerica instance = null;
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersVotes method, of class EntradaGenerica.
     */
    @Test
    public void testGetUsersVotes() {
        System.out.println("getUsersVotes");
        EntradaGenerica instance = null;
        Map<Usuario, Boolean> expResult = null;
        Map<Usuario, Boolean> result = instance.getUsersVotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoints method, of class EntradaGenerica.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        EntradaGenerica instance = null;
        int expResult = 0;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPoints method, of class EntradaGenerica.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        int points = 0;
        EntradaGenerica instance = null;
        instance.setPoints(points);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreationDate method, of class EntradaGenerica.
     */
    @Test
    public void testGetCreationDate() {
        System.out.println("getCreationDate");
        EntradaGenerica instance = null;
        Instant expResult = null;
        Instant result = instance.getCreationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class EntradaGenerica.
     */
    @Test
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        EntradaGenerica instance = null;
        Usuario expResult = null;
        Usuario result = instance.getCreatedBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class EntradaGenerica.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        EntradaGenerica instance = null;
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class EntradaGenerica.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "";
        EntradaGenerica instance = null;
        instance.setContent(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EntradaGenericaImpl extends EntradaGenerica {

        public EntradaGenericaImpl() {
            super(null, "");
        }
    }
    
}
