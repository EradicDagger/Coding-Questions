// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        //System.out.println("\n\n"+ s);
        if (s.length()%2 != 0 || s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if ( BracketHelper.symbols.keySet().contains(c)) {
                if (stack.empty()){
                    return false;
                }
                char sym = stack.pop();
                if (BracketHelper.symbols.get(c) != sym) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty()? true:false;
    }
}

class BracketHelper {

    public static Map<Character, Character> symbols = new HashMap<>();

    static {
        symbols.put(']', '[');
        symbols.put(')', '(');
        symbols.put('}', '{');
    }
}
