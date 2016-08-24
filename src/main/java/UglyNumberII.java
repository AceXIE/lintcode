import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
public class UglyNumberII {
    public static void main(String[] args) {
        System.out.print(nthUglyNumber(9));
    }
    public static int nthUglyNumber(int n) {
        if (n == 1) return 1;

        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();
        l1.add(1);
        l2.add(1);
        l3.add(1);

        int min = 0;

        for (int i = 0; i < n; i++) {
            min = Math.min(Math.min(l1.get(0), l2.get(0)), l3.get(0));

            if (min == l1.get(0)) l1.remove(0);
            if (min == l2.get(0)) l2.remove(0);
            if (min == l3.get(0)) l3.remove(0);

            l1.add(min*2);
            l2.add(min*3);
            l3.add(min*5);
        }
        return min;

    }
}
