import java.util.*;

public class Main {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // Solution class
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) return null;
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }

        public List<String> serialize(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add("null");
                    continue;
                }
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }

            // Trim trailing "null"s
            int i = result.size() - 1;
            while (i >= 0 && result.get(i).equals("null")) {
                result.remove(i);
                i--;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode bstRoot = sol.sortedArrayToBST(nums);
        List<String> serialized = sol.serialize(bstRoot);

        System.out.println(serialized);
    }
}
