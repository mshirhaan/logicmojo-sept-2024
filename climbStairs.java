class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return helper(0, n, memo);
    }

    public int helper(int step, int n, HashMap<Integer, Integer> memo) {
        if(step == n) return 1;
        if(memo.get(step)!=null) {
            return memo.get(step);
        }


        int left = helper(step+1, n, memo);


        int right = 0;

        if(step < n-1) right= helper(step+2, n, memo);

        memo.put(step, left+right);
        return left+right;
    }
}
