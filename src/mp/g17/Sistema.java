package mp.g17;

import mp.g17.users.Alumno;
import mp.g17.users.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private static List<Usuario> usuariosRegistrados = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Hola Mundo!");
        Usuario alumno1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hvizcaino@alumnos.urjc.es", "12345");
        System.out.println("alumno1 = " + alumno1);
    }


    public static boolean login(){
        return true;
    }
}
