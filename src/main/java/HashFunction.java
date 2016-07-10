/**
 * Created by Administrator on 2016/7/10.
 */
public class HashFunction {
    public static void main(String[] args) {
        char[] key = new char[] {'a','b','c','d'};
        System.out.print(hashCode(key,100));
    }
    public static int hashCode(char[] key, int HASH_SIZE) {
        if (key.length == 0) return 0;
        long sum = 0;
        for (int i = 0; i < key.length; i++) {
            sum = sum *33 %HASH_SIZE + key[i];
        }
        sum = sum%HASH_SIZE;
        return (int) sum;
    }
}
