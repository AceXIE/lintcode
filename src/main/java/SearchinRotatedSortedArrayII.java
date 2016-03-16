import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/16.
 */
public class SearchinRotatedSortedArrayII {

    public static boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (A[m] == target) return true;
            if (A[l] < A[m]) {
                if (A[l] <= target && target < A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (A[l] > A[m]) {
                if (A[m] < target && A[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入target：");
        int target = scanner.nextInt();
        System.out.print("输入数组：");
        String string = scanner.next();
        String stringArray[] = string.split(",");
        int A[] = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++) {
            A[i] = Integer.parseInt(stringArray[i]);
        }
        System.out.print("输出：" + search(A, target));
    }

}
