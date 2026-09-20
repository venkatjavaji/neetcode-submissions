class Twitter {
    //This implementation is without using the priorityQueue
    Map<Integer,List<int[]>> tweet; //userId -> [timestamp, tweetId]
    Map<Integer, Set<Integer>> following; //userId -> [following]
    Integer timestamp;

    public Twitter() {
        tweet = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        //user is posting a tweet.. 
        //need to save the tweet in the tweet map
        tweet.computeIfAbsent(userId, t -> new ArrayList<>());
        tweet.get(userId).add(new int[]{timestamp++, tweetId});
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //app needs to fetch the newsFeed for the user
        // need to fetch the feed from the following List
        //sort the newsFeed based on the timestamp
        // add to the list

        List<int[]> allTweets = new ArrayList<>();
        //add the user tweets..
        allTweets.addAll(tweet.getOrDefault(userId,new ArrayList<>()));
        //add the followee tweets
        for(int followee : following.getOrDefault(userId, new HashSet<>())) {
            allTweets.addAll(tweet.getOrDefault(followee, new ArrayList<>()));
        }
        //sort the tweets based on the timestamp
        //newer one gets on top..
        allTweets.sort((a,b) -> b[0]-a[0]);
        List<Integer> feeds = new ArrayList<>();
        for(int i=0; i<Math.min(allTweets.size(), 10); i++) {
            int[] latest_tweet = allTweets.get(i);
            feeds.add(latest_tweet[1]);
        }
        return feeds;

    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, h -> new HashSet<>()).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = following.get(followerId);
        if(null!=followees) following.get(followerId).remove(followeeId);
        
    }
}
