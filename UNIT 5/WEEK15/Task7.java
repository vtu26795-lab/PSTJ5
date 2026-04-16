import java.util.*;
import java.util.stream.*;

class User {
    int age;
    String location;
    double activityScore;
    boolean isActive;

    public User(int age, String location, double activityScore, boolean isActive) {
        this.age = age;
        this.location = location;
        this.activityScore = activityScore;
        this.isActive = isActive;
    }
}

public class Task7 {

    // 🔹 Method to calculate average activity score of active users
    public static double getAverageScore(List<User> users) {

        // 👉 BUG FIX: handle empty list / no active users safely
        return users.stream()
                .filter(user -> user.isActive)   // filter active users
                .mapToDouble(user -> user.activityScore)
                .average()
                .orElse(0.0);  // ✅ FIX: avoids NoSuchElement / wrong value
    }

    public static void main(String[] args) {

        // 🔹 Input: programmatically created users
        List<User> users = Arrays.asList(
                new User(25, "Chennai", 80.5, true),
                new User(30, "Delhi", 60.0, false),
                new User(22, "Mumbai", 90.0, true),
                new User(28, "Bangalore", 0.0, false)
        );

        double avg = getAverageScore(users);
        System.out.println("Average Activity Score (Active Users) = " + avg);

        // 🔹 Edge Case 1: Empty List
        List<User> emptyList = new ArrayList<>();
        System.out.println("Empty List Avg = " + getAverageScore(emptyList));

        // 🔹 Edge Case 2: All Inactive
        List<User> inactiveList = Arrays.asList(
                new User(20, "Chennai", 50.0, false),
                new User(21, "Delhi", 70.0, false)
        );
        System.out.println("All Inactive Avg = " + getAverageScore(inactiveList));
    }
}