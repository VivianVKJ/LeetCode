public class C183 {
    public static void main(String[] args) {
        String s = "1111011110000011100000110001011011110010111001010111110001";
        String s1 = "1101";
        String s3 = "1111110011101010110011100100101110010100101110111010111110110010";
        System.out.println(numSteps(s));
    }

    public static int numSteps(String s) {
        int step = 0;
        while (s.length() >= 1) {
            int ones = 0, p = s.length() - 1;
            while (p >= 0 && s.charAt(p) - '0' == 1) {
                ones++;
                p--;
            }
            if (ones > 0) {
                step += ones + 1;
                s = s.substring(0, s.length() - ones);
            }
            System.out.println(step);
            while (s.length() >= 1 && s.charAt(s.length() - 1) - '0' == 0) {
                step++;
                s = s.substring(0, s.length() - 1);
            }
            System.out.println(step);
        }
        return step;
    }
//        double num = 0, base = 1;
//        int step = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            num += (s.charAt(i) - '0') * base;
//            base *= 2;
//        }
//        if (num - 1 < 1e-6) return 0;
//        System.out.println(num);
//        double[] fib = new double[s.length()];
//        fib[0] = 1;
//        fib[1] = 1;
//        for (int i = 2; i < s.length(); i++) {
//            fib[i] = fib[i - 2] + fib[i - 1];
//            step += 1;
//            if (fib[i] - num < 1e-6) return step;
//        }
}
