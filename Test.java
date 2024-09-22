public class Test {
    public static void main(String[] args) {
       
        int arr[] = {1,3,-5,4,8,2,1};

        int max = Integer.MIN_VALUE;
        //brute force
        
        for(int i = 0; i < arr.length - 2; i++) {
            int sum = 0;
            for(int j = i; j<i+3; j++) {
                sum+=arr[j];
            }
            max = Math.max(sum,max);
        }

        System.out.println(max);
    }
}