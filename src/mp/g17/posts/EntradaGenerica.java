package mp.g17.posts;

import java.util.List;
import mp.g17.users.Usuario;

public abstract class EntradaGenerica {

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

    public abstract void verify(boolean resultado);

    public abstract boolean comment(Comentario texto);

    public abstract boolean vote(int valor, Usuario usuarioComent, Usuario usuarioVoto);


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
