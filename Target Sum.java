import java.util.Scanner;

public class Main {
    static {
        // Static block - runs when class is loaded (optional)
        for (int i = 0; i < 100; i++) {
            findTargetSumWays(new int[]{1, 2, 3}, 3);
        }
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int zero = 0;
        for (int num : nums) {
            sum += num;
        }
        int result = sum - Math.abs(target);
        if (result < 0 || (result & 1) == 1) {
            return 0;
        }
        result >>= 1;
        int[] data = new int[result + 1];
        data[0]++;
        for (int num : nums) {
            if (num == 0) {
                zero++;
                continue;
            }
            for (int j = result; j >= num; j--) {
                data[j] += data[j - num];
            }
        }
        return data[result] << zero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter the elements of the array separated by space:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target value: ");
        int target = sc.nextInt();
        int ways = findTargetSumWays(nums, target);
        System.out.println("Number of ways: " + ways);
        sc.close();
    }
}
