/**
 * Created by xk on 2016/4/2.
 * 线程等待测试
 */
public class WaitTest {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA("t1");

        synchronized (t1) {
            try {
                //启动线程
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                System.out.println(Thread.currentThread().getName() + "wait()");
                t1.wait();

                System.out.println(Thread.currentThread().getName() + "continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }
        public void run() {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "call notify()");
                notify();
            }
        }
    }
}
