// *************************************************************************** 
// 
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1 
// 
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************

import java.util.Scanner;

public class MyDateTester 
{
    public static void main(String[] args) 
    {
       Scanner input = new Scanner(System.in);

       System.out.print("Enter Day: ");
       int day = input.nextInt();

       System.out.print("Enter Month: ");
       int month = input.nextInt();

       System.out.print("Enter Year: ");
       int year = input.nextInt();

       MyDate date = new MyDate(day, month, year);

       System.out.println("The number of days: " + date.daysSinceJan1());
    }
}