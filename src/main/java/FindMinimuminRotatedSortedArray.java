/**
 * Created by Administrator on 2016/4/6.
 */
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(num));
    }
    public static int findMin(int[] num) {
        int l = 0, r = num.length -1;
        if (num.length == 1 || num[l] < num[r]) return num[0];
        while (l + 1 != r) {
            int mid = (l + r)/2;
            if (num[mid] > num[l]) {
                l = mid;
            }
            if (num[mid] < num[r]){
                r = mid;
            }
        }
        return num[r];
    }
    public static int findMinUsingBinarySearch(int[] num) {
        int l = 0, r = num.length - 1;
        while (l < r && num[l] >= num[r]) {
            int mid = (l + r) / 2;
            if (num[mid] < num[l]) {
                r = mid;
            } else if (num[mid] == num[l]) {
                l++;
            } else {
                l = mid + 1;
            }
        }
        return num[l];
    }
}
