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
import java.io.File;
import java.io.FileNotFoundException;

public class MileRedemptionApp
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        MileRedeemer redeemer = new MileRedeemer();

        //promt the user for file name
        System.out.print("Please enter the name of the file: ");
        String fileName = input.nextLine();
        File file = new File(fileName);

        try 
        {
            Scanner fileScanner = new Scanner(file);

            //this method will parse the data in the file
            redeemer.readDestinationInfo(fileScanner);

            System.out.println("\nWELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
            
            //loop to print the list of cities from the file
            System.out.println("\nList of destination cities your client can travel to:\n");
            String[] places = redeemer.getDestinationNames();
            for (int i = 0; i < places.length; i++)
            {
                System.out.print(places[i] + " ");
            }
        } catch (FileNotFoundException e) {
            //if the file is not detected then it will print a error message
            System.out.println("File not detected: " + e.getMessage());
        }

        String repeat;
        //the main part of the program of printing data and input from user
        do 
        {
            System.out.print("\n\nPlease enter your client's accumulated Frequent Flyer Miles: ");
            int flyerMiles = input.nextInt();

            System.out.print("\nPlease enter your client's month of departure (1-12): ");
            int month = input.nextInt();

            //gets all of the available tickets from the method and stores it in the array
            //if array length is 0 then return error message else print the array
            String[] availableTickets = redeemer.redeemCustomerMiles(flyerMiles, month);
            if (availableTickets.length == 0)
            {
                System.out.println("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
            }
            else
            {
                System.out.println("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:");
                for (String ticket : availableTickets)
                {
                    System.out.println("A Trip to " + ticket + " in Economy Class");
                }
            }

            System.out.println("Your client's remaining Frequent Flyer Miles: " + redeemer.getLeftoverMiles());

            System.out.print("Do you want to continue (y/n)? ");
            repeat = input.next();

            if (repeat.equals("n") || repeat.equals("N"))
            {
                System.out.println("\nTHANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
                break;
            }

        } while (repeat.equals("Y") || repeat.equals("y") || repeat.equals("Yes") || repeat.equals("yes"));
    }
}