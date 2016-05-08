/**
 * Created by Administrator on 2016/5/8.
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,1,3,1};
        int[] cost = {2,2,1,1};
        System.out.print(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost ==null) return -1;
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (sum < 0) {
                start = i;
                sum = gas[i] - cost[i];
            } else {
                sum += (gas[i] - cost[i]);
            }
        }
        return (total<0?-1:start);
    }
}
