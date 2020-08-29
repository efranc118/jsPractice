package main.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPath {


    List<Integer> PathTotals = new ArrayList<>();
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        calculatePathSums(root);
        int max = PathTotals.get(0);
        for(int i = 1; i < PathTotals.size(); i++) {
            if(PathTotals.get(i) > max) max = PathTotals.get(i);
        }
        return max;
    }

    public Integer calculatePathSums(TreeNode node) {
        if(node == null) return 0;

        int leftTotal = calculatePathSums(node.left);
        int rightTotal = calculatePathSums(node.right);

        if(leftTotal < 0) leftTotal = 0;
        if(rightTotal < 0) rightTotal = 0;

        int sum = leftTotal + rightTotal + node.val;
        PathTotals.add(sum);
        return sum;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPath solution = new BinaryTreeMaximumPath();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(solution.maxPathSum(root));
    }

}
