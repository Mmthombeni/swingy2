package mmthombe.controllers.gui;

import java.util.Random;

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
        this._fightSimulationModel = new FightSimulationModel(this._model.getHero(), this._model.getVillain(), true);
        this._view.setVisible(true);

        new WhileFightSimulation().start();
    }

    private class WhileFightSimulation extends Thread {
        public void run(){
            try {
                String simulationText = "";
                
                while (_fightSimulationModel.nextFight() == true){
                    simulationText += _fightSimulationModel.getSimulations() + " " + _fightSimulationModel.getSimulationText() + "\n";
                    _view.setTitle(_model.getHero().getName() + " " + _model.getHero().getHP() + "HP vs " + _model.getVillain().getName() + " " + _model.getVillain().getHP() + "HP" );
                    _view.setGameText(simulationText);
                }
                if (_model.getHero().getHP() > 0){
                    _model.heroWonFight();
                    SwingyIO.GUIOutput(Messages.FIGHT_WON);
                    
                    if ((new Random().nextBoolean()) == true){
                        if (SwingyIO.GUIConfirm(Messages.ArtifactMsg(_model.getVillain().getArtifact().toString()))  == true){
                            _model.getHero().setArtifact(_model.getVillain().getArtifact());
                        }
                    }
                }
                else{
                    SwingyIO.GUIOutput(Messages.FIGHT_LOST);
                }
                _view.dispose();
                new GameController(new GameView(), _model);
            } catch (Exception e) {}
        }
    }
}