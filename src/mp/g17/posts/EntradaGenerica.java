package mp.g17.posts;

import java.util.List;
import mp.g17.users.Usuario;

public abstract class EntradaGenerica {
    
    private Usuario creador;
    private int points;
    private String title;
    private String text;
    private boolean verified = false;
    private List<Comentario> commentList;

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

    public boolean vote(int valor, Usuario usuarioVoto) {
        if (usuarioVoto.getEmail().equals(creador.getEmail())) {
            return false;
        } else {
            points = points + valor;
            return true; 
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
