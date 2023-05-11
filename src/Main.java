import hashtable.LinearProbingHashtable;
import heap.MaximumHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MaximumHeap<Integer> maximumHeap = new MaximumHeap<>();

        maximumHeap.insert(30);
        maximumHeap.insert(35);
        maximumHeap.insert(40);
        maximumHeap.insert(37);

        maximumHeap.sort();
        maximumHeap.printHeap();
    }
}