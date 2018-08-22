package mmthombe.controllers.console;

import mmthombe.model.GameModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.console.GameView;

public class GameController{
    private GameView _view;
    private GameModel _model;

    public GameController(GameView view, GameModel model){
        this._view = view;
        this._model = model;
        
        this.startGame();
    }

    private void startGame(){
        while(this._model.isHeroWithinMap() && this._model.isHeroAlive()){
            SwingyIO.ConsoleOutput("\n" + this._model.getHero().getName() + "-  " + this._model.getHero().getHP() + "HP\n\n" );
            SwingyIO.ConsoleOutputLine(this._model.getMap());
            this.playerMovement();

            this._model.getHero().setHP(this._model.getHero().getHP() - 2);
        }

        if (this._model.isHeroWithinMap() == false){
            this._model.heroWonGame();
            //write to file
        }
        new OptionController().PickPlayer();
    }

    private void playerMovement(){
        String input = this._view.gameInstructions();
        
        if (input.equalsIgnoreCase("N") || input.equalsIgnoreCase("1") || input.equalsIgnoreCase("North")){
            this._model.moveNorth();
        }
        else if (input.equalsIgnoreCase("S") || input.equalsIgnoreCase("4") || input.equalsIgnoreCase("South")){
            this._model.moveSouth();
        }
        else if (input.equalsIgnoreCase("W") || input.equalsIgnoreCase("2") || input.equalsIgnoreCase("West")){
            this._model.moveWest();
        }
        else if (input.equalsIgnoreCase("E") || input.equalsIgnoreCase("3") || input.equalsIgnoreCase("East")){
            this._model.moveEast();
        }
        else {
            SwingyIO.ConsoleOutputLine("Please pick the correct input.");
        }
    }
}