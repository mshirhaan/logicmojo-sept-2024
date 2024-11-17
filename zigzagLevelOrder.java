class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = levelOrder(root);
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while(queue.size()>0) {
            int sizeSnapshot = queue.size();
            Deque<Integer> row = new ArrayDeque<>();
            while(sizeSnapshot>0) {
                TreeNode current = queue.poll();
                if(!reverse) {
                    row.addLast(current.val);
                } else {
                    row.addFirst(current.val);
                }
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
                sizeSnapshot--;
            }
            reverse = !reverse;
            res.add(new ArrayList(row));
        }
        return res;
    }
}
