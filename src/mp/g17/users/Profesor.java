package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.events.EventoEntradaCreada;
import mp.g17.posts.Ejercicio;
import mp.g17.posts.Encuesta;
import mp.g17.posts.Entrada;

public class Profesor extends Usuario {

    public Profesor(String firstname, String lastname, String alias, String email, String password) { //Constructor for a teacher user 
        super(firstname, lastname, alias, email, password);
    }
    public Subforo createSubforo(String name){//This method allows a professor to create a subforum 
        return new Subforo(name);
        }

    @Override
    public void update(EventoEntradaCreada event) {//This method returns the alert of have created a new post
        System.out.println("Soy el Profesor " + email + " que ha recibido una notificacion de post creado");
        super.update(event);
    }

    public  Encuesta createSurvey(String title, String text){
        return new Encuesta(this,title,text);
    }
    public Ejercicio createExercise(String title, String text,String solucion){
        return new Ejercicio(this,title,text,solucion);
    }
}
