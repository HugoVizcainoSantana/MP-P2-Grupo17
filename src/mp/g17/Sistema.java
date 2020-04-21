package mp.g17;

import mp.g17.users.Alumno;
import mp.g17.users.Profesor;
import mp.g17.users.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema implements Serializable {

    // Constantes para facilitar el uso del demostrador/sistema
    public static final String CORREO_HUGO = "hs.vizcaino@alumnos.urjc.es";

    // Variables de sistema
    private static Map<String, Usuario> users = new HashMap<>();
    private static Usuario currentUser = null;
    private static List<Subforo> subforums = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Inicializando sistema!");
        if (registerUser("Hugo", "Vizcaino", "hugo1234", CORREO_HUGO, "hVizcaino")) {
            System.out.println("Usuario registrado correctamente");
        }
        if (login(CORREO_HUGO, "hugo1235")) {
            System.out.println("Se ha iniciado sesion con las credenciales " + CORREO_HUGO + ":hugo1235");
        } else {
            System.out.println("No se ha podido iniciar sesion con las credenciales " + CORREO_HUGO + ":hugo1235");
        }
        if (login(CORREO_HUGO, "hugo1234")) {
            System.out.println("Se ha iniciado sesion con las credenciales " + CORREO_HUGO + ":hugo1234");
        } else {
            System.out.println("No se ha podido iniciar sesion con las credenciales " + CORREO_HUGO + ":hugo1235");
        }

        System.out.println("El usuario actual (con sesion iniciada) es:\n" + currentUser);
    }


    public static boolean login(String email, String password) {
        String auth = email + ":" + password;
        System.out.println("Intento de inicio de sesion con credenciales " + auth);
        Usuario userByEmail = users.get(email);
        if (userByEmail != null) {
            if (userByEmail.getPassword().equals(password)) {
                currentUser = userByEmail;
                System.out.println("Login correcto! Credenciales: " + auth);
                return true;
            }
            System.err.println("El correo recibido no existe");
        }

        return false;
    }

    public static boolean logout() {
        System.out.println("Haciendo logout...");
        currentUser = null;
        return true;
    }

    public static boolean registerUser(String name, String surname, String password, String mail, String alias) {
        Usuario user;
        if (users.containsKey(mail)) {
            System.err.println("Ya existe un usuario con el correo " + mail);
        }
        if (mail.endsWith("@alumnos.urjc.es")) {
            user = new Alumno(name, surname, alias, mail, password);
            System.out.println("Registrando nuevo alumno con correo " + mail);
            users.put(mail, user);
            return true;
        } else if (mail.endsWith("@urjc.es")) {
            user = new Profesor(name, surname, alias, mail, password);
            System.out.println("Registrando nuevo profesor con correo " + mail);
            users.put(mail, user);
            return true;
        } else {
                System.out.println("El email introducido NO es un email valido");
            return false;
        }

    }

    public static boolean createSubforum(String name) {
        Subforo forum = new Subforo(name);
        subforums.add(forum);
        return true;
    }

    private static boolean save(Sistema system) {
        try (FileOutputStream file = new FileOutputStream("forum.obj")) {
            try (ObjectOutputStream output = new ObjectOutputStream(file)) {
                output.writeObject(system);
                return true;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static Sistema load() {
        Sistema system = null;
        try (FileInputStream file = new FileInputStream("forum.obj")) {
            try (ObjectInputStream input = new ObjectInputStream(file)) {
                system = (Sistema) input.readObject();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return system;
    }
}
