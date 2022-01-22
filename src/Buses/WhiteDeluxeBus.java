package Buses;

public class WhiteDeluxeBus extends WhiteBus
{
    private static int num=1;
    public WhiteDeluxeBus()
    {
        this.BusName="WD"+num;
        num+=1;
        setCost_Per_Km(2.2F);
    }
    private final int AvgSpeed = 90;
    private final String type = "sleeper";

    @Override
    public String getType()
    {
        return type;
    }
}
