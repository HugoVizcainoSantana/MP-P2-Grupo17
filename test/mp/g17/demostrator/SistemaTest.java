/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.demostrator;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import mp.g17.Subforo;
import mp.g17.posts.Ejercicio;
import mp.g17.posts.Encuesta;
import mp.g17.posts.Entrada;
import mp.g17.posts.TextoPlano;
import mp.g17.users.Alumno;
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
public class SistemaTest {
    
    public SistemaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of load method, of class Sistema.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        Sistema expResult = null;
        Sistema result = Sistema.load();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Sistema.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Sistema system = null;
        boolean expResult = false;
        boolean result = Sistema.save(system);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getINSTANCE method, of class Sistema.
     */
    @Test
    public void testGetINSTANCE() {
        System.out.println("getINSTANCE");
        Sistema expResult = null;
        Sistema result = Sistema.getINSTANCE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Sistema.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Sistema instance = null;
        Map<String, Usuario> expResult = null;
        Map<String, Usuario> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUser method, of class Sistema.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        Sistema instance = null;
        Usuario expResult = null;
        Usuario result = instance.getCurrentUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubforums method, of class Sistema.
     */
    @Test
    public void testGetSubforums() {
        System.out.println("getSubforums");
        Sistema instance = null;
        List<Subforo> expResult = null;
        List<Subforo> result = instance.getSubforums();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActiveSubforum method, of class Sistema.
     */
    @Test
    public void testGetActiveSubforum() {
        System.out.println("getActiveSubforum");
        Sistema instance = null;
        Subforo expResult = null;
        Subforo result = instance.getActiveSubforum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActiveSubforum method, of class Sistema.
     */
    @Test
    public void testSetActiveSubforum() {
        System.out.println("setActiveSubforum");
        Subforo subforo = null;
        Sistema instance = null;
        instance.setActiveSubforum(subforo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDate method, of class Sistema.
     */
    @Test
    public void testGetCurrentDate() {
        System.out.println("getCurrentDate");
        Sistema instance = null;
        Calendar expResult = null;
        Calendar result = instance.getCurrentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showPosts method, of class Sistema.
     */
    @Test
    public void testShowPosts() {
        System.out.println("showPosts");
        Subforo subforo = null;
        Sistema instance = null;
        instance.showPosts(subforo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSubforo method, of class Sistema.
     */
    @Test
    public void testCreateSubforo() {
        System.out.println("createSubforo");
        String name = "";
        Sistema instance = null;
        Subforo expResult = null;
        Subforo result = instance.createSubforo(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createExercise method, of class Sistema.
     */
    @Test
    public void testCreateExercise() {
        System.out.println("createExercise");
        String title = "";
        String solution = "";
        Sistema instance = null;
        Ejercicio expResult = null;
        Ejercicio result = instance.createExercise(title, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSurvey method, of class Sistema.
     */
    @Test
    public void testCreateSurvey() {
        System.out.println("createSurvey");
        String title = "";
        Sistema instance = null;
        Encuesta expResult = null;
        Encuesta result = instance.createSurvey(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTextDescription method, of class Sistema.
     */
    @Test
    public void testCreateTextDescription() {
        System.out.println("createTextDescription");
        String text = "";
        Sistema instance = null;
        TextoPlano expResult = null;
        TextoPlano result = instance.createTextDescription(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Sistema.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String email = "";
        String password = "";
        Sistema instance = null;
        boolean expResult = false;
        boolean result = instance.login(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyAllEntries method, of class Sistema.
     */
    @Test
    public void testVerifyAllEntries() {
        System.out.println("verifyAllEntries");
        Subforo subforo = null;
        Sistema instance = null;
        boolean expResult = false;
        boolean result = instance.verifyAllEntries(subforo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class Sistema.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        Sistema instance = null;
        boolean expResult = false;
        boolean result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showInformationPost method, of class Sistema.
     */
    @Test
    public void testShowInformationPost() {
        System.out.println("showInformationPost");
        Entrada entrada = null;
        Sistema instance = null;
        instance.showInformationPost(entrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class Sistema.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String name = "";
        String surname = "";
        String password = "";
        String mail = "";
        String alias = "";
        Sistema instance = null;
        boolean expResult = false;
        boolean result = instance.registerUser(name, surname, password, mail, alias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerAdministrador method, of class Sistema.
     */
    @Test
    public void testRegisterAdministrador() {
        System.out.println("registerAdministrador");
        String mail = "";
        String password = "";
        Sistema instance = null;
        boolean expResult = false;
        boolean result = instance.registerAdministrador(mail, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRegisteredUsers method, of class Sistema.
     */
    @Test
    public void testShowRegisteredUsers() {
        System.out.println("showRegisteredUsers");
        Sistema instance = null;
        instance.showRegisteredUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSubforumsAvaliables method, of class Sistema.
     */
    @Test
    public void testShowSubforumsAvaliables() {
        System.out.println("showSubforumsAvaliables");
        Sistema instance = null;
        instance.showSubforumsAvaliables();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showComments method, of class Sistema.
     */
    @Test
    public void testShowComments() {
        System.out.println("showComments");
        Entrada entrada = null;
        Sistema instance = null;
        instance.showComments(entrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSubforumSubscribed method, of class Sistema.
     */
    @Test
    public void testShowSubforumSubscribed() {
        System.out.println("showSubforumSubscribed");
        Sistema instance = null;
        instance.showSubforumSubscribed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseSubforum method, of class Sistema.
     */
    @Test
    public void testChooseSubforum() {
        System.out.println("chooseSubforum");
        String name = "";
        Sistema instance = null;
        Subforo expResult = null;
        Subforo result = instance.chooseSubforum(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseAlumno method, of class Sistema.
     */
    @Test
    public void testChooseAlumno() {
        System.out.println("chooseAlumno");
        String email = "";
        Sistema instance = null;
        Alumno expResult = null;
        Alumno result = instance.chooseAlumno(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseEntrada method, of class Sistema.
     */
    @Test
    public void testChooseEntrada() {
        System.out.println("chooseEntrada");
        String name = "";
        Sistema instance = null;
        Entrada expResult = null;
        Entrada result = instance.chooseEntrada(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSubforum method, of class Sistema.
     */
    @Test
    public void testAddSubforum() {
        System.out.println("addSubforum");
        Subforo subforum = null;
        Sistema instance = null;
        boolean expResult = false;
        boolean result = instance.addSubforum(subforum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sistema.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sistema instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSurveyResult method, of class Sistema.
     */
    @Test
    public void testShowSurveyResult_Encuesta_boolean() {
        System.out.println("showSurveyResult");
        Encuesta encuesta = null;
        boolean showUsernames = false;
        Sistema instance = null;
        instance.showSurveyResult(encuesta, showUsernames);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSurveyResult method, of class Sistema.
     */
    @Test
    public void testShowSurveyResult_Encuesta() {
        System.out.println("showSurveyResult");
        Encuesta encuesta = null;
        Sistema instance = null;
        instance.showSurveyResult(encuesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
