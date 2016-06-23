/**
 * Created by Administrator on 2016/6/23.
 */
public class CountandSay {
    public static void main(String[] args) {
        int n = 6;//314241
        System.out.print(conutAndSay(n));
    }
    public static String conutAndSay(int n) {
        if (n <= 0) return new String();
        String say = "1";
        for (int i = 1; i < n; i++) {
            say = helper(say);
        }
        return say;
    }
    public static String helper(String say) {
        char last = say.charAt(0);
        int cnt = 0;
        say = say + '/';
        String res = "";
        for (int i = 0; i < say.length(); i++) {
            if (say.charAt(i) == last) {
                cnt++;
            } else {
                res = res + cnt;
                res = res + last;
                last = say.charAt(i);
                cnt=1;
            }
        }

        return res;
    }
}
