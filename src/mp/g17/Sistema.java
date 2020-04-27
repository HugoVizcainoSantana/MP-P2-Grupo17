package mp.g17;

import mp.g17.posts.Entrada;
import mp.g17.posts.EntradaGenerica;
import mp.g17.posts.comparer.SortByPointsStrategy;
import mp.g17.posts.comparer.SortType;
import mp.g17.users.Administrador;
import mp.g17.users.Alumno;
import mp.g17.users.Profesor;
import mp.g17.users.Usuario;
import mp.g17.utils.LoggerUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Sistema implements Serializable {

    // Constantes para facilitar el uso del demostrador/sistema
    public static final String CORREO_HUGO = "hs.vizcaino@alumnos.urjc.es";
    public static Logger LOGGER = LoggerUtils.getLogger(Sistema.class.getSimpleName());
    // Variables de sistema
    private static Map<String, Usuario> users = new HashMap<>();
    private static Usuario currentUser = null;
    private static List<Subforo> subforums = new ArrayList<>();



    public static void main(String[] args) {
        LOGGER.fine("Inicializando sistema!");
        if (registerUser("Juan", "Perez", "12345", "j.perez@urjc.es", "jPerez")) {
            LOGGER.info("Profesor Juan Registrado");
        }
        if(registerAdministrador("juan@admin.urjc.es","12345")){
            LOGGER.info("Administrador registrado");
        }


        if (registerUser("Pedro", "Jimenez", "12345", "pjimenez@alumnos.urjc.es", "pedrito")) {
            LOGGER.info("Alumno Pedro Registrado");
        }

        if (registerUser("Borja", "Castro", "12345", "b.castro.2018@alumnos.urjc.es", "bcastro")) {
            LOGGER.info("Alumno Borja Registrado");
        }

        if (registerUser("Hugo", "Vizcaino", "hugo1234", CORREO_HUGO, "hVizcaino")) {
            LOGGER.info("Alumno registrado correctamente");
        }
        if (login(CORREO_HUGO, "hugo1235")) {
            LOGGER.info("Se ha iniciado sesion con las credenciales " + CORREO_HUGO + ":hugo1235");
        }
        if (login(CORREO_HUGO, "hugo1234")) {
            LOGGER.info("Se ha iniciado sesion con las credenciales " + CORREO_HUGO + ":hugo1234");
        }

        LOGGER.info(String.format("El usuario actual (con sesion iniciada) es:%s", currentUser));

        showRegisteredUsers();

        LOGGER.info("Creacion de subforos");
        if (createSubforum("Notas de la practica")) {
            LOGGER.info("Subforo creado");
        }
        if (createSubforum("Preguntas practica")) {
            LOGGER.info("Subforo creado");
        }

        showSubforumsAvaliables();
        LOGGER.info("Vamos a mostrar los post creados en los subforos");
        for (Subforo subforum : subforums) {
            showPosts(subforum);
        }

        LOGGER.info("Se han ordenado los posts en el subforo con la estrategia 'OrdenarPorPuntuacion' con tipo Ordenacion Descendente. A partir de ahora, siempre se devolveran ordenados asi.");
        for(Subforo subforum: subforums){
            subforum.setSortingStrategy(new SortByPointsStrategy(SortType.DESCENDING));
            showPosts(subforum);

        }
       LOGGER.info("Elegimos el subforo para hacer la entrada");
        Subforo subforoActivo= chooseSubforum("Preguntas practica");
        EntradaGenerica entrada = new Entrada(currentUser,"prueba","hello");

        if (subforoActivo != null) {
            subforoActivo.addInput(entrada);
            LOGGER.fine("Post "+entrada.getTitle() +" creada");
        }

        LOGGER.info("Vamos a intentar hacer un una entrada en un subforo inexistente");
        subforoActivo= chooseSubforum(" practicas");
        if(subforoActivo!=null){
            subforoActivo.addInput(entrada);
            LOGGER.fine("Post "+entrada.getTitle() +" creada");
        }


        LOGGER.info("Vamos a mostrar los post creados en los subforos");
        for (Subforo subforum : subforums) {
            showPosts(subforum);
        }

        logout();
        login("juan@admin.urjc.es","12345");
        if(currentUser instanceof Administrador){
            for(Subforo subforo: subforums){
                for(EntradaGenerica entrad : subforo.getPostUnverified()){
                    LOGGER.info("Vamos a verificar las entradas pendientes en los subforos");
                    ((Administrador) currentUser).verify(entrad,true);
                    ((Administrador) currentUser).updatePosts(subforo);
                }
            }
            LOGGER.fine("Entradas verificadas");

        }
        logout();
        LOGGER.info("Vamos a mostrar los post creados y verificados en los subforos");
        for (Subforo subforum : subforums) {
            showPosts(subforum);
        }
    }


    public static boolean login(String email, String password) {
        String auth = email + ":" + password;
        LOGGER.fine(String.format("Intento de inicio de sesion con credenciales %s", auth));
        Usuario userByEmail = users.get(email);
        if (userByEmail != null) {
            if (userByEmail.getPassword().equals(password)) {
                currentUser = userByEmail;
                LOGGER.info(String.format("Login correcto! Credenciales: %s", auth));
                return true;
            }
            LOGGER.warning(String.format("Credenciales erroneos para %s:<encryptedPassword>", email));
        }

        return false;
    }

    public static boolean logout() {
        LOGGER.fine("Haciendo logout...");
        currentUser = null;
        return true;
    }



    public static boolean registerUser(String name, String surname, String password, String mail, String alias) {
        Usuario user;
        if (users.containsKey(mail)) {
            LOGGER.warning("Ya existe un usuario con el correo " + mail);
        }
        if (mail.endsWith("@alumnos.urjc.es")) {
            user = new Alumno(name, surname, alias, mail, password);
            LOGGER.info("Registrando nuevo alumno con correo " + mail);
            users.put(mail, user);
            return true;
        } else if (mail.endsWith("@urjc.es")) {
            user = new Profesor(name, surname, alias, mail, password);
            LOGGER.info("Registrando nuevo profesor con correo " + mail);
            users.put(mail, user);
            return true;
        } else{
            LOGGER.warning("El email introducido NO es un email valido");
            return false;
        }

    }
    public static boolean registerAdministrador(String mail, String password){
        Administrador administrador;
        if(users.containsKey(mail)){
            LOGGER.warning("Ya existe un usuario con el correo " + mail);
        }else{
            if(mail.endsWith("@admin.urjc.es")) {
                administrador = new Administrador(mail, password);
                LOGGER.info("Registrando nuevo administrador con correo "+ mail);
                users.put(mail,administrador);
                return true;
            }
        }
        LOGGER.warning("El email introducido no es un email valido para un administrador");
        return false;

    }


    public static void showRegisteredUsers() {
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

    public static void showSubforumsAvaliables() {
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


    public static boolean createSubforum(String name) {
        Subforo forum = new Subforo(name);
        subforums.add(forum);
        LOGGER.info("Creando subforo " + name);
        return true;
    }


    public static Subforo chooseSubforum(String name) {
        for (Subforo subforo : subforums) {
            if (subforo.getName().equalsIgnoreCase(name)) {
                return subforo;
            }

        }
        LOGGER.warning("No existe subforo con ese nombre");
        return null;
    }
    public static EntradaGenerica chooseEntrada(String name){
        for(Subforo subforo: subforums){
            for(EntradaGenerica entrada : subforo.getPostUnverified()){
                if(name.equalsIgnoreCase(entrada.getTitle())){
                    return entrada;
                }
            }
        }
        LOGGER.warning("No existe esa entrada con ese nombre");
        return null;
    }


    private static boolean save(Sistema system) {
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

    public static Sistema load() {
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

    private static void showPosts(Subforo subforo) {
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Posts del subforo "+ subforo.getName());
            if (subforo.getPosts().size()==0) {
                sb.append("\n\t").append(String.format("El subforo %10s no tiene posts",subforo.getName()));
            }else {
                for (EntradaGenerica post : subforo.getPosts()) {
                    sb.append("\n\t").append(String.format("Post %30s -> Tiene %s votos(s)", post.getTitle(), post.getPoints()));
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);

    }
}

