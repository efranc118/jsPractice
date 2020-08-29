package main;

import java.util.LinkedList;

public class MyCircularQueue {

    private Integer itemCount;
    private Integer maxSize;
    private LinkedList<Integer> linkedList;


    /** Initialize your data structure here. Set the size of the main.queue to be k. */
    public MyCircularQueue(int k) {
        linkedList = new LinkedList<>();
        itemCount = 0;
        maxSize = k;
    }

    /** Insert an element into the circular main.queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(itemCount < maxSize) {
            linkedList.addLast(value);
            itemCount++;
            return true;
        }
        else return false;
    }

    /** Delete an element from the circular main.queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(itemCount > 0) {
            linkedList.removeFirst();
            itemCount--;
            return true;
        }
        else return false;
    }

    /** Get the front item from the main.queue. */
    public int Front() {
        if(itemCount > 0) {
            return linkedList.getFirst();
        }
        else return -1;
    }

    /** Get the last item from the main.queue. */
    public int Rear() {
        if(itemCount > 0) {
            return linkedList.getLast();
        } else return -1;
    }

    /** Checks whether the circular main.queue is empty or not. */
    public boolean isEmpty() {
        return itemCount > 0;
    }

    /** Checks whether the circular main.queue is full or not. */
    public boolean isFull() {
        return itemCount == maxSize;
    }


    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the main.queue is full
        circularQueue.Rear();  // return 3
        circularQueue.isFull();  // return true
        circularQueue.deQueue();  // return true
        circularQueue.enQueue(4);  // return true
        circularQueue.Rear();  // return 4
    }

}
