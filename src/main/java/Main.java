
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by Administrator on 2016/3/19.
 */
public class Main {
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        String add = "addCandidate";
        String vote = "vote";
        List<String> name = new ArrayList<String>();
        List<String> cixu = new ArrayList<String>();
        int wuxiao = 0;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        int idex = 0;
        String oror = new String();
        while ( !((oror = cin.next()).equals( "getVoteResult"))) {

            if (oror.equals(add)) {
                String addname = cin.next();
                if (!hashMap.containsKey(addname)) {
                    cixu.add(addname);
                    idex++;
                    hashMap.put(addname, 0);
                }
            } else if (oror.equals(vote)){
                String addname = cin.next();
                if (hashMap.containsKey(addname)) {
                    int cishu = hashMap.get(addname);
                    cishu++;
                    hashMap.put(addname, cishu);
                } else {
                    wuxiao++;
                }
            }
        }
        for (int i = 0; i < hashMap.size(); i++){
            System.out.print(cixu.get(i) + " ");
            System.out.println(hashMap.get(cixu.get(i)));
        }
        System.out.println(wuxiao);
    }
}
