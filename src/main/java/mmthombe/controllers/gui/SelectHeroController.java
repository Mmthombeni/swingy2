package mmthombe.controllers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mmthombe.model.Character;
import mmthombe.model.CreateHeroModel;
import mmthombe.model.GameModel;
import mmthombe.model.SelectHeroModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.CreateHeroView;
import mmthombe.view.gui.GameView;
import mmthombe.view.gui.SelectHeroView;

public class SelectHeroController{
    private SelectHeroView _view;
    private SelectHeroModel _model;

    public SelectHeroController(SelectHeroView view, SelectHeroModel model){
        this._view = view;
        this._model = model;

        this._view.setVisible(true);
        this._view.setPlayBtnListner(new PlayBtnListner());
        this._view.setCreateBtnListner(new CreateBtnListner());       
    }

    class PlayBtnListner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Character hero = _model.getSelectedHero(_view.getSelectedHero());
            
            if (hero == null ){
                SwingyIO.GUIOutput("Please Select a hero");
            }
            else{
                _view.dispose();
                new GameController(new GameView(), new GameModel(hero));
            }
        }
    }

    class CreateBtnListner implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            _view.dispose();
            new CreateHeroController(new CreateHeroModel(), new CreateHeroView());
        }
    }
}