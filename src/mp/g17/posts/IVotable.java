package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.Map;

public interface IVotable {

    Map<Usuario, Boolean> getUsersVotes();

    int getPoints();

    void setPoints(int points);

    default void decrementVotes() {
        setPoints(getPoints() - 1);
    }

    default void incrementVotes() {
        setPoints(getPoints() + 1);
    }

    default void vote(Boolean valor, Usuario userVoting) {
        Map<Usuario, Boolean> usersVotes = getUsersVotes();
        if (usersVotes.containsKey(userVoting)) {
            boolean votoAnterior = usersVotes.remove(userVoting);
            if (votoAnterior) {
                decrementVotes();
            } else {
                incrementVotes();
            }
        }
        // If the new vote its null, we don't add the vote back, it simply gets removed
        if (valor != null) {
            if (valor) {
                incrementVotes();
            } else {
                decrementVotes();
            }
            usersVotes.put(userVoting, valor);
        }
    }
}
