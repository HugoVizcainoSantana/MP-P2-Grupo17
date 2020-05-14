/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17.posts;

import mp.g17.users.Alumno;
import mp.g17.users.Usuario;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author usuario
 */
public class ComentarioTest {

    private final Usuario userTest1;
    private final Usuario userTest2;
    private final Usuario userTest3;

    public ComentarioTest() {
        userTest1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hugo@urjc.es", "1234");
        userTest2 = new Alumno("Hugo2", "Vizcaino2", "hvizcaino2", "hugo2@urjc.es", "1234");
        userTest3 = new Alumno("Hugo3", "Vizcaino3", "hvizcaino3", "hugo3@urjc.es", "1234");
    }

    /**
     * Test of getVotes method, of class Comentario, inherited default implementation from interface.
     */
    @Test
    public void testVotes() {
        Comentario comment = new Comentario(userTest1, "Viva la programacion!");
        comment.vote(true, userTest1);
        assertEquals(1, comment.getPoints());
        comment.vote(false, userTest2);
        assertEquals(0, comment.getPoints());
        comment.vote(false, userTest3);
        assertEquals(-1, comment.getPoints());
        comment.vote(true, userTest2);
        assertEquals(1, comment.getPoints());
    }

}
