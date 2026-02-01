import java.util.concurrent.Semaphore;

public class PrintInOrder {

    static class SemaphoresFoo {

        private final Semaphore first = new Semaphore(1);
        private final Semaphore second = new Semaphore(1);
        private final Semaphore third = new Semaphore(1);

        public SemaphoresFoo() {
            try {
                first.acquire();
                second.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void first(Runnable printFirst) throws InterruptedException {
            third.acquire();
            printFirst.run();
            first.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            first.acquire();
            printSecond.run();
            second.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            second.acquire();
            printThird.run();
            third.release();
        }
    }

    static class SynchronizedFoo {

        private boolean isFirst = false;
        private boolean isSecond = false;
        private boolean isThird = true;

        public SynchronizedFoo() {

        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            while (!isThird) {
                wait();
            }
            printFirst.run();
            isFirst = true;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (!isFirst) {
                wait();
            }
            printSecond.run();
            isSecond = true;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (!isSecond) {
                wait();
            }
            printThird.run();
            isThird = true;
            notifyAll();
        }
    }

}
