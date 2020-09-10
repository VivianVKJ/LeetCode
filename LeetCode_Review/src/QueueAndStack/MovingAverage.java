package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    double sum = 0;
    int size = 0;
    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size)
            sum -= (double) queue.poll();
        sum += val;
        queue.offer(val);
        return sum / Math.min(queue.size(), size);
    }
}
