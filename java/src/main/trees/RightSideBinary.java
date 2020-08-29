package main.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideBinary {

    class NodeDepth {
        TreeNode node;
        Integer depth;
        NodeDepth(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        TreeNode ptr = root;
        Queue<NodeDepth> queue = new LinkedList<>();
        queue.add(new NodeDepth(root, 0));
        while(ptr != null) {
            NodeDepth curNode = queue.remove();
            if(result.size() > curNode.node.val) result.set(curNode.depth, curNode.node.val);
            else result.add(curNode.node.val);
            if (curNode.node.left != null) {
                queue.add(new NodeDepth(curNode.node.left, curNode.depth + 1));
            }
            if (curNode.node.right != null) {
                queue.add(new NodeDepth(curNode.node.right, curNode.depth + 1));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        RightSideBinary solution = new RightSideBinary();
//        System.out.println(solution.solve());
    }

}
