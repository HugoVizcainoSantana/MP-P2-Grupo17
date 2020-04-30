package mp.g17.users;

import mp.g17.events.EventoEntradaCreada;
import mp.g17.utils.LoggerUtils;

import java.util.logging.Logger;

public class Profesor extends Usuario {


    public Profesor(String firstname, String lastname, String alias, String email, String password) { //Constructor for a teacher user
        super(firstname, lastname, alias, email, password);

    }

    @Override
    public void update(EventoEntradaCreada event) {//This method returns the alert of have created a new post
        Logger logger=LoggerUtils.getLogger(Profesor.class.getSimpleName());
        logger.info("Soy el Profesor " + email + " que ha recibido una notificacion de post creado");
        super.update(event);
    }

}
