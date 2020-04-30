package mp.g17.demostrator;

import mp.g17.Subforo;
import mp.g17.posts.*;
import mp.g17.users.Administrador;
import mp.g17.users.Alumno;
import mp.g17.users.Profesor;
import mp.g17.users.Usuario;
import mp.g17.utils.LoggerUtils;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema implements Serializable {

    public static Logger LOGGER = LoggerUtils.getLogger();
    public static Random RANDOM = new Random();
    private static Sistema INSTANCE;
    // Variables de sistema
    private Map<String, Usuario> users;
    private Usuario currentUser;
    private List<Subforo> subforums;
    private Subforo activeSubforum;
    private Calendar currentDate;

    private Sistema() {
        users = new HashMap<>();
        currentUser = null;
        subforums = new ArrayList<>();
        activeSubforum = null;
        currentDate = new GregorianCalendar();
        LOGGER.fine("Inicializando sistema");
    }

    public static Sistema load() { //Method that loads all the system information
        Sistema system = null;
        try (FileInputStream file = new FileInputStream("forum.obj")) {
            try (ObjectInputStream input = new ObjectInputStream(file)) {
                system = (Sistema) input.readObject();
                LOGGER.info("Datos cargados correctamente. Fecha del backup:" + system.getCurrentDate().toString());
                LOGGER.info("Cambiando fecha actual del sistema al momento actual");
                system.currentDate = new GregorianCalendar();
                LOGGER.info(system.toString());
            }
        } catch (Exception ex) {
            LOGGER.severe("Error en la carga de datos del sistema...");
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            System.exit(-1);
        }
        return system;
    }

    public static boolean save(Sistema system) { //Method that saves all the system information
        try (FileOutputStream file = new FileOutputStream("forum.obj")) {
            try (ObjectOutputStream output = new ObjectOutputStream(file)) {
                system.currentUser = null;
                system.activeSubforum = null;
                system.currentDate = new GregorianCalendar();
                output.writeObject(system);
                return true;
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    public static Sistema getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Sistema();
        }
        return INSTANCE;
    }

    public Map<String, Usuario> getUsers() {
        return users;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public List<Subforo> getSubforums() {
        return subforums;
    }

    public Subforo getActiveSubforum() {
        return activeSubforum;
    }

    public void setActiveSubforum(Subforo subforo) {
        this.activeSubforum = subforo;
    }

    public Calendar getCurrentDate() {
        return currentDate;
    }

    public void showPosts(Subforo subforo) { //Method that shows all the posts in the system
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Posts del subforo ").append(subforo.getName());
            if (subforo.getPosts().size() == 0) { //Check if a subforum is empty
                sb.append("\n\t").append(String.format("El subforo %10s no tiene posts", subforo.getName()));
            } else {
                sb.append("Los posts estan ordenados con la estrategia ").append(subforo.getSortingStrategy()).append(" ").append(subforo.getSortingStrategy().sortType);
                for (EntradaGenerica post : subforo.getPosts()) {
                    sb.append("\n\t").append(String.format("Post %30s Creado: %20s-> Tiene %s votos(s)", post.getTitle(), post.getCreationDate(), post.getPoints()));
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);

    }

    public Subforo createSubforo(String name) {
        LOGGER.info("Creando subforo: " + name);
        return new Subforo(((Profesor) currentUser), name);
    }

    public Ejercicio createExercise(String title, String solution) {
        sleep();
        return new Ejercicio(((Profesor) currentUser), title, solution);
    }

    public Encuesta createSurvey(String title) {
        sleep();
        return new Encuesta(((Profesor) currentUser), title);
    }

    public TextoPlano createTextDescription(String text) {
        sleep();
        return new TextoPlano(currentUser, text);
    }

    public boolean login(String email, String password) {
        String auth = email + ":" + password;
        LOGGER.info(String.format("Intento de inicio de sesion con credenciales %s", auth));
        Usuario userByEmail = users.get(email);
        if (userByEmail != null) {
            if (userByEmail.getPassword().equals(password)) { //Check the email and the password
                currentUser = userByEmail;
                if (currentUser instanceof Alumno) {
                    if (((Alumno) currentUser).getStrike() != null && ((Alumno) currentUser).getStrike().getFechaFinal().compareTo(currentDate) >= 0) {
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
                for (Subforo subforum : subforums) {
                    subforum.setSortingStrategy(Subforo.DEFAULT_SORT);
                }
                return true;
            }

            LOGGER.warning(String.format("Credenciales erroneos para %s:<encryptedPassword>", email)); //If are wrong returns an error message
            currentUser = null;
        }


        return false;
    }

    public boolean verifyAllEntries(Subforo subforo) {
        if (currentUser instanceof Administrador) {
            for (Entrada entry : subforo.getPostUnverified()) {
                ((Administrador) currentUser).verify(entry, true);
            }
            ((Administrador) currentUser).updatePosts(activeSubforum);
            return true;
        } else {
            LOGGER.warning("NO TIENE PERMISOS PARA ESTO");
            return false;
        }
    }

    public boolean logout() { //Logout method
        if (currentUser != null) {
            LOGGER.fine("Haciendo logout...");
            currentUser = null;
            LOGGER.fine("Cambiando sistema de ordenacion de subforos al por defecto, para que un usuario sin logear vea los posts ordenados por puntos descendente.");
            for (Subforo subforum : subforums) {
                subforum.setSortingStrategy(Subforo.DEFAULT_SORT);
            }
        } else {
            LOGGER.fine("No hay sesion iniciada");
        }
        return true;
    }

    public void showInformationPost(Entrada entrada) {
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Informacion Detalla Post ").append(entrada.getTitle());
            for (EntradaGenerica entry : entrada.getEntradas()) {
                if (entry instanceof Encuesta) {
                    sb.append("\n\t").append(String.format("Encuesta ->  %s preguntas", ((Encuesta) entry).getPolls().size()));
                } else if (entry instanceof TextoPlano) {
                    sb.append("\n\t").append(String.format("Texto plano %5s", entry.getContent()));
                } else if (entry instanceof Ejercicio) {
                    sb.append("\n\t").append(String.format("Ejercicio %10s -> %s (respuesta)", entry.getTitle(), ((Ejercicio) entry).getSolution()));
                } else {
                    sb.append("Es una entrada sin nada");
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);

    }

    public boolean registerUser(String name, String surname, String password, String mail, String alias) {
        Usuario user;
        LOGGER.info("Registrando nuevo usuario con email: " + mail);
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

    public boolean registerAdministrador(String mail, String password) {
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

    public void showRegisteredUsers() { //Method that shows all the users registered in the system by mail
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

    public void showSubforumsAvaliables() { //Method that shows all the subforums created in the system
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
    public void showComments(Entrada entrada){
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Comentarios del post " + entrada.getTitle());
            if (currentUser instanceof Alumno || currentUser instanceof Profesor) {
                for (Comentario comentario : entrada.getCommentList()) { //Check with for if the user is in the forum
                    if (entrada.getCommentList().size() == 0) {
                        sb.append("\n\t").append("El  post seleccionado no tiene comentarios");
                    } else {
                        sb.append("\n\t").append(String.format(" %s : Comentario: %10s -> %s", comentario.getCreatedBy().getEmail(), comentario.getText(),comentario.getPoints()));
                    }
                }
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);

    }

    public void showSubforumSubscribed() { //Show the forums that a user is subscribed
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Listando Subforos Subscritos del usuario activo");
            if (currentUser instanceof Alumno || currentUser instanceof Profesor) {
                if (currentUser.getSuscribedSubForos().size() == 0)
                    sb.append("\n\t").append(String.format("El usuario %s no esta subscrito a ningun subforo", currentUser.getFullName()));
                else
                    sb.append("\n\t").append(String.format("El usuario %s esta subscrito a %d subforo(s)", currentUser.getFullName(), currentUser.getSuscribedSubForos().size()));
            }
            return sb.toString();
        };
        LOGGER.fine(supplier);
    }

    public Subforo chooseSubforum(String name) { //Method to choose a subforum by name
        for (Subforo subforo : subforums) {
            if (subforo.getName().equalsIgnoreCase(name)) {
                return subforo;
            }

        }
        LOGGER.warning("No existe subforo con ese nombre"); //Warn the user if it does not exists
        return null;
    }

    public Alumno chooseAlumno(String email) {
        for (Usuario usuario : users.values()) {
            if (usuario instanceof Alumno && usuario.getEmail().equalsIgnoreCase(email)) {
                return (Alumno) usuario;
            }
        }
        return null;
    }

    public Entrada chooseEntrada(String name) { //Method use to look for a post in the system
        for (Subforo subforo : subforums) { //The method look for it in all the subforum of the system
            for (Entrada entrada : subforo.getPosts()) {
                if (name.equalsIgnoreCase(entrada.getTitle())) {
                    return entrada;
                }
            }
        }
        LOGGER.warning("No existe esa entrada con ese nombre");
        return null;
    }

    public boolean addSubforum(Subforo subforum) {
        return subforums.add(subforum);
    }


    @Override
    public String toString() {
        return new StringJoiner(",", Sistema.class.getSimpleName() + "[", "]")
                .add("\n\t\tusers=" + users)
                .add("\n\t\tcurrentUser=" + currentUser)
                .add("\n\t\tsubforums=" + subforums)
                .add("\n\t\tactiveSubforum=" + activeSubforum)
                .toString();
    }

    public void showSurveyResult(Encuesta encuesta, boolean showUsernames) {
        if (showUsernames) {
            Map<String, Map<Usuario, String>> resultado_encuesta = encuesta.getAllAnswers();
            resultado_encuesta.forEach((pregunta, resultados) -> {
                LOGGER.info("Pregunta: " + pregunta);
                resultados.forEach((usuario, respuesta) -> LOGGER.info("\tUsuario:" + usuario.getFullName() + " | Respuesta: " + respuesta));
            });
        } else {
            Map<String, Map<String, Long>> resultado_encuesta = encuesta.getAllAnswersAnonymously();
            resultado_encuesta.forEach((pregunta, resultados) -> {
                LOGGER.info("Pregunta: " + pregunta);
                resultados.forEach((respuesta, numVotos) -> LOGGER.info("\tRespuesta:" + respuesta + " | Veces votado: " + numVotos));
            });
        }
    }

    public void showSurveyResult(Encuesta encuesta) {
        showSurveyResult(encuesta, false);
    }

    private void sleep() {
        try {
            Thread.sleep(RANDOM.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

