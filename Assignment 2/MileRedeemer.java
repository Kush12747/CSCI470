// *************************************************************************** 
// 
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1
//
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MileRedeemer
{
    //remaining miles
    private int remainingMiles;
    
    //array of destinations
    private ArrayList<Destination> destinations = new ArrayList<Destination>();

    Scanner fileScanner = new Scanner(System.in);

    public void readDestinationInfo(Scanner fileScanner)
    {
        //Constructs an empty list with an initial capacity
        destinations = new ArrayList<>();

        do
        {
            Destination destination = new Destination();
            
            //read in the string
            String data = fileScanner.nextLine();
            
            //split the data in the string from input file and stores the data in the array
            String[] Info = data.split(";");

            //set the data into the destination objects where each peice of data is located
            destination.setCityName(Info[0]);
            destination.setNormalMiles(Integer.parseInt(Info[1]));
            destination.setFrequentFlyersMiles(Integer.parseInt(Info[2]));
            destination.setAdditionalMiles(Integer.parseInt(Info[3]));
            destination.setFrequentFlyersStartMonth(Integer.parseInt(Info[4].split("-")[0]));
            destination.setFrequentFlyersEndMonth(Integer.parseInt(Info[4].split("-")[1]));

            //adds the data into the array list
            destinations.add(destination);

        } while (fileScanner.hasNextLine());
        
        //sort the array list by the mileage comparator method
        destinations.sort(new MileageComparator());
    }

    public String[] getDestinationNames()
    {
        //array of city and determins the length by destionations array
        String[] cityPlace = new String[destinations.size()];

        //loop the array to set the city names into cityplace array
        for (int i = 0; i < destinations.size(); i++)
        {
            //set the i position of the array with the city name
            cityPlace[i] = destinations.get(i).getCityName();
        }
        
        //sort the array in ascending order
        Arrays.sort(cityPlace);

        return cityPlace;
    }

    public String[] redeemCustomerMiles(int miles, int month)
    {
        int i = 0;

        //miles is the total available miles
        remainingMiles = miles;
        
        //redeemed tickets
        String[] ticket = new String[destinations.size()];
        
        //alogrithm to check for possible tickets
        for (Destination destination : destinations)
        {
            //checks the month if it meets the threshold of the tickets requirements
            if (month >= destination.getFrequentFlyersStartMonth() && month <= destination.getFrequentFlyersEndMonth())
            {
                //will keep checking if the remaining miles is greater than freq. flyer miles
                if (remainingMiles >= destination.getFrequentFlyersMiles())
                {
                    //setting the i'th position for the city names
                    ticket[i++] = destination.getCityName();

                    //subtract the miles by destination miles
                    remainingMiles = remainingMiles - destination.getFrequentFlyersMiles();
                }
                //this checks if the ticket can be upgraded to first class
                /*if (remainingMiles > 0)
                {
                    int upgrade = remainingMiles - destination.getAdditionalMiles();
                    remainingMiles = remainingMiles - upgrade;
                    ticket[i++] = "A Trip to " + destination.getCityName() + " in First Class";
                }*/
            }
        }
        //returns a copy of the array which does not include any null cases
        return Arrays.copyOf(ticket, i);
    }

    public int getLeftoverMiles()
    {
        return remainingMiles;
    }
}