class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {

        //extract the number
        //substring from# to length by using the number
        List<String> result = new ArrayList<>();
        int length = str.length();
        int counter = 0;
        while(counter<length) {
            int j = counter;
            while(str.charAt(j)!='#') {
                j++;
            }
            int len = Integer.valueOf(str.substring(counter,j));
            counter = j+1;
            j = counter+len;
            String s = str.substring(counter,j);
            result.add(s);
            counter = j;
        }

        return result;
    }
}
