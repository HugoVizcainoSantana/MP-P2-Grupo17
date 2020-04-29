package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.*;

public abstract class EntradaGenerica implements IVotable, IDatable {

    private Usuario createdBy;
    private int points;
    private String title;
    private String text;
    private boolean verified;
    private List<Comentario> commentList;
    private Map<Usuario, Boolean> usersVotes;
    private Date creationDate;

    public EntradaGenerica(Usuario createdBy, String title, String text) {
        this.createdBy = createdBy;
        this.points = 0;
        this.title = title;
        this.text = text;
        this.verified = false;
        this.commentList = new ArrayList<>();
        this.usersVotes = new HashMap<>();
        creationDate= new Date();
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

    public Date getCreationDate() {
        return creationDate;
    }

    public Usuario getCreatedBy() {
        return createdBy;
    }
}
