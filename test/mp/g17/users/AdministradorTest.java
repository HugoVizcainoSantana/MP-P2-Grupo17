/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.posts.Entrada;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author usuario
 */
public class AdministradorTest {

    public AdministradorTest() {
    }

    /**
     * Test of penalizarUsuario method, of class Administrador.
     */
    @Test
    public void testPenalizarUsuario() {
        Alumno alum = new Alumno("Sergio", "Sarria", "sarry150", "s.sarria@alumnos.urjc.es", "12345");
        Administrador admin = new Administrador("a.perez@urjc.es", "12345");
        admin.penalizarUsuario(alum, "Comportamiento");
        assertTrue(alum.getStrike() != null);
    }

    /**
     * Test of verify method, of class Administrador.
     */
    @Test
    public void testVerify() {
        Alumno alum = new Alumno("Sergio", "Sarria", "sarry150", "s.sarria@alumnos.urjc.es", "12345");
        Administrador admin = new Administrador("a.perez@urjc.es", "12345");
        Entrada entry = new Entrada(alum, "Ejercicios");
        admin.verify(entry, true);
        assertEquals(entry.isVerified(), true);
    }

    /**
     * Test of updatePosts method, of class Administrador.
     */
    @Test
    public void testUpdatePosts() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Administrador admin = new Administrador("a.perez@urjc.es", "12345");
        Entrada entry = new Entrada(prof, "Ejercicios");
        Subforo post = new Subforo(prof, "Novedades");
        post.addNewEntry(entry);
        admin.verify(entry, true);
        admin.updatePosts(post);
        assertEquals(post.getNumberOfVerfiedPosts(), 1);
    }

}
