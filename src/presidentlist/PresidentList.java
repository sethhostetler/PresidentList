/*
 * Program: PresidentList
 * This:  PresidentList.java
 * Date: 04/04/2016
 * Author: S. Hostetler.
 * Purpose: To create a list of presidents that can be searched.
 */
package presidentlist;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PresidentList 
{

    private static boolean isContinue = false;
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner fileInput = new Scanner(new File("USPresidents.txt"));
        PresidentArray USPresidents = new PresidentArray();
        USPresidents.storeList("USPresidents.txt", USPresidents);
        
        boolean quit = false;
        do{
        Scanner input = new Scanner(System.in);
        System.out.print("***President Menu***\n"
                + "(1) Pick President by number\n"
                + "(2) Show Presidents from a state\n"
                + "(0) Show all Presidents, then quit.\n"
                + "> ");
        String menuInput = input.next();
        char menuChar = menuInput.charAt(0);
        switch(menuChar)
        {
            case '0': 
                System.out.print("*****Showing all Presidents*****\n");
                System.out.print(USPresidents.toString());
                quit = true;
                break;
                
            case '1':
                System.out.println("*****Lookup by order*****");
                do 
                {

                    System.out.println("Enter a number between 1 and 44, to display that President's information.");
                    int choice;
                    while(!input.hasNextInt()) 
                    {
                        input.next();
                        System.out.print("Error! Please enter a whole number!\n");
                    }
                    choice = input.nextInt();
                    // This error check didn't work - supposed to catch numbers too big.  instead, just shows null
//                    while(choice > USPresidents.numElements)
//                    {
//                        System.out.println("Error! There aren't that many presidents!\n");
//                        choice = input.nextInt();
//                    }
//                    choice = input.nextInt(); 

                    President test = USPresidents.findOrder(choice);
                    PresidentArray testList = new PresidentArray();
                    testList.insert(test);
                    System.out.print("Here is your chosen President:");
                    System.out.print(testList.toString());

                    isContinue = repeatApp();
                } while(isContinue);  
                break;
                
                
            case '2':
                System.out.println("*****Lookup by State******");
                do
                {
                    System.out.print("Enter a state, to display all presidents from that state."
                            + "\n(Enter without spaces.  Ex: NewYork)\n");
                    String stateChoice = input.next();
                    System.out.print(USPresidents.contains(stateChoice).toString());
                    
                    isContinue = repeatApp();
                }while(isContinue);
                break;
                
            default:
                System.out.println("Error, enter only 0, 1, or 2");
        }
        
        } while(quit == false);

        
        
        
    }
    
    
//  =========================repeatApp()====================
    private static boolean repeatApp()
    {
        Scanner userInput = new Scanner(System.in); 
        System.out.print("\nEnter Y to continue: >");
        String choice = userInput.next().toUpperCase();
        char firstLetter = choice.charAt(0);
        if(firstLetter == 'Y')
        {
            return true;
        }
        return false;
    } 
}
