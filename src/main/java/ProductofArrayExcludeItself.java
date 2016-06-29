import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ProductofArrayExcludeItself {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<Long> res = productExcludeItself(arrayList);
        for (Long l : res) {
            System.out.print(l);
        }
    }
    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) return result;
        int len = A.size();
        long[] left = new long[len];
        long[] right = new long[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1]*A.get(i-1);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1]*A.get(i+1);
        }
        for (int i = 0; i < len; i++) {
            result.add(left[i]*right[i]);
        }
        return result;
    }
}
