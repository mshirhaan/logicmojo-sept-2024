class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][] = new int[n][n];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j < n; j++) {
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

        floyd(graph);

        int smallestCity = 0;
        int minCount = 999;

        for(int k = 0; k<n; k++) {
            int count = 0;
            for(int i = 0; i<n; i++) {
                if(i == k) continue;
                if(graph[k][i] <= distanceThreshold) {
                    count++;
                }
            }
            if(count <= minCount) {
                minCount = count;
                smallestCity = k;
            }
        }
        return smallestCity;
    }

    public void floyd(int graph[][]) {
        int V = graph.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if ((i != j) && (graph[i][j] > graph[i][k] + graph[k][j])) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
