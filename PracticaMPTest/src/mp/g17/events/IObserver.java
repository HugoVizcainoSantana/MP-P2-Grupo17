package mp.g17.events;

public interface IObserver<E> {//Oberver pattern
    void update(E event);
}
