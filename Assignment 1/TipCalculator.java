import java.util.Scanner;

class TipCalculator 
{
    private double BillAmount = 0;
    private int TipPercentage = 20;
    private int PartySize = 1;

    //getters
    public double getBillAmount() 
    {
        return BillAmount;
    }

    public int getTipPercentage() 
    {
        return TipPercentage;
    }

    public int getPartySize() 
    {
        return PartySize;
    }

    //setters
    public void setBillAmount(double BillAmount) 
    {
        this.BillAmount = BillAmount;
    }

    public void setTipPercentage(int TipPercentage) 
    {
        this.TipPercentage = TipPercentage;
    }

    public void setPartySize(int PartySize) 
    {
        this.PartySize = PartySize;
    }

    //method that calculates the total of the bill and rounds the result to 2 decimal places
    public double getTotalBill() 
    {
        double bill = (BillAmount * (1 + TipPercentage / 100.0));
        return Math.round(bill * 100.00) / 100.00;
    }

    //takes the amount from method getTotalBill and divides the share
    //by the party size and rounds the result to 2 decimal places
    public double getIndividualShare() 
    {
        double calcShare = getTotalBill() / PartySize;
        return Math.round(calcShare * 100.0) / 100.0;
    }
}

class TipApp 
{
    public static void main(String[] args) 
    {
        TipApp tip = new TipApp();
        tip.calculateTips();
    }

    public void calculateTips() 
    {
        char repeat;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        TipCalculator tipCalculator = new TipCalculator();

        System.out.println("*** Tip Calculator ***\n");

        //loop for the driver program
        do 
        {
            //loop to check errors by the user
            while (flag)
            {
                System.out.print("Enter bill amount: ");
                if (input.hasNextDouble())
                {
                    //read and store the amount to a temp variable
                    double billAmount = input.nextDouble();
                    
                    //checks the amount and if valid then it will store the value. If not then it will
                    //print a error message for invalid numbers and letters entered
                    if (billAmount > 0)
                    {
                        tipCalculator.setBillAmount(billAmount);
                        break;  //break out of the loop to move on next input
                    }
                    else
                    {
                        System.out.print("\nPlease enter a valid bill.\n\n");
                        input.nextLine();
                    }
                }
                else
                {
                    System.out.print("\nPlease enter a valid number.\n\n");
                    input.nextLine();
                }
                
            }
            
            //same loop algorithm being used to validate tip percentage
            while (flag)
            {
                System.out.print("Enter your desired tip percentage (20 equals 20%): ");
                if (input.hasNextInt())
                {
                    int tipPercentage = input.nextInt();

                    if (tipPercentage >= 0)
                    {
                        tipCalculator.setTipPercentage(tipPercentage);
                        break;
                    }
                    else
                    {
                        System.out.println("Please enter a valid tip percentage.\n");
                        input.nextLine();
                    }
                }
                else
                {
                    System.out.println("Please enter a valid tip percentage.\n");
                    input.nextLine();
                }
                
            }

            //same loop algorithm being used to validate party size
            while (flag)
            {
                System.out.print("Enter the size of your party: ");

                if (input.hasNextInt())
                {
                    int partySize = input.nextInt();
                    if (partySize > 0)
                    {
                        tipCalculator.setPartySize(partySize);
                        break;
                    }
                    else
                    {
                        System.out.println("Please enter a valid party size.\n");
                        input.nextLine();
                    }
                }
                else
                {
                    System.out.println("Please enter a valid party size.\n");
                    input.nextLine();
                }
                
            }

            //Program output display details 
            System.out.println("\n*** Your Bill ***\n");
            System.out.println("Bill Amount: $" + tipCalculator.getBillAmount());
            System.out.println("Tip Percentage: " + tipCalculator.getTipPercentage() + "%");
            System.out.println("Party Size: " + tipCalculator.getPartySize());

            System.out.println("\nTotal Bill (with Tip): $" + tipCalculator.getTotalBill());
            System.out.println("Share for Each Individual: $" + tipCalculator.getIndividualShare());

            System.out.print("\nAnother bill? (y/n): ");
            repeat = input.next().charAt(0);

            //if user wants to quit or run the program again
            if (repeat == 'n' || repeat == 'N') 
            {
                System.out.println("\nGoodbye!");
            }
            else 
            {
                System.out.println("\n");
            }

        } while(repeat == 'y' || repeat == 'Y');
    }
}
