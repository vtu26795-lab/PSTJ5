import java.util.*;

// Movie class
class Movie {
    String name;
    String genre;
    double rating;

    public Movie(String name, String genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }
}

// User class
class User {
    String username;
    List<Movie> watchHistory;

    public User(String username, List<Movie> watchHistory) {
        this.username = username;
        this.watchHistory = watchHistory;
    }
}

// Recommendation Engine
class RecommendationEngine {

    public List<Movie> getRecommendations(User user) {
        List<Movie> recommendations = new ArrayList<>();

        // Dummy logic: always return 10 movies
        for (int i = 1; i <= 10; i++) {
            recommendations.add(new Movie("Recommended" + i, "Genre" + i, 8.0));
        }

        return recommendations;
    }
}

// Test class (NO JUnit, manual testing)
public class Task3 {

    static RecommendationEngine engine = new RecommendationEngine();

    // Assertion methods
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            System.out.println("❌ FAIL: " + message);
        } else {
            System.out.println("✅ PASS");
        }
    }

    public static void assertNotNull(Object obj) {
        if (obj == null) {
            System.out.println("❌ FAIL: Object is null");
        } else {
            System.out.println("✅ PASS");
        }
    }

    // 1. No watch history
    public static void testNoWatchHistory() {
        System.out.println("\nTest: No Watch History");

        User user = new User("user1", new ArrayList<>());
        List<Movie> rec = engine.getRecommendations(user);

        assertNotNull(rec);
        assertTrue(rec.size() >= 5, "Less than 5 recommendations");
    }

    // 2. Single movie
    public static void testSingleMovie() {
        System.out.println("\nTest: Single Movie");

        List<Movie> watched = new ArrayList<>();
        watched.add(new Movie("Inception", "Sci-Fi", 9.0));

        User user = new User("user2", watched);
        List<Movie> rec = engine.getRecommendations(user);

        assertNotNull(rec);
        assertTrue(rec.size() >= 5, "Less than 5 recommendations");
    }

    // 3. Same ratings different genres
    public static void testSameRatings() {
        System.out.println("\nTest: Same Ratings");

        List<Movie> watched = new ArrayList<>();
        watched.add(new Movie("M1", "Action", 8.0));
        watched.add(new Movie("M2", "Drama", 8.0));
        watched.add(new Movie("M3", "Comedy", 8.0));

        User user = new User("user3", watched);
        List<Movie> rec = engine.getRecommendations(user);

        assertNotNull(rec);
        assertTrue(rec.size() >= 5, "Less than 5 recommendations");
    }

    // 4. Large history (stress test)
    public static void testLargeHistory() {
        System.out.println("\nTest: Large History");

        List<Movie> watched = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            watched.add(new Movie("Movie" + i, "Genre" + (i % 5), 7.0));
        }

        User user = new User("user4", watched);
        List<Movie> rec = engine.getRecommendations(user);

        assertNotNull(rec);
        assertTrue(rec.size() >= 5, "Less than 5 recommendations");
    }

    // Main method
    public static void main(String[] args) {
        testNoWatchHistory();
        testSingleMovie();
        testSameRatings();
        testLargeHistory();
    }
}