// *************************************************************************** 
// 
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1
//
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************

import java.util.Comparator;

public class MileageComparator implements Comparator<Destination> 
{
    public int compare(Destination dest1, Destination dest2) 
    {
        return (dest2.getNormalMiles() - dest1.getNormalMiles());
    }
}