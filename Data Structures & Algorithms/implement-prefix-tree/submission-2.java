
class TrieNode {
    TrieNode[] children;
    boolean eow;

    public TrieNode() {
        children = new TrieNode[26]; //size of alphabets
        eow = false;
    }
}
class PrefixTree {
    
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int index = c-'a';
            if(cur.children[index]==null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.eow = true; //end of the word
    }

    public boolean search(String word) {
            TrieNode searchNode = searchNode(word);
            return searchNode!=null && searchNode.eow;
    }

    public boolean startsWith(String prefix) {
        TrieNode searchNode = searchNode(prefix);
        return searchNode!=null;
    }

    public TrieNode searchNode(String word) {
        TrieNode cur = root;

        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(null!= cur.children[idx]) {
                cur = cur.children[idx];
            } else {
                return null;
            }
        }
        return cur;
    }
}
