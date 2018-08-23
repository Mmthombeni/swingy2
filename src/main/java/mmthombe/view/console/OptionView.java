package mmthombe.view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mmthombe.enums.Artifacts;
import mmthombe.factories.HeroFactory;
import mmthombe.model.Character;
import mmthombe.model.CreateHeroModel;
import mmthombe.model.SelectHeroModel;
import mmthombe.utils.*;

public class OptionView{
    public static int PickPlayer(){
        SwingyIO.ConsoleOutputLine("1. Create a hero.");
        SwingyIO.ConsoleOutputLine("2. Select a hero.");
        SwingyIO.ConsoleOutputLine("3. Quit game.");  

        return SwingyIO.ConsoleInputInt();
    }

    public static Character CreateHero(){
        int input;
        String name;
        //back button
        String types[] = {"Doll", "Godd", "Knight", "Princess", "Warrior"};
        CreateHeroModel newHero = new CreateHeroModel();

        SwingyIO.ConsoleOutput("Enter Hero name: ");
        name = SwingyIO.ConsoleInput().trim();
        if (name == null || name.length() == 0){
            SwingyIO.ConsoleOutputLine("Name can not be empty.");
            return CreateHero();
        }
        
        SwingyIO.ConsoleOutputLine("Pick Hero Type: ");
        SwingyIO.ConsoleOutputLine("1. Doll");
        SwingyIO.ConsoleOutputLine("2. Godd");
        SwingyIO.ConsoleOutputLine("3. Knight");
        SwingyIO.ConsoleOutputLine("4. Princess");
        SwingyIO.ConsoleOutputLine("5. Warrior");
        
        input = SwingyIO.ConsoleInputInt();

        if (input > 0 && input < 6){
            newHero.setHeroName(name);
            newHero.setHeroType(types[input-1]);
            return newHero.getHero();
        }
        SwingyIO.ConsoleOutputLine("Invaild input, please choose from the above list.");
        return CreateHero();
    }

    public static Character SelectHero(SelectHeroModel model){
        SwingyIO.ConsoleOutputLine("Selection of hero on list");
        //back option
        String data = "";
        Character hero;

        for (int i = 0; i < model.getHeros().length; i++){
            data += (i + 1) + ". " + model.getHeros()[i] + "\n";
        }
        SwingyIO.ConsoleOutputLine(data);

        hero = model.getSelectedHero(SwingyIO.ConsoleInputInt() - 1);
        if (hero != null){
            return hero;
        }
        SwingyIO.ConsoleOutputLine("Invaild input, please choose from the above list.");
        return SelectHero(model);
     }
}