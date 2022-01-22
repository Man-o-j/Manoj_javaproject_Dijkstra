package Others;
import java.util.*;
public class Hurdle {
    private final String Hurdle_type;
    private final int hurdle_weight;
    public Hurdle(String type,int weight)
    {
        this.Hurdle_type=type;
        this.hurdle_weight=weight;

    }
    public void alterEdgeWeight(String Start, String End)
    {
        int strt = Location.NameToCode.get(Start);
        int end = Location.NameToCode.get(End);

            System.out.println("Hurdle weight:" + this.hurdle_weight);
            WeightedGraph.alterEdge(strt, end, this.hurdle_weight);

    }

}
