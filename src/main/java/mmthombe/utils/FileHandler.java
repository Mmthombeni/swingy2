package mmthombe.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHandler{
    public static String ReadFile(){
        String str = "";
        File file = new File("heros.txt");
        try {
            BufferedReader buff =  new BufferedReader(new FileReader(file));
            String st;
            while ((st = buff.readLine()) != null){
                str = str + st + "\n";
            }
            buff.close();
        } catch (Exception e) {}
        return str; 
    }
    

}