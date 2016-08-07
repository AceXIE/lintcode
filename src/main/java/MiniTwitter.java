import java.util.*;

/**
 * Created by Administrator on 2016/8/7.
 */
public class MiniTwitter {
    public static void main(String[] args) {
        MiniTwitter m = new MiniTwitter();
        m.postTweet(1,"xk");
        System.out.println(m.getNewsFeed(1));
    }
    class Node {
        public int order;
        public Tweet tweet;

        public Node(int order, Tweet tweet) {
            this.order = order;
            this.tweet = tweet;
        }
    }
    class sortByOrder implements Comparator {
        public int compare(Object o1, Object o2) {
            Node n1 = (Node)o1;
            Node n2 = (Node)o2;
            if (n1.order > n2.order) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    private Map<Integer, HashMap<Integer, Boolean>> friends;
    private Map<Integer, ArrayList<Node>> users_tweets;
    private int order;
    public List<Node> getLastTen(List<Node> temp) {
        int last = Math.min(10, temp.size());
        return temp.subList(temp.size() - last, temp.size());
    }
    public List<Node> getFirstTen(List<Node> temp) {
        int last = Math.min(10, temp.size());
        return temp.subList(0, last);
    }
    public MiniTwitter() {
        this.friends = new HashMap<>();
        this.users_tweets = new HashMap<>();
        this.order = 0;
    }

    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!users_tweets.containsKey(user_id)) {
            users_tweets.put(user_id, new ArrayList<>());
        }
        this.order++;
        users_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }
    public List<Tweet> getNewsFeed(int user_id) {
        List<Node> temp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            temp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        if (friends.containsKey(user_id)) {
            for (Integer t : friends.get(user_id).keySet()) {
                if (users_tweets.containsKey(t)) {
                    temp.addAll(getLastTen(users_tweets.get(t)));
                }
            }
        }
        Collections.sort(temp, new sortByOrder());
        temp = getFirstTen(temp);
        List<Tweet> res = new ArrayList<>();
        for (Node node : temp) {
            res.add(node.tweet);
        }
        return res;
    }
    public List<Tweet> getTimeline(int user_id) {
        List<Node> temp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            temp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        Collections.sort(temp, new sortByOrder());
        List<Tweet> res = new ArrayList<>();
        temp = getFirstTen(temp);
        for (Node node : temp) {
            res.add(node.tweet);
        }
        return res;
    }
    public void follow(int from_user_id, int to_user_id) {
        if (!friends.containsKey(from_user_id)) {
            friends.put(from_user_id, new HashMap<>());
        }
        friends.get(from_user_id).put(to_user_id, true);
    }
    public void unfollow(int from_user_id, int to_user_id) {
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}
