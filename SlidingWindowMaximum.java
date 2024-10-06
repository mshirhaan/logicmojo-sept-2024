class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] ans = new int[nums.length - k + 1];

        // first k positions largest will be in leftmost position once loop completes
        for (int i = 0; i < k; i++) {
            while (deque.size() > 0 && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        ans[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (deque.size() > 0 && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[i - k + 1] = deque.peekFirst();
        }

        return ans;
    }
}