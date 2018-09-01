package mmthombe.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import mmthombe.enums.Artifacts;
import mmthombe.model.*;
import mmthombe.model.Character;
import mmthombe.utils.*;


public class HeroFactory{
    private static Validator validator;

    public static Character newHero(String name, String type, String xp, String attack, String defence, String hp, String artifact){
       try {
            int _xp = Integer.parseInt(xp);
            int _attack = Integer.parseInt(attack);
            int _defence = Integer.parseInt(defence) ;
            int _hp = Integer.parseInt(hp);
            Artifacts _artifact = Artifacts.valueOf(artifact.toUpperCase());
            Character hero = null;

            name = name.trim();
            // if (name == null || name.length() == 0){
            //     return null;
            // }
            
            if(type.equalsIgnoreCase("knight")){
                hero = new HeroKnight(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("warrior")){
                hero = new HeroWarrior(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("doll")){
                hero = new HeroDoll(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("princess")){
                hero = new HeroPrincess(name, _xp, _attack, _defence, _hp, _artifact);
            }
            else if(type.equalsIgnoreCase("godd")){
                hero = new HeroGodd(name, _xp, _attack, _defence, _hp, _artifact);
            }

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
            Set<ConstraintViolation<Character>> constraintViolations = validator.validate(hero);

            if (constraintViolations.size() == 0){
                return hero;
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