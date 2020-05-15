/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.demostrator;

import mp.g17.Subforo;
import mp.g17.posts.*;
import mp.g17.users.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class SistemaTest {

    public SistemaTest() {
    }

    /**
     * Test of load method, of class Sistema.
     */
    @Test
    public void testLoad() {
        Sistema sistema= new Sistema();
        Sistema.save(sistema);
        assertNotNull(Sistema.load());
    }

    /**
     * Test of save method, of class Sistema.
     */
    @Test
    public void testSave() {
        Sistema sistema= new Sistema();
        Sistema.save(sistema);
    }

    /**
     * Test of getINSTANCE method, of class Sistema.
     */
    @Test
    public void testGetINSTANCE() {
        assertNotNull(Sistema.getINSTANCE());
    }

    /**
     * Test of getUsers method, of class Sistema.
     */
    @Test
    public void testGetUsers() {
        Sistema sistema= new Sistema();
        List<Usuario> usuarios= new ArrayList<>();
        Usuario usuarioTest= new Alumno("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@alumnos.urjc.es", "1234");
        usuarios.add(usuarioTest);
        sistema.registerUser("Hugo3", "Vizcaino3", "1234", "hugo3@alumnos.urjc.es", "hvizcaino3");
        assertEquals(usuarios.size(),sistema.getUsers().size());



    }

    /**
     * Test of getCurrentUser method, of class Sistema.
     */
    @Test
    public void testGetCurrentUser() {
        Sistema sistema= new Sistema();
        Usuario usuarioTest= new Alumno("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@urjc.es", "1234");
        sistema.registerUser("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@urjc.es", "1234");
        sistema.login("hugo3@urjc.es", "1234");
        assertEquals(sistema.getCurrentUser(), usuarioTest);
    }

    /**
     * Test of getSubforums method, of class Sistema.
     */
    @Test
    public void testGetSubforums() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        Sistema sistema= new Sistema();
        sistema.addSubforum(sub);
        int i=0;
        for(Subforo subforum: sistema.getSubforums()) {
            if (sub == subforum) {
                i++;
            }
        }
        assertEquals(sistema.getSubforums().size(),i);
        }



    /**
     * Test of getActiveSubforum method, of class Sistema.
     */
    @Test
    public void testGetActiveSubforum() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        Sistema sistema= new Sistema();
        sistema.addSubforum(sub);
        sistema.setActiveSubforum(sub);
        assertEquals(sistema.getActiveSubforum(),sub);
    }

    /**
     * Test of setActiveSubforum method, of class Sistema.
     */
    @Test
    public void testSetActiveSubforum() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        Sistema sistema= new Sistema();
        sistema.addSubforum(sub);
        sistema.setActiveSubforum(sub);
        assertNotNull(sistema.getActiveSubforum());
    }

    /**
     * Test of getCurrentDate method, of class Sistema.
     */
    @Test
    public void testGetCurrentDate() {
        Calendar fecha= new GregorianCalendar();
        Sistema sistema= new Sistema();
        int resta = sistema.getCurrentDate().get(Calendar.SECOND) -   fecha.get(Calendar.SECOND);
        assertEquals(resta,0);
    }

    /**
     * Test of showPosts method, of class Sistema.
     */
    @Test
    public void testShowPosts() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.showPosts(sistema.chooseSubforum("Test 1"));
        assertNotNull(sistema.chooseSubforum("Test 1"));




    }

    /**
     * Test of createSubforo method, of class Sistema.
     */
    @Test
    public void testCreateSubforo() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        Subforo sub= sistema.createSubforo("Test 1");
        assertNotNull(sub);
    }

    /**
     * Test of createExercise method, of class Sistema.
     */
    @Test
    public void testCreateExercise() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        if(sistema.getCurrentUser()instanceof Profesor) {
            assertNotNull(sistema.createExercise("Vamos a sumar 2 +2", "4"));
        }else{
            fail();
        }


    }

    /**
     * Test of createSurvey method, of class Sistema.
     */
    @Test
    public void testCreateSurvey() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        if(sistema.getCurrentUser()instanceof Profesor){
            assertNotNull(sistema.createSurvey("Hello"));
        }


    }

    /**
     * Test of createTextDescription method, of class Sistema.
     */
    @Test
    public void testCreateTextDescription() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        assertNotNull(sistema.createTextDescription("Hello"));
    }

    /**
     * Test of login method, of class Sistema.
     */
    @Test
    public void testLogin() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        assertTrue(sistema.login("b.alberto@urjc.es","1234"));
    }

    /**
     * Test of verifyAllEntries method, of class Sistema.
     */
    @Test
    public void testVerifyAllEntries() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.setActiveSubforum(sistema.chooseSubforum("Test 1"));
        sistema.getActiveSubforum().addNewEntry(new Entrada(sistema.getCurrentUser(),"Hello"));
        sistema.logout();
        sistema.registerAdministrador("admin@admin.urjc.es","1234");
        sistema.login("admin@admin.urjc.es","1234");
        if (sistema.getCurrentUser() instanceof Administrador){
            assertTrue(sistema.verifyAllEntries(sistema.chooseSubforum("Test 1")));
        }
        else{
            fail();
        }


    }

    /**
     * Test of logout method, of class Sistema.
     */
    @Test
    public void testLogout() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        assertTrue(sistema.logout());

    }

    /**
     * Test of showInformationPost method, of class Sistema.
     */
    @Test
    public void testShowInformationPost() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.setActiveSubforum(sistema.chooseSubforum("Test 1"));
        sistema.getActiveSubforum().addNewEntry(new Entrada(sistema.getCurrentUser(),"Hello"));
        sistema.logout();
        sistema.registerAdministrador("admin@admin.urjc.es","1234");
        sistema.login("admin@admin.urjc.es","1234");
        sistema.verifyAllEntries(sistema.chooseSubforum("Test 1"));
        assertTrue(sistema.showInformationPost(sistema.chooseEntrada("Hello")));

    }

    /**
     * Test of registerUser method, of class Sistema.
     */
    @Test
    public void testRegisterUser() {
        Sistema sistema= new Sistema();
        assertTrue(sistema.registerUser("borja","Pere","1234","borja.pere@alumnos.urjc.es",""));

    }

    /**
     * Test of registerAdministrador method, of class Sistema.
     */
    @Test
    public void testRegisterAdministrador() {
        Sistema sistema= new Sistema();
        assertTrue(sistema.registerAdministrador("borj@admin.urjc.es","12345"));

    }

    /**
     * Test of showRegisteredUsers method, of class Sistema.
     */
    @Test
    public void testShowRegisteredUsers() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.showRegisteredUsers();
        assertNotNull(sistema.getUsers());

    }

    /**
     * Test of showSubforumsAvaliables method, of class Sistema.
     */
    @Test
    public void testShowSubforumsAvaliables() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.addSubforum(sistema.createSubforo("Prueba"));
        assertTrue(sistema.showSubforumsAvaliables());
    }

    /**
     * Test of showComments method, of class Sistema.
     */
    @Test
    public void testShowComments() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.setActiveSubforum(sistema.chooseSubforum("Test 1"));
        sistema.getActiveSubforum().addNewEntry(new Entrada(sistema.getCurrentUser(),"Hello"));
        sistema.logout();
        sistema.registerAdministrador("admin@admin.urjc.es","1234");
        sistema.login("admin@admin.urjc.es","1234");
        sistema.verifyAllEntries(sistema.chooseSubforum("Test 1"));
        sistema.logout();
        sistema.login("b.alberto@urjc.es","1234");
        sistema.chooseEntrada("Hello").comment(new Comentario(sistema.getCurrentUser(),"Probando"));
        assertTrue(sistema.showComments(sistema.chooseEntrada("Hello")));
    }

    /**
     * Test of showSubforumSubscribed method, of class Sistema.
     */
    @Test
    public void testShowSubforumSubscribed() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.getCurrentUser().subscribeForum(sistema.chooseSubforum("Test 1"));
        assertTrue(sistema.showSubforumSubscribed());
    }

    /**
     * Test of chooseSubforum method, of class Sistema.
     */
    @Test
    public void testChooseSubforum() {
        Sistema sistema = new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        assertNotNull(sistema.chooseSubforum("Test 1"));


    }

    /**
     * Test of chooseAlumno method, of class Sistema.
     */
    @Test
    public void testChooseAlumno() {
        Sistema sistema = new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@alumnos.urjc.es","");
        assertNotNull(sistema.chooseAlumno("b.alberto@alumnos.urjc.es"));
    }

    /**
     * Test of chooseEntrada method, of class Sistema.
     */
    @Test
    public void testChooseEntrada() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.setActiveSubforum(sistema.chooseSubforum("Test 1"));
        sistema.getActiveSubforum().addNewEntry(new Entrada(sistema.getCurrentUser(),"Hello"));
        sistema.logout();
        sistema.registerAdministrador("admin@admin.urjc.es","1234");
        sistema.login("admin@admin.urjc.es","1234");
        sistema.verifyAllEntries(sistema.chooseSubforum("Test 1"));
        sistema.logout();
        assertNotNull(sistema.chooseEntrada("Hello"));
    }

    /**
     * Test of addSubforum method, of class Sistema.
     */
    @Test
    public void testAddSubforum() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        Subforo subforo= sistema.createSubforo("Test 1");
        assertTrue(sistema.addSubforum(subforo));

    }


    /**
     * Test of showSurveyResult method, of class Sistema.
     */
    @Test
    public void testShowSurveyResult_Encuesta_boolean() {
        Sistema sistema= new Sistema();
        sistema.registerUser("borja","Alberto","1234","b.alberto@urjc.es","");
        sistema.login("b.alberto@urjc.es","1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.setActiveSubforum(sistema.chooseSubforum("Test 1"));
        Entrada entradaCreada = new Entrada(sistema.getCurrentUser(),"Encuesta para principantes");
        if (sistema.getCurrentUser() instanceof Profesor){
            Encuesta encuesta = new Encuesta((Profesor) sistema.getCurrentUser(),"");
            encuesta.addQuestion(new PreguntaEncuesta("Pasa el test?"));
            entradaCreada.add(encuesta);
        }

        sistema.getActiveSubforum().addNewEntry(entradaCreada);
        sistema.logout();
        sistema.registerAdministrador("admin@admin.urjc.es","1234");
        sistema.login("admin@admin.urjc.es","1234");
        sistema.verifyAllEntries(sistema.chooseSubforum("Test 1"));
        sistema.logout();
        sistema.registerUser("Juan","","1234","b.alberto@alumnos.urjc.es","");
        sistema.login("b.alberto@alumnos.urjc.es","1234");
        Entrada entradaSelelccionada=sistema.chooseEntrada("Encuesta para principantes");
        for(EntradaGenerica entrada: entradaSelelccionada.getEntradas()) {
            if (entrada instanceof Encuesta){
                for(PreguntaEncuesta pregunta: ((Encuesta) entrada).getPolls()){
                    // Añadimos aqui la posibilidad para no crear mas codigo
                    pregunta.addAnswer("Si");
                    pregunta.answer(sistema.getCurrentUser(),"Si");
                    assertTrue(sistema.showSurveyResult((Encuesta)entrada));
                }

            }

        }

    }

    /**
     * Test of showSurveyResult method, of class Sistema.
     */
    @Test
    public void testShowSurveyResult_Encuesta() {
        Sistema sistema = new Sistema();
        sistema.registerUser("borja", "Alberto", "1234", "b.alberto@urjc.es", "");
        sistema.login("b.alberto@urjc.es", "1234");
        sistema.addSubforum(sistema.createSubforo("Test 1"));
        sistema.setActiveSubforum(sistema.chooseSubforum("Test 1"));
        Entrada entradaCreada = new Entrada(sistema.getCurrentUser(), "Encuesta para principantes");
        if (sistema.getCurrentUser() instanceof Profesor) {
            Encuesta encuesta = new Encuesta((Profesor) sistema.getCurrentUser(), "");
            encuesta.addQuestion(new PreguntaEncuesta("Pasa el test?"));
            entradaCreada.add(encuesta);
        }

        sistema.getActiveSubforum().addNewEntry(entradaCreada);
        sistema.logout();
        sistema.registerAdministrador("admin@admin.urjc.es", "1234");
        sistema.login("admin@admin.urjc.es", "1234");
        sistema.verifyAllEntries(sistema.chooseSubforum("Test 1"));
        sistema.logout();
        sistema.registerUser("Juan", "", "1234", "b.alberto@alumnos.urjc.es", "");
        sistema.login("b.alberto@alumnos.urjc.es", "1234");
        Entrada entradaSelelccionada = sistema.chooseEntrada("Encuesta para principantes");
        for (EntradaGenerica entrada : entradaSelelccionada.getEntradas()) {
            if (entrada instanceof Encuesta) {
                for (PreguntaEncuesta pregunta : ((Encuesta) entrada).getPolls()) {
                    // Añadimos aqui la posibilidad para no crear mas codigo
                    pregunta.addAnswer("Si");
                    pregunta.answer(sistema.getCurrentUser(), "Si");
                    assertTrue(sistema.showSurveyResult((Encuesta) entrada, true));
                }

            }


        }
    }

}
