import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/16.
 */
public class SearchinRotatedSortedArray {
    public static int search(int[] A, int target) {

        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (A[m] == target) return m;
            if (A[l] <= A[m]) {
                if (A[l] <= target && A[m] >= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (A[m] >= target || A[l] <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入target：");
        int target = scanner.nextInt();
        System.out.print("输入数组：");
        String string = scanner.next().toString();
        String stringArray[] = string.split(",");
        int A[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            A[i] = Integer.parseInt(stringArray[i]);
        }
        System.out.print("Output: " + search(A, target));
    }
}
