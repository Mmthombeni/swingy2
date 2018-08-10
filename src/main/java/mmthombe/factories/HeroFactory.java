package mmthombe.factories;

import java.util.List;

import mmthombe.enums.Artifacts;
import mmthombe.model.*;
import mmthombe.model.Character;


public class HeroFactory{
    public static Character newHero(String name, String type, String xp, String attack, String defence, String hp, String artifact){
       try {
            int _xp = Integer.parseInt(xp);
            int _attack = Integer.parseInt(attack);
            int _defence = Integer.parseInt(defence) ;
            int _hp = Integer.parseInt(hp);
            Artifacts _artifact = Artifacts.valueOf(artifact.toUpperCase());

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
        try {
            
        } catch (Exception e) {}
        return null;
    } 
}