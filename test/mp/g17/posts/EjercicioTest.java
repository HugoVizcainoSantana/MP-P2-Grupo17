/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import mp.g17.users.Profesor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author usuario
 */
public class EjercicioTest {

    public EjercicioTest() {
    }

    /**
     * Test of getSolution method, of class Ejercicio.
     */
    @Test
    public void testGetSolution() {
        Profesor profesor = new Profesor("profe1", "ape1", "profeMolon", "profemolon@urjc.es", "asereje");
        Ejercicio ejercicio = new Ejercicio(profesor, "¿Que lenguaje usamos en MP?", "Java");
        assertEquals(ejercicio.getSolution(), "Java");
    }

}
