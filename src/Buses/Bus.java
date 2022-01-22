package Buses;

import Others.RecordedPath;
import Others.TestDriver;
import Others.Ticket;
import Others.User;

import java.util.ArrayList;

public abstract class Bus implements Buses{
    public String BusName;
    private float Cost_Per_Km;
    private RecordedPath recordedPath;

    public void setCost_Per_Km(float cost_Per_Km) {
        Cost_Per_Km = cost_Per_Km;
    }

    public float getCost_Per_Km() {
        return Cost_Per_Km;
    }
    public void getTicket(User u1)
    {
        String tempStrt= (String) getRecordedPath().getStart_End().keySet().toArray()[0];
        TestDriver.ticket[TestDriver.ticketCount]= new Ticket(u1,this,tempStrt,getRecordedPath().getStart_End().get(tempStrt));
        TestDriver.ticketCount+=1;
    }
    public String getBusName()
    {
        return BusName;
    }


    public void setRecordedPath(RecordedPath recordedPath) {
        this.recordedPath = recordedPath;
    }

    public RecordedPath getRecordedPath() {
        return recordedPath;
    }

}
