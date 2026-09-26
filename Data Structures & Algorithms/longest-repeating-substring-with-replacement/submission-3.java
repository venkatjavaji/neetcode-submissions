class Solution {
    public int characterReplacement(String s, int k) {
        //this is implemented using char array... instead of hash_map
        int[] char_count = new int[26];
        int left = 0;
        int max_freq = 0;
        int best = 0;

        for(int r = 0; r<s.length();r++) {
            char ch = s.charAt(r);
            char_count[ch-'A']++;
            max_freq = Math.max(max_freq, char_count[ch-'A']);
            while((r - left + 1) - max_freq > k) {
                char_count[s.charAt(left)-'A']--;
                left++;
            }
            best = Math.max(best, (r - left + 1));
        }
        return best;
    }
}
/**
Input: s = "AABABBA", k = 1 → expected output 4

index:  0 1 2 3 4 5 6
char:   A A B A B B A
right	char	counts (A,B)	maxFreq	window before shrink	replacements needed	shrink?	window after	best
0	A	1, 0	1	[0..0] A	1−1 = 0	no	[0..0]	1
1	A	2, 0	2	[0..1] AA	2−2 = 0	no	[0..1]	2
2	B	2, 1	2	[0..2] AAB	3−2 = 1	no	[0..2]	3
3	A	3, 1	3	[0..3] AABA	4−3 = 1	no	[0..3]	4
4	B	3, 2	3	[0..4] AABAB	5−3 = 2 > 1	drop A@0 → (2,2), left=1	[1..4] ABAB	4
5	B	2, 3	3	[1..5] ABABB	5−3 = 2 > 1	drop A@1 → (1,3), left=2	[2..5] BABB	4
6	A	2, 3	3	[2..6] BABBA	5−3 = 2 > 1	drop B@2 → (2,2), left=3	[3..6] ABBA	4

Result: 4, for example AABA → AAAA or BABB → BBBB.
**/