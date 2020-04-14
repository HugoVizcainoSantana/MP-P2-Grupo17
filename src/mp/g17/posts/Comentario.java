package mp.g17.posts;

import mp.g17.users.Usuario;

class Comentario {
    
    private Usuario creador;
    private String texto;
    private int puntuacion;

    public void comentar(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean votar(boolean valor, Usuario usuarioVoto) {
        if (usuarioVoto.getEmail().equals(creador.getEmail())) {
            return false;
        }
        if(valor = true){
            puntuacion = puntuacion++;
            return true;
        }else{
            puntuacion = puntuacion--;
            return true;
        }
    }


}
