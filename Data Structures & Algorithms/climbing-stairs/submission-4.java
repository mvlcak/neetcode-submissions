class Solution {

    HashMap<Params, Integer> cache = new HashMap<>();

    public record Params(int goal, int count){}

    public int climbStairs(int n) {
        return countSteps(n, 0);
    }

    private int countSteps(int goal, int count){
        Params params = new Params(goal, count);
        Integer cached = cache.get(params);
        if(cached != null){
            return cached;
        }

        if(count == goal){
            return 1;
        }



        int result = 0;
        result += countSteps(goal, count+1);
        if(goal - count > 1){
            result += countSteps(goal, count+2);
        }
        cache.put(params, result);
        return result;
    }


    private int countStepsRecursive(int goal, int count){
        
        

        int result = 0;
        result += countSteps(goal, count+1);
        if(goal - count > 1){
            result += countSteps(goal, count+2);
        }
        return result;
    }
}

