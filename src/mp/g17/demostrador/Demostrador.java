package mp.g17.demostrador;

import mp.g17.Sistema;
import mp.g17.Subforo;
import mp.g17.posts.Ejercicio;
import mp.g17.posts.Encuesta;
import mp.g17.posts.EntradaGenerica;
import mp.g17.posts.PreguntaEncuesta;
import mp.g17.posts.comparer.SortByPointsStrategy;
import mp.g17.posts.comparer.SortType;
import mp.g17.users.Administrador;
import mp.g17.users.Profesor;

import java.util.*;

public class Demostrador {




    public static void main(String[] args) {
        Sistema system = new Sistema();
        // Register of some users
        system.LOGGER.fine("Inicializando sistema!");
        if (system.registerUser("Juan", "Perez", "12345", "j.perez@urjc.es", "jPerez")) { //adds a new user (professor)
            system.LOGGER.info("Profesor Juan Registrado");
        }
        if (system.registerAdministrador("juan@admin.urjc.es", "12345")) { //Makes the professor a new admin
            system.LOGGER.info("Administrador registrado");
        }

        if (system.registerUser("Pedro", "Jimenez", "12345", "pjimenez@alumnos.urjc.es", "pedrito")) { //Adds a new alumn
            system.LOGGER.info("Alumno Pedro Registrado");
        }

        if (system.registerUser("Borja", "Castro", "12345", "b.castro.2018@alumnos.urjc.es", "bcastro")) {
            system.LOGGER.info("Alumno Borja Registrado");
        }

        if (system.registerUser("Hugo", "Vizcaino", "hugo1234", system.CORREO_HUGO, "hVizcaino")) {
            system.LOGGER.info("Alumno registrado correctamente");
        }
        //Login of a student
        if (system.login(system.CORREO_HUGO, "hugo1235")) {
            system.LOGGER.info("Se ha iniciado sesion con las credenciales " + system.CORREO_HUGO + ":hugo1235"); //Login
        }
        if (system.login(system.CORREO_HUGO, "hugo1234")) {
            system.LOGGER.info("Se ha iniciado sesion con las credenciales " + system.CORREO_HUGO + ":hugo1234");
        }

        system.LOGGER.info(String.format("El usuario actual (con sesion iniciada) es:%s", system.currentUser));


        system.showRegisteredUsers(); //Show the users registered in the system
        system.logout();

        //Login Profesor rol

        system.login("j.perez@urjc.es", "12345");

        system.LOGGER.info("Creacion de subforos"); // Creates a new subforum
        if (system.currentUser instanceof Profesor) {
            system.subforums.add(system.createSubforo("Preguntas practica"));
            system.subforums.add(system.createSubforo("Evaluacion"));
        }


        system.showSubforumsAvaliables(); // Show the subforums
        if (system.currentUser instanceof Profesor) {
            system.LOGGER.info("Vamos a crear una encuesta");
            Encuesta encuesta = system.createSurvey("Encuesta de Aprobados", "Vamos a ver cuanta gente espera aprobar");
            encuesta.addQuestion(new PreguntaEncuesta("¿Cree usted que va a aprobar?"));
            system.chooseSubforum("Preguntas practica").addInput(encuesta);
            system.LOGGER.info("Vamos a crear un ejercicio");
            Ejercicio ejercicio = system.createExercise("Hello world en java", "Debemos hacer el hello world en java", "System.out.println(\"Hello world \")");
            system.chooseSubforum("Preguntas practica").addInput(ejercicio);
        }
        system.logout();
        system.LOGGER.info("Vamos a mostrar los post creados en los subforos"); // Show the posts subforum
        for (Subforo subforum : system.subforums) {
            system.showPosts(subforum);
        }
        system.LOGGER.info("Se han ordenado los posts en el subforo con la estrategia 'OrdenarPorPuntuacion' con tipo Ordenacion Descendente. A partir de ahora, siempre se devolveran ordenados asi.");
        for (Subforo subforum : system.subforums) {
            subforum.setSortingStrategy(new SortByPointsStrategy(SortType.DESCENDING)); //Sort the subforums by punctuation
            system.showPosts(subforum);

        }
        system.LOGGER.info("Elegimos el subforo para hacer la entrada");
        system.login("pjimenez@alumnos.urjc.es", "12345");
        if (system.currentUser != null) {
            system.subforoActivo = system.chooseSubforum("Preguntas practica");
            EntradaGenerica entrada = system.createEntry("prueba", "probando"); //Makes a new post for the subforum "preguntas practica"

            if (system.subforoActivo != null) {
                system.subforoActivo.addInput(entrada);// Add the post to the subforum
                system.LOGGER.fine("Post " + entrada.getTitle() + " creada");
                system.LOGGER.info("Esperando validacion por el administrador");
            }

            system.LOGGER.info("Vamos a intentar hacer un una entrada en un subforo inexistente");
            system.subforoActivo = system.chooseSubforum("practicas");
            if (system.subforoActivo != null) {
                system.subforoActivo.addInput(entrada); // Add the post to a not existant subforum
                system.LOGGER.fine("Post " + entrada.getTitle() + " creada");
            } else {
                system.LOGGER.warning("El subforo solicitado no existe.");
            }
        } else {
            system.LOGGER.warning("Debe haber iniciado sesion un usuario para estas opciones");
        }
        system.LOGGER.info("Vamos a mostrar los post creados en los subforos");
        for (Subforo subforum : system.subforums) {
            system.showPosts(subforum);
        }
        system.logout();//logout as alumn

        system.login("juan@admin.urjc.es", "12345"); //Login as admin
        if (system.currentUser instanceof Administrador) {
            system.LOGGER.info("Vamos a verificar las entradas pendientes en los subforos"); //Check the posts as admin before set the as available
            for (Subforo subforo : system.subforums) {
                for (EntradaGenerica entry : subforo.getPostUnverified()) {
                    ((Administrador) system.currentUser).verify(entry, true);
                }
                ((Administrador) system.currentUser).updatePosts(subforo);
            }

            system.LOGGER.fine("Entradas verificadas");
            system.LOGGER.info("Como la entrada de un alumno no ha sido adecuada, vamos a proceder a penalizarle.");
            ((Administrador) system.currentUser).penalizarUsuario(system.chooseAlumno("b.castro.2018@alumnos.urjc.es"), "No cumple los requisitos");

        }
        system.logout();

        system.LOGGER.info("Vamos a mostrar los post creados y verificados en los subforos..."); // Show the verified posts
        for (Subforo subforum : system.subforums) {
            system.showPosts(subforum);
        }
        //Login with a stricker user
        system.login("b.castro.2018@alumnos.urjc.es", "12345");
        system.subforoActivo = system.chooseSubforum("Preguntas practica");
        system.LOGGER.info("Vamos a votar el post llamado prueba");
        if (system.currentUser != null) {
            for (EntradaGenerica entry : system.subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(true, system.currentUser);
                }
            }
        } else {
            system.LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        system.login(system.CORREO_HUGO, "hugo1234");
        system.LOGGER.info("Vamos a votar el post llamado prueba");
        if (system.currentUser != null) {
            for (EntradaGenerica entry : system.subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(true, system.currentUser);
                }
            }
            system.showPosts(system.subforoActivo);
            system.LOGGER.info("Vamos a intentar duplicar el voto");
            for (EntradaGenerica entry : system.subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(true, system.currentUser);
                }
            }
            system.showPosts(system.subforoActivo);

            system.LOGGER.info("Vamos a comprobar como se puede modificar el voto");
            for (EntradaGenerica entry : system.subforoActivo.getPosts()) {
                if (entry.getTitle().equalsIgnoreCase("prueba")) {
                    entry.vote(false, system.currentUser);
                }
            }
            system.showPosts(system.subforoActivo);
            system.LOGGER.info("Vamos a subscribirnos a un subforo");
            system.currentUser.subscribeForum(system.chooseSubforum("Preguntas practica"));
            system.showSubforumSubscribed();
            system.logout();
            system.LOGGER.info("Vamos a hacer que un profesor cree una entrada en el subforo al que se ha suscrito el usuario, para comprobar que funcionan las notificaciones");
            system.login("j.perez@urjc.es", "12345");
            system.subforoActivo = system.chooseSubforum("Preguntas practica");
            EntradaGenerica entrada = system.createEntry("Dudas Practica 2", "Aqui os resolvere las dudas de la practica 2 que os he explicado en clase");
            system.subforoActivo.addInput(entrada);
            system.LOGGER.info("Entrada creada");
            system.logout();//logout profesor

            system.login("juan@admin.urjc.es", "12345"); //Login as admin
            if (system.currentUser instanceof Administrador) {
                system.LOGGER.info("Vamos a verificar las entradas pendientes en el subforo \"Preguntas Practica\""); //Check the posts as admin before set the as available
                system.subforoActivo = system.chooseSubforum("Preguntas practica");
                for (EntradaGenerica entry : system.subforoActivo.getPostUnverified()) {
                    ((Administrador) system.currentUser).verify(entry, true);
                }
                ((Administrador) system.currentUser).updatePosts(system.subforoActivo);


                system.LOGGER.fine("Entradas verificadas");
                system.LOGGER.info("Como la entrada de un alumno no ha sido adecuada, vamos a proceder a penalizarle.");
                ((Administrador) system.currentUser).penalizarUsuario(system.chooseAlumno("b.castro.2018@alumnos.urjc.es"), "No cumple los requisitos");

            }
            system.logout();
        } else {
            system.LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        system.LOGGER.info("Vamos a avanzar 3 dias para ver si nos podemos loguear despues de la penalizacion");
        system.fechaActual.add(Calendar.DAY_OF_MONTH, 3);
        system.login("b.castro.2018@alumnos.urjc.es", "12345");
        system.logout();
        system.save(system);
    }
}
