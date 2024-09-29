
//Brute force
let arr = [0,1,0,2,1,0,1,3,2,1,2,1]

let water = 0;

for(let i = 1; i<arr.length-1;i++) {
    let leftMax = arr[0];
    for(let j = 1; j<i; j++) {
        leftMax = Math.max(leftMax, arr[j])
    }
    if(leftMax<=arr[i]) continue;
    
    let rightMax = arr[arr.length-1];
    for(let j = arr.length-2; j>i; j--) {
        rightMax = Math.max(rightMax, arr[j])
    }
    if(rightMax<=arr[i]) continue;

    water+= Math.min(leftMax, rightMax) - arr[i]
}


//Optimal solution
class Solution {
    public int trap(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        int temp = 0;
        for(int i = 0; i<height.length; i++) {
            leftMax[i] = temp;
            temp = Math.max(temp, height[i]);
        }
        temp = 0;
        for(int i = height.length-1; i>=0; i--) {
            rightMax[i] = temp;
            temp = Math.max(temp, height[i]);
        }
        int water = 0;
        for(int i = 0; i<height.length; i++) {
            water+= Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return water;
    }
}