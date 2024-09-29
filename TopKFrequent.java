import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//O(n) + O(k2)  (if you sort the map instead of nested loop , you get O(n) + O(klogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
       
        for(int i = 0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int[] ans = new int[k];
        Set<Integer> set = new HashSet<>();
        for(int i =0; i<k; i++) {
            int max = Integer.MIN_VALUE;
            int maxKey = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(set.contains(entry.getKey())) {
                    continue;
                }
                if(entry.getValue() > max) {
                    max = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            ans[i] = maxKey;
            set.add(maxKey);
        }
        return ans;
    }
}

//Optimal
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        Map<Integer, List<Integer>> revMap = new HashMap<>();
       
        for(int i = 0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int[] ans = new int[k];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(revMap.get(entry.getValue()) == null) {
                revMap.put(entry.getValue(), new ArrayList<>());
            }
            revMap.get(entry.getValue()).add(entry.getKey());
        }

        while(k>0) {
            for(int count = nums.length; count>0; count--) {
                if(revMap.get(count) != null) {
                    for(int i = 0; i<revMap.get(count).size() && k>0; i++) {
                        ans[k-1] = revMap.get(count).get(i);
                        k--;
                    }
                }
            }
        }
        
        return ans;
    }
}