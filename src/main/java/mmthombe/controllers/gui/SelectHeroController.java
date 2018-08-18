package mmthombe.controllers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mmthombe.view.gui.SelectHeroView;

public class SelectHeroController{
    private SelectHeroView _view;

    public SelectHeroController(SelectHeroView view){
        this._view = view;
        this._view.setVisible(true);
        this._view.setSubmitBtnListner(new SubmitBtnListner());
        
    }

    class SubmitBtnListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
    }

    class CreateBtnListner implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		}
        
    }
}