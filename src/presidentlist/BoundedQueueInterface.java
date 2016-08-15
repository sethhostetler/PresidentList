/*
 * Program: PresidentList
 * This:  BoundedQueueInterface.java
 * Date: 3/28/2016
 * Author: S. Hostetler
 * Purpose: Interface for a for a FIFO class that implements
            a queue of a bounded size
*/
package presidentlist;

public interface BoundedQueueInterface extends QueueInterface
{
    void insert(President element) throws QueueOverflowException;
    //exception if queue is full
    //else, adds element to queue
    
    boolean isFull();
    //returns true if queue is full;
}
