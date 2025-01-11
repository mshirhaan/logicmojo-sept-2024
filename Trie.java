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
        for(int i = 0; i<word.length(); i++) {
            int index = word.charAt(i) - 97;
            if(curr.bucket[index] == null) {
                curr.bucket[index] = new Node();
            } 
            curr = curr.bucket[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i<word.length(); i++) {
            int index = word.charAt(i) - 97;
            if(curr.bucket[index] == null) {
                return false;
            } 
            curr = curr.bucket[index];
        }
        if(curr.isWord) {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String word) {
        Node curr = root;
        for(int i = 0; i<word.length(); i++) {
            int index = word.charAt(i) - 97;
            if(curr.bucket[index] == null) {
                return false;
            } 
            curr = curr.bucket[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
