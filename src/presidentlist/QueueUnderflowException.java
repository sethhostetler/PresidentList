/*
 * Program: PresidentList
 * This:  QueueUnderflowException.java
 * Date: 3/28/2016
 * Author: S. Hostetler
 * Purpose: a class extends the RuntimeException
                if the queue is full and action is taken.
*/
package presidentlist;

public class QueueUnderflowException extends RuntimeException 
{
    public QueueUnderflowException()
    {
        super();
    }
    
    public QueueUnderflowException(String message)
    {
        super(message);
    }    
}
