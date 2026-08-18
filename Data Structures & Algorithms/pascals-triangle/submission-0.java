class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=0;j<i;j++) {
                if(j>0 && i>=2) {
                    int ele = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    row.add(ele);
                }
            }
            if(i!=0) row.add(1);
            result.add(row);
        }
        return result;
    }
}