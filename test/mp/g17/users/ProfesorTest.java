/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.events.EventoEntradaCreada;
import mp.g17.posts.Entrada;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author usuario
 */
public class ProfesorTest {

    public ProfesorTest() {
    }

    /**
     * Test of update method, of class Profesor.
     */
    @Test
    public void testUpdate() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo posts = new Subforo(prof, "Novedades");
        Entrada entry = new Entrada(prof, "Ejercicios");
        EventoEntradaCreada event = new EventoEntradaCreada(posts, entry);
        prof.update(event);
        int resultado = 1;
        assertEquals(prof.getNumberNotifications(), resultado);
    }

}
