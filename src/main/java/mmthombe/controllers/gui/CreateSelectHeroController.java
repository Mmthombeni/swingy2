package mmthombe.controllers.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mmthombe.model.CreateHeroModel;
import mmthombe.model.SelectHeroModel;
import mmthombe.view.gui.CreateHeroView;
import mmthombe.view.gui.CreateSelectHeroView;
import mmthombe.view.gui.SelectHeroView;

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
      new CreateHeroController(new CreateHeroModel(),new CreateHeroView());
      _view.dispose();
    }
  }

  class SelectButtonListner implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      SelectHeroModel heroModel = new SelectHeroModel();
      new SelectHeroController(new SelectHeroView(heroModel.getHeros()), heroModel);
      _view.dispose();
    }
  }
}