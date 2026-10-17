class Solution {

    int[] cache;

    int goal;
    public record Params(int goal, int count){}

    public int climbStairs(int n) {
        goal = n;
        cache = new int[n+1];
        return countSteps(0);
    }

    private int countSteps(int count){
        int cached = cache[count];
        if(cached != 0){
            return cached;
        }

        if(count == goal){
            return 1;
        }



        int result = 0;
        result += countSteps(count+1);
        if(goal - count > 1){
            result += countSteps(count+2);
        }
        cache[count]=result;
        return result;
    }


    private int countStepsRecursive(int goal, int count){
        
        

        int result = 0;
        result += countStepsRecursive(goal, count+1);
        if(goal - count > 1){
            result += countStepsRecursive(goal, count+2);
        }
        return result;
    }
}

