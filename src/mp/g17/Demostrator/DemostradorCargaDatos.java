package mp.g17.Demostrator;

import mp.g17.posts.*;
import mp.g17.users.Administrador;
import mp.g17.users.Profesor;

import java.util.logging.Logger;

public class DemostradorCargaDatos {
    public static void main(String[] args) {
        Logger LOGGER= Sistema.getLOGGER();
        Sistema system= new Sistema();
        if (system.registerUser("Juan", "Perez", "12345", "j.perez@urjc.es", "jPerez")) { //adds a new user (professor)
            LOGGER.info("Profesor Juan Registrado");
        }
        if(system.registerUser("Juan carlos","Galdos","12345","jc.galdos@urjc.es","jcGaldos")){
            LOGGER.info("Profesor Juan calors Registrado");

        }
        if (system.registerAdministrador("juan@admin.urjc.es", "12345")) { //Makes the professor a new admin
            LOGGER.info("Administrador registrado");
        }
        if(system.registerAdministrador("pedro@admin.urjc.es","12345")){
            LOGGER.info("Administrador registrado");
        }

        if (system.registerUser("Pedro", "Jimenez", "12345", "pjimenez@alumnos.urjc.es", "pedrito")) { //Adds a new alumn
            LOGGER.info("Alumno Pedro Registrado");
        }

        if (system.registerUser("Borja", "Castro", "12345", "b.castro.2018@alumnos.urjc.es", "bcastro")) {
            LOGGER.info("Alumno Borja Registrado");
        }

        if (system.registerUser("Hugo", "Vizcaino", "hugo1234", system.CORREO_HUGO, "hVizcaino")) {
            LOGGER.info("Alumno registrado correctamente");
        }
        if(system.registerUser("Alberto","Jimenez","12345","ajimenez@alumnos.urjc.es","aJimenez")){
            LOGGER.info("Alumno registrado");
        }

        system.login("j.perez@urjc.es", "12345");
        LOGGER.info("Creacion de subforos"); // Creates a new subforum
        if (system.currentUser instanceof Profesor) {
            system.subforums.add(system.createSubforo("Dudas"));
            system.subforums.add(system.createSubforo("Novedades"));
        }
        system.logout();
        system.login("jc.galdos@urjc.es","12345");
        LOGGER.info("Creacion de subforos");
        if (system.currentUser instanceof Profesor) {
            system.subforums.add(system.createSubforo("Practicas"));
            system.subforums.add(system.createSubforo("Examenes"));
        }
        system.logout();
        system.showSubforumsAvaliables(); // Show the subforums
        system.login("j.perez@urjc.es", "12345");
        if (system.currentUser instanceof Profesor) {
            LOGGER.info("Vamos a crear una encuesta");
            Encuesta encuesta = system.createSurvey("Encuesta de Final de curso");
            Ejercicio ejercicio = system.createExercise("Raiz cuadrada de 49","7");
            TextoPlano texto = system.createTextDescription("Por favor se necesita todo este antes del dia 25 de mayo");
            encuesta.addQuestion(new PreguntaEncuesta("¿Cree usted que va a aprobar?"));
            encuesta.addQuestion(new PreguntaEncuesta("¿Cree que ha aprendido suficiente?"));
            if(system.chooseSubforum("Examenes")!=null) {
                Entrada entrada= new Entrada(system.currentUser,"Encuesta final");
                entrada.add(encuesta);
                system.chooseSubforum("Examenes").addInput(entrada);
            }
            if(system.chooseSubforum("Practicas")!=null){
                Entrada entrada= new Entrada(system.currentUser, "Practica menor");
                entrada.add(ejercicio);
                entrada.add(texto);
                system.chooseSubforum("Practicas").addInput(entrada);
            }
        }
        system.logout();

        system.login("juan@admin.urjc.es", "12345"); //Login as admin
        if (system.currentUser instanceof Administrador) {
            LOGGER.info("Vamos a verificar las entradas pendientes en los subforos"); //Check the posts as admin before set the as available
            system.subforoActivo = system.chooseSubforum("Examenes");
            if(system.verifyAllEntries(system.subforoActivo)){
                LOGGER.fine("Entradas verificadas del subforo "+system.subforoActivo.getName());
            }
            system.subforoActivo= system.chooseSubforum("Practicas");
            if(system.verifyAllEntries(system.subforoActivo)){
                LOGGER.fine("Entradas verificadas del subforo "+system.subforoActivo.getName());
            }


        }

        system.logout();
        system.showPosts(system.subforoActivo);

        system.showInformationPost((system.chooseEntrada("Practica menor")));




    }
    }


