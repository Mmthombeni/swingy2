package mmthombe.controllers.console;

import mmthombe.model.*;
import mmthombe.model.Character;
import mmthombe.utils.*;
import mmthombe.view.console.OptionView;

public class OptionController{
    public void PickPlayer(){
        int selection = OptionView.PickPlayer();

        if (selection == 1){
            SwingyIO.ConsoleOutputLine("hero to create.");
            this.CreateHero();
        }
        else if (selection == 2){
            SwingyIO.ConsoleOutputLine("hero to select.");
        }
        else{
            SwingyIO.ConsoleOutputLine("Invaild input please select between 1 and 2");
            this.PickPlayer();
        }
    }

    public void CreateHero(){
        Character nam = OptionView.CreateHero();
        FileHandler.WriteToFile(nam);
    }
}