class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        char[] c1 = new char[26];
        for(char ch : s1.toCharArray()) {
            c1[ch - 'a']++;
        }

        for(int i=0;i<=s2.length()-s1.length();i++) {
            String sub = s2.substring(i, i+s1.length());
            char[] c2 = new char[26];
            for(char ch : sub.toCharArray()){
                c2[ch - 'a']++;
            }
            if(Arrays.equals(c2, c1)) {
                return true;
            }
        }
        return false;
    }
}
