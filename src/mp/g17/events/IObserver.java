package mp.g17.events;

public interface IObserver<E> {
    void update(E event);
}
