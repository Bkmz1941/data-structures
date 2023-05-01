import hashtable.LinearProbingHashtable;

public class Main {
    public static void main(String[] args) {
        try {
            LinearProbingHashtable<Integer, String> hashtable = new LinearProbingHashtable<>(6);
            hashtable.put(1, "Ilya");
            hashtable.put(2, "Anna");
            hashtable.put(3, "Dima");       // 3 * 31 (93) % 6 = 3
            hashtable.put(9, "Igor");       // 9 * 31 (279) % 6 = 3 (collision) ->
                                            // (3 + 1) % 6 = 4
            hashtable.put(15, "Elena");     // 9 * 31 (465) % 6 = 3 (collision) ->
                                            // (3 + 1) % 6 = 4 (collision) ->
                                            // (4 + 1) % 6 = 5
            hashtable.put(21, "Valera");    // 15 * 31 (651) % 6 = 3 (collision) ->
                                            // (3 + 1) % 6 = 4 (collision) ->
                                            // (4 + 1) % 6 = 5
                                            // (5 + 1) % 6 = 0
//            hashtable.display();
//            System.out.println(hashtable.get(1));
            hashtable.delete(1);
            hashtable.display();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}