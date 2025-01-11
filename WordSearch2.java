import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        s.findWords(new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" });

    }

}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();

        Node curr = t.root;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, curr, i, j, visited);
            }
        }

        return null;
    }

    public void dfs(char[][] board, Node curr, int i, int j, boolean[][] visited) {
        if (visited[i][i]) {
            return;
        }
        visited[i][j] = true;
        int index = board[i][j] - 97;
        if (curr.bucket[index] == null) {
            curr.bucket[index] = new Node();
        }
        curr = curr.bucket[index];
        curr.isWord = true;

        int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        for (int it = 0; it < directions.length; it++) {
            int rowAddition = directions[it][0];
            int colAddition = directions[it][1];

            int nextI = it + rowAddition;
            int nextJ = it + colAddition;

            if (nextI < 0 || nextI >= board.length || nextJ < 0 || nextJ >= board[0].length) {
                continue;
            }

            dfs(board, curr, nextI, nextJ, visited);
        }
    }
}

class Node {
    Node[] bucket = new Node[26];
    boolean isWord = false;
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            if (curr.bucket[index] == null) {
                curr.bucket[index] = new Node();
            }
            curr = curr.bucket[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            if (curr.bucket[index] == null) {
                return false;
            }
            curr = curr.bucket[index];
        }
        if (curr.isWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            if (curr.bucket[index] == null) {
                return false;
            }
            curr = curr.bucket[index];
        }
        return true;
    }
}
