package mp.g17;

import mp.g17.posts.Ejercicio;
import mp.g17.posts.Encuesta;
import mp.g17.posts.EntradaGenerica;
import mp.g17.posts.PreguntaEncuesta;
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
    private static Map<String, Usuario> users = new HashMap<>();
    private static Usuario currentUser = null;
    private static List<Subforo> subforums = new ArrayList<>();
    private static Subforo subforoActivo;
    private static Calendar fechaActual = new GregorianCalendar();


    public static void main(String[] args) {
        // Register of some users
        LOGGER.fine("Inicializando sistema!");
        if (registerUser("Juan", "Perez", "12345", "j.perez@urjc.es", "jPerez")) { //adds a new user (professor)
            LOGGER.info("Profesor Juan Registrado");
        }
        if (registerAdministrador("juan@admin.urjc.es", "12345")) { //Makes the professor a new admin
            LOGGER.info("Administrador registrado");
        }

        if (registerUser("Pedro", "Jimenez", "12345", "pjimenez@alumnos.urjc.es", "pedrito")) { //Adds a new alumn
            LOGGER.info("Alumno Pedro Registrado");
        }

        if (registerUser("Borja", "Castro", "12345", "b.castro.2018@alumnos.urjc.es", "bcastro")) {
            LOGGER.info("Alumno Borja Registrado");
        }

        if (registerUser("Hugo", "Vizcaino", "hugo1234", CORREO_HUGO, "hVizcaino")) {
            LOGGER.info("Alumno registrado correctamente");
        }
        //Login of a student
        if (login(CORREO_HUGO, "hugo1235")) {
            LOGGER.info("Se ha iniciado sesion con las credenciales " + CORREO_HUGO + ":hugo1235"); //Login
        }
        if (login(CORREO_HUGO, "hugo1234")) {
            LOGGER.info("Se ha iniciado sesion con las credenciales " + CORREO_HUGO + ":hugo1234");
        }

        LOGGER.info(String.format("El usuario actual (con sesion iniciada) es:%s", currentUser));


        showRegisteredUsers(); //Show the users registered in the system
        logout();

        //Login Profesor rol

        login("j.perez@urjc.es", "12345");

        LOGGER.info("Creacion de subforos"); // Creates a new subforum
        if (currentUser instanceof Profesor) {
            subforums.add(((Profesor) currentUser).createSubforo("Preguntas practica"));
            subforums.add(((Profesor) currentUser).createSubforo("Evaluacion"));
        }


        showSubforumsAvaliables(); // Show the subforums
        if (currentUser instanceof Profesor) {
            LOGGER.info("Vamos a crear una encuesta");
            Encuesta encuesta = ((Profesor) currentUser).createSurvey("Encuesta de Aprobados", "Vamos a ver cuanta gente espera aprobar");
            encuesta.addQuestion(new PreguntaEncuesta("¿Cree usted que va a aprobar?"));
            chooseSubforum("Preguntas practica").addInput(encuesta);
            LOGGER.info("Vamos a crear un ejercicio");
            Ejercicio ejercicio = ((Profesor) currentUser).createExercise("Hello world en java", "Debemos hacer el hello world en java", "System.out.println\"Hello world \"");
            chooseSubforum("Preguntas practica").addInput(ejercicio);
        }
        logout();
        LOGGER.info("Vamos a mostrar los post creados en los subforos"); // Show the posts subforum
        for (Subforo subforum : subforums) {
            showPosts(subforum);
        }
        LOGGER.info("Se han ordenado los posts en el subforo con la estrategia 'OrdenarPorPuntuacion' con tipo Ordenacion Descendente. A partir de ahora, siempre se devolveran ordenados asi.");
        for (Subforo subforum : subforums) {
            subforum.setSortingStrategy(new SortByPointsStrategy(SortType.DESCENDING)); //Sort the subforums by punctuation
            showPosts(subforum);

        }
        LOGGER.info("Elegimos el subforo para hacer la entrada");
        login("pjimenez@alumnos.urjc.es", "12345");
        if (currentUser != null) {
            subforoActivo = chooseSubforum("Preguntas practica");
            EntradaGenerica entrada = currentUser.createEntry("prueba", "probando"); //Makes a new post for the subforum "preguntas practica"

            if (subforoActivo != null) {
                subforoActivo.addInput(entrada);// Add the post to the subforum
                LOGGER.fine("Post " + entrada.getTitle() + " creada");
                LOGGER.info("Esperando validacion por el administrador");
            }
            subforoActivo = chooseSubforum("Evaluacion");

            entrada = currentUser.createEntry("Evaluacion practica", "Se pondran las notas aqui");
            subforoActivo.addInput(entrada);

            LOGGER.info("Vamos a intentar hacer un una entrada en un subforo inexistente");
            subforoActivo = chooseSubforum("practicas");
            if (subforoActivo != null) {
                subforoActivo.addInput(entrada); // Add the post to a not existant subforum
                LOGGER.fine("Post " + entrada.getTitle() + " creada");
            }
        } else {
            LOGGER.warning("Debe haber iniciado sesion un usuario para estas opciones");
        }
        LOGGER.info("Vamos a mostrar los post creados en los subforos");
        for (Subforo subforum : subforums) {
            showPosts(subforum);
        }
        logout();//logout as alumn

        login("juan@admin.urjc.es", "12345"); //Login as admin
        if (currentUser instanceof Administrador) {
            LOGGER.info("Vamos a verificar las entradas pendientes en los subforos"); //Check the posts as admin before set the as available
            for (Subforo subforo : subforums) {
                for (EntradaGenerica entry : subforo.getPostUnverified()) {
                    ((Administrador) currentUser).verify(entry, true);
                }
                ((Administrador) currentUser).updatePosts(subforo);
            }

            LOGGER.fine("Entradas verificadas");
            ((Administrador) currentUser).penalizarUsuario(chooseAlumno("b.castro.2018@alumnos.urjc.es"), "No cumple los requisitos");

        }
        logout();

        LOGGER.info("Vamos a mostrar los post creados y verificados en los subforos..."); // Show the verified posts
        for (Subforo subforum : subforums) {
            showPosts(subforum);
        }
        //Login with a stricker user
        login("b.castro.2018@alumnos.urjc.es", "12345");
        subforoActivo = chooseSubforum("Preguntas practica");

        LOGGER.info("Vamos a votar el post llamado prueba");
        if (currentUser != null) {
            for (EntradaGenerica entry : subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(true, currentUser);
                }
            }

        } else {
            LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        login(CORREO_HUGO, "hugo1234");
        LOGGER.info("Vamos a votar el post llamado prueba");
        if (currentUser != null) {
            for (EntradaGenerica entry : subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(true, currentUser);
                }
            }
            showPosts(subforoActivo);
            LOGGER.info("Vamos a intentar duplicar el voto");
            for (EntradaGenerica entry : subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(true, currentUser);
                }
            }
            showPosts(subforoActivo);

            LOGGER.info("Vamos a comprobar como se puede modificar  el voto");
            for (EntradaGenerica entry : subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(false, currentUser);
                }
            }
            showPosts(subforoActivo);
            LOGGER.info("Vamos a subscribirnos a un subforo");
            currentUser.subscribeForum(chooseSubforum("Preguntas practica"));
            showSubforumSubscribed();
        } else {
            LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        LOGGER.info("Vamos a avanzar 3 dias para ver si nos podemos loguear despues de la penalizacion");
        fechaActual.add(Calendar.DAY_OF_MONTH, 3);
        login("b.castro.2018@alumnos.urjc.es", "12345");
        logout();


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
        LOGGER.fine("Haciendo logout...");
        currentUser = null;
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
                        sb.append("\n\t").append(String.format("El usuario %30s -> %s  ", currentUser.getFullName(), subforo.getName()));
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


    private static boolean save(Sistema system) { //Method that saves all the system information
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

    private static void showPosts(Subforo subforo) { //Method that shows all the posts in the system
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

