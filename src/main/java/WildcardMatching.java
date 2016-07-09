/**
 * Created by Administrator on 2016/7/5.
 */
public class WildcardMatching {
    public static void main(String[] args) {
        String a = "aa", b = "a";
        System.out.print(isMatch(a,b));
    }
    public static boolean isMatch(String s, String p) {
        if (s == null) return p == null;
        int lenS = s.length();
        int lenP = p.length();
        int indexP = 0, indexS = 0;
        int starP = -1, starS = -1;
        while (indexS < lenS) {
            if (indexP < lenP && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                indexP++;
                indexS++;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                starP = indexP;
                starS = indexS;
                indexP++;
                continue;
            } else if (starP != -1) {
                indexS = starS;
                indexP = starP + 1;
                starS++;
            } else {
                return false;
            }
        }
        while (indexP < lenP && p.charAt(indexP) == '*') indexP++;

        return indexP == lenP && indexS == lenS;
    }
}
