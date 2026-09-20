//identify how to implement Trie is the main thing..
//I'm going to use ListNode and each node length is 26

class TrieNode {
    TrieNode[] trie;
    boolean eow;

    public TrieNode() {
        trie = new TrieNode[26]; // every TrieNode has 26 child nodes
        eow = false;
    }
}

class PrefixTree {

    TrieNode trieNode;
    public PrefixTree() {
        trieNode = new TrieNode();
    }

    public void insert(String word) {
        // while inserting.. break the word in to characters
        // see if the character node already present.. traverse to the next until you see character is not present..
        TrieNode cur = trieNode;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if(cur.trie[i] == null) {
                TrieNode newNode = new TrieNode();
                cur.trie[i] = newNode;
            }
            cur = cur.trie[i]; //pointing to next trie like in ListNode
        }
        cur.eow = true;

    }

    public boolean search(String word) {

       TrieNode searchNode = searchNode(word);
       return null!=searchNode && searchNode.eow;

    }

    public boolean startsWith(String prefix) {
        TrieNode searchNode = searchNode(prefix);
        return null!=searchNode;
    }

    //traverse the trieNode
    public TrieNode searchNode(String search) {
        TrieNode cur = trieNode;
        for(char ch : search.toCharArray()) {
            int index = ch - 'a';
            if(cur.trie[index]!=null) {
                cur = cur.trie[index]; // pointing to next Node..
            } else {
                return null;
            }
        }
        return cur;
    }
}
