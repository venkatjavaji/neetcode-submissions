class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        int levels = 1;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);

        while(!queue.isEmpty()) {
            int loop = queue.size();
            //iterate over the queue size
            for(int i=0;i<loop;i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) return levels;
                char[] ch = cur.toCharArray();
                for(int j=0;j<ch.length;j++) {
                    // replace every jth position char
                    char original = ch[j];
                    for(char c = 'a'; c<='z';c++) {
                        if(c == original) continue;
                        ch[j] = c;
                        String t = new String(ch);
                        if(wordSet.contains(t)) {
                            queue.offer(t);
                            wordSet.remove(t);
                        }
                    }
                    ch[j]= original;
                }  
            }
            levels++;
        }
        return 0;
    }
}