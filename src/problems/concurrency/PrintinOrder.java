package problems.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * leetcode 1114 PrintinOrder Easy
 */
public class PrintinOrder {

    // Runtime: 10 ms, faster than 52.70% of Java online submissions for Print in
    // Order.
    // Memory Usage: 35.5 MB, less than 100.00% of Java online submissions for Print
    // in Order.
    public static
    class Foo {
        CountDownLatch oneToTwo;
        CountDownLatch twoToThree;

        public Foo() {
            oneToTwo = new CountDownLatch(1);
            twoToThree = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            oneToTwo.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            oneToTwo.await();
            printSecond.run();
            twoToThree.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            twoToThree.await();
            printThird.run();
        }
    }

}