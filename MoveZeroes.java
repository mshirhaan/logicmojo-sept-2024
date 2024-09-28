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


//2 pointers
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i<nums.length && nums[i]!=0) {
            i++;
        }
        
        for(int j = i+1; j<nums.length; j++) {
            if(nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
