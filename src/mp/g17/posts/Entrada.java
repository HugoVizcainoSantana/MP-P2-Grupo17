package mp.g17.posts;

import mp.g17.users.Usuario;

public class Entrada extends EntradaGenerica {

    public Entrada(Usuario createdBy, String title, String text) { //Constructor of a new post
        super(createdBy, title, text);
    }
}
