package Others;

import java.util.ArrayList;

public class WeightedGraph {
    public static RecordedPath[] paths = new RecordedPath[15];
    public static int pathCount =0;
    public static final int vertices=23;
    public static Integer[][] adjMatrix = new Integer[vertices][vertices];
    public static int[] parents= new int[vertices];
    public static ArrayList<String > RecordedPath= new ArrayList<>();


    public static Boolean edgeCheck(String st, String en) {

        int tempst=Location.NameToCode.get(st);
        int tempen=Location.NameToCode.get(en);
        if(adjMatrix[tempst][tempen]!=0)
            return true;
        else
            return false;
    }
    public static void alterEdge(int st,int en,int weight)
    {
        adjMatrix[st][en]+=weight;
        adjMatrix[en][st]+=weight;
        System.out.println("Edge weight altered= "+ WeightedGraph.adjMatrix[st][en]);

    }
    public static void addEdge(int st,int en,int weight)
    {
        adjMatrix[st][en]=weight;
        adjMatrix[en][st]=weight;
    }
    public static void initGraph()//Adding edges to the graph
    {

        addEdge(0,1,37);
        addEdge(1,0,37);
        addEdge(1,2,50);
        addEdge(2,1,50);
        addEdge(0,3,100);
        addEdge(3,0,100);
        addEdge(0,4,5);
        addEdge(4,0,5);
        addEdge(4,5,25);
        addEdge(5,4,25);
        addEdge(5,6,20);
        addEdge(6,5,20);
        addEdge(6,7,22);
        addEdge(7,6,22);
        addEdge(4,8,21);
        addEdge(8,4,21);
        addEdge(0,9,498);
        addEdge(9,0,498);
        addEdge(0,11,363);
        addEdge(11,0,363);
        addEdge(0,10,208);
        addEdge(10,0,208);
        addEdge(0,14,5);
        addEdge(14,0,5);
        addEdge(0,12,4);
        addEdge(12,0,4);
        addEdge(4,12,4);
        addEdge(12,4,4);
        addEdge(12,14,4);
        addEdge(14,12,4);
        addEdge(14,13,3);
        addEdge(13,14,3);
        addEdge(13,12,5);
        addEdge(12,13,5);
        addEdge(4,15,2);
        addEdge(15,4,2);
        addEdge(16,15,2);
        addEdge(15,16,2);
        addEdge(0,16,2);
        addEdge(16,0,2);
        addEdge(0,17,4);
        addEdge(17,0,4);
        addEdge(16,17,3);
        addEdge(17,16,3);
        addEdge(0,21,1);
        addEdge(21,0,1);
        addEdge(0,19,9);
        addEdge(19,0,9);
        addEdge(21,22,9);
        addEdge(22,21,9);
        addEdge(22,19,3);
        addEdge(19,22,3);
        addEdge(17,18,4);
        addEdge(18,17,4);
        addEdge(18,19,10);
        addEdge(19,18,10);
        addEdge(18,20,3);
        addEdge(20,18,3);
        addEdge(19,20,7);
        addEdge(20,19,7);
        for(int i=0;i<23;i++)
        {
            for(int j=0;j<23;j++)
            {
                if(adjMatrix[i][j]==null)
                {
                    adjMatrix[i][j]=0;
                }
            }
        }
        Location.initHashmap();
    }



    public static int getMinimumVertex(boolean [] spt, int [] key){

        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i <vertices ; i++) {
            if(spt[i]==false && minKey>key[i]){
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }
    public static int FindShortestPath(String SourceString, String DestinationString) {
        paths[pathCount]=new RecordedPath(SourceString,DestinationString);
        int[] parents= new int[vertices];
        int sourceVertex = Location.NameToCode.get(SourceString);
        int DestinationVertex= Location.NameToCode.get(DestinationString);
        boolean[] spt = new boolean[vertices];
        int[] distance = new int[vertices];
        int INFINITY = Integer.MAX_VALUE;
        parents[sourceVertex]=-1;

        //Initialize all the distance to infinity
        for (int i = 0; i < vertices; i++) {
            distance[i] = INFINITY;
        }

        //start from the vertex 0
        distance[sourceVertex] = 0;

        for (int i = 0; i < vertices; i++) {

            //get the vertex with the minimum distance
            int vertex_U = getMinimumVertex(spt, distance);

            spt[vertex_U] = true;

            for (int vertex_V = 0; vertex_V < vertices; vertex_V++) {
                if (adjMatrix[vertex_U][vertex_V] > 0) {

                    if (!spt[vertex_V] && adjMatrix[vertex_U][vertex_V] != 0 && adjMatrix[vertex_U][vertex_V]!=INFINITY) {
                        int newKey = adjMatrix[vertex_U][vertex_V] + distance[vertex_U];
                        if (newKey < distance[vertex_V])
                        {
                            parents[vertex_V] = vertex_U;
                            distance[vertex_V] = newKey;
                        }
                    }
                }
            }
        }
        printDijkstra(sourceVertex, distance,DestinationVertex,parents);
        return distance[DestinationVertex];
    }
    public static void printDijkstra(int sourceVertex, int [] key,int destVertex,int[] parents){
        for (int i = 0; i <vertices ; i++) {

            if(i==destVertex)
            {
                System.out.println("Distance from " + Location.CodeToName.get(sourceVertex) + " to " + Location.CodeToName.get(+i) +
                        " : " + key[i]+" Km");
                paths[pathCount].setEdge_weight(key[i]);
                CreatePath(i,parents);

            }
        }

        int sizetemp=RecordedPath.size();
        paths[pathCount].setPath(RecordedPath);
        User.NoOfNodes=sizetemp;
        int y=1;
        for(int i=0;i<sizetemp-1;i++)
        {
            RecordedPath.add(y,"->");
            y+=2;
        }

        System.out.println("Travel Path : "+RecordedPath);
        RecordedPath=new ArrayList<>();



    }
    private static void CreatePath(int currentVertex,
                                  int[] parents)
    {
        if (currentVertex == -1)
        {
            return;
        }
        CreatePath(parents[currentVertex], parents);
        RecordedPath.add(Location.CodeToName.get(currentVertex));
    }

}

