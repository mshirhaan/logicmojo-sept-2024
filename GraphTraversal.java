import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

    Map<String, Set<String>> adjacencyList = new HashMap<>();

    public void signUp(String username) {
        adjacencyList.put(username, new HashSet<>());
    }

    public void connect(String username1, String username2) {
        adjacencyList.get(username1).add(username2);
        adjacencyList.get(username2).add(username1);
    }

    public void disconnect(String username1, String username2) {
        adjacencyList.get(username1).remove(username2);
        adjacencyList.get(username2).remove(username1);
    }

    public void deactivate(String username) {
        adjacencyList.remove(username);
        for (Set<String> connections : adjacencyList.values()) {
            connections.remove(username);
        }
    }

    public void bfs(String username) {
        Queue<String> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();
        visited.add(username);
        queue.add(username);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            System.out.println(current);
            for (String neighbor : adjacencyList.get(current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }

    public void dfs(String username) {
        helper(username, new HashSet<>());
    }

    private void helper(String username, Set<String> visited) {
        System.out.println(username);
        visited.add(username);
        for (String neighbor : adjacencyList.get(username)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            helper(neighbor, visited);
        }
    }
}
