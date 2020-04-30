package mp.g17.posts;

import mp.g17.users.Usuario;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntradaGenerica implements IVotable, IDatable, Serializable {

    private Usuario createdBy;
    private int points;
    private String title;
    private String content;

    private boolean verified;
    private List<Comentario> commentList;
    private Map<Usuario, Boolean> usersVotes;
    private Instant creationDate;

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public EntradaGenerica(Usuario createdBy, String title) {
        this(createdBy, title, null);
    }

    public EntradaGenerica(Usuario createdBy, String title, String content) {
        this.createdBy = createdBy;
        this.points = 0;
        this.title = title;
        this.content = content;
        this.commentList = new ArrayList<>();
        this.usersVotes = new HashMap<>();
        creationDate = Instant.now();
    }

    public List<Comentario> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comentario> commentList) {
        this.commentList = commentList;
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

    public Instant getCreationDate() {
        return creationDate;
    }

    public Usuario getCreatedBy() {
        return createdBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
