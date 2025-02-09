var maxProfit = function(prices) {

    return helper(0, true, {})
    
    function helper(i, canBuy, memo) {
        if(memo[i+","+canBuy] != undefined) {
            return memo[i+","+canBuy];
        }
        if(i == prices.length) return 0;
        
        if(canBuy) {
            let leftProfit = helper(i+1, false, memo)-prices[i];
            let rightProfit = helper(i+1, true, memo);
            memo[i+","+canBuy] = Math.max(leftProfit, rightProfit);
            return memo[i+","+canBuy];
        } else {
            memo[i+","+canBuy] = Math.max(prices[i], helper(i+1, false, memo));
            return memo[i+","+canBuy];
        }
    }
};
