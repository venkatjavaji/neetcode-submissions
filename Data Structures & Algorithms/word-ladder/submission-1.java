class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) return 0;
        Set<String> tempSet = new HashSet<>(wordList);

        //Level order - BF to count the number of words
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        //remove the begin word from tempset
        tempSet.remove(beginWord);

        //take the word from queue
        // change charcter by character and compare the new string with word
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int q=0;q<size;q++) {
                String current = queue.poll();
                if(current.equals(endWord)) return level;
                char[] ch = current.toCharArray();
                for(int i=0;i<current.length();i++) {
                     char old = ch[i];
                    for(char c='a';c<='z';c++) {
                        if(ch[i] == c) continue;
                        ch[i] = c;
                        String newStr = new String(ch);
                        if(tempSet.contains(newStr)) {
                            queue.offer(newStr);
                            tempSet.remove(newStr);
                        }
                    }
                    ch[i] = old;
                }
            }
            level++;
        }
            
        return 0;

    }
}
