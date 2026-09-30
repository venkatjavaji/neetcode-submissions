class Solution {
    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for(String e : emails) {
            String s1 = e.substring(0,e.indexOf('@'));
            if(s1.contains("+")) {
                s1 = s1.substring(0,s1.indexOf('+'));
            }
            set.add(s1.replace(".","") + e.substring(e.indexOf('@')));
        }
        return set.size();
        
    }
}