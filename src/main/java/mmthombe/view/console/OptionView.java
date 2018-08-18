package mmthombe.view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mmthombe.enums.Artifacts;
import mmthombe.factories.HeroFactory;
import mmthombe.model.Character;
import mmthombe.model.CreateHeroModel;
import mmthombe.utils.*;

public class OptionView{
    public static int PickPlayer(){
        SwingyIO.ConsoleOutputLine("1. Create a hero.");
        SwingyIO.ConsoleOutputLine("2. Select a hero.");  

        return SwingyIO.ConsoleInputInt();
    }

    public static Character CreateHero(){
        int input;
        String name;
        String types[] = {"Doll", "Godd", "Knight", "Princess", "Warrior"};
        CreateHeroModel newHero = new CreateHeroModel();

        SwingyIO.ConsoleOutput("Enter Hero name: ");
        name = SwingyIO.ConsoleInput().trim();
        if (name == null || name.length() == 0){
            SwingyIO.ConsoleOutputLine("Name can not be empty.");
            return CreateHero();
        }
        SwingyIO.ConsoleOutputLine("Pick Hero Type: 1. Doll, 2. Godd, 3. Knight, 4. Princess, 5. Warrior ");
        
        input = SwingyIO.ConsoleInputInt();

        if (input > 0 && input < 6){
            newHero.setHeroName(name);
            newHero.setHeroType(types[input-1]);
            return newHero.getHero();
        }
        SwingyIO.ConsoleOutputLine("Invaild input, please choose from the above list.");
        return CreateHero();
    }

    public static Character SelectHero(List<Character> heros){
        SwingyIO.ConsoleOutputLine("Selection of hero on list");
        String data = "";
        int counter = 1;
        int heroSelected;

        for (Character hero : heros) {
            data = counter + ". " + hero.getName() + ", " + hero.getClass().getSimpleName().substring(4) + ", " + hero.getXP() + ", " + hero.getAttack() + ", " + hero.getDefense() + ", " + hero.getHP() + ", " + hero.getArtifact() + "\n";
            counter++;
            SwingyIO.ConsoleOutput(data);
        }
        heroSelected = SwingyIO.ConsoleInputInt();
        if (heroSelected > 0 && heroSelected <= heros.size()){
            return heros.get(heroSelected - 1);
        }
        SwingyIO.ConsoleOutputLine("Invaild input, please choose from the above list.");
        return SelectHero(heros);
     }
}