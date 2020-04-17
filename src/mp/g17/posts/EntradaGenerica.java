package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntradaGenerica implements IVotable {

    private Usuario createdBy;
    private int points;
    private String title;
    private String text;
    private boolean verified;
    private List<Comentario> commentList;
    private Map<Usuario, Boolean> usersVotes;

    public EntradaGenerica(Usuario createdBy, String title, String text) {
        this.createdBy = createdBy;
        this.points = 0;
        this.title = title;
        this.text = text;
        this.verified = false;
        this.commentList = new ArrayList<>();
        this.usersVotes = new HashMap<>();
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

    @Override
    public Map<Usuario, Boolean> getUsersVotes() {
        return usersVotes;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }
}
