package mmthombe.controllers.gui;

import mmthombe.model.GameModel;
import mmthombe.view.gui.GameView;

public class GameController{
    private GameView _view;
    public GameController(GameView view, GameModel model){
        this._view = view;

        this._view.setVisible(true);
        
    }
}