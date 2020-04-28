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
        if (usersVotes.containsKey(userVoting)) { //This check if the user that is voting has voted before
            boolean votoAnterior = usersVotes.remove(userVoting); //If is the case the vote is removed (it doesn't count)
            if (votoAnterior) { 
                decrementVotes();
            } else {
                incrementVotes();
            }
        }
        if (valor != null) {  // If the new vote is null, we don't add the vote back, it simply gets removed
            if (valor) {
                incrementVotes();
            } else {
                decrementVotes();
            }
            usersVotes.put(userVoting, valor);
        }
    }
}
