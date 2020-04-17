package mp.g17.posts;


import mp.g17.users.Usuario;

public class Ejercicio extends EntradaGenerica {

    private String solution;

    public Ejercicio(Usuario createdBy, String title, String text, String solution) {
        super(createdBy, title, text);
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
