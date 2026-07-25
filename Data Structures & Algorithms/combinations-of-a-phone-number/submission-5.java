class Solution {

    private static String[] mapping = new String[] {
        "" ,"" ,"abc" ,"def", "ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length()<=0) return result;

        char[] ch = digits.toCharArray();
        String[] inputs = new String[ch.length];
        int counter = 0;
        for(char c : ch) {
            Integer index = Integer.valueOf(c-'0');
            inputs[counter++] = mapping[index];
        }

    if(inputs!=null) {

        if(inputs.length ==1) {
            for(int i=0;i<inputs[0].length();i++) {
                 String temp = "" + inputs[0].charAt(i);
                    result.add(temp);
            }
        }   else if(inputs.length==2){
            for(int i=0;i<inputs[0].length();i++) {
                for(int j=0;j<inputs[1].length();j++) {
                    String temp = "" + inputs[0].charAt(i) + inputs[1].charAt(j);
                    result.add(temp);
                }
            }
        } else if(inputs.length==3){
            for(int i=0;i<inputs[0].length();i++) {
                for(int j=0;j<inputs[1].length();j++) {
                    for(int k=0;k<inputs[2].length();k++) {
                    String temp = "" + inputs[0].charAt(i) + inputs[1].charAt(j) + inputs[2].charAt(k);
                    result.add(temp);
                    }
                   
                }
            }
        }else {
            for(int i=0;i<inputs[0].length();i++) {
                for(int j=0;j<inputs[1].length();j++) {
                    for(int k =0;k<inputs[2].length();k++) {
                        for(int l=0;l<inputs[3].length();l++) {
                              String temp = "" + inputs[0].charAt(i) + inputs[1].charAt(j) + inputs[2].charAt(k) + inputs[3].charAt(l);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        
    }
        return result;
    }
}
