class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }

        int left=0;
        int baseLeft = 0;
        int baseLength = Integer.MAX_VALUE;
        Map<Character,Integer> window = new HashMap<>();
        for(int right=0;right<s.length();right++) {
            char sc = s.charAt(right);
            window.put(sc, window.getOrDefault(sc,0)+1);
            while(compareFrequency(window,need)) {
                // shrink the window-string
                if(right-left+1 < baseLength) {
                    baseLength = right-left+1;
                    baseLeft = left;
                }

                char leftMostChar =s.charAt(left);
                window.put(leftMostChar, window.get(leftMostChar)-1);
                left++;
            }
        }
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
