import java.util.HashSet;

public class Task10 {

    public static int isColorful(int A) {
        String num = String.valueOf(A);
        HashSet<Integer> set = new HashSet<>();

        // Generate all contiguous subsequences
        for (int i = 0; i < num.length(); i++) {
            int product = 1;

            for (int j = i; j < num.length(); j++) {
                int digit = num.charAt(j) - '0';
                product *= digit;

                // If product already exists → not colorful
                if (set.contains(product)) {
                    return 0;
                }

                set.add(product);
            }
        }

        return 1; // all products are unique
    }

    public static void main(String[] args) {
        int A = 23;

        System.out.println(isColorful(A)); // Output: 1
    }
}