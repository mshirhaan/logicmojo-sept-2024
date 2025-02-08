class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    knapSack(capacity, val, wt) {
        // code here
        return helper(0, capacity, {});
        
        
        function helper(i, remCap, map) {
            if(map[i+','+remCap] != undefined) {
                return map[i+','+remCap];
            }
            
            if(remCap == 0 || i == val.length) {
                return 0;
            }
            let left = 0;
            if(remCap >= wt[i]) {
                left = val[i] + helper(i+1, remCap-wt[i], map)
            }
            let right = helper(i+1, remCap, map)
            
            map[i+','+remCap] = Math.max(left, right);
            return map[i+','+remCap];
        }
    }
    
    
}
