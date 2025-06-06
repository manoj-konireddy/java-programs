import java.util.*;

public class Main {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, slowPrev = null;
        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from mid
        if (slowPrev != null) slowPrev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head == slow ? null : head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    // Helper method to create linked list from array
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper method to print tree in level-order
    public static List<String> printTree(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                result.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            } else {
                result.add("null");
            }
        }
        // Trim trailing "null"s
        int i = result.size() - 1;
        while(i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        int[] input = {-10, -3, 0, 5, 9};
        ListNode head = createLinkedList(input);
        TreeNode root = solution.sortedListToBST(head);

        List<String> output = printTree(root);
        System.out.println(output);
    }
}
