class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null; //here string is used to trace the words in a dict
}

class Solution {

    int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {

        //create the Trie and loop over the words and search for the words.. if found add it to the list

        TrieNode trieNode = buildTrie(words);
        List<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board,trieNode,i,j,result);
            }
        }
        return result;
    }


    public void dfs(char[][] board, TrieNode node, int r, int c, List<String> result) {
        //base conditions..
        if(r<0 || r>=board.length ||
            c<0 || c>=board[0].length) return;
        
        char ch = board[r][c];
        if(ch == '#') return; //already covered this cell
        int idx = ch - 'a';
        TrieNode next = node.children[idx];
        if(next == null) return;
        if(next.word!=null) {
            //end of the word reached..
            result.add(next.word);
            next.word = null; //avoid re-adding to the resultList
        }

        board[r][c] = '#';
        for(int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(board, next, nr, nc, result);
        }
        board[r][c] = ch;

    }

    /*
        Building Trie for words = ["cat", "car", "dog"]

            Step 1: Insert "cat"
            ────────────────────
            root
            └─ c
                └─ a
                    └─ t (word="cat") ✓

            Step 2: Insert "car"
            ────────────────────
            root
            └─ c
                └─ a
                    ├─ t (word="cat") ✓
                    └─ r (word="car") ✓

            Step 3: Insert "dog"
            ────────────────────
            root
            ├─ c
            │   └─ a
            │       ├─ t (word="cat") ✓
            │       └─ r (word="car") ✓
            │
            └─ d
                └─ o
                    └─ g (word="dog") ✓
    */
    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = word;
        }
        return root;
    }
}
