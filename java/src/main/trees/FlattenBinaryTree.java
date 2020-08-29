package main.trees;

public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        flattenTree(root);
        System.out.println(root.val);
    }

    public TreeNode flattenTree(TreeNode node) {
        if(node == null) return null;

        TreeNode left = flattenTree(node.left);

        TreeNode right = flattenTree(node.right);

        if(left == null) return node;

        TreeNode leftPtr = left;
        while(leftPtr.right != null) {
            leftPtr = leftPtr.right;
        }
        node.right = left;
        leftPtr.right = right;
        node.left = null;
        return node;
    }


    public static void main(String[] args) {
        FlattenBinaryTree solution = new FlattenBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        solution.flatten(root);
    }

}
