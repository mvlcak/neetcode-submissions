class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> studentQue = new ArrayDeque<>(Arrays.stream(students).boxed().collect(Collectors.toList()));
        ArrayDeque<Integer> sandwhichQue = new ArrayDeque<>(Arrays.stream(sandwiches).boxed().collect(Collectors.toList()));
        int loopCounter = 0;
        boolean shouldLoop=true;
        while(shouldLoop){
            var student = studentQue.pop();
            if(!student.equals(sandwhichQue.peek())){
               studentQue.addLast(student);
                loopCounter++;
            } else{
                sandwhichQue.pop();
                loopCounter = 0;
            }
            if (loopCounter > studentQue.size()){
                return studentQue.size();
            }
            if(sandwhichQue.size() == 0){
                shouldLoop=false;
            }


        }
        return 0;
    }
}