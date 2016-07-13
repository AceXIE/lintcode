/**
 * Created by Administrator on 2016/7/13.
 */
public class SpaceReplacement {
    public static void main(String[] args) {
        String s = "hello world";//"Mr John Smith";
        int length = 11;
        char[] string = new char[length];
        string = s.toCharArray();
        System.out.print(replaceBlank(string, 11));
    }
    public static int replaceBlank(char[] string, int length) {
        if (string == null || string.length == 0) return 0;
        int rlen = length;
        for (int i = 0; i < length; i++) {
            char c = string[i];
            if (c == ' ') {
                rlen +=2;
            }
        }
        int index = rlen;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[--index] = '0';
                string[--index] = '2';
                string[--index] = '%';
            } else {
                string[--index] = string[i];
            }
        }
        return rlen;
    }
}
