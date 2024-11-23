let n1 = {val:1};
let n2 = {val:2};
let n3 = {val:3};
let n4 = {val:4};
let n5 = {val:5};
let n6 = {val: 6};
let n7 = {val: 7}

n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5
n3.left = n6;
n3.right = n7;

function topView(root) {
    return bfs(root);


    function bfs(root) {
        let map = {};
        
        let queue = [{node: root, x: 0}]
        while(queue.length) {
            let curr = queue.shift();
            if(!map[curr.x]) {
                map[curr.x] = curr.node.val;
            }
            if(curr.node.left) {
                queue.push({node: curr.node.left, x: curr.x-1});
            }
            if(curr.node.right) {
                queue.push({node: curr.node.right, x: curr.x+1});
            }
   
        }
        return map;
    }
}

topView(n1)

    



===========java
import java.util.*;
import javafx.util.Pair;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        Map<Integer, Integer> topViewMap = topView(n1);
        System.out.println(topViewMap);
    }

    public static Map<Integer, Integer> topView(TreeNode root) {
        return bfs(root);
    }

    private static Map<Integer, Integer> bfs(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode node = curr.getKey();
            int x = curr.getValue();

            if (!map.containsKey(x)) {
                map.put(x, node.val);
            }
            if (node.left != null) {
                queue.add(new Pair<>(node.left, x - 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, x + 1));
            }
        }
        return map;
    }
}
