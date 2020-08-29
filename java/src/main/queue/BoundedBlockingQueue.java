package main.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    private List<Integer> list;
    private int itemCount;
    private int capacity;
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;


    public BoundedBlockingQueue(int capacity) {
        list = new ArrayList<>(capacity);
        itemCount = 0;
        this.capacity = capacity;
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while(itemCount == capacity) {
                notFull.await();
            }
            list.add(0, element);
            itemCount++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while(itemCount == 0) {
                notEmpty.await();
            }
            int item = list.remove(itemCount - 1);
            itemCount--;
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return itemCount;
        } finally{
            lock.unlock();
        }
    }



    public static void main(String[] args) {
        BoundedBlockingQueue solution = new BoundedBlockingQueue(10);

        Thread thread = new Thread(() -> {
            try {
                solution.enqueue(2);
                System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
                solution.enqueue(4);
                System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
                solution.enqueue(6);
                System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
                solution.enqueue(8);
                System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
                System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        thread.setName("Even Thread");
        thread.start();
        Thread current = Thread.currentThread();
        current.setName("Odd Thread");
        try {
            solution.enqueue(1);
            solution.enqueue(3);
            System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
            solution.enqueue(5);
            System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
            solution.enqueue(7);
            System.out.println(" I am running in " + Thread.currentThread() + "dequeue: " + solution.dequeue());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
