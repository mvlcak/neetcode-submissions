class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char in = s.charAt(i);
            boolean interm = true;
            if(in == '('||in == '['|| in == '{'){
                stack.push(in);
            } else  {
                interm = matchRight(in, stack);
            }
            
            if(!interm){
                return false;
            }
            
        }
        if(!stack.empty()){
            return false;
        }

        return true;
    }

    boolean matchRight(char in, Stack<Character> stack){
        if(stack.empty()){
            return false;
        }
        char popped = stack.pop();
        if(popped ==')' || popped ==']' || popped == '}'){
            return matchRight(popped, stack);
        } else if (
            !((in  == ')' && popped == '(')
        || (in == ']' && popped == '[')
        || (in == '}' && popped == '{'))){
            return false;
        } else {
            return true;
        }
    }
}
