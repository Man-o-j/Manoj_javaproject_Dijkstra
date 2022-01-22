package Others;
import Buses.Bus;
import Buses.RedBus;

import java.util.*;
import java.util.HashMap;
public class RecordedPath {
    private HashMap<String,String> Start_End = new HashMap<String,String>();
    private ArrayList<String> path= new ArrayList<>();
    private int edge_weight;
    private String AllottedBus;

    RecordedPath(String strt, String end) {
        Start_End.put(strt,end);
    }

    public void setPath(ArrayList<String> path)
    {
        this.path = path;
    }

    public void setEdge_weight(int edge_weight)
    {
        this.edge_weight = edge_weight;
    }

    public HashMap<String, String> getStart_End()
    {
        return Start_End;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public int getEdge_weight() {
        return edge_weight;
    }

    public void setAllottedBus(String allottedBus) {
        AllottedBus = allottedBus;
    }

    public String getAllottedBus() {
        return AllottedBus;
    }
}
