import java.util.logging.Handler;

/**
 * Created by xk on 2016/4/2.
 */
public class wm {
    public abstract class SyncTask<R> {
        protected abstract R run();
        private R result;
        private byte[] lock = new byte[0];
        private boolean notified = false;
        private Runnable task = new Runnable() {
            @Override
            public void run() {
                R ret = SyncTask.this.run();
                synchronized (lock) {
                    result = ret;
                    lock.notify();
                    notified = true;
                }
            }
        };
        public R start(final long timeout, final R defaultRet, Handler handler) {

        }
    }

}
