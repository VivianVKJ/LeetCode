package DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//399 Equation Division
public class equation_division {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, values[i]);
            map.get(b).put(a, 1 / values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), 1.0, new HashSet<>());
        }
        return ans;
    }

    public static double dfs(HashMap<String, HashMap<String, Double>> map, String s, String t, double res, HashSet<String> visited) {
        if (!map.containsKey(s) || !map.containsKey(t)) return -1;
        visited.add(s);
        HashMap<String, Double> chain = new HashMap<>();
        for (String post : chain.keySet()) {
            if (post == t) return res * chain.get(post);
            if (!visited.contains(post)) return res * dfs(map, post, t, res * chain.get(post), visited);
        }
        return -1;
    }
}
