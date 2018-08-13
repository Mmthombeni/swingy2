package mmthombe.view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mmthombe.enums.Artifacts;
import mmthombe.factories.HeroFactory;
import mmthombe.model.Character;
import mmthombe.utils.*;

public class OptionView{
    public static int PickPlayer(){
        SwingyIO.ConsoleOutputLine("1. Create a hero.");
        SwingyIO.ConsoleOutputLine("2. Select a hero.");  

        return SwingyIO.ConsoleInputInt();
    }

    public static Character CreateHero(){
        String type = "";
        int input;
        String name;
        String types[] = {"Doll", "Godd", "Knight", "Princess", "Warrior"};
        String[] artifact = {"WEAPON", "ARMOR", "HELM"};
        Random random = new Random();
        String _artifact = artifact[random.nextInt(artifact.length)];

        SwingyIO.ConsoleOutput("Enter Hero name: ");
        name = SwingyIO.ConsoleInput().trim();
        if (name == null || name.length() == 0){
            SwingyIO.ConsoleOutputLine("Name can not be empty.");
            return CreateHero();
        }
        SwingyIO.ConsoleOutputLine("Pick Hero Type: 1. Doll, 2. Godd, 3. Knight, 4. Princess, 5. Warrior ");
        
        input = SwingyIO.ConsoleInputInt();

        if (input > 0 && input < 6){
            type = types[input - 1];
        }
        else{
            SwingyIO.ConsoleOutputLine("Invaild input, please choose from the above list.");
            return CreateHero();
        }
        return HeroFactory.newHero(name, type, "0", "0", "0", "0", _artifact);
    }

    // public static Character SelectHero(){
    //     List<Character> character = new ArrayList<Character>();
    //     character = HeroFactory.HeroList();

    //     for (Character characters : character) {
    //         SwingyIO.ConsoleOutput(HeroFactory.getName());
    //     }
    //     return HeroFactory.newHero("name", "type", "xp", "attack", "defence", "hp", "artifact");
    // }
}