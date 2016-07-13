import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by Administrator on 2016/7/13.
 */
public class strStr {
    public static void main(String[] args) {
        String source = "abcdabcdefg", target = "defg";
        System.out.print(strStr(source,target));
    }
    public static int strStr(String source, String target) {
        if (target == null) return source==null?0:-1;
        if (source == null) return -1;
        int len = source.length();
        int lenTarget = target.length();
        int res = -1;
        int i = 0, j = 0;
        for (i = 0; i <= len - lenTarget; i++) {
            String string = source.substring(i, i+lenTarget);
            if (string.equals(target)) {
                return i;
            }
        }
        return res;
    }
}
