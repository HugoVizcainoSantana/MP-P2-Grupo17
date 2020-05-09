package mp.g17.demostrator;

import mp.g17.Subforo;
import mp.g17.posts.*;
import mp.g17.posts.comparer.SortByDateStrategy;
import mp.g17.posts.comparer.SortByPointsStrategy;
import mp.g17.posts.comparer.SortType;
import mp.g17.users.Administrador;
import mp.g17.utils.LoggerUtils;

import java.util.Calendar;
import java.util.Random;
import java.util.logging.Logger;

public class DemostradorCargaDatos {
    private static Logger LOGGER = LoggerUtils.getLogger();

    public static void main(String[] args) {
        LOGGER.info("Iniciando demostrador que carga datos y demuestra la funcionalidad");
        Sistema system = Sistema.load();

        system.showRegisteredUsers(); //Show the users registered in the system

        LOGGER.info("Vamos a mostrar los post creados en los subforos. Por defecto esta ordenado con la estrategia"); // Show the posts subforum
        for (Subforo subforum : system.getSubforums()) {
            system.showPosts(subforum);
        }
        LOGGER.info("Se han ordenado los posts en el subforo con la estrategia 'OrdenarPorPuntuacion' con tipo Ordenacion Descendente. A partir de ahora, siempre se devolveran ordenados asi.");
        for (Subforo subforum : system.getSubforums()) {
            subforum.setSortingStrategy(new SortByPointsStrategy(SortType.DESCENDING)); //Sort the subforums by punctuation
            system.showPosts(subforum);
        }
        LOGGER.info("Iniciamos sesion con un alumno, y elegimos el subforo para hacer la entrada");
        if (system.login("pjimenez@alumnos.urjc.es", "12345")) {

            //Makes a new post for the subforum "preguntas practica"
            system.setActiveSubforum(system.chooseSubforum("Practicas"));
            Entrada entrada = new Entrada(system.getCurrentUser(), "prueba");
            TextoPlano textoPlano = new TextoPlano(system.getCurrentUser(), "Post de prueba");
            entrada.add(textoPlano);


            if (system.getActiveSubforum() != null) {
                system.getActiveSubforum().addNewEntry(entrada);// Add the post to the subforum
                LOGGER.fine("Post " + entrada.getTitle() + " creada");
                LOGGER.info("Esperando validacion por el administrador");
            }

            LOGGER.info("Vamos a intentar hacer un una entrada en un subforo inexistente");
            system.setActiveSubforum(system.chooseSubforum("hello"));
            if (system.getActiveSubforum() != null) {
                system.getActiveSubforum().addNewEntry(entrada); // Add the post to a not existant subforum
                LOGGER.fine("Post " + entrada.getTitle() + " creada");
            } else {
                LOGGER.warning("El subforo solicitado no existe.");
            }

        }

        LOGGER.info("Vamos a mostrar los post creados en los subforos");
        for (Subforo subforum : system.getSubforums()) {
            system.showPosts(subforum);
        }

        system.logout();//logout as alumn

        if (system.login("juan@admin.urjc.es", "12345")) { //Login as admin
            if (system.getCurrentUser() instanceof Administrador) {
                LOGGER.info("Vamos a verificar las entradas pendientes en los subforos"); //Check the posts as admin before set the as available
                for (Subforo subforo : system.getSubforums()) {
                    for (Entrada entry : subforo.getPostUnverified()) {
                        ((Administrador) system.getCurrentUser()).verify(entry, true);
                    }
                    ((Administrador) system.getCurrentUser()).updatePosts(subforo);
                }

                LOGGER.fine("Entradas verificadas");
                LOGGER.info("Como la entrada de un alumno no ha sido adecuada, vamos a proceder a penalizarle.");
                ((Administrador) system.getCurrentUser()).penalizarUsuario(system.chooseAlumno("b.castro.2018@alumnos.urjc.es"), "No cumple los requisitos");

            }
        }
        system.logout();

        LOGGER.info("Vamos a mostrar los post creados y verificados en los subforos..."); // Show the verified posts
        for (Subforo subforum : system.getSubforums()) {
            system.showPosts(subforum);
        }

        LOGGER.info("Vamos a mostrar los post ordenados por fecha de creacion descendente."); // Show the verified posts
        for (Subforo subforum : system.getSubforums()) {
            subforum.setSortingStrategy(new SortByDateStrategy(SortType.DESCENDING));
            system.showPosts(subforum);
        }
        //Login with a stricker user
        if (system.login("b.castro.2018@alumnos.urjc.es", "12345")) {
            system.setActiveSubforum(system.chooseSubforum("Preguntas practica"));
            LOGGER.info("Vamos a votar el post llamado prueba");

            Entrada entry = system.getActiveSubforum().getPostByTitle("prueba");
            entry.vote(true, system.getCurrentUser());
        } else {
            LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        system.logout();

        if (system.login("hs.vizcaino@alumnos.urjc.es", "hugo1234")) {
            system.setActiveSubforum(system.chooseSubforum("Practicas"));
            LOGGER.info("Vamos a votar el post llamado prueba");

            system.showPosts(system.getActiveSubforum());
            system.getActiveSubforum().getPostByTitle("prueba").vote(true, system.getCurrentUser());
            LOGGER.info("Ahora el post 'prueba' debe tener un voto");
            system.showPosts(system.getActiveSubforum());

            LOGGER.info("Vamos a intentar duplicar el voto");
            system.getActiveSubforum().getPostByTitle("prueba").vote(true, system.getCurrentUser());
            system.showPosts(system.getActiveSubforum());
            LOGGER.info("Los votos no se han modificado");

            LOGGER.info("Vamos a comprobar como se puede modificar el voto. En este caso tendria que quedarse con -1");
            system.getActiveSubforum().getPostByTitle("prueba").vote(false, system.getCurrentUser());
            system.showPosts(system.getActiveSubforum());

            LOGGER.info("Se van a ordenar ahora los posts por fecha descendente.");
            for (Subforo subforum : system.getSubforums()) {
                subforum.setSortingStrategy(new SortByDateStrategy(SortType.DESCENDING)); //Sort the subforums by punctuation
                system.showPosts(subforum);
            }
            LOGGER.info("Vamos a subscribirnos a un subforo");
            system.getCurrentUser().subscribeForum(system.chooseSubforum("Preguntas practica"));
            system.showSubforumSubscribed();
        }

            system.logout();
            LOGGER.info("Vamos a hacer que un profesor cree una entrada en el subforo al que se ha suscrito el usuario, para comprobar que funcionan las notificaciones");
            if(system.login("j.perez@urjc.es", "12345")) {
                system.setActiveSubforum(system.chooseSubforum("Preguntas practica"));
                Entrada entrada = new Entrada(system.getCurrentUser(), "Dudas Practica 2");
                TextoPlano textoPlano = new TextoPlano(system.getCurrentUser(), "Aqui os resolvere las dudas de la practica 2 que os he explicado en clase");
                entrada.add(textoPlano);
                system.getActiveSubforum().addNewEntry(entrada);
                LOGGER.info("Entrada creada");
                system.logout();//logout profesor

                system.login("juan@admin.urjc.es", "12345"); //Login as admin
                if (system.getCurrentUser() instanceof Administrador) {
                    LOGGER.info("Vamos a verificar las entradas pendientes en el subforo \"Preguntas Practica\""); //Check the posts as admin before set the as available
                    system.setActiveSubforum(system.chooseSubforum("Preguntas practica"));
                    for (Entrada entry : system.getActiveSubforum().getPostUnverified()) {
                        ((Administrador) system.getCurrentUser()).verify(entry, true);
                    }
                    ((Administrador) system.getCurrentUser()).updatePosts(system.getActiveSubforum());

                    LOGGER.fine("Entradas verificadas");
                    LOGGER.info("Como la entrada de un alumno no ha sido adecuada, vamos a proceder a penalizarle.");
                    ((Administrador) system.getCurrentUser()).penalizarUsuario(system.chooseAlumno("b.castro.2018@alumnos.urjc.es"), "No cumple los requisitos");

                }
            } else {
                LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
            }
            system.logout();


        LOGGER.info("Vamos a comentar el post Dudas Practica 2");
        if(system.login("hs.vizcaino@alumnos.urjc.es", "hugo1234")) {
            Subforo foro = system.chooseSubforum("Preguntas practica");
            Entrada entryada = foro.getPostByTitle("Dudas Practica 2");
            Comentario coment = new Comentario(system.getCurrentUser(), "Ejercicio completado");
            entryada.comment(coment);
            LOGGER.info("Vamos a votar el comentario");
            entryada.vote(true, system.getCurrentUser());
            LOGGER.info("El comentario " + entryada.getTitle() + " tiene un total de: " + entryada.getPoints() + "puntos");
        }else{
            LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        system.logout();
        LOGGER.info("Vamos a avanzar 3 dias para ver si nos podemos loguear despues de la penalizacion");
        system.getCurrentDate().add(Calendar.DAY_OF_MONTH, 3);
        if(system.login("b.castro.2018@alumnos.urjc.es", "12345")) {
            LOGGER.info("Vamos a votar en una encuesta");
            Subforo subforoExamenes = system.chooseSubforum("Examenes");
            Entrada entrada = subforoExamenes.getPostByTitle("Encuesta final");
            for (EntradaGenerica entradaEntrada : entrada.getEntradas()) {
                // Se hace el casting directo por simplificar el codigo, pero habria que verificarlo con un instanceof
                Encuesta encuesta = (Encuesta) entradaEntrada;
                for (PreguntaEncuesta poll : encuesta.getPolls()) {
                    LOGGER.info("Primero vamos a intentar responder algo incorrecto");
                    if (poll.answer(system.getCurrentUser(), "Random")) {
                        LOGGER.info("Respuesta registrada");
                    } else {
                        LOGGER.warning("La respuesta introducida no es valida. Elija una de las siguientes: '" + String.join(", ", poll.getAnswers()) + "'");
                    }

                    if (poll.answer(system.getCurrentUser(), poll.getAnswers().get(new Random().nextInt(poll.getAnswers().size())))) {
                        LOGGER.info("Respuesta registrada");
                    } else {
                        LOGGER.warning("La respuesta introducida no es valida. Elija una de las siguientes: '" + String.join(", ", poll.getAnswers()) + "'");
                    }
                }
            }
        }else{
            LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        system.logout();

        LOGGER.info("Vamos a hacer que un profesor vea los resultados de las encuestas");

        if(system.login("j.perez@urjc.es", "12345")) {
            Subforo subforumExamenes = system.chooseSubforum("Examenes");
            Entrada encuesta_final = subforumExamenes.getPostByTitle("Encuesta final");
            for (EntradaGenerica entradaEntrada : encuesta_final.getEntradas()) {
                // Se hace el casting directo por simplificar el codigo, pero habria que verificarlo con un instanceof
                Encuesta encuesta = (Encuesta) entradaEntrada;
                LOGGER.info("Viendo las respuestas de forma anonima");
                system.showSurveyResult(encuesta);
                LOGGER.info("Viendo las respuestas con el nombre de usuario");
                system.showSurveyResult(encuesta, true);
            }
        }else{
            LOGGER.warning("No puedes hacer estas funcionalidades sin estar logueado");
        }
        system.logout();//logout profesor

    }
}
