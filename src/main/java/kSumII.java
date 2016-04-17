import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2016/4/16.
 */
public class kSumII {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int k = 2, target = 5;
        ArrayList<ArrayList<Integer>> arrayLists = kSumII(A, k, target);
        for (ArrayList<Integer> a : arrayLists) {
            for (Integer b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<Integer, Integer>();
        Arrays.sort(A);
        return ans;



    }
}
