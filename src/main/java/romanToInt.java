import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/15.
 */
public class romanToInt {
    static int romanToInt(String s) {
        // Write your code here
        int count = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M': count += 1000; break;
                case 'D': count += 500; break;
                case 'C':
                    if ((i<s.length()-1) &&(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'))
                        count -= 100;
                    else
                        count += 100;
                    break;
                case 'L': count += 50; break;
                case 'X':
                    if ((i<s.length()-1) && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
                        count -= 10;
                    else
                        count += 10;
                    break;
                case 'V': count += 5; break;
                case 'I':
                    if ((i<s.length()-1) &&(s.charAt(i+1) == 'V'|| s.charAt(i+1) == 'X'))
                        count--;
                    else
                        count++;
                    break;
            }
        }
        return count;
    }
}
