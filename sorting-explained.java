let students = [{name: 'arun', age: 20, marks: 45}, 
                {name: 'eedd', age: 25, marks: 55},
               {name: 'adddrun', age: 21, marks: 75},
               {name: 'arddeun', age: 27, marks: 25},
               {name: 'dedd', age: 23, marks: 35}]

function bubbleSort(nums, comparator) {
    for(let i = 0; i<nums.length-1; i++ ) {
        let didSwap = false;
        for(let j = 0; j<nums.length-1-i;j++) {
            if(comparator(nums[j], nums[j+1]) > 0) {
                didSwap = true;
                swap(nums, j, j+1)
            }
        }
        if(!didSwap) {
            break;
        }
    }
    return nums
}


function selectionSort(nums, comparator) {
    for(let i=0; i<nums.length-1; i++) {
        let swapIndex = i;
        for(let j = i+1; j<nums.length; j++) {
            if(comparator(nums[swapIndex], nums[j]) > 0) {
                swapIndex = j;
            }
        }
        swap(nums, i, swapIndex)
    }
    return nums
}

function insertionSort(nums, comparator) {
    for(let i = 0; i<nums.length-1; i++) {
        let currentNum = nums[i+1];
        for(var j = i; j>=0; j--) {
            if(comparator(nums[j], currentNum)>0) {
                nums[j+1] = nums[j]
            } else {
                break;
            }
        }
        nums[j+1] = currentNum
    }
    return nums
}


function swap(arr, i, j) {
    let temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}


bubbleSort(students, (a,b)=>a.marks-b.marks)
//selectionSort((a,b)=>a-b)
//insertionSort((a,b)=>b-a)



=======
//Merge sort java


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 6, 8, 1, 2, 3, 4, 9, 5 };
        int res[] = mergeSort(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] firstHalf = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] secondHalf = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        int[] left = mergeSort(firstHalf);
        int[] right = mergeSort(secondHalf);

        return merge(left, right);

    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] combinedArr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                combinedArr[k] = (arr1[i]);
                k++;
                i++;
            } else {
                combinedArr[k] = (arr2[j]);
                k++;
                j++;
            }
        }
        while (i < arr1.length) {
            combinedArr[k] = (arr1[i]);
            k++;
            i++;
        }
        while (j < arr2.length) {
            combinedArr[k] = (arr2[j]);
            k++;
            j++;
        }
        return combinedArr;
    }
}


