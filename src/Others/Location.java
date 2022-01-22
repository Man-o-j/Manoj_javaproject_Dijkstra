package Others;

import java.util.HashMap;

public class Location {
    public static HashMap<Integer,String> CodeToName= new HashMap<>();//To convert place name to code
    public static HashMap<String,Integer> NameToCode= new HashMap<>();//To convert place name to code
    public static void initHashmap()
    {
        NameToCode.put("Gandhipuram",0);
        NameToCode.put("Metupalayam",1);
        NameToCode.put("Ooty",2);
        NameToCode.put("Erode",3);
        NameToCode.put("Ukkadam",4);
        NameToCode.put("Kinathukadavu",5);
        NameToCode.put("Pollachi",6);
        NameToCode.put("Aaliyar",7);
        NameToCode.put("Amrita University",8);
        NameToCode.put("Chennai",9);
        NameToCode.put("Madurai",10);
        NameToCode.put("Bangalore",11);
        NameToCode.put("Flower Market",12);
        NameToCode.put("GCT",13);
        NameToCode.put("Saibaba Colony",14);
        NameToCode.put("Railway Station",15);
        NameToCode.put("VOC Park",16);
        NameToCode.put("Lakshmi Mills",17);
        NameToCode.put("Hope College",18);
        NameToCode.put("Vilankurachi",19);
        NameToCode.put("Airport",20);
        NameToCode.put("Omni Busstand",21);
        NameToCode.put("Saravanapatti",22);
        //------------
        CodeToName.put(0,"Gandhipuram");
        CodeToName.put(1,"Metupalayam");
        CodeToName.put(2,"Ooty");
        CodeToName.put(3,"Erode");
        CodeToName.put(4,"Ukkadam");
        CodeToName.put(5,"Kinathukadavu");
        CodeToName.put(6,"Pollachi");
        CodeToName.put(7,"Aaliyar");
        CodeToName.put(8,"Amrita University");
        CodeToName.put(9,"Chennai");
        CodeToName.put(10,"Madurai");
        CodeToName.put(11,"Bangalore");
        CodeToName.put(12,"Flower Market");
        CodeToName.put(13,"GCT");
        CodeToName.put(14,"Saibaba Colony");
        CodeToName.put(15,"Railway Station");
        CodeToName.put(16,"VOC Park");
        CodeToName.put(17,"Lakshmi Mills");
        CodeToName.put(18,"Hope College");
        CodeToName.put(19,"Vilankurachi");
        CodeToName.put(20,"Airport");
        CodeToName.put(21,"Omni Busstand");
        CodeToName.put(22,"Saravanapatti");
    }

}
