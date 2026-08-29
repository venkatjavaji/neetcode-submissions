class Solution {
    public String longestCommonPrefix(String[] strs) {
        //find the shortest
        int min = Integer.MAX_VALUE;

        for(String s : strs) {
            min = Math.min(min, s.length());
        }

            StringBuilder result = new StringBuilder();
            for(int j=0;j<min;j++) {
                char c = strs[0].charAt(j);
                for(int i=1;i<strs.length;i++) {
                    if(strs[i].charAt(j)!=c) {
                            return result.toString();
                    }
                }
                result.append(c);
            }

            return result.toString();
        
    }
}