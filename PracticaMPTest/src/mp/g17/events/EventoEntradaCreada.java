package mp.g17.events;

import mp.g17.Subforo;
import mp.g17.posts.EntradaGenerica;

import java.io.Serializable;
import java.time.Instant;
import java.util.StringJoiner;

public class EventoEntradaCreada implements Serializable {
    public final Subforo subforo;
    public final EntradaGenerica post;
    public final Instant instant;

    public EventoEntradaCreada(Subforo subforo, EntradaGenerica post) { //Creates a new event when a new post is created
        this.subforo = subforo;
        this.post = post;
        this.instant = Instant.now();
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", EventoEntradaCreada.class.getSimpleName() + "[", "]")
                .add("subforo=" + subforo)
                .add("post title=" + post.getTitle())
                .add("instant=" + instant)
                .toString();
    }
}
