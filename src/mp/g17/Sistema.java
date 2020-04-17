package mp.g17;

import mp.g17.users.Alumno;
import mp.g17.users.Usuario;

import java.util.HashMap;
import java.util.Map;

public class Sistema {

    private static Map<String, Usuario> users = new HashMap<>();
    private static Usuario currentUser = null;

    public static void main(String[] args) {
        System.out.println("Inicializando sistema!");
        Usuario alumno1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hvizcaino@alumnos.urjc.es", "12345");
        System.out.println("Creado alumno1 = " + alumno1);
        users.put(alumno1.getEmail(), alumno1);
    }


    public static boolean login(String email, String password) {
        Usuario userByEmail = users.get(email);
        if (userByEmail != null && userByEmail.getPassword().equals(password)) {
            currentUser = userByEmail;
            return true;
        }
        return false;
    }

    public static boolean logout() {
        currentUser = null;
        return true;
    }
}
