package Array;

import java.util.ArrayList;
import java.util.Collections;

public class maximumProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        int nz = 0;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int a : nums) {
            if (a > 0) pos.add(a);
            else if (a == 0) nz++;
            else neg.add(a);
        }
        Collections.sort(pos);
        Collections.sort(neg);
        int np = pos.size(), nn = neg.size();
        int max = Integer.MIN_VALUE;
        if (np >= 3) max = Math.max(max, pos.get(np - 3) * pos.get(np - 2) * pos.get(np - 2));
        if (np >= 1 && nn >= 2) max = Math.max(max, pos.get(np - 1) * neg.get(0) * neg.get(1));
        if (nz >= 1) max = Math.max(0, max);
        if (nn >= 3) max = Math.max(max, neg.get(nn - 3) * neg.get(nn - 2) * neg.get(nn - 1));
        return max;
    }
}
