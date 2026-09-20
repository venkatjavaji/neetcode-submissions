class TrieNode {
    TrieNode[] trie; // Array of 26 child nodes (a-z)
    boolean eow;// End of word flag

    public TrieNode() {
        trie = new TrieNode[26];
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
        // Traverse each character in the word
        for(char ch : word.toCharArray()) {
            int index = ch-'a';
            // Convert char to index (a=0, b=1, ... z=25)
            // If child node doesn't exist, create it
            if(null == cur.trie[index]) {
                TrieNode newNode = new TrieNode();
                cur.trie[index] = newNode;
            }
             // Move to the child node
            cur = cur.trie[index];
        }
        // Mark the end of this word
        cur.eow = true;
    }

    public boolean search(String word) {

        return dfs(word, root, 0); //start from index-0 with root-Node on the given word...
    }

    boolean dfs(String word,TrieNode cur, int word_index) {
        // Base case: if current node is null, path doesn't exist
        if(cur == null) return false;

// Base case: if we've processed all characters in the word
        if(word_index == word.length()) {
            return cur.eow; // if the length reached just return eow flag..
        }

        // search char by char
        char ch = word.charAt(word_index);
        if(ch == '.') {
           // Wildcard: '.' can match ANY single character (a-z)
            // Try all 26 possible children and see if any leads to a valid word
            // Example: search ".at" in trie with "cat", "bat", "rat"
            //   - Skip '.' and try all 26 letters: c, b, r, etc.
            //   - When we reach 'c', search for "at" from that node
            //   - If "at" exists under 'c', we found a match!
            for(TrieNode temp : cur.trie) {
                if(temp!=null && dfs(word, temp, word_index+1)) {
                    return true;
                }
            }
            return false;

        } else {
           // Regular character: follow the exact path in the trie
            int next_char_index = ch-'a';
            // Recursively search for the next character
            return dfs(word,cur.trie[next_char_index],word_index+1);
        }
    }
}

/**
 * Example Usage:
 * WordDictionary wd = new WordDictionary();
 * wd.addWord("bad");
 * wd.addWord("dad");
 * wd.addWord("mad");
 * 
 * wd.search("pad");     → false (no 'p' words)
 * wd.search("bad");     → true (exact match)
 * wd.search(".ad");     → true (matches "bad", "dad", "mad")
 * wd.search("b..");     → true (matches "bad")
 * wd.search("..d");     → true (matches "bad", "dad", "mad")
 * wd.search("b.d");     → true (matches "bad")
 * wd.search("b..");     → true (matches "bad")
 
 +++++++++++++++++++++++
search(".at") in trie["cat", "bat", "rat", "sat"]

dfs(".at", root, 0)
  ch = '.'
  → Try ALL 26 children from root:
    → dfs("at", node_c, 1)     → Search for "at" under 'c'
       dfs("t", node_a, 2)     → Search for "t" under 'a'
         dfs("", node_t, 3)    → Length reached, return node_t.eow = true ✓
    → dfs("at", node_b, 1)     → Search for "at" under 'b'
       Similar path → true ✓
    → dfs("at", node_r, 1)     → Search for "at" under 'r'
       Similar path → true ✓
    → dfs("at", node_s, 1)     → Search for "at" under 's'
       Similar path → true ✓
  
Return true (found at least one match)



**/