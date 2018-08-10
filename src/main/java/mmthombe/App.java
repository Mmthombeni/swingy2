package mmthombe;

import mmthombe.enums.Artifacts;
import mmthombe.factories.HeroFactory;
import mmthombe.interfaces.ICharacter;
import mmthombe.utils.FileHandler;
import mmthombe.model.*;
import mmthombe.model.Character;
import mmthombe.utils.SwingyIO;

public class App 
{
    public static void main( String[] args )
    {
        String sfg;
        sfg = FileHandler.ReadFile();
        SwingyIO.ConsoleOutput(sfg);

        Character doll = HeroFactory.newHero("agui", "knight", "1", "1", "1", "4", "weapon");
        if (doll != null){
      
        SwingyIO.ConsoleOutput(doll.toString());
        SwingyIO.ConsoleOutput(doll.getName());
              
        }
        // if(args.length == 1 ){
        //     if(args[0].equalsIgnoreCase("console")){
        //         SwingyIO.ConsoleOutput("console mode");
        //         return;
        //     }
        //     else if(args[0].equalsIgnoreCase("gui")){
        //         SwingyIO.ConsoleOutput("gui mode");
        //         return;
        //     }
        // }
        // SwingyIO.ConsoleOutput("Invaild argument, argument should be either console or gui");
    }
}
