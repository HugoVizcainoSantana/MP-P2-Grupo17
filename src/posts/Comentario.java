package posts;

import users.Usuario;

class Comentario{
    
private String texto;
private int puntuacion;

    public void comentar (String texto){
        this.texto = texto;
    }
    public boolean votar (int valor, Usuario usuarioComent, Usuario usuarioVoto){
        if(usuarioVoto.getnombre().equals(usuarioComent.getnombre())){
            return false;
        }else
            puntuacion = puntuacion + valor;
            return true;
            
    }


}
