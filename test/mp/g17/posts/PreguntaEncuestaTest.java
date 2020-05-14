/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import mp.g17.users.Alumno;
import mp.g17.users.Usuario;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author usuario
 */
public class PreguntaEncuestaTest {

    private final Usuario userTest1;
    private final Usuario userTest2;
    private final Usuario userTest3;

    public PreguntaEncuestaTest() {
        userTest1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hugo@urjc.es", "1234");
        userTest2 = new Alumno("Hugo2", "Vizcaino2", "hvizcaino2", "hugo2@urjc.es", "1234");
        userTest3 = new Alumno("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@urjc.es", "1234");
    }

    /**
     * Test of addAnswer method, of class PreguntaEncuesta.
     */
    @Test
    public void testAddAnswer() {
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta("Pregunta 1");
        preguntaEncuesta.addAnswer("Respuesta 1");
        preguntaEncuesta.addAnswer("Respuesta 2");
        assertEquals(2, preguntaEncuesta.getAnswers().size());

    }

    /**
     * Test of getAnswersRegistered method, of class PreguntaEncuesta.
     */
    @Test
    public void testGetAnswersRegistered() {
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta("Pregunta 1");
        preguntaEncuesta.addAnswer("Respuesta 1");
        preguntaEncuesta.addAnswer("Respuesta 2");
        preguntaEncuesta.answer(userTest1, "Si");
        preguntaEncuesta.answer(userTest2, "No");
        preguntaEncuesta.answer(userTest3, "Niet");
        Map<Usuario, String> answersExpected = new HashMap<>();
        answersExpected.put(userTest1, "Si");
        answersExpected.put(userTest2, "No");
        assertEquals(answersExpected, preguntaEncuesta.getAnswersRegistered());
    }

    /**
     * Test of answer method, of class PreguntaEncuesta.
     */
    @Test
    public void testAnswerSuccess() {
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta("Pregunta 1");
        preguntaEncuesta.addAnswer("Respuesta 1");
        preguntaEncuesta.answer(userTest1, "Respuesta 1");
        assertEquals(1, preguntaEncuesta.getAnswersRegistered().size());
    }

    @Test
    public void testAnswerInvalid() {
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta("Pregunta 1");
        preguntaEncuesta.addAnswer("Respuesta 1");
        preguntaEncuesta.answer(userTest3, "Respuesta asereje");
        assertEquals(0, preguntaEncuesta.getAnswersRegistered().size());
    }

}
