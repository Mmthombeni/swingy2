package mmthombe.controllers.console;

import java.util.List;

import mmthombe.factories.HeroFactory;
import mmthombe.model.*;
import mmthombe.model.Character;
import mmthombe.utils.*;
import mmthombe.view.console.GameView;
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
            this.SelectHero();
        }
        else{
            SwingyIO.ConsoleOutputLine("Invaild input please select between 1 and 2");
            this.PickPlayer();
        }
    }

    public void CreateHero(){
        Character nam = OptionView.CreateHero();
        FileHandler.WriteToFile(nam);
        this.PickPlayer();
    }

    public void SelectHero(){
        SelectHeroModel heroModel = new SelectHeroModel();

        if (heroModel.getHeroList().size() == 0){
            SwingyIO.ConsoleOutputLine("No Heros to select from, please create a hero");
            this.PickPlayer();
        }
        else{
            Character hero = OptionView.SelectHero(heroModel);
            new GameController(new GameView(), new GameModel(hero));
        }
    }
}