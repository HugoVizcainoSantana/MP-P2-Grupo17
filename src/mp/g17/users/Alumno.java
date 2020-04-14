package mp.g17.users;

import mp.g17.Penalizacion;
import mp.g17.events.EventoEntradaCreada;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Alumno extends Usuario {
    private boolean tienePenalizacionActiva;
    private Penalizacion penalizacion;

    public Alumno(String firstname, String lastname, String alias, String email, String password) {
        super(firstname, lastname, alias, email, password);
        tienePenalizacionActiva=false;
    }

    @Override
    public void update(EventoEntradaCreada event) {
        System.out.println("Soy el Alumno " + email + " que ha recibido una notificacion de post creado");
        super.update(event);
    }
    public void penalizar (){
        tienePenalizacionActiva=true;
        penalizacion= new Penalizacion(new GregorianCalendar());

    }
    public boolean estaPenalizado(){
        return tienePenalizacionActiva;
    }
}
