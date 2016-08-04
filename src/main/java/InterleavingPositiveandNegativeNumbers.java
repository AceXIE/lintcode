/**
 * Created by Administrator on 2016/7/30.
 */
public class InterleavingPositiveandNegativeNumbers {
    public static void main(String[] args) {
        int[] A = {-33,-19,30,26,21,-9};//-13,-8,-12,-15,-14,35,7,-1,11,27,10,-7,12,28,18};//-1, 2, 3, -4, -5, 6, 8};
        rerange(A);
        for (int a : A)
        System.out.print(a + ",");
    }
    public static void rerange(int[] A) {
        if (A == null || A.length <= 1) return;
        int len = A.length;
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < len && A[left] < 0) {
                left++;
            }
            while (right >= 0 && A[right] > 0) {
                right--;
            }
            if (left > right) break;
            swap(A, left, right);
        }
        right++;
        int lright = right;
        if (2*right < len) {//正数多，第一个为正数
            left=0; right = len - 1;
            while (left < right) {
                swap(A, left++, right--);
            }
        }
        if (2 * right != len)
            right = len - 1;
        else
            right = len - 2;
        left = 1;
        while (left < right) {
            swap(A, left, right);
            left+=2;
            right-=2;
        }

    }
    public static void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
