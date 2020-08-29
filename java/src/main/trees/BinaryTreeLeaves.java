package main.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeaves {


    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        while(root.left != null || root.right != null) {
            result.add(removeLeaves(root, new ArrayList<>()));
        }
        List<Integer> lastList = new ArrayList<>();
        lastList.add(root.val);
        result.add(lastList);
        return result;
    }

    public List<Integer> removeLeaves(TreeNode node, List<Integer> leaves) {
        if(node.left != null || node.right != null) {
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    leaves.add(node.left.val);
                    node.left = null;
                } else leaves = removeLeaves(node.left, leaves);
            }
            if (node.right != null) {
                if (isLeaf(node.right)) {
                    leaves.add(node.right.val);
                    node.right = null;
                } else leaves = removeLeaves(node.right, leaves);
            }
        }
        else {
            leaves.add(node.val);
        }
        return leaves;
    }

    public Boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }



    public static void main(String[] args) {
        BinaryTreeLeaves solution = new BinaryTreeLeaves();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(solution.findLeaves(root));
    }


}
