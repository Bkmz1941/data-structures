package heap;

public interface IHeap<T extends Comparable> {
    IHeap<T> insert(T data);
    T getRoot();

    void sort();
}
