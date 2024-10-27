class Solution {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), 0, target, result);
        return result;
    }


    private static void helper(int index, int[] nums, List<Integer> current, 
                               int sum, int target, List<List<Integer>> result) {
        if (sum > target) {
            return;  // Stop exploring if sum exceeds the target
        }
        if (index == nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(current));  // Add a valid subset to the result
            }
            return;
        }
        // Include the current element in the subset
        current.add(nums[index]);
        helper(index, nums, current, sum + nums[index], target, result);

        // Backtrack: remove the last added element
        current.remove(current.size() - 1);

        // Exclude the current element and move to the next index
        helper(index + 1, nums, current, sum, target, result);
    }

}
