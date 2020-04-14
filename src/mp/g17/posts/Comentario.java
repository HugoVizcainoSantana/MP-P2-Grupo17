package mp.g17.posts;

import mp.g17.users.Usuario;

class Comentario {

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

    public boolean votar(int valor, Usuario usuarioComent, Usuario usuarioVoto) {
        if (usuarioVoto.getEmail().equals(usuarioComent.getEmail())) {
            return false;
        } else {
            puntuacion = puntuacion + valor;
            return true;
        }
    }


}
