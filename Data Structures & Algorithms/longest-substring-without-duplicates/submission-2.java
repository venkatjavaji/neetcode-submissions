class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right<s.length(); right++) {

            while(!set.add(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}

/*
 * DRY RUN — s = "abcabcbb"
 * Initial: max=0, left=0, set={}
 *
 * right=0, c='a'
 *   set.add('a') -> true (no dup) -> set={a}
 *   window = [0,0] = "a", size = 0-0+1 = 1
 *   max = max(0,1) = 1
 *
 * right=1, c='b'
 *   set.add('b') -> true -> set={a,b}
 *   window = [0,1] = "ab", size = 1-0+1 = 2
 *   max = max(1,2) = 2
 *
 * right=2, c='c'
 *   set.add('c') -> true -> set={a,b,c}
 *   window = [0,2] = "abc", size = 2-0+1 = 3
 *   max = max(2,3) = 3
 *
 * right=3, c='a'
 *   set.add('a') -> FALSE (dup!) -> enter while loop
 *     remove s.charAt(left=0)='a' -> set={b,c}, left=1
 *     retry set.add('a') -> true -> set={b,c,a}
 *   window = [1,3] = "bca", size = 3-1+1 = 3
 *   max = max(3,3) = 3
 *
 * right=4, c='b'
 *   set.add('b') -> FALSE (dup!) -> enter while loop
 *     remove s.charAt(left=1)='b' -> set={c,a}, left=2
 *     retry set.add('b') -> true -> set={c,a,b}
 *   window = [2,4] = "cab", size = 4-2+1 = 3
 *   max = max(3,3) = 3
 *
 * right=5, c='c'
 *   set.add('c') -> FALSE (dup!) -> enter while loop
 *     remove s.charAt(left=2)='c' -> set={a,b}, left=3
 *     retry set.add('c') -> true -> set={a,b,c}
 *   window = [3,5] = "abc", size = 5-3+1 = 3
 *   max = max(3,3) = 3
 *
 * right=6, c='b'
 *   set.add('b') -> FALSE (dup!) -> enter while loop
 *     remove s.charAt(left=3)='a' -> set={b,c}, left=4
 *     retry set.add('b') -> FALSE (still dup, 'b' still in set!) -> loop again
 *     remove s.charAt(left=4)='b' -> set={c}, left=5
 *     retry set.add('b') -> true -> set={c,b}
 *   window = [5,6] = "cb", size = 6-5+1 = 2
 *   max = max(3,2) = 3
 *
 * right=7, c='b'
 *   set.add('b') -> FALSE (dup!) -> enter while loop
 *     remove s.charAt(left=5)='c' -> set={b}, left=6
 *     retry set.add('b') -> FALSE (still dup) -> loop again
 *     remove s.charAt(left=6)='b' -> set={}, left=7
 *     retry set.add('b') -> true -> set={b}
 *   window = [7,7] = "b", size = 7-7+1 = 1
 *   max = max(3,1) = 3
 *
 * FINAL RESULT: 3   (the substring "abc")
 */
