class Solution {
    // Function to return a list containing vertices in Topological order.
    topologicalSort(adj) {
        const ans = [];
        const visited = new Set();
        
        function dfs(node) {
            for (let i = 0; i < adj.length; i++) {
                const neighbours = adj[i];
    
                for (const neigh of neighbours) {
                    if(visited.has(neigh)) {
                        continue;
                    }
                    dfs(neigh);
                }
                visited.add(i);
                ans.push(i);
            }
        }
        
        dfs(0);
        return ans;
    }

    
}
