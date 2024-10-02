function sortColors(nums) {
    let n = nums.length;
    let i = 0;
    while (nums[i] == 0)
        i++;

    let j = n - 1;
    while (nums[j] == 2)
        j--;

    let k = i;

    while (k <= j) {
        if (nums[k] == 0) {
            swap(nums, i, k);
            i++;
            k++;
        }
        else if (nums[k] == 2) {
            swap(nums, j, k);
            j--;
        }
        else if (nums[k] == 1)
            k++;
    }
return nums
}

function swap(arr, i, j) {
    let temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

//Abhisheks working code
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let i = 0
    let j = nums.length-1
    let k= 0
    while(k<=j){
         if(nums[k]==0)
            {
                swap(nums,k,i);
                i++;
                k++;
            }
            else if(nums[k]==1)
                k++;
            else
            {
                swap(nums, k , j);
                j--;
            }
    }
    return(nums)
};
var swap = function(nums,a,b){
    let temp = nums[a]
    nums[a] = nums[b]
    nums[b] = temp
}