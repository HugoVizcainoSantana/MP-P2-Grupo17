package mp.g17.users;

import mp.g17.Penalizacion;
import mp.g17.Subforo;
import mp.g17.posts.EntradaGenerica;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Administrador extends Usuario {
    public Administrador(String email, String password) {
        super("Administrador", "", "Administrador", email, password);
    }

    public void penalizarUsuario(Alumno alumno, String reason) {
        alumno.setStrike(new Penalizacion(new GregorianCalendar(), this, reason));
    }
    public void verify(EntradaGenerica entrada,boolean resultado){
        entrada.verify(resultado);
        if(resultado==false){
            if(entrada.getCreatedBy() instanceof Alumno){
                penalizarUsuario((Alumno) entrada.getCreatedBy(),"No cumple con los requisitos para ser publicada");
            };
        }
    }
    public void updatePosts(Subforo subforo){
        subforo.setVerifiedInVisiblePosts();

    }

}
