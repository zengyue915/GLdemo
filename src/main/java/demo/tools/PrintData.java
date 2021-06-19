package demo.tools;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintData {
    public static void printList(String[] strings){
        for(int i=0; i<strings.length; i++){
            System.out.println(strings[i]);
        }
    }

    public static void printMap(HashMap<String, Integer> map){
        for(String key:map.keySet()){
            System.out.println(key+": "+ map.get(key));
        }
    }
}
