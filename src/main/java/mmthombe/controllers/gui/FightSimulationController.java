package mmthombe.controllers.gui;

import mmthombe.messages.Messages;
import mmthombe.model.FightSimulationModel;
import mmthombe.model.GameModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.GameView;

public class FightSimulationController{
    private FightSimulationModel _fightSimulationModel;
    private GameModel _model;
    private GameView _view;
    
    public FightSimulationController(GameView view, GameModel model){
        this._view = view;
        this._model = model;
        this._fightSimulationModel = new FightSimulationModel(this._model.getHero(), this._model.getVillain(), false);
        this._view.setVisible(true);

        new WhileFightSimulation().start();
    }

    private class WhileFightSimulation extends Thread {
        public void run(){
            try {
                while (_fightSimulationModel.nextFight() == true){
                    _view.setGameText(_fightSimulationModel.getSimulations() + " " + _fightSimulationModel.getSimulationText());
                }
                if (_model.getHero().getHP() > 0){
                    _model.heroWonFight();
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
        }
    }
}