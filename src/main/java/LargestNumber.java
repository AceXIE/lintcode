import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2016/8/5.
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] num = {0,0,0,0,0};//{1, 20, 23, 4, 8};
        System.out.print(largestNumber(num));
    }
    public static String largestNumber(int[] num) {
        if (num == null) return null;
        if (num.length == 1) return String.valueOf(num[0]);
        String[] strings = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strings[i] = String.valueOf(num[i]);
        }
        Arrays.sort(strings, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : strings) {
            stringBuffer.append(s);
        }
        for (int i = 0; i < stringBuffer.length(); ) {
            if (stringBuffer.charAt(i) != '0') {
                break;
            } else {
                stringBuffer.deleteCharAt(i);
                if (stringBuffer.length() == 1) {
                    break;
                }
            }
        }
        return stringBuffer.toString();
    }
}
