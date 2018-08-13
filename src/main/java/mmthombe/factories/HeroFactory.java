package mmthombe.factories;

import java.util.ArrayList;
import java.util.List;

import mmthombe.enums.Artifacts;
import mmthombe.model.*;
import mmthombe.model.Character;
import mmthombe.utils.*;


public class HeroFactory{
    public static Character newHero(String name, String type, String xp, String attack, String defence, String hp, String artifact){
       try {
            int _xp = Integer.parseInt(xp);
            int _attack = Integer.parseInt(attack);
            int _defence = Integer.parseInt(defence) ;
            int _hp = Integer.parseInt(hp);
            Artifacts _artifact = Artifacts.valueOf(artifact.toUpperCase());

            name = name.trim();
            if (name == null || name.length() == 0){
                return null;
            }
            if(type.equalsIgnoreCase("knight")){
            return new HeroKnight(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("warrior")){
                return new HeroWarrior(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("doll")){
                return new HeroDoll(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("princess")){
                return new HeroPrincess(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("godd")){
                return new HeroGodd(name, _xp, _attack, _defence, _hp, _artifact);
            }
       } catch (Exception e) {}
        return null;
    }

    public static List<Character> HeroList(){
        List<Character> characters = new ArrayList<Character>();

        try {
           String heros = FileHandler.ReadFile();
           String[] heroArray = heros.split("\n");
           
           for (int i = 0; i < heroArray.length; i++){
                String[] heroData = heroArray[i].trim().split(",");
                
                if (heroData != null && heroData.length == 7){
                    Character hero = newHero(heroData[0].trim(), heroData[1].trim(), heroData[2].trim(), heroData[3].trim(), heroData[4].trim(), heroData[5].trim(), heroData[6].trim());

                    if(hero != null){
                        characters.add(hero);
                    }
                }           
            }
        } catch (Exception e) {}
        return characters;
    } 
}