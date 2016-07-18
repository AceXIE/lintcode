import java.util.*;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Anagrams {
    public static void main(String[] args) {
        String[] strings = {"lint", "intl", "inlt", "code"};
        List<String> ans = anagrams(strings);
        System.out.print(ans);
    }

    public static List<String> anagrams(String[] strs) {
        List<String> strings = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            if (map.containsKey(string)) {
                int index = map.get(string);
                if (index != -1) {
                    strings.add(strs[index]);
                    map.put(string, -1);
                }
                strings.add(strs[i]);
            } else {//不存在
                map.put(string, i);
            }
        }
        return strings;
    }
}
