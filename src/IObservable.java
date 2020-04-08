import java.util.List;

public interface IObservable<E> {

    List<IObserver<E>> getObservers();

    default void notifyObservers(E event) {
        getObservers().forEach(ob -> ob.update(event));
    }

    default boolean addObserver(IObserver<E> observer) {
        return getObservers().add(observer);
    }

    default boolean detachObserver(IObserver<E> observer) {
        return getObservers().remove(observer);
    }
}
