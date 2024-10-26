class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> trolly = new ArrayList<>();
        Arrays.sort(nums);
        trolly.add(new ArrayList<>());
        List<Integer> bag = new ArrayList<>();
        helper(0, nums, trolly, bag);
        return trolly;
    }



    public void helper(int index, int nums[], List<List<Integer>> trolly, List<Integer> bag) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            bag.add(nums[i]);
            trolly.add(new ArrayList<>(bag));
            helper(i + 1, nums, trolly, bag);
            bag.remove(bag.size() - 1);
        }
    }
}
