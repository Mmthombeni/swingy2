package mmthombe;

import java.util.logging.Level;
import java.util.logging.Logger;

import mmthombe.config.Config;
import mmthombe.controllers.console.OptionController;
import mmthombe.controllers.gui.CreateSelectHeroController;
import mmthombe.enums.DisplayMode;
import mmthombe.utils.SwingyIO;
import mmthombe.view.gui.CreateSelectHeroView;

public class App 
{
    public static void main( String[] args )
    {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        new Config().init(args);

        if(Config.DISPLAY_MODE == DisplayMode.CONSOLE){
            new OptionController().PickPlayer();
            return;
        }
        else if(Config.DISPLAY_MODE == DisplayMode.GUI){
            SwingyIO.ConsoleOutputLine("Running on GUI");
            new CreateSelectHeroController(new CreateSelectHeroView());
            return;
        }
        SwingyIO.ConsoleOutput("Invaild argument, argument should be either console or gui");
    }
}
