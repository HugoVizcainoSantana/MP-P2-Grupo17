package mp.g17.posts;


import mp.g17.users.Profesor;
import mp.g17.users.Usuario;

import java.util.List;

public class Ejercicio extends EntradaGenerica {

    private String solution;

    public Ejercicio(Profesor createdBy, String title, String solution) { //Constructor exercise
        super(createdBy, title);
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }




}
