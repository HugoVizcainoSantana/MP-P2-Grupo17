package mp.g17.users;

import mp.g17.Penalizacion;

import java.util.GregorianCalendar;

public class Administrador extends Usuario {
    public Administrador(String email, String password) {
        super("Administrador", "", "Administrador", email, password);
    }

    public void penalizarUsuario(Alumno alumno, String reason) {
        alumno.setStrike(new Penalizacion(new GregorianCalendar(), this, reason));
    }

}
