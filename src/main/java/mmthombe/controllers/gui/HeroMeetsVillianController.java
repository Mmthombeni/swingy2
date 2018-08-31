package mmthombe.controllers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mmthombe.model.GameModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.HeroMeetsVillianView;

public class HeroMeetsVillianController{
    private HeroMeetsVillianView _view;
    private GameModel _model;

    public HeroMeetsVillianController(HeroMeetsVillianView view, GameModel model){
        this._view = view;
        this._model = model;

    }

    class RunButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            if (_model.run() == true){
                SwingyIO.GUIOutput("You lucky thing, will get you next time");
                _model.doRun();
            }
		}
    }

    class FightButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
    }
}