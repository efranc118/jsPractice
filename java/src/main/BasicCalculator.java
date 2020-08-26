import java.util.Stack;

public class BasicCalculator {

    int stringPos = 0;
    public int calculate(String s) {
        stringPos = 0;
        s = new StringBuilder(s).reverse().toString();
        return calculateValue(s);



    }

    public int calculateValue(String s) {

        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        while(stringPos < s.length()) {
            char currentChar = s.charAt(stringPos);
            if(Character.isDigit(currentChar)) {
                int value = parseInteger(s);
                values.push(value);
            } else if(currentChar == '+' || currentChar == '-') {
                operators.push(currentChar);
                stringPos++;
            } else if(currentChar == ')') {
                stringPos++;
                values.push(calculateValue(s));
            } else if(currentChar == '(') {
                stringPos++;
                break;
            } else stringPos++;
        }

        while(!operators.isEmpty()) {
            int operandOne = values.pop();
            int operandTwo = values.pop();
            Character operator = operators.pop();

            if(operator == '+') {
                values.push(operandTwo + operandOne);
            }
            if(operator == '-') {
                values.push(operandOne - operandTwo);
            }
        }
        return values.pop();
    }



    public int parseInteger(String s) {
        int pos = stringPos;
        int operand = 0;
        int n = 0;
        while( pos < s.length() && Character.isDigit(s.charAt(pos))) {
            operand = (int) Math.pow(10, n) * (int) (s.charAt(pos) - '0') + operand;
            n += 1;
            pos++;
        }
        stringPos = pos;
        return operand;
    }


    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();
        Solution check = new Solution();
//        System.out.println(solution.calculate("7463847412 + 1"));
        System.out.println(check.calculate("7463847412 + 1"));
//        System.out.println(solution.calculate(" 2-1 + 1"));
//        System.out.println(solution.calculate(" 2-(1 + 1)"));
//        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}



class Solution {

    public int evaluateExpr(Stack<Object> stack) {

        int res = 0;

        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        // Evaluate the expression till we get corresponding ')'
        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public int calculate(String s) {

        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                // Forming the operand - in reverse order.
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {

                    // Save the operand on the stack
                    // As we encounter some non-digit.
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {

                    int res = evaluateExpr(stack);
                    stack.pop();

                    // Append the evaluated result to the stack.
                    // This result could be of a sub-expression within the parenthesis.
                    stack.push(res);

                } else {
                    // For other non-digits just push onto the stack.
                    stack.push(ch);
                }
            }
        }

        //Push the last operand to stack, if any.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }
}
