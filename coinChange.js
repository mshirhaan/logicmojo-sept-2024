//for loop approach gives time limit
var coinChange = function(coins, amount) {
    return helper(0, amount, {});

    function helper(i, amountNeeded, memo) {
       
        if(memo[i+","+amountNeeded] != undefined) {
            return memo[i+","+amountNeeded];
        }
        if(amountNeeded == 0) {
            return 0;
        }
        if(i==coins.length) {
            return -1;
        }

        let maxCoinsWeCanTake = Math.floor(amountNeeded/coins[i]);
        let minCoins = Infinity;

        for(let count = 0; count<= maxCoinsWeCanTake; count++) {
            let newAmountNeeded = amountNeeded-(count*coins[i]);
            let ans = helper(i+1, newAmountNeeded, memo);
            if(ans != -1) {
                minCoins = Math.min(minCoins, count+ans);
            }
        }
        if(minCoins<Infinity) {
            memo[i+","+amountNeeded] = minCoins;
            return minCoins;
        }
        memo[i+","+amountNeeded] = -1;
        return -1;
    }
};





//works
var coinChange = function(coins, amount) {
    let memo = {}
    
    function helper(i, amountNeeded) {
        if (amountNeeded == 0) return 0;
        if (i == coins.length || amountNeeded < 0) return Infinity;
        
        let key = i + "," + amountNeeded;
        if (memo[key] !=undefined) return memo[key];
        
        // Either pick the coin (stay at `i`) or skip to the next coin (`i+1`)
        let pick = 1 + helper(i, amountNeeded - coins[i]);
        let dontPick = helper(i + 1, amountNeeded);
        
        let result = Math.min(pick, dontPick);
        memo[key] = result;
        return result;
    }
    
    let result = helper(0, amount);
    return result == Infinity ? -1 : result;
};
