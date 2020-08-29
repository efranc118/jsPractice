package main;

import main.trees.TreeNode;

import java.util.Arrays;

public class InorderPreorderTree {

    int pos = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) return null;
        int val = preorder[pos];
        pos++;
        TreeNode node = new TreeNode(val);
        int inorderPos = 0;
        for(int i =0; i < inorder.length; i++) {
            if(val == inorder[i]){
                inorderPos = i;
                break;
            }
        }
        node.left = buildTree(preorder, Arrays.copyOfRange(inorder,0,
                inorderPos));
        node.right = buildTree(preorder, Arrays.copyOfRange(inorder,
                inorderPos + 1,inorder.length));
        return node;
    }

        public static void main(String[] args) {
        InorderPreorderTree solution = new InorderPreorderTree();
        System.out.println(solution.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }

}
