import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        BitSet ans = new BitSet(sum + 1);
        ans.set(0);
        for (int num : nums) {
            if (num > sum) continue;
            BitSet shifted = shiftLeft(ans, num, sum);
            ans.or(shifted);
            if (ans.get(sum)) {
                return true;
            }
        }
        return ans.get(sum);
    }
    private static BitSet shiftLeft(BitSet bitset, int shift, int max) {
        BitSet shifted = new BitSet(max + 1);
        for (int i = bitset.nextSetBit(0); i >= 0 && i + shift <= max; i = bitset.nextSetBit(i + 1)) {
            shifted.set(i + shift);
        }
        return shifted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the elements separated by spaces:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean result = canPartition(nums);
        System.out.println("Can partition: " + result);
        sc.close();
    }
}
