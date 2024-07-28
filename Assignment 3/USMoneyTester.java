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

public class USMoneyTester 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Money Caclulator\n");
        System.out.print("Enter the first amount ex:(1.11): $");

        //read the input from user
        double amount1 = input.nextDouble();

        //extract the dollars and cents from the value by taking the int values
        int dollars1 = (int) amount1;
        int cents1 = (int) ((amount1 - dollars1) * 100);

        //create the first money object with the input values 
        USMoney money1 = new USMoney(dollars1, cents1);

        //prompt the user again for the 2nd amount
        System.out.print("Enter the 2nd amount ex:(1.11): $");

        //read 2nd amount from user
        double amount2 = input.nextDouble();
        
        //same logic as before for converting to int
        int dollars2 = (int) amount2;
        int cents2 = (int) ((amount2 - dollars2) * 100);
        
        //2nd money object
        USMoney money2 = new USMoney(dollars2, cents2);

        //sum object
        USMoney sum = money1.plus(money2);        
        
        //output details of the result
        System.out.println("\nFirst USMoney Object: $" + money1.getDollars() + "." + money1.getCents());
        System.out.println("\nSecond USMoney Object: $" + money2.getDollars() + "." + money2.getCents());
        System.out.println("\nSum of the two USMoney objects: $" + sum.getDollars() + "." + sum.getCents());
    }
}