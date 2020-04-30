package mp.g17.posts;

import mp.g17.users.Usuario;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Comentario implements IVotable, IDatable, Serializable {

    private Usuario createdBy;
    private String text;
    private int points;
    private Map<Usuario, Boolean> usersVotes; //This match the vote with the user
    private Instant creationDate;

    public Comentario(Usuario createdBy, String text) { //Constructor comment
        this.createdBy = createdBy;
        this.text = text;
        this.points = 0;
        this.usersVotes = new HashMap<>();
        creationDate = Instant.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public void setCreatedBy(Usuario createdBy) {
        this.createdBy = createdBy;
    }
}



