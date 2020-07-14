package Array;

import java.util.Arrays;
import java.util.HashMap;

public class prisonAfterNDays {
    public static void main(String[] args) {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        cells = prisonAfterNDays(cells, N);
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> record = new HashMap<>();
        while (N > 0) {
            int[] next = new int[8];
            record.put(Arrays.toString(cells), N--);
            for (int p = 1; p < 7; p++)
                next[p] = cells[p - 1] == cells[p + 1] ? 1 : 0;
            cells = next;
            if (record.containsKey(Arrays.toString(cells)))
                N %= record.get(Arrays.toString(cells)) - N;
        }
        return cells;
    }

}
