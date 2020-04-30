package mp.g17.demostrator;

import mp.g17.Subforo;
import mp.g17.posts.*;
import mp.g17.users.Administrador;
import mp.g17.users.Profesor;
import mp.g17.utils.LoggerUtils;

import java.util.logging.Logger;

public class DemostradorCargaDatos {
    private static Logger LOGGER = LoggerUtils.getLogger();

    static {
        LOGGER.setUseParentHandlers(false);
    }

    public static void main(String[] args) {
        LOGGER.info("Iniciando demostrador");
        Sistema system = Sistema.getINSTANCE();
        if (system.registerUser("Juan", "Perez", "12345", "j.perez@urjc.es", "jPerez")) { //adds a new user (professor)
            LOGGER.info("Profesor Juan Registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }
        if (system.registerUser("Juan carlos", "Galdos", "12345", "jc.galdos@urjc.es", "jcGaldos")) {
            LOGGER.info("Profesor Juan carlos Registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }
        if (system.registerAdministrador("juan@admin.urjc.es", "12345")) { //Makes the professor a new admin
            LOGGER.info("Administrador registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }
        if (system.registerAdministrador("pedro@admin.urjc.es", "12345")) {
            LOGGER.info("Administrador registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }

        if (system.registerUser("Pedro", "Jimenez", "12345", "pjimenez@alumnos.urjc.es", "pedrito")) { //Adds a new alumn
            LOGGER.info("Alumno Pedro Registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }

        if (system.registerUser("Borja", "Castro", "12345", "b.castro.2018@alumnos.urjc.es", "bcastro")) {
            LOGGER.info("Alumno Borja Registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }

        if (system.registerUser("Hugo", "Vizcaino", "hugo1234", "hs.vizcaino@alumnos.urjc.es", "hVizcaino")) {
            LOGGER.info("Alumno registrado correctamente");
        }
        if (system.registerUser("Alberto", "Jimenez", "12345", "ajimenez@alumnos.urjc.es", "aJimenez")) {
            LOGGER.info("Alumno registrado");
        } else {
            LOGGER.info("Error registrando un usuario");
        }

        system.login("j.perez@urjc.es", "12345");
        LOGGER.info("Creacion de subforos1"); // Creates a new subforum
        if (system.getCurrentUser() instanceof Profesor) {
            system.addSubforum(system.createSubforo("Dudas"));
            system.addSubforum(system.createSubforo("Novedades"));
        }
        system.logout();
        system.login("jc.galdos@urjc.es", "12345");
        LOGGER.info("Creacion de subforos 2");
        if (system.getCurrentUser() instanceof Profesor) {
            system.addSubforum(system.createSubforo("Practicas"));
            system.addSubforum(system.createSubforo("Examenes"));
        }
        system.logout();
        LOGGER.info("Mostrando los subforos sin ninguna sesion activa");
        system.showSubforumsAvaliables(); // Show the subforums
        system.login("j.perez@urjc.es", "12345");
        if (system.getCurrentUser() instanceof Profesor) {
            LOGGER.info("Vamos a crear una entrada con encuesta, otra con un ejercicio y un texto plano");
            Encuesta encuesta = system.createSurvey("Encuesta de Final de curso");
            Ejercicio ejercicio = system.createExercise("Raiz cuadrada de 49", "7");
            TextoPlano texto = system.createTextDescription("Por favor se necesita todo este antes del dia 25 de mayo");
            encuesta.addQuestion(new PreguntaEncuesta("¿Cree usted que va a aprobar?"));
            encuesta.addQuestion(new PreguntaEncuesta("¿Cree que ha aprendido suficiente?"));

            Subforo subforoExamenes = system.chooseSubforum("Examenes");
            if (subforoExamenes != null) {
                Entrada entrada = new Entrada(system.getCurrentUser(), "Encuesta final");
                entrada.add(encuesta);
                subforoExamenes.addNewEntry(entrada);
            }

            Subforo subforoPracticas = system.chooseSubforum("Practicas");
            if (subforoPracticas != null) {
                Entrada entrada = new Entrada(system.getCurrentUser(), "Practica menor");
                entrada.add(ejercicio);
                entrada.add(texto);
                subforoPracticas.addNewEntry(entrada);
            }
        }
        system.logout();

        system.login("juan@admin.urjc.es", "12345"); //Login as admin
        if (system.getCurrentUser() instanceof Administrador) {
            LOGGER.info("Vamos a verificar las entradas pendientes en los subforos"); //Check the posts as admin before set the as available
            system.setActiveSubforum(system.chooseSubforum("Examenes"));
            Subforo subforoActivo = system.getActiveSubforum();
            if (system.verifyAllEntries(subforoActivo)) {
                LOGGER.fine("Entradas verificadas del subforo " + subforoActivo.getName());
            }
            system.setActiveSubforum(system.chooseSubforum("Practicas"));
            subforoActivo = system.getActiveSubforum();
            if (system.verifyAllEntries(subforoActivo)) {
                LOGGER.fine("Entradas verificadas del subforo " + subforoActivo.getName());
            }


        }

        system.logout();
        system.showPosts(system.getActiveSubforum());

        system.showInformationPost((system.chooseEntrada("Practica menor")));
    }
}


