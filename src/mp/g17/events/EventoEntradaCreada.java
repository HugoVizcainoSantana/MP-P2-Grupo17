package mp.g17.events;

import mp.g17.Subforo;
import mp.g17.posts.EntradaGenerica;

import java.time.Instant;

public class EventoEntradaCreada {
    public final Subforo subforo;
    public final EntradaGenerica post;
    public final Instant instant;

    public EventoEntradaCreada(Subforo subforo, EntradaGenerica post) {
        this.subforo = subforo;
        this.post = post;
        this.instant = Instant.now();
    }

}
