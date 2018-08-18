package mmthombe.controllers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mmthombe.model.CreateHeroModel;
import mmthombe.utils.FileHandler;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.CreateHeroView;
import mmthombe.view.gui.CreateSelectHeroView;

public class CreateHeroController{
    private CreateHeroView _view;
    private CreateHeroModel _model;

    public CreateHeroController(CreateHeroModel model, CreateHeroView view){
        this._view = view;
        this._model = model;

        this._view.setVisible(true);
        this._view.setSubmitButtonListner(new SubmitButtonListner());
        this._view.setBackButtonListner(new BackButtonListner());
    }

    class SubmitButtonListner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (_view.getHeroName().length() > 0){
                _model.setHeroName(_view.getHeroName());
                _model.setHeroType(_view.getHeroType());

                if (FileHandler.WriteToFile(_model.getHero()) == true){
                    SwingyIO.GUIOutput("Hero created successfully");
                }
                else{
                    SwingyIO.GUIOutput("Could not create hero");
                }

                new CreateSelectHeroController(new CreateSelectHeroView());
                _view.dispose();
            }
            else{
                SwingyIO.GUIOutput("Please ensure you typed a name for your new hero");
            }
        }
    }

    class BackButtonListner implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            new CreateSelectHeroController(new CreateSelectHeroView());
            _view.dispose();
        }
    }
}