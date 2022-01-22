package Others;

import Buses.*;

import java.util.Objects;
import java.util.Scanner;
import java.util.*;

public class User extends Thread{

    private static RedBus rb[]=new RedBus[20];
    private static BlueBus blb[]=new BlueBus[20];
    private static BrownBus brb[]=new BrownBus[20];
    private static GreenBus gb[]=new GreenBus[20];
    private static WhiteBus wb[]=new WhiteBus[20];
    private static WhiteDeluxeBus wdb[]=new WhiteDeluxeBus[20];
    private static int rb_count=0;
    private static int gb_count=0;
    private static int blb_count=0;
    private static int brb_count=0;
    private static int wb_count=0;
    private static int wdb_count=0;

    public static int NoOfNodes;
    public String name;
    private final String PhoneNumber;
    private String busNum;
    public User(String name,String PhoneNumber)
    {
        this.name=name;
        this.PhoneNumber=PhoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getBusNum() {
        return busNum;
    }

    public void invokeSearch(String strt, String end) throws InterruptedException {
        int distance;
        Scanner sc= new Scanner(System.in);
        String choice;
        Thread.sleep(500);
        System.out.println("Refer the Map for all the available location and enter the Start Locations and Destination:");
        Thread.sleep(500);
        System.out.println("START : "+strt);
        Thread.sleep(500);
        System.out.println("END : "+end);
        Thread.sleep(500);
        distance = WeightedGraph.FindShortestPath(strt,end);//Dijkstra's
        if((distance<45 && distance>=25 && NoOfNodes>3)||(distance<25))
        {
            System.out.println("Available Bus Types are A)RED and B)BROWN .");
            Thread.sleep(500);
            System.out.println("Your travel cost from "+strt+" to "+end+" in:");
            Thread.sleep(500);
            int v = (int) (distance * TestDriver.temprb.getCost_Per_Km());
            System.out.println("Red Bus = ₹"+v+" (*EXTRA COMFORT*)");
            Thread.sleep(500);
            int j = (int) (distance * TestDriver.tempbrb.getCost_Per_Km());
            System.out.println("Brown Bus = ₹"+j);
            Thread.sleep(500);
            System.out.print("Enter your choice(A/B) : ");
            choice=sc.nextLine();
            if(Objects.equals(choice, "A"))
            {
                rb[rb_count]=new RedBus();
                rb[rb_count].setRecordedPath(WeightedGraph.paths[WeightedGraph.pathCount]);
                busNum=rb[rb_count].BusName;
                rb[rb_count].getRecordedPath().setAllottedBus("RED");
                System.out.println("Bus Number : "+busNum);
                System.out.println("From : "+strt+" to "+rb[rb_count].getRecordedPath().getStart_End().get(strt));
                System.out.println("Ticket Cost = ₹"+v);
                System.out.print("Approximate Travel Time : ");rb[rb_count].ApproxTimeCalc();
                System.out.println("Type YES to confirm:");
                String temp=sc.nextLine();
                if (Objects.equals(temp, "YES"))
                {
                    rb[rb_count].getTicket(this);
                    System.out.println("------------------------------------------------------------------");
                    rb_count+=1;
                }
                else {
                    System.out.println("------------------------------------------------------------------");
                    return;
                }

            }
            else if(Objects.equals(choice, "B"))
            {
                brb[brb_count]=new BrownBus();
                brb[brb_count].setRecordedPath(WeightedGraph.paths[WeightedGraph.pathCount]);
                busNum=brb[brb_count].BusName;
                brb[brb_count].getRecordedPath().setAllottedBus("BROWN");
                System.out.println("Bus Number : "+busNum);
                System.out.println("From : "+strt+" to "+brb[brb_count].getRecordedPath().getStart_End().get(strt));
                System.out.println("Ticket Cost = ₹"+j);
                System.out.print("Approximate Travel Time : ");brb[brb_count].ApproxTimeCalc();
                System.out.println("Type YES to confirm:");
                String temp=sc.nextLine();
                if (Objects.equals(temp, "YES"))
                {
                    brb[brb_count].getTicket(this);
                    System.out.println("------------------------------------------------------------------");
                    brb_count+=1;
                }
                else {
                    System.out.println("------------------------------------------------------------------");
                    return;
                }

            }

        }
        else if((distance<=100 && distance>=45) || (distance<45 && distance>25) && (NoOfNodes==2 || NoOfNodes==3))
        {
            System.out.println("Available Bus Types are A)BLUE and B)GREEN .");
            Thread.sleep(500);
            System.out.println("Your travel cost from "+strt+" to "+end+" in:");
            Thread.sleep(500);
            int v = (int) (distance * TestDriver.tempblb.getCost_Per_Km());
            System.out.println("Blue Bus = ₹"+v+" (*EXTRA COMFORT*)");
            Thread.sleep(500);
            int j = (int) (distance * TestDriver.tempgb.getCost_Per_Km());
            System.out.println("Green Bus = ₹"+j);
            Thread.sleep(500);
            System.out.print("Enter your choice(A/B) : ");
            choice=sc.nextLine();
            if(Objects.equals(choice, "A"))
            {
                blb[blb_count]=new BlueBus();
                blb[blb_count].setRecordedPath(WeightedGraph.paths[WeightedGraph.pathCount]);
                busNum=blb[blb_count].BusName;
                blb[blb_count].getRecordedPath().setAllottedBus("BLUE");
                System.out.println("Bus Number : "+busNum);
                System.out.println("From : "+strt+" to "+blb[blb_count].getRecordedPath().getStart_End().get(strt));
                System.out.println("Ticket Cost = ₹"+v);
                System.out.print("Approximate Travel Time : ");blb[blb_count].ApproxTimeCalc();
                System.out.println("Type YES to confirm:");
                String temp=sc.nextLine();
                if (Objects.equals(temp, "YES"))
                {
                    blb[blb_count].getTicket(this);
                    System.out.println("------------------------------------------------------------------");
                    blb_count+=1;
                }
                else {
                    System.out.println("------------------------------------------------------------------");
                    return;
                }

            }
            else if(Objects.equals(choice, "B"))
            {
                gb[gb_count]=new GreenBus();
                gb[gb_count].setRecordedPath(WeightedGraph.paths[WeightedGraph.pathCount]);
                busNum=gb[gb_count].BusName;
                gb[gb_count].getRecordedPath().setAllottedBus("GREEN");
                System.out.println("Bus Number : "+busNum);
                System.out.println("From : "+strt+" to "+gb[gb_count].getRecordedPath().getStart_End().get(strt));
                System.out.println("Ticket Cost = ₹"+j);
                System.out.print("Approximate Travel Time : ");gb[gb_count].ApproxTimeCalc();
                System.out.println("Type YES to confirm:");
                String temp=sc.nextLine();
                if (Objects.equals(temp, "YES"))
                {
                    gb[gb_count].getTicket(this);
                    System.out.println("------------------------------------------------------------------");
                    gb_count+=1;
                }
                else {
                    System.out.println("------------------------------------------------------------------");
                    return;
                }

            }

        }
        else if(distance>100)
        {
            System.out.println("Available Bus Types are A)WHITE DELUXE and B)WHITE .");
            Thread.sleep(500);
            System.out.println("Your travel cost from "+strt+" to "+end+" in:");
            Thread.sleep(500);
            int v = (int) (distance * TestDriver.tempwdb.getCost_Per_Km());
            System.out.println("White Deluxe Bus = ₹"+v+" (*SLEEPER*)");
            Thread.sleep(500);
            int j = (int) (distance * TestDriver.tempwb.getCost_Per_Km());
            System.out.println("White Bus = ₹"+j+" (*SEMI SLEEPER*)");
            Thread.sleep(500);
            System.out.print("Enter your choice(A/B) : ");
            choice=sc.nextLine();
            if(Objects.equals(choice, "B"))
            {
                wb[wb_count]=new WhiteBus();
                wb[wb_count].setRecordedPath(WeightedGraph.paths[WeightedGraph.pathCount]);
                busNum=wb[wb_count].BusName;
                wb[wb_count].getRecordedPath().setAllottedBus("WHITE");
                System.out.println("Bus Number : "+busNum);
                System.out.println("From : "+strt+" to "+wb[wb_count].getRecordedPath().getStart_End().get(strt));
                System.out.println("Ticket Cost = ₹"+j);
                System.out.print("Approximate Travel Time : ");wb[wb_count].ApproxTimeCalc();
                System.out.println("Type YES to confirm:");
                String temp=sc.nextLine();
                if (Objects.equals(temp, "YES"))
                {
                    wb[wb_count].getTicket(this);
                    System.out.println("------------------------------------------------------------------");
                    wb_count+=1;
                }
                else {
                    System.out.println("------------------------------------------------------------------");
                    return;
                }

            }
            else if(Objects.equals(choice, "A"))
            {
                wdb[wdb_count]=new WhiteDeluxeBus();
                wdb[wdb_count].setRecordedPath(WeightedGraph.paths[WeightedGraph.pathCount]);
                busNum=wdb[wdb_count].BusName;
                wdb[wdb_count].getRecordedPath().setAllottedBus("WHITEDELUXE");
                System.out.println("Bus Number : "+busNum);
                System.out.println("From : "+strt+" to "+wdb[wdb_count].getRecordedPath().getStart_End().get(strt));
                System.out.println("Ticket Cost = ₹"+j);
                System.out.print("Approximate Travel Time : ");wdb[wdb_count].ApproxTimeCalc();
                System.out.println("Type YES to confirm:");
                String temp=sc.nextLine();
                if (Objects.equals(temp, "YES"))
                {
                    wdb[wdb_count].getTicket(this);
                    System.out.println("------------------------------------------------------------------");
                    wdb_count+=1;
                }
                else {
                    System.out.println("------------------------------------------------------------------");
                    return;
                }

            }
        }
        WeightedGraph.pathCount+=1;
    }


}
