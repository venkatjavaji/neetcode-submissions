class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null; 
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //using  Tries and DFS
        TrieNode root = buildTrieNode(words);
        List<String> result = new ArrayList<>();
         int col = board[0].length;
         int row = board.length;
         for(int i=0; i< row; i++) {
            for(int j=0;j<col;j++) {
                dfs(board,i,j,root,result);
            }
         }
         return result;

    }

    public TrieNode buildTrieNode(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode cur = root;
            for(char ch : w.toCharArray()) {
                int idx = ch-'a';
                if(cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.word = w;
        }
        return root;
    }


    public void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if(row<0 || row>=board.length ||
            col<0 || col>=board[0].length
            ) return;

        char ch = board[row][col];
        if(ch == '#') return; //already covered!!
        int idx = ch - 'a';
        TrieNode next = node.children[idx];
        if(next == null) return; //not found..

        if(next.word!=null) {
            result.add(next.word);
            next.word = null; //avoid adding the same word twice if the board has multiple paths for the same word
        }

        board[row][col] = '#';
        dfs(board,row+1,col,next,result);
        dfs(board,row-1,col,next,result);
        dfs(board,row,col+1,next,result);
        dfs(board,row,col-1,next,result);
        board[row][col] = ch; //restore the char


    }
}
