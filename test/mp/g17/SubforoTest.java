/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp.g17;

import java.util.List;
import static mp.g17.demostrator.Sistema.RANDOM;
import mp.g17.posts.Entrada;
import mp.g17.posts.comparer.ASortingStrategy;
import mp.g17.posts.comparer.SortByDateStrategy;
import mp.g17.posts.comparer.SortByPointsStrategy;
import mp.g17.posts.comparer.SortType;
import mp.g17.users.Administrador;
import mp.g17.users.Profesor;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author usuario
 */
public class SubforoTest {

    public SubforoTest() {
    }
    @Before
    public void testBefore(){
        System.out.println("Hola");
    }
    @After
    public void testAfter(){
        System.out.println("Adios");
    }
    @Test
    public void testAddUser() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        sub.addUser(prof);
        assertTrue(sub.getNumberObservers() == 1);
    }

    /**
     * Test of addNewEntry method, of class Subforo.
     */
    @Test
    public void testAddNewEntry() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        Entrada entry = new Entrada(prof, "Ejercicios");
        sub.addNewEntry(entry);
        assertTrue(sub.getNumberEntries() == 1);
    }

    /**
     * Test of deleteUser method, of class Subforo.
     */
    @Test
    public void testDeleteUser() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        sub.addUser(prof);
        System.out.println("Numero de miembros en el foro: " + sub.getNumberObservers());
        sub.deleteUser(prof);
        System.out.println("Numero de miembros en el foro: " + sub.getNumberObservers());
        assertTrue(sub.getNumberObservers() == 0);
    }

    /**
     * Test of deleteInput method, of class Subforo.
     */
    @Test
    public void testDeleteInput() {
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        Entrada entry = new Entrada(prof, "Ejercicios");
        sub.addNewEntry(entry);
        System.out.println("Numero de entradas en el foro: " + sub.getNumberEntries());
        sub.setVerifiedInVisiblePosts();
        System.out.println("Numero de entradas verificadas en el foro: " + sub.getNumberEntries());
        sub.deleteInput(entry);
        System.out.println("Numero de entradas en el foro: " + sub.getNumberEntries());
        System.out.println("Numero de entradas verificadas en el foro: " + sub.getNumberOfVerfiedPosts());
        assertTrue(sub.getNumberOfVerfiedPosts() == 0);
    }
   
    
    @Test
    public void testgetPostsVotes(){
        Profesor prof = new Profesor("Jose", "Perez", "", "j.perez@.urjc.es", "12345");
        Administrador admin = new Administrador("a.perez@urjc.es", "12345");
        Subforo sub = new Subforo(prof, "Profesores");
        Entrada entry = new Entrada(prof, "Ejercicios");
        Entrada entry1 = new Entrada(prof, "Resolucion 1");
        Entrada entry2 = new Entrada(prof, "Resolucion 2");
        Entrada entry3 = new Entrada(prof, "Resolucion 3");
        entry.setPoints(12);
        entry1.setPoints(74);
        entry2.setPoints(63);
        entry3.setPoints(8);
        admin.verify(entry, true);
        admin.verify(entry1, true);
        admin.verify(entry2, true);
        admin.verify(entry3, true);
        sub.addNewEntry(entry1);
        sub.addNewEntry(entry3);
        sub.addNewEntry(entry2);
        sub.addNewEntry(entry);
        admin.updatePosts(sub);
        sub.setSortingStrategy(new SortByPointsStrategy(SortType.DESCENDING));
        List<Entrada> list = sub.getPosts();
        boolean comp = false;
        System.out.println(list.size());
        for(int i = 0; i <= list.size() - 2; i++){
            if(list.get(i).getPoints() > list.get(i + 1).getPoints()){
                comp = true;
            }
        }
        assertEquals(comp, true);
    }

}
