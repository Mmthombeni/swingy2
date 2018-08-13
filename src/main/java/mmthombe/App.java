package mmthombe;

import mmthombe.controllers.console.OptionController;
import mmthombe.utils.SwingyIO;

public class App 
{
    public static void main( String[] args )
    {
        if(args.length == 1 ){
            if(args[0].equalsIgnoreCase("console")){
                OptionController control = new OptionController();
                control.PickPlayer();
                return;
            }
            else if(args[0].equalsIgnoreCase("gui")){
                SwingyIO.ConsoleOutput("gui mode");
                return;
            }
        }
        SwingyIO.ConsoleOutput("Invaild argument, argument should be either console or gui");
    }
}
