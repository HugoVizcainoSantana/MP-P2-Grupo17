/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import mp.g17.users.Alumno;
import mp.g17.users.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author usuario
 */
public class EntradaTest {

    private final Usuario userTest1;
    private final Usuario userTest2;
    private final Usuario userTest3;

    public EntradaTest() {
        userTest1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hugo@urjc.es", "1234");
        userTest2 = new Alumno("Hugo2", "Vizcaino2", "hvizcaino2", "hugo2@urjc.es", "1234");
        userTest3 = new Alumno("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@urjc.es", "1234");
    }

    /**
     * Test of verify method, of class Entrada.
     */
    @Test
    public void testVerifySuccesful() {
        Entrada entrada = new Entrada(userTest1, "Entrada de JUnit");
        assertFalse(entrada.isVerified());
        entrada.verify(true);
        assertTrue(entrada.isVerified());
    }

    @Test
    public void testVerifyUnuccesful() {
        Entrada entrada = new Entrada(userTest1, "Entrada de JUnit");
        assertFalse(entrada.isVerified());
        entrada.verify(false);
        assertFalse(entrada.isVerified());
    }

    /**
     * Test of add method, of class Entrada.
     */
    @Test
    public void testAdd() {

    }

    @Test
    public void testVote() {
        Entrada entry = new Entrada(userTest1, "Viva la programacion!");
        // Ignoring creator votes
        entry.vote(true, userTest1);
        assertEquals(0, entry.getPoints());
        entry.vote(false, userTest1);
        assertEquals(0, entry.getPoints());
        // Voting false, should have less points
        entry.vote(false, userTest2);
        assertEquals(-1, entry.getPoints());
        entry.vote(false, userTest3);
        assertEquals(-2, entry.getPoints());
        // Changing a vote, it should eliminate the last vote (so points == -1) and then add a positive vote (points == 0)
        entry.vote(true, userTest2);
        assertEquals(0, entry.getPoints());
        // Undoing a vote, so it should substract -1 (because the vote was negative)
        entry.vote(null, userTest3);
        assertEquals(1, entry.getPoints());
    }

}
