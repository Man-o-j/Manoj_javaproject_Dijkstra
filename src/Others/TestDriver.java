package Others;

import Buses.*;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.lang.Thread;

public class TestDriver extends Thread{
    private static boolean brain=true;
    public static final int userCount=10;
    public static BlueBus tempblb=new BlueBus();
    public static BrownBus tempbrb=new BrownBus();
    public static RedBus temprb=new RedBus();
    public static GreenBus tempgb=new GreenBus();
    public static WhiteDeluxeBus tempwdb=new WhiteDeluxeBus();
    public static WhiteBus tempwb=new WhiteBus();
    public static int ticketCount=0;
    public static Ticket[] ticket =new Ticket[5];
    public static User[] user =new User[5];
    public static void main(String[] args) throws InterruptedException, IOException {
        DisplayImage disp=new DisplayImage();
        Thread t1= new Thread(disp);
        t1.start();//Displaying the image in a separate thread
        String st,en;
        WeightedGraph.initGraph();
        ArrayList<String> tempuser= new ArrayList<>();
        ArrayList<String> templocat= new ArrayList<>();
        ArrayList<String> tempalter= new ArrayList<>();
        ArrayList<String> tempyon= new ArrayList<>();
        String [][] userfile= new String[5][2];
        String [][] locationfile= new String[5][2];
        String [][] alterlocation= new String[4][2];
        String [] yon= new String[3];
        Scanner sc= new Scanner(System.in);
        Hurdle toll= new Hurdle("Toll",1);
        Hurdle badWeather= new Hurdle("Bad Weather",1);
        Hurdle Block=new Hurdle("Block->Take Diversion",3);
        String data;
        try {//Reading the alter location from file
                        File myObj = new File("src//alter.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                            if(!Objects.equals(data,"empty")){
                                tempalter.add(data);
                            }

                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File Not Found");
                        e.printStackTrace();
                    }
                    for(int i=0;i<4;i++)//implement queue
                    {
                        alterlocation[i][0]=tempalter.get(0);
                        tempalter.remove(0);
                        alterlocation[i][1]=tempalter.get(0);
                        tempalter.remove(0);

                    }


        try {//Reading yes or no for alter edge weight
                        File myObj = new File("src//yon.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                            if(!Objects.equals(data,"empty")){
                                tempyon.add(data);
                            }

                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File Not Found");
                        e.printStackTrace();
                    }
                    for(int i=0;i<3;i++)//implement queue
                    {
                        yon[i]=tempyon.get(0);
                        tempyon.remove(0);
                    }
        int userCount=0;
        int userFileCount=0;
        String YesorNo= "Y";

        do{
            System.out.println("1.Alter Edge Weight\n2.Ticket Booking\n3.View Booked Tickets\n4.Exit");
            System.out.println("------------------------------------------------------------------");
            int value;
            value=sc.nextInt();

            System.out.println("------------------------------------------------------------------");
            switch (value) {
                case 1: {
                    int loop = 0;
                    int alter=0;
                    int cyon=0;
                    while (Objects.equals(YesorNo, "Y") || Objects.equals(YesorNo, "y")) {

                        int i = 0;

                        do {

                            if (i != 0) {
                                System.out.println("You have entered incorrect location names.Please re enter the correct name.Refer the map image");
                            }
                            System.out.println("Enter the Starting and Ending point names:");
                            System.out.println("---------------");
                            Thread.sleep(750);
                            if (loop == 0) {
                               // st = sc.nextLine();
                            }
                            //st = sc.nextLine();
                            //en = sc.nextLine();
                            st = alterlocation[alter][0];
                            en = alterlocation[alter][1];
                            System.out.println(st);
                            Thread.sleep(750);
                            System.out.println(en);
                            System.out.println("---------------");
                            Thread.sleep(750);
                            alter++;
                            i++;
                        } while (!Location.NameToCode.containsKey(st) || !Location.NameToCode.containsKey(en));
                        if (WeightedGraph.edgeCheck(st, en)) {

                            System.out.println("Enter the Hurdle Faced \n1.Toll\n2.Bad Weather\n3.Block->Take Diversion");
                            int b = (int)(Math.random()*(3-1+1)+1);
                            int hurd = b;
                            System.out.println("--");
                            System.out.println(b);
                            System.out.println("--");
                            Thread.sleep(750);
                            if (hurd == 1) {

                                toll.alterEdgeWeight(st, en);
                            } else if (hurd == 2) {
                                badWeather.alterEdgeWeight(st, en);
                            }
                            else {
                                Block.alterEdgeWeight(st, en);
                            }
                            System.out.println("Any other Hurdle?[Y/N]");
                            Thread.sleep(750);
                            YesorNo = yon[cyon];
                            System.out.println(YesorNo);
                            Thread.sleep(750);
                            System.out.println("-------------------------------------------");
                            cyon++;
                            loop += 1;

                        } else if (!WeightedGraph.edgeCheck(st, en)) {
                            System.out.println("There is no direct path connecting the entered locations");
                            Thread.sleep(1100);
                            System.out.println("Any other Hurdle?[Y/N]");
                            Thread.sleep(750);
                            YesorNo = yon[cyon];
                            System.out.println(YesorNo);
                            Thread.sleep(750);
                            System.out.println("-------------------------------------------");
                            cyon++;
                        }

                    }
                    break;
                }
                case 2: {
                    try {
                        File myObj = new File("src//name.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                            if(!Objects.equals(data,"empty")){
                                tempuser.add(data);
                            }

                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File Not Found");
                        e.printStackTrace();
                    }
                    for(int i=0;i<5;i++)//implement queue
                    {
                        userfile[i][0]=tempuser.get(0);
                        tempuser.remove(0);
                        userfile[i][1]=tempuser.get(0);
                        tempuser.remove(0);

                    }
                    try {
                        File myloc = new File("src//place.txt");
                        Scanner myReader = new Scanner(myloc);
                        while (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                            if(!Objects.equals(data,"empty")){
                                templocat.add(data);
                            }

                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File Not Found");
                        e.printStackTrace();
                    }
                    for(int i=0;i<5;i++)//implement queue
                    {
                        locationfile[i][0]=templocat.get(0);
                        templocat.remove(0);
                        locationfile[i][1]=templocat.get(0);
                        templocat.remove(0);

                    }
                    for (int k = 0; k < 5; k++) {
                        user[k] = new User(userfile[k][0], userfile[k][1]);
                        Thread.sleep(500);
                        System.out.print("Enter the Name of the Customer: ");
                        Thread.sleep(500);
                        System.out.println(user[k].name);
                        Thread.sleep(500);
                        System.out.print("Enter the Phone Number: ");
                        Thread.sleep(500);
                        System.out.println(user[k].getPhoneNumber());
                        Thread.sleep(500);
                        user[k].invokeSearch(locationfile[k][0],locationfile[k][1]);

                    }
                    break;

                }
                case 3: {
                    int tempCount=0;
                    System.out.println("Number of Tickets booked : "+ticketCount);
                    Thread.sleep(900);
                    System.out.println("------------------------");
                    Thread.sleep(900);
                    for(Ticket arr:ticket) {
                        if (tempCount == ticketCount)
                            break;
                        System.out.println(arr.getMailData());
                        Thread.sleep(1500);
                        System.out.println("------------------------");
                        Thread.sleep(900);
                        tempCount += 1;
                    }


                }break;
                case 4:
                {
                    brain=false;
                    DisplayImage.frame.dispose();

                }//
            }
        }while(brain);
        System.out.println("Thank you");
    }
}
