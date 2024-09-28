//Naive Solution
class Solution {
    public void moveZeroes(int[] nums) {
        int[] copy = new int[nums.length];
        int i = 0, j = 0;

        while(i<nums.length) {
            if(nums[i]!=0) {
                copy[j] = nums[i];
                j++;
            }
            i++;
        }
        for(int k = 0; k<copy.length;k++) {
            nums[k] = copy[k];
        }
        System.out.print(Arrays.toString(nums));
    }
}

