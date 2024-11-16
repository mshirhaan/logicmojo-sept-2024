
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       return helper(root, subRoot);
    }

    public boolean helper(TreeNode root, TreeNode subRoot) {
        if(sameTree(root, subRoot) == true) return true;

       if(root.left!=null && helper(root.left, subRoot) == true ) return true;

       if(root.right != null && helper(root.right, subRoot) == true) return true;

       return false;

    }

    public boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        };
        if(p == null || q == null) {
            return false;
        };

        if(p.val != q.val) return false;

        boolean leftMatch = sameTree(p.left, q.left);

        if(leftMatch == false) return false;

        boolean rightMatch = sameTree(p.right, q.right);

        return leftMatch && rightMatch;
    }

    

}
