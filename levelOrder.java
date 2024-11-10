class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()>0) {
            int sizeSnapshot = queue.size();
            List<Integer> row = new ArrayList<>(); 
            while(sizeSnapshot>0) {
                TreeNode current = queue.poll();
                row.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
                sizeSnapshot--;
            }
            res.add(row);
        }
        return res;
    }
}
