class Solution {
    fractionalknapsack(val, wt, capacity) {
        // code here
        let arr = []
        
        for(let i = 0; i<wt.length; i++) {
            arr.push({
                wt: wt[i],
                val: val[i], 
                unitVal: val[i]/wt[i]
            })
        }
        
        arr.sort((a,b)=>b.unitVal-a.unitVal)
        
        let remCap = capacity;
        let value = 0;
        
        for(let i = 0; i<wt.length; i++) {
            let unitsToTake = Math.min(remCap, arr[i].wt);
            value+= unitsToTake*arr[i].unitVal;
            remCap-=unitsToTake
            if(remCap == 0) {
                break;
            }
        }
        return value;
    }
}
