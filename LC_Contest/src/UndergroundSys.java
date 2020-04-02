import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UndergroundSys {

    HashMap<String, int[]> map;
    HashMap<Integer, List<String>> time;

    public UndergroundSys() {
        this.map = new HashMap<>();
        this.time = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        List<String> rec = new ArrayList<>();
        rec.add(stationName);
        rec.add(t + "");
        time.put(id, rec);
    }

    public void checkOut(int id, String stationName, int t) {
        List<String> record = this.time.get(id);
        int dur = t - Integer.parseInt(record.get(1));
        String trip = record.get(0) + stationName;
        if (this.map.containsKey(trip)) {
            int[] his = this.map.get(trip);
            his[1] += 1;
            his[0] += dur;
            this.map.put(trip, his);
        } else {
            int[] add = {dur, 1};
            this.map.put(trip, add);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        return this.map.get(startStation + endStation)[0] * 1.0 / this.map.get(startStation + endStation)[1];
    }

    public static void main(String[] args) {
        UndergroundSys undergroundSystem = new UndergroundSys();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
    }
}
