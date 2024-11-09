class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
            };
        if(p == null || q == null) {
            return false;
        };

        return helper(p, q);
    }

    public boolean helper(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        };
        if(p == null || q == null) {
            return false;
        };

        if(p.val != q.val) return false;

        boolean leftMatch = helper(p.left, q.left);

        if(leftMatch == false) return false;

        boolean rightMatch = helper(p.right, q.right);

        return leftMatch && rightMatch;
    }
}
