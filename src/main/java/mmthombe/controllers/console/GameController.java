package mmthombe.controllers.console;

import mmthombe.messages.Messages;
import mmthombe.model.FightSimulationModel;
import mmthombe.model.GameModel;
import mmthombe.utils.*;
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
            SwingyIO.ConsoleOutput(this._model.getHero().getName() + " - " + this._model.getHero().getAttack() + "attack " + this._model.getHero().getDefense() + "defence " + this._model.getHero().getHP() + "HP\n\n" );
            SwingyIO.ConsoleOutput("\n" + this._model.getHero().getCoodrinates().getX() + "x, " + this._model.getHero().getCoodrinates().getY() + "y" + "\n\n" );
            this._model.drawMap();
            SwingyIO.ConsoleOutputLine(this._model.getMap());
            

            if (this._model.getMatchPostion()){
                int heroChoice = this._view.heroColliedVillian(this._model.getVillain());

                if (heroChoice == 1){
                    if (this._model.run() == true){
                        SwingyIO.ConsoleOutputLine(Messages.RUN_MESSAGE);
                        SwingyIO.ConsoleOutputLine(Messages.CONTINUE_MESSAGE);
                        SwingyIO.ConsoleInput();
                        this._model.doRun();
                    }else{
                        SwingyIO.ConsoleOutputLine(Messages.FORCE_FIGHT_MSG);
                        SwingyIO.ConsoleOutputLine(Messages.CONTINUE_MESSAGE);
                        SwingyIO.ConsoleInput();
                        this.fight();
                    }
                }
                else{
                    this.fight();
                }
            }
            else{
                this._model.setHeroPreviousPosition(this._model.getHero().getCoodrinates());
                this.playerMovement();
            }
        }

        if (this._model.isHeroWithinMap() == false){
            this._model.heroWonGame();
            SwingyIO.ConsoleOutputLine(Messages.GAME_OVER_WON);
        }else{
            SwingyIO.ConsoleOutputLine(Messages.GAME_OVER_LOST);
        }
        SwingyIO.ConsoleInput();
        new OptionController().PickPlayer();
    }

    private void fight(){
        FightSimulationModel fightSM = new FightSimulationModel(this._model.getHero(), this._model.getVillain(), true);

        try {
            while (fightSM.nextFight() == true){
                SwingyIO.ConsoleOutputLine(fightSM.getSimulations() + " " + fightSM.getSimulationText());
            }
            if (this._model.getHero().getHP() > 0){
                this._model.heroWonFight();
                SwingyIO.ConsoleOutputLine(Messages.FIGHT_WON);
                
                if (this._view.artifactDrop() == true){
                    if (this._view.takeArtifact(this._model.getVillain().getArtifact()) == 1){
                        this._model.getHero().setArtifact(this._model.getVillain().getArtifact());
                    }
                }
            }
            else{
                SwingyIO.ConsoleOutputLine(Messages.FIGHT_LOST);
            }
            SwingyIO.ConsoleOutputLine(Messages.CONTINUE_MESSAGE);
            SwingyIO.ConsoleInput();
        } catch (Exception e) {}
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
            SwingyIO.ConsoleOutputLine(Messages.INVALID_INPUT);
        }
    }
}