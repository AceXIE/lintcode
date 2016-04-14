/**
 * Created by Administrator on 2016/4/14.
 *
 *
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 31;
        System.out.println(findFirstBadVersion(n));
    }
    public static boolean isBadVersion(int k) {
        return k>0;
    }
    public static int findFirstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
