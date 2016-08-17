import java.util.*;

/**
 * Created by Administrator on 2016/8/17.
 */
public class WordLadder {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("b");
        System.out.print(ladderLength("a","a", dict));
    }
    public static int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() != end.length()) {
            return 0;
        }
        if (start.equals(end)) return 1;
        if (getDiff(start, end) == 1) return 2;

        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> dist = new HashMap<>();
        queue.add(start);
        dist.put(start, 1);
        while (!queue.isEmpty()) {
            String head = queue.poll();
            int headDist = dist.get(head);
            for (int i = 0; i < head.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (head.charAt(i) == j) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(head);
                    sb.setCharAt(i, j);
                    if (sb.toString().equals(end)) return headDist +1;
                    if (dict.contains(sb.toString()) && !dist.containsKey(sb.toString())) {
                        queue.add(sb.toString());
                        dist.put(sb.toString(), headDist + 1);
                    }
                }
            }
        }
        return 0;
    }
    public static int getDiff(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
