package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.*;

public abstract class EntradaGenerica implements IVotable, IDatable {

    private Usuario createdBy;
    private int points;
    private String title;

    private boolean verified;
    private List<Comentario> commentList;
    private Map<Usuario, Boolean> usersVotes;
    private Date creationDate;

    public EntradaGenerica(Usuario createdBy, String title) {
        this.createdBy = createdBy;
        this.points = 0;
        this.title = title;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public Usuario getCreatedBy() {
        return createdBy;
    }
}
