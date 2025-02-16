var minEatingSpeed = function(piles, h) {
    
    let maxBananas = Math.max(...piles)

    function canKokoFinish(k) {
        let hours = 0;
        for(let pile of piles) {
            hours+= Math.ceil(pile/k);
        }
        
        return hours <= h;
    }

    let start = 1, end = maxBananas;

    while(start <= end) {
        let k = Math.floor((start + end)/2)
        let flag = canKokoFinish(k)
        if(flag && !canKokoFinish(k-1)) {
            return k
        } else if(flag) {
            end = k - 1
        } else {
            start = k + 1
        }
    }

};
