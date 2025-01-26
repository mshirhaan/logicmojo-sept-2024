class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> memo1 = new HashMap<>();
        HashMap<Integer, Integer> memo2 = new HashMap<>();
        int first = helper(1, nums, memo1);
        int second = helper(0, Arrays.copyOf(nums, nums.length-1), memo2);

        return Math.max(first, second);
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
