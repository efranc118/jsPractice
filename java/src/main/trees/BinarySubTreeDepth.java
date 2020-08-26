package main;

import java.util.ArrayList;
import java.util.List;

public class BinarySubTreeDepth {

    List<NodeDepth> nodeDepths = new ArrayList<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        deepestSubTree(root, 0);
        NodeDepth maxNode = new NodeDepth(root, 0);
        for(NodeDepth nd: nodeDepths) {
            if(nd.depth > maxNode.depth) maxNode = nd;
        }
        return maxNode.node;
    }

    public Integer deepestSubTree(TreeNode node, int curDepth) {
        if(node == null) return null;

        Integer leftDepth = deepestSubTree(node.left, curDepth + 1);
        Integer rightDepth = deepestSubTree(node.right, curDepth + 1);
        Integer maxDepth;
        if(leftDepth == null && rightDepth == null) return curDepth;
        if(leftDepth != null && rightDepth != null)
            maxDepth = Math.max(leftDepth, rightDepth);
        else if(leftDepth == null)
            maxDepth = rightDepth;
        else maxDepth = leftDepth;
        nodeDepths.add(new NodeDepth(node, maxDepth));
        return maxDepth;
    }


    class NodeDepth {
        TreeNode node;
        Integer depth;

        NodeDepth(TreeNode node, Integer val) {
            this.node = node;
            this.depth = val;
        }
    }


    public static void main(String[] args) {
        BinarySubTreeDepth solution = new BinarySubTreeDepth();
//        System.out.println(solution.solve());
    }

}
