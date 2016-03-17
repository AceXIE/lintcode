import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/3/17.
 */
public class tmp {
    /**
     * @param args
     * @author JavaAlpha
     * Info 测试队列
     */
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");//插入一个元素
        queue.offer("2");
        queue.offer("3");
        //打印元素个数
        System.out.println("queue.size()"+queue.size());
        String string1 = queue.poll();
        //打印元素个数
        System.out.println("poll:"+string1);
        //遍历打印所有的元素,安装插入是顺序打印
        for (String string : queue)
        {
            System.out.println(string);
        }

        ArrayList<Integer> arrayList;
        arrayList= new ArrayList<Integer>();
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        arrayList.add(1);
        arrayList.add(2);
        res.add(arrayList);
        System.out.println(res);

        arrayList= new ArrayList<Integer>();
        arrayList.add(3);
        res.add(arrayList);
        System.out.print(res);
    }
}
