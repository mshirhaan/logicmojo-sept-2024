import java.util.*;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        List<List<Integer>> res = levelOrder(arr);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrder(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);

        while (queue.size() > 0) {
            int sizeSnapshot = queue.size();
            List<Integer> row = new ArrayList<>();
            while (sizeSnapshot > 0) {
                Integer current = queue.poll();
                row.add(current);
                int leftChild = leftChildIndex(arr, current);
                if (leftChild != -1 && leftChild < arr.length) {
                    queue.add(leftChild);
                }
                int rightChildIndex = rightChildIndex(arr, current);
                if (rightChildIndex != -1 && rightChildIndex < arr.length) {
                    queue.add(rightChildIndex);
                }
                sizeSnapshot--;
            }
            res.add(row);
        }
        return res;
    }

    private static int leftChildIndex(int[] arr, int index) {
        return (index * 2) + 1;
    }

    private static int rightChildIndex(int[] arr, int index) {
        return (index * 2) + 2;
    }

}
