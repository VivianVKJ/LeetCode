public class C182 {
    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 4, 1};
        System.out.println(numOfInc(arr) + numOfInc(reverse(arr)));
    }

    public static int numOfInc(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[3][n], sum = 0;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int l = 1; l < 3; l++) {
            for (int i = l; i < n; i++) {
                dp[l][i] = 0;
                for (int j = l - 1; j < i; j++) {
                    if (arr[j] < arr[i])
                        dp[l][i] += dp[l - 1][j];
                }
            }
        }
        for (int i = 2; i < n; i++) sum += dp[2][i];
        return sum;
    }

    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
//        for (int i : array) System.out.print(i + "  ");
        return array;
    }

}


