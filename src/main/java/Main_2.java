import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Main_2 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String string = "LOD GRADE:NAME=XiaoMing,LANG=100,MATH=90;";
        String[] p1 = string.split(",");
        for (String s : p1)
            System.out.println(s);

        String[] p10 = p1[1].split("=");
        System.out.print(p10[1]);
    }
}
