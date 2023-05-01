package hashtable;

public class LinearProbingHashtable<K, V> {
    private int M;
    private int N;
    private final Entry<K, V>[] table;

    public LinearProbingHashtable(int size) {
        this.M = size;
        this.N = 0;
        this.table = new Entry[size];
    }

    public void put(K key, V value) {
        int idx = this.hash(key) % this.M;

        while (this.table[idx] != null) {
            if (this.table[idx].key.equals(key)) {
                this.table[idx].value = value;
                return;
            }
            idx = (idx + 1) % this.M;
        }

        if (this.N > this.M - 1) {
            throw new RuntimeException("Table is full");
        }

        this.table[idx] = new Entry<>(key, value);
        this.N++;
    }

    public V get(K key) {
        int idx = this.hash(key) % this.M;
        while (this.table[idx] != null) {
            if (this.table[idx].key.equals(key)) {
                return this.table[idx].value;
            }
            idx = (idx + 1) % this.M;
        }

        return null;
    }

    public void delete(K key) {
        int idx = this.hash(key) % this.M;
        while (this.table[idx] != null) {
            if (this.table[idx].key.equals(key)) {
                this.table[idx] = null;
                return;
            }
            idx = (idx + 1) % this.M;
        }
    }

    public void display() {
        for (int i = 0; i < this.M; i++) {
            System.out.println(this.table[i]);
        }
    }

    private int hash(K key) {
        return 31 * key.hashCode();
    }

    class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
