/**
 * Created by Administrator on 2016/7/10.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.print(addBinary("0","0"));
    }
    public static String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int lenA = a.length();
        int lenB = b.length();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0, na, nb;
        while (indexA >= 0 && indexB >= 0) {
            na = a.charAt(indexA) - '0';
            nb = b.charAt(indexB) - '0';
            stringBuffer.insert(0, (na + nb + carry)%2);
            carry = (na + nb + carry)/2;
            indexA--; indexB--;
        }
        while (indexA >= 0) {
            na = a.charAt(indexA) -'0';
            stringBuffer.insert(0, (na + carry)%2);
            carry = (na + carry)/2;
            indexA--;
        }
        while (indexB >= 0) {
            nb = b.charAt(indexB) -'0';
            stringBuffer.insert(0, (nb + carry)%2);
            carry = (nb + carry)/2;
            indexB--;
        }
        if (carry != 0)
            stringBuffer.insert(0, carry);
        return stringBuffer.toString();
    }
}
