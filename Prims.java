public class Solution {
    
    public int minimumCost(int n, int[][] edges) {

        int graph[][] = new int[n+1][n+1];

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 99999;
            }
        }

        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            graph[from][to] = weight;
            graph[to][from] = weight;
        }


        int[] visited = new int[n+1];
        int cost = 0;

        PriorityQueue<PriorityQueueNode> minHeap = new PriorityQueue<>(10, (a, b) -> a.weight - b.weight);

       
        minHeap.add(new PriorityQueueNode(1, 1, 0));

        while (minHeap.size() > 0) {
            PriorityQueueNode node = minHeap.poll();
            if (visited[node.to] == 1) {
                continue;
            }
            visited[node.to] = 1;
            cost+= node.weight;

            for(int i = 1; i<=n; i++) {
                if(graph[node.to][i] != 99999) {
                    minHeap.add(new PriorityQueueNode(node.to, i, graph[node.to][i]));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) return -1;
        }

        return cost;
    }
}

class PriorityQueueNode {
    int from;
    int to;
    int weight;

    PriorityQueueNode(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
