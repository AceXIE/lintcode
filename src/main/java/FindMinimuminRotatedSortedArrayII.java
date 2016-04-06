/**
 * Created by Administrator on 2016/4/6.
 */
public class FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] num = {4,4,5,6,7,0,1,2};
        System.out.println(findMin(num));
    }
    public static int findMin(int[] num) {
        int l = 0, r = num.length - 1;
        if (num[l] <= num[r]) return num[l];
        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] > num[i]) {
                return num[i];
            }
        }
        return num[0];
    }
}
