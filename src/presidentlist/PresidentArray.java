/*
 * Program: PresidentList
 * This:  PresidentArray.java
 * Date: 3/28/2016
 * Author: S. Hostetler
 * Purpose: Implements the BoundedQueueInterface with an 
            array to build the queue
*/
package presidentlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PresidentArray implements BoundedQueueInterface
{
    protected final int DEFCAP = 100;//defaut capacity
    protected President[] queue;    // array that holds elements
    protected int numElements = 0;  // elements in array
    protected int front = 0;        // index of front of queue
    protected int rear;             // index of rear of queue.
    
    
    //========================Constructors============================
    
    public PresidentArray()
    {
        queue = new President[DEFCAP];
        rear = DEFCAP - 1;
    }

    public PresidentArray(int length)
    {
        queue = new President[length];
        rear = length - 1;
    }
    
    
    //==========================insert()=========================
    public void insert(President element)
    {
        //throws exception if queue full
        //else, adds element to rear
        if(isFull())
        {
            throw new QueueOverflowException("Enqueue"
                    + " attempted on a full queue");            
        }
        else 
        {    
            rear = (rear+1) % queue.length;
            queue[rear] = element;
            numElements++;
        }    
    }
    
    
    
    //==========================getSize()=======================
    public int size()
    {
        //returns the number of elements in the array
        return numElements;
    }


//========================isFull()=========================
    public boolean isFull()
    {
        //returns true if queue is full
        return (numElements == queue.length);
    }
//=======================isEmpty()==============================
    public boolean isEmpty()
    {
        //return true if queue empty
        return (numElements == 0);
    }
    
//======================Dequeue()===========================
    public President dequeue()
    {
        //throws exception if queue empty
        //else, removes front element
        if(isEmpty())
        {
            throw new QueueUnderflowException("Dequeue"
                    + "attempted on an empty queue");
        }
        else
        {
            President toReturn = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            numElements = numElements - 1;
            return toReturn;
        }
    }
    
    //===========================findOrder()===================
    public President findOrder(int order)
    {
        return queue[order - 1];
    }
    
    
//=========================toString()=========================
    public String toString()
    {
        //outputs the contents of the array
        String display = "\n*****************President List******************\n";
        display += String.format("%-3s%-12s%-12s%-12s%-15s%-6s%-6s%-23s%-12s%-12s",
            "#","First Name","Last Name","Birth Date","Birth State","Start","End",
            "Party","vpFirst","vpLast");
        display += "\n";

        for(int index = 0; index < numElements;)
        {
            display += (dequeue()+ "\n");
        }
        display += "*****************End List****************\n";
        return display;
    }

//=========================clear()=========================
    public void clear()
    {
        for(int index = 0; index < numElements; index++)
        {
            queue[index] = null;
        }
    }
    
//=============================contains()=======================
    public PresidentArray contains(String term)
    {
        PresidentArray homeStateList = new PresidentArray();
        for(int index = 0; index < numElements; index++)
        {
            if(queue[index].getBirthState().equalsIgnoreCase(term))
            {
                homeStateList.insert(queue[index]);
            }
        }
        return homeStateList;
        //return false;
    }
    
    public void storeList(String presList, PresidentArray list)
    {        
        try {
            Scanner input = new Scanner(new File(presList));
            while(input.hasNext())
            {
                President tempPres = new President();
                tempPres.setOrder(input.nextInt());
                tempPres.setFirstName(input.next());
                tempPres.setLastName(input.next());
                tempPres.setBirthDate(input.next());
                tempPres.setBirthState(input.next());
                tempPres.setTermStart(input.next());
                tempPres.setTermEnd(input.next());
                tempPres.setParty(input.next());
                tempPres.setVpFirst(input.next());
                tempPres.setVpLast(input.next());
                list.insert(tempPres);
                //System.out.print(list.toString());
            }
        }
        catch(FileNotFoundException noFile)
        {
            System.out.println("File not foudn.");
        }
    }


}
