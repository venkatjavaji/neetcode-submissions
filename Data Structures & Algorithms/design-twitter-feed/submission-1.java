class Twitter {

    class Tweet {
        int tweetId;
        int timestamp;
        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    class User {
        int userId;
        List<Tweet> tweets;
        Set<Integer> following;
        public User(int userId) {
            this.userId = userId;
            this.tweets = new ArrayList<>();
            this.following = new HashSet<>();
        }
    }

    Map<Integer,User> usermap;
    int timestamp;

    public Twitter() {
        usermap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = usermap.computeIfAbsent(userId, u -> new User(userId));
        user.tweets.add(new Tweet(tweetId, timestamp++));    
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        //add self tweets and followers tweets
        User user = usermap.get(userId);
        if(user == null) return feed; //return empty list if the user is null

        //gather the people whose tweet should appear
        Set<Integer> people = new HashSet<>(user.following);
        people.add(userId); //add self Id
        //max-heap ordered by timestamp!! seed with most recent tweet!!
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int personId : people) {
            User currentuser = usermap.get(personId);
            if(currentuser == null || currentuser.tweets.isEmpty()) continue;
            int lastIndex = currentuser.tweets.size()-1;
            Tweet t = currentuser.tweets.get(lastIndex); //get the last tweet by the user
            maxHeap.offer(new int[]{t.timestamp, t.tweetId, personId, lastIndex});
        }

        while(!maxHeap.isEmpty() && feed.size() < 10) {
            int[] top = maxHeap.poll();
            feed.add(top[1]); //adding the tweetId to the feed List

            int pid = top[2]; //get the personId
            int lidx = top[3]; // get the lastIndex
            if(lidx>0) {
                //there are tweets available
                User sameUser = usermap.get(pid);
                Tweet next = sameUser.tweets.get(lidx-1); 
                maxHeap.offer(new int[]{next.timestamp, next.tweetId, pid, lidx-1});
            }
        }

        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        User follower = usermap.computeIfAbsent(followerId, u -> new User(followerId));
        usermap.computeIfAbsent(followeeId, u -> new User(followeeId));
        follower.following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        User follower = usermap.get(followerId);
        if (follower != null) follower.following.remove(followeeId);
    }
}
