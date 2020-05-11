/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.events.EventoEntradaCreada;
import mp.g17.posts.Entrada;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

/**
 *
 * @author usuario
 */
public class UsuarioTest {

    public UsuarioTest() {
    }
    
    @Before
    public void testBefore(){
        System.out.println("Hola");
    }

    @Test
    public void testSubscribeForum() {
        Profesor prof = new Profesor ("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo post = new Subforo(prof,"Suscritos");
        Alumno alum = new Alumno("Sergio", "Sarria", "sarry150", "s.sarria@alumnos.urjc.es", "12345");
        alum.subscribeForum(post);
        assertTrue(alum.suscribedSubforos == post);
    }
    @After
    public void testAfter(){
        System.out.println("Adios");
    }

    /**
     * Test of update method, of class Usuario.
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

    public class UsuarioImpl extends Usuario {

        public UsuarioImpl() {
            super("", "", "", "", "");
        }
    }

}
