package main.trees;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        String leftVal = left != null ? left.toString() : "null";
        String rightVal = right != null ? right.toString() : "null";
        return "TreeNode{" +
                "val=" + val +
                ", left=" + leftVal +
                ", right=" + rightVal +
                '}';
    }
}
