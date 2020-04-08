package posts;

import users.Usuario;

class Comentario{
    
private String texto;
private int puntuacion;

    public void comentar (String texto){
        this.texto = texto;
    }
    public boolean votar (int valor, Usuario usuarioComent, Usuario usuarioVoto){
        if(usuarioVoto != usuarioComent){
            puntuacion = puntuacion + valor;
            return true;
        }else
            return false;
    }


}
