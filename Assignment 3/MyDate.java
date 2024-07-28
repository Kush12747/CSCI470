// *************************************************************************** 
// 
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1 
// 
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************
public class MyDate 
{
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int daysSinceJan1()
    {
    	//initialize the day
    	int day = this.day;
    	
    	//loop through the month to add the days up
    	for (int i = 1; i < month; i++)
    	{
    		switch(i)
    		{
    			case 1: //January
    				day += 31;
    				break;
    			case 2: //February
    				if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0))
    				{
    					day += 29;
    				}
    				else
    				{
    					day += 28;
    				}
    				break;
    			case 3: //march
    				day += 31;
    				break;
	    		case 4: //April
	    			day += 30;
	    			break;
	    		case 5: //may
	    			day += 31;
	    			break;
	    		case 6: //June
	    			day += 30;
	    			break;
	    		case 7: //July
	    			day += 31;
	    			break;
	    		case 8: //August
	    			day += 31;
	    			break;
	    		case 9://September
	    			day += 30;
	    			break;
	    		case 10: //October
	    			day += 31;
	    			break;
	    		case 11: //November
	    			day += 30;
	    			break;
	    		case 12: //December
	    			day += 31;
	    			break;
    		}
    	}
    	return day;
    }
}
