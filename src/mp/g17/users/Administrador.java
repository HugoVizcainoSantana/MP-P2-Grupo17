package mp.g17.users;

import mp.g17.Penalizacion;
import mp.g17.Subforo;
import mp.g17.posts.EntradaGenerica;


import java.util.GregorianCalendar;

public class Administrador extends Usuario { 
    public Administrador(String email, String password) { //Constructor of the administrator user type
        super("Administrador", "", "Administrador", email, password);
    }

    public void penalizarUsuario(Alumno alumno, String reason) { //This method penalizes a member from the forum
        alumno.setStrike(new Penalizacion(new GregorianCalendar(), this, reason));

    }
    public void verify(EntradaGenerica entrada,boolean resultado){ //If a post does not get verified the author becomes banned
        entrada.verify(resultado);
        if(resultado==false){
            if(entrada.getCreatedBy() instanceof Alumno){
                penalizarUsuario((Alumno) entrada.getCreatedBy(),"No cumple con los requisitos para ser publicada");
            }
        }
    }
    public void updatePosts(Subforo subforo){ //This method refresh which post are available to be seen
        subforo.setVerifiedInVisiblePosts();

    }

}
