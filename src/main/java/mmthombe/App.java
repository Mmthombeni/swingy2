package mmthombe;

import mmthombe.controllers.console.OptionController;
import mmthombe.controllers.gui.CreateSelectHeroController;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.CreateSelectHeroView;

public class App 
{
    public static void main( String[] args )
    {
        if(args.length == 1 ){
            if(args[0].equalsIgnoreCase("console")){
                new OptionController().PickPlayer();
                return;
            }
            else if(args[0].equalsIgnoreCase("gui")){
                new CreateSelectHeroController(new CreateSelectHeroView());
                return;
            }
        }
        SwingyIO.ConsoleOutput("Invaild argument, argument should be either console or gui");
    }
}
