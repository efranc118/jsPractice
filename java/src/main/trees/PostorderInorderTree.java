package main.trees;

import java.util.Arrays;

public class PostorderInorderTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        if(inorder.length == 0) return null;
        if(postorder.length == 1) return new TreeNode(postorder[0]);
        int val = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(val);
        int leftIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) leftIndex = i;
        }
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, leftIndex) , Arrays.copyOfRange(postorder, 0, leftIndex));
        node.right = buildTree(Arrays.copyOfRange(inorder, leftIndex + 1, inorder.length),Arrays.copyOfRange(postorder, leftIndex + 1, postorder.length - 2));
        return node;
    }


    public static void main(String[] args) {
        PostorderInorderTree solution = new PostorderInorderTree();
        System.out.println(solution.buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}));
    }

}
