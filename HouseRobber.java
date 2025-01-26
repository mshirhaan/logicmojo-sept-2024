class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return helper(0, nums, memo);
    }

    public int helper(int i, int[] nums, HashMap<Integer, Integer> memo) {
        if(memo.get(i) !=null) {
            return memo.get(i);
        }
        if(i >= nums.length) {
            return 0;
        }
        //rob
        int left = nums[i] + helper(i+2, nums, memo);

        //dont rob
        int right = helper(i+1, nums, memo);

        memo.put(i, Math.max(left, right));
        return Math.max(left, right);
    }
}
