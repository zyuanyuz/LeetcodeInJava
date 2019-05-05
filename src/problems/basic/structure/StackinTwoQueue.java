package problems.basic.structure;

import java.util.*;

/**
 * StackinTwoQueue 
 * 
 * Implementing the stack structure using two queues
 */
public class StackinTwoQueue<T> extends Stack<T> {
    Queue<T> queueOne = new LinkedList<>();
    Queue<T> queueTwo = new LinkedList<>();
    boolean queueSwitch = true;

    public T push(T item) {
        // queueTake only contains one newest item for func pop
        Queue<T> queueTake = queueSwitch ? queueOne : queueTwo;
        Queue<T> queueStorage = queueSwitch ? queueTwo : queueOne;
        if (queueTake.isEmpty()) {
            queueTake.offer(item);
        } else {
            queueStorage.offer(queueTake.poll());
            queueTake.offer(item);
        }
        return item;
    }

    public T pop() {
        Queue<T> queueTake = queueSwitch ? queueOne : queueTwo;
        Queue<T> queueStorage = queueSwitch ? queueTwo : queueOne;
        if(queueTake.isEmpty()){
            return null;
        }
        T item = queueTake.poll();
        while(queueStorage.size()>1){
            queueTake.offer(queueStorage.poll());
        }
        queueSwitch = !queueSwitch;
        return item;
    }
}