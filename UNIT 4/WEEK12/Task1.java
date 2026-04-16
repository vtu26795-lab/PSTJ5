import java.util.*;

public class Task1 {

    public static int minMeetingRooms(int[][] meetings) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Step 1: Mark start and end times
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        // Step 2: Traverse TreeMap
        int currentRooms = 0;
        int maxRooms = 0;

        for (int count : map.values()) {
            currentRooms += count;
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] meetings = {
            {30, 75},
            {0, 50},
            {60, 150}
        };

        System.out.println(minMeetingRooms(meetings)); // Output: 2
    }
}