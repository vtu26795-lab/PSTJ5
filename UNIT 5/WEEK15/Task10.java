import java.util.*;

// 🔹 Item Class
class Item {
    int id;
    int frequency;
    double rating;

    public Item(int id, int frequency, double rating) {
        this.id = id;
        this.frequency = frequency;
        this.rating = rating;
    }
}

// 🔹 Recommendation Engine
class RecommendationEngine {

    // TreeMap: Key = score, Value = list of items
    private TreeMap<Double, List<Item>> map = new TreeMap<>(Collections.reverseOrder());

    // Add item
    public void addItem(Item item) {
        double score = item.frequency * item.rating;

        map.putIfAbsent(score, new ArrayList<>());
        map.get(score).add(item);
    }

    // Get Top-N items
    public List<Item> getTopN(int n) {
        List<Item> result = new ArrayList<>();

        for (Map.Entry<Double, List<Item>> entry : map.entrySet()) {
            for (Item item : entry.getValue()) {
                result.add(item);
                if (result.size() == n) return result;
            }
        }
        return result;
    }
}

// 🔹 Main Class (Stress Testing + Logging)
public class Task10 {

    public static void main(String[] args) {

        RecommendationEngine engine = new RecommendationEngine();

        int size = 1_000_000; // 10^6 items
        Random rand = new Random();

        // 🔹 Start Time
        long start = System.currentTimeMillis();
        System.out.println("[INFO] Adding items...");

        // 🔹 Add items
        for (int i = 0; i < size; i++) {
            int freq = rand.nextInt(100) + 1;
            double rating = rand.nextDouble() * 5;

            engine.addItem(new Item(i, freq, rating));
        }

        long afterInsert = System.currentTimeMillis();
        System.out.println("[INFO] Insert Time = " + (afterInsert - start) + " ms");

        // 🔹 Query Top-N
        System.out.println("[INFO] Fetching Top 10 items...");
        List<Item> topItems = engine.getTopN(10);

        long end = System.currentTimeMillis();
        System.out.println("[INFO] Query Time = " + (end - afterInsert) + " ms");

        // 🔹 Output Top Items
        System.out.println("\nTop 10 Items:");
        for (Item item : topItems) {
            System.out.println("ID=" + item.id +
                    " Score=" + (item.frequency * item.rating));
        }

        // 🔹 Total Time
        System.out.println("\n[INFO] Total Execution Time = " + (end - start) + " ms");
    }
}