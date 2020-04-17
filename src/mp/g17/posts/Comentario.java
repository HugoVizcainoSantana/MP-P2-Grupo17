package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.HashMap;
import java.util.Map;

class Comentario implements IVotable {

    private Usuario createdBy;
    private String text;
    private int points;
    private Map<Usuario, Boolean> usersVotes;

    public Comentario(Usuario createdBy, String text) {
        this.createdBy = createdBy;
        this.text = text;
        this.points = 0;
        this.usersVotes = new HashMap<>();
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
}



