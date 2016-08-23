import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/23.
 */
public class WoodCut {
    public static void main(String[] args) {
        int[] L = {232,124,456};
        System.out.print(woodCut(L, 7));
    }
    public static int woodCut(int[] L, int k) {
        if (L == null) return 0;
        int len = L.length;
        if (len == 0) return 0;
        Arrays.sort(L);
        int left = 1, right = L[len - 1];
        int res = 0;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            int count = 0;
            for (int i = 0; i < len; i++) {
                count+=(L[i]/mid);
            }
            if (count >= k) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
