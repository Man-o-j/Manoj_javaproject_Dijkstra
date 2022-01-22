package Buses;

import Others.User;

public class WhiteBus extends Bus
{
    private static int num=1;
    public WhiteBus()
    {
        this.BusName="W"+num;
        num+=1;
        setCost_Per_Km(1.8F);
    }
    private final int AvgSpeed=90;
    public final String colour="White";
    private final String Type="Semi Sleeper";

    public String getType()
    {
        return Type;
    }

    @Override
    public void ApproxTimeCalc() {

        float time=(float) getRecordedPath().getEdge_weight() /AvgSpeed;
        int hr= (int)time;
        float min= (time-hr)*60;
        if(hr!=0)
        {
            System.out.println(hr+" hour "+(int)min+" minutes");
        }
        else
        {
            System.out.println((int)min+" minutes");
        }

    }


}
