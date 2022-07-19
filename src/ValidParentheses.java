import java.util.Stack;

/**
 *
 *  20. Valid Parentheses
 *  <p>
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  <p>
 *  An input string is valid if:
 *  <p>
 *  Open brackets must be closed by the same type of brackets.
 *  Open brackets must be closed in the correct order.
 *  Note that an empty string is also considered valid.
 *
 *  1. traverse the string from left to right
 *  2. if we encountered the open/left parenthesis, then we will push it to the Stack data structure due to its
 *  Last In First Out (LIFO) property
 *  3. if we encountered any of the close/right parentheses, we will check it with the top stack of the stack. if it is
 *  the correct corresponding open/left parentheses, we will move further, else we will return false
 *  4. At last, for valid string, the stack should be empty because all the left parentheses should have matched with the right ones.
 *
 * Declare an empty stack.
 * Push an opening parenthesis on top of the stack.
 * In case of a closing bracket, check if the stack is empty.
 * If not, pop in a closing parenthesis if the top of the stack contains the corresponding opening parenthesis.
 * If the parentheses are valid,​ then the stack will be empty once the input string finishes.
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        // Stack to store left symbols
        Stack<Character> leftSymbols = new Stack<>();

        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // if left symbol is encountered
            if (c == '(' || c == '{' || c == '['){
                leftSymbols.push(c);
            }
            // if right symbol is encountered
            else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '('){
                leftSymbols.pop();
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{'){
                leftSymbols.pop();
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '['){
                leftSymbols.pop();
            }

            // if none of the valid symbols is encountered
            else {
                return false;
            }
        }
        return leftSymbols.isEmpty();


    }
}
