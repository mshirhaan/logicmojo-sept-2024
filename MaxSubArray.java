class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int candidateSum = sum + nums[i];
            if (nums[i] > candidateSum) {
                sum = nums[i];
            } else {
                sum = candidateSum;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}