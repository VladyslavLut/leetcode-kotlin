import java.util.concurrent.Semaphore;

public class PrintInOrder {

    static class SemaphoresFoo implements OrderedPrinter {

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

        @Override
        public void first(Runnable printFirst) throws InterruptedException {
            third.acquire();
            printFirst.run();
            first.release();
        }

        @Override
        public void second(Runnable printSecond) throws InterruptedException {
            first.acquire();
            printSecond.run();
            second.release();
        }

        @Override
        public void third(Runnable printThird) throws InterruptedException {
            second.acquire();
            printThird.run();
            third.release();
        }
    }

    static class SynchronizedFoo implements OrderedPrinter {

        private int state = 0;

        public SynchronizedFoo() {

        }

        @Override
        public synchronized void first(Runnable printFirst) throws InterruptedException {
            while (state != 0) {
                wait();
            }
            printFirst.run();
            state = 1;
            notifyAll();
        }

        @Override
        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (state != 1) {
                wait();
            }
            printSecond.run();
            state = 2;
            notifyAll();
        }

        @Override
        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (state != 2) {
                wait();
            }
            printThird.run();
            state = 0;
            notifyAll();
        }
    }

}
