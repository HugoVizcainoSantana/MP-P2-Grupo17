/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import mp.g17.users.Alumno;
import mp.g17.users.Profesor;
import mp.g17.users.Usuario;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author usuario
 */
public class EncuestaTest {

    private final Profesor profesor;
    private final Usuario userTest1;
    private final Usuario userTest2;
    private final Usuario userTest3;

    public EncuestaTest() {
        profesor = new Profesor("profe1", "ape1", "profeMolon", "profemolon@urjc.es", "asereje");
        userTest1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hugo@urjc.es", "1234");
        userTest2 = new Alumno("Hugo2", "Vizcaino2", "hvizcaino2", "hugo2@urjc.es", "1234");
        userTest3 = new Alumno("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@urjc.es", "1234");
    }

    /**
     * Test of addQuestion method, of class Encuesta.
     */
    @Test
    public void testAddQuestion() {
        Encuesta encuesta = new Encuesta(profesor, "Encuesta de satisfaccion");
        encuesta.addQuestion(new PreguntaEncuesta("¿Estais de acuerdo con el contenido que se enseña?"));
        assertEquals(1, encuesta.getPolls().size());
    }

    /**
     * Test of deleteQuestion method, of class Encuesta.
     */
    @Test
    public void testDeleteQuestion() {
        Encuesta encuesta = new Encuesta(profesor, "Encuesta de satisfaccion");
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta("¿Estais de acuerdo con el contenido que se enseña?");
        encuesta.addQuestion(preguntaEncuesta);
        encuesta.deleteQuestion(preguntaEncuesta);
        assertEquals(0, encuesta.getPolls().size());
    }

    /**
     * Test of getAllAnswersAnonymously method, of class Encuesta.
     */
    @Test
    public void testGetAllAnswersAnonymously() {
        Encuesta encuesta = new Encuesta(profesor, "Encuesta de satisfaccion");
        PreguntaEncuesta preguntaEncuesta1 = new PreguntaEncuesta("¿Estas de acuerdo con el contenido que se enseña?");
        preguntaEncuesta1.addAnswer("Si");
        preguntaEncuesta1.addAnswer("No");
        encuesta.addQuestion(preguntaEncuesta1);
        PreguntaEncuesta preguntaEncuesta2 = new PreguntaEncuesta("¿Estas contento con el formato de la asignatura?");
        preguntaEncuesta2.addAnswer("Si");
        preguntaEncuesta2.addAnswer("No");
        encuesta.addQuestion(preguntaEncuesta2);
        encuesta.getPolls().forEach(preguntaEncuesta -> {
            preguntaEncuesta.answer(userTest1, "Si");
            preguntaEncuesta.answer(userTest2, "No");
            preguntaEncuesta.answer(userTest3, "Niet");
        });
        Map<String, Map<String, Long>> respuestasEsperadas = new HashMap<>();
        Map<String, Long> resultadosPregunta = new HashMap<>();
        resultadosPregunta.put("Si", 1L);
        resultadosPregunta.put("No", 1L);
        respuestasEsperadas.put("¿Estas de acuerdo con el contenido que se enseña?", resultadosPregunta);
        respuestasEsperadas.put("¿Estas contento con el formato de la asignatura?", resultadosPregunta);
        assertEquals(respuestasEsperadas, encuesta.getAllAnswersAnonymously());
    }

    /**
     * Test of getAllAnswers method, of class Encuesta.
     */
    @Test
    public void testGetAllAnswers() {
        Encuesta encuesta = new Encuesta(profesor, "Encuesta de satisfaccion");
        PreguntaEncuesta preguntaEncuesta1 = new PreguntaEncuesta("¿Estas de acuerdo con el contenido que se enseña?");
        preguntaEncuesta1.addAnswer("Si");
        preguntaEncuesta1.addAnswer("No");
        encuesta.addQuestion(preguntaEncuesta1);
        PreguntaEncuesta preguntaEncuesta2 = new PreguntaEncuesta("¿Estas contento con el formato de la asignatura?");
        preguntaEncuesta2.addAnswer("Si");
        preguntaEncuesta2.addAnswer("No");
        encuesta.addQuestion(preguntaEncuesta2);
        encuesta.getPolls().forEach(preguntaEncuesta -> {
            preguntaEncuesta.answer(userTest1, "Si");
            preguntaEncuesta.answer(userTest2, "Niet");
            preguntaEncuesta.answer(userTest3, "No");
        });
        Map<String, Map<Usuario, String>> respuestasEsperadas = new HashMap<>();
        Map<Usuario, String> resultadosPregunta = new HashMap<>();
        resultadosPregunta.put(userTest1, "Si");
        resultadosPregunta.put(userTest3, "No");
        respuestasEsperadas.put("¿Estas de acuerdo con el contenido que se enseña?", resultadosPregunta);
        respuestasEsperadas.put("¿Estas contento con el formato de la asignatura?", resultadosPregunta);
        assertEquals(respuestasEsperadas, encuesta.getAllAnswers());

    }

}
