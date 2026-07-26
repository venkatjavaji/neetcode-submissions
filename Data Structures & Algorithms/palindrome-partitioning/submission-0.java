class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        backtracking(result,new ArrayList<>(),s,0);
        return result;
        
    }

    public void backtracking(List<List<String>> result, List<String> temp,String s, int idx) {

        if(idx == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=idx ;i<s.length(); i++) {
            
            if(!ispali(s.substring(idx,i+1))) continue;
            temp.add(s.substring(idx,i+1));
            backtracking(result,temp,s,i+1);
            temp.remove(temp.size()-1);
        }

    }

    public boolean ispali(String pal) {

        int i=0;
        int j= pal.length();
        while(i<j) {
            if(pal.charAt(i) == pal.charAt(j-1)) {
                i++;
                j--;
            }else {
                break;
            }
        }
        return i>=j;
        
    }
}
