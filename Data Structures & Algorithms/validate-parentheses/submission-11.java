public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        if(s.toCharArray().length % 2 != 0) return false;

        for(char a : s.toCharArray()){
            if(map.containsKey(a)){
                if(stack.isEmpty()) return false;
                if(stack.pop() != map.get(a)) return false;
            } else {
                stack.push(a);
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}