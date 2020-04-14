package mp.g17.users;

import mp.g17.events.EventoEntradaCreada;

public class Profesor extends Usuario {

    public Profesor(String firstname, String lastname, String alias, String email, String password) {
        super(firstname, lastname, alias, email, password);
    }

    @Override
    public void update(EventoEntradaCreada event) {
        System.out.println("Soy el Profesor " + email + " que ha recibido una notificacion de post creado");
        super.update(event);
    }
}
