// *************************************************************************** 
// 
//   Kush Gandhi 
//   Z1968933
//   CSCI 470-PE1
//
//   I certify that this is my own work and where appropriate an extension 
//   of the starter code provided for the assignment. 
// ***************************************************************************

class Destination 
{
    private String cityName;
    private int normalMiles;
    private int frequentFlyerMiles;
    private int additionalMiles;
    private int frequentFlyerStartMonth;
    private int frequentFlyerEndMonth;

    public String getCityName()
    {
        return cityName;
    }

    public int getNormalMiles()
    {
        return normalMiles;
    }

    public int getFrequentFlyersMiles()
    {
        return frequentFlyerMiles;
    }

    public int getAdditionalMiles()
    {
        return additionalMiles;
    }

    public int getFrequentFlyersStartMonth()
    {
        return frequentFlyerStartMonth;
    }

    public int getFrequentFlyersEndMonth()
    { 
        return frequentFlyerEndMonth; 
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public void setNormalMiles(int normalMiles)
    {
        this.normalMiles = normalMiles;
    }

    public void setFrequentFlyersMiles(int frequentFlyersMiles)
    {
        this.frequentFlyerMiles = frequentFlyersMiles;
    }

    public void setAdditionalMiles(int additionalMiles)
    {
        this.additionalMiles = additionalMiles;
    }

    public void setFrequentFlyersStartMonth(int frequentFlyerStartMonth)
    {
        this.frequentFlyerStartMonth = frequentFlyerStartMonth;
    }

    public void setFrequentFlyersEndMonth(int frequentFlyerEndMonth)
    {
        this.frequentFlyerEndMonth = frequentFlyerEndMonth;
    }
}