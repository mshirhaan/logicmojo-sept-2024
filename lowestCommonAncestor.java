class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while(true) {
            if(current.val == p.val || current.val == q.val) {
                return current;
            }
            if(p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if(p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
    }
}
