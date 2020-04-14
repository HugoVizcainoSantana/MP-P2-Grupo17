package mp.g17.users;

public class Administrador extends Usuario{
    public Administrador( String email, String password) {
        super("Administrador", "", "Administrador", email, password);
    }

    public void penalizarUsuario(Alumno alumno){
        alumno.penalizar();

    }

}
