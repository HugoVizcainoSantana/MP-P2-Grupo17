package mp.g17;

import mp.g17.events.EventoEntradaCreada;
import mp.g17.events.IObservable;
import mp.g17.events.IObserver;
import mp.g17.posts.Entrada;
import mp.g17.posts.EntradaGenerica;
import mp.g17.posts.comparer.ASortingStrategy;
import mp.g17.posts.comparer.SortByPointsStrategy;
import mp.g17.posts.comparer.SortType;
import mp.g17.users.Profesor;
import mp.g17.users.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Subforo implements IObservable<EventoEntradaCreada>, Serializable {
    public static final ASortingStrategy DEFAULT_SORT = new SortByPointsStrategy(SortType.ASCENDING);
    private Profesor createdBy;
    private String name;
    private List<IObserver<EventoEntradaCreada>> usersForo;
    private List<Entrada> posts;
    private List<Entrada> postUnverified; //List of post not verified yet
    private ASortingStrategy sortingStrategy;

    public Subforo(Profesor createdBy, String name) { //Constructor of a new subforum
        this.name = name;
        this.createdBy = createdBy;
        this.posts = new ArrayList<>();
        this.usersForo = new ArrayList<>();
        this.postUnverified = new ArrayList<>();
        sortingStrategy = DEFAULT_SORT;
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

    public void addNewEntry(Entrada input) {
        postUnverified.add(input);
    }

    public void deleteUser(Usuario subs) {
        usersForo.remove(subs);
    }

    public void deleteInput(EntradaGenerica input) {
        posts.remove(input);
    }

    public List<Entrada> getPostUnverified() { //This method returns the posts that have not been verfied
        return postUnverified;
    }

    @Override
    public List<IObserver<EventoEntradaCreada>> getObservers() { //This method returns the users subscribed in the subforum
        return usersForo;
    }

    public List<Entrada> getPosts() {
        posts = sortingStrategy.sort(this.posts);
        return posts;
    }

    public List<Entrada> getPosts(ASortingStrategy sortingStrategy) { //This method returns the list of posts sorted by a strategy sorting
        this.sortingStrategy = sortingStrategy;
        posts = sortingStrategy.sort(this.posts);
        return getPosts();
    }

    public void setSortingStrategy(ASortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setVerifiedInVisiblePosts() { //This method add to the verfied posts to visible post list
        for (Entrada entrada : postUnverified) {
            if (entrada.isVerified()) {
                posts.add(entrada);
                notifyObservers(new EventoEntradaCreada(this, entrada));
            }
        }
        for (EntradaGenerica post : posts) {
            postUnverified.remove(post);
        }
    }

    public Entrada getPostByTitle(String title) {
        for (Entrada post : this.posts) {
            if (post.getTitle().equalsIgnoreCase(title))
                return post;
        }
        return null;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Subforo.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}

