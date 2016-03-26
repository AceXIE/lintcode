/**
 * Created by xk on 2016/3/26.
 */
public class PartitionArraybyOddandEven {
    public void partitionArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l]%2 != 0) {//左为奇数
                l++;
            } else {//左为偶数
                if (nums[r]%2 == 0) {//右为偶数
                    r--;
                } else { //右为奇数，需要交换
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;r--;
                }
            }
        }
    }
}
