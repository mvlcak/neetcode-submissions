class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< operations.length; i++){
            if(operations[i].equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                int sum = first + second;
              
                stack.push(first);
                stack.push(sum);
            } else if(operations[i].equals("D")){
                int first = stack.peek();
                int res = first * 2;
                stack.push(res);
            } else if(operations[i].equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(operations[i]));
            }
            
        }
        int result = 0;
        while(true){
            try{
                result = result + stack.pop();
            } catch (Exception e){
                break;
            }
        }
        return result;
    }
}