class Solution {
    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root); 
        return max;
    }

    public int helper(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 1;
        }
        int left = node.left != null ? helper(node.left) : 0;
        int right = node.right != null ? helper(node.right) : 0;
        this.max = Math.max(this.max, left + right);
        return 1+ Math.max(left, right);
    }
}



//TODO
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[] = helper(root); 
        return Math.max(ans[0], ans[1]);
    }

    public int[] helper(TreeNode node) {
        if(node.left == null && node.right == null) {
            return new int[]{1,1};
        }
        int left[] = node.left != null ? helper(node.left) : new int[]{0,0};
        int right[] = node.right != null ? helper(node.right) : new int[]{0,0};
        return new int[]{1+ Math.max(left[0], right[0]), Math.max(left[1] + right[1])};
    }
}
