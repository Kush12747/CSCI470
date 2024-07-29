class USMoney
{
    private int dollars;
    private int cents;

    public int getDollars()
    {
        return dollars;
    }

    public int getCents()
    {
        return cents;
    }

    public void setDollars(int dollars)
    {
        this.dollars = dollars;
    }

    public void setCents(int cents)
    {
        this.cents = cents;
    }

    public USMoney(int dollars, int cents)
    {
        this.dollars = dollars;
        this.cents = cents;

        //transfer extra cents over to dollars
        if (cents >= 100)
        {
            dollars = (cents / 100) + dollars;
            cents = cents % 100;
        }
        //transfer some cents over if less than 0
        if (cents < 0)
        {
            dollars = dollars + (cents / 100) - 1;
            cents = 100 + (cents % 100);
        }
    }

    public USMoney plus(USMoney money)
    {
    	//create new variable that will add the 2 values
        int newCents = this.cents + money.cents;
        int newMoney = this.dollars + money.dollars;
        
        //ensure that cents on the new object is between 0 and 99.
        if (newCents >= 100)
        {
            newMoney = newMoney + (newCents / 100);
            newCents = newCents % 100;
        }
        
        //returns a new money object
        return new USMoney(newMoney, newCents);
    }
}
