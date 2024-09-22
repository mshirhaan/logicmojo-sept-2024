//Illegal in leetcode but challenging with zeros
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countZero = 0;

        for(int num : nums) {
            if(num==0) {
                countZero++;
            } else {
                product*= num;
            }
        }

        int ans[] = new int[nums.length];

        for(int i = 0; i<nums.length; i++) {
            if(countZero>1) {
                ans[i] = 0;
            } else if(countZero == 1) {
                if(nums[i] == 0) {
                    ans[i] = product;
                } else {
                    ans[i] = 0;
                }
            } else {
                ans[i] = product/nums[i];
            }
        }
        return ans;
    }
}


//optimal
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pref[] = new int[nums.length];
        int suff[] = new int[nums.length];

        int carry = 1;

        for(int i = 0; i<nums.length; i++) {
            pref[i] = carry;
            carry*= nums[i];
        }

        carry = 1;
        for(int i = nums.length-1; i>=0; i--) {
            suff[i] = carry;
            carry*= nums[i];
        }


        int ans[] = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            ans[i] = pref[i] * suff[i];
        }

        return ans;
    }
}