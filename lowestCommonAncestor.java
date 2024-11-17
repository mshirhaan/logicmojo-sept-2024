//Iteration
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while(true) {
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

//Recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,  p,  q);
    }
    public TreeNode helper(TreeNode current, TreeNode p, TreeNode q) {
        if(p.val < current.val && q.val < current.val) {
            return helper(current.left, p, q);
        } else if(p.val > current.val && q.val > current.val) {
            return helper(current.right, p, q);
        }
        return current;
    }
}
