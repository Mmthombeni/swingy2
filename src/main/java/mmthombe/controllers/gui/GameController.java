package mmthombe.controllers.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    }

    class PressedKeyListener implements KeyListener {
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {}

		public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            
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