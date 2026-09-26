class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
//pwwkew
/*
    r=0
    set(p) -> true 
    w = 0, (0-0+1) max=1

    r=1
    set(w) -> true => {p,w}
    w = [1-0+1] (1,2) max=2

    r=2, l=0
    set(w) -> false => set.remov(p) => {w}, l=1
            -> false => set.remove(w) => {}, l=2
            -> true => set => {w}

            max = {2, 2-2+1} => 2
    r=3, l=2
    set(k) => true => {w,k}
            max = {2, 3-2+1} => 2
    r=4, l=2
    set(e) => true => {w,k,e}
            max = {2, 4-2+1} =>3
    
    4=5, l=2
    set(w) => false => set.remove(2) => {k,e}
            left = 3
            => true 
            max = {3, 5-3+1} => 3

        return 3..
*/
        for(int right=0;right<s.length();right++) {

            while(!set.add(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
        
    }
}
