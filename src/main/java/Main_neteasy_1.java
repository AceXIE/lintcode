import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Main_neteasy_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String string = new String();

        while (in.hasNextLine()) {
            string = in.nextLine();
            String[] arr = string.split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j], 1);
                }
            }
        }

        System.out.println(map.keySet().size());
    }
}
