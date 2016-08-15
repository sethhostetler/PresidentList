/*
 * Program: PresidentList
 * This:  QueueInterface.java
 * Date: 3/14/2016
 * Author: S. Hostetler
 * Purpose: interface for a class that implements a queue President
*/
package presidentlist;

public interface QueueInterface 
{
    President dequeue() throws QueueUnderflowException;
    //exception if the queue is empty
    //else, removes front element
    
    boolean isEmpty();
    //true if empty queue
            
    
}
