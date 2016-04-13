import java.util.*;

/**
 * Created by Administrator on 2016/4/13.
 */
public class GrayCode {
    public static void main(String[] args) {
        int n = 2;
        ArrayList<Integer> res = grayCode(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }

    /***
     * 格雷码
     * @param n
     * @return
     */
    public static ArrayList<Integer> grayCode(int n) {
        int size = 1<<n;
        ArrayList<Integer> ans = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            int gcode = i ^ ( i>>1 );
            ans.add(gcode);
        }
        return ans;
    }
}
