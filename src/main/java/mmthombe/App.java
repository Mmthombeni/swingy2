package mmthombe;

import mmthombe.controllers.console.GameController;
import mmthombe.controllers.console.OptionController;
import mmthombe.controllers.gui.CreateSelectHeroController;
import mmthombe.factories.HeroFactory;
import mmthombe.model.GameModel;
import mmthombe.utils.SwingyIO;
import mmthombe.view.console.GameView;
import mmthombe.view.gui.CreateSelectHeroView;

public class App 
{
    public static void main( String[] args )
    {
        // new GameController(new GameView(), new GameModel(HeroFactory.HeroList().get(0)));

        if(args.length == 1 ){
            if(args[0].equalsIgnoreCase("console")){
                new OptionController().PickPlayer();
                return;
            }
            else if(args[0].equalsIgnoreCase("gui")){
                SwingyIO.ConsoleOutputLine("Running on GUI");
                new CreateSelectHeroController(new CreateSelectHeroView());
                return;
            }
        }
        SwingyIO.ConsoleOutput("Invaild argument, argument should be either console or gui");
    }
}
