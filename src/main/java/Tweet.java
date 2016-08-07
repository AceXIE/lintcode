/**
 * Created by Administrator on 2016/8/7.
 */
public class Tweet {
    public int id;
    public int user_id;
    public String text;
    public static Tweet create(int user_id, String tweet_text) {
        return new Tweet();
    }
}
