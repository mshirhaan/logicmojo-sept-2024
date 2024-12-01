class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node);
    }

    public Node dfs(Node node) {
        return helper(node, new HashMap<>());
    }

    private Node helper(Node node, Map<Node, Node> map) {
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
           
            Node cloneNeighbor = helper(neighbor, map);
            cloneNode.neighbors.add(cloneNeighbor);
        }
        return cloneNode;
    }
}
