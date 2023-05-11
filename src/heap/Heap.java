package heap;

public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {
    protected T[] heap;
    protected int position = -1;

    public Heap() {
        heap = (T[]) new Comparable[2];
    }
}
