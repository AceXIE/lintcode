import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/25.
 */
public class CountofSmallerNumber {
    public static void main(String[] args) {
        int[] A = {1,2,7,8,5};
        int[] queries = {1,8,5};
        System.out.print(countOfSmallerNumberSort(A,queries));
    }
    //二分
    //Total Runtime: 4307 ms
    public static ArrayList<Integer> countOfSmallerNumberSort(int[] A, int[] queries) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (A == null || queries == null) return null;
        if (queries.length == 0) return arrayList;
        int len = queries.length;

        Arrays.sort(A);
        for (int i = 0; i < len; i++) {
            int target = queries[i];
            int left = 0, right = A.length - 1;
            while (left < right) {
                int mid = left + (right - left)/2;
                if (A[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            arrayList.add(left);
        }


        return arrayList;
    }
    //只是用Loop
    //Total Runtime: 9774 ms
    public static ArrayList<Integer> countOfSmallerNumberLoop(int[] A, int[] queries) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (A == null || queries == null) return null;
        if (queries.length == 0) return arrayList;
        int len = queries.length;
        for (int i = 0; i < len; i++) {
            int target = queries[i];
            int num = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] < target) {
                    num++;
                }
            }
            arrayList.add(num);
        }
        return arrayList;
    }
}
