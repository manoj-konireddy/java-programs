import java.util.*;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    ArrayList<TreeNode> res = new ArrayList<>();

    public void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        res.add(root);
        inorderTraversal(root.right);
    }

    public TreeNode helper(ArrayList<TreeNode> arr, int low, int high){
        if(low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode temp = new TreeNode(arr.get(mid).val);
        temp.left = helper(arr, low, mid - 1);
        temp.right = helper(arr, mid + 1, high);
        return temp;
    }

    public TreeNode balanceBST(TreeNode root) {
        res.clear();
        inorderTraversal(root);
        return helper(res, 0, res.size() - 1);
    }

    // Build tree from level order input with 'null' as missing nodes
    public static TreeNode buildTree(Integer[] arr) {
        if(arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while(!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();
            if(arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if(i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    // Level order print with "null" placeholders
    public static List<String> printTree(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                res.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            } else {
                res.add("null");
            }
        }

        // Remove trailing nulls
        int idx = res.size() - 1;
        while(idx >= 0 && res.get(idx).equals("null")) {
            res.remove(idx);
            idx--;
        }
        return res;
    }

    public static void main(String[] args) {
        Main sol = new Main();

        // Input: root = [1,null,2,null,3,null,4,null,null]
        // Represented in level order array form with Integer[] and null for missing nodes
        Integer[] input = {1, null, 2, null, 3, null, 4, null, null};
        TreeNode root = buildTree(input);

        TreeNode balancedRoot = sol.balanceBST(root);

        List<String> output = printTree(balancedRoot);
        System.out.println(output);
    }
}