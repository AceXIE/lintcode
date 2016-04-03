//import java.util.logging.Handler;
//
///**
// * 完SyncTask的start方法，要求
// * 1，SyncTask的派生类的run方法抛到Handler所属的线程执行。
// * 2，SyncTask派生类的执行线程等待返回，除非等待的超时timeout
// * 3，如果timeout或出错，则返回默认值defultRet
// */
//public class wm {
//    public abstract class SyncTask<R> {
//        protected abstract R run();
//        private R result;
//        private byte[] lock = new byte[0];
//        private boolean notified = false;
//        private Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                R ret = SyncTask.this.run();
//                synchronized (lock) {
//                    result = ret;
//                    lock.notify();
//                    notified = true;
//                }
//            }
//        };
//
//        /***
//         * 将任务抛到其他线程，同步等待其返回结果
//         * @param timeout 超过指定时间则直接返回ms
//         * @param defaultRet 默认返回值，即超时后或出错的返回值
//         * @param handler 执行线程handler
//         * @return
//         */
//        public R start(final long timeout, final R defaultRet, Handler handler) {
//
//        }
//    }
//
//}
