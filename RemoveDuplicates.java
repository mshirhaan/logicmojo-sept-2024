public class RemoveDuplicates {
    
}


//Brute force
class Solution {
    public int removeDuplicates(int[] arr) {
        List<Integer> dup = new ArrayList<>();
        dup.add(arr[0]);
       
        for(int j = 1; j<arr.length; j++) {
            if(arr[j] != arr[j-1]) {
                dup.add(arr[j]);
            }
        }

        for(int i = 0; i<dup.size(); i++) {
            arr[i] = dup.get(i);
        }

        return dup.size();
    }
}


//Optimal solution
class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;

        for(int j = 1; j < arr.length; j++) {
            if(arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}

