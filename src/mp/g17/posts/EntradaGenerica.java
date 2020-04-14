package mp.g17.posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mp.g17.users.Usuario;

public abstract class EntradaGenerica {
    
    private Usuario creador;
    private int points;
    private String title;
    private String text;
    private boolean verified = false;
    private List<Comentario> commentList;
    private Map<Usuario, Boolean> usuariosVotos = new HashMap<>();
    private int puntuacion;

    public int getPoints() {
        return points;
    }

    public List<Comentario> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comentario> commentList) {
        this.commentList = commentList;
    }

    public void verify(boolean resultado) {
        setVerified(resultado);
    }

    public boolean comment(Comentario texto) {
        getCommentList().add(texto);
        return true;
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




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
