import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, Pair> checkInMap;
    private Map<String, Time> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkIn = checkInMap.get(id);
        checkInMap.remove(id);

        String key = checkIn.station + "-" + stationName;
        int travelTime = t - checkIn.time;

        Time trip = travelMap.getOrDefault(key, new Time(0, 0));
        trip.totalTime += travelTime;
        trip.count += 1;

        travelMap.put(key, trip);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        Time trip = travelMap.get(key);
        return (double) trip.totalTime / trip.count;
    }

    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Time {
        int totalTime;
        int count;

        Time(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}