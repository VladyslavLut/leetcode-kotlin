import java.util.concurrent.Semaphore;

public class PrintInOrder {
    class Foo {

        private Semaphore first = new Semaphore(1);
        private Semaphore second = new Semaphore(1);
        private Semaphore third = new Semaphore(1);

        public Foo() {
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

    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
