class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 != 0){
            return false;
        }

        Stack<String> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            String in = s.substring(i,i+1);
            boolean interm = true;
            if(in.matches("\\(|\\[|\\{")){
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

    boolean matchRight(String in, Stack<String> stack){
        if(stack.empty()){
            return false;
        }
        String popped = stack.pop();
        if(popped.matches("\\)|\\]|\\}")){
            return matchRight(popped, stack);
        } else if (
            !((in.equals(")") && popped.equals("("))
        || (in.equals("]") && popped.equals("["))
        || (in.equals("}") && popped.equals("{")))){
            return false;
        } else {
            return true;
        }
    }
}
