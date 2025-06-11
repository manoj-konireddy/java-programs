import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int range = max - min + 1;
        int[] count = new int[range];
        for (int num : nums) {
            count[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            int freq = count[i];
            while (freq-- > 0) {
                nums[index++] = i + min;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Main solution = new Main();
        int[] sorted = solution.sortArray(nums);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(sorted));
        scanner.close();
    }
}
