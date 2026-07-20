class TimeStampValue {
    String val;
    int timestamp;
    public TimeStampValue(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, List<TimeStampValue>> map;

    public TimeMap() {
         this.map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, val -> new ArrayList<>());
        map.get(key).add(new TimeStampValue(value,timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)) return "";

        List<TimeStampValue> list = map.get(key);

        return binarySearch(list, timestamp);

    }

    public String binarySearch(List<TimeStampValue> list, int target) {
        int left = 0;
        int right = list.size()-1;
        int index = -1;
        while(left <= right) {
            int mid = left + (right-left)/2 ;
            TimeStampValue ts = list.get(mid);
            if(ts.timestamp <= target) {
                    //value is on the right side;
                    left = mid+1;
                    index = mid;
            } else {
                right = mid-1;
            }
        }
        return index!=-1 ? list.get(index).val : "";
    }
}
