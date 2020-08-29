package main.trees;

import java.util.*;

public class BinaryTreeZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        return helper(true, result, stack);
    }

    public List<List<Integer>> helper(boolean ltor, List<List<Integer>> result, Stack<TreeNode> level) {
        if(level.isEmpty()) return result;
        List<Integer> levelResult = new ArrayList<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        while(!level.empty()) {
            TreeNode current = level.pop();
            levelResult.add(current.val);
            if(ltor) {
                if (current.left != null) nextLevel.push(current.left);
                if (current.right != null) nextLevel.push(current.right);
            } else {
                if (current.right != null) nextLevel.push(current.right);
                if (current.left != null) nextLevel.push(current.left);
            }
        }
        result.add(levelResult);
        return helper(!ltor, result, nextLevel);
    }


    public static void main(String[] args) {
        BinaryTreeZigZag solution = new BinaryTreeZigZag();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.zigzagLevelOrder(root));
    }

}
