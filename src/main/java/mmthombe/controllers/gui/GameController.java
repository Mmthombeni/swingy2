package mmthombe.controllers.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mmthombe.messages.Messages;
import mmthombe.model.FightSimulationModel;
import mmthombe.model.GameModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.GameView;

public class GameController{
    private GameView _view;
    private GameModel _model;

    public GameController(GameView view, GameModel model){
        this._view = view;
        this._model = model;

        this._view.setVisible(true);
        this._view.setGameTitle(this._model.getHero().getName() + "  -  " + this._model.getHero().getHP() + "HP");
        this._view.setKeyListener(new PressedKeyListener());

        this.drawGame();
    }

    private void drawGame(){
        this._model.drawMap();
        this._view.setGameText(this._model.getMap());

        if (this._model.isHeroWithinMap() && this._model.isHeroAlive()){
            if (this._model.getMatchPostion()){
                boolean heroChoice = SwingyIO.GUIConfirm("You have encounted a villian would you like to run(Yes) or fight(No)?");
                
                if (heroChoice == true){
                    if (this._model.run() == true){
                        SwingyIO.GUIOutput(Messages.RUN_MESSAGE);
                        this._model.doRun();
                        this.drawGame();
                    }else{
                        SwingyIO.GUIOutput(Messages.FORCE_FIGHT_MSG);
                        this.fight();
                    }
                }else{
                    this.fight();
                }
            }
        }
        else{
            if (this._model.isHeroWithinMap() == false){
                this._model.heroWonGame();
                SwingyIO.GUIOutput(Messages.GAME_OVER_WON);
            }else{
                SwingyIO.GUIOutput(Messages.GAME_OVER_LOST);
            }
            this._view.dispose();
        }
    }

    private void fight(){
        FightSimulationModel fightSM = new FightSimulationModel(this._model.getHero(), this._model.getVillain(), true);

        try {
            while (fightSM.nextFight() == true){
                SwingyIO.ConsoleOutputLine(fightSM.getSimulations() + " " + fightSM.getSimulationText());
            }
            if (this._model.getHero().getHP() > 0){
                this._model.heroWonFight();
                SwingyIO.GUIOutput(Messages.FIGHT_WON);
                //SwingyIO.ConsoleOutputLine(this._model.getVillain() + " died and droped " + this._model.getVillain().getArtifact() + " would you like pick it up?");
                
                // if (this._view.artifactDrop() == true){
                //     if (this._view.takeArtifact() == 1){
                //         this._model.getHero().setArtifact(this._model.getVillain().getArtifact());
                //     }
                // }
            }
            else{
                SwingyIO.GUIOutput(Messages.FIGHT_LOST);
            }
        } catch (Exception e) {}
        drawGame();
    }

    class PressedKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {}

		public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            _model.setHeroPreviousPosition(_model.getHero().getCoodrinates());
            
            if (key == 38){
               _model.moveNorth();
            }
            else if (key == 40){
                _model.moveSouth();
            }
            else if (key == 37){
                _model.moveWest();
            }
            else if (key == 39){
                _model.moveEast();
            }
            else{
                SwingyIO.GUIOutput("Invalid input, please use arrows to navigate");
            }

            drawGame();
		}
    }
}