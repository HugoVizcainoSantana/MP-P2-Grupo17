/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

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
public class EncuestaTest {
    
    public EncuestaTest() {
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
     * Test of addQuestion method, of class Encuesta.
     */
    @Test
    public void testAddQuestion() {
        System.out.println("addQuestion");
        PreguntaEncuesta question = null;
        Encuesta instance = null;
        instance.addQuestion(question);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteQuestion method, of class Encuesta.
     */
    @Test
    public void testDeleteQuestion() {
        System.out.println("deleteQuestion");
        PreguntaEncuesta question = null;
        Encuesta instance = null;
        instance.deleteQuestion(question);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPolls method, of class Encuesta.
     */
    @Test
    public void testGetPolls() {
        System.out.println("getPolls");
        Encuesta instance = null;
        List<PreguntaEncuesta> expResult = null;
        List<PreguntaEncuesta> result = instance.getPolls();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPolls method, of class Encuesta.
     */
    @Test
    public void testSetPolls() {
        System.out.println("setPolls");
        List<PreguntaEncuesta> polls = null;
        Encuesta instance = null;
        instance.setPolls(polls);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAnswersAnonymously method, of class Encuesta.
     */
    @Test
    public void testGetAllAnswersAnonymously() {
        System.out.println("getAllAnswersAnonymously");
        Encuesta instance = null;
        Map<String, Map<String, Long>> expResult = null;
        Map<String, Map<String, Long>> result = instance.getAllAnswersAnonymously();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAnswers method, of class Encuesta.
     */
    @Test
    public void testGetAllAnswers() {
        System.out.println("getAllAnswers");
        Encuesta instance = null;
        Map<String, Map<Usuario, String>> expResult = null;
        Map<String, Map<Usuario, String>> result = instance.getAllAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
