package mp.g17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mp.g17.users.Alumno;
import mp.g17.users.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import mp.g17.users.Profesor;

public class Sistema {

    private static Map<String, Usuario> users = new HashMap<>();
    private static Usuario currentUser = null;
    private static List<Usuario> registeredUsers = new ArrayList<>();
    private static List<Subforo> subforums = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Inicializando sistema!");
        Usuario alumno1 = new Alumno("Hugo", "Vizcaino", "hvizcaino", "hvizcaino@alumnos.urjc.es", "12345");
        System.out.println("Creado alumno1 = " + alumno1);
        users.put(alumno1.getEmail(), alumno1);
    }


    public static boolean login(String email, String password) {
        Usuario userByEmail = users.get(email);
        if (userByEmail != null && userByEmail.getPassword().equals(password)) {
            currentUser = userByEmail;
            return true;
        }
        return false;
    }

    public static boolean logout() {
        currentUser = null;
        return true;
    }
    
    public static boolean login(){
        return true;
    }
    public static boolean registerUser(String name, String surname, String password, String mail, String alias){
        Usuario user = null;
            if(mail.contains("@alumnos.urjc.es")){
                user = new Alumno(name, surname, alias, mail, password);
                registeredUsers.add(user);
                return true;
            }else if(mail.contains("@urjc.es")){
                user = new Profesor(name, surname, alias, mail, password);
                registeredUsers.add(user);
                return true;
            }else{
                System.out.println("No es un email valido");
                return false;
            }
            
            
    }
    
    public static boolean createSubforum(String name){
        Subforo forum = null;
        forum.setName(name);
        subforums.add(forum);
        return true;
    }
    
    private static boolean save(Sistema system){
        try {
           FileOutputStream file = new FileOutputStream("forum.obj");
           ObjectOutputStream finalFile = new ObjectOutputStream(file);
           finalFile.writeObject(system);
           finalFile.close();
           file.close();
           return true;

        } catch (IOException e) {
           System.out.println(e.getMessage());
           return false;
        }
    }
    
    public static Sistema load(){
        Sistema system = null;
        try {
            FileInputStream file = new FileInputStream("forum.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            system = (Sistema) inputFile.readObject();
            
            inputFile.close();
            file.close();
        } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
        }
        return system;
    }
}
