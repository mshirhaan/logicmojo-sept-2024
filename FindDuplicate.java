class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;

        int ans = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];

            if (fast == slow) {
                fast = 0;

                while(fast!=slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                ans = fast;
                break;
            }
        }        
        return ans;
    }
}
