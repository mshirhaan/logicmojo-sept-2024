
var canJump = function(nums) {
    return helper(0, []);

    function helper(i, map) {

        if(i==nums.length-1) {
            return true;
        }

        if(map[i]!=undefined) {
            return map[i]
        }

        for(let count = 1; count<=nums[i]; count++) {
            if(helper(i+count, map)) {
                map[i] = true;
                return true;
            }
        }
        map[i] = false;
        return false;
    }
};
