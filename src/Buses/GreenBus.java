package Buses;

import Others.RecordedPath;
import Others.User;

public class GreenBus extends Bus {
    private static int num=1;
    public GreenBus()
    {
        this.BusName="G"+num;
        num+=1;
        setCost_Per_Km(1F);
    }
    private final int AvgSpeed=50;
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
