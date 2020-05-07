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
public class PreguntaEncuestaTest {
    
    public PreguntaEncuestaTest() {
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
     * Test of addAnswer method, of class PreguntaEncuesta.
     */
    @Test
    public void testAddAnswer() {
        System.out.println("addAnswer");
        String newAnswer = "";
        PreguntaEncuesta instance = null;
        List<String> expResult = null;
        List<String> result = instance.addAnswer(newAnswer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestion method, of class PreguntaEncuesta.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        PreguntaEncuesta instance = null;
        String expResult = "";
        String result = instance.getQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuestion method, of class PreguntaEncuesta.
     */
    @Test
    public void testSetQuestion() {
        System.out.println("setQuestion");
        String question = "";
        PreguntaEncuesta instance = null;
        instance.setQuestion(question);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswersRegistered method, of class PreguntaEncuesta.
     */
    @Test
    public void testGetAnswersRegistered() {
        System.out.println("getAnswersRegistered");
        PreguntaEncuesta instance = null;
        Map<Usuario, String> expResult = null;
        Map<Usuario, String> result = instance.getAnswersRegistered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of answer method, of class PreguntaEncuesta.
     */
    @Test
    public void testAnswer() {
        System.out.println("answer");
        Usuario user = null;
        String answer = "";
        PreguntaEncuesta instance = null;
        boolean expResult = false;
        boolean result = instance.answer(user, answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswers method, of class PreguntaEncuesta.
     */
    @Test
    public void testGetAnswers() {
        System.out.println("getAnswers");
        PreguntaEncuesta instance = null;
        List<String> expResult = null;
        List<String> result = instance.getAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
