package mmthombe.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import mmthombe.factories.HeroFactory;
import mmthombe.model.Character;

public class FileHandler{
    private final static String fileName = "heros.txt";

    public static String ReadFile(){
        String str = "";
        File file = new File(fileName);
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

    public static boolean WriteToFile(Character new_hero){
        try {
            List<Character> heros = HeroFactory.HeroList();
            PrintWriter writeToFile = new PrintWriter(new File(fileName));
            String data = "";
            
            for (Character hero : heros) {
                data += hero.getName() + "," + hero.getClass().getSimpleName().substring(4) + "," + hero.getXP() + "," + hero.getAttack() + "," + hero.getDefense() + "," + hero.getHP() + "," + hero.getArtifact() + "\n";
            }
            if (new_hero != null ){
                data += new_hero.getName() + "," + new_hero.getClass().getSimpleName().substring(4) + "," + new_hero.getXP() + "," + new_hero.getAttack() + "," + new_hero.getDefense() + "," + new_hero.getHP() + "," + new_hero.getArtifact();
            }
            writeToFile.println(data);
            writeToFile.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean updateHero(String data) {
        try {
            PrintWriter writeToFile = new PrintWriter(new File(fileName));
            writeToFile.println(data);
            writeToFile.close();
            return (true);
        } catch (Exception e) {
            return false;
        }
    }

}