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
    private List<EntradaGenerica> postUnverified; //List of post not verified yet
    private ASortingStrategy sortingStrategy;

    public Subforo(String name) { //Constructor of a new subforum
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
    public List<EntradaGenerica> getPostUnverified(){ //This method returns the posts that have not been verfied
        return postUnverified;
    }
    @Override
    public List<IObserver<EventoEntradaCreada>> getObservers() { //This method returns the users subscribed in the subforum
        return usersForo;
    }

    public List<EntradaGenerica> getPosts() {
        return posts;
    }

    public List<EntradaGenerica> getPosts(ASortingStrategy sortingStrategy) { //This method returns the list of posts sorted by a strategy sorting
        this.sortingStrategy = sortingStrategy;
        posts= sortingStrategy.sort(this.posts);
        return getPosts();
    }

    public void setSortingStrategy(ASortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
    public void setVerifiedInVisiblePosts(){ //This method add to the verfied posts to visible post list
        for(EntradaGenerica entrada: postUnverified){
            if (entrada.isVerified()){
                posts.add(entrada);
            }
        }
    }
}

