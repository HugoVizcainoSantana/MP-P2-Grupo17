package mp.g17.users;

import mp.g17.Penalizacion;
import mp.g17.events.EventoEntradaCreada;

public class Alumno extends Usuario {
    private Penalizacion strike;

    public Alumno(String firstname, String lastname, String alias, String email, String password) {
        super(firstname, lastname, alias, email, password);
    }

    @Override
    public void update(EventoEntradaCreada event) {
        System.out.println("Soy el Alumno " + email + " que ha recibido una notificacion de post creado");
        super.update(event);
    }

    public Penalizacion getStrike() {
        return strike;
    }

    public void setStrike(Penalizacion strike) {
        System.out.println("El alumno " + email + " esta recibiendo una penalizacion de " + strike.getPenalizedBy().getEmail() + ".\n\tMotivo: " + strike.getReason());
        this.strike = strike;
    }
}
