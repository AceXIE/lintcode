import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class NumberofAirplanesintheSky {
    public static void main(String[] args) {
        List<Interval> airplanes = new ArrayList<>();
        airplanes.add(new Interval(1,10));
        airplanes.add(new Interval(2,3));
        airplanes.add(new Interval(5,8));
        airplanes.add(new Interval(10,11));
        NumberofAirplanesintheSky t = new NumberofAirplanesintheSky();
        System.out.print(t.countofAirplanes(airplanes));
    }
    public int countofAirplanes(List<Interval> airplanes) {
        List<Cell> cells = new ArrayList<>();
        for (Interval i : airplanes) {
            cells.add(new Cell(i.start, 1));
            cells.add(new Cell(i.end, 0));
        }
        Collections.sort(cells);
        int cnt = 0, ans = 0;
        for (Cell cell : cells) {
            if (cell.flag == 1) cnt++;
            else cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
    class Cell implements Comparable<Cell> {
        int time;
        int flag;

        Cell(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }

        @Override
        public int compareTo(Cell o) {
            if (this.time == o.time) {
                return this.flag - o.flag;
            } else {
                return this.time - o.time;
            }
        }
    }
}
