//O(n3)
let nums= [100,4,200,1,3,2]

let max = Math.min(1, nums.length);

for(let i = 0; i < nums.length; i++) {
    let length = 1;
    for(let j = nums[i]+1; ;j++) {
        let found = false;
        for(let k = 0; k<nums.length;k++) {
            if(nums[k] == j) {
                found = true;
                length++;
                break;
            }
        }
        if(found) {
            max = Math.max(max, length);
        } else {
            break;
        }
    }   
}


//O(n2)
let nums= [100,4,200,1,3,2]

let max = Math.min(1, nums.length);

let set = new Set();

for(let k = 0; k < nums.length; k++) {
    set.add(nums[k]);
}

for(let i = 0; i < nums.length; i++) {
    let length = 1;
    if(!set.has(nums[i]-1)) {
        for(let j = nums[i]+1; ;j++) {
            if(set.has(j)) {
                length++;
            } else {
                max = Math.max(max, length);
                break;
            }
        }
    }
}




//O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int max = 1;

        for(int num : set) {

            //checking if not starting of series
            if(set.contains(num-1)) {
                continue;
            }

            int count = 1;
            int curr = num+1;

            while(set.contains(curr)) {
                count++;
                if(count > max) max = count;

                curr++;
            }
        }

        return max;
    }
}