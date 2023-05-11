package heap;

import java.util.Arrays;

public class MaximumHeap<T extends Comparable<T>> extends Heap<T> {
    @Override
    public IHeap<T> insert(T data) {
        if (this.isFull()) this.resize(2 * heap.length);

        heap[++position] = data;
        this.fixUpward();
        return this;
    }

    public void printHeap() {
        Arrays.stream(heap).forEach(System.out::println);
    }

    @Override
    public T getRoot() {
        if (this.isEmpty()) return null;

        T result = heap[0];
        heap[0] = heap[position--];
        heap[position + 1] = null;

        this.fixDownward(position);

        return result;
    }

    private void fixUpward() {
        int index = this.position;
        int parentIndex = (index - 1) / 2;

        while (parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void fixDownward(int endIndex) {
        if (endIndex == -1) return;

        int index = 0;
        while (index <= endIndex) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;

            if (leftChildIndex > endIndex) break;

            int childToSwap = rightChildIndex > endIndex
                    ? leftChildIndex
                    : heap[leftChildIndex].compareTo(heap[rightChildIndex]) > 0
                        ? leftChildIndex
                        : rightChildIndex;

            if (heap[index].compareTo(heap[childToSwap]) > 0) break;

            swap(index, childToSwap);
            index = childToSwap;
        }
    }

    @Override
    public void sort() {
        for (int i = 0; i <= position; i++) {
            swap(0, position - i);
            fixDownward(position - i - 1);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    private boolean isFull() {
        return position == heap.length - 1;
    }

    private boolean isEmpty() {
        return this.heap.length == 0;
    }

    private void resize(int capacity) {
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }
}
