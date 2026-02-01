import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAlternatively {
    static class SemaphoresFooBar {
        private int n;

        private final Semaphore fooSemaphore = new Semaphore(1);
        private final Semaphore barSemaphore = new Semaphore(0);

        public SemaphoresFooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSemaphore.release();
            }
        }
    }

    static class SynchronizedFooBar {
        private int n;

        private boolean isFoo = true;

        public SynchronizedFooBar(int n) {
            this.n = n;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!isFoo) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo = false;
                notifyAll();
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (isFoo) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFoo = true;
                notifyAll();
            }
        }
    }
}
