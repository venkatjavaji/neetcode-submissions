class TrieNode {
    TrieNode[] children;
    boolean eow;

    public TrieNode(){
        children = new TrieNode[26];
        eow = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(cur.children[idx]==null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx]; // move current to child-node of the root and so-on
        }
        cur.eow = true;
    }

    public boolean search(String word) {
        return dfs(word,root,0);

    }

    public boolean dfs(String word, TrieNode node, int idx) {
        if(node == null) return false; //path is ended/ word is not found

        if(idx == word.length()) {
            return node.eow;
        }

        char ch = word.charAt(idx);  
        if(ch == '.') {
            //try all the child node possibilities
            for(TrieNode temp : node.children) {
                if(temp!=null && dfs(word, temp, idx+1)) {
                    return true;
                }
            }
            return false;

        } else {
            int index = ch-'a';
            //pass the next child-node and increment the index 
            return dfs(word,node.children[index],idx+1);
        }
        
    }
}
