package mp.g17;

import mp.g17.events.EventoEntradaCreada;
import mp.g17.events.IObservable;
import mp.g17.events.IObserver;
import mp.g17.posts.EntradaGenerica;
import mp.g17.users.Usuario;

import java.util.List;

public class Subforo implements IObservable<EventoEntradaCreada> {
    private String name;
    private List<IObserver<EventoEntradaCreada>> usersForo;
    private List<EntradaGenerica> posts;

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public void addUser(Usuario subs) {
        usersForo.add(subs);
    }

    public void addInput(EntradaGenerica input) {
        posts.add(input);
        notifyObservers(new EventoEntradaCreada(this, input));
    }

    public void deleteUser(Usuario subs) {
        usersForo.remove(subs);
    }

    public void deleteInput(EntradaGenerica input) {
        posts.remove(input);
    }

    @Override
    public List<IObserver<EventoEntradaCreada>> getObservers() {
        return usersForo;
    }

    public List<EntradaGenerica> getPosts() {
        return posts;
    }
}

