import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/7/22.
 */
public class java8 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("xiekai","xiaowang","xiaoxia","zhangming");
        Collections.sort(names, (String a, String b)->{
            return a.compareTo(b);
        });
        System.out.print(names);
    }
}
