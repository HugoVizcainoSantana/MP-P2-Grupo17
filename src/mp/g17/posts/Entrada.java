package mp.g17.posts;

import mp.g17.users.Usuario;

public class Entrada extends EntradaGenerica {
    private int puntuacion;

    @Override
    public void verify(boolean resultado) {
        setVerified(resultado);
    }

    @Override
    public boolean comment(Comentario texto) {
        getCommentList().add(texto);
        return true;
    }

    @Override
    public boolean vote(int valor, Usuario usuarioComent, Usuario usuarioVoto) {
        if (usuarioVoto.getEmail().equals(usuarioComent.getEmail())) {
            return false;
        } else {
            puntuacion = puntuacion + valor;
            return true;
        }
        }

}
