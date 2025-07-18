package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty() && (ch == '}' || ch == ')' || ch == ']') ) {
                return false;
            }
            else if(ch == '}' || ch == ')' || ch == ']') {
                if(stack.peek().equals(map.get(ch))) {
                    stack.pop();
                }else {
                    return false;
                }
            }
            else {
                stack.push(ch);
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
