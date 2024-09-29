class Solution {
    public static void main(String[] args) {
        
    }
    public int missingNumber(int[] arr) {
        int xor = arr[0];

        for(int i = 1; i<5;i++) {
            xor^=arr[i];

        }
        for(int i = 0; i<=5;i++) {
            xor^=i;

        }
        return xor;
    }
}


