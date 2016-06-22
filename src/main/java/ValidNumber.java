/**
 * Created by Administrator on 2016/6/22.
 */
public class ValidNumber {
    public static void main(String[] args) {
        String s = "0";
        System.out.print(isNumber(s));
    }
    enum InputType {
        INVALID,    // 0
        SPACE,      // 1
        SIGN,       // 2
        DIGIT,      // 3
        DOT,        // 4
        EXPONENT,   // 5
        NUM_INPUTS  // 6
    }

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        int[][] transitionTable = new int[][]{
            {-1,  0,  3,  1,  2, -1},     // next states for state 0
            {-1,  8, -1,  1,  4,  5},     // next states for state 1
            {-1, -1, -1,  4, -1, -1},     // next states for state 2
            {-1, -1, -1,  1,  2, -1},     // next states for state 3
            {-1,  8, -1,  4, -1,  5},     // next states for state 4
            {-1, -1,  6,  7, -1, -1},     // next states for state 5
            {-1, -1, -1,  7, -1, -1},     // next states for state 6
            {-1,  8, -1,  7, -1, -1},     // next states for state 7
            {-1,  8, -1, -1, -1, -1},     // next states for state 8
        };
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
//            InputType inputType = InputType.INVALID;
            int inputType = 0;
            char c = s.charAt(i);
            if (c == ' ') {
                inputType = 1;
            } else if (c == '+' || c == '-') {
                inputType = 2;
            } else if (c <= '9' && c >= '0') {
                inputType = 3;
            } else if (c == '.') {
                inputType = 4;
            } else if (c == 'e' || c == 'E') {
                inputType = 5;
            }

            state = transitionTable[state][inputType];
            if (state == -1) return false;
        }
        return state == 1 || state == 4 || state == 7 || state == 8;
//        int start = 0, end = s.length() - 1;
//        while (s.charAt(start) == ' ') {
//            start++;
//        }
//        while (s.charAt(end) == ' ') {
//            end--;
//        }
//        for (int i = start; i <= end; i++) {
//            char c = s.charAt(i);
//            if (c < )
//        }
    }
}
