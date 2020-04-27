package mp.g17;

import mp.g17.events.EventoEntradaCreada;
import mp.g17.events.IObservable;
import mp.g17.events.IObserver;
import mp.g17.posts.EntradaGenerica;
import mp.g17.posts.comparer.ASortingStrategy;
import mp.g17.users.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Subforo implements IObservable<EventoEntradaCreada> {
    private String name;
    private List<IObserver<EventoEntradaCreada>> usersForo;
    private List<EntradaGenerica> posts;
    private List<EntradaGenerica> postUnverified;
    private ASortingStrategy sortingStrategy;

    public Subforo(String name) {
        this.name = name;
        this.posts= new ArrayList<>();
        this.usersForo= new ArrayList();
        this.postUnverified= new ArrayList<>();


    }

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
            postUnverified.add(input);
    }

    public void deleteUser(Usuario subs) {
        usersForo.remove(subs);
    }

    public void deleteInput(EntradaGenerica input) {
        posts.remove(input);
    }
    public List<EntradaGenerica> getPostUnverified(){
        return postUnverified;
    }
    @Override
    public List<IObserver<EventoEntradaCreada>> getObservers() {
        return usersForo;
    }

    public List<EntradaGenerica> getPosts() {
        return posts;
    }

    public List<EntradaGenerica> getPosts(ASortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
        posts= sortingStrategy.sort(this.posts);
        return getPosts();
    }

    public void setSortingStrategy(ASortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
    public void setVerifiedInVisiblePosts(){
        for(EntradaGenerica entrada: postUnverified){
            if (entrada.isVerified()){
                posts.add(entrada);
            }
        }
    }
}

