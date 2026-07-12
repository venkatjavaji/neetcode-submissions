class Solution {
    public boolean isPalindrome(String s) {

        String news = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        System.out.println(news);

        int lc = 0;
        int rc = news.length()-1;
        while(lc<rc) {
            if(news.charAt(lc) == news.charAt(rc)) {
                lc++;
                rc--;
            } else {
                return false;
            }
        }
        return true;
        
    }
}
