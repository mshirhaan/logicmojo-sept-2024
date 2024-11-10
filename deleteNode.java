class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) {
                return null;
            }
        if(root.val == key) {
            if(root.left ==null && root.right ==null) {
                return null;
            }
            if(root.left ==null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            helper(root.right, root.left);
            return root.left;
        }
        //find the parent
        TreeNode current = root;
        
        while(true) {
            if(current == null) {
                break;
            }
            
            if(current.left !=null && current.left.val == key) {
                current.left = newChild(current.left);
                break;
            } else if(current.right != null && current.right.val == key) {
                current.right = newChild(current.right);
                break;
            } else if(key > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return root;
    }

    public TreeNode newChild(TreeNode root) {
        if(root.left ==null && root.right ==null) {
            return null;
        }
        if(root.left ==null) {
            return root.right;
        }
        if(root.right == null) {
            return root.left;
        }
        helper(root.right, root.left);
        return root.left;
    }

    public void helper(TreeNode nodeToAttach, TreeNode nodeToTravel) {
        if(nodeToTravel.right == null) {
            nodeToTravel.right = nodeToAttach;
            return;
        }
        helper(nodeToAttach,nodeToTravel.right);
    }
}
