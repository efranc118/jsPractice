package main;

import java.util.Stack;

public class BinaryTreeFromString {

  int pos;

    public TreeNode str2tree(String s) {
        pos = 0;
        Stack<TreeNode> heirarchy = new Stack<>();
        TreeNode currentParent = null;
        while(pos < s.length()) {
            Character currentValue = s.charAt(pos);
            if(currentValue == '-' || Character.isDigit(currentValue)) {
                if(currentParent != null) heirarchy.push(currentParent);
                currentParent = new TreeNode(parseInteger(s));
            }
            else if(currentValue == '(') {
                pos++;
                if(currentParent == null) throw new IllegalArgumentException("Invalid String");
                if(currentParent.left == null) {
                    currentParent.left = new TreeNode(parseInteger(s));
                    heirarchy.push(currentParent);
                    currentParent = currentParent.left;
                } else {
                    currentParent.right = new TreeNode(parseInteger(s));
                    heirarchy.push(currentParent);
                    currentParent = currentParent.right;
                }
            } else if(currentValue == ')') {
                currentParent = heirarchy.pop();
            }
            pos++;
        }
        return currentParent;
    }




    private Integer parseInteger(String value) {
      int ptr = pos;
      while(ptr < value.length() && (value.charAt(ptr) == '-' || Character.isDigit(value.charAt(ptr)))) ptr++;

      Integer returnValue = Integer.parseInt(value.substring(pos, ptr));
      pos = ptr - 1;
      return returnValue;
    }


    public static void main(String[] args) {
        BinaryTreeFromString solution = new BinaryTreeFromString();
        System.out.println(solution.str2tree("-4145(17465(1375)(86583))(6(5))"));
        System.out.println(solution.str2tree("-4145"));
    }

}
