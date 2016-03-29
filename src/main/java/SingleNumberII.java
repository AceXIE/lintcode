import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/29.
 */
public class SingleNumberII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Integer.SIZE);
//        System.out.println(singleNumber(scanner.next()));
    }
    public static int singleNumber(int[] A) {
        int res = 0;
        int[] bitsum = new int[Integer.SIZE];//
        for (int i = 0; i < Integer.SIZE; i++) {
            for (int j = 0; j < A.length; j++) {
                bitsum[i] += (A[j]>>i) & 1;
            }
            res = res | (bitsum[i]%3)<<i;
        }
        return res;
    }
}
