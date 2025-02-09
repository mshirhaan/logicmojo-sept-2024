var maxProfit = function(prices) {
    let futureSellingPrice = 0;

    let dp=Array(prices.length).fill(0);

    for(let i = prices.length-1; i>=0; i--) {
        if(prices[i] < futureSellingPrice) {
            dp[i] = futureSellingPrice - prices[i];
            futureSellingPrice = prices[i];
        } else {
            futureSellingPrice = Math.max(futureSellingPrice, prices[i]);
        }
    }
    let sum = 0;
    for(let p of dp) {
        sum+=p
    }
    return sum;
};
