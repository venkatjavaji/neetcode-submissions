class Solution {
    public boolean isIsomorphic(String s, String t) {

        //frequency count?
        //length of the string should be equal
        // frequency counts should match
        int sl = s.length();
        int tl = t.length();
        if(sl != tl )return false;

        int[] smap = new int[256];
        int[] tmap = new int[256];
       
       for(int i=0; i<sl; i++) {
            char chars = s.charAt(i);
            char chart = t.charAt(i);
            
            if(smap[chars] != tmap[chart]) return false;
            smap[chars] = i+1;
            tmap[chart] = i+1;

            
       }

        return true;
        
    }
}