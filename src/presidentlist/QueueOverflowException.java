/*
 * Program: PresidentList
 * This:  QueueOverflowException.java
 * Date: 3/28/2016
 * Author: S. Hostetler
 * Purpose: a class extends the RuntimeException
                if the queue is full and action is taken.
*/
package presidentlist;

public class QueueOverflowException extends RuntimeException 
{
    public QueueOverflowException()
    {
        super();
    }
    
    public QueueOverflowException(String message)
    {
        super(message);
    }    
}

