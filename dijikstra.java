import java.util.*;

public class Graph {

    Map<String, Map<String, Integer>> adjacencyList = new HashMap<>();

    public void add(String node) {
        adjacencyList.put(node, new HashMap<>());
    }

    public void addEdge(String node1, String node2, int weight) {
        adjacencyList.get(node1).put(node2, weight);
        adjacencyList.get(node2).put(node1, weight);
    }

    public void dijikstra(String source) {
        Map<String, Map<Integer, String>> distances = new HashMap<>();

        Set<String> visited = new HashSet<>();

        PriorityQueue<PriorityQueueNode> minHeap = new PriorityQueue<>(10, (a, b) -> a.weight - b.weight);

        minHeap.add(new PriorityQueueNode("A", "A", 0));

        while (minHeap.size() > 0) {
            PriorityQueueNode node = minHeap.poll();

            if (visited.contains(node.name)) {
                continue;
            }

            visited.add(node.name);
            distances.put(node.name, Map.of(node.weight, node.via));

            adjacencyList.get(node.name).forEach((key, value) -> {
                minHeap.add(new PriorityQueueNode(key, node.name, node.weight + value));
            });

        }

        System.out.println(distances);
    }
}

class PriorityQueueNode {
    String name;
    String via;
    int weight;

    PriorityQueueNode(String name, String via, int weight) {
        this.name = name;
        this.via = via;
        this.weight = weight;
    }
}
