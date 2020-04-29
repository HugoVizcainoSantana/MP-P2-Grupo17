package mp.g17;

import mp.g17.posts.*;
import mp.g17.posts.comparer.SortByPointsStrategy;
import mp.g17.posts.comparer.SortType;
import mp.g17.users.Administrador;
import mp.g17.users.Alumno;
import mp.g17.users.Profesor;
import mp.g17.users.Usuario;
import mp.g17.utils.LoggerUtils;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Sistema implements Serializable {

    // Constantes para facilitar el uso del demostrador/sistema
    public static final String CORREO_HUGO = "hs.vizcaino@alumnos.urjc.es";
    public static Logger LOGGER = LoggerUtils.getLogger(Sistema.class.getSimpleName());
    // Variables de sistema
    public static Map<String, Usuario> users;
    public static Usuario currentUser = null;
    public static List<Subforo> subforums;
    public static Subforo subforoActivo;
    public static Calendar fechaActual;

    public Sistema (){
        this.users = new HashMap<>();
        this.currentUser = null;
        this.subforums = new ArrayList<>();
        this.subforoActivo = null;
        fechaActual = new GregorianCalendar();
    }
    public static String getCorreoHugo() {
        return CORREO_HUGO;
    }

    public static Subforo createSubforo(String name) {
        return new Subforo(((Profesor) currentUser), name);
    }

    public static EntradaGenerica createEntry(String title, String text) {
        return new Entrada(currentUser, title, text);
    }

    public static Ejercicio createExercise(String title, String text, String solution) {
        return new Ejercicio(((Profesor) currentUser), title, text, solution);
    }

    public static Encuesta createSurvey(String title, String text) {
        return new Encuesta(((Profesor) currentUser), title, text);
    }




    public static boolean login(String email, String password) {
        String auth = email + ":" + password;
        LOGGER.info(String.format("Intento de inicio de sesion con credenciales %s", auth));
        Usuario userByEmail = users.get(email);
        if (userByEmail != null) {
            if (userByEmail.getPassword().equals(password)) { //Check the email and the password
                currentUser = userByEmail;
                if (currentUser instanceof Alumno) {
                    if (((Alumno) currentUser).getStrike() != null && ((Alumno) currentUser).getStrike().getFechaFinal().compareTo(fechaActual) >= 0) {
                        LOGGER.warning("Este usuario esta penalizado");
                        currentUser = null;
                        return false;
                    } else {
                        LOGGER.info("ROL : ALUMNO");
                    }
                } else if (currentUser instanceof Profesor) {
                    LOGGER.info("ROL: PROFESOR");
                } else if (currentUser instanceof Administrador) {
                    LOGGER.info("ROL: ADMINISTRADOR");
                }

                LOGGER.fine(String.format("Login correcto! Credenciales: %s", auth));
                return true;
            }

            LOGGER.warning(String.format("Credenciales erroneos para %s:<encryptedPassword>", email)); //If are wrong returns an error message
            currentUser = null;
        }


        return false;
    }

    public static boolean logout() { //Logout method
        if (currentUser != null) {
            LOGGER.fine("Haciendo logout...");
            currentUser = null;
        } else {
            LOGGER.fine("No hay sesion iniciada");
        }
        return true;
    }


    public static boolean registerUser(String name, String surname, String password, String mail, String alias) {
        Usuario user;
        if (users.containsKey(mail)) { // Checks if the introduced mail is in the system
            LOGGER.warning("Ya existe un usuario con el correo " + mail);
        }
        if (mail.endsWith("@alumnos.urjc.es")) { // Checks if the introduced mail is from an alumn
            user = new Alumno(name, surname, alias, mail, password);
            LOGGER.info("Registrando nuevo alumno con correo " + mail);
            users.put(mail, user);
            return true;
        } else if (mail.endsWith("@urjc.es")) { // Checks if the intrduced mail is from a teacher
            user = new Profesor(name, surname, alias, mail, password);
            LOGGER.info("Registrando nuevo profesor con correo " + mail);
            users.put(mail, user);
            return true;
        } else {
            LOGGER.warning("El email introducido NO es un email valido"); //And the last check is for a non valid email
            return false;
        }

    }

    public static boolean registerAdministrador(String mail, String password) {
        Administrador administrador;
        if (users.containsKey(mail)) { //Checks if the introduced mail is in the system
            LOGGER.warning("Ya existe un usuario con el correo " + mail);
        } else {
            if (mail.endsWith("@admin.urjc.es")) {
                administrador = new Administrador(mail, password);
                LOGGER.info("Registrando nuevo administrador con correo " + mail);
                users.put(mail, administrador);//Add a new admin to the system
                return true;
            }
        }
        LOGGER.warning("El email introducido no es un email valido para un administrador");
        return false;

    }


    public static void showRegisteredUsers() { //Method that shows all the users registered in the system by mail
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Usuarios Registrados...");
            for (Map.Entry<String, Usuario> entry : users.entrySet()) {
                String key = entry.getKey();
                Usuario value = entry.getValue();
                sb.append("\n\t").append(String.format("Mail %35s -> %s", key, value));
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);
    }

    public static void showSubforumsAvaliables() { //Method that shows all the subforums created in the system
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Subforos Disponibles...");
            for (Subforo subforo : subforums) {
                if (subforo.getPosts() == null) {
                    sb.append("\n\t").append(String.format("Subforo %35s -> No tiene Entradas", subforo.getName()));
                } else {
                    sb.append("\n\t").append(String.format("Subforo %35s -> Tiene %s entrada(s)", subforo.getName(), subforo.getPosts().size()));
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);
    }

    public static void showSubforumSubscribed() { //Show the forums that a user is subscribed
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Subforos Subscritos del usuario activo");
            if (currentUser instanceof Alumno || currentUser instanceof Profesor) {
                for (Subforo subforo : currentUser.getSuscribedSubForos()) { //Check with for if the user is in the forum
                    if (subforo.getPosts().size() == 0) {
                        sb.append("\n\t").append(String.format("El usuario %s no esta subscrito a ningun subforo", currentUser.getFullName()));
                    } else {
                        sb.append("\n\t").append(String.format("El usuario %30s -> Subforo: %s  ", currentUser.getFullName(), subforo.getName()));
                    }
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);
    }

    public static Subforo chooseSubforum(String name) { //Method to choose a subforum by name
        for (Subforo subforo : subforums) {
            if (subforo.getName().equalsIgnoreCase(name)) {
                return subforo;
            }

        }
        LOGGER.warning("No existe subforo con ese nombre"); //Warn the user if it does not exists
        return null;
    }

    public static Alumno chooseAlumno(String email) {
        for (Usuario usuario : users.values()) {
            if (usuario instanceof Alumno && usuario.getEmail().equalsIgnoreCase(email)) {
                return (Alumno) usuario;
            }
        }
        return null;
    }

    public static EntradaGenerica chooseEntrada(String name) { //Method use to look for a post in the system
        for (Subforo subforo : subforums) { //The method look for it in all the subforum of the system
            for (EntradaGenerica entrada : subforo.getPostUnverified()) {
                if (name.equalsIgnoreCase(entrada.getTitle())) {
                    return entrada;
                }
            }
        }
        LOGGER.warning("No existe esa entrada con ese nombre");
        return null;
    }


    public static boolean save(Sistema system) { //Method that saves all the system information
        try (FileOutputStream file = new FileOutputStream("forum.obj")) {
            try (ObjectOutputStream output = new ObjectOutputStream(file)) {
                output.writeObject(system);
                return true;
            }
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
            return false;
        }
    }

    public static Sistema load() { //Method that loads all the system information
        Sistema system = null;
        try (FileInputStream file = new FileInputStream("forum.obj")) {
            try (ObjectInputStream input = new ObjectInputStream(file)) {
                system = (Sistema) input.readObject();
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            System.exit(-1);
        }
        return system;
    }

    public static void showPosts(Subforo subforo) { //Method that shows all the posts in the system
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Posts del subforo " + subforo.getName());
            if (subforo.getPosts().size() == 0) { //Check if a subforum is empty
                sb.append("\n\t").append(String.format("El subforo %10s no tiene posts", subforo.getName()));
            } else {
                for (EntradaGenerica post : subforo.getPosts()) {
                    sb.append("\n\t").append(String.format("Post %30s -> Tiene %s votos(s)", post.getTitle(), post.getPoints()));
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);

    }
}

