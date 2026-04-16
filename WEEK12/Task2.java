import java.util.*;

class Item {
    String name;
    double rating;

    Item(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of items
        int n = sc.nextInt();

        ArrayList<Item> list = new ArrayList<>();

        // Read items
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double rating = sc.nextDouble();
            list.add(new Item(name, rating));
        }

        double threshold = 8.0;

        // Filter items (rating >= 8.0)
        list.removeIf(item -> item.rating < threshold);

        // Sort items
        Collections.sort(list, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (a.rating == b.rating) {
                    return a.name.compareTo(b.name); // lexicographic
                }
                return Double.compare(b.rating, a.rating); // descending
            }
        });

        // Print output
        for (Item item : list) {
            System.out.println(item.name + " " + item.rating);
        }

        sc.close();
    }
}