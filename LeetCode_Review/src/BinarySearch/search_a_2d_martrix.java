package BinarySearch;

public class search_a_2d_martrix {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1}, {3}};
        int target = 3;
        System.out.println(searchMatrix(nums, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //find last<targer in  row
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        int column = BinarySearch(matrix[0], target);
        System.out.print(column);
        if (column < n && matrix[0][column] == target) return true;
        int row = 0;
        while (row + 1 < m && matrix[row + 1][column] < target) {
            row++;
        }
        if (row < m && matrix[row][column] == target) return true;
        return false;


    }

    public static int BinarySearch(int[] nums, int target) { //find last min
        int n = nums.length;
        int l = 0, r = n, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return r;
    }

}
