class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //bruteforce approach
        int m = s1.length();
        int n = s2.length();

        if(m>n) return false;

        int[] s1f = new int[26];
        for(char c : s1.toCharArray()) {
            s1f[c-'a']++;
        }

        //check every contiguous window of size n in s2
        for(int i=0;i<=n-m;i++){
            int[] windowFre = new int[26];
            //j is starting from i
            for(int j=i;j<i+m;j++) {
                windowFre[s2.charAt(j)-'a']++;
            }
            if(Arrays.equals(s1f, windowFre)) {
                return true;
            }

        }
        return false;
    }
}
