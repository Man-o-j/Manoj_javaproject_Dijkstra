package Buses;

import Others.User;

public class BrownBus extends Bus{
    private static int num=1;

    public BrownBus()
    {
        this.BusName="BR"+num;
        num+=1;
        setCost_Per_Km(0.65F);
    }
    private final int AvgSpeed=30;
    public final String colour="Red";

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
