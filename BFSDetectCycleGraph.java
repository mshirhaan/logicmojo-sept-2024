//My code which passed only 37 TC
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        return bfs(adj, 0);
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adjacencyList, Integer startNode) {
        Queue<Pair> queue = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();
        visited.add(startNode);
        queue.add(new Pair(startNode, -1));

        while(visited.size() < adjacencyList.size()) {
            while (!queue.isEmpty()) {
                Pair current = queue.remove();
    
               
                for (Integer neighbor : adjacencyList.get(current.node)) {
                    if (visited.contains(neighbor)) {
                        if(current.parent != neighbor) {
                            return true;
                        }
                        continue;
                    }
                    visited.add(neighbor);
                    queue.add(new Pair(neighbor, current.node));
                }
            }
            for(int i =0;i<adjacencyList.size(); i++) {
                if(!visited.contains(i)) {
                     queue.add(new Pair(i, -1));
                      visited.add(i);
                     break;
                }
            }
        }
        return false;
    }
}

class Pair {
    Integer node;
    Integer parent;
    
    Pair(Integer node, Integer parent) {
        this.node = node;
        this.parent = parent;
    }
}


//GPT code
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); // Number of vertices
        boolean[] visited = new boolean[V]; // To track visited nodes
        
        // Loop through all vertices to handle disconnected graphs
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If any component has a cycle, return true
                if (bfsCheckCycle(adj, i, visited)) {
                    return true;
                }
            }
        }
        return false; // No cycle found in any component
    }
    
    // BFS function to detect cycle in a graph
    private boolean bfsCheckCycle(ArrayList<ArrayList<Integer>> adj, int startNode, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(new Pair(startNode, -1)); // Add the starting node with a parent of -1
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int parent = current.parent;

            // Traverse all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair(neighbor, node)); // Add neighbor with current node as its parent
                } else if (neighbor != parent) {
                    // If visited and not the parent, cycle is detected
                    return true;
                }
            }
        }
        return false; // No cycle detected in this component
    }
}

// Pair class to store node and its parent
class Pair {
    int node;
    int parent;
    
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}
