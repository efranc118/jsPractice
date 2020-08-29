package main.divideconquer;

import main.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateAllBST {



    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<>();
        return getCombinations(1, n);
    }




    public ArrayList<TreeNode> generateCombinations(Integer min,
                                                    Integer max) {
        ArrayList<TreeNode> allCombinations = new ArrayList<>();

        if(min > max) {
            allCombinations.add(null);
            return allCombinations;
        }


        for(int i = min; i <= max; i++) {

            ArrayList<TreeNode>leftCombinations = generateCombinations(min, i - 1);
            ArrayList<TreeNode>rightCombinations = generateCombinations(i + 1, max);


            for (TreeNode leftCombination : leftCombinations) {
                for (TreeNode rightCombination : rightCombinations) {
                    TreeNode nextNode = new TreeNode(i);
                    nextNode.left = leftCombination;
                    nextNode.right = rightCombination;
                    allCombinations.add(nextNode);
                }
            }
        }
        return allCombinations;
    }





    public LinkedList<TreeNode> getCombinations(int start, int end) {

        //Generate the list to return
        LinkedList<TreeNode> allTrees = new LinkedList<>();

        //Check that a valid tree besides null can be created
        if(start > end) {
            allTrees.add(null); //We have no value to assign so return null node
            return allTrees;
        }


        //Iterate through the entire list of nodes with each as the root
        for(int i  = start; i <= end; i++) {
            //We need to grab all the left & right trees as we iterate through the list

            LinkedList<TreeNode> leftTrees = getCombinations(start, i - 1);

            LinkedList<TreeNode> rightTrees = getCombinations(i + 1, end);

            /**
             * Now we have a list of all the left and right subtrees, and we iterate, we need to do the cross product
             * in order to generate all the required combinations since every left subtree can be paired with every
             * right and then we add the result of our current tree to the all trees
             *
             **/
            for(TreeNode l: leftTrees) { //For every left node we pair all the right nodes
                for(TreeNode r: rightTrees) {
                    TreeNode curNode = new TreeNode(i); //Generate our current Node
                    curNode.left = l;
                    curNode.right = r;
                    allTrees.add(curNode);
                }
            }
        }

        return allTrees;

    }

    public static void main(String[] args) {
        GenerateAllBST solution = new GenerateAllBST();
        System.out.println(solution.generateTrees(3));
    }

}
