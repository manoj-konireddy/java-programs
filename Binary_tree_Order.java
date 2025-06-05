class Node{
    int val;
    Node left, right;
    Node (int val){
        this.val = val;
        this.right = null;
    }
}
// Binary tree definition
public class Main{
    Node root;
    // Insert Nodes manually (not BST insert)
    void buildSampleTree(){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }
    // Inorder traversal (left, root, right)
    void inorder(Node node){
        if (node != null){
            inorder(node.left);
            System.out.print(node.val+" ");
            inorder(node.right);
        }
    }
    // preorder traversal (root, left, right)
    void preorder(Node node){
        if (node != null){
            System.out.print(node.val+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    // postorder traversal (right ,left,right )
    void postorder(Node node){
        if (node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.val+" ");
        }
    }
    // Level order traversal (BFS)
    void levelorder(){
        if (root != null) return;
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.val+" ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }
    // main function
    public static void main(String[] args){
        Main tree = new Main();
        tree.buildSampleTree();
        System.out.println("Inorder traversal");
        tree.inorder(tree.root);
        System.out.println("\npreorder traversal");
        tree.preorder(tree.root);
        System.out.println("\npostorder traversal");
        tree.postorder(tree.root);
        System.out.println("\nlevelorder traversal");
        tree.levelorder();
    }
}