package Heap;

import java.util.PriorityQueue;

public class lastStoneWeight {
    public static void main(String[] args) {
        int[] s = {1, 3};
        System.out.println(lastStoneWeight(s));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int i : stones)
            heap.add(i);
        while (heap.size() > 1) {
            int large = heap.poll(), small = heap.poll();
            if (large > small) heap.offer(large - small);
        }
        return heap.size() == 0 ? 0 : heap.peek();
    }
}
