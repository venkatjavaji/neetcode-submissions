class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        // count how many of each char t needs
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }

        int left=0;
        int baseLeft = 0;
        int baseLength = Integer.MAX_VALUE; // smallest valid window found so far
        Map<Character,Integer> window = new HashMap<>();
        for(int right=0;right<s.length();right++) {
            char sc = s.charAt(right);
            window.put(sc, window.getOrDefault(sc,0)+1); // expand window
            // window has everything t needs — try shrinking from the left
            while(compareFrequency(window,need)) {
                // record this window if it's smaller than the best found so far
                if(right-left+1 < baseLength) {
                    baseLength = right-left+1;
                    baseLeft = left;
                }
                
                char leftMostChar =s.charAt(left);
                // remove leftmost char and move left forward
                window.put(leftMostChar, window.get(leftMostChar)-1);
                left++;
            }
        }
        // if baseLength never changed, no valid window was found — return empty string;
        // otherwise extract the smallest valid window using its start index and length
        return baseLength == Integer.MAX_VALUE ? "" : s.substring(baseLeft, baseLeft+baseLength);
    }

    public boolean compareFrequency(Map<Character,Integer> window, Map<Character,Integer> need) {
        //compare the character count of Target string with the window string
        for(Map.Entry<Character,Integer> entry : need.entrySet()) {
           char c = entry.getKey();
           int requiredCount = entry.getValue();
           if(window.getOrDefault(c,0) < requiredCount) {
            return false;
           }
        }
        return true;
    }
}
