import java.util.Comparator;

public class MileageComparator implements Comparator<Destination> 
{
    public int compare(Destination dest1, Destination dest2) 
    {
        return (dest2.getNormalMiles() - dest1.getNormalMiles());
    }
}
