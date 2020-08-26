import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue {

    private Queue<Integer> queue;
    private Integer capacity;
    private final Object mutex = new Object();


    BoundedBlockingQueue(Integer capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }





}
