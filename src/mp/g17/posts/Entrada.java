package mp.g17.posts;

import mp.g17.users.Usuario;

public class Entrada extends EntradaGenerica {
    private Ejercicio ejercicio;
    private Encuesta encuesta;

    public Entrada(Usuario createdBy, String title, String text) { //Constructor of a new post
        super(createdBy, title, text);
    }
/*
    public Entrada( Usuario cretedBy, String tittle,String text, Encuesta encuesta ){
        super(cretedBy,tittle,text);
        this.encuesta=encuesta;
    }
    public Entrada( Usuario cretedBy, String tittle,String text, Ejercicio ejercicio ){
        super(cretedBy,tittle,text);
        this.ejercicio=ejercicio;
    }
    public Entrada( Usuario cretedBy, String tittle,String text, Ejercicio ejercicio,Encuesta encuesta ){
        super(cretedBy,tittle,text);
        this.ejercicio=ejercicio;
        this.encuesta=encuesta;
    }
*/
}
