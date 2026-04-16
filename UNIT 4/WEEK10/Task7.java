import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else {
                // If stack empty → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check matching
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack empty → valid
        return stack.isEmpty();
    }
}
