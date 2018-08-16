package mmthombe.controllers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.CreateSelectHeroView;

public class CreateSelectHeroController{
    private CreateSelectHeroView _view;

    public CreateSelectHeroController(CreateSelectHeroView view){
        this._view = view;
        this._view.setVisible(true);
        this._view.createButtonListner(new CreateButtonListner());
        this._view.selectButtonListner(new SelectButtonListner());
    }

    class CreateButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
           SwingyIO.ConsoleOutputLine("control");
		}
    }

    class SelectButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
           SwingyIO.ConsoleOutputLine("select");
		}
    }
}