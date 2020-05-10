/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.events.EventoEntradaCreada;
import mp.g17.posts.Entrada;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author usuario
 */
public class AlumnoTest {

    /**
     * Test of update method, of class Alumno.
     */
    @Test
    public void testUpdate() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo posts = new Subforo(prof, "Novedades");
        Alumno alum = new Alumno("Sergio", "Sarria", "sarry150", "s.sarria@alumnos.urjc.es", "12345");
        Entrada entry = new Entrada(alum, "Ejercicios");
        EventoEntradaCreada event = new EventoEntradaCreada(posts, entry);
        alum.update(event);
        int resultado = 1;
        assertTrue(alum.getNumberNotifications() == resultado);
    }

}
