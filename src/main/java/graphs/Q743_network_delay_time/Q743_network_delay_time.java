package graphs.Q743_network_delay_time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class Q743_network_delay_time {
    /*
        Test case#1
            input XXX
            output XXX
        Test case#2
            input XXX
            output XXX
    */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();

        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int distance = time[2];
            map.putIfAbsent(source, new ArrayList<>());
            map.get(source).add(new Pair<>(target, distance));
        }

        return 0;
    }
}