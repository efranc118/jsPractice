package main;

public class ProducerConsumer {

    private static final Object lock = new Object();
    private static boolean [] buffer = new boolean[10];
    private static int count = 0;

    static boolean isFull() {
        return count == 9;
    }

    static boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread produce = new Thread(() -> {
            for(int i = 0; i < 50; i++) {
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done producing");
        } ) ;

        Thread consume = new Thread(() -> {
            for(int i = 0; i < 45; i++) {
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done consuming");
        }) ;

        produce.start();
        consume.start();

        produce.join();
        consume.join();

        System.out.println("Final Result: " + count);
    }



    static class Producer {

        public void produce() throws InterruptedException {
            synchronized (lock) {
                if(isFull())
                    lock.wait();
                buffer[count++] = true;
                lock.notify();
            }
        }
    }


    static class Consumer {

        public void consume() throws InterruptedException {
            synchronized (lock) {
                if(isEmpty())
                    lock.wait();
                buffer[count--] = false;
                lock.notify();
            }
        }
    }

}
