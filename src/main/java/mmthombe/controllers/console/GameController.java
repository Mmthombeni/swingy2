package mmthombe.controllers.console;

import mmthombe.model.GameModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.console.GameView;

public class GameController{
    public GameController(GameView view, GameModel model){
        SwingyIO.ConsoleOutputLine(model.getHero().getLevel() + "\n\n" + model.getMap());
    }
}