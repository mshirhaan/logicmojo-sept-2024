class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> bag = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        this.helper(0, bag, nums, result);
        return result;
    }

    private void helper(int index, List<Integer> bag, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(bag));
            return;
        }

        // Include the current element
        bag.add(nums[index]);
        helper(index + 1, bag, nums, result);

        // Backtrack and exclude the current element
        bag.remove(bag.size() - 1);
        helper(index + 1, bag, nums, result);
    }
}
