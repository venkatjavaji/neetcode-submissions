class Solution {
    public int longestConsecutive(int[] nums) {

        
        Set<Integer> setNum = new TreeSet<>();

        for(int n : nums) {
            setNum.add(n);
        }
        System.out.println(setNum);
        int[] inca = new int[setNum.size()];
        int c = 0;
        for(Integer i : setNum) {
            inca[c++] = i;
        }

        if(inca.length==1) return 1;
        int maxL = 1;
        int longest = 0;
        for(int j=0;j<inca.length-1;j++) {
            if(inca[j] == inca[j+1]-1) {
                maxL++;
            } else {
                maxL = 1;
            }
            System.out.println("Number :" +inca[j] + " maxL : "+ maxL);
            longest = Math.max(longest, maxL);
        }
        
        return longest;

        
    }
}
