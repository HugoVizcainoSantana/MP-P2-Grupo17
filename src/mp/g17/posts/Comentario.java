package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.HashMap;
import java.util.Map;

class Comentario {

    private Usuario creador;
    private String texto;
    private int puntuacion;
    private Map<Usuario, Boolean> usuariosVotos = new HashMap<>();

    public void comentar(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void votar(boolean valor, Usuario usuarioVoto) {
            if (usuariosVotos.containsKey(usuarioVoto)) {
                boolean votoAnterior = usuariosVotos.get(usuarioVoto);
                if (votoAnterior) {
                    puntuacion--;
                    usuariosVotos.put(usuarioVoto, valor);
                } else {
                    puntuacion++;
                    usuariosVotos.put(usuarioVoto, valor);
                }

            } else {
                usuariosVotos.put(usuarioVoto, valor);
            }
            if(valor){
                puntuacion++;
            }else{
                puntuacion--;
            }

    }
}



